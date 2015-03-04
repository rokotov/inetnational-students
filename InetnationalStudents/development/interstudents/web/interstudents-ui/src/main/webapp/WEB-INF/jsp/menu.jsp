<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="currentURI" scope="page" value="${requestScope['javax.servlet.forward.request_uri']}" />
<div class="container-fluid">
    <div class="row">
            <div class="navbar navbar-default" >
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#responsive-menu">
                        <span class="sr-only">Открыть навигацию</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">ART-VACATION</a>
                </div>
                <div class="collapse navbar-collapse " id="responsive-menu">
                    <ul class="nav navbar-nav">
                        <li <c:if test="${currentURI eq '/my-vacations'}">class="active"</c:if>>
                            <a href="${pageContext.request.contextPath}/my-vacations">Мои отпуска</a>
                        </li>
                        <li <c:if test="${currentURI eq '/schedule'}">class="active"</c:if>>
                            <a href="${pageContext.request.contextPath}/schedule">График отпусков</a>
                        </li>
                        <li <c:if test="${currentURI eq '/approvement'}">class="active"</c:if>>
                            <a href="${pageContext.request.contextPath}/approvement">Заявления на согласование</a>
                        </li>
                        <c:if test="${employee.id == employee.office.officeManagerId}">
                            <li <c:if test="${currentURI eq '/administration'}">class="active"</c:if>>
                                <a href="${pageContext.request.contextPath}/administration" >Администрирование</a>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.isHr}">
                            <li  <c:if test="${currentURI eq '/register'}">class="active"</c:if>>
                                <a href="${pageContext.request.contextPath}/register">Регистрация отпусков</a>
                            </li>
                        </c:if>

                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggles" data-toggle="dropdown">
                                <c:out value="${employee.firstName} ${employee.middleName} ${employee.lastName}" /> <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dLabel">
                                <li><a href="https://time.artezio.com">ArtTime</a></li>
                                <li class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/login/logout">Выход</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
    </div>
</div>
