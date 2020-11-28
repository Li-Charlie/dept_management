package crmsys1111.service;

import crmsys1111.pojo.Emp;

import java.util.List;

public interface EmpService {
    public int addEmp(Emp emp);
    public List<Emp> getAllEmps();
    public Emp getEmpById(Integer empId);
    public int editEmp(Emp emp);
    public int deleteEmpById(Integer empId);
}
