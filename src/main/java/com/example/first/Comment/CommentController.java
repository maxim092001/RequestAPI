package com.example.first.Comment;


import com.example.first.Request.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    RequestRepo requestRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/comment")
    public ResponseEntity<CommentRecord> createNewComment(@RequestBody CommentRecord commentRecord) {

        if (requestRepo.existsById(commentRecord.getRequestId())) {
            commentRecord = commentRepo.save(commentRecord);
            return new ResponseEntity<>(commentRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
