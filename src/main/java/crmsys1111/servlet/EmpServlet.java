package crmsys1111.servlet;

import crmsys1111.pojo.Dept;
import crmsys1111.pojo.Emp;
import crmsys1111.service.DeptService;
import crmsys1111.service.EmpService;
import crmsys1111.service.impl.DeptServiceImpl;
import crmsys1111.service.impl.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/doEmp")
public class EmpServlet extends HttpServlet {
    // 这两个Services一定会用到所以先写在这里
    EmpService empService = new EmpServiceImpl();
    DeptService deptService = new DeptServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); // 解决表单传递过来的中文乱码问题
        response.setContentType("text/html;charset=utf-8"); // 解决弹出窗口中文乱码的问题
        String action = request.getParameter("op");
        if ("doAdd".equals(action)) {
            doAdd(request, response);
        } else if ("toAdd".equals(action)) {
            toAdd(request, response);
        } else if ("list".equals(action)) {
            list(request, response);
        } else if ("toEdit".equals(action)) {
            toEdit(request, response);
        } else if ("doEdit".equals(action)) {
            doEdit(request, response);
        } else if ("del".equals(action)) {
            del(request, response);
        }
    }

    /**
     * 添加员工信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String empName = request.getParameter("empname");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        Integer salary = Integer.parseInt(request.getParameter("salary"));
        Integer deptid = Integer.parseInt(request.getParameter("deptid"));
        Emp emp = new Emp();
        emp.setEmpname(empName);
        emp.setEmail(email);
        emp.setTel(tel);
        emp.setSalary(salary);
        Dept dept = new Dept();
        dept.setDeptid(deptid);
        emp.setDept(dept);
        int result = empService.addEmp(emp);
        if (result > 0){
            response.sendRedirect(request.getContextPath() + "/admin/doEmp?op=list");
        } else {
            response.getWriter().print("<script>alert('添加失败！);history.go(-1);</script>");
        }
    }

    /**
     * 跳转到添加员工页面(emp_toAdd.jsp)
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将部门表信息放在部门(depts)里面。
        // 准备好并跳转到emp_toAdd.jsp页面中去。
        List<Dept> depts = deptService.getAllDepts();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("/admin/emp_toAdd.jsp").forward(request, response);
    }

    /**
     * 显示所有员工信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将员工表信息放在部门(emps)里面。
        // 准备好并跳转到 emp_list.jsp页面中去。
        List<Emp> emps = empService.getAllEmps();
        request.setAttribute("emps", emps);
        request.getRequestDispatcher("/admin/emp_list.jsp").forward(request, response);
    }

    /**
     * 前往修改页面，传入相应参数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将员工表信息放在部门(emps)里面。
        // 准备好并跳转到 emp_list.jsp页面中去。
        Integer empId = Integer.parseInt(request.getParameter("id"));
        Emp emp = empService.getEmpById(empId);
        request.setAttribute("emp", emp);
        List<Dept> depts = deptService.getAllDepts();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("/admin/emp_toEdit.jsp").forward(request, response);
    }

    /**
     * 提交修改，返回list
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer empid = Integer.parseInt(request.getParameter("empid"));
        String empName = request.getParameter("empname");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        Integer salary = Integer.parseInt(request.getParameter("salary"));
        Integer deptid = Integer.parseInt(request.getParameter("deptid"));
        Emp emp = new Emp();
        emp.setEmpid(empid);
        emp.setEmpname(empName);
        emp.setEmail(email);
        emp.setTel(tel);
        emp.setSalary(salary);
        Dept dept = new Dept();
        dept.setDeptid(deptid);
        emp.setDept(dept);
        int result = empService.editEmp(emp);
        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/admin/doEmp?op=list");
        } else {
            response.getWriter().print("<script>alert('修改失败！);history.go(-1);</script>");
        }
    }

    /**
     * 前往修改页面，传入相应参数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将员工表信息放在部门(emps)里面。
        // 准备好并跳转到 emp_list.jsp页面中去。
        Integer empId = Integer.parseInt(request.getParameter("id"));
        int result = empService.deleteEmpById(empId);
        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/admin/doEmp?op=list");
        } else {
            response.getWriter().print("<script>alert('删除失败！);history.go(-1);</script>");
        }
    }
}
