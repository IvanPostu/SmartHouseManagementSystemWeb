package com.webmvc.smarthousemanagementsystem.persistence;

import java.util.Optional;
import com.webmvc.smarthousemanagementsystem.domain.entities.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);

    void deleteAll();

    void save(UserEntity userEntity);

    Optional<UserEntity> findById(Long id);

}
