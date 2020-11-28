package crmsys1111.service.impl;

import crmsys1111.Utils.MyBatisUtils;
import crmsys1111.mapper.EmpSqlMapper;
import crmsys1111.pojo.Emp;
import crmsys1111.service.EmpService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpSqlMapper mapper;

    /**
     * 插入员工
     * @param emp 员工信息类
     * @return 影响的结果
     */
    @Override
    public int addEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        mapper = sqlSession.getMapper(EmpSqlMapper.class);
        int result = mapper.insertEmp(emp);
        if (result > 0) {
            sqlSession.commit();
            return result;
        } else {
            sqlSession.rollback();
        }
        MyBatisUtils.closeAll(sqlSession);
        return -1;
    }

    /**
     * 查询所有员工信息
     * @return 返回所有员工信息 List<Emp> emps
     */
    @Override
    public List<Emp> getAllEmps() {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        mapper = sqlSession.getMapper(EmpSqlMapper.class);
        List<Emp> emps = mapper.getAllEmps();
        MyBatisUtils.closeAll(sqlSession);
        return emps;
    }

    /**
     * 通过 ID 来查询员工信息
     * @param empId
     * @return
     */
    @Override
    public Emp getEmpById(Integer empId) {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        mapper = sqlSession.getMapper(EmpSqlMapper.class);
        return mapper.getEmpsById(empId);
    }

    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    @Override
    public int editEmp(Emp emp) {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        mapper = sqlSession.getMapper(EmpSqlMapper.class);
        int result = mapper.updateEmpById(emp);
        if (result > 0) {
            sqlSession.commit();
            return result;
        } else {
            sqlSession.rollback();
        }
        MyBatisUtils.closeAll(sqlSession);
        return -1;
    }

    @Override
    public int deleteEmpById(Integer empId) {
        SqlSession sqlSession = MyBatisUtils.createSqlSession();
        mapper = sqlSession.getMapper(EmpSqlMapper.class);
        int result = mapper.deleteEmpById(empId);
        if (result > 0) {
            sqlSession.commit();
            return result;
        } else {
            sqlSession.rollback();
        }
        MyBatisUtils.closeAll(sqlSession);
        return -1;
    }
}
