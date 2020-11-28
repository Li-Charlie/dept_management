package crmsys1111.pojo;

public class Dept {
    private Integer deptid;
    private String deptname;
    private String deptinfo;

    public Dept() {
        super();
    }

    public Dept(String deptname, String deptinfo) {
        this.deptname = deptname;
        this.deptinfo = deptinfo;
    }

    public Dept(Integer deptid, String deptname, String deptinfo) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptinfo = deptinfo;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptinfo() {
        return deptinfo;
    }

    public void setDeptinfo(String deptinfo) {
        this.deptinfo = deptinfo;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptid=" + deptid +
                ", deptname='" + deptname + '\'' +
                ", deptinfo='" + deptinfo + '\'' +
                '}';
    }
}
