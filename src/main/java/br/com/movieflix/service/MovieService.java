package br.com.movieflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieflix.entity.Movie;
import br.com.movieflix.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public Movie saveMovie(Movie movie) {
        return repository.save(movie);
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
