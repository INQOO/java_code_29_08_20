package edu.inqoo.godObject;

import java.math.BigDecimal;

public class Employee {

    public static final String TYPE_CEO = "CEO";
    public static final String TYPE_MANAGER = "MANAGER";
    public static final String TYPE_WORKER = "WORKER";

    public static final String DEPARTMENT_SALES = "SALES";
    public static final String DEPARTMENT_HR = "HR";
    public static final String DEPARTMENT_PRODUCTION = "PRODUCTION";

    private String name;
    private String login;
    private String password;
    private String address;
    private String type;
    private String department;
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
