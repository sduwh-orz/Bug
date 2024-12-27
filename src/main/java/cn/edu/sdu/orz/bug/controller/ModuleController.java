package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.service.ModuleService;
import cn.edu.sdu.orz.bug.vo.ModuleCreateVO;
import cn.edu.sdu.orz.bug.vo.ModuleUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Module Controller
 */
@Validated
@RestController
@CrossOrigin
@SuppressWarnings("unused")
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    /**
     * Create Module.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/create")
    public Response create(@RequestBody ModuleCreateVO vO, HttpSession session) {
        return new Response(moduleService.create(vO, session));
    }

    /**
     * Modify Module.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/modify")
    public Response modify(@RequestBody ModuleUpdateVO vO, HttpSession session) {
        return new Response(moduleService.modify(vO, session));
    }

    /**
     * Remove Module.
     *
     * @param id      the id
     * @param session the session
     * @return the response
     */
    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable(name = "id") String id, HttpSession session) {
        return new Response(moduleService.remove(id, session));
    }
}
