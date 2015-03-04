<%@ page contentType="application/json;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
{
  "status": "${jsonResult.status}",
  "message": "${jsonResult.message}",
  "reload": "${jsonResult.reload}"
}
