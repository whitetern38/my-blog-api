package io.whitetern.myblog.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record ResponseCommentDto(
    @NotNull
    Long commentId,

    Long userId,

    @NotNull
    Long postId,

    @NotBlank
    String content
) {}
