<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<jsp:include page="/users/menu"></jsp:include>

<%--<frameset rows="70, 170, *">
  <iframe srs="/users/menu" name="menu">
  <frame srs="/users/about" name="about">
  <frame srs="/users/about" name="about">
</frameset> --%>
<h1>My cabinet</h1>
<br>
<h3>
  <a href="/users/listUsers">Go to the users page</a>
  <br>
  <a href="/users/resume">Submit or change the resume</a>
  <form:form action="/users/main" method="POST">
  <td><input type="submit" value="Go out"/></td>
  </form:form>
<br> 
<h2>Ask user to recommend u:</h2>
<form:form action="/users/main" method="POST">
   <select size=5 name="recommendatorId">
     <c:forEach var="user" items="${users}">
      <option value="${user.id}"> ${user.fullName} [${user.email}] </option>
     </c:forEach>
   </select>   
   <input type="submit" value="ask recommendation" />
</form:form>

<%--<form:form action="/users/main" method="POST" modelAttribute="userInfo">
   <form:select path="user" multiple>
      <form:option value="-" label="--Select user"/>
      <form:options items="${users}"/>
   </form:select>
   <input type="submit" value="OK" />
</form:form> --%>

<br>
<h2>Asked users:</h2>
<table>
<c:forEach var="recommendation" items="${recommendationsToMe}">
  <form:form action="/users/recommendation" method="GET">
  <tr>
    <c:choose>
      <c:when test = "${recommendation.isWritten == false}">
        <td><c:out value="User ${recommendation.recommendatorName} did not write recommendation for u yet!" /></td>
      </c:when>
      <c:otherwise>
        <td><c:out value="User ${recommendation.recommendatorName} reccomend u!" /></td>
        <td><input type="hidden" name="recommendationId" value="${recommendation.recommendationId}"/></td>
        <td><input type="submit" value="See his recommendation"/></td>
      </c:otherwise>
    </c:choose>
  </tr>
  </form:form>
</c:forEach>
</table>
<br>
<h2>Users, who ask u to recommend them:</h2>
<table>
<c:forEach var="recommendation" items="${myRecommendations}">
  <form:form action="/users/giverecommendation" method="GET">
    <c:if test = "${recommendation.isWritten == false}">
      <tr>
        <td><c:out value="U did not write recommendation for user ${recommendation.userName} yet!"/></td>
        <td><input type="hidden" name="recommendationId" value="${recommendation.recommendationId}"/></td>
        <td><input type="submit" value="Give recommendation"/></td>
      </tr>
    </c:if>
  </form:form>
</c:forEach>
</table>
<br>
<h2>Users, who u already recommend:</h2>
<table>
<c:forEach var="recommendation" items="${myRecommendations}">
  <form:form action="/users/recommendation" method="GET">
      <c:if test = "${recommendation.isWritten == true}">
        <tr>
        <td><c:out value="U reccomend user ${recommendation.userName}!"/></td>
        <td><input type="hidden" name="recommendationId" value="${recommendation.recommendationId}"/></td>
        <td><input type="submit" value="See recommendation"/></td>
        </tr>
      </c:if>
  </form:form>
</c:forEach>
</table>

</h3>