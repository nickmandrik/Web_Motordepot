<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/admineditorpassagestag" prefix="adm" %>
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
            <c:param name="command" value="get_passages"/>
        </c:url>">Рейсы</a>
        <%@include file="util/header.jsp" %>
    </div>
</nav>


    <div class="container">
        <div class="panel panel-body">
            <button type="button" class="btn btn-toolbar" data-toggle="modal" data-target="#myModal">
                Добавить рейс
            </button>
            <p></p>
            <c:if test="${editPassage != null}">
                <div class="alert-box">
                    <c:if test="${isError == true}">
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Ошибка:</span>
                                ${editPassage}
                        </div>
                    </c:if>
                    <c:if test="${isError == false}">
                        <div class="alert alert-success" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Инфо:</span>
                                ${editPassage}
                        </div>
                    </c:if>
                </div>
            </c:if>
        </div>
    </div>


<div class="container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <!-- div class="center-children" -->
                <div style="font-size: 20px" class="glyphicon glyphicon-align-justify">
                </div>
                <span style="display:inline-block; width: 10px;"></span>
                <c:if test="${isByDriver == true}">
                    <font size="5px">Список рейсов водителя (ID = ${driver_id})</font>
                </c:if>
                <c:if test="${isByDriver == false}">
                    <font size="5px">Список рейсов</font>
                </c:if>
            <!-- /div -->
        </div>

        <!-- Table -->
        <table class="table table-striped">
            <tr>
                <th class="text-center">Номер рейса</th>
                <th class="text-center">Выполнен</th>
                <th class="text-center">Идентификатор водителя</th>
                <adm:check-admin>
                    <th>Edit</th>
                </adm:check-admin>
            </tr>

            <c:forEach var="passage" items="${passages}" varStatus="ind">

                <tr>
                    <td class="text-center"><c:out value="${passage.id}"/></td>
                    <td class="text-center">
                        <c:if test="${passage.isMade == true}">
                            <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                        </c:if>
                        <c:if test="${passage.isMade == false}">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </c:if>
                    </td>
                    <td class="text-center"><c:out value="${passage.driver.id}"/></td>
                    <adm:check-admin>
                        <td>
                            <form name="editDishForm" method="get" action="/motordepot_ejb_servlet/serv">
                                <input type="hidden" name="command" value="edit_passage">
                                <input type="hidden" name="passage_id" value="${passage.id}">
                                <button type="submit">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                    </adm:check-admin>
                </tr>
            </c:forEach>

        </table>
    </div>
</div>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Новый рейс</h4>
            </div>

                <form name="addPassageForm" method="get" action="/motordepot_ejb_servlet/serv">
                    <input type="hidden" name="command" value="add_passage">
                    <div class="modal-body">
                    <div class="form-group">
                        <label for="id_driver">Идентификатор водителя</label>
                        <input type="number" class="form-control" id="id_driver"
                            name="driver_id" value="0">
                        <label for="is_made"> Совершен</label>
                        <p></p>
                        <span class="input-group-addon" style="width:0px; padding-left:0px;
                        padding-right:0px; border:none;"></span>
                        <select class="form-control" id="is_made" name="made_is">
                            <option>No</option>
                            <option>Yes</option>
                        </select>
                    </div>
                    <div class="form-group">

                        <!--<span class="input-group-addon">
                            <input type="checkbox" class="form-control" id="is_made" name="is_made">
                        </span>-->
                    </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                        <button type="submit" class="btn btn-success">Сохранить</button>
                    </div>
                </form>
        </div>
    </div>
</div>

</body>
</html>