<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<% pageContext.setAttribute("_title", "错误信息"); %>

<%@include file="template/header.jsp" %>


<div class="blog-header">
    <h1 class="blog-title">${_msg}</h1>
</div>


<%@include file="template/footer.jsp" %>