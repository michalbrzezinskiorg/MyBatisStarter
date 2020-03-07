package com.example.demo.dto;

import com.example.demo.database.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String surname;
    private ProfileDto profile;

    public UserDto(User user, ProfileDto profile) {
        id = user.getId();
        name = user.getName();
        surname = user.getSurname();
        this.profile = profile;
    }
}
