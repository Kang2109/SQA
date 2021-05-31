<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Hệ thống thanh toán tiền nước</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

    <header>
        <div style="float: left;width: 90%" >
		<nav class="navbar navbar-expand-md navbar-dark"
                     style="background-color: #009999 "  >
			<div>
				<a href="#" class="navbar-brand">Hệ thống thanh toán tiền nước</a>
                            
			</div>
                    

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Khách hàng</a></li>
			
                                        
		</nav>
               
              </div>   
                                         <div style="float: right;width: 10%">
		<nav class="navbar navbar-expand-md navbar-dark"
                     style="background-color: gray">
			
                    <a href="<%=request.getContextPath()%>/LogoutServlet" class="navbar-brand" style="float:right ">
					Đăng xuất </a                       
		</nav>
               
              </div>              
	</header>
                               
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">Danh sách khách hàng</h3>
			<hr>
			<div class="container text-left">
   <a href="<%=request.getContextPath()%>/list" class="btn btn-success">
					Cập nhật</a>
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
					Thêm khách hàng</a>
                                <a href="showSignupServlet" class="btn btn-success">
					Thêm người dùng</a>     
                                        
                                        
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Mã KH</th>
						<th>Họ tên</th>
                                                <th>Địa chỉ</th>
						<th>Email</th>
						<th>Số điện thoại</th>
                                                <th>Giao dịch</th>
						<th>Quản lý</th>
                                                
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="client" items="${listClient}">

						<tr>
							<td><c:out value="${client.id}" /></td>
							<td><c:out value="${client.name}" /></td>
                                                        <td><c:out value="${client.address}" /></td>
							<td><c:out value="${client.email}" /></td>
							<td><c:out value="${client.phonenumber}" /></td>
                                                        <td><a href="more?id=<c:out value='${client.id}' />">Xem</a>
							<td><a href="edit?id=<c:out value='${client.id}' />">Sửa</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${client.id}' />">Xóa</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
