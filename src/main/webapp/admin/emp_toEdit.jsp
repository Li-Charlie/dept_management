<%@ page import="crmsys1111.pojo.Emp" %>
<%@ page import="crmsys1111.pojo.Dept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: charlieli
  Date: 2020/11/15
  Time: 2:46 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息修改</title>
</head>
<body>
<%
    Emp emp = (Emp) request.getAttribute("emp");
%>
<h3>员工信息修改</h3>
<form name="frmadd" method="post" action="<%=request.getContextPath()%>/admin/doEmp?op=doEdit">
    <%--   这里加上 empid 隐式传送 --%>
    <input name="empid" type="hidden" value="<%=emp.getEmpid()%>">
    姓名：<input name="empname" type="text" value="<%=emp.getEmpname()%>"/>
    <br>
    邮箱：<input name="email" type="text" value="<%=emp.getEmail()%>"/>
    <br>
    电话：<input name="tel" type="text" value="<%=emp.getTel()%>"/>
    <br>
    薪资：<input name="salary" type="text" value="<%=emp.getSalary()%>"/>
    <br>
        部门：<select name="deptid">
<%--        <option value="<%=emp.getDept().getDeptid()%>">隶属于：（<%=emp.getDept().getDeptname()%>）</option>--%>
        <%
            // 读出现有到部门表信息并显示在下拉框中
        List<Dept> depts = (List<Dept>) request.getAttribute("depts");
        for (Dept dept : depts) {
            if (dept.getDeptid().equals(emp.getDept().getDeptid())) {
        %>
        <option value="<%=dept.getDeptid()%>" selected="selected">
            <%=dept.getDeptname()%>
        </option>
        <%  } else { %>
        <option value="<%=dept.getDeptid()%>">
            <%=dept.getDeptname()%>
        </option>
        <%  }
        } %>
        </select>
        <br>
    <input name="btnadd" type="submit" value="修改"/>
    <input name="btnreset" type="submit" value="重置"/>
</form>
</body>
</html>
