<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Log In</h1>

<h3>
<form:form action="/users/login" method="POST" modelAttribute="logForm">
  <table>
  <tr>
    <td><label for="email">Email: </label></td><td><form:input path="email" id="email"/></td>
  </tr>
  <tr>
    <td><label for="password">Password: </label></td><td><form:input path="password" type="password" id="password"/></td>
  </tr>
  <tr>
    <td/><td><input type="submit" value="Enter"/></td>
  </tr>
  </table>
</form:form>
</h3>