<%@tag language="java" description="form-error" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri='http://www.springframework.org/tags/form'%>
<%@attribute name="path" required="true" type="java.lang.String" %>
<%@attribute name="title" required="false" type="java.lang.String" %>
<%@attribute name="noIcon" required="false" type="java.lang.Boolean" %>

<c:set var="error"><form:errors path="${path}" delimiter=", "/></c:set>
  <c:if test="${not empty error}">
  <div class="alert alert-danger">
    <c:if test="${not noIcon}"><i class="fa fa-exclamation-circle"></i>&nbsp;</c:if>
    <c:if test="${not empty title}"><strong>${title}</strong>&nbsp;</c:if>
    ${error}
  </div>
</c:if>