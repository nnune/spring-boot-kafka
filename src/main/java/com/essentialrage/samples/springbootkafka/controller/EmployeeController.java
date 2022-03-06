package com.essentialrage.samples.springbootkafka.controller;

import com.essentialrage.samples.springbootkafka.entity.Employee;
import com.essentialrage.samples.springbootkafka.repository.EmployeeRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController("employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    @NonNull
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(Pageable pageable){
        return ResponseEntity.ok(employeeRepository.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable UUID id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok(employeeRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }
}
