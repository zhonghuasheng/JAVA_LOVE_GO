<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer List Page</title>
</head>
<body>
  <div style="margin-left:50px; margin-top:50px;margin-right:50px">
    <table class="table table-sm table-dark">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Store ID</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Email</th>
          <th scope="col">Address ID</th>
          <th scope="col">Active</th>
          <th scope="col">Create Date</th>
          <th scope="col">Last Update</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach items="${customers}" var="customer">
          <tr>
            <td>${customer.getCustomerId() }</td>
            <td>${customer.getStoreId() }</td>
            <td>${customer.getFirstName() }</td>
            <td>${customer.getLastName() }</td>
            <td>${customer.getEmail() }</td>
            <td>${customer.getAddressId() }</td>
            <td>${customer.isActive() }</td>
            <td>${customer.getCreateDate() }</td>
            <td>${customer.getLastUpdate() }</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>
</html>