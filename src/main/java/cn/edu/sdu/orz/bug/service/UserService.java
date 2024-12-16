package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.repository.UserRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.UserUpdateVO;
import cn.edu.sdu.orz.bug.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> search(
            String username,
            String realName,
            String role,
            String email,
            Integer queryPage,
            Integer querySize
    ) {
        return Utils.pagination(
                queryPage,
                querySize,
                pageable -> userRepository.findByUsernameContainingIgnoreCaseAndRealNameContainingIgnoreCaseAndRoleNameContainingAndEmailContainingIgnoreCaseAndDeletedFalse(
                        username != null ? username : "",
                        realName != null ? realName : "",
                        role != null ? role : "",
                        email != null ? email : "",
                        pageable
                ),
                UserService::toDTO
        );
    }

    public UserDTO getById(String id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    public boolean create(UserVO vO, HttpSession session) {
        if (!isLoggedIn(session))
            return false;
        try {
            User bean = new User();
            BeanUtils.copyProperties(vO, bean);
            userRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean modify(String id, UserUpdateVO vO, HttpSession session) {
        if (!isLoggedIn(session))
            return false;
        try {
            User bean = requireOne(id);
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            userRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean remove(String id, HttpSession session) {
        if (!isLoggedIn(session))
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

    public User getByUsername(String username) {
        return userRepository.findByUsernameAndDeletedFalse(username);
    }

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
        String afterMD5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equals(afterMD5)) {
            session.removeAttribute("id");
            session.removeAttribute("password");
            return null;
        }
        return user;
    }

    public boolean isLoggedIn(HttpSession session) {
        return getLoggedInUser(session) != null;
    }

    public boolean isLoggedInUserAdmin(HttpSession session) {
        User user = getLoggedInUser(session);
        if (user == null)
            return false;
        return user.getRole().equals("管理员");
    }

    public boolean isAdmin(String id) {
        return userRepository.findByIdAndDeletedFalseAndRoleName(id, "管理员").orElse(null) != null;
    }

    public boolean login(String username, String password, HttpSession session) {
        User user = getByUsername(username);
        if (user == null) {
            return false;
        } else {
            String afterMD5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
            if (!user.getPassword().equals(afterMD5)) {
                return false;
            } else {
                session.setAttribute("user", user.getId());
                session.setAttribute("password", user.getPassword());
                return true;
            }
        }
    }

    public void logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("password");
    }

    private static UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(String id) {
        return userRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
