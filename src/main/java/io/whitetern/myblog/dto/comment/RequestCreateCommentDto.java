package io.whitetern.myblog.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public record RequestCreateCommentDto(
    @NotBlank
    String content,

    @NotNull
    Long postId,

    @NotNull
    Long userId
) {}
