package com.istudio.bookcrossing.users;

import com.istudio.bookcrossing.service.MapperService;
import com.istudio.bookcrossing.users.dto.InputUserDto;
import com.istudio.bookcrossing.users.dto.UserDto;
import com.istudio.bookcrossing.users.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
    public UserDto getUserByUserId(UUID userId) {
        // TODO создать ошибку UserNotFoundException и написать его обработку
        User user = userRepository.findByIdActive(userId)
                .orElseThrow(() -> new RuntimeException("Пользователь с данным userId не найден"));

        return mapperService.toUserDto(user);
    }
}
