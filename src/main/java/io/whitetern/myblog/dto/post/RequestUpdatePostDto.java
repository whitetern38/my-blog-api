package io.whitetern.myblog.dto.post;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RequestUpdatePostDto {

    private String title;

    private String content;

}
