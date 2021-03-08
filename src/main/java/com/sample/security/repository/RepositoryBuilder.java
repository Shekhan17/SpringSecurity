package com.sample.security.repository;

import com.sample.security.model.dto.User.UserDto;
import com.sample.security.model.entity.user.User;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RepositoryBuilder {
    UserRepository userRepository;

    public <IdType, EntityType, T extends CrudRepository<EntityType, IdType>> T getRepository(Class clazz) throws ClassNotFoundException {
        if(UserDto.class.isAssignableFrom(clazz)) {
            return (T)userRepository;
        } else if(User.class.isAssignableFrom(clazz)) {
            return (T)userRepository;
        }

        throw new ClassNotFoundException("Repository not found!!");

    }

}
