package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.ProjectDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInBugListDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.service.ProjectService;
import cn.edu.sdu.orz.bug.vo.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    public String save(@RequestBody ProjectVO vO) {
        return projectService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        projectService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody ProjectUpdateVO vO) {
        projectService.update(id, vO);
    }

    @GetMapping("/{id}")
    public ProjectDTO getById(@PathVariable("id") String id) {
        return projectService.getById(id);
    }

    @GetMapping
    public Page<ProjectDTO> query(ProjectQueryVO vO) {
        return projectService.query(vO);
    }

    @GetMapping("/search")
    public List<ProjectDTO> search(@RequestParam(value = "name") String projectName) {
        return projectService.findByName(projectName);
    }

    @GetMapping("/task_search")
    public List<ProjectInTaskListDTO> searchProjectsInTaskList(@RequestParam(value = "name") String projectName) {
        return projectService.findProjectsWithModuleAndOwnerCount(projectName);
    }

    @GetMapping("/bug_search")
    public List<ProjectInBugListDTO> searchProjectsInBugList(@RequestParam(value = "name") String projectName) {
        return projectService.findProjectsWithBugCount(projectName);
    }

    @PostMapping("/create")
    public Response create(@RequestBody ProjectCreateVO vO, HttpSession httpSession) {
        return new Response(projectService.create(vO, httpSession));
    }

    @PostMapping("/modify/{id}")
    public Response modify(@PathVariable("id") String id,
                           @RequestBody ProjectUpdateVO vO,
                           HttpSession httpSession) {
        return new Response(projectService.modify(id, vO, httpSession));
    }

    @PostMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id, HttpSession httpSession) {
        return new Response(projectService.remove(id, httpSession));
    }
}
