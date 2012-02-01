<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Recommendation</h1>

<form:form action="/users/recommendation" method="POST" modelAttribute="recommendationForm">
  <table>
    <tr>
      <td>
        <label for="userName">From user:</label>
      </td>
      <td>
        <form:text readonly path="userName" id="userName"/>
      </td>
    </tr>
    <tr>
      <td>
        <label for="text">Text of recommendation:</label>
      </td>
      <c:choose>
        <c:when test="${empty recommendationForm.text}">
          <td>
            <form:textarea cols="10" path="text" id="text"/>
          </td>
        </c:when>
        <c:otherwise test="${empty recommendationForm.text}">
          <td>
            <form:textarea readonly cols="10" path="text" id="text"/>
          </td>
        </c:otherwise>
      </c:choose>
    </tr>
    <tr>
      <td>
        <button value="send" name="button" type="submit"> OK </button>
      </td>
    </tr>
  </table>
</form:form>