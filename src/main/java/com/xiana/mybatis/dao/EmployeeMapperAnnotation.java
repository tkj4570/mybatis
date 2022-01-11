package com.xiana.mybatis.dao;

import com.xiana.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id=#{id}")
    public Employee getEmployeeById(Integer id);
}
