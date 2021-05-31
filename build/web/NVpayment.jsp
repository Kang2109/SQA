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
                    
			<h3 class="text-center">Thanh toán tiền nước</h3>
			<hr>
			
			<br>
                        
                        <p>Mã KH: ${byName.id}</p>    
       <p>Họ tên: ${byName.name}</p> 
        <p>Email: ${byName.email}</p> 
       <p>Địa chỉ: ${byName.address}</p> 
       <p>Số điện thoại: ${byName.phonenumber}</p> 

       
      
       
                            
                                     
                                        
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Tháng</th>
						<th>Chỉ số cũ</th>
                                                <th>Chỉ số mới</th>
                                                <th>Số tiêu thụ(m3)</th>
                                                <th>Tiền nước</th>
                                                
					
						
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
                                                            ${sessionScope.tieuthu}
                                                </td>
                                                        <td>${sessionScope.tiennuoc} (VND)</td>
							
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
                                                            <p>Thuế GTGT (5%): ${sessionScope.tienthue} (VND)</p> 
                                                        <p>Phí BVMT (10%): ${sessionScope.phibvmt} (VND)</p> 
                                                        <p>Tổng tiền: ${sessionScope.tongtien} (VND)</p> 
                                                        <a href="NVAddBillServlet"
                                                           class="btn btn-success">Thanh toán</a>
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                       
		</div>
	
</body>
</html>
