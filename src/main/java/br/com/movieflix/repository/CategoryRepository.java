package br.com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieflix.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
  