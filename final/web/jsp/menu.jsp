<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Menu</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sass/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sass/style.css">
</head>
<body>
<div class="menu_background">
</div>
<jsp:include page="templates/header.jsp"/>

<section class="menu_section">
    <div class="container">
        <h1 class="menu_section_title">menu</h1>
        <div class="divider"></div>
        <form class="menu_section_types" action="controller">
            <c:forEach items="${dishTypes}" var="dishType">
                <a class="menu_section_type" href="${pageContext.request.contextPath}/controller?command=SHOW_DISHES&id=${dishType.id}">
                    <c:out value="${dishType.name}"/>
                </a>
            </c:forEach>
        </form>

        <div class="menu_section_items">
            <c:forEach items="${dishes}" var="dish">
                <div class="menu_section_item">
                    <a href="${pageContext.request.contextPath}/controller?command=GO_TO_DISH_INFO&id=${dish.id}" class="menu_section_link">
                        <img src="<c:out value="${dish.picturePath}"/>" alt="<c:out value="${dish.name}"/> " class="menu_section_img">
                        <p class="menu_section_text"><c:out value="${dish.name}"/></p>
                        <input class="menu_section_button" type="submit" value="ADD">
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</section>

<jsp:include page="templates/footer.jsp"/>
</body>
</html>
