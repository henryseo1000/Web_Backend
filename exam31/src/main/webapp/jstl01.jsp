<%--
  Created by IntelliJ IDEA.
  User: seohojun
  Date: 1/8/24
  Time: 1:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="firstname" scope="request" value="Seo"/>

<html>
<head>
    <title>JSTL Hello</title>
</head>
<body>
    성: ${firstname}<br>
    <c:remove var="firstname" scope="request"/>
    성: ${firstname}<br>
</body>
</html>
