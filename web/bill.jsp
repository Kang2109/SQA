<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> User
					Management App </a>
			</div>
                  

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
                                        
				<a href="#" class="navbar-brand">Log out
					 </a>
			
		</nav>
                                        
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
                    
			<h3 class="text-center">Thanh toan tien nuoc</h3>
			<hr>
			
			<br>
                        <div style="float: left">                
       <p>ID: ${byName.id}</p>    
       <p>Ten chu ho: ${byName.name}</p> 
        <p>Email: ${byName.email}</p> 
       <p>Dia chi: ${byName.address}</p> 
       <p>So dien thoai: ${byName.phonenumber}</p> 
           </div>
           <div style="float: right">
               <p>ID Nhân viên:dsfsdfsdf ${byName.id}</p>  
               <p>Họ tên:sdfsdfsd ${byName.id}</p>  
           </div>
       
      
       
                            
                                     
                                        
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Thang</th>
						<th>Chi so cu</th>
                                                <th>Chi so moi</th>
                                                <th>So tieu thu(m3)</th>
                                                <th>Tien nuoc</th>
                                                
					
						
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					

						<tr>
							<td>${u.id}</td>
							<td>${u.thang}</td>
							<td>${cscu.chiso}</td>
							<td>${u.chiso}</td>
                                                        <td>
                                                            
                     
                                                        </td>
                                                        <td>${sessionScope.tiennuoc}(VND)</td>
							
						</tr>
					
					<!-- } -->
				</tbody>
                                

			</table>
                                                        <div style="float: left">
                                                        <p>Mức nước 10m3 đầu tiên: 5973.0 (VND)</p>
                                                        <p>Mức nước 10 đến 20m3: 7052.0 (VND)</p>
                                                        <p>Mức nước 20 đến 30m3: 8669.0 (VND)</p>
                                                        <p>Trên 30m3: 15929.0 (VND)</p>
                                                        </div>
                                                        <div style="float: right">
                                                            <p>Thue GTGT (5%): ${sessionScope.tienthue} (VND)</p> 
                                                        <p>Phi BVMT (10%): ${sessionScope.tienbvmt}(VND)</p> 
                                                        <p>Tong tien: ${sessionScope.tongtien}(VND)</p> 
                                                        <a href="PaymentServlet?idwater=${u.id}" class="btn btn-success">Quay lại</a>
		</div>
	
</body>
</html>
