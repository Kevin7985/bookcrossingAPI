package com.istudio.bookcrossing.service;

import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;
import com.istudio.bookcrossing.users.dto.UserMapper;
import com.istudio.bookcrossing.users.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapperService {
    private final UserMapper userMapper;

    public User toUser(InputUserDto userDto) {
        if (userDto == null) {
            return null;
        }

        return userMapper.toUser(userDto);
    }

    public UserDto toUserDto(User user) {
        if (user == null) {
            return null;
        }

        return userMapper.toUserDto(user);
    }
}
