<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/13/24
  Time: 2:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <c:set var="t" value="<script type='text/javascript'>alert(hello);</script>" />
    ${t}
<%--    그냥 단순한 글로써 동작한다.--%>
    <c:out value="${t}" escapeXml="true" />
<%--    자바스크립트 코드로써 동작한다.--%>
    <c:out value="${t}" escapeXml="false" />
</body>
</html>
