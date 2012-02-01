<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Registration</h1>


<form:form action="/users/register" method="POST" modelAttribute="userForm">
  <table>
  <tr>
    <td><label for="email">Email:</label></td><td><form:input path="email" id="email"/></td>
  </tr>
  <tr>
    <td><label for="password">Password:</label></td><td><form:input path="password" type="password" id="password"/></td>
  </tr>
  <tr>
    <td><label for="fullName">Full Name:</label></td><td><form:input path="fullName" id="fullName"/></td>
  </tr>
  <tr>
    <td/><td><input type="submit" value="Register"/></td>
  </tr>
  </table>
</form:form>
