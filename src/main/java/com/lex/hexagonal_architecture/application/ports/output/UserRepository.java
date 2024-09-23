package com.lex.hexagonal_architecture.application.ports.output;

import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lex.hexagonal_architecture.core.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
  User update(User user);

  void delete(String userId);

  Optional<User> findById(String userId);

  List<User> findAll();
}
