<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2022/3/5
  Time: 21:28
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
<h3>修改品牌</h3>
<form action="/brand-demo/updateServlet" method="post">
<%--    隐藏域提交id--%>
    <input type="hidden" name="id" value="${brand.id}">
    品牌名称：<input type="text" name="brandName" value="${brand.brandName}"><br>
    企业名成：<input type="text" name="companyName"  value ="${brand.companyName}"><br>
    排序：    <input type="text" name="ordered"  value ="${brand.ordered}"><br>
    描述信息：<textarea rows="5" cols="20" name ="brand.description">${brand.description}</textarea><br>
    状态信息：
      <C:if test="${brand.status==1}">
        <input type="radio" name="status" value="1"checked>启用
        <input type="radio" name="status" value="0">禁用<br>
    </C:if>
    <C:if test="${brand.status==0}">
        <input type="radio" name="status" value="1">启用
        <input type="radio" name="status" value="0"checked>禁用<br>
    </C:if>

    <input type="submit" value="提交">
</form>
</body>
<
</html>