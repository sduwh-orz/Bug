package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.dto.ProjectInBugListDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO;
import cn.edu.sdu.orz.bug.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Project Repository
 */
@SuppressWarnings("unused")
public interface ProjectRepository extends JpaRepository<Project, String>, JpaSpecificationExecutor<Project> {
    /**
     * Count project by owner's ID.
     *
     * @param owner the owner
     * @return the integer
     */
    Integer countProjectByOwner_Id(String owner);

    /**
     * Get Tasks list if User is admin.
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the page
     */
    @Query("select new cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO ( " +
            "p.id, p.name, uu.realName, count(distinct f.id), count(distinct u.id) " +
            ") from Project p " +
            "left join Module m on p.id = m.project.id " +
            "left join Feature f on m.id = f.module.id " +
            "left join User u on u.id = f.owner.id " +
            "left join User uu on uu.id = p.owner.id " +
            "where p.name like %:name% " +
            "group by p.id, p.name, uu.realName " +
            "order by p.created DESC")
    Page<ProjectInTaskListDTO> taskListAdmin(@Param("name") String name, Pageable pageable);

    /**
     * Get Tasks list.
     *
     * @param name     the name
     * @param user     the user
     * @param pageable the pageable
     * @return the page
     */
    @Query("select new cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO ( " +
            "p.id, p.name, uu.realName, count(distinct f.id), count(distinct u.id) " +
            ") from Project p " +
            "left join Module m on p.id = m.project.id " +
            "left join Feature f on m.id = f.module.id " +
            "left join User u on u.id = f.owner.id " +
            "left join User uu on uu.id = p.owner.id " +
            "where p.name like %:name% and p.owner.id = :owner " +
            "group by p.id, p.name, uu.realName " +
            "order by p.created DESC")
    Page<ProjectInTaskListDTO> taskList(@Param("name") String name, @Param("owner") String user, Pageable pageable);

    /**
     * Find projects with bug count page.
     *
     * @param name     the name
     * @param pageable the pageable
     * @return the page
     */
    @Query("select new cn.edu.sdu.orz.bug.dto.ProjectInBugListDTO ( " +
            "p.id, p.name, u.realName, count(distinct b.id) " +
            ") " +
            "from Project p " +
            "left join Module m on p.id = m.project.id " +
            "left join Feature f on m.id = f.module.id " +
            "left join Bug b on f.id = b.feature.id " +
            "left join User u on u.id = p.owner.id " +
            "where p.name like %:name% " +
            "group by p.id, p.name, u.realName " +
            "order by p.created DESC")
    Page<ProjectInBugListDTO> findProjectsWithBugCount(@Param("name") String name, Pageable pageable);

}