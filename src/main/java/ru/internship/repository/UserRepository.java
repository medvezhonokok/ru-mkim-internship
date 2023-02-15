package ru.internship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.internship.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(
            value = "SELECT * from internship WHERE login=?1 and passwordSha=SHA1(CONCAT('abfb33e9f6ccc', ?1, ?2))",
            nativeQuery = true
    )
    User findByLoginAndPassword(String login, String password);

    int countByLogin(String login);

    @Query(
            value = "UPDATE internship SET passwordSha=SHA1(CONCAT('abfb33e9f6ccc', ?2, ?3)) WHERE id=?1",
            nativeQuery = true
    )
    void updatePassword(long id, String login, String password);
}
