package com.lex.hexagonal_architecture.application.ports.input;

import java.util.Optional;
import com.lex.hexagonal_architecture.core.domain.User;

public interface GetUserUseCase {
  Optional<User> getUserById(String userId);
}
