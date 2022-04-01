<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 20.03.2022
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Error</p>
    <p>Status: ${pageContext.errorData.statusCode}</p>
    <p>Request URI: ${pageContext.errorData.requestURI}</p>
    <p>Message: ${errorMessage}</p>
</body>
</html>
