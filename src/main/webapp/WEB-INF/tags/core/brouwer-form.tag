<%@tag language="java" description="brouwer-form" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri='http://www.springframework.org/tags'%>
<%@taglib prefix="form" uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix="br" uri='http://brouwers.be/core/tags'%>
<%@attribute name="url" required="true" type="java.lang.String" %>

<form:form action="${url}" commandName="brouwer" id="form-brouwer">

<table class="table table-bordered table-hover">
  <tbody>
    <tr>
      <td class="text-right">
        <br:form-label code="Naam" path="naam" style="primary"/>
      </td>
      <td>
        <br:form-error path="naam"/>
        <spring:message code="Naam" var="placeholder"/>
        <form:input type="text" path="naam" cssClass="form-control" placeholder="${placeholder}" maxlength="25"/>
      </td>
    </tr>
    
    <tr>
      <td class="text-right">
        <br:form-label code="Straat" path="adres.straat" style="primary"/>
      </td>
      <td>
        <br:form-error path="adres.straat"/>
        <spring:message code="Straat" var="placeholder"/>
        <form:input type="text" path="adres.straat" cssClass="form-control" placeholder="${placeholder}" maxlength="45"/>
      </td>
    </tr>
    
    <tr>
      <td class="text-right">
        <br:form-label code="Huisnummer" path="adres.huisnr" style="primary"/>
      </td>
      <td>
        <br:form-error path="adres.huisnr"/>
        <spring:message code="Huisnummer" var="placeholder"/>
        <form:input type="text" path="adres.huisnr" cssClass="form-control" placeholder="${placeholder}" maxlength="15"/>
      </td>
    </tr>
    
    <tr>
      <td class="text-right">
        <br:form-label code="Postcode" path="adres.postcode" style="primary"/>
      </td>
      <td>
        <br:form-error path="adres.postcode"/>
        <spring:message code="Postcode" var="placeholder"/>
        <form:input type="number" path="adres.postcode" cssClass="form-control" placeholder="${placeholder}"
          min="1000" max="9999"/>
      </td>
    </tr>
    
    <tr>
      <td class="text-right">
        <br:form-label code="Gemeente" path="adres.gemeente" style="primary"/>
      </td>
      <td>
        <br:form-error path="adres.gemeente"/>
        <spring:message code="Gemeente" var="placeholder"/>
        <form:input type="text" path="adres.gemeente" cssClass="form-control" placeholder="${placeholder}" maxlength="45"/>
      </td>
    </tr>
    
    <tr>
      <td class="text-right">
        <br:form-label code="Omzet" path="omzet" style="primary"/>
      </td>
      <td>
        <br:form-error path="omzet"/>
        <spring:message code="Omzet" var="placeholder"/>
        <form:input type="number" path="omzet" cssClass="form-control" placeholder="${placeholder}"/>
      </td>
    </tr>
    
    <tr>
      <td colspan="2" class="active">
        <button type="submit" class="btn btn-info"><i class="fa fa-save"></i>&nbsp;<spring:message code="Opslaan"/></button>
      </td>
    </tr>
  </tbody>
</table>

  
</form:form>