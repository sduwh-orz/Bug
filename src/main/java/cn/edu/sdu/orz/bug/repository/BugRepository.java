package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Bug Repository
 */
public interface BugRepository extends JpaRepository<Bug, String>, JpaSpecificationExecutor<Bug> {
    /**
     * Find Bugs by Project's ID.
     *
     * @param projectId the project id
     * @return the list
     */
    List<Bug> findByFeature_Module_Project_Id(String projectId);
}