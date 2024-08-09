package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.PostEntity;
import com.project.samplecrud_sb.model.request.post.PostRequest;
import com.project.samplecrud_sb.model.response.post.PostResponse;
import com.project.samplecrud_sb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController{

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest request) throws Exception{
        PostEntity postEntity = this.postService.create(request);
        return ResponseEntity.ok(PostResponse.fromEntity(postEntity));
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll(){
        List<PostResponse> post = this.postService.findAll().stream().map(PostResponse::fromEntity).toList();
        return ResponseEntity.ok(post);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findOne(@PathVariable Long id)throws NotFoundException {
        PostEntity postEntity = this.postService.findOne(id);
        return ResponseEntity.ok(PostResponse.fromEntity(postEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable Long id,@RequestBody PostRequest request) throws Exception {
        PostEntity postEntity = this.postService.update(id,request);
        return ResponseEntity.ok(PostResponse.fromEntity(postEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostResponse> delete(@PathVariable Long id) throws Exception{
        PostEntity postEntity = this.postService.delete(id);
        return ResponseEntity.ok(PostResponse.fromEntity(postEntity));
    }
}
