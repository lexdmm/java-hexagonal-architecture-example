package com.lex.hexagonal_architecture.application.ports.input;

import java.util.List;

import com.lex.hexagonal_architecture.core.domain.User;

public interface GetAllUsersUseCase {
    List<User> getAllUsers();
}
