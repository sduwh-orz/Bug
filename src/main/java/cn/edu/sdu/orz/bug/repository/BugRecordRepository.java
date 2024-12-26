package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Bug record Repository
 */
public interface BugRecordRepository extends JpaRepository<BugRecord, String>, JpaSpecificationExecutor<BugRecord> {

}