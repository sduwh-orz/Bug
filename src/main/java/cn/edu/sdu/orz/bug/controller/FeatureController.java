package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.FeatureDTO;
import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.service.FeatureService;
import cn.edu.sdu.orz.bug.vo.FeatureQueryVO;
import cn.edu.sdu.orz.bug.vo.FeatureUpdateVO;
import cn.edu.sdu.orz.bug.vo.FeatureVO;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/create")
    public Response create(@RequestBody FeatureVO vO,
                         HttpSession session) {
        return new Response(featureService.create(vO,session));
    }

    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id,
                          HttpSession session) {
        return new Response(featureService.remove(id, session));
    }

    @PostMapping("/modify")
    public Response modify(@RequestBody FeatureUpdateVO vO,
                          HttpSession session) {
        return new Response(featureService.modify(vO, session));
    }
}
