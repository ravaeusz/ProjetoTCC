package com.tcc.TccProject.config;

import com.tcc.TccProject.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.tcc.TccProject.repository.UserRepository;

import java.util.Optional;

@Service
public class AuthConfig implements UserDetailsService {

    private UserRepository userRepository;

    public AuthConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public User getUserById(Long id){
        return userRepository.findUserById(id);
    }
}
