package crmsys1111;

import crmsys1111.Utils.MyBatisUtils;
import crmsys1111.mapper.EmpSqlMapper;
import crmsys1111.pojo.Dept;
import crmsys1111.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpSqlMapperTest {

    @Test
    public void testInsertEmp(){
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        EmpSqlMapper mapper = sqlSession.getMapper(EmpSqlMapper.class);
        System.out.println(mapper);
        Emp emp = new Emp();
        emp.setEmpname("李四");
        emp.setEmail("lisi@163.com");
        emp.setSalary(8900);
        emp.setTel("13888888888");
        Dept dept = new Dept();
        dept.setDeptid(1);
        emp.setDept(dept);
        int result = mapper.insertEmp(emp);
        sqlSession.commit();
        if (result > 0) {
            System.out.println("插入成功!");
        } else {
            System.out.println("插入失败!");
        }
        MyBatisUtils.closeAll(sqlSession);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = null;
        sqlSession = MyBatisUtils.createSqlSession();
        EmpSqlMapper mapper = sqlSession.getMapper(EmpSqlMapper.class);
        List<Emp> emps = mapper.getAllEmps();
        for (Emp emp : emps) {
            System.out.println(emp);
        }
        MyBatisUtils.closeAll(sqlSession);
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = null;
        sqlSession = MyBatisUtils.createSqlSession();
        EmpSqlMapper mapper = sqlSession.getMapper(EmpSqlMapper.class);
        Emp emp = mapper.getEmpsById(1);
        System.out.println(emp);
        MyBatisUtils.closeAll(sqlSession);
    }
}
