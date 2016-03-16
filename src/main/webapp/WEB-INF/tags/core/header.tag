<%@tag language="java" description="header" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>
<%@attribute name='activeId' required='true' type='java.lang.Integer'%>

<header>
  <nav class="navbar navbar-default" id="navigation">
    <div class="container-fluid centralized">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-collapse" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand brand-name" href="<c:url value='/'/>">
          <img alt="Logo" src="<c:url value='/images/core/favicon.png'/>"
            width="46" height="46"/>
        </a>
      </div>

      <div class="collapse navbar-collapse" id="nav-collapse">
        <ul class="nav navbar-nav">
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><spring:message code="Brouwers"/> <span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="<c:url value='/brouwers'/>"><spring:message code="AlleBrouwers"/></a></li>
              <li><a href="<c:url value='/brouwers/opalfabet'/>"><spring:message code="OpAlfabet"/></a></li>
              <li><a href="<c:url value='/brouwers/beginnaam'/>"><spring:message code="Beginnaam"/></a></li>
              <li><a href="<c:url value='/brouwers/toevoegen'/>"><spring:message code="Toevoegen"/></a></li>
            </ul>
          </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <c:if test="${pageContext.response.locale.language != 'nl'}">
            <c:url value='' var="nederlandsUrl">
              <c:param name="locale" value="nl_BE"/>
            </c:url>
            <c:set var="enClass" value="active"/>
            <c:set var="aenClass" value="cursor-default"/>
          </c:if>
          <c:if test="${pageContext.response.locale.language != 'en'}">
            <c:url value='' var="engelsUrl">
              <c:param name="locale" value="en_US"/>
            </c:url>
            <c:set var="nlClass" value="active"/>
            <c:set var="anlClass" value="cursor-default"/>            
          </c:if>
          <li class="${enClass}"><a class="${aenClass}"<c:if test="${not empty engelsUrl}"> href="${engelsUrl}"</c:if>>ENG</a></li>
          <li class="${nlClass}"><a class="${anlClass}"<c:if test="${not empty nederlandsUrl}"> href="${nederlandsUrl}"</c:if>>NLD</a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>