package cn.edu.sdu.orz.bug.controller;

import cn.edu.sdu.orz.bug.dto.Response;
import cn.edu.sdu.orz.bug.service.FeatureService;
import cn.edu.sdu.orz.bug.vo.FeatureCreateVO;
import cn.edu.sdu.orz.bug.vo.FeatureUpdateVO;
import cn.edu.sdu.orz.bug.vo.TaskAssignVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Feature Controller
 */
@Validated
@RestController
@CrossOrigin
@RequestMapping("/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    /**
     * Create Feature.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/create")
    public Response create(@RequestBody FeatureCreateVO vO,
                           HttpSession session) {
        return new Response(featureService.create(vO, session));
    }

    /**
     * Remove Feature.
     *
     * @param id      the id
     * @param session the session
     * @return the response
     */
    @GetMapping("/remove/{id}")
    public Response remove(@PathVariable("id") String id,
                           HttpSession session) {
        return new Response(featureService.remove(id, session));
    }

    /**
     * Modify Feature.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/modify")
    public Response modify(@RequestBody FeatureUpdateVO vO,
                           HttpSession session) {
        return new Response(featureService.modify(vO, session));
    }

    /**
     * Assign Feature.
     *
     * @param vO      the vO
     * @param session the session
     * @return the response
     */
    @PostMapping("/assign")
    public Response assign(@RequestBody TaskAssignVO vO,
                           HttpSession session) {
        return new Response(featureService.assign(vO, session));
    }
}
