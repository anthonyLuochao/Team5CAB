<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/welcome" prefix="welcome" %>

<c:choose>
	<c:when test="${sessionScope.role == \"admin\"}">
		<welcome:admin />
	</c:when>
	<c:otherwise >
		<welcome:anon_member />	
	</c:otherwise>
</c:choose>