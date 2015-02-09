<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<% pageContext.setAttribute("_title", "新建文章"); %>

<%@include file="../template/header.jsp" %>


<div class="blog-header">
    <h1 class="blog-title">新建文章</h1>
</div>

<form class="navbar-form" action='/article/new' method='post' enctype="multipart/form-data">
    <div class="form-group">
        标题:<input class="form-control" type='text' name='title'/><br>
        内容:
        <textarea class="form-control" name='content'></textarea><br>
    </div>
    <br>
    <input type='submit' class="btn btn-default" value='提交'/>
</form>

<%@include file="../template/footer.jsp" %>