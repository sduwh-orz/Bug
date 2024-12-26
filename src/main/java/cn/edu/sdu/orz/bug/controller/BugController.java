package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.dto.TypeDTO;
import cn.edu.sdu.orz.bug.service.BugService;
import cn.edu.sdu.orz.bug.vo.BugCreateVO;
import cn.edu.sdu.orz.bug.vo.BugQueryVO;
import cn.edu.sdu.orz.bug.vo.BugUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Bug Controller
 */
@Validated
@RestController
@CrossOrigin
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private BugService bugService;

    /**
     * Gets by Bug id.
     *
     * @param id the id
     * @return the Bug
     */
    @GetMapping("/{id}")
    public BugDTO getById(@PathVariable("id") String id) {
        return bugService.getById(id);
    }

    /**
     * Search Bugs.
     *
     * @param vO the vO
     * @return the result with pagination
     */
    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody BugQueryVO vO) {
        return bugService.search(vO);
    }

    /**
     * Create Bug.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/create")
    public Response create(@RequestBody BugCreateVO vO,
                           HttpSession session) {
        return new Response(bugService.create(vO, session));
    }

    /**
     * Modify Bug.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/modify")
    public Response modify(@RequestBody BugUpdateVO vO,
                           HttpSession session) {
        return new Response(bugService.modify(vO, session));
    }

    /**
     * Open Bug.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/open")
    public Response open(@RequestBody BugUpdateVO vO,
                         HttpSession session) {
        return new Response(bugService.open(vO, session));
    }

    /**
     * Close Bug.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/close")
    public Response close(@RequestBody BugUpdateVO vO,
                          HttpSession session) {
        return new Response(bugService.close(vO, session));
    }

    /**
     * Comment Bug.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/comment")
    public Response comment(@RequestBody BugUpdateVO vO,
                            HttpSession session) {
        return new Response(bugService.comment(vO, session));
    }

    /**
     * Solve Bug.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/solve")
    public Response solve(@RequestBody BugUpdateVO vO,
                          HttpSession session) {
        return new Response(bugService.solve(vO, session));
    }

    /**
     * Bug Stats.
     *
     * @param id the id
     * @return the result with pagination
     */
    @GetMapping("/stats/{id}")
    public Map<String, Object> stats(@PathVariable("id") String id) {
        return bugService.stats(id);
    }

    /**
     * Bug Grades list.
     *
     * @return the list
     */
    @GetMapping("/grades")
    public List<TypeDTO> grades() {
        return bugService.getBugGrades();
    }

    /**
     * Bug Record types list.
     *
     * @return the list
     */
    @GetMapping("/record_types")
    public List<TypeDTO> recordTypes() {
        return bugService.getBugRecordTypes();
    }

    /**
     * Bug Solve types list.
     *
     * @return the list
     */
    @GetMapping("/solve_types")
    public List<TypeDTO> solveTypes() {
        return bugService.getBugSolveTypes();
    }

    /**
     * Bug Status list.
     *
     * @return the list
     */
    @GetMapping("/status")
    public List<TypeDTO> status() {
        return bugService.getBugStatus();
    }

}
