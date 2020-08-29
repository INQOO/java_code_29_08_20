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
}