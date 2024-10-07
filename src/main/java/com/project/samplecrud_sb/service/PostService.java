package com.project.samplecrud_sb.service;

import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.entity.PostEntity;
import com.project.samplecrud_sb.model.request.post.PostRequest;
import com.project.samplecrud_sb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity create(PostRequest req) throws Exception{
        try {
            return this.postRepository.save(req.toEntity());
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //find all data from db:
    public List<PostEntity> findAll(){
        return this.postRepository.findAll();
    }

    //find one data from db by id:
    public PostEntity findOne(Long id) throws NotFoundException {
        return this.postRepository.findById(id).orElseThrow(()-> new NotFoundException("Post not found!"));
    }

    //update data:
    public PostEntity update(Long id, PostRequest req) throws Exception {
        //check data into db:
        PostEntity foundData = this.postRepository.findById(id).orElseThrow(()->new NotFoundException("Post not found!"));

        // need give all field's value to update
        foundData.setTitle(req.getTitle());
        foundData.setDescription(req.getDescription());

        try {
            //update entity:
            return this.postRepository.save(foundData);
        }catch (Exception ex){
            throw new Exception(ex);
        }
    }

    //delete data:
    public PostEntity delete(Long id) throws Exception{
        //check data into db:
        //PostEntity foundData = this.postRepository.findById(id).orElseThrow(()->
        //new NotFoundException("Post not found!"));

        //get data by id onto database:
        PostEntity data = this.findOne(id);
        //PostEntity data = this.postRepository.findById(id);

        try {
            this.postRepository.deleteById(data.getId());
        }catch (Exception ex){
            throw new Exception(ex);
        }
        return data;
    }
}
