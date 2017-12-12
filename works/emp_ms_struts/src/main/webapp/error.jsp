<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Random" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>发生了可爱的错误</title>
</head>
<body>

<h2>亲爱的，我。。。错了。我应该认真学习的！</h2>

<div>
    <img src="/image/smile.jpg" width="200" style="float: left; margin-right: 50px;"/>

    <section>
        <h3>使用 ognl 表达式获取错误</h3>
        <ol>
            <li><s:property value="actionErrors[0]"/></li>
            <li>${exception}</li>
            <li>${actionErrors[0]}</li>
            <li>${fieldErrors.name[0]}</li>
        </ol>
    </section>

    <section>
        <h3>使用 actionError/fieldError 标签</h3>
        <p><s:actionerror/></p>
        <p><s:fielderror name="name"/></p>
    </section>


</div>

<a href="/index.jsp">惦记我返回首页哦   </a><%= new Random().nextInt() %>

<p>
    <s:debug/>
</p>
</body>
</html>
