package io.whitetern.myblog.service;

import io.whitetern.myblog.domain.Comment;
import io.whitetern.myblog.dto.comment.RequestCreateCommentDto;
import io.whitetern.myblog.dto.comment.RequestUpdateCommentDto;
import io.whitetern.myblog.dto.comment.ResponseCommentDto;
import io.whitetern.myblog.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public ResponseCommentDto createComment(RequestCreateCommentDto requestCreateCommentDto) {
        Comment createdComment = commentRepository
                .save(
                    Comment.builder()
                            .postId(requestCreateCommentDto.getPostId())
                            .content(requestCreateCommentDto.getContent())
                            .build());
        return ResponseCommentDto.builder()
                .commentId(createdComment.getId())
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
