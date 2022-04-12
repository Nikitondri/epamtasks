<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 02.04.2022
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sass/style.css">
    <title>Food</title>
</head>
<body>
    <jsp:include page="templates/header.jsp"/>

    <section class="food_info">
        <div class="container">
            <div class="food_info_wrapper">
                <img class="food_info_img" src="<c:out value="${dish.picturePath}"/>" alt="#">
                <div class="food_description">
                    <div class="food_info_title"><c:out value="${dish.name}"/></div>
                    <div class="food_details">cost: <c:out value="${dish.cost}"/>$</div>
                    <div class="food_details">type: <c:out value="${dish.type.name}"/></div>
                    <div class="food_details">weight: <c:out value="${dish.weight}"/></div>
                    <div class="food_details"><c:out value="${dish.description}"/></div>
                </div>
            </div>
        </div>
    </section>
    <div class="divider"></div>
    <section class="food_reviews">
        <div class="container">
            <div class="food_review_wrapper">
                <c:forEach items="${reviews}" var="review">
                    <div class="food_review">
                        <div class="person_info">
                            <div class="person_name">name</div>
                            <div class="review_date"><c:out value="${review.createDate}"/></div>
                        </div>
                        <div class="food_review_text">
                            <c:out value="${review.text}"/>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="input_review">
                <div class="input_review_title">Your review</div>
                <form action="controller">
                    <textarea class="input_text_review" placeholder="Your review"></textarea>
                    <button class="button_review" type="submit">send</button>
                </form>
            </div>
        </div>
    </section>

    <jsp:include page="templates/footer.jsp"/>
</body>
</html>
