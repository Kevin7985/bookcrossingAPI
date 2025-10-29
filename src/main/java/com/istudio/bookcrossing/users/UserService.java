package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(InputUserDto userDto);
    UserDto getUserByUserId(UUID userId);
}
