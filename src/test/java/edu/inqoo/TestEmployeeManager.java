package edu.inqoo;

import edu.inqoo.godObject.Employee;
import edu.inqoo.godObject.EmployeeManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestEmployeeManager {

    private EmployeeManager manager = new EmployeeManager();


    @Test
    public void testNewEmployee() throws Exception {
        String name = "test user";
        String login = "test.user";
        String password = "test";
        String address = "Test street, yy-zzz Test";
        String type = Employee.TYPE_MANAGER;
        String department = Employee.DEPARTMENT_SALES;
        manager.addEmployee(name, login, password, address, type, department, null);
    }

    @Test
    public void testGetEmployee(){
        String login = "test.user";
        Employee employee = manager.getEmployee(login);
        assertNotNull(employee);
        assertEquals(login, employee.getLogin());
    }
}
