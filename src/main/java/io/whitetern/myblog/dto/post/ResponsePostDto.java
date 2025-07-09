package io.whitetern.myblog.dto.post;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ResponsePostDto(
    Long postId,
    String title,
    String content,
    Long memberId,
    int readCnt,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
