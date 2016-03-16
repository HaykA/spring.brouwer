<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <br:head title="Wijzigen"/>
  </head>
  <body>
    <br:header activeId="0"></br:header>
    <div class="centralized">
      <h1><spring:message code="Wijzigen"/></h1>
      <spring:url value="/brouwers/{id}/wijzigen" var="url">
        <spring:param name="id" value="${brouwer.id}"></spring:param>
      </spring:url>
      <br:brouwer-form url="${url}"/>
    </div>
  </body>
</html>