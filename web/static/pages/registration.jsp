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
    <title>Registration</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <span class="glyphicon glyphicon-home"></span>
            <a class="navbar-brand" href="<c:url value="/serv">
                <c:param name="command" value="registration"/>
            </c:url>">Регистрация</a>
        </a>
        <%@include file="util/header.jsp" %>
    </div>
</nav>

<div class="container">
    <blockquote class="blockquote-reverse">
        <p>Доставят быстро и дешево. Лучшая автобаза!</p>
        <footer>Проверено временем</footer>
    </blockquote>

    <div class="col-md-4 col-md-offset-4">
        <form name="addUser" method="post" action="/motordepot_ejb_servlet/serv">
            <input type="hidden" name="command" value="add_user">
            <div class="form-group">
                <label for="InputLogin">Логин</label>
                <input type="text" class="form-control" id="InputLogin" placeholder="Login" name="login">
            </div>

            <c:if test="${errors.login != null}">
                <c:forEach items="${errors.login}" var="logEr">
                    <div class="alert-box">
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                                ${logEr}
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <div class="form-group">
                <label for="InputPassword">Пароль</label>
                <input type="password" class="form-control" id="InputPassword" placeholder="Password" name="pass">
            </div>

            <c:if test="${errors.pass != null}">
                <c:forEach items="${errors.pass}" var="passEr">
                    <div class="alert-box">
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                                ${passEr}
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <div class="form-group">
                <label for="InputRole">Роль</label>
                <select class="form-control" id="InputRole" name="role">
                    <option>user</option>
                    <option>admin</option>
                </select>
            </div>

            <c:if test="${errors.role != null}">
                <c:forEach items="${errors.role}" var="roleEr">
                    <div class="alert-box">
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                                ${roleEr}
                        </div>
                    </div>
                </c:forEach>
            </c:if>

            <c:if test="${errok != null}">
                <div class="alert-box">
                    <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Ошибка:</span>
                            ${errok}
                    </div>
                </div>
            </c:if>

            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </form>
    </div>
</div>

<%@include file="util/footer.jsp" %>

</body>
</html>
