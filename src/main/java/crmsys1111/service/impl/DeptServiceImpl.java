package crmsys1111.service.impl;

import crmsys1111.Utils.MyBatisUtils;
import crmsys1111.mapper.DeptSqlMapper;
import crmsys1111.mapper.EmpSqlMapper;
import crmsys1111.pojo.Dept;
import crmsys1111.service.DeptService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    private DeptSqlMapper deptSqlMapper = null;
    private EmpSqlMapper empSqlMapper = null;

    /**
     * 新增部门
     * @param dept 部门对象
     * @return 返回受影响的行数
     */
    @Override
    public int addDept(Dept dept) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            // 在service中异常自己处理而不往外抛了
            deptSqlMapper = sqlSession.getMapper(DeptSqlMapper.class);
            Dept realDept = deptSqlMapper.selectDeptByName(dept.getDeptname());
            if (realDept == null){
                result = deptSqlMapper.insertDeptById(dept);
            } else {
                result = -1; // -1 代表部门名称已经存在
            }
            sqlSession.commit(); // 提交SQL语句
        } finally {
            MyBatisUtils.closeAll(sqlSession); // 应用层关闭连接对象
        }
        return result;
    }

    /**
     * 修改部门信息
     * @param dept 获取一个部门对象
     * @return  返回受影响的行数
     */
    @Override
    public int editDept(Dept dept) {
        int result = 0;
        SqlSession sqlSession = null;
        try {
            // 在service中异常处理不再还往外抛异常了
            sqlSession = MyBatisUtils.createSqlSession();
            deptSqlMapper = sqlSession.getMapper(DeptSqlMapper.class);
            Dept realDept = deptSqlMapper.selectDeptByName(dept.getDeptname());
            if (realDept == null) {
                result = deptSqlMapper.updateDeptById(dept);
            }
            // 两个情况：
            // 1）名字没改，导致与自己的名字重复了
            // 2）名字改成重复的名字了
            // 1.名字没改的情况
            else if (realDept.getDeptid().equals(dept.getDeptid())) {
                result = deptSqlMapper.updateDeptById(dept);
            }
            // 2.名字改了但是与其他名字重复了
            else { result = -1; }
            sqlSession.commit(); // 提交SQL语句
        } finally {
            MyBatisUtils.closeAll(sqlSession); // 应用层关闭连接对象
        }
        return result;
    }

    /**
     * 使用 ID 删除部门
     * @param dept_id 部门的ID
     * @return 返回受影响的条数
     */
    @Override
    public int deleteDeptById(Integer dept_id) {
        SqlSession sqlSession = null;
        int result;
        sqlSession = MyBatisUtils.createSqlSession();
        deptSqlMapper = sqlSession.getMapper(DeptSqlMapper.class);
        empSqlMapper = sqlSession.getMapper(EmpSqlMapper.class);
        Integer count = empSqlMapper.countEmpByDeptId(dept_id);
        if (count == 0) {
            // 如果该部门下没有员工，则可以删除整个部门，否则不允许删除
            result = deptSqlMapper.deleteDeptById(dept_id);
            sqlSession.commit();
        } else {
            result = -1;
            sqlSession.rollback();
        }
        // 只有在业务层才关闭连接
        MyBatisUtils.closeAll(sqlSession);
        return result;
    }

    /**
     * 查询所有部门信息
     * @return 一个带有所有部门对象的数组
     */
    @Override
    public List<Dept> getAllDepts() {
        SqlSession sqlSession = null;
        List<Dept> depts = null;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            deptSqlMapper = sqlSession.getMapper(DeptSqlMapper.class);
            depts = deptSqlMapper.selectAll();
        } finally {     // 只有在业务层才关闭连接
            MyBatisUtils.closeAll(sqlSession);
        }
        return depts;
    }

    /**
     * 通过 id 来查询部门
     * @param dept_id 部门id
     * @return 一个部门对象
     */
    @Override
    public Dept selectDeptById(Integer dept_id) {
        Dept dept = null;
        SqlSession sqlSession = null;
        int result = 0;
        try {
            sqlSession = MyBatisUtils.createSqlSession();
            deptSqlMapper = sqlSession.getMapper(DeptSqlMapper.class);
            dept = deptSqlMapper.selectDeptById(dept_id);
        } finally {
            // 只有在业务层才关闭连接
            MyBatisUtils.closeAll(sqlSession);
        }
        return dept;
    }
}
