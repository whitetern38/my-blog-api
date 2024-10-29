package io.whitetern.myblog.repository.comment;

import io.whitetern.myblog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
