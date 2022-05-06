package edu.corvinus.hazi20;

import edu.corvinus.hazi20.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

   Optional<User> findByUsername(String username);
}
