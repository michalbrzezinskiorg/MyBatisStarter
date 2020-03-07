package com.example.demo;

import com.example.demo.database.UserRepository;
import com.example.demo.database.User;
import com.example.demo.dto.ProfileDto;
import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final UserProcessor userProcessor;

    public UserDto save(UserDto userDto) throws JsonProcessingException {
        User user = userProcessor.processUserDto2User(userDto);
        user = userRepository.save(user);
        ProfileDto profile = objectMapper.readerFor(ProfileDto.class).readValue(user.getProfile());
        return new UserDto(user, profile);
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> new UserDto(user, userProcessor.getNullableProfileRequest(user)))
                .collect(Collectors.toList());
    }
}
