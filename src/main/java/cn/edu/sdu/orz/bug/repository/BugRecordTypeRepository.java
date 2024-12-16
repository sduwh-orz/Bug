package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugRecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BugRecordTypeRepository extends JpaRepository<BugRecordType, String>, JpaSpecificationExecutor<BugRecordType> {
    Optional<BugRecordType> findByName(String name);
}