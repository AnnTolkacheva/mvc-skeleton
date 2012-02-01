<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<jsp:include page="/users/menu"></jsp:include>

<h1>Данные пользователя</h1>
<br>
<h2><c:out value="Пользователь: ${userName}" default="NO DATA" escapeXml="true" /></h2>
<br>
<h2>Резюме пользователя</h2>
<br>
<table>
  <tr>
    <td>
      Work:
    </td>
    <td >
      <textarea readonly cols=70> ${resumeForm.work} </textarea>
    </td>
  </tr>
  <tr>
    <td>
      Salary:
    </td>
    <td>
      <textarea readonly cols=10> ${resumeForm.salary} </textarea>
    </td>
  </tr>
  <tr>
    <td>
      Standing:
    </td>
    <td>
      <textarea readonly cols=10> ${resumeForm.standing} </textarea>
    </td>
  </tr>
  <tr>
    <td>
      Additional information:
    </td>
    <td>
      <textarea readonly rows=10 cols=70> ${resumeForm.text} </textarea>
    </td>
  </tr> 
</table>
<%-- <br>
<h2>Рекомендации пользователя</h2>
<h3>
  <ul>
    <c:forEach var="recomendation" items="${recomendations}">
      <li>Рекомендация от ${recomendation.fullName}
          <br>
          ${recomendation.text}]
          <br>
      </li>
    </c:forEach>
  </ul>
</h3> --%>