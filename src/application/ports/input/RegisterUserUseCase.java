package ports.input;

import domain.User;

public interface RegisterUserUseCase {
  void register(User user);
}
