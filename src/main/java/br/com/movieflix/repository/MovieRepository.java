package br.com.movieflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository <Movie, Long>{

    List<Movie> findMovieByCategories(List<Category> categories);
}