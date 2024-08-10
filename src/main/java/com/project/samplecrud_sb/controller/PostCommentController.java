package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import com.project.samplecrud_sb.model.request.postComment.PostCommentRequest;
import com.project.samplecrud_sb.model.response.postComment.PostCommentResponse;
import com.project.samplecrud_sb.service.PostCommentService;
import com.project.samplecrud_sb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post_comment")
public class PostCommentController {

    private final PostCommentService postCommentService;
    private final PostService postService;

    @Autowired
    public PostCommentController(PostCommentService postCommentService, PostService postService) {
        this.postCommentService = postCommentService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostCommentResponse> create(@RequestBody PostCommentRequest res) throws Exception{
        PostCommentEntity postComment = this.postCommentService.create(res);
        return ResponseEntity.ok(PostCommentResponse.fromEntity(postComment));
    }

    @GetMapping
    public ResponseEntity<List<PostCommentResponse>> getAll(@RequestParam(required = false) Long postId){
        List<PostCommentResponse> postComments = this.postCommentService.findAll(postId).stream().map
                (PostCommentResponse::fromEntity).toList();
        return ResponseEntity.ok(postComments);
    }
}
