package com.xiana.mybatis.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">Administrator</a>
 * @version v1.0
 * @package com.xiana.mybatis.bean
 * @project mybatis
 * @description [类型描述]
 * @createTime 2022/1/9 17:27
 */
public class Department implements Serializable {
    private Integer id;
    private String DepartmentName;
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        DepartmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", DepartmentName='" + DepartmentName + '\'' +
                '}';
    }
}
