package io.whitetern.myblog.service;

import io.whitetern.myblog.domain.User;
import io.whitetern.myblog.dto.user.RequestCreateUserDto;
import io.whitetern.myblog.dto.user.ResponseUserDto;
import io.whitetern.myblog.exception.UserException;
import io.whitetern.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

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
        return userRepository.save(requestCreateUserDto.toEntity(passwordEncoder)).getId();
    }

    private void validateCreateUser(RequestCreateUserDto requestCreateUserDto) {
        if (!requestCreateUserDto.getPassword().equals(requestCreateUserDto.getPasswordConfirm())) {
            throw new UserException("Password Not Equal");
        }

        if (isAlreadyExistsLoginId(requestCreateUserDto.getLoginId())) {
            throw new UserException("LoginId Already Exists");
        }
    }

    private boolean isAlreadyExistsLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UserException("as"));

    }
}
