<%@page import="xyz.yangchaojie.entity.Blog"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<%Blog b = (Blog)request.getAttribute("blog"); %>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><%=b.getBlog_time() %></title>
	<link rel="shortcut icon" href="<%=path %>/Blog/img/blogger_16px_1148729_easyicon.net.ico" type="image/x-icon"/>  

    <!-- Bootstrap Core CSS -->
    <link href="<%=path %>/Blog/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional fonts for this theme -->
    <link href="<%=path %>/Blog/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link href="http://cdn.bootcss.com/highlight.js/8.0/styles/monokai_sublime.min.css" rel="stylesheet">  
	<script src="http://cdn.bootcss.com/highlight.js/8.0/highlight.min.js"></script>  
	<script >hljs.initHighlightingOnLoad();</script>  
    <!-- Custom styles for this theme -->
    <link href="<%=path %>/Blog/css/clean-blog.min.css" rel="stylesheet">

    <!-- Temporary navbar container fix until Bootstrap 4 is patched -->
    <style>
    .img-responsive {
  display: inline-block;
  height: auto;
  max-width: 100%;
}
    .navbar-toggler {
        z-index: 1;
    }
    
    @media (max-width: 576px) {
        nav > .container {
            width: 100%;
        }
    }
    </style>

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar fixed-top navbar-toggleable-md navbar-light" id="mainNav">
        <div class="container">
            <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="index.html">Katrnia</a>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                     <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="<%=path%>/index/index.jsp">Index</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="<%=path%>/blogControl/blogPage.do">Technology Blog</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="<%=path%>/articleControl/articlePage.do">Article</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link page-scroll" href="<%=path%>/informalEssayControl/informalEssayPage.do">InformalEssay</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Page Header -->
    <header class="intro-header" style="background-image: url('<%=path%>/BlogImg/<%=b.getBlog_photourl()%>')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                    <div class="post-heading">
                        <h1><%=b.getBlog_title() %></h1>
                        <h2 class="subheading"><%=b.getBlog_intro() %></h2>
                        <span class="meta">Tag by:<a href="#"><%=b.getBlog_keyword() %></a>&nbsp;&nbsp;date:<%=b.getBlog_time() %></span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post Content -->
    <article>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                   <%=b.getBlog_content() %>
                </div>
            </div>
        </div>
    </article>

    <hr>

    <!-- Footer -->
   
    <!-- jQuery Version 3.1.1 -->
    <script src="<%=path %>/Blog/lib/jquery/jquery.js"></script>

    <!-- Tether -->
    <script src="<%=path %>/Blog/lib/tether/tether.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=path %>/Blog/lib/bootstrap/js/bootstrap.min.js"></script>

    <!-- Theme JavaScript -->
    <script src="<%=path %>/Blog/js/clean-blog.min.js"></script>

</body>

</html>
