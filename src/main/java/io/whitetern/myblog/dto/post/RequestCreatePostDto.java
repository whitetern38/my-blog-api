package io.whitetern.myblog.dto.post;

import jakarta.validation.constraints.NotBlank;

public record RequestCreatePostDto(
        @NotBlank
        String title,

        @NotBlank
        String content,

        @NotBlank
        Long userId
) {}