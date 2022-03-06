package com.essentialrage.samples.springbootkafka.repository;

import com.essentialrage.samples.springbootkafka.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, UUID> {
}