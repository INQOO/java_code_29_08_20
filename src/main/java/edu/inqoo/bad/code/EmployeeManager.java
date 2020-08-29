package edu.inqoo.bad.code;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    List<Employee> employeeList = new ArrayList();

    public void addEmployee(String name, String login, String password,
                          String address, String type, String department, BigDecimal salary) throws Exception {
        for (Employee employee: employeeList) {
            if(login == employee.getLogin()){
                throw new Exception("The user with the given login exists");
            }
        }
        Employee employee = new Employee();
        employee.setName(name);
        employee.setLogin(login);
        employee.setPassword(password);
        employee.setAddress(address);
        employee.setType(type);
        employee.setDepartment(department);
        employee.setSalary(salary==null ? getDefaultSalary(department, type) : salary);
        employeeList.add(employee);
    }

    public void removeEmployee(String name, String login) throws Exception {
        Employee removeEmployee = null;
        for (Employee employee: employeeList) {
            if(login == employee.getLogin() && name == employee.getName()){
                removeEmployee = employee;
            }
        }
        if(removeEmployee == null){
            throw new Exception("user not found");
        }else{
            employeeList.remove(removeEmployee);
        }
    }

    public Employee getEmployee(String login){
        for (Employee employee: employeeList) {
            if(login == employee.getLogin()){
                return employee;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    public List<Employee> employeesByDepartment(String department){
        List<Employee> departmentEmployee = new ArrayList<>();
        for (Employee employee: employeeList) {
            if(department == employee.getDepartment()){
                departmentEmployee.add(employee);
            }
        }
        return departmentEmployee;
    }

    public List<Employee> employeesByType(String type){
        List<Employee> typeEmployee = new ArrayList<>();
        for (Employee employee: employeeList) {
            if(type == employee.getType()){
                typeEmployee.add(employee);
            }
        }
        return typeEmployee;
    }

    public void updateEmployee(String name, String login,
    String address, String type, String department, BigDecimal salary) throws Exception {
        Employee updateEmployee = new Employee();
        for (Employee employee: employeeList) {
            if(login == employee.getLogin()){
                updateEmployee = employee;
            }
        }
        if(updateEmployee == null){
            throw new Exception("user not found");
        }
        updateEmployee.setName(name);
        updateEmployee.setAddress(address);
        updateEmployee.setType(type);
        updateEmployee.setDepartment(department);
        updateEmployee.setSalary(salary==null ? getDefaultSalary(department, type) : salary);
        employeeList.add(updateEmployee);

    }
    public boolean loginToSystem(String login, String password){
        for (Employee employee: employeeList) {
            if(login == employee.getLogin() && password == employee.getPassword()){
                return true;
            }
        }
        return false;
    }

    public void changePassword(String login, String oldPassword, String newPassword) throws Exception {
        Employee changePassword = null;
        for (Employee employee: employeeList) {
            if(login == employee.getLogin() && oldPassword == employee.getPassword()){
                changePassword = employee;
            }
        }
        if(changePassword == null){
            throw new Exception("user not found");
        }else{
            changePassword.setPassword(newPassword);
        }
    }

    public BigDecimal getDefaultSalary(String department, String type){
        if(department == Employee.DEPARTMENT_HR){
            if(type == Employee.TYPE_CEO){
                return BigDecimal.valueOf(25000);
            }else if(type == Employee.TYPE_MANAGER){
                return BigDecimal.valueOf(16000);
            }else if(type == Employee.TYPE_WORKER){
                return BigDecimal.valueOf(9000);
            }
        }else if(department == Employee.DEPARTMENT_SALES){
            if(type == Employee.TYPE_CEO){
                return BigDecimal.valueOf(35000);
            }else if(type == Employee.TYPE_MANAGER){
                return BigDecimal.valueOf(23000);
            }else if(type == Employee.TYPE_WORKER){
                return BigDecimal.valueOf(15000);
            }
        }else if(department == Employee.DEPARTMENT_PRODUCTION){
            if(type == Employee.TYPE_CEO){
                return BigDecimal.valueOf(19000);
            }else if(type == Employee.TYPE_MANAGER){
                return BigDecimal.valueOf(12000);
            }else if(type == Employee.TYPE_WORKER){
                return BigDecimal.valueOf(7000);
            }
        }
        return BigDecimal.ONE;
    }

}