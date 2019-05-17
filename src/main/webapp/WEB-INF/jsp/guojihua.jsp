<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
<a href="${pageContext.request.contextPath}/guojihua2?langType=cn">中文</a> | <a href="${pageContext.request.contextPath}/guojihua2?langType=en">英文</a><br/>
<h2>${guojihua}</h2>

<h2>${problem}</h2>
<%--<spring:message code="guojihua"/>


<spring:message code="1000"/>

<spring:message code="2000"/>--%>
</body>

</html>
