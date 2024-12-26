package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.ProjectDTO;
import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.service.ProjectService;
import cn.edu.sdu.orz.bug.vo.ProjectCreateVO;
import cn.edu.sdu.orz.bug.vo.ProjectQueryVO;
import cn.edu.sdu.orz.bug.vo.ProjectUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public ProjectDTO getProjectDetails(@PathVariable("id") String id,
                                        HttpSession session) {
        return projectService.getProjectDetails(id, session);
    }

    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody ProjectQueryVO vO,
                                      HttpSession session) {
        return projectService.search(vO, session);
    }

    @PostMapping("/task_search")
    public Map<String, Object> searchProjectsInTaskList(@RequestBody ProjectQueryVO vO, HttpSession session) {
        return projectService.taskList(vO, session);
    }

    @PostMapping("/bug_search")
    public Map<String, Object> searchProjectsInBugList(@RequestBody ProjectQueryVO vO) {
        return projectService.findProjectsWithBugCount(vO);
    }

    @PostMapping("/create")
    public Response create(@RequestBody ProjectCreateVO vO, HttpSession session) {
        return new Response(projectService.create(vO, session));
    }

    @PostMapping("/modify")
    public Response modify(@RequestBody ProjectUpdateVO vO,
                           HttpSession session) {
        return new Response(projectService.modify(vO, session));
    }

    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id, HttpSession session) {
        return new Response(projectService.remove(id, session));
    }
}
