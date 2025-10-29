package com.istudio.bookcrossing.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDto {
    private final UUID id;

    @NotNull(message = "Почта не может быть пустой")
    @NotBlank(message = "Почта не может быть пустой")
    @Size(min = 1, max = 320, message = "Почта не может быть длинее 320 символов")
    @Email(message = "Невалидный E-mail")
    private final String email;

    private final Boolean isActive;
}
