package br.com.movieflix.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.movieflix.service.MovieService;

@RestController
@RequestMapping("/movieflix/movie")
public class MovieController {
    private MovieService service;

}
