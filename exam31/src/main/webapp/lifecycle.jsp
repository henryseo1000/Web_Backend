<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/2/24
  Time: 3:18 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Lifecycle | HJ</title>
</head>
<body>
    Hello JSP! I'm here to check what happens if I call you!

    <%--실행시켜 페이지에 들어가는 순간과 새로고침 하는 순간 계속 jspService()가 콘솔창에 뜨는 것을 확인할 수 있다.--%>
    <%--<% %>만 사용하면 서블릿의 Service() 메소드 내에만 코드가 추가듼다.--%>
    <%
        System.out.println("jspService() 호출됨");
    %>

    <%--<%! %>를 사용하면 서블릿의 Service() 메소드 바깥에 코드가 추가듼다.(메소드 선언 등이 가능)--%>
    <%!
        public void jspInit(){
            System.out.println("jspInit() 호출됨");
        }

        public void jspDestroy(){
            System.out.println("jspDestroy() 호출됨");
        }
    %>
</body>
</html>
