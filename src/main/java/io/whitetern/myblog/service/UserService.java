package io.whitetern.myblog.service;

import io.whitetern.myblog.dto.user.RequestCreateUserDto;
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

    public Long createUser(RequestCreateUserDto requestCreateUserDto) {
        if (!requestCreateUserDto.getPassword1().equals(requestCreateUserDto.getPassword2())) {
            throw new IllegalArgumentException("Password Not Equal");
        }

        if (isAlreadyExistEmail(requestCreateUserDto.getEmail())) {
            throw new IllegalArgumentException("Email Exists");
        }

        if (isAlreadyExistNickname(requestCreateUserDto.getNickname())) {
            throw new IllegalArgumentException("Nickname Exists");
        }

        return userRepository.save(requestCreateUserDto.toEntity(passwordEncoder)).getId();
    }

    private boolean isAlreadyExistEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private boolean isAlreadyExistNickname(String nickname) {
        return userRepository.findByNickname(nickname).isPresent();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);

    }
}
