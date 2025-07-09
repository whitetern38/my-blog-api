package io.whitetern.myblog.service;

import io.whitetern.myblog.domain.Member;
import io.whitetern.myblog.domain.Post;
import io.whitetern.myblog.dto.post.RequestCreatePostDto;
import io.whitetern.myblog.dto.post.RequestUpdatePostDto;
import io.whitetern.myblog.dto.post.ResponsePostDto;
import io.whitetern.myblog.repository.post.PostRepository;
import io.whitetern.myblog.repository.member.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public List<ResponsePostDto> findAll() {
        return postRepository
                .findAll()
                .stream()
                .map(Post::toResponseDto)
                .collect(Collectors.toList());
    }

    public ResponsePostDto findById(Long postId)  {
        return postRepository
                .findById(postId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."))
                .toResponseDto();
    }

    public ResponsePostDto createPost(RequestCreatePostDto requestCreatePostDto) {
        Member member = memberRepository.findById(requestCreatePostDto.userId())
                .orElseThrow(() -> new IllegalArgumentException("Create Post Error :: User Not Exists"));

        Post post = Post.builder()
                .title(requestCreatePostDto.title())
                .content(requestCreatePostDto.content())
                .member(member)
                .build();

        return postRepository.save(post).toResponseDto();
    }

    @Transactional
    public void update(Long postId, RequestUpdatePostDto requestUpdatePostDto) {
        postRepository
                .findById(postId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."))
                .updatePost(requestUpdatePostDto);
    }

    public void delete(Long postId) {
        Post targetPost = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 게시글입니다."));

        postRepository.delete(targetPost);
    }
}
