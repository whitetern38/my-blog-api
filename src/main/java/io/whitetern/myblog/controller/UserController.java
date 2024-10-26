package io.whitetern.myblog.controller;

import io.whitetern.myblog.dto.user.RequestCreateUserDto;
import io.whitetern.myblog.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @PostMapping
    public ResponseEntity<Long> createUser(
            @RequestBody @Valid RequestCreateUserDto requestCreateUserDto
    ) {
        return ResponseEntity.ok(userService.createUser(requestCreateUserDto));
    }
}
