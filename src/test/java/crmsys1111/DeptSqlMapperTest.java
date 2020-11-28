package crmsys1111;

import crmsys1111.Utils.MyBatisUtils;
import crmsys1111.mapper.DeptSqlMapper;
import crmsys1111.pojo.Dept;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class DeptSqlMapperTest {

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        // 帮你得到DAO层接口的实现对象
        DeptSqlMapper mapper = sqlSession.getMapper(DeptSqlMapper.class);
        List<Dept> depts = mapper.selectAll();
        for (Dept dept : depts) {
            System.out.println(dept);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDeptById() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        // 帮你得到DAO层接口的实现对象
        DeptSqlMapper mapper = sqlSession.getMapper(DeptSqlMapper.class);
        Dept dept = mapper.selectDeptById(1);
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testSelectDeptByName() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        // 帮你得到DAO层接口的实现对象
        DeptSqlMapper mapper = sqlSession.getMapper(DeptSqlMapper.class);
        Dept dept = mapper.selectDeptByName("研发部");
        System.out.println(dept);
        sqlSession.close();
    }

    @Test
    public void testInsertDept() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        // 帮你得到DAO层接口的实现对象
        DeptSqlMapper mapper = sqlSession.getMapper(DeptSqlMapper.class);
        Dept dept = new Dept();
        dept.setDeptname("科研部");
        dept.setDeptinfo("负责公司的科研工作");
        try {
            int result = mapper.insertDeptById(dept);
            sqlSession.commit();
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception exception) {
            sqlSession.rollback();
            System.out.println("添加失败");
            exception.getCause();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateDept() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        // 帮你得到DAO层接口的实现对象
        DeptSqlMapper mapper = sqlSession.getMapper(DeptSqlMapper.class);
        Dept dept = new Dept();
        dept.setDeptid(16);
        dept.setDeptname("销售部");
        dept.setDeptinfo("负责公司的销售工作");
        try {
            int result = mapper.updateDeptById(dept);
            sqlSession.commit();
            if (result > 0) {
                System.out.println("修改成功");
            }
        } catch (Exception exception) {
            sqlSession.rollback();
            System.out.println("修改失败");
            exception.getCause();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteDeptById() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        // 帮你得到DAO层接口的实现对象
        DeptSqlMapper mapper = sqlSession.getMapper(DeptSqlMapper.class);
        try {
            int result = mapper.deleteDeptById(16);
            sqlSession.commit();
            if (result > 0) {
                System.out.println("删除成功");
            }
        } catch (Exception exception) {
            sqlSession.rollback();
            System.out.println("删除失败");
            exception.getCause();
        } finally {
            sqlSession.close();
        }
    }
}
