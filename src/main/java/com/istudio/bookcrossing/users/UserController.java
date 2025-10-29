package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.LoginCredentials;
import com.istudio.bookcrossing.users.dto.LoginUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Users", description = "Методы для работы с пользователями")
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Метод для регистрации пользователя")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody @Valid InputUserDto userDto) {
        return userService.createUser(userDto);
    }

    @PostMapping("/login")
    @Operation(summary = "Метод для авторизации в профиле")
    public LoginCredentials loginUser(@RequestBody @Valid LoginUserDto userDto) {
        return userService.loginUser(userDto);
    }

    @GetMapping("/users/{userId}")
    @Operation(
            summary = "Получение пользователя по userId",
            description = "Данный метод возвращает активного пользователя платформы"
    )
    public UserDto getUserByUserId(@PathVariable UUID userId) {
        return userService.getUserByUserId(userId);
    }
}
