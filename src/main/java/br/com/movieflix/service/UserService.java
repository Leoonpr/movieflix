package br.com.movieflix.service;

import org.springframework.stereotype.Service;

import br.com.movieflix.entity.User;
import br.com.movieflix.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }
}
