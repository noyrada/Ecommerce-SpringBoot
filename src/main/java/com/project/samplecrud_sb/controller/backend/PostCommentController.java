package com.project.samplecrud_sb.controller.backend;

import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import com.project.samplecrud_sb.model.request.postComment.CreatePostCommentRequest;
import com.project.samplecrud_sb.model.request.postComment.UpdatePostCommentRequest;
import com.project.samplecrud_sb.model.response.postComment.PostCommentResponse;
import com.project.samplecrud_sb.model.response.postComment.ShortPostCommentResponse;
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
    public ResponseEntity<ShortPostCommentResponse> create(@RequestBody CreatePostCommentRequest res) throws Exception{
        PostCommentEntity postComment = this.postCommentService.create(res);
        return ResponseEntity.ok(ShortPostCommentResponse.fromEntity(postComment));
    }

    @GetMapping
    public ResponseEntity<List<PostCommentResponse>> getAll(@RequestParam(required = false) Long postId){
        List<PostCommentResponse> postComments = this.postCommentService.findAll(postId).stream().map
                (PostCommentResponse::fromEntity).toList();
        return ResponseEntity.ok(postComments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShortPostCommentResponse> update(@PathVariable Long id, @RequestBody UpdatePostCommentRequest req)throws Exception{
        PostCommentEntity data = this.postCommentService.update(id,req);
        return ResponseEntity.ok(ShortPostCommentResponse.fromEntity(data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ShortPostCommentResponse> delete(@PathVariable Long id)throws Exception{
        PostCommentEntity data = this.postCommentService.delete(id);
        return ResponseEntity.ok(ShortPostCommentResponse.fromEntity(data));
    }
}
