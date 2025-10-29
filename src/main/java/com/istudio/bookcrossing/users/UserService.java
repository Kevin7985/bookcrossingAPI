package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.LoginCredentials;
import com.istudio.bookcrossing.users.dto.LoginUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;

import java.util.UUID;

public interface UserService {
    UserDto createUser(InputUserDto userDto);
    LoginCredentials loginUser(LoginUserDto userDto);
    UserDto getUserByUserId(UUID userId);
}
