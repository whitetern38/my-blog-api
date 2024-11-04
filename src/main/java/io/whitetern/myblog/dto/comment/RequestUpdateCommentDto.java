package io.whitetern.myblog.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestUpdateCommentDto(
    @NotNull
    Long commentId,

    @NotBlank
    String content
) {}
