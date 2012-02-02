<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Recommendation</h1>

<c:choose>
<c:when test="${!empty isWrittable}">
<form:form action="/users/giverecommendation" method="POST" modelAttribute="recommendation">
<form:hidden path="id" id="id"/> 
  <table>
    <tr>
      <td><label for="userName">Recommendation to user:</label></td>
      <td><form:textarea readonly="true" path="userName" id="userName"/></td>
    </tr>
    <tr>
      <td><label for="text">Text of recommendation:</label></td>
      <td><form:textarea cols="30" rows="17" path="text" id="text"/></td>
    </tr>
    <tr>
      <td><button value="send" name="button" type="submit"> OK </button></td>
    </tr>
  </table>
</form:form>
</c:when>
<c:otherwise>  
  <table>
    <tr>
      <td> <c:out value ="From user: ${recommendation.recommendatorName}"/> </td><td><td>
    </tr>
    <tr>
      <td> <c:out value ="To user: ${recommendation.userName}"/> </td><td><td>
    </tr>
    <tr>
      <td> <c:out value = "Text of recommendation:"/> </td>
      <td> <textarea readonly cols="10" > ${recommendation.text} </textarea> </td>
    </tr>
  </table>
</c:otherwise>
</c:choose>