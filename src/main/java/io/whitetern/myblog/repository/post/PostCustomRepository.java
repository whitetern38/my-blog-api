package io.whitetern.myblog.repository.post;

import io.whitetern.myblog.domain.Post;

import java.util.List;

public interface PostCustomRepository {

    List<Post> findAllByQueryDsl();

}
