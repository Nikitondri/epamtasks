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
<header>
    <nav>
        <div class="container">
            <ul id="main">
                <li class="menu_item">Home</li>
                <li class="menu_item">Menu</li>
                <li class="menu_item">Info
                    <ul class="drop">
                        <div>
                            <li class="menu_drop_item">Info</li>
                            <li class="menu_drop_item">Orders</li>
                            <a href="authorization.html"><li class="menu_drop_item">Exit</li></a>
                        </div>
                    </ul>
                </li>
                <div id="marker"></div>
            </ul>
        </div>
    </nav>
</header>

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
                    <a href="#" class="menu_section_link">
                        <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="<c:out value="${dish.name}"/> " class="menu_section_img">
                        <p class="menu_section_text"><c:out value="${dish.name}"/></p>
                        <input class="menu_section_button" type="submit" value="ADD">
                    </a>
                </div>
            </c:forEach>

<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
<%--            <div class="menu_section_item">--%>
<%--                <a href="#" class="menu_section_link">--%>
<%--                    <img src="${pageContext.request.contextPath}/img/burgers/burger.png" alt="" class="menu_section_img">--%>
<%--                    <p class="menu_section_text">BURGER XL</p>--%>
<%--                    <input class="menu_section_button" type="submit" value="ADD">--%>
<%--                </a>--%>
<%--            </div>--%>
        </div>
    </div>
</section>

<footer>
    <div class="container">
        <div class="footer">
            <p class="footer_text">© Copyright @nikitondri 2022, All rights reserved.</p>
            <div class="footer_social">
                <a href="#" class="footer_social_item">
                    <img src="${pageContext.request.contextPath}/icon/Twitter.png" alt="social" class="footer_social_icon">
                </a>
                <a href="#" class="footer_social_item">
                    <img src="${pageContext.request.contextPath}/icon/LinkedIn.png" alt="social" class="footer_social_icon">
                </a>
                <a href="#" class="footer_social_item">
                    <img src="${pageContext.request.contextPath}/icon/Google.png" alt="social" class="footer_social_icon">
                </a>
                <a href="#" class="footer_social_item">
                    <img src="${pageContext.request.contextPath}/icon/Facebook.png" alt="social" class="footer_social_icon">
                </a>
            </div>
        </div>
    </div>
</footer>
</body>
</html>
