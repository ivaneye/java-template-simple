<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${_title}</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="/resource/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resource/css/blog.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/resource/js/jquery-1.11.2.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/resource/js/bootstrap.min.js"></script>
</head>
<body>

<div class="blog-masthead">
    <div class="container">
        <%--<nav class="blog-nav">
            <a class="blog-nav-item active" href="#">Home</a>
            <a class="blog-nav-item" href="#">New features</a>
            <a class="blog-nav-item" href="#">Press</a>
            <a class="blog-nav-item" href="#">New hires</a>
            <a class="blog-nav-item" href="#">About</a>
        </nav>--%>
        <%
            Cookie[] cookies = request.getCookies();
            String name = null;
            if(cookies != null) {
                for (Cookie c : cookies) {
                    System.out.println(c.getName() + "|" + c.getValue());
                    if (c.getName().equals("user")) {
                        String temp = c.getValue();
                        name = temp.split("_")[1];
                        break;
                    }
                }
            }
        %>
            <%
                if(name == null){
            %>
            <form class="navbar-form" action='/user/login' method='post'>
                <div class="form-group">
                    <input class="form-control" type='text' placeholder="name" name='name'/>
                    &nbsp;
                    <input class="form-control" type='password' placeholder="password" name='password'/>
                    <input type="hidden" name="path" value="<%=request.getRequestURI()%>"/>
                </div>
                <input type='submit' class="btn btn-default" value='登录'/>
            </form>
        <%}else{%>
                <%=name%>
                <a class="blog-nav-item active" href="/user/logout?path=<%=request.getRequestURI()%>">登出</a>
        <%}%>
    </div>
</div>

<div class="container">