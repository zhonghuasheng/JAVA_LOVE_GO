<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>application</title>
  </head>
  <body>
    <%@include file="/back.jsp" %>
    <%
    Enumeration attributes = application.getAttributeNames();

    out.println("<br/>");
    while(attributes.hasMoreElements()) {
        out.println(String.valueOf(attributes.nextElement()));
        out.println("<br/>");
    }
    %>
  </body>
</html>