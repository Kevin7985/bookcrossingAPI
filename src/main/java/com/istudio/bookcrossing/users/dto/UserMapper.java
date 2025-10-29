package com.istudio.bookcrossing.users.dto;

import com.istudio.bookcrossing.users.models.User;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User toUser(InputUserDto userDto) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(userDto.getPassword().getBytes());
            byte[] digest = m.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            userDto.setPassword(hexString.toString());
        } catch (Exception ignored) { }

        return new User(
                null,
                userDto.getEmail(),
                userDto.getPassword(),
                false,
                LocalDateTime.now()
        );
    }

    public UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getIsActive()
        );
    }
}
