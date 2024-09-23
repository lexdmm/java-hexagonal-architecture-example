package com.lex.hexagonal_architecture.core.usecase;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.lex.hexagonal_architecture.application.ports.input.GetUserUseCase;
import com.lex.hexagonal_architecture.application.ports.output.UserRepository;
import com.lex.hexagonal_architecture.core.domain.User;

@Service
public class GetUser implements GetUserUseCase {
  private final UserRepository userRepository;

  public GetUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public Optional<User> getUserById(String userId) {
    return this.userRepository.findById(userId);
  }
}
