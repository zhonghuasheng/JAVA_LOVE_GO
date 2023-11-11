<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
  </head>
  <body>
    <%
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (userName != null && "admin".equals(userName) &&
                password != null && "admin".equals(password)) {
            request.getRequestDispatcher("login-succeed.jsp")
                .forward(request, response);
        } else {
            response.setCharacterEncoding("utf-8");
            response.sendRedirect("login-failed.jsp");
        }
    %>
  </body>
</html>