<%-- 
    Document   : signup
    Created on : Nov 15, 2020, 2:15:08 AM
    Author     : Admin
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Đăng ký</title>

    <c:url value="/static/client/css/signup.css" var="logincss"></c:url>
    <link href="${logincss}" rel="stylesheet" type="text/css" media="all">

   
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>

</head>

<body>

    <form style="border:1px solid #ccc">
        <div class="container">

           
           
            <h1><span style="color: red"> Đăng ký!</h1>
            <p>Hãy điền thông tin đăng kí của bạn!</p>
            <hr>
            <label for="Username"><b>Tên tài khoản</b></label>
            <input id="usernameInput" type="text" placeholder="Tên đăng nhập" name="username" required>

            <label for="psw"><b>Mật khẩu</b></label>
            <input id="passwordInput" type="password" placeholder="Mật khẩu" name="psw" required>

            <label for="Username"><b>Họ và tên</b></label>
            <input id="nameInput" type="text" placeholder="Họ tên" name="name" required>

            <label for="Username"><b>Địa chỉ</b></label>
            <input id="addressInput" type="text" placeholder="Địa chỉ" name="address" required>

            <label for="Username"><b>Số điện thoại</b></label>
            <input id="phoneInput" type="text" placeholder="Số điện thoại" name="phone" required>

            <p>Bằng việc đăng kí, Bạn đã đồng ý về <a href="#" style="color:red">Điều khoản dịch vụ & Chính sách bản mật</a>.</p>

            <div class="clearfix">
                <button type="button" class="cancelbtn" onclick="cancelUser()">Cancel</button>
                <button type="button" class="signupbtn" onclick="insertUser()">Sign Up</button>
            </div>
        </div>
    </form>

<c:url value="/static/client/js/signup.js" var="test"></c:url>
<script src="${test}"></script>
</body>
</html>
<script>
                            function cancelUser() {
                                location.replace("http://localhost:8080/Smartphone/view/client/login.jsp");
                            }

</script>