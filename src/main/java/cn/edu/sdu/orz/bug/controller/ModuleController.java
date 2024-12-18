package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.service.ModuleService;
import cn.edu.sdu.orz.bug.vo.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping("/create")
    public Response create(@RequestBody ModuleCreateVO vO, HttpSession session) {
        return new Response(moduleService.create(vO, session));
    }

    @PostMapping("/modify")
    public Response modify(@RequestBody ModuleUpdateVO vO, HttpSession session) {
        return new Response(moduleService.modify(vO, session));
    }

    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable(name = "id") String id, HttpSession session) {
        return new Response(moduleService.remove(id, session));
    }
}
