package edu.inqoo.good.code;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employeeList = new ArrayList();

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
