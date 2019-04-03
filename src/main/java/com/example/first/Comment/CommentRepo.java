package com.example.first.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CommentRepo extends JpaRepository<CommentRecord, Integer> {
    ArrayList<CommentRecord> getAllByRequestId(int requestId);
}
