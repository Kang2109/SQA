<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Đăng nhập</title>
        
        <style>
            *{
    padding: 0px;
    margin: 0px;
    font-family: sans-serif;
    box-sizing: border-box;
}
header{
    background-color: #cccccc;
    min-height: 70px;
    padding: 15px;
}
main{
    background-color: #dddddd;
    min-height: 300px;
    padding: 7.5px 15px;
}
footer{
    background-color: #cccccc;
    min-height: 70px;
    padding: 15px;
}
.container{
    width: 100%;
    max-width: 1200px;
    margin-left: auto;
    margin-right: auto;
}
.login-form{
    width: 100%;
    max-width: 400px;
    margin: 20px auto;
    background-color: #ffffff;
    padding: 15px;
    border: 2px dotted #cccccc;
    border-radius: 10px;
}
h1{
    color: #009999;
    font-size: 20px;
    margin-bottom: 30px;
}
.input-box{
    margin-bottom: 10px;
}
.input-box input{
    padding: 7.5px 15px;
    width: 100%;
    border: 1px solid #cccccc;
    outline: none;
}
.btn-box{
    text-align: right;
    margin-top: 30px;
}
.btn-box button{
    padding: 7.5px 15px;
    border-radius: 2px;
    background-color: #009999;
    color: #ffffff;
    border: none;
    outline: none;
}
        </style>
    </head>
    <body>
        
        <main>
            <div class="container">
            <div class="login-form">
                <form action="LoginServlet" method="post">
                    <h1>Hệ thống thanh toán tiền nước</h1>
                    <div class="input-box">
                        <i ></i>
                        <label><b>Tên đăng nhập</b></label>
                        <input type="text"  name="username">
                    </div>
                    <div class="input-box">
                        <i ></i>
                        <label><b>Mật khẩu</b></label>
                        <input type="password" name="password">
                    </div>
                    <p>${wrong}</p>
                    <div class="btn-box">
                        
                        <button type="reset">
                            Hủy
                        </button>
                        <button type="submit">
                            Đăng nhập
                        </button>
                    </div>
                </form>
            </div>
            </div>
        </main>
      
    </body>
</html>
