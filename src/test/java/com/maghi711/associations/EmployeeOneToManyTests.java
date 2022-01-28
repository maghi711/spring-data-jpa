package com.maghi711.associations;

import com.maghi711.associations.entities.Address;
import com.maghi711.associations.entities.Employee;
import com.maghi711.associations.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

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

    @Test
    void testCreateEmployee() {
        Address tempAddress = new Address();
        tempAddress.setStreet("BCC Layout");
        tempAddress.setCity("Bangalore");
        tempAddress.setState("Karnataka");
        tempAddress.setCountry("India");
        tempAddress.setZipcode("560040");

        Address newAddress = new Address();
        newAddress.setStreet("RHCS Layout");
        newAddress.setCity("Bangalore");
        newAddress.setState("Karnataka");
        newAddress.setCountry("India");
        newAddress.setZipcode("560091");

        Employee employee = new Employee();
        employee.setName("Aadavan M");
        employee.addAddress(newAddress);
        employee.addAddress(tempAddress);

        final Employee save = employeeRepository.save(employee);
        assertThat(save).isNotNull();
    }
}
