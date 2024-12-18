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

    @GetMapping("/me")
    public UserDTO myInfo(HttpSession session) {
        return userService.myInfo(session);
    }

    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody UserQueryVO vO, HttpSession session) {
        return userService.search(vO, session);
    }

    @PostMapping("/create")
    public Response create(@RequestBody UserCreateVO vO,
                           HttpSession session) {
        return new Response(userService.create(vO, session));
    }

    @PostMapping("/modify")
    public Response modify(@RequestBody UserUpdateVO vO,
                           HttpSession session
    ) {
        return new Response(userService.modify(vO, session));
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

    @GetMapping("/all")
    public List<UserBriefDTO> all() {
        return userService.all();
    }

    @GetMapping("/roles")
    public List<TypeDTO> roles() {
        return userService.getUserRoles();
    }
}
