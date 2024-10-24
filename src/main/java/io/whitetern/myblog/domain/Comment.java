package io.whitetern.myblog.domain;

import io.whitetern.myblog.dto.comment.RequestUpdateCommentDto;
import io.whitetern.myblog.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", insertable = false, updatable = false)
    private Post post;

    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "user_id")
    private Long userId;

    @Builder
    public Comment(Long id, String content, Post post, Long postId, User user, Long userId) {
        this.id = id;
        this.content = content;
        this.post = post;
        this.postId = postId;
        this.user = user;
        this.userId = userId;
    }

    public void updateComment(RequestUpdateCommentDto requestUpdateCommentDto) {
        this.content = requestUpdateCommentDto.getContent();
    }

}
