<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/2/24
  Time: 2:28 AM
  To change this template use File | Settings | File Templates.
--%>

<%--이 페이지에서 자바 언어로 된 코드 부분이 나올 것이라고 알려주는 지시문--%>
<%--jsp는 서블릿으로 바뀌어 실행되고, lifecycle도 servlet과 동일하다.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Hello JSP! | HJ</title>
</head>
<body>
    <%
        int total = 0;
        for(int i = 0; i <= 10; i ++){
            total = total + i;
        }
    %>

    <%-- <%=%>는 out.print와 같은 역할이다. --%>
    1~10까지의 합은 : <%= total %>
</body>
</html>
