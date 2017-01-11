<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>out</title>
  </head>
  <body>
    <%@include file="/back.jsp" %>
    <%
      out.println("use out object");
      out.println("<br/>");
      out.println("红豆生南国，");
      out.println("<br/>");
      out.println("春来发几枝。");
      out.println("<br/>");
      out.println(out.getBufferSize());
      out.println("before clear");
      out.println("<br/>");
      out.clear();
      out.clearBuffer();
      out.println("after clear");
      out.println("<br/>");
      out.println(out.getBufferSize());
      out.println("<br/>");
      out.flush(); //冲洗的意思，将buffer（缓存）从内存中冲出去
      /* flush之后调用clear会报错Caused by: java.io.IOException: 
          Error: Attempt to clear a buffer that's already been flushed
      */
      //out.clear();
      /*
         flush之后使用clearBuffer不会报错，为什么？
      */
      out.clearBuffer();
      out.println("愿君多采撷，");
      out.println("<br/>");
      out.println("此物最相思。");
    %>
  </body>
</html>