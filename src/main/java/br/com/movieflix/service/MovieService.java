package br.com.movieflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.entity.Movie;
import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StreamingService streamingService;

    public List<Movie> findAll() {
        return repository.findAll();
    }

    public List<Movie> findByCategory(Long categoryId) {
        return repository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
    }

    public Movie saveMovie(Movie movie) {
        movie.setCategories(findCategories(movie.getCategories()));
        movie.setStreamings(findStreamings(movie.getStreamings()));
        return repository.save(movie);
    }

    public Optional<Movie> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<Movie> update(Long movieId, Movie updateMovie) {
        Optional<Movie> optMovie = repository.findById(movieId);
        if (optMovie.isPresent()) {
            Movie movie = optMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDescription(updateMovie.getDescription());
            movie.setRating(updateMovie.getRating());
            movie.setReleaseDate(updateMovie.getReleaseDate());

            List<Category> categories = this.findCategories(updateMovie.getCategories());
            List<Streaming> streamings =  this.findStreamings(updateMovie.getStreamings());

            movie.getCategories().clear();
            movie.getCategories().addAll(categories);

            movie.getStreamings().clear();
            movie.getStreamings().addAll(streamings);

            repository.save(movie);
            return Optional.of(movie);
        }

        return Optional.empty();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private List<Category> findCategories(List<Category> categories) {
        List<Category> categoriesList = new ArrayList<>();
        categories.forEach(category -> {
            Optional<Category> optCategory = categoryService.findById(category.getId());
            optCategory.ifPresent(categoriesList::add);
        });
        return categoriesList;
    }

    private List<Streaming> findStreamings(List<Streaming> services) {
        List<Streaming> servicesList = new ArrayList<>();
        services.forEach(service -> {
            Optional<Streaming> optStreamService = streamingService.findById(service.getId());
            optStreamService.ifPresent(servicesList::add);
        });
        return servicesList;
    }
}
