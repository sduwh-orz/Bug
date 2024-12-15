package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.repository.UserRepository;
import cn.edu.sdu.orz.bug.repository.UserRoleRepository;
import cn.edu.sdu.orz.bug.vo.Response;
import cn.edu.sdu.orz.bug.vo.UserQueryVO;
import cn.edu.sdu.orz.bug.vo.UserUpdateVO;
import cn.edu.sdu.orz.bug.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public String save(UserVO vO) {
        User bean = new User();
        BeanUtils.copyProperties(vO, bean);
        bean = userRepository.save(bean);
        return bean.getId();
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public void update(String id, UserUpdateVO vO) {
        User bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        userRepository.save(bean);
    }

    public UserDTO getById(String id) {
        User original = requireOne(id);
        return toDTO(original);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User getLoggedInUser(HttpSession session) {
        if (isLoggedIn(session)) {
            String id = session.getAttribute("id").toString();
            return requireOne(id);
        }
        return null;
    }

    public boolean isLoggedIn(HttpSession session) {
        if (session.getAttribute("id") == null)
            return false;
        String id = session.getAttribute("id").toString();
        if (session.getAttribute("password") == null)
            return false;

        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            return false;
        String password = session.getAttribute("password").toString();
        String afterMD5 = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        if (!user.getPassword().equals(afterMD5)) {
            session.removeAttribute("id");
            session.removeAttribute("password");
            return false;
        }
        return true;
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

    public boolean isAdmin(String id) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null)
            return false;

        return userRoleRepository.getReferenceById(user.getRole()).getName().equals("管理员");
    }

    public Page<UserDTO> query(UserQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UserDTO toDTO(User original) {
        UserDTO bean = new UserDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private User requireOne(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
