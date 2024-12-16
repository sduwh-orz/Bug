package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BugStatusRepository extends JpaRepository<BugStatus, Integer>, JpaSpecificationExecutor<BugStatus> {

}