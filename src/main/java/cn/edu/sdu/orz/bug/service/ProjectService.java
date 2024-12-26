package cn.edu.sdu.orz.bug.service;

import cn.edu.sdu.orz.bug.dto.ProjectDTO;
import cn.edu.sdu.orz.bug.entity.Project;
import cn.edu.sdu.orz.bug.entity.User;
import cn.edu.sdu.orz.bug.repository.ProjectRepository;
import cn.edu.sdu.orz.bug.utils.Utils;
import cn.edu.sdu.orz.bug.vo.ProjectCreateVO;
import cn.edu.sdu.orz.bug.vo.ProjectQueryVO;
import cn.edu.sdu.orz.bug.vo.ProjectUpdateVO;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

/**
 * Project Service
 */
@Service
@SuppressWarnings("unused")
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    /**
     * Search Project.
     *
     * @param vO      the vO
     * @param session the session
     * @return the result with pagination
     */
    public Map<String, Object> search(ProjectQueryVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return null;

        Project example = new Project();
        example.setName(vO.getName());
        if (!user.isAdmin())
            example.setOwner(user);
        return Utils.pagination(
                vO.getPage(),
                vO.getSize(),
                pageable -> projectRepository.findAll(
                        Example.of(example, ExampleMatcher.matching().withMatcher("name", contains())),
                        PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                                Sort.by(Sort.Direction.DESC, "created"))
                ),
                ProjectDTO::toDTO
        );
    }

    /**
     * Get Tasks list.
     *
     * @param vO      the vO
     * @param session the session
     * @return the result with pagination
     */
    public Map<String, Object> taskList(ProjectQueryVO vO, HttpSession session) {
        User user = userService.getLoggedInUser(session);
        if (user == null)
            return null;
        if (user.isAdmin())
            return Utils.pagination(
                    vO.getPage(),
                    vO.getSize(),
                    pageable -> projectRepository.taskListAdmin(vO.getName(), pageable),
                    (v) -> v
            );
        return Utils.pagination(
                vO.getPage(),
                vO.getSize(),
                pageable -> projectRepository.taskList(vO.getName(), user.getId(), pageable),
                (v) -> v
        );
    }

    /**
     * Find projects with bug count.
     *
     * @param vO the vO
     * @return the result with pagination
     */
    public Map<String, Object> findProjectsWithBugCount(ProjectQueryVO vO) {
        return Utils.pagination(
                vO.getPage(),
                vO.getSize(),
                pageable -> projectRepository.findProjectsWithBugCount(vO.getName(), pageable),
                (v) -> v
        );
    }

    /**
     * Create Project.
     *
     * @param projectCreateVO the project create vo
     * @param httpSession     the http session
     * @return the boolean
     */
    public boolean create(ProjectCreateVO projectCreateVO, HttpSession httpSession) {
        User user = userService.getLoggedInUser(httpSession);
        if (user == null || !user.isAdmin()) {
            return false;
        }
        try {
            Project bean = new Project();
            BeanUtils.copyProperties(projectCreateVO, bean, Utils.getNullPropertyNames(projectCreateVO));
            bean.setId(newID());
            bean.setOwner(userService.requireOne(projectCreateVO.getOwner()));
            bean.setCreated(new Timestamp(new java.util.Date(System.currentTimeMillis()).getTime()));
            projectRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Modify Project.
     *
     * @param vO          the vO
     * @param httpSession the http session
     * @return the boolean
     */
    public boolean modify(ProjectUpdateVO vO, HttpSession httpSession) {
        User user = userService.getLoggedInUser(httpSession);
        if (user == null) {
            return false;
        }
        try {
            Project bean = requireOne(vO.getId());
            if (bean.hasNoPerm(user))
                return false;
            BeanUtils.copyProperties(vO, bean, Utils.getNullPropertyNames(vO));
            bean.setOwner(userService.requireOne(vO.getOwner()));
            projectRepository.save(bean);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Remove Project.
     *
     * @param id          the id
     * @param httpSession the http session
     * @return the boolean
     */
    public boolean remove(String id, HttpSession httpSession) {
        User user = userService.getLoggedInUser(httpSession);
        if (user == null || !user.isAdmin()) {
            return false;
        }
        try {
            projectRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Gets project details.
     *
     * @param projectId   the project id
     * @param httpSession the http session
     * @return the project details
     */
    public ProjectDTO getProjectDetails(String projectId, HttpSession httpSession) {
        User user = userService.getLoggedInUser(httpSession);
        if (user == null) {
            return null;
        }
        Project original = projectRepository.findById(projectId).orElse(null);
        if (original == null)
            return null;
        return ProjectDTO.toDTO(original);
    }

    /**
     * Require one Project.
     *
     * @param id the id
     * @return the project
     */
    public Project requireOne(String id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private String newID() {
        while (true) {
            String id = Utils.newRandomID();
            if (!projectRepository.existsById(id)) {
                return id;
            }
        }
    }
}
