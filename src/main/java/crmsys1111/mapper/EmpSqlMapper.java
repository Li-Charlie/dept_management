package crmsys1111.mapper;

import crmsys1111.pojo.Emp;

import java.util.List;

public interface EmpSqlMapper {
    public int insertEmp(Emp emp);
    public int updateEmpById(Emp emp);
    public int deleteEmpById(Integer empid);
    public List<Emp> getAllEmps();
    public Emp getEmpsById(Integer empid);
    public Integer countEmpByDeptId(Integer deptId);
}
