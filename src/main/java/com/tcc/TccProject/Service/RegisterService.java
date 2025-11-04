package com.tcc.TccProject.Service;

import com.tcc.TccProject.entity.User;
import org.springframework.stereotype.Service;
import com.tcc.TccProject.repository.UserRepository;

@Service
public class RegisterService {

    private final UserRepository userRepository;

    public RegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(User user){
        return userRepository.save(user);
    }
}
