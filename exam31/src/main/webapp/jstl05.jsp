<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/12/24
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<c:import url="http://localhost:8080/exam31_war_exploded/jstlValue.jsp" var="urlValue" scope="request"></c:import>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    읽어들인 값 : ${urlValue}
</body>
</html>
