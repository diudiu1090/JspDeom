<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2022/3/5
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h3>添加品牌</h3>
<form action="/brand-demo/addServlet" method="post">
    品牌名称：<input type="text" name="brandName"><br>
    企业名成：<input type="text" name="companyName"><br>
    排序：    <input type="text" name="ordered"><br>
    描述信息：<textarea rows="5" cols="20" name="description"></textarea><br>
    状态信息：
    <input type="radio" name="status" value="0">禁用
    <input type="radio" name="status" value="1">启用<br>
    <input type="submit" value="提交">
</form>
</body>

</html>
