<%@tag language="java" description="form-label" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri='http://www.springframework.org/tags'%>
<%@taglib prefix="form" uri='http://www.springframework.org/tags/form'%>
<%@attribute name="path" required="true" type="java.lang.String" %>
<%@attribute name="code" required="true" type="java.lang.String" %>
<%@attribute name="style" required="false" type="java.lang.String" %>

<c:if test="${empty style}">
  <c:set var="style" value="default"/>
</c:if>

<c:if test="${empty size}">
  <c:set var="size" value="6"/>
</c:if>

<h6><form:label path="${path}" cssClass="label label-${style}">
          <spring:message code="${code}"/></form:label></h6>