<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12 form-inline" >
                <jsp:include page="my-vacations-search.jsp" />
            </div>
            <div class="col-sm-6 content ">
                <div>
                    <jsp:include page="my-vacations-search-result.jsp" />
                </div>
            </div>
            <div class="col-sm-6 content" id="right-region">
                <div class="col-lg-6 well pull-right">
                    <p>Доступно календарных дней :</p>
                    <p>на текущую дату 14 (из них 10 рабочих)</p>
                    <p>до конца года 28  ( из них 20 рабочих)</p>

                    <p><a href="https://wiki.artezio.com">Wiki Artezio</a></p>
                    <p><a>Правила оформления отпусков</a></p>
                </div>
            </div>
        </div>
    </div>
</t:layout>