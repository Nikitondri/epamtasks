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
    <title>Main</title>
</head>
<body>
<div class="background">
    <img src="${pageContext.request.contextPath}/img/background.jpg" alt="background">
</div>

<jsp:include page="templates/header.jsp"/>

<section class="promo">
    <div class="container">
        <img src="${pageContext.request.contextPath}/icon/main_logo.png" alt="logo" class="main_logo">
        <h1 class="main_title">bird pempo</h1>
    </div>
</section>

<section class="food_menu">
    <div class="container">
        <h2>menu</h2>
        <h3>text</h3>
        <div class="divider"></div>
        <div class="food_wrapper">
            <div class="food_item">
                <a href="#" class="food_link">
                    <img src="${pageContext.request.contextPath}/img/pizza.png" alt="" class="food_img">
                    <div class="food_type">pizza</div>
                </a>
            </div>
            <div class="food_item">
                <a href="#" class="food_link">
                    <img src="${pageContext.request.contextPath}/img/pizza.png" alt="" class="food_img">
                    <div class="food_type">type</div>
                </a>
            </div>
            <div class="food_item">
                <a href="#" class="food_link">
                    <img src="${pageContext.request.contextPath}/img/pizza.png" alt="" class="food_img">
                    <div class="food_type">type</div>
                </a>
            </div>
            <div class="food_item">
                <a href="#" class="food_link">
                    <img src="${pageContext.request.contextPath}/img/pizza.png" alt="" class="food_img">
                    <div class="food_type">type</div>
                </a>
            </div>
            <div class="food_item">
                <a href="#" class="food_link">
                    <img src="${pageContext.request.contextPath}/img/pizza.png" alt="" class="food_img">
                    <div class="food_type">type</div>
                </a>
            </div>
            <div class="food_item">
                <a href="#" class="food_link">
                    <img src="${pageContext.request.contextPath}/img/pizza.png" alt="" class="food_img">
                    <div class="food_type">type</div>
                </a>
            </div>
        </div>
        <form class="food_button_link" name="goToMenuForm" action="${pageContext.request.contextPath}/controller" method="POST">
            <button class="food_button" type="submit" name="command" value="GO_TO_MENU">menu...</button>
        </form>
    </div>
</section>

<jsp:include page="templates/footer.jsp"/>
</body>
</html>
