package com.lex.hexagonal_architecture.core.usecase;

import org.springframework.stereotype.Service;
import com.lex.hexagonal_architecture.application.ports.input.DeleteUserUseCase;
import com.lex.hexagonal_architecture.application.ports.output.UserRepository;

@Service
public class DeleteUser implements DeleteUserUseCase {
  private final UserRepository userRepository;

  public DeleteUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void deleteUser(String userId) {
    this.userRepository.delete(userId);
  }
}
