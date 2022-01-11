package com.xiana.mybatis.test;

import com.xiana.mybatis.bean.Department;
import com.xiana.mybatis.dao.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">Administrator</a>
 * @version v1.0
 * @package com.xiana.mybatis.test
 * @project mybatis
 * @description [类型描述]
 * @createTime 2022/1/9 18:29
 */
public class DepartmentTest {
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testDepartmentAndEmployee() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department departmentAndEmployee = mapper.getDepartmentAndEmployee(1);
            System.out.println(departmentAndEmployee.getEmployees());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDepartmentStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department department = mapper.getDepartmentStep(1);
            System.out.println(department.getDepartmentName());
            System.out.println(department.getEmployees());
        } finally {
            sqlSession.close();
        }
    }
}
