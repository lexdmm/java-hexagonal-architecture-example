package com.lex.hexagonal_architecture.core.usecase;

import org.springframework.stereotype.Service;

import com.lex.hexagonal_architecture.application.ports.input.RegisterUserUseCase;
import com.lex.hexagonal_architecture.application.ports.output.UserRepository;
import com.lex.hexagonal_architecture.core.domain.User;
import com.lex.hexagonal_architecture.dto.UserDTO;

@Service
public class RegisterUser implements RegisterUserUseCase {

  private final UserRepository userRepository;

  public RegisterUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User saveUser(UserDTO userDTO) {
    User user = new User();
    user.setName(userDTO.getName());
    user.setEmail(userDTO.getEmail());
    return userRepository.save(user);
  }
}