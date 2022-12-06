package unisystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unisystem.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
