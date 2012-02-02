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
    <td>Work:</td>
    <td ><textarea readonly cols=70> ${resumeForm.work} </textarea></td>
  </tr>
  <tr>
    <td>Salary:</td>
    <td><textarea readonly cols=10> ${resumeForm.salary} </textarea></td>
  </tr>
  <tr>
    <td>Standing:</td>
    <td><textarea readonly cols=10> ${resumeForm.standing} </textarea></td>
  </tr>
  <tr>
    <td>Additional information:</td>
    <td><textarea readonly rows=10 cols=70> ${resumeForm.text} </textarea></td>
  </tr> 
</table>
<br>
<h2>Рекомендации которые дал пользователь "${userName}":</h2>
<h3>
<table>
<c:forEach var="recommendation" items="${myRecommendations}">
  <form:form action="/users/recommendation" method="GET">
      <c:if test = "${recommendation.isWritten == true}">
      <tr>
      <td><c:out value="пользователю ${recommendation.userName} "/></td>
      <td><input type="hidden" name="recommendationId" value="${recommendation.recommendationId}"/></td>
      <td><input type="submit" value="See recommendation"/></td>
      </tr>
    </c:if>
  </form:form>
</c:forEach>
</table>
<br>
<h2>Рекомендации которые дали пользователю "${userName} другие пользователи:</h2>
<table>
<c:forEach var="recommendation" items="${recommendationsToMe}">
  <form:form action="/users/recommendation" method="GET">
    <c:if test = "${recommendation.isWritten == true}">
      <tr>
        <td><c:out value="пользователь ${recommendation.recommendatorName} "/></td>
        <td><input type="hidden" name="recommendationId" value="${recommendation.recommendationId}"/></td>
        <td><input type="submit" value="See his recommendation"/></td>
      </tr>
    </c:if>
  </form:form>
</c:forEach>
</table>
</h3>