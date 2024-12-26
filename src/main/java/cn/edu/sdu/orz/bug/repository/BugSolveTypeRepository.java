package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugSolveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Bug solve type Repository
 */
@SuppressWarnings("unused")
public interface BugSolveTypeRepository extends JpaRepository<BugSolveType, Integer>, JpaSpecificationExecutor<BugSolveType> {
    /**
     * Find by name optional.
     *
     * @param name the name
     * @return the optional
     */
    Optional<BugSolveType> findByName(String name);
}