package com.xiana.mybatis.test;

import com.xiana.mybatis.bean.Department;
import com.xiana.mybatis.bean.Employee;
import com.xiana.mybatis.dao.DepartmentMapper;
import com.xiana.mybatis.dao.EmployeeMapper;
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
public class CacheTest {
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFirstCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee1 = mapper.getEmployeeById(2);
            sqlSession.clearCache();
            Employee employee2 = mapper.getEmployeeById(2);
            System.out.println(employee1 == employee2);
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void testSecondCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        try{
            EmployeeMapper mapper1 = sqlSession1.getMapper(EmployeeMapper.class);
            Employee employee1 = mapper1.getEmployeeById(2);
            sqlSession1.close();
            System.out.println(employee1);

            EmployeeMapper mapper2 = sqlSession2.getMapper(EmployeeMapper.class);
            Employee employee2 = mapper2.getEmployeeById(2);
            sqlSession2.close();
            System.out.println(employee2);
        }finally {

        }
    }
}
