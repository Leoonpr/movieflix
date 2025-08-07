package br.com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.movieflix.entity.Streaming;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long>{
}
