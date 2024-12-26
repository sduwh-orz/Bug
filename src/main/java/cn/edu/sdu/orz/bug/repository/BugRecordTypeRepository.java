package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugRecordType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Bug record type Repository
 */
@SuppressWarnings("unused")
public interface BugRecordTypeRepository extends JpaRepository<BugRecordType, String>, JpaSpecificationExecutor<BugRecordType> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<BugRecordType> findByName(String name);
}