<%@ page import="crmsys1111.pojo.Emp" %>
<%@ page import="java.util.List" %>
<%@ page import="crmsys1111.pojo.Dept" %><%--
  Created by IntelliJ IDEA.
  User: charlieli
  Date: 2020/11/13
  Time: 2:11 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加员工</title>
</head>
<body>
<h3>员工信息录入</h3>
<form name="frmadd" method="post" action="<%=request.getContextPath()%>/admin/doEmp?op=doAdd">
    员工姓名：<input name="empname" type="text"/>
    <br>
    邮箱：<input name="email"/>
    <br>
    电话：<input name="tel"/>
    <br>
    薪资：<input name="salary"/>
    <br>
    部门：<select name="deptid">
        <option value="0">请选择</option>
    <%  // 读出现有到部门表信息并显示在下拉框中
        List<Dept> depts = (List<Dept>) request.getAttribute("depts");
        for (Dept dept : depts){
            %>
                <option value="<%=dept.getDeptid()%>">
                    <%=dept.getDeptname()%>
                </option>
            <%
        }
    %>
</select>
    <input name="btnadd" type="submit" value="添加"/>
    <input name="btnreset" type="submit" value="重置"/>
</form>
</body>
</html>
