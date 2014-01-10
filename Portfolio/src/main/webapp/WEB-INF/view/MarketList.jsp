<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Market Form</title>
</head>
<body>

<div id="global">
  <table>
    <tr>
      <td>ID</td><td>Market Short Code</td><td>Description</td><td>Action</td>
    </tr>
    <c:forEach items="${market_list}" var="marketItem">
      <tr>
        <td><c:out value="${marketItem.id}" /></td>
        <td><c:out value="${marketItem.shortCode }" /></td>
        <td><c:out value="${marketItem.description }" /></td>
        <spring:url value="/markets/{marketId}/edit" var="editMarketUrl">
          <spring:param name="marketId" value="${marketItem.id}" />
        </spring:url>
        <spring:url value="/markets/{marketId}/delete" var="deleteMarketUrl">
          <spring:param name="marketId" value="${marketItem.id}" />
        </spring:url>
        <td><a href="${editMarketUrl}">Edit</a> | <a href="${deleteMarketUrl}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  <br/>
  <a href="<spring:url value='/markets/new'/>">Add Market</a>
</div>

</body>
</html>