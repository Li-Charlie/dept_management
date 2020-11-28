package crmsys1111.pojo;

public class Emp {
    private Integer empid;
    private String empname;
    private Integer salary;
    private String email;
    private String tel;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer empid, String empname, Integer salary, String email, String tel, Dept dept) {
        this.empid = empid;
        this.empname = empname;
        this.salary = salary;
        this.email = email;
        this.tel = tel;
        this.dept = dept;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empid=" + empid +
                ", empname='" + empname + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", dept=" + dept +
                '}';
    }
}
