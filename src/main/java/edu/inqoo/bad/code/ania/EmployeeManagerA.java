package edu.inqoo.bad.code.ania;

import edu.inqoo.bad.code.Employee;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerA {

    private List<EmployeeA> employeeList = new ArrayList();

    public void addEmployee(String name, String login, String password,
                            String address, Type type, Department department, BigDecimal salary) {

        EmployeeA employee = new EmployeeA(login);
        employee.setName(name);
        employee.setPassword(password);
        employee.setAddress(address);
        employee.setDepartment(department);
        employee.setType(type);
        employee.setSalary(getDefaultSalary(type, department));
        employeeList.add(employee);
    }

    public BigDecimal getDefaultSalary(Type type, Department department) {
        switch (type) {
            case CEO:
                return PaymentManager.getCEODefaultSalary(department);
            case Manager:
                return PaymentManager.getManagerDefaultSalary(department);
            case Worker:
                return PaymentManager.getWorkerDefaultSalary(department);
            default: return BigDecimal.ZERO;
        }


    }
}


