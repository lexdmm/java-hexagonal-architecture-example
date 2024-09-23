package ports.output;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.User;

public interface UserRepository extends JpaRepository<User, String> {
  List<User> findAll();

  Optional<User> findById(String id);

  boolean existsById(String id);

  void deleteById(String id);
}
