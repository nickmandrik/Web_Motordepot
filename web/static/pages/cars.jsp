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
            <c:param name="command" value="get_cars"/>
        </c:url>">Автомобили</a>
        <%@include file="util/header.jsp" %>
    </div>
</nav>

<c:if test="${isDefectives == false}">
    <div class="container">
        <div class="panel panel-body">
            <button type="button" class="btn btn-toolbar" data-toggle="modal" data-target="#myModal">
                Вывести автомобили на ремонте
            </button>
        </div>
    </div>
</c:if>

<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <div style="font-size: 20px" class="glyphicon glyphicon-modal-window fa-4x">
            </div>
            <span style="display:inline-block; width: 10px;"></span>
            <c:if test="${isDefectives == true}">
                <font size="5px">Список автомобилей на ремонте</font>
            </c:if>
            <c:if test="${isDefectives == false}">
                <font size="5px">Список автомобилей</font>
            </c:if>
        </div>

        <!-- Table -->
        <table class="table table-striped">
            <tr>
                <th class="text-center">Идентификатор</th>
                <th class="text-center">Номер</th>
                <th class="text-center">Модель</th>
                <th class="text-center">Стоит на ремонте</th>
                <th class="text-center">Вместимость, чел</th>
                <th class="text-center">Макс груз, кг</th>
            </tr>

            <c:forEach var="car" items="${cars}" varStatus="ind">

                <tr>
                    <td class="text-center"><c:out value="${car.id}"/></td>
                    <td class="text-center"><c:out value="${car.number}"/></td>
                    <td class="text-center"><c:out value="${car.model}"/></td>
                    <td class="text-center">
                            <a type="button" class="btn btn-default" href="<c:url value="/serv">
                                <c:param name="command" value="set_defective_on_car"/>
                                <c:param name="car_id" value="${car.id}"/>
                            </c:url>">
                            <c:if test="${car.defective == true}">
                                <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                            </c:if>
                            <c:if test="${car.defective == false}">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                            </c:if>
                            </a>
                    </td>
                    <td class="text-center"><c:out value="${car.maxPassangers}"/></td>
                    <td class="text-center"><c:out value="${car.capacity}"/></td>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Вы желаете вывести список автомобилей, находящихся на ремонте?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <a href="<c:url value="/serv">
                            <c:param name="command" value="get_defective_cars"/>
                        </c:url>"
                   type="button" class="btn btn-success">Да</a>
            </div>
        </div>
    </div>
</div>



<!--
<!%@include file="util/footer.jsp" %>
-->

</body>
</html>