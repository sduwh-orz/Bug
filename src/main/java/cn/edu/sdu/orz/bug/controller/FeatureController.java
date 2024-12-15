package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.FeatureDTO;
import cn.edu.sdu.orz.bug.service.FeatureService;
import cn.edu.sdu.orz.bug.vo.FeatureQueryVO;
import cn.edu.sdu.orz.bug.vo.FeatureUpdateVO;
import cn.edu.sdu.orz.bug.vo.FeatureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    @PostMapping
    public String save(@RequestBody FeatureVO vO) {
        return featureService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        featureService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") String id,
                       @RequestBody FeatureUpdateVO vO) {
        featureService.update(id, vO);
    }

    @GetMapping("/{id}")
    public FeatureDTO getById(@PathVariable("id") String id) {
        return featureService.getById(id);
    }

    @GetMapping
    public Page<FeatureDTO> query(FeatureQueryVO vO) {
        return featureService.query(vO);
    }
}
