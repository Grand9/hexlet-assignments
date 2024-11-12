package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> show(Long id) {
        return userRepository.findById(id);
    }
    public Mono<User> create(User userData) {
        return userRepository.save(userData);
    }
    public Mono<User> update(User userData, Long id) {
        User res = new User(userData.getFirstName(), userData.getLastName(), userData.getEmail());
        res.setId(id);
        return userRepository.save(res);
    }
    public Mono<Void> delete(Long id) {
        return userRepository.deleteById(id);
    }
    // END
}
