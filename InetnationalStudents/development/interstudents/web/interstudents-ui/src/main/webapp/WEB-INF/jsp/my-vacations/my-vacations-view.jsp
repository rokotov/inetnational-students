<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="white-place">
    <form:form action="${pageContext.request.contextPath}/my-vacations/view/${vacation.id}"
               method="post" modelAttribute="vacationForm" cssClass="form-inline">
        <div>
            <jsp:include page="../common-units/vac-type-selected-radio-unit.jsp" />
        </div>
        <div class="form-group">
            <jsp:include page="../common-units/vacation-period-disabled.jsp" />
        </div>
        <div>
            <jsp:include page="../common-units/comment-unit.jsp" />
            </td>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/my-vacations/cancel/${vacation.id}" class="btn btn-default popupContent">
                Отменить отпуск
            </a>
            <button type="submit" class="btn btn-default pull-right">
                Оставить комментарий
            </button>
        </div>
        <div>
            <jsp:include page="../common-units/journal-unit.jsp" />
        </div>
    </form:form>
</div>