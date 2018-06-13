<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib tagdir="/WEB-INF/tags/navbars" prefix="nav" %>


<c:choose>
	<c:when test="${sessionScope.role == \"admin\"}">
		<nav:admin />	
	</c:when>
	<c:when test="${sessionScope.role== \"member\"}" >
		<nav:member />	
	</c:when>
	<c:otherwise >
		<nav:anon/>	
	</c:otherwise>
</c:choose>