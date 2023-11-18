<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <%--useBean对象的scope有application session request page(this) --%>
    <jsp:useBean id="user" class="com.jsp.model.User" scope="page"></jsp:useBean>
    <jsp:setProperty property="*" name="user"/>
    User Name: <jsp:getProperty property="name" name="user"/>
    Age: <jsp:getProperty property="age" name="user" />
  </body>
</html>