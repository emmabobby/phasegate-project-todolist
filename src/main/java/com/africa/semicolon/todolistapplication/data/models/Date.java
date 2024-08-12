package com.africa.semicolon.todolistapplication.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Setter
@Getter
public class Date {
    private String id;
    private String day;
    private String month;
    private String year;
}
