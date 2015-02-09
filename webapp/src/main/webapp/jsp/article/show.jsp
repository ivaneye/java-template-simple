<%@ page import="com.webapp.domain.ArticleDomain" %>
<%@ page import="java.util.List" %>
<%@ page import="com.webapp.domain.UserDomain" %>
<%@ page import="com.webapp.util.AppContext" %>
<%@ page import="com.webapp.domain.PostDomain" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<% pageContext.setAttribute("_title", "文章详情"); %>

<%@include file="../template/header.jsp" %>


<div class="blog-header">
    <h1 class="blog-title">文章详情</h1>
    <a href="javascript:return 0;" id="_del">删除</a>
</div>

<%
    ArticleDomain article = (ArticleDomain) request.getAttribute("article");
    List<PostDomain> posts = (List<PostDomain>) request.getAttribute("posts");
%>
标题:<%=article.getTitle()%><br>
内容:<%=article.getContent()%><br>
<hr>
评论：<br>
<%
    for(PostDomain post : posts){
%>
<%=post.getContent()%><br>
<hr>
<%}%>
<hr>
<%
    if(name != null){
%>
<form class="navbar-form" action='/post/new' method='post' >
    <div class="form-group">
        内容:
        <textarea class="form-control" name='content'></textarea><br>
        <input type="hidden" name="artId" value="<%=article.getRecId()%>"/>
    </div>
    <br>
    <input type='submit' class="btn btn-default" value='提交'/>
</form>
<%}%>

<form method="post" action="/article/delete" id="delForm">
    <%--<input type="hidden" name="_method" value="DELETE"/>--%>
    <input type="hidden" name="recId" value="<%=article.getRecId()%>"/>
</form>
<script type="text/javascript">
    $(function(){
        $("#_del").click(function(){
            if(confirm("确认删除吗?")) {
                var _delForm = $("#delForm");
                delForm.submit();
            }
        })
    })
</script>
<%@include file="../template/footer.jsp" %>