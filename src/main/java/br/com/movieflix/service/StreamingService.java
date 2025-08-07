package br.com.movieflix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.movieflix.entity.Streaming;
import br.com.movieflix.repository.StreamingRepository;

@Service

public class StreamingService {

    @Autowired
    private StreamingRepository repository;

    public List<Streaming> findAll() {
        return repository.findAll();
    } 

    public Streaming saveStreaming(Streaming streaming) {
        return repository.save(streaming);
    }

    
    public Optional<Streaming> findById(Long id) {
       return repository.findById(id);
    }
 
    public void deleteById(Long id) {
         repository.deleteById(id);
    }
}
