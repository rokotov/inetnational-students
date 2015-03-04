<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="white-place">
    <form:form action="${pageContext.request.contextPath}/my-vacations/create"
               method="post" modelAttribute="vacationForm" cssClass="form-inline">
        <div class="col-lg-12">
            <form:errors path="*" cssStyle="color: red;" />
        </div>
        <div class="form-group col-lg-6">
            <jsp:include page="../common-units/vac-type-radio-unit.jsp" />
        </div>
        <div class="form-group col-lg-6">
            <jsp:include page="../common-units/period-unit.jsp" />
        </div>
        <div class="form-group col-lg-12">
            Количество дней отпуска:
        </div>
        <div class="form-group col-lg-12">
            Согласовать с:
            <c:forEach items="${approvers}" var="approver">
                <i><c:out value="${approver.lastName} ${approver.firstName}" /></i>,
            </c:forEach>
        </div>
        <div class="form-group col-lg-12">
            дополнительно согласовать с: <input type="text" class="form-control" style="width: auto;" />
        </div>
        <div class="form-group col-lg-12">
                <jsp:include page="../common-units/comment-unit.jsp" />
        </div>
        <div class="form-group col-lg-12">
            <button type="submit" class="btn btn-default">
                Отправить на согласование
            </button>
            <button type="button" class="btn btn-default cancelForm">
                Отменить
            </button>
         </div>
    </form:form>
</div>