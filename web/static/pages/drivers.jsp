<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap-theme.css">


    <link rel="stylesheet" href="static/css/merge.css">
    <script src="static/bootstrap/js/jquery.min.js"></script>
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
    <script src="static/js/index.js"></script>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home"></span></a>
        <a class="navbar-brand" href="<c:url value="/serv">
            <c:param name="command" value="get_drivers"/>
        </c:url>">Водители</a>
        <%@include file="util/header.jsp" %>
    </div>
</nav>

<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <div style="font-size: 20px" class="glyphicon glyphicon-user fa-4x">
            </div>
            <span style="display:inline-block; width: 10px;"></span>
            <font size="5px">Список водителей</font>
        </div>

        <!-- Table -->
        <table class="table table-striped">
            <tr>
                <th class="text-center">Идентификатор</th>
                <th class="text-center">ФИО</th>
                <th class="text-center">Идентификатор машины</th>
                <th class="text-center"></th>
            </tr>

            <c:forEach var="driver" items="${drivers}" varStatus="ind">

                <tr>
                    <td class="text-center"><c:out value="${driver.id}"/></td>
                    <td class="text-center"><c:out value="${driver.fio}"/></td>
                    <td class="text-center"><c:out value="${driver.car.id}"/></td>
                    <td class="text-center">
                        <a href="<c:url value="/serv">
                                    <c:param name="command" value="get_passages_by_driver"/>
                                    <c:param name="driver_id" value="${driver.id}"/>
                                </c:url>">
                            <span class="glyphicon glyphicon-info-sign"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>

</body>
</html>