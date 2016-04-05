<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<!DOCTYPE html>
<html>
  <head>
    <br:head title="HetWeer"/>
  </head>
  <body>
    <br:header activeId="0"></br:header>
    <div class="centralized pull-down">
      <h1>Het weer is <fmt:formatNumber value=''/> ${current.temperature.value}°C in ${gemeente}</h1>
      <c:choose>
      <c:when test='${empty fout}'>
        <div class="well">
          <h2><img src="${current.weatherIcon.iconImage}"/> ${current.weatherIcon.value}</h2>
          <h3>Min:  ${current.temperature.min}°C</h3>
          <h3>Max:  ${current.temperature.max}°C</h3>
        </div>
      </c:when>
      <c:otherwise>
          <div class='fout'>${fout}</div>
      </c:otherwise>
      </c:choose>
    </div>
  </body>
</html>