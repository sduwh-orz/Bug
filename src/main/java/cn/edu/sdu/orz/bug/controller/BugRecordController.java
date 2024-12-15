package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.BugRecordDTO;
import cn.edu.sdu.orz.bug.service.BugRecordService;
import cn.edu.sdu.orz.bug.vo.BugRecordQueryVO;
import cn.edu.sdu.orz.bug.vo.BugRecordUpdateVO;
import cn.edu.sdu.orz.bug.vo.BugRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/bugRecord")
public class BugRecordController {

    @Autowired
    private BugRecordService bugRecordService;

    @PostMapping
    public String save(@RequestBody BugRecordVO vO) {
        return bugRecordService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        bugRecordService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody BugRecordUpdateVO vO) {
        bugRecordService.update(id, vO);
    }

    @GetMapping("/{id}")
    public BugRecordDTO getById(@PathVariable("id") String id) {
        return bugRecordService.getById(id);
    }

    @GetMapping
    public Page<BugRecordDTO> query(BugRecordQueryVO vO) {
        return bugRecordService.query(vO);
    }
}
