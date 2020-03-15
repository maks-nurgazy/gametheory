package diplom.gametheory.project.repository;


import diplom.gametheory.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Long> {

    Optional<User> findOneByLogin(String login);

}
