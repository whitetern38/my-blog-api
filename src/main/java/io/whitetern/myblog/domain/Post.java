package io.whitetern.myblog.domain;

import io.whitetern.myblog.dto.post.RequestUpdatePostDto;
import io.whitetern.myblog.dto.post.ResponsePostDto;
import io.whitetern.myblog.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comment = new ArrayList<>();

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "read_cnt", columnDefinition = "integer default 0", nullable = false)
    private int readCnt;


    public void updatePost(RequestUpdatePostDto requestUpdatePostDto) {
        this.title = requestUpdatePostDto.getTitle();
        this.content = requestUpdatePostDto.getContent();
    }

    public ResponsePostDto toResponseDto() {
        return ResponsePostDto.builder()
                .postId(id)
                .title(title)
                .content(content)
                .readCnt(readCnt)
                .createdAt(createdDt)
                .updatedAt(updatedDt)
                .build();
    }

}
