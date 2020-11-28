package crmsys1111.service;

import crmsys1111.pojo.Dept;

import java.util.List;

public interface DeptService {
    public int addDept(Dept dept);
    public int editDept(Dept dept);
    public List<Dept> getAllDepts();
    public int deleteDeptById(Integer id);
    public Dept selectDeptById(Integer deptid);
}
