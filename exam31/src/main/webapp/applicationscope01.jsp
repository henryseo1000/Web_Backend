<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/6/24
  Time: 7:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Application Scope Test</title>

    <%
        try{
            int value = (int)application.getAttribute("value") + 2;
            application.setAttribute("value", value);

    %>

    <h1><%= value %></h1>

    <%
        } catch(NullPointerException e) {
    %>
        <h1>value가 설정되지 않았습니다.</h1>
    <%
        }
    %>

</head>
<body>

</body>
</html>
