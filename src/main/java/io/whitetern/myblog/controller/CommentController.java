package io.whitetern.myblog.controller;

import io.whitetern.myblog.dto.comment.RequestCreateCommentDto;
import io.whitetern.myblog.dto.comment.RequestUpdateCommentDto;
import io.whitetern.myblog.dto.comment.ResponseCommentDto;
import io.whitetern.myblog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<ResponseCommentDto> createComment(
            @RequestBody RequestCreateCommentDto requestCreateCommentDto
    ) {
        return ResponseEntity.ok(commentService.createComment(requestCreateCommentDto));
    }

    @PutMapping
    public ResponseEntity<?> updateComment(
            @RequestBody RequestUpdateCommentDto requestUpdateCommentDto
    ) {
        commentService.updateComment(requestUpdateCommentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

}
