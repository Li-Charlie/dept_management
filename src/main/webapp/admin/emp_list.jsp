<%@ page import="crmsys1111.pojo.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: charlieli
  Date: 2020/11/15
  Time: 2:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工</title>
</head>
<body>
<h3>员工管理</h3><br>
<a href="${pageContext.request.contextPath}/admin/doEmp?op=toAdd">添加</a>
<table>
    <tr>
        <td>姓名</td>
        <td>部门</td>
        <td>邮箱</td>
        <td>电话</td>
        <td>薪资</td>
        <td>操作</td>
    </tr>
    <%  List<Emp> emps = (List<Emp>) request.getAttribute("emps");
        for (Emp emp:emps){
    %>
    <tr>
        <td><%=emp.getEmpname()%></td>
        <td><%=emp.getDept().getDeptname()%></td>
        <td><%=emp.getEmail()%></td>
        <td><%=emp.getTel()%></td>
        <td><%=emp.getSalary()%></td>
        <td>
            <a href="${pageContext.request.contextPath}/admin/doEmp?op=toEdit&id=<%=emp.getEmpid()%>">修改</a>
            <a href="${pageContext.request.contextPath}/admin/doEmp?op=del&id=<%=emp.getEmpid()%>" onclick="return confirm('是否删除？')">删除</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>