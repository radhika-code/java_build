package com.paperflite.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document
public class StudentEntity {

    @Id
    public String id;

    @Field("name")
    public String Name;

    @Field("college")
    public String college;

    @Field("department")
    public String department;

    @Field("year")
    public String year;
}
