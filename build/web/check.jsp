<%-- 
    Document   : login
    Created on : May 19, 2021, 11:12:09 AM
    Author     : duyqu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       ID client ${sessionScope.idclient}
       ID Water ${sessionScope.idwater}
        ${sessionScope.cscu}
        
        ${sessionScope.tieuthu}
        ${sessionScope.tiennuoc}
        ${sessionScope.tienthue}
        ${sessionScope.phibvmt}
        ${sessionScope.tongtien}
        <form action="addBillServlet"method="post">
            idclient:<input type="text" name ="idclient" value="${sessionScope.idclient}"/><br>
            idwater:<input type="text" name ="idwater" value="${sessionScope.idwater}"/><br>   
            cscu:<input type="text" name ="cscu" value="${sessionScope.cscu}"/><br>
            tieuthu:<input type="text" name ="tieuthu" value="${sessionScope.tieuthu}"/><br>
            password:<input type="text" name ="tiennuoc"value="${sessionScope.tiennuoc}"/><br>  
            tiennuoc:<input type="text" name ="tienthue" value="${sessionScope.tienthue}"/><br>
            phibvmt:<input type="text" name ="phibvmt" value="${sessionScope.phibvmt}"/><br>  
            tongtien:<input type="text" name ="tongtien" value="${sessionScope.tongtien}"/><br>
            
            <input type="submit" value="login"/>
        </form>
    </body>
</html>
