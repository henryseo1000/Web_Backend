<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/6/24
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--EL 문법을 무시하고 싶은 경우 아래 주석을 해제하면 된다.--%>
<%--<%@ page isELIgnored="true" %>--%>

<%
    request.setAttribute("k", 10);
    request.setAttribute("m", true);
%>
<html>
<head>
    <title>EL Test Page</title>
</head>
<body>
    k : ${k} <br>
    k + 5 : ${k + 5} <br>
    k - 5 : ${k - 5} <br>
    k * 5 : ${k * 5} <br>
    k / 5 : ${k div 5} <br>
    k : ${k}<br>
    m : ${m}<br>
    k > 5 : ${k > 5} <br>
    k < 5 : ${k < 5} <br>
    k <= 10 : ${k <= 10} <br>
    k >= 10 : ${k >= 10} <br>
    m : ${m} <br>
    !m : ${!m} <br>
</body>
</html>
