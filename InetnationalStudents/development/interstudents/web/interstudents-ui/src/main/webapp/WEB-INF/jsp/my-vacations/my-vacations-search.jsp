<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form modelAttribute="vacationSearchForm" method="get" cssClass="" >
    <div class="col-lg-2 form-group">
        <jsp:include page="../common-units/vac-type-unit.jsp" />
    </div>
    <div class="col-lg-3 form-group">
        <jsp:include page="../common-units/vac-status-unit.jsp" />
    </div>
    <div class=" col-lg-3 form-group ">
        <jsp:include page="../common-units/period-unit.jsp" />
    </div>
    <div class="col-lg-1 form-group">
        <jsp:include page="../common-units/search-button-unit.jsp" />
    </div>
    <div class="col-lg-2 form-group" >
        <button type="button" href="${pageContext.request.contextPath}/my-vacations/create"
                class="rightContent btn">
            <span class="glyphicon glyphicon-plus"></span> Создать заявление
        </button>
    </div>
</form:form>
