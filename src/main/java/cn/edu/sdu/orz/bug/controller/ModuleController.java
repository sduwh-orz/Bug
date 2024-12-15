package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.ModuleDTO;
import cn.edu.sdu.orz.bug.service.ModuleService;
import cn.edu.sdu.orz.bug.vo.ModuleQueryVO;
import cn.edu.sdu.orz.bug.vo.ModuleUpdateVO;
import cn.edu.sdu.orz.bug.vo.ModuleVO;
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
}
