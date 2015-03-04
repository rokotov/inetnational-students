<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}" />/script/jquery/jquery-ui.css" type="text/css"/>
        <link rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}" />/css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}" />/css/bootstrap-theme.css" type="text/css"/>
        <link rel="stylesheet" href="<c:out value="${pageContext.request.contextPath}" />/css/style.css" type="text/css"/>
        <script type="text/javascript">
            App = {}
        </script>
        <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}" />/script/jquery/jquery-1.11.2.min.js"></script>
        <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}" />/script/jquery/jquery-ui.js"></script>
        <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}" />/script/dialogs.js"></script>
        <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}" />/script/scripts.js"></script>
        <script type="text/javascript" src="<c:out value="${pageContext.request.contextPath}" />/script/bootstrap.js"></script>
        <title>ART-VACATION</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <jsp:doBody />
        <div id="dialogWindow" class="dialogWindow">window</div>
        <div id="dialogError" class="dialogWindow">error</div>
        <div id="dialogMessage" class="dialogWindow">message</div>
        <div id="dialogWarning" class="dialogWindow">warning</div>
        <div id="dialogWarningSave" class="dialogWindow">warning save</div>
    </body>
</html>