<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/app.js"></script>

<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/script/login.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/home.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/students.js"></script>--%>


    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html5-boilerplate/main.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/html5-boilerplate/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/angular-material/angular-material.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/indigo-theme.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/app.css"/>
</head>

<body ng-controller="MainCtrl">
<!-- Верхняя панель-->
<md-toolbar md-theme="indigo" class="app-toolbar md-whiteframe-z2 fix-top" >
    <div class="md-toolbar-tools" tabindex="0">
        <md-button class="menu-icon normal-btn" ng-click="toggleRight()" aria-label="Toggle Menu">
            <md-tooltip >
                Меню
            </md-tooltip>
            <md-icon icon="img/icons/ic_menu_24px.svg"></md-icon>
        </md-button>
        <span>International Students</span>
    </div>
</md-toolbar>

<!--Сюда будут вставляться views-->
<div class="main-context" layout-align="center" layout="row" >
    <jsp:doBody />
</div>
<!-- Боковая панель -->
<md-sidenav md-theme="indigo" class="md-sidenav-left md-whiteframe-z3" md-component-id="left">
    <div ng-controller="LeftCtrl" ng-click="close()">
        <md-toolbar >
            <h1 class="md-toolbar-tools">Меню</h1>
        </md-toolbar>
        <md-content >
            <a class="menu-item menu-sub-item md-menu-item" ng-click="menu.toggleSelectPage(page)" ng-repeat="page in menu.pages" ng-href="#{{page.url}}" md-highlight="menu.isPageSelected(page)" md-ink-ripple="#bbb">
                <span > {{page.discription}} </span>
            </a>
        </md-content>
    </div>
</md-sidenav>

</body>
</html>