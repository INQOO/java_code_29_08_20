package edu.inqoo.good.code;

import edu.inqoo.books.Library;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

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
        if(!doesEmployeeExist(login)) {
            Employee employee = new Employee(login);
            employee.setName(name);
            employee.setPassword(password);
            employee.setAddress(address);
            employee.setType(type);
            employee.setDepartment(department);
            employee.setSalary(getDefaultSalary(type, department));

            employeeList.add(employee);
        }
    }

    public boolean doesEmployeeExist(String login){
        for (Employee employee: employeeList) {
            if(login.equals(employee.getLogin())){
                return true;
            }
        }
        return false;
    }

    public BigDecimal getDefaultSalary(WorkerType type, Department department){
        switch (type){
            case CEO: return PaymentManager.getCEODefaultSalary(department);

            case MANAGER: return PaymentManager.getManagerDefaultSalary(department);

            case WORKER: return PaymentManager.getWorkerDefaultSalary(department);

            default: return BigDecimal.ZERO;
        }
    }

    public void removeEmployee(String login){
        if(doesEmployeeExist(login)){
            Employee employee = getEmployee(login);
            employeeList.remove(employee);
        }
    }

    public Employee getEmployee(String login) {
        for (Employee employee: employeeList) {
            if(login.equals(employee.getLogin())){
                return employee;
            }
        }
        return Employee.DEFAULT_EMPLOYEE;
    }
}
