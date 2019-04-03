package com.example.first.Comment;


import javax.persistence.*;

@Entity
@Table(name = "comment")
public class CommentRecord {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "text")
    private String text;

    @Column(name = "requestId")
    private int requestId;


    public CommentRecord(String text, int requestId) {
        this.text = text;
        this.requestId = requestId;
    }

    public CommentRecord() {
    }

    @Override
    public String toString() {
        return "CommentRecord{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", requestId=" + requestId +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getRequestId() {
        return requestId;
    }
}
