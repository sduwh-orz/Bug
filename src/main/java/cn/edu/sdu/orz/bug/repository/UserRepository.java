package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    Optional<User> findByUsername(String id);

    Optional<User> findByIdAndDeletedFalse(String id);

    User findByUsernameAndDeletedFalse(String username);

    List<User> findAllyByDeletedFalse();
}