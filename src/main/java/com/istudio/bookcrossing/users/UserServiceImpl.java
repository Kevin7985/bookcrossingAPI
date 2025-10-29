package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.service.MapperService;
import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.LoginCredentials;
import com.istudio.bookcrossing.users.dto.LoginUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;
import com.istudio.bookcrossing.users.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final MapperService mapperService;
    private final UserRepository userRepository;

    @Override
    public UserDto createUser(InputUserDto userDto) {
        User user = mapperService.toUser(userDto);
        user = userRepository.save(user);

        // TODO обработать ошибку duplicate key value violates unique constraint "uq_user_email"
        return mapperService.toUserDto(user);
    }

    @Override
    public LoginCredentials loginUser(LoginUserDto userDto) {
        User login = mapperService.toUser(userDto);

        // TODO обработать ошибку неверного пароля
        User user = userRepository.findByEmailAndPassword(login.getEmail(), login.getPassword())
                .orElseThrow(() -> new RuntimeException("Неверная почта или пароль"));

        // TODO обработать ошибку неактивированного аккаунта
        if (!user.getIsActive()) {
            throw new RuntimeException("Данный аккаунт не подтверждён");
        }

        // TODO добавить токен в Redis
        LoginCredentials creds = new LoginCredentials(
                mapperService.toUserDto(user),
                "",
                Timestamp.valueOf(LocalDateTime.now().plusHours(2)).getTime()
        );

        return creds;
    }

    @Override
    public UserDto getUserByUserId(UUID userId) {
        // TODO создать ошибку UserNotFoundException и написать его обработку
        User user = userRepository.findActiveById(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с данным userId не найден"));

        return mapperService.toUserDto(user);
    }
}
