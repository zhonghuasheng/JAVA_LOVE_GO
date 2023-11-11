<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <jsp:useBean id="user" class="com.jsp.model.User"></jsp:useBean>
    <%-- *表示自动匹配，javaBean中的属性和表单穿过来的name自动匹配，比如表单传过来name，就会和user中的name匹配上 --%>
    <jsp:setProperty property="*" name="user"/>
    <%--下面表达式中的user是上面使用javaBean声明的user对象 --%>
    <p>User name:<%=user.getName() %></p>
    <p>Age:<%=user.getAge() %></p>
    <jsp:useBean id="account" class="com.jsp.model.Account"></jsp:useBean>
    <%--这里的property指定了id，那么就会根据表单穿过来的数据匹配id，至于UUID则不会匹配 --%>
    <%--如果account和user都有name属性，怎么自动匹配，setProperty有其他的匹配方式直接指定到了request对象中的参数名 --%>
    <jsp:setProperty property="id" name="account"/>
    <p>Account ID: <%=account.getId() %></p>
    <p>Account UUID: <%=account.getUuid() %></p>
    <jsp:useBean id="school" class="com.jsp.model.School"></jsp:useBean>
    <jsp:setProperty property="id" name="school" param="schoolId"/>
    <jsp:setProperty property="name" name="school" param="schoolName"/>
    <p><%=school.getId() %></p>
    <p><%=school.getName() %></p>
  </body>
</html>