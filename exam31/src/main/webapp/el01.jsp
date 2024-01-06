<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/6/24
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    pageContext.setAttribute("p1", "page scope value");
    request.setAttribute("r1", "request scope value");
    session.setAttribute("s1", "session scope value");
    application.setAttribute("a1", "application scope value");
%>
<html>
<head>
    <title>EL Test Page</title>
</head>
<body>
    pageContext.getAttribute("p1") : ${pageScope.p1}<br>
    request.getAttribute("r1") : ${requestScope.r1}<br>
    session.getAttribute("s1") : ${sessionScope.s1}<br>
    application.getAttribute("a1") : ${applicationScope.a1}<br>
    <br><br>

<%--    변수들의 이름이 겹치지 않는다는 가정 하에 아래와 같이 쓰는 것도 가능하다.--%>
    pageContext.getAttribute("p1") : ${p1}<br>
    request.getAttribute("r1") : ${r1}<br>
    session.getAttribute("s1") : ${s1}<br>
    application.getAttribute("a1") : ${a1}<br>
</body>
</html>
