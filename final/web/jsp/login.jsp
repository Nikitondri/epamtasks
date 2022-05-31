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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sass/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/sass/style.css">
    <script src="${pageContext.request.contextPath}/script/login.js"></script>
    <title>Authorization</title>
</head>
<body>
    <div class="authorization_background">
        <img src="${pageContext.request.contextPath}/img/background.jpg" alt="back">
    </div>
    <section class="enter">
        <h1 class="enter_title">Welcome to pempo bird</h1>
        <div class="divider"></div>
        <div class="enter_choice">
            <div class="enter_buttons">
                <input type="checkbox" id="clickLogin">
                <label for="clickLogin" class="clickLogin">login</label>
                <input type="checkbox" id="clickRegister">
                <label for="clickRegister" class="clickRegister">register</label>
                <div class="error_message"><c:out value="${error}"/></div>

                <div class="modal_login">
                    <label for="clickLogin" id="times"><img src="${pageContext.request.contextPath}/icon/back.svg" alt="back"></label>
                    <h2 class="login_title">Login</h2>
                    <div class="divider"></div>
                    <form class="login_form" action="${pageContext.request.contextPath}/controller" method="post">
                        <label class="login_label" for="username">Username</label>
                            <input class="login_input" name="login" type="text" placeholder="Email or Phone" id="username">

                        <label class="login_label" for="password">Password</label>
                            <input class="login_input"
                                   name="password"
                                   type="password"
                                   placeholder="Password"
                                   id="password"
                                   pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                                   title="Password must be 8 characters or more, consisting of at least one number and one uppercase and lowercase letter"
                            >
                        <button class="login_button" type="submit" name="command" value="SIGN_IN">Log In</button>
                    </form>
                </div>

                <div class="modal_register">
                    <label for="clickRegister" id="timesRegister"><img src="${pageContext.request.contextPath}/icon/back.svg" alt="back"></label>
                    <h2 class="login_title">Register</h2>
                    <div class="divider"></div>
                    <form class="register_form" action="${pageContext.request.contextPath}/controller" method="post">
                        <label class="login_label" for="username">Username</label>
                        <input class="login_input" name="login" type="text" placeholder="Email or Phone" id="usernameRegister">

                        <label class="login_label" for="password">Password</label>
                        <input class="login_input"
                               name="password"
                               type="password"
                               onkeyup='check();'
                               placeholder="Password"
                               id="passwordRegister"
                               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                               title="Password must be 8 characters or more, consisting of at least one number and one uppercase and lowercase letter"
                        >
                        <label class="login_label" for="password">Repeat password</label>
                        <input class="login_input"
                               onkeyup='check();'
                               name="repeatPassword"
                               type="password"
                               placeholder="Repeat password"
                               pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                               id="passwordRepeat"
                        >
                        <span id='message'></span>
                        <button id="registerButton" class="login_button" type="submit" name="command" value="SIGN_UP">Sign Up</button>
                    </form>
                </div>

            </div>

            <img class="enter_logo_img" src="${pageContext.request.contextPath}/icon/main_logo.png" alt="main logo"/>
        </div>
    </section>

</body>
</html>