package com.example.first.Request;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepo extends JpaRepository <RequestRecord, Integer> {

    RequestRecord getById(int id);

    boolean existsById(int id);
}
