package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugSolveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BugSolveTypeRepository extends JpaRepository<BugSolveType, Integer>, JpaSpecificationExecutor<BugSolveType> {

}