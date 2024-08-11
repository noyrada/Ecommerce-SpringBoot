package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.PostCommentEntity;
import com.project.samplecrud_sb.model.entity.PostEntity;
import com.project.samplecrud_sb.model.request.postComment.CreatePostCommentRequest;
import com.project.samplecrud_sb.model.request.postComment.UpdatePostCommentRequest;
import com.project.samplecrud_sb.repository.PostCommentRepository;
import com.project.samplecrud_sb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCommentService {

    private final PostCommentRepository postCommentRepository;
    private final PostRepository postRepository;

    @Autowired
    public PostCommentService(PostCommentRepository postCommentRepository, PostRepository postRepository) {
        this.postCommentRepository = postCommentRepository;
        this.postRepository = postRepository;
    }

    public PostCommentEntity create(CreatePostCommentRequest postCommentReq) throws Exception {

        //prepare request model into entity model:
        PostCommentEntity request = postCommentReq.toEntity();

        //validate that post exist from db:
        PostEntity foundPost = this.postRepository.findById(postCommentReq.getPostId()).orElseThrow(()->
                new NotFoundException("Post not found!"));

        //set post into post-comments entity:
        request.setPost(foundPost);

        try {
            //save record:
            return this.postCommentRepository.save(request);

        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //find all data with id's post into db:
    public List<PostCommentEntity> findAll(Long postId){
        if(postId == null) return this.postCommentRepository.findAll();
        else return this.postCommentRepository.findAllByPostId(postId);
    }

    //update method:
    public PostCommentEntity update(Long id, UpdatePostCommentRequest req) throws Exception{
        //validate first id of comment that exist in db or not:
        PostCommentEntity foundData = this.postCommentRepository.findById(id).orElseThrow(()->
                new NotFoundException("Comment not found!"));

        //prepare and update data into db:
        foundData.setComment(req.getComment());

        try{
            //save exist:
            return this.postCommentRepository.save(foundData);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //delete method:
    public PostCommentEntity delete(Long id) throws Exception{
        //validate data:
        PostCommentEntity foundData = this.postCommentRepository.findById(id).orElseThrow(()->
                new NotFoundException("Comment not found!"));

        try {
            this.postCommentRepository.deleteById(foundData.getId());
        }catch (Exception ex){
            throw new Exception(ex);
        }
        return foundData;
    }
}
