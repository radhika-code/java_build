package com.paperflite.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequest {

    private String name;
    private String college;
    private String department;
    private String year;
}
