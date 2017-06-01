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
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home"></span></a>
    <a class="navbar-brand" href="index.jsp">Автобаза</a>
    <%@include file="static/pages/util/header.jsp" %>
  </div>
</nav>

<div class="top-center-header">
  <h3> <i> Акторы проекта </i></h3>
</div>

<div class="container">
  <div class="row">
    <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
        <div class="img-container">
          <img src="static/images/dispetcher.jpeg" alt="disptecher">
        </div>
        <div class="description-img-container">
          <div class="caption">
            <h3>Диспетчер</h3>
            <p>Диспетчер распределяет Заявки на Рейсы между Водителями.</p>
          </div>
        </div>
      </div>
    </div>

    <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
        <div class="img-container">
          <img src="static/images/auto.png" alt="auto">
        </div>
        <div class="description-img-container">
          <div class="caption">
            <h3>Автомобиль</h3>
            <p>На Рейс может быть назначен Автомобиль, находящийся в исправном состоянии и характеристики которого соответствуют Заявке.</p>
          </div>
        </div>
      </div>
    </div>


    <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
        <div class="img-container">
          <img src="static/images/driver.jpg" alt="driver">
        </div>
        <div class="description-img-container">
          <div class="caption">
            <h3>Водитель</h3>
            <p>За каждым водителем закреплен свой Автомобиль. Водитель делает отметку о выполнении Рейса и состоянии Автомобиля.</p>
          </div>
        </div>
      </div>
    </div>
  </div>

</div>

<%@include file="static/pages/util/footer.jsp" %>

</body>
</html>
