package com.paperflite.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequest {
    private String name;
    private String college;
    private String department;
    private String year;

    private boolean isNameSet = false;
    private boolean isCollegeSet = false;
    private boolean isDepartmentSet = false;
    private boolean isYearSet = false;

    public void setCollege(String college) {
        this.college = college;
        this.setCollegeSet(true);
    }
    public void setName(String name) {
        this.name = name;
        this.setNameSet(true);
    }
    public void setYear(String year) {
        this.year = year;
        this.setYearSet(true);
    }
    public void setDepartment(String department) {
        this.department = department;
        this.setDepartmentSet(true);
    }
}
