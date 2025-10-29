package com.istudio.bookcrossing.users.dto;

import com.istudio.bookcrossing.users.models.User;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.time.LocalDateTime;

@Component
public class UserMapper {
    public User toUser(InputUserDto userDto) {
        return new User(
                null,
                userDto.getEmail(),
                hashPassword(userDto.getPassword()),
                false,
                LocalDateTime.now()
        );
    }

    public User toUser(LoginUserDto userDto) {
        return new User(
                null,
                userDto.getEmail(),
                hashPassword(userDto.getPassword()),
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

    private String hashPassword(String password) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] digest = m.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ignored) { }

        return null;
    }
}
