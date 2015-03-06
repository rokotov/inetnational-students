<%--
  Created by IntelliJ IDEA.
  User: vkotov
  Date: 06.03.2015
  Time: 5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <div ng-controller="HomeCtrl" layout="column" layout-align="center center" class="app-context md-whiteframe-z4">
        <p>Приложение International Students в стиле Material Design + AngularJS</p>
        <p>Готов список студентов</p>
        <md-icon icon="img/icons/ic_border_color_24px.svg"></md-icon>
        <md-icon icon="img/icons/ic_chevron_right_24px.svg"></md-icon>
    </div>
</t:layout>