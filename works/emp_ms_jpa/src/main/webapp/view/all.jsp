<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title>员工列表</title>
    <style>

        * {
            box-sizing: border-box;
        }

        .searchBanner {
            width: 60%;
            margin-bottom: 2em;
            display: flex;
            justify-content: space-between;
        }

        table {
            width: 60%;
        }

        table, th, td {
            border: 1px solid gray;
            border-collapse: collapse;
            padding: 2px 10px;
        }

        thead {
            background: gold;
        }

        tbody tr:nth-child(even) {
            background: lightyellow;
        }

        .addForm {
            position: fixed;
            right: 2em;
            bottom: 2em;
            padding: 10px 20px 10px 20px;
            border: 1px solid lightgrey;
        }

        .addForm label {
            display: flex;
            justify-content: space-between;
        }

        .addForm input, .addForm select {
            border: 0;
            width: 65%;
            margin-bottom: 10px;
            box-shadow: 1px 1px 3px grey;
            padding: 5px 10px;
        }

        .addForm input[type='submit'] {
            margin-top: 20px;
            width: 100%;
        }

        .warn {
            padding: 6px;
            background: lightpink;
            border: 1px darkred;
            border-radius: 3px;
            margin: 10px 0;
        }

    </style>

    <script>
        function confirmDel() {
            if (!window.confirm("是否删除?")) {
                event.preventDefault();
            }
        }
    </script>
</head>
<body>

<div>

    <h2><a href="/all">所有员工</a></h2>

    <%--搜索栏--%>
    <div class="searchBanner">
        <form action="/all">
            <input name="ename1" placeholder="请输入姓名..." size="10"/>
            <input type="submit" value="模糊查询"/>
        </form>

        <form action="/all">
            <label>姓名
                <input name="ename2" size="10"/>
            </label>
            <label>工资
                <input name="lowsal" size="5">
            </label>
            <label> -&gt;
                <input name="hisal" size="5">
            </label>

            <input type="submit" value="组合查询"/>
        </form>
    </div>
    <%--搜索栏结束--%>


    <%--员工信息表单--%>
    <table>
        <thead>
            <tr>
                <th>序号</th>
                <th>员工编号</th>
                <th>员工姓名</th>
                <th>员工工资</th>
                <th>员工部门</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${emps}" var="e" varStatus="s">
                <tr>
                    <td>${s.index + 1}</td>
                    <td>${e.empno}</td>
                    <td><a href="/emp?empno=${e.empno}">${e.name}</a></td>
                    <td>${e.salary}</td>
                    <td><a href="/dept?deptno=${e.department.deptno}">${e.department.name}</a></td>
                    <td><a onclick="confirmDel();" href="/empdel?empno=${e.empno}">删除</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%--员工信息表单结束--%>

</div>


<%-- 增加员工表单开始 --%>
<form action="/empadd" method="post">
    <div class="addForm">
        <%--验证提示信息--%>
        <c:if test="${empadd_msg != null}">
            <div class="warn">${empadd_msg}</div>
        </c:if>

        <label>员工姓名
            <input id="ename" name="ename" maxlength="10" required="required"/>
        </label>

        <label>部门
            <select name="deptno" required>
                <c:forEach items="${depts}" var="d">
                    <option value="${d.deptno}">${d.name}</option>
                </c:forEach>
            </select>
        </label>

        <label>工资
            <input name="sal" type="number" max="50000" />
        </label>

        <label>入职日期
            <input name="hire_date" type="date" />
        </label>

        <input type="submit"/>
    </div>
</form>
<%-- 增加员工表单结束 --%>


</body>
</html>
