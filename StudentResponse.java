package com.paperflite.response;

import com.paperflite.model.StudentEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private String id;
    private String name;
    private String year;
    private String college;

    public static StudentResponse full(StudentEntity entity) {
        if (entity == null) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(entity.getId());
        studentResponse.setName(entity.getName());
        studentResponse.setCollege(entity.getCollege());
        studentResponse.setYear(entity.getYear());

        return studentResponse;
    }

}
