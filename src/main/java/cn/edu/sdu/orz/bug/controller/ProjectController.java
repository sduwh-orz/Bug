package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.*;
import cn.edu.sdu.orz.bug.service.ProjectService;
import cn.edu.sdu.orz.bug.vo.ProjectCreateVO;
import cn.edu.sdu.orz.bug.vo.ProjectQueryVO;
import cn.edu.sdu.orz.bug.vo.ProjectUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public ProjectDTO getProjectDetails(@PathVariable("id") String id) {
        return projectService.getProjectDetails(id);
    }

    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody ProjectQueryVO vO) {
        return projectService.search(vO);
    }

    @PostMapping("/task_search")
    public Map<String, Object> searchProjectsInTaskList(@RequestBody ProjectQueryVO vO) {
        return projectService.findProjectsWithModuleAndOwnerCount(vO);
    }

    @PostMapping("/bug_search")
    public Map<String, Object> searchProjectsInBugList(@RequestBody ProjectQueryVO vO) {
        return projectService.findProjectsWithBugCount(vO);
    }

    @PostMapping("/create")
    public Response create(@RequestBody ProjectCreateVO vO, HttpSession httpSession) {
        return new Response(projectService.create(vO, httpSession));
    }

    @PostMapping("/modify")
    public Response modify(@RequestBody ProjectUpdateVO vO,
                           HttpSession httpSession) {
        return new Response(projectService.modify(vO, httpSession));
    }

    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id, HttpSession httpSession) {
        return new Response(projectService.remove(id, httpSession));
    }
}
