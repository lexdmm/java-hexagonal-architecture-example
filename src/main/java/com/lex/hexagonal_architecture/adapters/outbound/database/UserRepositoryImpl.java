package com.lex.hexagonal_architecture.adapters.outbound.database;

import com.lex.hexagonal_architecture.application.ports.output.UserRepository;
import com.lex.hexagonal_architecture.core.domain.User;
import com.lex.hexagonal_architecture.dto.UserDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public User save(User user) {
    this.entityManager.persist(user);
    return user;
  }

  @Override
  public User update(User user) {
    return this.entityManager.merge(user);
  }

  @Override
  public void delete(String userId) {
    User user = entityManager.find(User.class, userId);
    if (user != null) {
      this.entityManager.remove(user);
    }
  }

  @Override
  public Optional<User> findById(String userId) {
    return Optional.ofNullable(this.entityManager.find(User.class, userId));
  }

  @Override
  public List<User> findAll() {
    return this.entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
  }
}
