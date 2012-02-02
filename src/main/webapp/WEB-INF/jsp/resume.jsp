<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Resume submit\change</h1>

<form:form action="/users/resume" method="POST" modelAttribute="resumeForm">
<table>
  <tr>
    <td>
      <label for="work">Work:</label>
    </td>
    <td>
      <form:textarea cols="70" rows="1" path="work" id="work"/>
    </td>
  </tr>
  <tr>
    <td>
      <label for="salary">Salary:</label>
    </td>
    <td>
      <form:textarea cols="10" path="salary" id="salary"/>
    </td>
  </tr>
  <tr>
    <td>
      <label for="standing">Standing: <br>(количество полных лет)</label>
    </td>
    <td>
      <form:textarea cols="10" path="standing" id="standing"/>
    </td>
  </tr>
  <tr>
    <td>
      <label for="text">Additional information:</label>
    </td>
    <td>
      <form:textarea rows="17" cols = "70" path="text" id="text"/>
    </td>
  </tr> 
  <tr>
    <td>
      <button value="send" name="button" type="submit"> Submit </button>
    </td>
  </tr>
</table>
</form:form>