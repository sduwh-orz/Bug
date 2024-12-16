package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugRecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BugRecordTypeRepository extends JpaRepository<BugRecordType, String>, JpaSpecificationExecutor<BugRecordType> {

}