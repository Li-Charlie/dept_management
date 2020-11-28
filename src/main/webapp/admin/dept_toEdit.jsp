<%@ page import="crmsys1111.pojo.Dept" %><%--
  Created by IntelliJ IDEA.
  User: charlieli
  Date: 2020/11/12
  Time: 9:28 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>部门信息修改</title>
</head>
<body>
<%
    Dept dept = (Dept) request.getAttribute("dept");
%>
<h3>部门信息修改</h3>
<form name="frmadd" method="post" action="<%=request.getContextPath()%>/admin/doDept?op=doEdit">
    <%--   这里加上 deptid 隐式传送 --%>
    <input name="deptid" type="hidden" value="<%=dept.getDeptid()%>">
    部门名称：<input name="deptname" type="text" value="<%=dept.getDeptname()%>"/>
    <br>
    部门描述：<textarea name="deptinfo" rows="8" cols="40"><%=dept.getDeptinfo()%></textarea>
    <br>
    <input name="btnadd" type="submit" value="修改"/>
    <input name="btnreset" type="submit" value="重置"/>
</form>
</body>
</html>
