<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

<table class="table table-hover" id="vacationTable">
    <tbody>
    <t:search-empty-result searchResult="${vacations}"/>
    <c:forEach items="${vacations}" var="vacation">
        <tr data-href="${pageContext.request.contextPath}/my-vacations/view/<c:out value="${vacation.id}" />">
            <td>
                <fmt:formatDate value="${vacation.startDate}" pattern="dd.MM.y" /> -
                <fmt:formatDate value="${vacation.endDate}" pattern="dd.MM.y" />
            </td>
            <td><c:out value="${vacation.type.name}"/></td>
            <td><c:out value="${vacation.status.title}"/></td>
            <td>
                <c:if test="${vacation.status eq 'F'}">
                    <span class="glyphicon glyphicon-ok" style="color: green"></span>
                </c:if>
                <c:if test="${vacation.status == 'C'}">
                    <span class="glyphicon glyphicon-remove" style="color: red"></span>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

