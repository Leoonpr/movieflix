package br.com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.movieflix.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
