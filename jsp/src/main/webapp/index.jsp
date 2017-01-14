<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>out</title>
  </head>
  <body>
    <%
        out.println(request.getParameter("userName") == null ? "" : request.getParameter("userName"));
        out.println(request.getAttribute("hello") == null ? "" : request.getAttribute("hello"));
    %>
    <h3>Inner Object</h3>
    <div class="mod">
      application: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
    <div class="mod">
      page: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
    <div class="mod">
      pageContext: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
    <div class="mod">
      config: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
    <div class="mod">
      out: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
    <div class="mod">
      request: <a href="inner-object/request-get.jsp">request-get.jsp</a>
      request: <a href="inner-object/request-get.jsp">request-post.jsp</a>
    </div>
    <div class="mod">
      response: <a href="inner-object/response-sendRedirect.jsp">response-sendRedirect.jsp</a>
      response: <a href="inner-object/response-forward.jsp">response-forward.jsp</a>
    </div>
    <div class="mod">
      session: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
        <div class="mod">
      exception: <a href="inner-object/out.jsp">out.jsp</a>
    </div>
  </body>
</html>