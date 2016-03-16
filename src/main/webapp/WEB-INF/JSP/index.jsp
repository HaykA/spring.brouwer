<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>

<!DOCTYPE html>
<html>
  <head>
    <br:head title='Welkom'/>
  </head>
  <body>
    <br:header activeId="0"></br:header>
    <div class="centralized pull-down">
      <h1><spring:message code="${groet}" /></h1>
    </div>
  </body>
</html>