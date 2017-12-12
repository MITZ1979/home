<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>部门信息</title>
</head>
<body>

<h3>部门介绍</h3>
<ul>
    <li>名称: <s:property value="#request.dept.name" /></li>
    <li>地址: <s:property value="#request.dept.location" /></li>
</ul>

<h3>部门员工</h3>
<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>工资</td>
        <td>部门</td>
    </tr>
    <s:iterator value="#request.dept.employees" var="e" status="s">
        <tr>
            <td>${s.index}</td>
            <td><a href="/emp/empinfo.php?empno=${e.empno}">${e.name}</a></td>
            <td>${e.salary}</td>
            <td>${e.department.name}</td>
        </tr>
    </s:iterator>
</table>

<s:debug />
</body>
</html>
