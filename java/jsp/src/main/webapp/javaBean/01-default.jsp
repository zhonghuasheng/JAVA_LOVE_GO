<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!-- 
    导入对应的model类
 -->
<%@ page import="com.jsp.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
  </head>
  <body>
    <%
        User user = new User();
        user.setName("ant");
        user.setAge(21);
    %>
    <p>User name: <%=user.getName() %></p>
    <p>User age: <%=user.getAge() %></p>
  </body>
</html>