package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.BugDTO;
import cn.edu.sdu.orz.bug.entity.Bug;
import cn.edu.sdu.orz.bug.service.BugService;
import cn.edu.sdu.orz.bug.vo.BugQueryVO;
import cn.edu.sdu.orz.bug.vo.BugUpdateVO;
import cn.edu.sdu.orz.bug.vo.BugVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
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

    @PostMapping
    public String save(@RequestBody BugVO vO) {
        return bugService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        bugService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody BugUpdateVO vO) {
        bugService.update(id, vO);
    }

    @GetMapping("/{id}")
    public BugDTO getById(@PathVariable("id") String id) {
        return bugService.getById(id);
    }

    @PostMapping("/search")
    public Map<String, Object> search(@RequestBody BugQueryVO vO) {
        return bugService.search(vO);
    }
}
