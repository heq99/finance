<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="fragments/cssAndjs.jsp" />
<title>
  <c:choose>
    <c:when test="${market['new']}">
      <c:set var="method" value="post"/>
      <c:set var="button" value="Add Market"/>
      Add Market
    </c:when>
    <c:otherwise>
      <c:set var="method" value="put"/>
      <c:set var="button" value="Update Market"/>
      Update Market
    </c:otherwise>
  </c:choose>
</title>
</head>
<body>

<jsp:include page="fragments/bodyHeader.jsp"/>

<div id="global">
  <form:form commandName="market" method="${method}">
    <fieldset>
      <legend>${button}</legend>
      <p>
        <label for="shortCode">Market Short Code: </label>
        <form:input id="shortCode" path="shortCode" />
      </p>
      <p>
        <label for="description">Market Description: </label>
        <form:textarea id="description" path="description" rows="5" cols="40"/>
      </p>
      <p id="buttons">
        <input id="reset" type="reset">
        <input id="submit" type="submit" value="${button}">
      </p>
    </fieldset>
  </form:form>
</div>

<jsp:include page="fragments/bodyFooter.jsp" />

</body>
</html>