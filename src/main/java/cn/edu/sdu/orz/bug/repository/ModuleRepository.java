package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Module Repository
 */
public interface ModuleRepository extends JpaRepository<Module, String>, JpaSpecificationExecutor<Module> {

}