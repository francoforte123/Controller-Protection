package Controller.Protection.Repository;

import Controller.Protection.Entities.Role;
import Controller.Protection.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findByActivationCode(String activationCode);

    User findByPasswordResetCode(String passwordResetCode);

    Optional<Role> findByName(String registered);
}
