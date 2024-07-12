package gr.aueb.cf.springauthsession5.repository;

import gr.aueb.cf.springauthsession5.model.Status;
import gr.aueb.cf.springauthsession5.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import gr.aueb.cf.springauthsession5.model.Role;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
    Long countByRole(Role role);
    Long countByRoleAndStatus(Role role, Status status);

}
