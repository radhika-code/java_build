package com.paperflite.resource;

import com.paperflite.model.StudentEntity;
import com.paperflite.request.CreateStudentRequest;
import com.paperflite.request.UpdateStudentRequest;
import com.paperflite.response.StudentResponse;
import com.paperflite.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/1.0/students")
public class StudentResource {

    @Autowired
    private StudentService studentService;

     @PostMapping
     ResponseEntity<StudentResponse> newStudents(@RequestBody CreateStudentRequest createStudentRequest) {
         StudentEntity studentEntity = studentService.createStudent(createStudentRequest);

         StudentResponse response = new StudentResponse();
         response.setId(studentEntity.getId());
         response.setName(studentEntity.getName());
         response.setCollege(studentEntity.getCollege());
         response.setYear(studentEntity.getYear());
         return ResponseEntity.ok(response);

     }

     @GetMapping("/{id}")
     ResponseEntity<StudentResponse> fetchStudents(@PathVariable("id") String id) throws Exception {
         StudentEntity student = studentService.fetchStudents(id);

         if (student == null) {
             throw new Exception("Student not found");
         }

         StudentResponse studentResponse = new StudentResponse();
         studentResponse.setId(student.getId());
         studentResponse.setName(student.getName());
         studentResponse.setCollege(student.getCollege());
         studentResponse.setYear(student.getYear());
         return ResponseEntity.ok(studentResponse);
     }

     @GetMapping("/")
     ResponseEntity<List<StudentResponse>> fetchAllStudents() {
         List<StudentEntity> students = studentService.fetchAllStudents();

         List<StudentResponse> responses = students.stream()
                 .map(entity -> StudentResponse.full(entity))
                 .collect(Collectors.toList());


         return ResponseEntity.ok(responses);
     }

     @PutMapping("/update/{id}")
     ResponseEntity<StudentResponse> updateStudentDetails(@PathVariable("id") String id,
                                                              @RequestBody UpdateStudentRequest request) throws Exception {
         StudentEntity student = studentService.updateStudentDetails(id,request);

         if (student == null){
             throw new Exception("student not found");
         }

         StudentResponse response = new StudentResponse();
         response.setId(student.getId());
         response.setName(student.getName());
         response.setCollege(student.getCollege());
         response.setYear(student.getYear());

         return ResponseEntity.ok(response);
     }

     @DeleteMapping("/delete/{id}")
     void deleteStudent(@PathVariable("id") String id) {
         studentService.deleteStudent(id);
     }




}
