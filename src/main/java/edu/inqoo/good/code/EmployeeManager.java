package edu.inqoo.good.code;

import edu.inqoo.books.Library;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList = new ArrayList();

    public List<Employee> getEmployeeList() {
        List<Employee> result = new ArrayList<>();
        for (Employee employee:employeeList) {
            Employee resultEmployee = new Employee(employee.getLogin());
            resultEmployee.setName(employee.getName());
            resultEmployee.setPassword(employee.getPassword());
            resultEmployee.setAddress(employee.getAddress());
            resultEmployee.setType(employee.getType());
            resultEmployee.setDepartment(employee.getDepartment());
            resultEmployee.setSalary(employee.getSalary());
            result.add(resultEmployee);
        }
        return result;
    }

    public void addEmployee(String name, String login,
                            String password, String address,
                            WorkerType type, Department department){
        Employee employee = new Employee(login);
        employee.setName(name);
        employee.setPassword(password);
        employee.setAddress(address);
        employee.setType(type);
        employee.setDepartment(department);
        employee.setSalary(getDefaultSalary(type, department));

        employeeList.add(employee);
    }

    public BigDecimal getDefaultSalary(WorkerType type, Department department){
        switch (type){
            case CEO: return PaymentManager.getCEODefaultSalary(department);

            case MANAGER: return PaymentManager.getManagerDefaultSalary(department);

            case WORKER: return PaymentManager.getWorkerDefaultSalary(department);

            default: return BigDecimal.ZERO;
        }
    }
}
