package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;

public interface UserService {
    UserDto createUser(InputUserDto userDto);
}
