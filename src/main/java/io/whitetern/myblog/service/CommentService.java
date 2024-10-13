package io.whitetern.myblog.service;

import io.whitetern.myblog.domain.Comment;
import io.whitetern.myblog.domain.Post;
import io.whitetern.myblog.domain.User;
import io.whitetern.myblog.dto.comment.RequestCreateCommentDto;
import io.whitetern.myblog.dto.comment.RequestUpdateCommentDto;
import io.whitetern.myblog.dto.comment.ResponseCommentDto;
import io.whitetern.myblog.repository.CommentRepository;
import io.whitetern.myblog.repository.PostRepository;
import io.whitetern.myblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ResponseCommentDto createComment(RequestCreateCommentDto requestCreateCommentDto) {
        User user = userRepository.findById(requestCreateCommentDto.getUserId())
                .orElseThrow(IllegalArgumentException::new);

        Post post = postRepository.findById(requestCreateCommentDto.getPostId())
                .orElseThrow(IllegalArgumentException::new);

        Comment createdComment = commentRepository.save(
                Comment.builder()
                        .post(post)
                        .user(user)
                        .content(requestCreateCommentDto.getContent())
                        .build()
        );

        return ResponseCommentDto.builder()
                .commentId(createdComment.getId())
                .postId(createdComment.getPostId())
                .userId(createdComment.getUserId())
                .content(createdComment.getContent())
                .build();
    }

    @Transactional
    public void updateComment(RequestUpdateCommentDto requestUpdateCommentDto) {
        commentRepository
                .findById(requestUpdateCommentDto.getCommentId())
                .orElseThrow(RuntimeException::new)
                .updateComment(requestUpdateCommentDto);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(RuntimeException::new);
        commentRepository.delete(comment);
    }
}
