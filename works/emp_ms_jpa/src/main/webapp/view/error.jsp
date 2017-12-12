<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>出错页面</title>
</head>
<body>
<div>
    <h1>出错了。。。。。</h1>
    <div>
        <pre style="background: lightyellow;">
            <%
                out.print(request.getAttribute("error"));
            %>
        </pre>
    </div>
    <div>
        <a href="/all">返回首页</a>
    </div>
</div>
</body>
</html>
