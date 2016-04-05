<%@tag language="java" description="pagebar" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@attribute name="urlPattern" required="true" type="java.lang.String" %>

<nav>
  <ul class="pagination">

<c:forEach var="pageNr" begin="1" end="${page.totalPages}">
  <c:choose>
    <c:when test="${pageNr-1 == page.number}">
      <li class="active"><a href="${url}">${pageNr}</a></li>
    </c:when>
    <c:otherwise>
      <c:url value="${urlPattern}" var="url">
        <c:if test="${not empty page.sort}">
          <c:param name="sort" value="${param.sort}"/>
        </c:if>
        <c:if test="${pageNr > 1}">
          <c:param name="page" value="${pageNr-1}"/>
        </c:if>  
        
        <c:if test="${page.size ne 20}">
          <c:param name="size">${page.size}</c:param>
        </c:if>

      </c:url>
      <li><a href="${url}">${pageNr}</a></li>
    </c:otherwise>
  </c:choose>
</c:forEach>

  </ul>
</nav>