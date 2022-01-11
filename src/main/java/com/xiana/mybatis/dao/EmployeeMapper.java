package com.xiana.mybatis.dao;

import com.xiana.mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    Employee getEmployeeById(Integer id);

    Integer getEmployeeCount();

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

    Employee getEmployeeByIdAndLastName(@Param("id") Integer id,@Param("lastName") String lastName);

    List<Employee> getEmployeeByName(String lastName);

    @MapKey("id")
    Map<Integer,Employee> getEmployeeIndexId(String lastName);

    Employee getEmployeeAndDeptById(Integer id);

    Employee getEmployeeStep(Integer id);

    List<Employee> getEmployeeByDeptId(Integer deptId);

    List<Employee> getEmployeeByCondition(Employee employee);

    List<Employee> getEmployeeByIn(List<Integer> list);
}
