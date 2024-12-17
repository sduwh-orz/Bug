package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.dto.ProjectBriefDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInBugListDTO;
import cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO;
import cn.edu.sdu.orz.bug.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, String>, JpaSpecificationExecutor<Project> {

    @Query(value = "select p from Project p where p.name like %:name%")
    List<Project> findByName(String name);

    @Query("""
        select new cn.edu.sdu.orz.bug.dto.ProjectInTaskListDTO (
            p.id, p.name, uu.realName, count(distinct m.id), count(distinct u.id)
        ) from Project p
        left join Module m on p.id = m.project.id
        left join Feature f on m.id = f.module.id
        left join User u on u.id = f.owner.id
        left join User uu on uu.id = p.owner
        where p.name like %:name%
        group by p.id, p.name, uu.realName
    """)
    List<ProjectInTaskListDTO> findProjectsWithModuleAndOwnerCount(@Param("name") String name);

    @Query("""
        select new cn.edu.sdu.orz.bug.dto.ProjectInBugListDTO (
            p.id, p.name, u.realName, count(distinct b.id)
        )
        from Project p
        left join Module m on p.id = m.project.id
        left join Feature f on m.id = f.module.id
        left join Bug b on f.id = b.feature.id
        left join User u on u.id = p.owner
        where p.name like %:name%
        group by p.id, p.name, u.realName
    """)
    List<ProjectInBugListDTO> findProjectsWithBugCount(@Param("name") String name);

    @Query("""
        select p.id, p.name, m.id, m.name, f.id, f.name, f.hours
        from Project p
        left join Module m on m.project.id = p.id
        left join Feature f on f.module.id = m.id
        where p.id = :id
        group by p.id, p.name, m.id, m.name, f.id, f.name, f.hours
    """)
    List<Object[]> getProjectDetails(@Param("id") String id);


}