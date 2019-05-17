<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>${message}</h2>
<c:forEach items="${list}" begin="0" end="${byPage.size}" var="list">
    <c:out value="${list}">

    </c:out>
    <br>
</c:forEach>

</body>

</html>
