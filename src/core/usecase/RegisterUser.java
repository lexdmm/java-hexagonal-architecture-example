package usecase;

import domain.User;
import ports.output.UserRepository;
import ports.input.RegisterUserUseCase;

public class RegisterUser implements RegisterUserUseCase {

  private final UserRepository userRepository;

  public RegisterUser(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void register(User user) {
    // Lógica de negócio para registro de usuário
    userRepository.save(user);
  }
}