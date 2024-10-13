package io.whitetern.myblog.dto.post;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCreatePostDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

}