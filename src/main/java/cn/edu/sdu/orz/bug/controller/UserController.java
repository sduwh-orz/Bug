package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.service.UserService;
import cn.edu.sdu.orz.bug.vo.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody UserQueryVO vO) {
        return userService.search(vO);
    }

    @PostMapping("/create")
    public Response create(@RequestBody UserCreateVO vO,
                           HttpSession session) {
        return new Response(userService.create(vO, session));
    }

    @PostMapping("/modify/{id}")
    public Response modify(@PathVariable("id") String id,
                           @RequestBody UserUpdateVO vO,
                           HttpSession session
    ) {
        return new Response(userService.modify(id, vO, session));
    }

    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id,
                           HttpSession session) {
        return new Response(userService.remove(id, session));
    }

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

    @GetMapping("/logout")
    public Response logout(HttpSession session) {
        userService.logout(session);
        return new Response(true);
    }

    @PostMapping("/password")
    public Response password(@RequestBody UserPasswordVO vO,
                             HttpSession session) {
        return new Response(userService.password(vO, session));
    }
}
