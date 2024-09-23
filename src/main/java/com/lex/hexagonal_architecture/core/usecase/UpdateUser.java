package com.lex.hexagonal_architecture.core.usecase;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.lex.hexagonal_architecture.application.ports.input.UpdateUserUseCase;
import com.lex.hexagonal_architecture.application.ports.output.UserRepository;
import com.lex.hexagonal_architecture.core.domain.User;
import com.lex.hexagonal_architecture.dto.UserDTO;

@Service
public class UpdateUser implements UpdateUserUseCase {
  private final UserRepository userRepository;

  public UpdateUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User updateUser(String id, UserDTO userDTO) {
    Optional<User> existingUser = userRepository.findById(id);
    if (existingUser.isPresent()) {
      User user = existingUser.get();
      user.setName(userDTO.getName());
      user.setEmail(userDTO.getEmail());
      return userRepository.save(user);
    }
    return null;
  }
}
