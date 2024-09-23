package inbound.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import domain.User;
import exceptions.InvalidUserException;
import exceptions.UserNotFoundException;
import ports.input.RegisterUserUseCase;
import ports.output.UserRepository;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserRepository userRepository;
  private final RegisterUserUseCase registerUserUseCase;

  public UserController(UserRepository userRepository, RegisterUserUseCase registerUserUseCase) {
    this.userRepository = userRepository;
    this.registerUserUseCase = registerUserUseCase;
  }

  @GetMapping
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userRepository.findAll();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable String id) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
    if (user.getName() == null || user.getEmail() == null) {
      throw new InvalidUserException("Name and Email are required.");
    }

    registerUserUseCase.register(user);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User updatedUser) {
    User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found."));

    user.setName(updatedUser.getName());
    user.setEmail(updatedUser.getEmail());
    userRepository.save(user);

    return ResponseEntity.ok(user);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable String id) {
    if (!userRepository.existsById(id)) {
      throw new UserNotFoundException("User with id " + id + " not found.");
    }

    userRepository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
