package outbound.database;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryImpl extends JpaRepository<User, String> {
  // As operações CRUD são providas automaticamente pelo JpaRepository
}
