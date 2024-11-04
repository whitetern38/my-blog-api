package io.whitetern.myblog.dto.post;

import jakarta.validation.constraints.NotBlank;

public record RequestUpdatePostDto(
        @NotBlank
        String title,

        @NotBlank
        String content
) {}
