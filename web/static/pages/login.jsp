<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.css">


    <link rel="stylesheet" href="static/css/merge.css">
    <script src="static/bootstrap/js/jquery.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <script src="static/js/index.js"></script>
    <title>Login</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <span class="glyphicon glyphicon-home"></span>
            <a class="navbar-brand" href="<c:url value="/serv">
                <c:param name="command" value="login"/>
            </c:url>">Вход</a>
        </a>
        <%@include file="util/header.jsp" %>
    </div>
</nav>

<div class="container">
    <blockquote class="blockquote-reverse">
        <p>Войдите для продолжения</p>
    </blockquote>

    <div class="col-md-4 col-md-offset-4">
        <form name="login" action="/motordepot_ejb_servlet/serv" method="post">
            <input type="hidden" name="command" value="login">
            <div class="form-group">
                <label for="InputLogin">Логин</label>
                <input name="login" type="text" class="form-control" id="InputLogin" placeholder="Login">
            </div>
            <div class="form-group">
                <label for="InputPassword">Пароль</label>
                <input name="password" type="password" class="form-control" id="InputPassword" placeholder="Password">
            </div>

            <c:if test="${error != null}">
                <div class="alert-box">
                    <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Ошибка:</span>
                            ${error}
                    </div>
                </div>
            </c:if>
            <button type="submit" class="btn btn-primary">Войти</button>
        </form>
    </div>
</div>

<%@include file="util/footer.jsp" %>

</body>
</html>
