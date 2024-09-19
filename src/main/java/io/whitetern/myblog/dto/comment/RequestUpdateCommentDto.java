package io.whitetern.myblog.dto.comment;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestUpdateCommentDto {
    private Long commentId;
    private String content;
}
