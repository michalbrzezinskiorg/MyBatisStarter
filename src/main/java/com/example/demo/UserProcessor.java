package com.example.demo;

import com.example.demo.database.User;
import com.example.demo.dto.ProfileDto;
import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProcessor {

    private final ObjectMapper objectMapper;

    public User processUserDto2User(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .surname(userDto.getSurname())
                .profile(serializeProfile(userDto))
                .build();
    }

    String serializeProfile(UserDto userDto) {
        String prof = "null";
        try {
            prof = objectMapper.writeValueAsString(userDto.getProfile());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return prof;
    }

    public ProfileDto getNullableProfileRequest(User u) {
        ProfileDto profile = null;
        try {
            profile = objectMapper.readerFor(ProfileDto.class).readValue(u.getProfile());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
