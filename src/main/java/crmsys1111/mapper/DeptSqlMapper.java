package crmsys1111.mapper;

import crmsys1111.pojo.Dept;

import java.util.List;

/**
 * 这个接口名和包名要和DeptSqlMapper.xml文件中<mapper>中的 namespace 相同
 */
public interface DeptSqlMapper {
    public List<Dept> selectAll();
    public Dept selectDeptById(Integer id);
    public Dept selectDeptByName(String deptname);
    public int insertDeptById(Dept dept);
    public int updateDeptById(Dept dept);
    public int deleteDeptById(Integer id);
}
