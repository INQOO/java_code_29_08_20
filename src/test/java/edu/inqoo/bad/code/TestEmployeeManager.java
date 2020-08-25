package edu.inqoo.bad.code;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testGetAllEmployees(){
        List<Employee> employees = manager.getAllEmployees();
        assertEquals(1, employees.size());
    }

    @Test
    public void testEmployeesByDepartment(){
        String department = Employee.DEPARTMENT_SALES;
        List<Employee> employees = manager.employeesByDepartment(department);
        assertEquals(1, employees.size());
        assertEquals(department, employees.get(0).getDepartment());
    }

    @Test
    public void testEmployeesByType(){
        String type = Employee.TYPE_MANAGER;
        List<Employee> employees = manager.employeesByType(type);
        assertEquals(1, employees.size());
        assertEquals(type, employees.get(0).getType());
    }

    @Test
    public void testUpdateUser() throws Exception {
        String login = "test.user";
        String address = "Test street, yy-zzz Test2";
        String type = Employee.TYPE_CEO;
        manager.updateEmployee(null, login, address, type, null, null);
    }

    @Test
    public void testLoginToSystem(){
        String login = "test.user";
        String password = "test";
        assertTrue(manager.loginToSystem(login, password));
    }

    @Test
    public void testChangePassword() throws Exception {
        String login = "test.user";
        String oldPassword = "test";
        String newPassword = "test";
        manager.changePassword(login, oldPassword, newPassword);
    }

    @Test
    public void testGetEmployee(){
        String login = "test.user";
        Employee employee = manager.getEmployee(login);
        assertNotNull(employee);
        assertEquals(login, employee.getLogin());
    }

    @Test
    public void removeEmployee() throws Exception {
        String name = "test user";
        String login = "test.user";
        manager.removeEmployee(name, login);
    }
}
