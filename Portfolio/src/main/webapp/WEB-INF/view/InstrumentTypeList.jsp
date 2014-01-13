<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="fragments/cssAndjs.jsp" />
<title>Instrument Type</title>
</head>
<body>

<jsp:include page="fragments/bodyHeader.jsp" />

<div id="global">
  <table class="color-table">
    <tr>
      <td>ID</td><td>Instrument Type Name</td><td>Action</td>
    </tr>
    <c:forEach items="${instrumentType_list}" var="item">
      <tr>
        <td><c:out value="${item.id}" /></td>
        <td><c:out value="${item.name}" /></td>
        <spring:url value="/instrumentTypes/{id}/edit" var="editInstrumentTypeUrl">
          <spring:param name="id" value="${item.id}" />
        </spring:url>
        <spring:url value="/instrumentTypes/{id}/delete" var="deleteInstrumentTypeUrl">
          <spring:param name="id" value="${item.id}" />
        </spring:url>
        <td><a href="${editInstrumentTypeUrl}">Edit</a> | <a href="${deleteInstrumentTypeUrl}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  <br/>
  <a href="<spring:url value='/instrumentTypes/new'/>">Add Instrument Type</a>
</div>

<jsp:include page="fragments/bodyFooter.jsp" />

</body>
</html>