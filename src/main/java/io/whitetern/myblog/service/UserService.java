package io.whitetern.myblog.service;

import io.whitetern.myblog.domain.User;
import io.whitetern.myblog.dto.user.RequestCreateUserDto;
import io.whitetern.myblog.dto.user.ResponseUserDto;
import io.whitetern.myblog.exception.UserException;
import io.whitetern.myblog.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseUserDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not Found"));
        return ResponseUserDto.builder()
                .loginId(user.getLoginId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .birthday(user.getBirthDate().toLocalDate())
                .build();
    }

    public Long createUser(RequestCreateUserDto requestCreateUserDto) {
        validateCreateUser(requestCreateUserDto);
        return userRepository.save(
                User.builder()
                        .loginId(requestCreateUserDto.loginId())
                        .password(passwordEncoder.encode(requestCreateUserDto.password()))
                        .name(requestCreateUserDto.name())
                        .email(requestCreateUserDto.email())
                        .phone(requestCreateUserDto.phone())
                        .birthDate(requestCreateUserDto.birthDate())
                    .build())
                .getId();
    }

    private void validateCreateUser(RequestCreateUserDto requestCreateUserDto) {
        if (!requestCreateUserDto.password().equals(requestCreateUserDto.passwordConfirm())) {
            throw new UserException(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        if (isAlreadyExistsLoginId(requestCreateUserDto.loginId())) {
            throw new UserException(ErrorCode.ALREADY_EXIST_LOGIN_ID);
        }
    }

    private boolean isAlreadyExistsLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).isPresent();
    }

}
