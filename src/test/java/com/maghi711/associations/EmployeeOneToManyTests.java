package com.maghi711.associations;

import com.maghi711.associations.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmployeeOneToManyTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void contextLoads() {
        assertThat(employeeRepository).isNotNull();
    }
}
