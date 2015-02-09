<%@ page import="com.webapp.domain.ArticleDomain" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<% pageContext.setAttribute("_title", "文章列表"); %>

<%@include file="../template/header.jsp" %>


<div class="blog-header">
    <h1 class="blog-title">文章列表</h1>
</div>

<%
    List<ArticleDomain> articles = (List<ArticleDomain>) request.getAttribute("articles");
    for(ArticleDomain article : articles){
%>
<div>
标题:<%=article.getTitle()%><br>
内容:<%=article.getContent()%><br>
<a href="/article/show/<%=article.getRecId()%>">查看全文</a>
<a href="javascript:return 0;" id="del_<%=article.getRecId()%>">删除</a>
<hr>
</div>
<%}%>

<script type="text/javascript">
    $(function(){
        $("a[id^='del_']").click(function(){
            if(confirm("确认删除吗?")) {
                var _this = $(this);
                var id = _this.attr("id").split("_")[1];
                $.post("/article/del", {recId: id}, function () {
                    _this.parent().remove();
                })
            }
        })
    })
</script>

<%@include file="../template/footer.jsp" %>