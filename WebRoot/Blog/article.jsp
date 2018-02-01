<%@page import="xyz.yangchaojie.entity.Article"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

<head>
<%List<Article> articleList =(List<Article>) request.getAttribute("articleList");%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Article</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=path %>/Blog/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="<%=path %>/Blog/img/blogger_16px_1148729_easyicon.net.ico" type="image/x-icon"/>  

    <!-- Additional fonts for this theme -->
    <link href="<%=path %>/Blog/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='<%=path %>/Blog/https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='<%=path %>/Blog/https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="<%=path %>/Blog/css/style.css"> <!-- Resource style -->
    <!-- Custom styles for this theme -->
    <link href="<%=path %>/Blog/css/clean-blog.min.css" rel="stylesheet">
	
    <!-- Temporary navbar container fix until Bootstrap 4 is patched -->
    <style>
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
            <a class="navbar-brand page-scroll" href="index.html">Katrina</a>
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
    <header class="intro-header" style="background-image: url('<%=path %>/Blog/img/2559b11d0ed9cf10536039734b27c458bf732047.jpg')">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                    <div class="site-heading">
                        <h1>Article</h1>
                        <span class="subheading">文章</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                <%for(Article a:articleList){%>
                <div class="post-preview">
                    <a href="<%=path%>/articleControl/readArticle.do?id=<%=a.getId()%>">
                        <h2 class="post-title">
                            <%=a.getArticle_title() %>
                        </h2>
                        <h3 class="post-subtitle">
							<%=a.getArticle_intro() %>
                        </h3>
                    </a>
                    <p class="post-meta">Tag by:<a href="<%=path%>/articleControl/articlePage.do?tag=<%=a.getArticle_keyword()%>"><%=a.getArticle_keyword() %></a>&nbsp;&nbsp;date:<%=a.getArticle_time() %></p>
                </div>
                <hr>
                <%} %>
            <ul id = "pagination1" class="cd-pagination no-space move-buttons custom-icons">
						<!-- <li class="button"><a href="#0">Prev</a>
						<li><a href="#0">1</a>
						<li><a href="#0">2</a>
						<li><a class="current" href="#0">3</a>
						<li><a href="#0">4</a>
						<li><span>...</span>
						<li><a href="#0">20</a>
						<li class="button"><a href="#0">Next</a> -->
					</ul>
            </div>
        </div>
    </div>

    <hr>

    <!-- Footer -->
    <!-- <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 offset-lg-2 col-md-10 offset-md-1">
                    <ul class="list-inline text-center">
                        <li class="list-inline-item">
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                        <li class="list-inline-item">
                            <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                            </a>
                        </li>
                    </ul>
                    <p class="copyright text-muted">Copyright &copy; Your Website 2017. More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
                </div>
            </div>
        </div>
    </footer> -->
	<script type="text/javascript" src="<%=path %>/Blog/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/Blog/js/jquery.page.js"></script>
    <script type="text/javascript">
    $("#pagination1").createPage({
					pageCount :<%=request.getAttribute("pageCount")%>,
					current : <%=request.getAttribute("currentPageNum")%>,
					backFn : function(p) {
					//alert(p);
					window.location.href="<%=path%>/articleControl/articlePage.do?p="+p;
		}
	});
   
</script>
<script type="text/javascript">
	
</script>
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
