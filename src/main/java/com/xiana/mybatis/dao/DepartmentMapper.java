package com.xiana.mybatis.dao;

import com.xiana.mybatis.bean.Department;

public interface DepartmentMapper {

    Department getGetDepartmentById(Integer id);

    Department getDepartmentAndEmployee(Integer id);

    Department getDepartmentStep(Integer id);
}
