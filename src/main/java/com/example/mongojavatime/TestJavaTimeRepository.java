package com.example.mongojavatime;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by cdouy on 17/10/2017.
 */
public interface TestJavaTimeRepository extends MongoRepository<TestJavaTime, String> {

    List<TestJavaTime> findByCreatedDateAfter(LocalDateTime date);
}