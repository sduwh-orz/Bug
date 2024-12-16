package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.Bug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, String>, JpaSpecificationExecutor<Bug> {
    List<Bug> findByFeature_Module_Project_Id(String projectId);
}