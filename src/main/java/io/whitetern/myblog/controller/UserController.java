package io.whitetern.myblog.controller;

import io.whitetern.myblog.dto.member.RequestCreateMemberDto;
import io.whitetern.myblog.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final MemberService memberService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(memberService.getUser(userId));
    }

    @PostMapping
    public ResponseEntity<Long> createUser(
            @RequestBody @Valid RequestCreateMemberDto requestCreateMemberDto
    ) {
        return ResponseEntity.ok(memberService.createUser(requestCreateMemberDto));
    }
}
