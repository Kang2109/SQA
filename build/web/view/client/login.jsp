<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Đăng nhập</title>

        <c:url value="/static/client/css/login.css" var="logincss"></c:url>
        <link href="${logincss}" rel="stylesheet" type="text/css" media="all">

    </head>
    <body>

        <div class="main-container">
            <form method="post">
                <div class="imgcontainer">
                  
                    <h1>Hệ thống quản lý tiền nước</h1>
                </div>

                <div class="container">
                    <label for="uname"><b>Tên tài khoản</b></label>
                    <input type="text" placeholder="Email/Số điện thoại/Tên đăng nhập" id="usernameInput" name="uname" required>

                    <label for="psw"><b>Mật khẩu</b></label>
                    <input type="password" placeholder="Password" id="passwordInput" name="psw" required>
                    <div class="clearfix">
                        <button type="button" class="cancelbtn" onclick="cancel()">Hủy</button>
                        <button type="button" class="signinbtn" onclick="loginUser()">Đăng nhập</button>
                    </div>
                    <label>Bạn chưa có tài khoản? <a style="text-decoration: none;" href="/Smartphone/view/client/signup.jsp">Thêm tài khoản ngày!</a></label>
                </div>
            </form>
        </div>

        <c:url value="/static/client/js/login.js" var="test"></c:url>
        <script src="${test}"></script>
    </body>
</html>

<script>
                            function cancel() {
                                location.replace("http://localhost:8080/Smartphone/view/client/dashboard.jsp");
                            }
</script>
