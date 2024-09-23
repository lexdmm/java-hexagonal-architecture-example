package com.lex.hexagonal_architecture.adapters.inbound.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.lex.hexagonal_architecture.application.ports.input.DeleteUserUseCase;
import com.lex.hexagonal_architecture.application.ports.input.GetUserUseCase;
import com.lex.hexagonal_architecture.application.ports.input.GetAllUsersUseCase;
import com.lex.hexagonal_architecture.application.ports.input.RegisterUserUseCase;
import com.lex.hexagonal_architecture.application.ports.input.UpdateUserUseCase;
import com.lex.hexagonal_architecture.core.domain.User;
import com.lex.hexagonal_architecture.dto.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

  private final RegisterUserUseCase registerUserUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final DeleteUserUseCase deleteUserUseCase;
  private final GetUserUseCase getUserUseCase;
  private final GetAllUsersUseCase getUsersUseCase;

  public UserController(RegisterUserUseCase registerUserUseCase, UpdateUserUseCase updateUserUseCase,
      DeleteUserUseCase deleteUserUseCase, GetUserUseCase getUserUseCase, GetAllUsersUseCase getUsersUseCase) {
    this.registerUserUseCase = registerUserUseCase;
    this.updateUserUseCase = updateUserUseCase;
    this.deleteUserUseCase = deleteUserUseCase;
    this.getUserUseCase = getUserUseCase;
    this.getUsersUseCase = getUsersUseCase;
  }

  @PostMapping
  public void save(@RequestBody UserDTO user) {
    this.registerUserUseCase.saveUser(user);
  }

  @PutMapping("/{id}")
  public User update(@PathVariable String id, @RequestBody UserDTO user) {
    return this.updateUserUseCase.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    this.deleteUserUseCase.deleteUser(id);
  }

  @GetMapping("/{id}")
  public Optional<User> getUser(@PathVariable String id) {
    return this.getUserUseCase.getUserById(id);
  }

  @GetMapping("/all")
  public List<User> getAllUsers() {
    return this.getUsersUseCase.getAllUsers();
  }
}
