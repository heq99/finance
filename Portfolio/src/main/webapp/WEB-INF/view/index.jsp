<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<jsp:include page="fragments/cssAndjs.jsp" />

<title>Portfolio</title>
</head>
<body>

  <jsp:include page="fragments/bodyHeader.jsp" />
  
  <div>
    <h2>Welcome</h2>
    <a href="<spring:url value="/markets" />">Manage Markets</a> <br/>
    <a href="<spring:url value="/instrumentTypes" />">Manage Instrument Types</a>
  </div>
  
  <jsp:include page="fragments/bodyFooter.jsp" />
  
</body>
</html>