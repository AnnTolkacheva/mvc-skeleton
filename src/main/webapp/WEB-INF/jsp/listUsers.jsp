<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Users</h1>
<h3>
  <ul>
    <c:forEach var="user" items="${users}">
      <li>${user.fullName} [${user.email}] </li>
         <form:form action="/users/userPage" method="GET">
           <input type="hidden" name="userId" value="${user.id}" />
           <input type="submit" value="Show user info"/>
         </form:form>    
    </c:forEach>
  </ul>
</h3>