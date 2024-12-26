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

/**
 * Project Controller
 */
@Validated
@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    /**
     * Gets project details.
     *
     * @param id      the id
     * @param session the session
     * @return the project details
     */
    @GetMapping("/{id}")
    public ProjectDTO getProjectDetails(@PathVariable("id") String id,
                                        HttpSession session) {
        return projectService.getProjectDetails(id, session);
    }

    /**
     * Search Projects.
     *
     * @param vO      the vO
     * @param session the session
     * @return the result with pagination
     */
    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody ProjectQueryVO vO,
                                      HttpSession session) {
        return projectService.search(vO, session);
    }

    /**
     * Search Projects in Task List.
     *
     * @param vO      the vO
     * @param session the session
     * @return the result with pagination
     */
    @PostMapping("/task_search")
    public Map<String, Object> searchProjectsInTaskList(@RequestBody ProjectQueryVO vO, HttpSession session) {
        return projectService.taskList(vO, session);
    }

    /**
     * Search Projects in Bug List.
     *
     * @param vO the vO
     * @return the result with pagination
     */
    @PostMapping("/bug_search")
    public Map<String, Object> searchProjectsInBugList(@RequestBody ProjectQueryVO vO) {
        return projectService.findProjectsWithBugCount(vO);
    }

    /**
     * Create Project.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/create")
    public Response create(@RequestBody ProjectCreateVO vO, HttpSession session) {
        return new Response(projectService.create(vO, session));
    }

    /**
     * Modify Project.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/modify")
    public Response modify(@RequestBody ProjectUpdateVO vO,
                           HttpSession session) {
        return new Response(projectService.modify(vO, session));
    }

    /**
     * Remove Project.
     *
     * @param id      the id
     * @param session the session
     * @return the response
     */
    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id, HttpSession session) {
        return new Response(projectService.remove(id, session));
    }
}
