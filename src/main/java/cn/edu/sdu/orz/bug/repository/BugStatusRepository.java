package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Bug status Repository
 */
@SuppressWarnings("unused")
public interface BugStatusRepository extends JpaRepository<BugStatus, Integer>, JpaSpecificationExecutor<BugStatus> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<BugStatus> findByName(String name);
}