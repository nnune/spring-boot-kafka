package com.essentialrage.samples.springbootkafka.model.messaging;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class EmployeeMessage {
    private UUID employeeUUid;
    private String firstName;
    private String lastName;
}
