package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    Optional<User> findByIdAndDeletedFalse(String id);
    Optional<User> findByIdAndDeletedFalseAndRoleName(String id, String role);
    User findByUsernameAndDeletedFalse(String username);
    Page<User> findByUsernameContainingIgnoreCaseAndRealNameContainingIgnoreCaseAndRoleNameContainingAndEmailContainingIgnoreCaseAndDeletedFalse(
            String username, String realName, String role, String email, Pageable pageable
    );
}