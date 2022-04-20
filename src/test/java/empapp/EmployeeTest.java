package empapp;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmployeeTest implements PrintNameCapable {

    Employee employee;

//    public EmployeeTest() {
//        System.out.println("Constructor");
//    }

//    @BeforeAll
//    static void beforeAll() {
//        System.out.println("Before all");
//        System.out.println();
//    }

    @BeforeEach
    void initEmployee() {
//        System.out.println("INIT");
        employee = new Employee("John Doe", 1970);
    }

    @Test
    @DisplayName("Test age calculation with positive number")
    void getAgeTest() {
        int age = employee.getAge(2000);
        System.out.println("TC1");
        assertEquals(30, age);

        assertNotNull(employee);

        Employee expected = new Employee("John Doe", 1970);

        assertEquals(expected, employee);
        assertNotSame(expected, employee);
    }

    @Test
    void getAgeWithAssertAllTest() {
        assertEquals(30, employee.getAge(2000));
        assertAll(
                () -> assertEquals(30, employee.getAge(2000)),
                () -> assertEquals("John Doe", employee.getName())
        );
    }

    @Test
    void get_Age_With_Zero_Test() {
        System.out.println("TC2");
        assertEquals(0, employee.getAge(1970));
    }
}