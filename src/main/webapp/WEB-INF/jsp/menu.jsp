<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<table border=5 width=100% height=70>
  <tr>
     
    <td align="center" width=33%> 
      <h2><a href="/users/about" target=mainFrame>About Site</a></h2>
    </td>
    
    <td align="center">
      <h2><a href="/users/listUsers" target=mainFrame>List Users</a></h2>
    </td>
      
    <td align="center" width=33%> 
      <c:choose>
        <c:when test="${empty userName}">
          <table>
            <tr> <td> <a href="/users/register" target=mainFrame><h3>Register</h3></a> </td> </tr>
            <tr> <td> <a href="/users/login" target=mainFrame><h3>Enter</h3></a> </td> </tr>
          </table>
        </c:when>
        <c:otherwise>
          <table width=100%>
            <tr> 
              <td align="center" width=30%> <h3><c:out value="Hi, ${userName}!" default="NO DATA" escapeXml="true" /></h3> </td>
              <td align="center" rowspan = 2> <h2><a href="/users/main" target=mainFrame>My Cabinet</a></h2> </td>
            </tr>
            <tr> 
              <td align="center" width=30%>
                <h3>
                <form:form action="/users/leave" method="POST">
                  <input type="submit" value="Go out"/>
                </form:form>
                </h3> 
              </td>
            </tr>
          </table>
        </c:otherwise>
      </c:choose>
    </td> 
  </tr>
</table>