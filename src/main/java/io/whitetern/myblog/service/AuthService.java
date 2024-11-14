package io.whitetern.myblog.service;

import io.whitetern.myblog.auth.AuthenticatedUser;
import io.whitetern.myblog.constants.ErrorCode;
import io.whitetern.myblog.domain.User;
import io.whitetern.myblog.dto.auth.RequestLoginDto;
import io.whitetern.myblog.exception.AuthException;
import io.whitetern.myblog.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User login(RequestLoginDto requestLoginDto) {
        User user = userRepository.findByLoginId(requestLoginDto.loginId())
                .orElseThrow(() -> new AuthException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(requestLoginDto.password(), user.getPassword())) {
            throw new AuthException(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new AuthException(ErrorCode.USER_NOT_FOUND));
        return new AuthenticatedUser(user);
    }

}
