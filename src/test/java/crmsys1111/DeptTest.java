package crmsys1111;

import crmsys1111.Utils.MyBatisUtils;
import crmsys1111.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DeptTest {
    private static SqlSessionFactory sqlSessionFactory = null;

    @Test
    public void selectAllTest() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            List<Dept> depts = sqlSession.selectList("DeptSqlMapper.selectAll");
            for (Dept dept : depts) {
                System.out.println(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void insertDeptTest() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            Dept dept = new Dept();
            dept.setDeptname("人事部");
            dept.setDeptinfo("负责公司人事工作");
            int result = sqlSession.insert("DeptSqlMapper.insertDept", dept);
            sqlSession.commit();
            if (result > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void updateDeptByIdTest() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            Dept dept = new Dept();
            dept.setDeptid(5);
            dept.setDeptname("行政部");
            dept.setDeptinfo("负责公司行政工作");
            int result = sqlSession.insert("DeptSqlMapper.updateDept", dept);
            sqlSession.commit();    // 手动提交
            if (result > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void deleteDeptByIdTest() {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            int result = sqlSession.insert("DeptSqlMapper.deleteDeptById", 4);
            sqlSession.commit();    // 手动提交
            if (result > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
