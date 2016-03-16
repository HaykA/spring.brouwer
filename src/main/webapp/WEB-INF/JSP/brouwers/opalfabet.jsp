<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>

<!DOCTYPE html>
<html>
  <head>
    <br:head title="BrouwersOpAlfabet"/>
  </head>
  <body>
    <br:header activeId="0"></br:header>
    <div class="centralized pull-down">
      <h1><i class="fa fa-font"></i> <spring:message code="BrouwersOpAlfabet"/></h1>
      <nav>
        <ul class="pagination pagination-fixed-1">
          <c:forEach var="letter" items="${alfabet}">
            <c:choose>
              
              <c:when test="${letter eq gekozenLetter}">
                <li class="active"><a>${letter}</a></li>
              </c:when>
              <c:otherwise>
                <spring:url var="url" value="/brouwers/opalfabet/{x}">
                  <spring:param name="x" value="${letter}"></spring:param>
                </spring:url>
                <li><a href="${url}">${letter}</a></li>
              </c:otherwise>
            </c:choose>
          </c:forEach>    
        </ul>
      </nav>
      <c:if test="${not empty gekozenLetter}">
      <c:choose>
      <c:when test="${not empty brouwers}">
      <ul class="list-group">
        <c:forEach var="brouwer" items="${brouwers}">
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