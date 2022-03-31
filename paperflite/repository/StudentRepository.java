package com.paperflite.repository;

import com.paperflite.model.StudentEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface StudentRepository extends MongoRepository<StudentEntity, String> {

}
