<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <br:head title="Brouwers"/>
  </head>
  <body>
    <br:header activeId="0"></br:header>
    <div class="centralized pull-down">
      <h1><i class="fa fa-glass"></i> <spring:message code="AlleBrouwers"/></h1>
      <pre>
      Total pages: ${page.totalPages}
      Page size: ${page.size}
      Page number: ${page.number}
      Sorted by: ${param.sort}
      </pre>
      <table class="table table-hover table-bordered">
        <thead>
          <tr class="active">
            <td class="text-center text-middle">
              <c:url value="/brouwers" var="brouwersUrl">
              <c:choose>
                <c:when test="${empty param.sort or param.sort eq 'id,desc'}">
                  <c:param name="sort">id</c:param>
                </c:when>
                <c:otherwise>
                  <c:param name="sort">id,desc</c:param>
                </c:otherwise>
              </c:choose>
              </c:url>
              <c:if test="${not empty param.sort}">
                <c:choose>
                  <c:when test="${param.sort eq 'id'}">
                    <c:set var="paramSortIcon" value="triangle-top"/>
                  </c:when>
                  <c:when test="${param.sort eq 'id,desc'}">
                    <c:set var="paramSortIcon" value="triangle-bottom"/>
                  </c:when>
                </c:choose>
              </c:if>
              <a href="${brouwersUrl}"><strong><spring:message code="Nummer"/>
                <c:if test="${not empty paramSortIcon}">&nbsp;<br:gi icon="${paramSortIcon}"/></c:if> </strong></a></td>
            <td class="text-left text-middle"><strong><spring:message code="Naam"/></strong></td>
            <td class="text-left text-middle"><strong><spring:message code="Straat"/></strong></td>
            <td class="text-center text-middle"><strong><spring:message code="Huisnummer"/></strong></td>
            <td class="text-center text-middle"><strong><spring:message code="Postcode"/></strong></td>
            <td class="text-left text-middle"><strong><spring:message code="Gemeente"/></strong></td>
            <td class="text-right text-middle"><strong><spring:message code="Omzet"/></strong></td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="brouwer" items="${page.content}">
          <tr>
            <td class="text-center text-middle">${brouwer.id}</td>
            <td class="text-left text-middle">${brouwer.naam}</td>
            <td class="text-left text-middle">${brouwer.adres.straat}</td>
            <td class="text-center text-middle">${brouwer.adres.huisnr}</td>
            <td class="text-center text-middle">${brouwer.adres.postcode}</td>
            <td class="text-left text-middle">${brouwer.adres.gemeente}</td>
            <td class="text-right text-middle">
              <fmt:formatNumber value="${brouwer.omzet}"/> EUR</td>
            <td class="text-left text-middle">
              <spring:url value="/brouwers/{id}/verwijderen" var="verwijderUrl">
                <spring:param name="id" value="${brouwer.id}"/>
              </spring:url>
              <spring:url value="/brouwers/{id}/wijzigen" var="wijzigUrl">
                <spring:param name="id" value="${brouwer.id}"/>
              </spring:url>
              <form action="${verwijderUrl}" method="post">
                <button type="submit" class="btn btn-danger"
                  data-toggle="tooltip" title="<spring:message code='Verwijderen'/>">
                  <br:gi icon="trash"/></button>
                <a href="${wijzigUrl}" class="btn btn-primary"><br:gi icon="edit"/></a>
              </form>
              
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>