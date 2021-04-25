package com.webmvc.smarthousemanagementsystem.app.services;

import java.util.Optional;
import javax.transaction.Transactional;
import com.webmvc.smarthousemanagementsystem.domain.entities.UserEntity;
import com.webmvc.smarthousemanagementsystem.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =
                userRepository.findByEmail(username).orElseThrow(() -> new RuntimeException(
                        String.format("User with username %s not found", username)));
        return user;
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity;
    }


}
