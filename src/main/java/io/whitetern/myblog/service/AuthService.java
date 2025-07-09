package io.whitetern.myblog.service;

import io.whitetern.myblog.constants.ErrorCode;
import io.whitetern.myblog.domain.Member;
import io.whitetern.myblog.dto.auth.RequestLoginDto;
import io.whitetern.myblog.exception.CustomException;
import io.whitetern.myblog.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Member login(RequestLoginDto requestLoginDto) {
        Member member = memberRepository.findByLoginId(requestLoginDto.loginId())
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(requestLoginDto.password(), member.getPassword())) {
            throw new CustomException(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        return member;
    }

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        Member member = memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return null;
//        return new AuthenticatedUser(member);
    }

}
