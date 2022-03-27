<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 12.03.2022
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <link rel="stylesheet" href="css/style.css">
    <title>$Title$</title>
  </head>
  <body>
    <h1>Task07xml</h1>
    <form class="parser_form" name="parserForm" action="controller" method="POST" enctype="multipart/form-data">
      <div class="parser_inputs">
        <input class="button_parser" type="submit" name="command" value="PARSE_DOM">
        <input class="button_parser" type="submit" name="command" value="PARSE_SAX">
        <input class="button_parser" type="submit" name="command" value="PARSE_STAX">
      </div>
      <div class="input_file">
        <input type="file" class="choice_file" name="file" accept=".xml" readonly>
      </div>
    </form>
  </body>
</html>
