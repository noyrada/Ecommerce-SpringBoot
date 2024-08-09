package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import com.project.samplecrud_sb.model.request.postComment.PostCommentRequest;
import com.project.samplecrud_sb.model.response.postComment.PostCommentResponse;
import com.project.samplecrud_sb.service.PostCommentService;
import com.project.samplecrud_sb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
