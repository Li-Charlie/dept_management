<%--
  Created by IntelliJ IDEA.
  User: Charlie
  Date: 2020/11/9
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<h3>部门信息录入</h3>
<form name="frmadd" method="post" action="<%=request.getContextPath()%>/admin/doDept?op=doAdd">
    部门名称：<input name="deptname" type="text"/>
    <br>
    部门描述：<textarea name="deptinfo" rows="8" cols="40"></textarea>
    <br>
    <input name="btnadd" type="submit" value="添加"/>
    <input name="btnreset" type="submit" value="重置"/>
</form>
</body>
</html>
