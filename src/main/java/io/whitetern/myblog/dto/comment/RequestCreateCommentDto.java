package io.whitetern.myblog.dto.comment;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateCommentDto {
    private String content;
    private Long postId;
}
