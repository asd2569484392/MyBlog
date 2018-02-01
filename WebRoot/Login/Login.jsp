<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="<%=path %>/Login/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=path %>/Login/css/animate.css">
	<link rel="stylesheet" href="<%=path %>/Login/css/style.css">


	<!-- Modernizr JS -->
	<script src="<%=path %>/Login/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body class="style-2">

		<div class="container">
			
			<div class="row">
				<div class="col-md-4">
					

					<!-- Start Sign In Form -->
					<form action="<%=path %>/accountControl/Login.do" method="post" class="fh5co-form animate-box" data-animate-effect="fadeInLeft">
						<h2>Log in</h2>
						<div class="form-group">
							<label for="username" class="sr-only">Username</label>
							<input type="text" class="form-control" id="username" placeholder="用户名" name = "username" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="password" class="sr-only">Password</label>
							<input type="password" class="form-control" id="password" placeholder="密码" name = "password" autocomplete="off">
						</div>
						<div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> 记住我</label>
						</div>
						<div class="form-group">
							<p>没有账号？ <a href="sign-up2.html"></a> | <a href="forgot2.html">去主页瞧瞧吧</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="登录" class="btn btn-primary">
						</div>
					</form>
					<!-- END Sign In Form -->

				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
			</div>
		</div>
	
	<!-- jQuery -->
	<script src="<%=path %>/Login/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=path %>/Login/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="<%=path %>/Login/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="<%=path %>/Login/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="<%=path %>/Login/js/main.js"></script>

	</body>
</html>

