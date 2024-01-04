<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/2/24
  Time: 3:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>How to use inner objects | HJ</title>
</head>
<body>
  <%
    // 분명 선언한 적이 없는데 request 사용 가능 - 내장 객체이기 때문
    StringBuffer url = request.getRequestURL();

    // 분명 선언한 적이 없는데 out 사용 가능 - 내장 객체이기 때문
    out.print("url : " + url);
  %>
</body>
</html>
