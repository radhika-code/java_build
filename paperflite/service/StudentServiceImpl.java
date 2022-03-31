package com.paperflite.service;

import com.paperflite.model.StudentEntity;
import com.paperflite.repository.StudentRepository;
import com.paperflite.request.CreateStudentRequest;
import com.paperflite.request.UpdateStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentEntity createStudent(CreateStudentRequest createStudentRequest) {
       StudentEntity student = new StudentEntity();
       student.setName(createStudentRequest.getName());
       student.setCollege(createStudentRequest.getCollege());
       student.setDepartment(createStudentRequest.getDepartment());
       student.setYear(createStudentRequest.getYear());
       student = studentRepository.save(student);
       return student;
    }

    public StudentEntity fetchStudents(String id) {
        StudentEntity student = studentRepository.findById(id).orElse(null);
        return student;
    }

    public List<StudentEntity>      fetchAllStudents() {
        List<StudentEntity> students = studentRepository.findAll();
        return students;
    }

    public StudentEntity updateStudentDetails(String id, UpdateStudentRequest request) throws Exception {
        StudentEntity student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            throw new Exception("student not found");
        }

        if (request.isCollegeSet()) {
            student.setCollege(request.getCollege());
        }
        if (request.isDepartmentSet()) {
            student.setDepartment(request.getDepartment());
        }
        if (request.isYearSet()) {
            student.setYear(request.getYear());
        }
        if (request.isNameSet()) {
            student.setName(request.getName());
        }
        student = studentRepository.save(student);
        return student;
    }

    public void deleteStudent(String id) {
        StudentEntity student = studentRepository.findById(id).orElse(null);
        studentRepository.delete(student);
    }

}
