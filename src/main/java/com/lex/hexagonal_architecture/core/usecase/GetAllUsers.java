package com.lex.hexagonal_architecture.core.usecase;

import java.util.List;
import org.springframework.stereotype.Service;

import com.lex.hexagonal_architecture.application.ports.input.GetAllUsersUseCase;
import com.lex.hexagonal_architecture.application.ports.output.UserRepository;
import com.lex.hexagonal_architecture.core.domain.User;

@Service
public class GetAllUsers implements GetAllUsersUseCase {

  private final UserRepository userRepository;

  public GetAllUsers(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
}
