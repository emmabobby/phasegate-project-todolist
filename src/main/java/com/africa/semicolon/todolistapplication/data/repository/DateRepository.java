package com.africa.semicolon.todolistapplication.data.repository;

import com.africa.semicolon.todolistapplication.data.models.Date;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DateRepository extends MongoRepository<Date,String> {
}
