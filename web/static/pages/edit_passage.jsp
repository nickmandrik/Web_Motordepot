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
    <title>Edit passage</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">
            <span class="glyphicon glyphicon-home"></span>
            <a class="navbar-brand" href="<c:url value="/serv">
                <c:param name="command" value="edit_passage"/>
            </c:url>">Изменение рейса</a>
        </a>
        <%@include file="util/header.jsp" %>
    </div>
</nav>


<div class="container">

    <div class="col-md-4 col-md-offset-4">
        <form name="login" action="/motordepot_ejb_servlet/serv" method="post">
            <input type="hidden" name="command" value="update_passage">
            <input type="hidden" name="_method" value="get">
            <input type="hidden" name="passage_id" value="${passage.id}">
            <div class="form-group">
                <label for="id_driver">Идентификатор водителя</label>
                <input type="number" class="form-control" id="id_driver"
                       name="driver_id" value="${passage.driver.id}">
            </div>

            <div class="form-group">
                <label for="is_made">Совершен</label>
                <span class="input-group-addon" style="width:0px; padding-left:0px;
                        padding-right:0px; border:none;"></span>
                <c:if test="${passage.isMade == false}">
                    <select class="form-control" id="is_made" name="made_is">
                        <option>No</option>
                        <option>Yes</option>
                    </select>
                </c:if>
                <c:if test="${passage.isMade == true}">
                    <select class="form-control" id="is_made" name="made_is">
                        <option>Yes</option>
                        <option>No</option>
                    </select>
                </c:if>
            </div>

            <button type="submit" class="btn btn-primary">Изменить рейс</button>
        </form>
    </div>
</div>

<%@include file="util/footer.jsp" %>

</body>
</html>