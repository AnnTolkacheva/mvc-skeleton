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
<form:form action="/users/getrecommendation" method="GET">
  <c:forEach var="recommendation" items="${recommendationsToMe}">
    <c:choose>
      <c:when test = "${empty recommendation.text}">
        <c:out value="User ${recommendation.userName} did not write recommendation for u yet!" />
      </c:when>
      <c:otherwise>
        <c:out value="User ${recommendation.userName} reccomend u!" />
        <td><input type="hidden" name="recommendatorId" value="${recommendation.userId}"/></td>
        <td><input type="submit" value="See his recommendation"/></td>
      </c:otherwise>
    </c:choose>
  </c:forEach>
</form:form>
<br>
<h2>Users, who ask u to recommend them:</h2>
<form:form action="/users/giverecommendation" method="GET">
  <c:forEach var="recommendation" items="${myRecommendations}">
    <c:choose>
      <c:when test = "${empty recommendation.text}">
        <c:out value="U did not write recommendation for user ${recommendation.userName} yet!" />
        <td><input type="hidden" name="recommendatorId" value="${recommendation.userId}"/></td>
        <td><input type="submit" value="Give recommendation"/></td>
      </c:when>
      <c:otherwise>
        <c:out value="U reccomend user ${recommendation.userName}!" />
        <td><input type="hidden" name="recommendatorId" value="${recommendation.userId}"/></td>
        <td><input type="submit" value="See recommendation"/></td>
      </c:otherwise>
    </c:choose>
  </c:forEach>
</form:form>
</h3>

