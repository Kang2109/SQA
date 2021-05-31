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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${client != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${client == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${client != null}">
            			Sửa thông tin khách hàng
            		</c:if>
						<c:if test="${client == null}">
            			Thêm mới khách hàng
            		</c:if>
					</h2>
				</caption>

				<c:if test="${client != null}">
					<input type="hidden" name="id" value="<c:out value='${client.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Họ tên</label> <input type="text"
						value="<c:out value='${client.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>
                                <fieldset class="form-group">
					<label>Địa chỉ</label> <input type="text"
						value="<c:out value='${client.address}' />" class="form-control"
						name="address" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${client.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Số điện thoại</label> <input type="text"
						value="<c:out value='${client.phonenumber}' />" class="form-control"
						name="phonenumber">
				</fieldset>

				<button type="submit" class="btn btn-success">Lưu</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
