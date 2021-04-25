package com.webmvc.smarthousemanagementsystem.app.services;

import java.util.Optional;
import com.webmvc.smarthousemanagementsystem.domain.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    Optional<UserEntity> getUserById(Long id);


}
