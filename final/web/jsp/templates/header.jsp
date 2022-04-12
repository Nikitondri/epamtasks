<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 01.04.2022
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sass/style.css">
    <title>Header</title>
</head>
<body>
    <header>
        <nav>
            <div class="container">
                <ul id="main">
                    <a class="menu_item" href="${pageContext.request.contextPath}/jsp/main.jsp"><li>Home</li></a>
                    <a class="menu_item" href="${pageContext.request.contextPath}/jsp/menu.jsp"><li>Menu</li></a>
                    <li class="menu_item">Info
                        <ul class="drop">
                            <div>
                                <a class="menu_drop_item"  href="${pageContext.request.contextPath}/jsp/user_info.jsp">
                                    <li>Info</li>
                                </a>
                                <a class="menu_drop_item" href="#">
                                    <li>Orders</li>
                                </a>
                                <a class="menu_drop_item" href="${pageContext.request.contextPath}/controller?command=SIGN_OUT">
                                    <li>Exit</li>
                                </a>
                            </div>
                        </ul>
                    </li>
                    <div id="marker"></div>
                </ul>
            </div>
        </nav>
    </header>
</body>
</html>
