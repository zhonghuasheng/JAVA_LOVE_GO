<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <jsp:useBean id="applicationUser" class="com.jsp.model.User" scope="application"></jsp:useBean>
    <jsp:setProperty property="*" name="applicationUser"/>
    <jsp:useBean id="sessionUser" class="com.jsp.model.User" scope="session"></jsp:useBean>
    <jsp:setProperty property="*" name="sessionUser"/>
    <jsp:useBean id="requestUser" class="com.jsp.model.User" scope="request"></jsp:useBean>
    <jsp:setProperty property="*" name="requestUser"/>
    <jsp:useBean id="pageUser" class="com.jsp.model.User" scope="page"></jsp:useBean>
    <jsp:setProperty property="*" name="pageUser"/>

    <h1>scope=applicatioin</h1>
    <div>
      <p>User name: <jsp:getProperty property="name" name="applicationUser"/></p>
      <p>Age: <jsp:getProperty property="age" name="applicationUser"/></p>
    </div>
    <h1>scope=session</h1>
    <div>
      <p>User name: <jsp:getProperty property="name" name="sessionUser"/></p>
      <p>Age: <jsp:getProperty property="age" name="sessionUser"/></p>
    </div>
    <h1>scope=request</h1>
    <div>
      <p>User name: <jsp:getProperty property="name" name="requestUser"/></p>
      <p>Age: <jsp:getProperty property="age" name="requestUser"/></p>
    </div>
    <h1>scope=page</h1>
    <div>
      <p>User name: <jsp:getProperty property="name" name="pageUser"/></p>
      <p>Age: <jsp:getProperty property="age" name="pageUser"/></p>
    </div>
    <a href="04-scope-result.jsp">Go</a>
  </body>
</html>