<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2022/3/4
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--
<c:foEach>:相当于for循环
items:被遍历的容器
var:遍历产生的临时变量
varStatus:遍历状态对象，{status.index}标识序号从0开始，{status.count}从1额开始
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>${user.username},欢迎你</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="stutas">
        <tr align="center">
            <td>${stutas.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <td><C:if test="${brand.status==1}">
                启用
            </C:if>
                <C:if test="${brand.status==0}">
                    禁用
                </C:if>
            </td>
            <td><a href="/brand-demo/selectByIdServlet?id=${brand.id}">修改</a>
                <a href="/brand-demo/delectServlet?id=${brand.id}">删除</a></td>
        </tr>

    </c:forEach>





</table>
<script>
document.getElementById("add").onclick=function (){
    location.href="/brand-demo/addBrand.jsp";
}
</script>
</body>
</html>