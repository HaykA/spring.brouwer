<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>
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
      
      <div class="well">
        <br:pagebar urlPattern="/brouwers"/>
        <form method="post">
        	<button type="submit" value="pdf" class="btn btn-lg btn-danger"><br:fa icon="file-pdf-o"/>&nbsp;PDF</button>
        	<security:csrfInput/>
        </form>
      </div>
      
      <table class="table table-hover table-bordered">
        <thead>
          <tr class="active">
          
            <td class="text-center text-middle">
              <br:sort-url urlPattern="/brouwers" sortBy="id" name='Nummer'/>
            </td>
            
            <td class="text-left text-middle">
              <br:sort-url urlPattern="/brouwers" sortBy="naam" name='Naam'/>
            </td>
            
            <td class="text-left text-middle">
              <br:sort-url urlPattern="/brouwers" sortBy="adres.straat" name='Straat'/>
            </td>
            
            <td class="text-center text-middle">
              <br:sort-url urlPattern="/brouwers" sortBy="adres.huisnr" name='Huisnummer'/>
            </td>
            
            <td class="text-center text-middle">
              <br:sort-url urlPattern="/brouwers" sortBy="adres.postcode" name='Postcode'/>
            </td>
            
            <td class="text-left text-middle">
            <br:sort-url urlPattern="/brouwers" sortBy="adres.gemeente" name='Gemeente'/>
            </td>
            
            <td class="text-right text-middle">
              <br:sort-url urlPattern="/brouwers" sortBy="omzet" name='Omzet'/>
            </td>
            
            <td></td>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="brouwer" items="${page.content}">
          <spring:url value="/weather/{gemeente}/temperature" var="weerUrl">
            <spring:param name="gemeente" value="${brouwer.adres.gemeente}"/>
          </spring:url>
          <tr>
            <td class="text-center text-middle">${brouwer.id}</td>
            <td class="text-left text-middle">${brouwer.naam}</td>
            <td class="text-left text-middle">${brouwer.adres.straat}</td>
            <td class="text-center text-middle">${brouwer.adres.huisnr}</td>
            <td class="text-center text-middle">${brouwer.adres.postcode}</td>
            <td class="text-left text-middle">
              <a href="${weerUrl}" class="btn btn-success"
                  data-toggle="tooltip" title="<spring:message code='HetWeer'/>"><br:gi icon="cloud"/></a> &nbsp;${brouwer.adres.gemeente}</td>
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
                <a href="${wijzigUrl}" class="btn btn-primary"
                  data-toggle="tooltip" title="<spring:message code='Wijzigen'/>"><br:gi icon="edit"/></a>
              </form>
              
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>