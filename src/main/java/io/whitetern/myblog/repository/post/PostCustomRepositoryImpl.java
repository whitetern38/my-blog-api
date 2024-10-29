package io.whitetern.myblog.repository.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.whitetern.myblog.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.whitetern.myblog.domain.QPost.post;

@Repository
@RequiredArgsConstructor
public class PostCustomRepositoryImpl implements PostCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Post> findAllByQueryDsl() {
        return jpaQueryFactory
                .selectFrom(post)
                .fetch();
    }
}
