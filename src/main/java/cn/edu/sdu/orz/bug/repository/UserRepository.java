package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    Optional<User> findByIdAndDeletedFalse(String id);
    Optional<User> findByIdAndDeletedFalseAndRoleName(String id, String role);
    User findByUsernameAndDeletedFalse(String username);
}