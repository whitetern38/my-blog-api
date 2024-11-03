package io.whitetern.myblog.service;

import io.whitetern.myblog.auth.AuthenticatedUser;
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
        User user = userRepository.findByLoginId(requestLoginDto.getLoginId())
                .orElseThrow(() -> new AuthException("해당 아이디로 가입된 정보가 없습니다."));

        if (!passwordEncoder.matches(requestLoginDto.getPassword(), user.getPassword())) {
            throw new AuthException("비밀번호가 일치하지 않습니다.");
        }

        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginId)
                .orElseThrow(() -> new AuthException("as"));
        return new AuthenticatedUser(user);
    }

}
