package com.istudio.bookcrossing.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserDto {
    @NotNull(message = "Почта не может быть пустой")
    @NotBlank(message = "Почта не может быть пустой")
    @Size(min = 1, max = 320, message = "Почта не может быть длинее 320 символов")
    @Email(message = "Невалидный E-mail")
    private final String email;

    @NotNull(message = "Пароль не может быть пустым")
    @NotBlank(message = "Пароль не может быть пустым")
    @Size(min = 8, max = 256, message = "Пароль не может быть короче 8 и длиннее 256 символов")
    private String password;
}
