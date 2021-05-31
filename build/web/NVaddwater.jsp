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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				
					<form action="addWServlet" method="post">
				
				
					
			

				<caption>
					<h2>
						
						
            			Thêm tháng mới
					</h2>
				</caption>

			

				<fieldset class="form-group">
					<label>Tháng</label> 
                                        <select name="thang">
                                            <option value="1">1</option>
                                            <option value="2">2</option>
                                            <option value="3">3</option>
                                            <option value="4">4</option>
                                
                                            <option value="5">5</option>
                                            <option value="6">6</option>
                                            <option value="7">7</option>
                                            <option value="8">8</option>
                                            <option value="9">9</option>
                                            <option value="10">10</option>
                                            <option value="11">11</option>
                                            <option value="12">12</option>
                                 
                                  </select>
                                 </fieldset>
                                 <fieldset class="form-group">
					<label>Năm</label> <input type="text"
						 class="form-control"
						name="nam">
				</fieldset>

				<fieldset class="form-group">
					<label>Chỉ số</label> <input type="text"
						 class="form-control"
						name="chiso">
				</fieldset>
                                           
				

				<button type="submit" class="btn btn-success">Thêm</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
