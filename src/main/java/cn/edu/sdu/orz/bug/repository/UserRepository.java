package cn.edu.sdu.orz.bug.repository;

import cn.edu.sdu.orz.bug.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * User Repository
 */
@SuppressWarnings("unused")
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    /**
     * Find by username optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<User> findByUsername(String id);

    /**
     * Find by id.
     *
     * @param id the id
     * @return the optional
     */
    Optional<User> findByIdAndDeletedFalse(String id);

    /**
     * Find by username.
     *
     * @param username the username
     * @return the user
     */
    User findByUsernameAndDeletedFalse(String username);

    /**
     * Find all Users.
     *
     * @return the list
     */
    List<User> findAllByDeletedFalse();
}