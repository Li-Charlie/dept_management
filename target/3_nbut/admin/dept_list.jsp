<%@ page import="java.util.List" %>
<%@ page import="crmsys1111.pojo.Dept" %><%--
  Created by IntelliJ IDEA.
  User: Charlie
  Date: 2020/11/9
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门</title>
</head>
<body>
    <h3>部门管理</h3>
    <table>
        <tr>
            <td>部门名称</td>
            <td>部门描述</td>
            <td>操作</td>
        </tr>
        <%  List<Dept> depts = (List<Dept>) request.getAttribute("depts");
            for (Dept dept:depts){
                System.out.println("depts = " + depts);
        %>
            <tr>
            <td><%=dept.getDeptname()%></td>
            <td><%=dept.getDeptinfo()%></td>
            <td>
                <a href="${pageContext.request.contextPath}/admin/doDept?op=toEdit&id=<%=dept.getDeptid()%>">修改</a>
                <a href="${pageContext.request.contextPath}/admin/doDept?op=del&id=<%=dept.getDeptid()%>" onclick="return confirm('是否删除？')">删除</a>
            </td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>
