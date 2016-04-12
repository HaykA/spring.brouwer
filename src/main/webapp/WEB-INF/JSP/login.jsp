<%@page contentType='text/html' pageEncoding='UTF-8' session='false' trimDirectiveWhitespaces="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix="br" uri="http://brouwers.be/core/tags"%>

<!DOCTYPE html>
<html>
  <head>
    <br:head title='Welkom'/>
  </head>
  <body>
    <br:header activeId="0"/>
    <div class="centralized pull-down">
      <h1>Sign-in</h1>
      <div class="col-sm-4">
        <form method="post">
          <div class="input-group input-group-lg v-spaced">
            <span class="input-group-addon" id="username-addon"><br:gi icon="user"/></span>
            <input name="username" type="text" class="form-control" placeholder="<spring:message code="Username"/>" aria-describedby="username-addon">
          </div>
        
          <div class="input-group input-group-lg v-spaced">
            <span class="input-group-addon" id="password-addon"><br:gi icon="lock"/></span>
            <input name="password" type="password" class="form-control" placeholder="<spring:message code="Password"/>" aria-describedby="username-addon">
          </div>
          
          <div class="input-group input-group-lg v-spaced">
            <button class="btn btn-lg btn-primary" type="submit"><br:fa icon="sign-in"/>&nbsp;<spring:message code="SignIn"/></button>
          </div>
          
          <c:if test='${param.error != null}'>
          <div class="alert alert-danger">
            <spring:message code="msg_SignInAuth"/>
          </div>
          </c:if>
          
          <security:csrfInput/>
      </form>
      </div>
      
      
      
    </div>
  </body>
</html>