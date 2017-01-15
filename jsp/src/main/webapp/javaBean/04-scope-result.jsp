<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="com.jsp.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <div>
      <h3>scope=application</h3>
      User name: <%=((User) application.getAttribute("applicationUser")).getName() %>
    </div>
    <div>
      <h3>scope=session</h3>
      User name: <%=((User) session.getAttribute("sessionUser")).getName() %>
    </div>
        <div>
      <h3>scope=request</h3>
      <%
          String requestName = "";
          if (pageContext.getAttribute("requestUser") != null) {
              requestName = ((User) pageContext.getAttribute("requestUser")).getName();
          }
      %>
      User name: <%=requestName %>
    </div>
        <div>
      <h3>scope=page</h3>
      <%
          String name = "";
          if (pageContext.getAttribute("pageUser") != null) {
              name = ((User) pageContext.getAttribute("pageUser")).getName();
          }
      %>
      User name: <%=name %>
    </div>
  </body>
</html>