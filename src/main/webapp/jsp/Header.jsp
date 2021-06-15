<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: zhassulan
  Date: 5/13/21
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%String lang = (String) session.getAttribute("lang");%>
<fmt:setLocale value="<%=lang%>" />
<fmt:setBundle basename="Language_Language" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
    <title>Document</title>
</head>

<body>
    <%
        User user = (User) session.getAttribute("user");
        boolean userLoggedIn = user != null;
    %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a class="navbar-brand" href="/main">BS</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="/main"><fmt:message key="label.button.name"/></a>
                </li>
                <%
                    if(userLoggedIn){
                %>
                    <%if(user.getRoleId() == 1){%>
                <li class="nav-item">
                    <a class="nav-link" href="/orders"><fmt:message key="label.button.orders"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/basket"><fmt:message key="label.button.basket"/></a>
                </li>
                <%}else{ %>
                <li class="nav-item">
                    <a class="nav-link" href="/addbook"><fmt:message key="label.button.addbook"/></a>
                </li>
                <%} %>
                <li class="nav-item">
                    <a class="nav-link" href="/profile"><fmt:message key="label.button.profile"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout"><fmt:message key="label.button.logout"/></a>
                </li>
                <%}else{ %>
                <li class="nav-item">
                    <a class="nav-link" href="/login"><fmt:message key="label.button.login"/></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/signup"><fmt:message key="label.button.signup"/></a>
                </li>
                <%} %>
            </ul>
        </div>

<%--        <form class="form-inline" action="/language" method="post">--%>
<%--            <div class="nav-item dropdown">--%>
<%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                    <fmt:message key="label.button.language"/>--%>
<%--                </a>--%>
<%--                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" onchange="this.form.submit()">--%>
<%--                    <a class="dropdown-item" name="lang" value="en">English</a>--%>
<%--                    <a class="dropdown-item" name="lang" value="ru">Русский</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </form>--%>

        <form class="form-inline" action="/language" method="post">
            <select data-style="btn-info" name="lang" onchange="this.form.submit()">
                <option selected><fmt:message key="label.button.language"/></option>
                <option value="en" >English</option>
                <option value="ru" >Русский</option>
            </select>
        </form>

    </div>
</nav>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body></html>
