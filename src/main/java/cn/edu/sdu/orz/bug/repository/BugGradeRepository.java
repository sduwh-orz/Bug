package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.BugGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Bug grade Repository
 */
@SuppressWarnings("unused")
public interface BugGradeRepository extends JpaRepository<BugGrade, Integer>, JpaSpecificationExecutor<BugGrade> {

}