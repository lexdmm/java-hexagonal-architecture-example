package com.lex.hexagonal_architecture.application.ports.input;

import com.lex.hexagonal_architecture.core.domain.User;
import com.lex.hexagonal_architecture.dto.UserDTO;

public interface RegisterUserUseCase {
  User saveUser(UserDTO userDTO);
}
