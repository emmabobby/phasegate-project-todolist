package com.africa.semicolon.todolistapplication.utils;

import com.africa.semicolon.todolistapplication.data.models.Date;

public class DateMapper {
    public static Date map(String day, String month, String year) {
        Date date = new Date();
        date.setDay(day);
        date.setMonth(month);
        date.setYear(year);
        return date;
    }
}
