<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 20.03.2022
  Time: 00:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Reviews</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>Review id</td>

            <td>Dish name</td>
            <td>cost</td>
            <td>type</td>
            <td>isEnable</td>
            <td>weight</td>
            <td>description</td>
            <td>picturePath</td>

            <td>userId</td>
            <td>login</td>
            <td>password</td>
            <td>role</td>
            <td>status</td>

            <td>parentId</td>
            <td>text</td>
            <td>date</td>
        </tr>
        <c:forEach items="${reviews}" var="review">
            <tr>
                <td><c:out value="${review.id}"/></td>
                <td><c:out value="${review.dish.name}"/></td>

                <td><c:out value="${review.dish.cost}"/></td>
                <td><c:out value="${review.dish.typeId.name}"/></td>
                <td><c:out value="${review.dish.isEnable}"/></td>
                <td><c:out value="${review.dish.weight}"/></td>
                <td><c:out value="${review.dish.description}"/></td>
                <td><c:out value="${review.dish.picturePath}"/></td>

                <td><c:out value="${review.user.id}"/></td>
                <td><c:out value="${review.user.login}"/></td>
                <td><c:out value="${review.user.password}"/></td>
                <td><c:out value="${review.user.role}"/></td>
                <td><c:out value="${review.user.status}"/></td>

                <td><c:out value="${review.parent.id}"/></td>
                <td><c:out value="${review.text}"/></td>
                <td><c:out value="${review.dateTime}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
