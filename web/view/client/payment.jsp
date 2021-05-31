<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Hóa đơn thanh toán</title>
        <c:url value="/static/admin/css/admin.css" var="bootstrap"></c:url>
        <link href="${bootstrap}" rel="stylesheet" type="text/css" media="all">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <!-- phai co link phia duoi nay nhe -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>

    </head>

    <body>
        <div class="container">
            <div class="navbar">
                <div class="admin">
                    <a href="#home"><i class="fa fa-wrench"></i> Thanh toán tiền nước</a>
                </div>

                <div class="dropdown">
                    <button class="dropbtn">Xin chào ${user.name} !
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="#">Thông tin cá nhân</a>
                        <a href="#">Cài đặt</a>
                        <hr />
                        <a href="/Smartphone/view/admin/login.jsp"Đăng xuất</a>
                    </div>
                </div>
            </div>

            
            <div class="add-content">

                <br>
                <h2 align="center">Hóa đơn thanh toán</h2>
                <div class="add-table">
                    <div class="hr">
                        <hr>
                    </div>
                    <form method="post" id="ha">
                        <label for="exampleInputName">Nhà cung cấp</label>
                        <input id="nameInput" type="text" name="name" required="">
                        <div class="hr">
                            <hr>
                        </div>
                        <label>Mã khách hàng</label>
                        <input id="phoneInput" type="text" name="phone" class="lock">
                        <div class="hr">
                            <hr>
                        </div>
                        <label>Khách hàng</label>
                        <input id="addressInput" type="text" name="address" class="lock">
                        <div class="hr">
                            <hr>
                        </div>
                        <label for="exampleInputUsername">Số diện thoại</label>
                        <input id="usernameInput" type="text" name="username" required="">
                        <div class="hr">
                            <hr>
                        </div>
                        <label for="exampleInputPassword">Địa chỉ</label>
                        <input id="passwordInput" type="password" name="password" class="lock">
                        <div class="hr">
                            <hr>
                            <label for="exampleInputPassword">Số tiền</label>
                        <input id="passwordInput" type="password" name="password" class="lock">
                        <div class="hr">
                            <hr>
                        <label for="exampleInputPassword">Kỳ thanh toán</label>
                        <input id="passwordInput" type="password" name="password" class="lock">
                        <div class="hr">
                            
                        <div class="hr">
                            <hr>
                        </div>
                        <input type="button" name="addUser" id="submit" value="Thanh toán" onclick="insertUser()"> </br>
                    </form>
                </div>
            </div>
        </div>

    </body>

</html>