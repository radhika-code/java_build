package com.paperflite.service;
import com.paperflite.model.StudentEntity;
import com.paperflite.request.CreateStudentRequest;
import com.paperflite.request.UpdateStudentRequest;

import java.util.List;


public interface StudentService {

    StudentEntity createStudent(CreateStudentRequest createStudentRequest);

    StudentEntity fetchStudents(String id);

    List<StudentEntity> fetchAllStudents();

    StudentEntity updateStudentDetails(String id, UpdateStudentRequest request) throws Exception;

    void deleteStudent(String id);

}
