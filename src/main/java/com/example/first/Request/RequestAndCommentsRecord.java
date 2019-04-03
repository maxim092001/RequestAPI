package com.example.first.Request;

import com.example.first.Comment.CommentRecord;

import java.util.ArrayList;

public class RequestAndCommentsRecord {

    private RequestRecord requestRecord;
    private ArrayList<CommentRecord> comments;


    public RequestAndCommentsRecord(RequestRecord requestRecord, ArrayList<CommentRecord> comments) {
        this.requestRecord = requestRecord;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "RequestAndCommentsRecord{" +
                "requestRecord=" + requestRecord +
                ", comments=" + comments +
                '}';
    }

    public RequestAndCommentsRecord() {
    }

    public void setRequestRecord(RequestRecord requestRecord) {
        this.requestRecord = requestRecord;
    }

    public void setComments(ArrayList<CommentRecord> comments) {
        this.comments = comments;
    }

    public RequestRecord getRequestRecord() {
        return requestRecord;
    }

    public ArrayList<CommentRecord> getComments() {
        return comments;
    }
}
