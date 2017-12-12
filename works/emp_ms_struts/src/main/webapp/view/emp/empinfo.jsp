<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>员工信息</title>
</head>
<body>

<a href="/emp/emplist.php">返回首页</a>

<table>
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>工资</td>
        <td>部门</td>
    </tr>
    <s:iterator value="#request.info" var="e" status="s">
        <tr>
            <td>${s.index}</td>
            <td>${e.name}</td>
            <td>${e.salary}</td>
            <td>${e.department.name}</td>
        </tr>
    </s:iterator>
</table>

</body>
</html>