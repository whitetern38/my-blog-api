package io.whitetern.myblog.service;

import io.whitetern.myblog.constants.ErrorCode;
import io.whitetern.myblog.domain.Member;
import io.whitetern.myblog.dto.member.RequestCreateMemberDto;
import io.whitetern.myblog.dto.member.ResponseMemberDto;
import io.whitetern.myblog.exception.CustomException;
import io.whitetern.myblog.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public ResponseMemberDto getUser(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));
        return ResponseMemberDto.builder()
                .loginId(member.getLoginId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .birthday(member.getBirthDate().toLocalDate())
                .build();
    }

    public Long createUser(RequestCreateMemberDto requestCreateMemberDto) {
        validateCreateUser(requestCreateMemberDto);
        return memberRepository.save(
                Member.builder()
                        .loginId(requestCreateMemberDto.loginId())
                        .password(passwordEncoder.encode(requestCreateMemberDto.password()))
                        .name(requestCreateMemberDto.name())
                        .email(requestCreateMemberDto.email())
                        .phone(requestCreateMemberDto.phone())
                        .birthDate(requestCreateMemberDto.birthDate())
                    .build())
                .getId();
    }

    private void validateCreateUser(RequestCreateMemberDto requestCreateMemberDto) {
        if (!requestCreateMemberDto.password().equals(requestCreateMemberDto.passwordConfirm())) {
            throw new CustomException(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        if (isAlreadyExistsLoginId(requestCreateMemberDto.loginId())) {
            throw new CustomException(ErrorCode.ALREADY_EXIST_LOGIN_ID);
        }
    }

    private boolean isAlreadyExistsLoginId(String loginId) {
        return memberRepository.findByLoginId(loginId).isPresent();
    }

}
