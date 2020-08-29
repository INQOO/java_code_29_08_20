package edu.inqoo.good.code;

import java.math.BigDecimal;

public class Employee {

    private String name;
    private String login;
    private String password;
    private String address;
    private WorkerType type;
    private Department department;
    private BigDecimal salary;

    public Employee(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(WorkerType type) {
        this.type = type;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public WorkerType getType() {
        return type;
    }

    public Department getDepartment() {
        return department;
    }

    public BigDecimal getSalary() {
        return salary;
    }
}
