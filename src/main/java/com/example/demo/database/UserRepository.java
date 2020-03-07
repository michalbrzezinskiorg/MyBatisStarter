package com.example.demo.database;

import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UsersDAO usersDAO;

    public User save(User user) {
        if (user.getId() > 0) {
            usersDAO.update(user);
            return usersDAO.findById(user.getId());
        }
        usersDAO.insert(user);
        return user;
    }

    public List<User> findAll() {
        return usersDAO.findAll();
    }

}
