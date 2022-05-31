<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 12.04.2022
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${language}" scope="session"/>
<fmt:setBundle basename="language.ui"/>


<html>
<head>
    <title>User info</title>
</head>
<body>
<jsp:include page="templates/header.jsp"/>

    <h1 class="user_info_title"><fmt:message key="USER_INFO_TITLE"/></h1>
    <div class="divider"></div>
    <section class="section_user_info">
        <div class="container">
            <div class="user_info_wrapper">
                <div class="user_info_item">
                    <div class="user_info_param">text</div>
                    <div class="user_info_text">text</div>
                </div>
                <div class="user_info_divider"></div>
                <div class="user_info_item">
                    <div class="user_info_param">text</div>
                    <div class="user_info_text">text</div>
                </div>
                <div class="user_info_divider"></div>
                <div class="user_info_item">
                    <div class="user_info_param">text</div>
                    <div class="user_info_text">text</div>
                </div>
                <div class="user_info_divider"></div>
            </div>
        </div>
    </section>

    <div class="sections_money_stat">
        <section class="section_user_money">

        </section>
        <section class="section_user_stat">

        </section>
    </div>

<jsp:include page="templates/footer.jsp"/>
</body>
</html>
