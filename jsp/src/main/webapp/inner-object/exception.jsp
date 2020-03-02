<%@ page language="java" contentType="text/html; charset=utf-8" errorPage="answer-exception.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
  </head>
  <body>
    <h2> errorPage="answer-exception.jsp"</h2>
    <%
        session.setAttribute("errorPage", request.getServerName());
    %>

    <%
        System.out.println(1 / 0);
    %>
  </body>
</html>