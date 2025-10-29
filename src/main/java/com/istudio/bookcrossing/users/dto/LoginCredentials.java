package com.istudio.bookcrossing.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginCredentials {
    private final UserDto user;
    private final String accessToken;
    private final Long expires;
}
