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
				<li><a href="NVviewServlet"
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
                    
			<h3 class="text-center">Danh sách các tháng</h3>
			<hr>
			
			<br>
                        
                        <p>Mã KH: ${byName.id}</p>    
       <p>Họ tên: ${byName.name}</p> 
        <p>Email: ${byName.email}</p> 
       <p>Địa chỉ: ${byName.address}</p> 
       <p>Số điện thoại: ${byName.phonenumber}</p> 
       
      
       
                                <a href="NVWaterServlet?idclient=${byName.id}" class="btn btn-success">Tra cứu</a>
                                      
				
                                     
                                        
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tháng</th>
						<th>Chỉ số</th>
						<th>Trạng thái</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="u" items="${listWater}">

						<tr>
							<td><c:out value="${u.id}" /></td>
							<td><c:out value="${u.thang}" /></td>
							<td><c:out value="${u.chiso}" /></td>
							<td><c:out value="${u.trangthai}" /></td>
                                                        <c:if test="${u.trangthai!= 'Da dong'}">
					
				
                                                        <td><a href="NVPaymentServlet?idwater=${u.id}&thang=${u.thang}&idclient=${byName.id}">Thanh toán ngay </a></td>
							</c:if>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
