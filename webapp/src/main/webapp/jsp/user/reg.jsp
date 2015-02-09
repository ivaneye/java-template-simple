<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<% pageContext.setAttribute("_title", "用户注册"); %>

<%@include file="../template/header.jsp" %>


<div class="blog-header">
    <h1 class="blog-title">用户注册</h1>
</div>

<form class="navbar-form" action='/user/reg' method='post' enctype="multipart/form-data">
    <div class="form-group">
        用户名:<input class="form-control" type='text' name='name'/><br>
        密码:<input class="form-control" type='password' name='password'/><br>
    </div>
    <br>
    <input type='submit' class="btn btn-default" value='注册'/>
</form>

<%@include file="../template/footer.jsp" %>