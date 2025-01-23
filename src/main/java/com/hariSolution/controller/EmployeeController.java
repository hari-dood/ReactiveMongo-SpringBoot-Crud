package com.hariSolution.controller;

import com.hariSolution.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {

   @Autowired
   private ReactiveMongoTemplate reactiveMongoTemplate;

   @PostMapping("/create")
   public Mono<Employee> createEmployee(@RequestBody Employee employee){
       return this.reactiveMongoTemplate.save(employee);
    }


    @GetMapping("/get-all")
    public Flux<Employee> getAllEmployee(){
        return this.reactiveMongoTemplate.findAll(Employee.class);
    }


    @GetMapping("/get /{employeeId}")
    public Mono<Employee> getAllEmployee(@PathVariable(value = "employeeId") String employeeId){
        return getEmployeeId(employeeId);
    }

    private Mono<Employee>getEmployeeId(String employeeId){
        Criteria criteria=new Criteria(employeeId);
        Query query=new Query(criteria);
        return reactiveMongoTemplate.findOne(query, Employee.class);

    }

}
