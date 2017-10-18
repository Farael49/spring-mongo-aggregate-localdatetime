package com.example.mongojavatime;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Created by cdouy on 17/10/2017.
 */
public class TestJavaTime {

    @Id
    public String id;

    public LocalDateTime createdDate = LocalDateTime.now();

    @Override
    public String toString() {
        return "TestJavaTime{" +
                "id='" + id + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
