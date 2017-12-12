<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
    <title>员工列表</title>
    <style>

        * {
            box-sizing: border-box;
        }

        .searchBanner {
            width: 75%;
            margin-bottom: 2em;
            display: flex;
            justify-content: space-between;
        }

        .list {
            width: 75%;
        }

        .list, .list th, .list td {
            border: 1px solid gray;
            border-collapse: collapse;
            padding: 2px 10px;
        }

        .list thead {
            background: gold;
        }

        .list tbody tr:nth-child(even) {
            background: lightyellow;
        }

        .addForm {
            position: fixed;
            right: 1em;
            bottom: 1em;
            padding: 10px 20px 10px 20px;
            background: white;
            box-shadow: 0 0 3px #999, 0 0 6px #6a6;
        }

        .addForm input, .addForm select {
            border: 0;
            width: 95%;
            margin-bottom: 10px;
            box-shadow: 1px 1px 3px grey;
            padding: 5px 10px;
        }

        .addForm input[type='submit'] {
            margin-top: 20px;
            width: 100%;
        }

    </style>

    <script>
        function confirmDel() {
            if (!window.confirm("是否删除?")) {
                event.preventDefault();
            }
        }

    </script>

    <%--增加 hibernate 内置的一些样式--%>
    <s:head />
</head>
<body>

<div>

    <h2><a href="/emp/emplist.php">所有员工</a></h2>

    <%--搜索栏--%>
    <div class="searchBanner">
        <form action="/emp/emplist.php">
            <input name="name" placeholder="请输入姓名..." size="10"/>
            <input type="submit" value="模糊查询"/>
        </form>

        <form action="/emp/emplist.php">
            <label>姓名
                <input name="ename" size="10"/>
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
    <table class="list">
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
            <s:iterator value="#request.emps" var="e" status="s">
                <tr>
                    <td>${s.index + 1}</td>
                    <td>${e.empno}</td>
                    <td><a href="/emp/empinfo.php?empno=${e.empno}">${e.name}</a></td>
                    <td>${e.salary}</td>
                    <td><a href="/dept/deptinfo.php?deptno=${e.department.deptno}">${e.department.name}</a></td>
                    <td><a onclick="confirmDel();" href="/emp/empdel.php?empno=${e.empno}">删除</a></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <%--员工信息表单结束--%>

</div>


<%-- 增加员工表单开始 --%>
<div class="addForm">
    <s:form action="empsave" namespace="/emp" method="POST">
        <s:textfield name="name" label="用户名字" />
        <s:select name="department.deptno" list="#request.depts" listKey="deptno" listValue="name" label="部门" />
        <s:textfield name="salary" label="工资" type="number" maxlength="5" />
        <s:textfield name="hireDate" label="雇佣日期" type="date" />
        <s:submit value="提交" />
    </s:form>
</div>
<%-- 增加员工表单结束 --%>


<div style="margin-top: 30px;">
    <table id="xxxx" style="background: black; color: gold; padding: 10px 30px;">
        <tr><td>点我，点我，快点我</td></tr>
    </table>
</div>


<script>

    function clickmenow() {
        let xhr = new XMLHttpRequest();
        xhr.open("GET", "/emp/json.php", true);
        xhr.onreadystatechange = function () {
            if(xhr.readyState === 4) {
                document.querySelector("#xxxx").innerHTML = JSON.parse(xhr.responseText).map(function (e) {
                    return "<tr><td>" + e.name + "</td><td>" + e.salary + "</td></tr>";
                }).join("\n");
            }
        };
        xhr.send();
    }

    document.getElementById("xxxx").addEventListener("click", clickmenow);

</script>

</body>
</html>
