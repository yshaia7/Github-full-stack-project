package main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * that interface define the method we will use when we want
 * to find/get users from the data base.
 * we can find by one user by user name
 * we can get 10 users with top count search
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    List<User> findFirst10ByOrderByCountDesc();
}
