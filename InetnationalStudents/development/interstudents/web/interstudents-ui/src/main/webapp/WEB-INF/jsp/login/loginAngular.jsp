<%--
  Created by IntelliJ IDEA.
  User: vkotov
  Date: 04.03.2015
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="myApp" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="myApp" class="no-js"> <!--<![endif]-->
<head>
  <title>Students</title>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="Material design angular demo">
  <meta name="viewport" content="width=device-width, initial-scale=1">

    <script type="text/javascript">
        App = {}
    </script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/angular/angular.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/angular-material/angular-material.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/angular/angular-animate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/angular/angular-route.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/angular/angular-aria.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/angular/angular-loader.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/hammer/hammer.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/version/version.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/version/version-directive.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/version/interpolate-filter.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/login.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/app.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/students.js"></script>


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html5-boilerplate/main.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html5-boilerplate/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/angular-material/angular-material.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/indigo-theme.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css"/>
</head>

</head>

<body ng-controller="MainCtrl">
<div class="md-whiteframe-z4 app-login loginForm" <%--ng-controller="LoginCtrl"--%> layout="column" layout-align="center center">
<form method="post">
  <md-content >
    <md-input-container >
      <label >Логин</label>
      <input type="text" name="login" >
    </md-input-container>

    <md-input-container >
      <label>Пароль</label>
      <input type="password" name="password">
    </md-input-container>

    <div  style="padding: 20px;">
      <md-button <%--ng-click="login()"--%> type="submit" class="md-raised">Button</md-button>
    </div>
  </md-content>
</form>
</div>
</body>
</html>
