<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:if test="${user != null}">
    <ul class="nav navbar-nav">
        <li>
            <a href="<c:url value="/serv">
                <c:param name="command" value="get_drivers"/>
            </c:url>">Список Водителей</a>
        </li>
        <li>
            <a href="<c:url value="/serv">
                <c:param name="command" value="get_cars"/>
            </c:url>">Список Автомобилей</a>
        </li>
        <li>
            <a href="<c:url value="/serv">
                <c:param name="command" value="get_passages"/>
            </c:url>">Список Рейсов</a>
        </li>
    </ul>
</c:if>

<ul class="nav navbar-nav navbar-right">
    <c:if test="${user == null}">
        <li>
            <a href="<c:url value="/serv">
                    <c:param name="command" value="login"/>
                        </c:url>">Войти</a>
        </li>
        <li>
            <a href="<c:url value="/serv">
                    <c:param name="command" value="registration"/>
                        </c:url>">Зарегистрироваться</a>
        </li>
    </c:if>

    <c:if test="${user != null}">
        <li>
            <a>
                <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                <span>${user.login}</span>
            </a>
        </li>
        <li>
            <a href="<c:url value="/serv">
                    <c:param name="command" value="logout"/>
                        </c:url>">Выйти</a>
        </li>
    </c:if>
</ul>


