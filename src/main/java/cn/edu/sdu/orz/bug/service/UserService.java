package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.TypeDTO;
import cn.edu.sdu.orz.bug.dto.UserBriefDTO;
import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.entity.UserRole;
import cn.edu.sdu.orz.bug.repository.ProjectRepository;
import cn.edu.sdu.orz.bug.repository.UserRepository;
import cn.edu.sdu.orz.bug.repository.UserRoleRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.UserCreateVO;
import cn.edu.sdu.orz.bug.vo.UserPasswordVO;
import cn.edu.sdu.orz.bug.vo.UserQueryVO;
import cn.edu.sdu.orz.bug.vo.UserUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

/**
 * User Service
 */
@Service
@SuppressWarnings("unused")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    /**
     * Search Users.
     *
     * @param vO      the vO
     * @param session the session
     * @return the result with pagination
     */
    public Map<String, Object> search(UserQueryVO vO, HttpSession session) {
        if (isLoggedInUserNotAdmin(session))
            return null;
        User example = new User();
        BeanUtils.copyProperties(vO, example);
        if (vO.getRole() != null) {
            UserRole role = new UserRole();
            role.setId(vO.getRole());
            example.setRole(role);
        }
        example.setDeleted(0);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("role.id", exact())
                .withMatcher("username", contains().ignoreCase())
                .withMatcher("realName", contains().ignoreCase())
                .withMatcher("email", contains().ignoreCase());

        return Utils.pagination(
                vO.getPage(),
                vO.getSize(),
                pageable -> userRepository.findAll(Example.of(example, matcher), pageable),
                UserService::toDTO
        );
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public UserDTO getById(String id) {
        User original = userRepository.findById(id).orElse(null);
        return toDTO(original);
    }

    /**
     * All Users list.
     *
     * @return the list
     */
    public List<UserBriefDTO> all() {
        return userRepository.findAllByDeletedFalse().stream().map(UserBriefDTO::toDTO).collect(Collectors.toList());
    }

    /**
     * Create User.
     *
     * @param vO      the vO
     * @param session the session
     * @return the pair
     */
    public Pair<Boolean, String> create(UserCreateVO vO, HttpSession session) {
        if (isLoggedInUserNotAdmin(session))
            return Pair.of(false, "未登录");
        try {
            if (userRepository.findByUsername(vO.getUsername()).isPresent())
                return Pair.of(false, "用户名已存在");
            User bean = new User();
            BeanUtils.copyProperties(vO, bean);
            bean.setId(newID());
            bean.setDeleted(0);
            bean.setPassword(DigestUtils.md5DigestAsHex(vO.getPassword().getBytes(StandardCharsets.UTF_8)));
            bean.setRole(userRoleRepository.findById(vO.getRole()).orElseThrow());
            userRepository.save(bean);
        } catch (Exception e) {
            return Pair.of(false, "创建用户失败");
        }
        return Pair.of(true, "");
    }

    /**
     * Modify User.
     *
     * @param vO      the vO
     * @param session the session
     * @return the boolean
     */
    public boolean modify(UserUpdateVO vO, HttpSession session) {
        if (isLoggedInUserNotAdmin(session))
            return false;
        try {
            User bean = requireOne(vO.getId());
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            bean.setRole(userRoleRepository.findById(vO.getRole()).orElseThrow());
            userRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Change User's password.
     *
     * @param vO      the vO
     * @param session the session
     * @return the pair
     */
    public Pair<Boolean, String> password(UserPasswordVO vO, HttpSession session) {
        User user = getLoggedInUser(session);
        if (user == null)
            return Pair.of(false, "未登录");
        if (vO.getPrevious() == null || vO.getPassword() == null)
            return Pair.of(false, "缺少参数");
        try {
            String hashedPrevious = DigestUtils.md5DigestAsHex(vO.getPrevious().getBytes(StandardCharsets.UTF_8));
            if (!hashedPrevious.equals(user.getPassword()))
                return Pair.of(false, "原密码不正确");
            String hashedNow = DigestUtils.md5DigestAsHex(vO.getPassword().getBytes(StandardCharsets.UTF_8));
            user.setPassword(hashedNow);
            userRepository.save(user);
        } catch (Exception e) {
            return Pair.of(false, "修改失败");
        }
        return Pair.of(true, "");
    }

    /**
     * Remove User.
     *
     * @param id      the id
     * @param session the session
     * @return the boolean
     */
    public boolean remove(String id, HttpSession session) {
        if (isLoggedInUserNotAdmin(session))
            return false;
        try {
            User bean = requireOne(id);
            bean.setDeleted(1);
            userRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * My User info.
     *
     * @param session the session
     * @return the user dto
     */
    public UserDTO myInfo(HttpSession session) {
        User user = getLoggedInUser(session);
        if (user == null)
            return null;
        UserDTO bean = toDTO(user);
        bean.setLeader(projectRepository.countProjectByOwner_Id(user.getId()) > 0);
        return bean;
    }

    /**
     * Get User by username.
     *
     * @param username the username
     * @return the by username
     */
    public User getByUsername(String username) {
        return userRepository.findByUsernameAndDeletedFalse(username);
    }

    /**
     * Get logged-in user.
     *
     * @param session the session
     * @return the logged-in user
     */
    public User getLoggedInUser(HttpSession session) {
        if (session.getAttribute("id") == null)
            return null;
        String id = session.getAttribute("id").toString();
        if (session.getAttribute("password") == null)
            return null;

        User user = userRepository.findByIdAndDeletedFalse(id).orElse(null);
        if (user == null)
            return null;
        String password = session.getAttribute("password").toString();
        if (!user.getPassword().equals(password)) {
            session.removeAttribute("id");
            session.removeAttribute("password");
            return null;
        }
        return user;
    }

    /**
     * Is User logged in.
     *
     * @param session the session
     * @return the boolean
     */
    public boolean isLoggedIn(HttpSession session) {
        return getLoggedInUser(session) != null;
    }

    /**
     * Is logged-in User admin.
     *
     * @param session the session
     * @return the boolean
     */
    public boolean isLoggedInUserAdmin(HttpSession session) {
        User user = getLoggedInUser(session);
        if (user == null)
            return false;
        return user.getRole().getName().equals("管理员");
    }

    /**
     * Is logged-in user not admin.
     *
     * @param session the session
     * @return the boolean
     */
    public boolean isLoggedInUserNotAdmin(HttpSession session) {
        return !isLoggedInUserAdmin(session);
    }

    /**
     * User Login.
     *
     * @param username the username
     * @param password the password
     * @param session  the session
     * @return the boolean
     */
    public boolean login(String username, String password, HttpSession session) {
        User user = getByUsername(username);
        if (user == null) {
            return false;
        } else {
            String afterMD5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            if (!user.getPassword().equals(afterMD5)) {
                return false;
            } else {
                session.setAttribute("id", user.getId());
                session.setAttribute("password", user.getPassword());
                return true;
            }
        }
    }

    /**
     * User Logout.
     *
     * @param session the session
     */
    public void logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("password");
    }

    /**
     * Get User roles.
     *
     * @return the user roles
     */
    public List<TypeDTO> getUserRoles() {
        return userRoleRepository.findAll().stream().map(TypeDTO::toDTO).collect(Collectors.toList());
    }

    private String newID() {
        while (true) {
            String id = Utils.newRandomID();
            if (!userRepository.existsById(id)) {
                return id;
            }
        }
    }

    private static UserDTO toDTO(User original) {
        if (original == null)
            return null;
        return UserDTO.toDTO(original);
    }

    /**
     * Require one User.
     *
     * @param id the id
     * @return the user
     */
    public User requireOne(String id) {
        return userRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
