package com.example.first.Request;


import com.example.first.Comment.CommentRecord;
import com.example.first.Comment.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class RequestController {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    RequestRepo requestRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/request")
    public RequestRecord createRequest(@RequestBody String description) {
        RequestRecord requestRecord = new RequestRecord(description);
        requestRecord.setStatus(StatusEnum.New);
        return requestRepo.save(requestRecord);
    }



    @RequestMapping(method = RequestMethod.GET, path = "/request")
    public ResponseEntity<RequestAndCommentsRecord> getRequestById(@RequestParam(name = "id") int id) {
        if (requestRepo.existsById(id)) {
            RequestRecord tempRecord = requestRepo.getById(id);
            ArrayList<CommentRecord> comments = commentRepo.getAllByRequestId(id);
            RequestAndCommentsRecord requestAndCommentsRecord = new RequestAndCommentsRecord(tempRecord, comments);
            return new ResponseEntity<>(requestAndCommentsRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }



    @RequestMapping(method = RequestMethod.PUT, path = "/request")
    public ResponseEntity<RequestRecord> updateStatus(@RequestBody RequestRecord requestRecord) {
        if (requestRepo.existsById(requestRecord.getId())) {
            RequestRecord tempRecord = requestRepo.getById(requestRecord.getId());
            tempRecord.setStatus(requestRecord.getStatus());
            return new ResponseEntity<>(requestRepo.save(tempRecord), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/request")
    public ResponseEntity<RequestRecord> deleteRequestById(@RequestParam(name = "id") int id) {
        if (requestRepo.existsById(id)) {
            RequestRecord tempRecord = requestRepo.getById(id);
            ArrayList<CommentRecord> comments = commentRepo.getAllByRequestId(id);
            requestRepo.delete(tempRecord);
            for (CommentRecord commentRecord : comments) {
                commentRepo.delete(commentRecord);
            }
            return new ResponseEntity<>(tempRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
