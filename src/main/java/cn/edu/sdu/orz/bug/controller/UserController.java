package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.dto.TypeDTO;
import cn.edu.sdu.orz.bug.dto.UserBriefDTO;
import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.service.UserService;
import cn.edu.sdu.orz.bug.vo.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * User Controller
 */
@Validated
@RestController
@CrossOrigin
@SuppressWarnings("unused")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Gets by User id.
     *
     * @param id the id
     * @return the by id
     */
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    /**
     * Get my User info.
     *
     * @param session the session
     * @return the user dto
     */
    @GetMapping("/me")
    public UserDTO myInfo(HttpSession session) {
        return userService.myInfo(session);
    }

    /**
     * Search Users.
     *
     * @param vO      the vO
     * @param session the session
     * @return the result with pagination
     */
    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody UserQueryVO vO, HttpSession session) {
        return userService.search(vO, session);
    }

    /**
     * Create User.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/create")
    public Response create(@RequestBody UserCreateVO vO,
                           HttpSession session) {
        return new Response(userService.create(vO, session));
    }

    /**
     * Modify User.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/modify")
    public Response modify(@RequestBody UserUpdateVO vO,
                           HttpSession session
    ) {
        return new Response(userService.modify(vO, session));
    }

    /**
     * Remove User.
     *
     * @param id      the id
     * @param session the session
     * @return the response
     */
    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id,
                           HttpSession session) {
        return new Response(userService.remove(id, session));
    }

    /**
     * Login using username and password.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/login")
    public Response login(@RequestBody UserLoginVO vO,
                          HttpSession session) {
        if (userService.isLoggedIn(session)) {
            return new Response(false, "已登录");
        } else {
            if (userService.login(vO.getUsername(), vO.getPassword(), session)) {
                return new Response(true);
            }
            return new Response(false, "用户名或密码错误");
        }
    }

    /**
     * Logout User.
     *
     * @param session the session
     * @return the response
     */
    @GetMapping("/logout")
    public Response logout(HttpSession session) {
        userService.logout(session);
        return new Response(true);
    }

    /**
     * Password change.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/password")
    public Response password(@RequestBody UserPasswordVO vO,
                             HttpSession session) {
        return new Response(userService.password(vO, session));
    }

    /**
     * Get all Users.
     *
     * @return the list
     */
    @GetMapping("/all")
    public List<UserBriefDTO> all() {
        return userService.all();
    }

    /**
     * Get User Roles list.
     *
     * @return the list
     */
    @GetMapping("/roles")
    public List<TypeDTO> roles() {
        return userService.getUserRoles();
    }
}
