package com.example.demo;


import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    List<UserDto> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    UserDto saveUser(@RequestBody UserDto userDto) throws JsonProcessingException {
        return userService.save(userDto);
    }

}