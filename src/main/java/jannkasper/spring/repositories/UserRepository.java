package jannkasper.spring.repositories;

import jannkasper.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByLogin(String login);
    User findByLoginAndPassword(String login, String password);
}
