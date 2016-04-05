<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <br:head title="Beginnaam"/>
  </head>
  <body>
    <br:header activeId="0"></br:header>
    <div class="centralized side-padded-15 pull-down">
      <h1><i class="fa fa-search"></i> <spring:message code="Beginnaam"/></h1>
      <c:url var="url" value='/brouwers'/>
      <form:form method="get" action="${url}" commandName='beginnaamForm'>
      <div class="input-group">
      <spring:message var="placeholder" code="Beginnaam"/>
      <form:input path="beginnaam" cssClass="form-control" placeholder="${placeholder}"/>
      <span class="input-group-btn" data-toggle="tooltip" title="<spring:message code='Zoeken'/>">
          <button class="btn btn-primary" type="submit"><i class="fa fa-search fa-fw"></i></button>
        </span>
      </div>
      
      <c:if test="${errBeginnaamEmpty}">
      <hr/>
      <div class="alert alert-danger"><spring:message code="errBeginnaamEmpty"/> </div>
      </c:if>
      </form:form>
      
      
      
      <c:if test="${not empty param.beginnaam}">
      <hr/>
      <c:choose>
      <c:when test="${not empty page and not empty page.content}">
      
      <ul class="list-group">
        <c:forEach var="brouwer" items="${page.content}">
        <li class="list-group-item">${brouwer.naam} (${brouwer.adres.gemeente})</li>
        </c:forEach>
      </ul>
      </c:when>
      <c:otherwise>
      <div class="alert alert-warning"><spring:message code="GeenBrouwersGevonden"/></div>
      </c:otherwise>
      </c:choose>
      </c:if>
      
    </div>
  </body>
</html>