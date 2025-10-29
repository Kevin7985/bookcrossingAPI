package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Users", description = "Методы для работы с пользователями")
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @Operation(description = "Метод для регистрации пользователя")
    public UserDto createUser(@RequestBody @Valid InputUserDto userDto) {
        return userService.createUser(userDto);
    }
}
