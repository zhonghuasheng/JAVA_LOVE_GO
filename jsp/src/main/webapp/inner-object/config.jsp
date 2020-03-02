<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
  </head>
  <body>
    <%
        out.println(config.getServletName());
        out.println("<br/>");

        Enumeration parameters = config.getInitParameterNames();
        while(parameters.hasMoreElements()) {
            out.println(String.valueOf(parameters.nextElement()));
            out.println("<br/>");
        }
    %>
  </body>
</html>