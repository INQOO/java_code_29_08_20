package edu.inqoo.good.code;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    @Test
    void addEmployee() {
        String name = "test user";
        String login = "test.user";
        String password = "test";
        String address = "Test street, yy-zzz Test";
        Department department = Department.HR;
        WorkerType workerType = WorkerType.MANAGER;

        EmployeeManager employeeManager = new EmployeeManager();
        assertEquals(0, employeeManager.getEmployeeList().size());

        employeeManager.addEmployee(name, login, password, address, workerType, department);
        assertEquals(1, employeeManager.getEmployeeList().size());
        Employee employee = employeeManager.getEmployeeList().get(0);
        assertEquals(name, employee.getName());
        assertEquals(login, employee.getLogin());
        assertEquals(PaymentManager.getManagerDefaultSalary(department), employee.getSalary());
        employee.setSalary(BigDecimal.valueOf(50000));
        employee = employeeManager.getEmployeeList().get(0);
        assertEquals(PaymentManager.getManagerDefaultSalary(department), employee.getSalary());
    }

    @Test
    public void testGetEmployee(){
        EmployeeManager manager = new EmployeeManager();
        assertEquals(manager.getEmployee("test"), Employee.DEFAULT_EMPLOYEE);

        String name = "test user";
        String login = "test.user";
        String password = "test";
        String address = "Test street, yy-zzz Test";
        Department department = Department.HR;
        WorkerType workerType = WorkerType.MANAGER;

        manager.addEmployee(name, login, password, address, workerType, department);

        assertEquals(name, manager.getEmployee(login).getName());
    }

    @Test
    public void testRemoveEmployee(){
        EmployeeManager manager = new EmployeeManager();

        String name = "test user";
        String login = "test.user";
        String password = "test";
        String address = "Test street, yy-zzz Test";
        Department department = Department.HR;
        WorkerType workerType = WorkerType.MANAGER;

        manager.addEmployee(name, login, password, address, workerType, department);
        assertEquals(1, manager.getEmployeeList().size());

        manager.removeEmployee(login);
        assertEquals(0, manager.getEmployeeList().size());
    }
}