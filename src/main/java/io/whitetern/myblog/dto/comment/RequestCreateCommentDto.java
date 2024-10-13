package io.whitetern.myblog.dto.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestCreateCommentDto {

    @NotBlank
    private String content;

    @NotNull
    private Long postId;

    @NotNull
    private Long userId;

}
