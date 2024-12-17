package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.ModuleDTO;
import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.service.ModuleService;
import cn.edu.sdu.orz.bug.vo.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/module")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @PostMapping
    public String save(@RequestBody ModuleVO vO) {
        return moduleService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        moduleService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody ModuleUpdateVO vO) {
        moduleService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ModuleDTO getById(@PathVariable("id") String id) {
        return moduleService.getById(id);
    }

    @GetMapping
    public Page<ModuleDTO> query(ModuleQueryVO vO) {
        return moduleService.query(vO);
    }

    @PostMapping("/create")
    public Response create(@RequestBody ModuleCreateVO vO, HttpSession session) {
        return new Response(moduleService.create(vO, session));
    }

    @PostMapping("/modify/{id}")
    public Response modify(@PathVariable(name = "id") String id,
                           @RequestBody ModuleUpdateVO vO, HttpSession session) {
        return new Response(moduleService.modify(id, vO, session));
    }

    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable(name = "id") String id, HttpSession session) {
        return new Response(moduleService.remove(id, session));
    }
}
