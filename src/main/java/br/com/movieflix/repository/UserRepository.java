package br.com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.movieflix.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
