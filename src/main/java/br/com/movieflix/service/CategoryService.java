package br.com.movieflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieflix.entity.Category;
import br.com.movieflix.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    
    public Optional<Category> findById(Long id) {
       return repository.findById(id);
    }

    public void deleteById(Long id) {
         repository.deleteById(id);
    }

}