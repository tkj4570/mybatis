package com.xiana.mybatis.test;

import com.xiana.mybatis.bean.Employee;
import com.xiana.mybatis.dao.EmployeeMapper;
import com.xiana.mybatis.dao.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mail to: 457066709@qq.com" rel="nofollow">Administrator</a>
 * @version v1.0
 * @package com.xiana.mybatis.test
 * @project mybatis
 * @description [类型描述]
 * @createTime 2022/1/8 12:00
 */
public class MybatisTest {

    public SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
    /**
     * 1.根据xml配置文件（全局配置文件）创建一个SqlSessionFactory对象
     *      有数据源一些运行环境信息
     * 2.sql映射文件；配置每一个sql，以及sql的封装规则等
     * 3.将sql映射文件注册在全局配置文件中
     * 4.
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession实例，能直接执行已经映射的sql语句
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Employee employee = openSession.selectOne("com.xiana.mybatis.dao.EmployeeMapper.getEmployeeById", 2);
            System.out.println(employee);
        } finally {
            openSession.close();
        }
    }

    @Test
    public void testDao() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper sessionMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = sessionMapper.getEmployeeById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testCount() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper sessionMapper = sqlSession.getMapper(EmployeeMapper.class);
            Integer count = sessionMapper.getEmployeeCount();
            System.out.println(count);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDaoManyParam() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper sessionMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = sessionMapper.getEmployeeByIdAndLastName(2,"xiana");
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDaoAnnotation() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapperAnnotation sessionMapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = sessionMapper.getEmployeeById(1);
            System.out.println(employee);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAdd() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "xiana", "1314", "1");
            mapper.addEmployee(employee);
            System.out.println(employee.getId());
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdate() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.updateEmployee(new Employee(1,"xiana","1314","1"));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDelete() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            mapper.deleteEmployee(1);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testEmployeeMany() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.getEmployeeByName("%x%");
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testEmployeeIndexId() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Map<Integer, Employee> employeeMap = mapper.getEmployeeIndexId("%x%");
            System.out.println(employeeMap);
        } finally {
            sqlSession.close();
        }
    }


    @Test
    public void testEmployeeAndDepartment() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeAndDeptById(2);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testEmployeeStep() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmployeeStep(3);
            //打印全部会分步查询部门表
            System.out.println(employee);
            //只执行获取employee的字段会根据配置实现只查单表不会分步
            System.out.println(employee.getDepartment());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testEmployeeByCondition() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = new Employee(null, "x", null, null);
            List<Employee> employees = mapper.getEmployeeByCondition(employee);
            for (Employee one : employees) {
                System.out.println(one);
            }
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testEmployeeByIn() throws IOException {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.getEmployeeByIn(Arrays.asList(2,3));
            for (Employee one : employees) {
                System.out.println(one);
            }
        } finally {
            sqlSession.close();
        }
    }
}
