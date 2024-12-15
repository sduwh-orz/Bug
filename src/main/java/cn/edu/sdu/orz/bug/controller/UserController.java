package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.UserDTO;
import cn.edu.sdu.orz.bug.service.UserService;
import cn.edu.sdu.orz.bug.vo.Response;
import cn.edu.sdu.orz.bug.vo.UserQueryVO;
import cn.edu.sdu.orz.bug.vo.UserUpdateVO;
import cn.edu.sdu.orz.bug.vo.UserVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String save(@RequestBody UserVO vO) {
        return userService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody UserUpdateVO vO) {
        userService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable("id") String id) {
        return userService.getById(id);
    }

    @GetMapping
    public Page<UserDTO> query(UserQueryVO vO) {
        return userService.query(vO);
    }

    @PostMapping("/login")
    public Response login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session
    ) {
        if (userService.isLoggedIn(session)) {
            return new Response(false, "已登录");
        } else {
            if (userService.login(username, password, session)) {
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
}
