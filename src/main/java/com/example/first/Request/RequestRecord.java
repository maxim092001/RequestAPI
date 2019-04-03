package com.example.first.Request;

import javax.persistence.*;

@Entity
@Table(name = "request")
public class RequestRecord {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum status;



    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public RequestRecord(String description, StatusEnum status) {
        this.description = description;
        this.status = status;
    }

    public RequestRecord(StatusEnum status) {
        this.status = status;
    }

    public RequestRecord(String description) {
        this.description = description;
    }

    public RequestRecord() {
    }
}
