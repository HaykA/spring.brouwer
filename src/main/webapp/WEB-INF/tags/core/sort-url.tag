<%@tag language="java" description="sort-url" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@attribute name="sortBy" required="true" type="java.lang.String" %>
<%@attribute name="urlPattern" required="true" type="java.lang.String" %>
<%@attribute name="name" required="true" type="java.lang.String" %>


<c:url value="${urlPattern}" var="urlVar">
  <c:set var="sortQuery">${sortBy},desc</c:set>
  <c:choose>
    <c:when test="${empty param.sort or param.sort eq sortQuery or param.sort ne sortBy}">
      <c:param name="sort">${sortBy}</c:param>
    </c:when>
    <c:otherwise>
      <c:param name="sort">${sortQuery}</c:param>
    </c:otherwise>
  </c:choose>
  <c:if test="${page.number > 0}">
      <c:param name="page">${page.number}</c:param>
  </c:if>
  <c:if test="${page.size ne 20}">
      <c:param name="size">${page.size}</c:param>
  </c:if>
</c:url>

<c:if test="${not empty param.sort}">
  <c:choose>
	<c:when test="${param.sort eq sortBy}">
	 <c:set var="paramSortIcon" value="triangle-top"/>
	</c:when>
	<c:when test="${param.sort eq sortQuery}">
      <c:set var="paramSortIcon" value="triangle-bottom"/>
    </c:when>
  </c:choose>
</c:if>

<a href="${urlVar}"><strong><spring:message code="${name}"/>
  <c:if test="${not empty paramSortIcon}">&nbsp;<br:gi icon="${paramSortIcon}"/></c:if> </strong></a>

