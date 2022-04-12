<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 12.04.2022
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User info</title>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
    <h1>User Info</h1>
    <div>
        <c:out value="${userId}"/>
    </div>
<jsp:include page="templates/footer.jsp"/>
</body>
</html>
