package io.whitetern.myblog.controller;

import io.whitetern.myblog.domain.Member;
import io.whitetern.myblog.dto.auth.RequestLoginDto;
import io.whitetern.myblog.service.AuthService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody @Valid RequestLoginDto requestLoginDto,
            HttpSession session
    ) {
        Member member = authService.login(requestLoginDto);
        session.setAttribute("user", member);

        return ResponseEntity.ok("로그인 성공");
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.removeAttribute("user");
        return ResponseEntity.ok("로그아웃 성공");
    }

}
