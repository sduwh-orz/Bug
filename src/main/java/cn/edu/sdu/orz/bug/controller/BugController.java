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

@Validated
@RestController
@CrossOrigin
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private BugService bugService;

    @GetMapping("/{id}")
    public BugDTO getById(@PathVariable("id") String id) {
        return bugService.getById(id);
    }

    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody BugQueryVO vO) {
        return bugService.search(vO);
    }

    @PostMapping("/create")
    public Response create(@RequestBody BugCreateVO vO,
                           HttpSession session) {
        return new Response(bugService.create(vO, session));
    }

    @PostMapping("/modify")
    public Response modify(@RequestBody BugUpdateVO vO,
                           HttpSession session) {
        return new Response(bugService.modify(vO, session));
    }

    @PostMapping("/open")
    public Response open(@RequestBody BugUpdateVO vO,
                         HttpSession session) {
        return new Response(bugService.open(vO, session));
    }

    @PostMapping("/close")
    public Response close(@RequestBody BugUpdateVO vO,
                          HttpSession session) {
        return new Response(bugService.close(vO, session));
    }

    @PostMapping("/comment")
    public Response comment(@RequestBody BugUpdateVO vO,
                            HttpSession session) {
        return new Response(bugService.comment(vO, session));
    }

    @PostMapping("/solve")
    public Response solve(@RequestBody BugUpdateVO vO,
                          HttpSession session) {
        return new Response(bugService.solve(vO, session));
    }

    @GetMapping("/stats/{id}")
    public Map<String, Object> stats(@PathVariable("id") String id) {
        return bugService.stats(id);
    }

    @GetMapping("/grades")
    public List<TypeDTO> grades() {
        return bugService.getBugGrades();
    }

    @GetMapping("/record_types")
    public List<TypeDTO> recordTypes() {
        return bugService.getBugRecordTypes();
    }

    @GetMapping("/solve_types")
    public List<TypeDTO> solveTypes() {
        return bugService.getBugSolveTypes();
    }

    @GetMapping("/status")
    public List<TypeDTO> status() {
        return bugService.getBugStatus();
    }

}
