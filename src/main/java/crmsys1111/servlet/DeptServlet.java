package crmsys1111.servlet;

import crmsys1111.pojo.Dept;
import crmsys1111.service.DeptService;
import crmsys1111.service.impl.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/admin/doDept")
public class DeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);   // 无论你从哪个方法过来我都使用doGet方法处理
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
            doDelete(request, response);
        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptService service = new DeptServiceImpl();
        List<Dept> depts = service.getAllDepts();
        request.setAttribute("depts", depts);
        request.getRequestDispatcher("/admin/dept_list.jsp").forward(request, response);
    }

    protected void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/dept_toAdd.jsp").forward(request, response);
    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deptname = request.getParameter("deptname");
        String deptinfo = request.getParameter("deptinfo");
        Dept dept = new Dept();
        dept.setDeptname(deptname);
        dept.setDeptinfo(deptinfo);
        DeptService service = new DeptServiceImpl();
        int result = service.addDept(dept);
        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/admin/doDept?op=list");
        } else if (result == 0) {
            response.getWriter().print("<script>alert('添加失败!');history.go(-1);</script>"); // history.go(-1) -1代表回退回去前面的页面
        } else if (result == -1) {
            response.getWriter().print("<script>alert('部门名称重复，添加失败!');history.go(-1);</script>");
        }
    }

    protected void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer deptid = Integer.parseInt(request.getParameter("id"));
        DeptService service = new DeptServiceImpl();
        Dept dept = service.selectDeptById(deptid);
        request.setAttribute("dept", dept);
        request.getRequestDispatcher("/admin/dept_toEdit.jsp").forward(request, response);
    }

    protected void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer deptid = Integer.valueOf(request.getParameter("deptid"));
        String deptname = request.getParameter("deptname");
        String deptinfo = request.getParameter("deptinfo");
        Dept dept = new Dept();
        dept.setDeptid(deptid);
        dept.setDeptname(deptname);
        dept.setDeptinfo(deptinfo);
        DeptService service = new DeptServiceImpl();
        int result = service.editDept(dept);
        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/admin/doDept?op=list");
        } else if (result == 0) {
            response.getWriter().print("<script>alert('修改失败!');history.go(-1);</script>"); // history.go(-1) -1代表回退回去前面的页面
        } else if (result == -1) {
            response.getWriter().print("<script>alert('部门名称重复，修改失败!');history.go(-1);</script>");
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer deptid = Integer.valueOf(request.getParameter("id"));
        DeptService service = new DeptServiceImpl();
        int result = service.deleteDeptById(deptid);
        if (result > 0) {
            response.sendRedirect(request.getContextPath() + "/admin/doDept?op=list");
        } else if (result == 0) {
            response.getWriter().print("<script>alert('删除失败!');history.go(-1);</script>"); // history.go(-1) -1代表回退回去前面的页面
        } else if (result == -1) {
            response.getWriter().print("<script>alert('该部门还有员工，不能删除');history.go(-1);</script>");
        }
    }
}
