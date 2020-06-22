package com.op.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.op.mongo.entity.Employee;

public interface EmployeeRepository  extends MongoRepository<Employee, Integer>{

}
