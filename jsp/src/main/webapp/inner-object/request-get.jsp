<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>request</title>
  </head>
  <body>
    <%
        out.println("request.getSchema:");
        out.println(request.getScheme());
        out.println("<br/>");
        out.println(request.getServerName());
        out.println("<br/>");
        out.println(request.getServerPort());
        out.println("<br/>");
        out.println(request.getContextPath());
        out.println("<br/>");
        out.println(request.getServletContext());
        out.println("<br/>");
        out.println(request.getServletPath());
    %>
    <form name="login" action="answer-request-get.jsp" method="get">
    User name: <input type="text" name="userName" />
    Password: <input type="password" name="password" />
    <input type="submit" name="submit">Login</input>
    </form>
  </body>
</html>