package com.project.samplecrud_sb.controller;

import com.project.samplecrud_sb.exceptions.AlreadyExistException;
import com.project.samplecrud_sb.exceptions.BadRequestException;
import com.project.samplecrud_sb.exceptions.NotFoundException;
import com.project.samplecrud_sb.model.response.errors.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),(short)500);
        return ResponseEntity.status(500).body(err);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(AlreadyExistException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),(short)409);
        return ResponseEntity.status(409).body(err);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),(short)404);
        return ResponseEntity.status(404).body(err);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException ex){
        ErrorResponse err = new ErrorResponse(ex.getMessage(),(short)400);
        return ResponseEntity.status(400).body(err);
    }

    //modify in swagger:
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(MethodArgumentNotValidException ex){
        String message = "Invalid values!";
        for(ObjectError err : ex.getBindingResult().getAllErrors()){
            message = err.getDefaultMessage();
        }
        ErrorResponse err = new ErrorResponse(message,(short)400);
        return ResponseEntity.status(400).body(err);
    }


}
