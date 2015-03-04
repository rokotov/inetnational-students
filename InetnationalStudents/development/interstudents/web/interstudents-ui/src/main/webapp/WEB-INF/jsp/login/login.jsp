<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/script/bootstrap.js"></script>
  <title>Students</title>
</head>
<body>

<div class="container">
  <div class="row">
    <div class="col-sm-5 col-sm-offset-1 hidden-xs jumbotron helloForm">
      <h1>hello!</h1>
      <h3>I`m Art-Vacation application! =)</h3>
    </div>
    <div class="col-sm-5 col-md-4 col-sm-offset-1 col-md-offset-2 loginForm">
      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">Inter Students</h2>
        <div class="form-group<c:if test="${status.error}"> has-error</c:if>">
          <input type="text" name="login" class="form-control"/>
        </div>
        <div class="form-group">
          <input type="password" name="password" class="form-control" />
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
