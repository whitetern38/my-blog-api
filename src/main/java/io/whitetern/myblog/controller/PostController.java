package io.whitetern.myblog.controller;

import io.whitetern.myblog.domain.Post;
import io.whitetern.myblog.dto.post.RequestCreatePostDto;
import io.whitetern.myblog.dto.post.RequestUpdatePostDto;
import io.whitetern.myblog.dto.post.ResponsePostDto;
import io.whitetern.myblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<ResponsePostDto> createPost(@RequestBody RequestCreatePostDto requestCreatePostDto) {
        ResponsePostDto savedPost = postService.save(requestCreatePostDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{savedId}")
                .buildAndExpand(savedPost.getPostId())
                .toUri();
        return ResponseEntity.created(location).body(savedPost);
    }

    @GetMapping
    public ResponseEntity<List<ResponsePostDto>> getAllPosts() {
        return ResponseEntity.ok(postService.findAll());
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ResponsePostDto> getPost(@PathVariable Long postId) {
        ResponsePostDto responsePostDto = postService.findById(postId);
        return ResponseEntity.ok(responsePostDto);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<?> updatePost(
            @PathVariable Long postId,
            @RequestBody RequestUpdatePostDto requestUpdatePostDto
    ) {
        postService.update(postId, requestUpdatePostDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity.noContent().build();
    }

}
