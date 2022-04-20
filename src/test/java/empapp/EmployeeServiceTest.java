package empapp;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class EmployeeServiceTest {

    @Test
    void ListEmployeeNamesTest() {
        assertEquals(List.of("John Doe", "Jane Doe"), new EmployeeService().listEmployeeNames());
    }

    @Test
    void ListEmployeesTest() {
        // ez csak akkor működik, ha felül van írva az Employee osztályban az equals metódus
//        assertEquals(List.of(new Employee("John Doe", 1970),
//                new Employee("Jane Doe", 1980)), new EmployeeService().listEmployees());

        assertEquals(List.of("John Doe", "Jane Doe"), new EmployeeService().listEmployees().stream()
                .map(Employee::getName).collect(Collectors.toList()));

        EmployeeService employeeService = null;

        assumeTrue(employeeService != null);

        assertEquals(List.of("John Doe", "Jane Doe"), employeeService.listEmployees().stream()
                .map(Employee::getName).collect(Collectors.toList()), "Employee lists are different");
    }
}