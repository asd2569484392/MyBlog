<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
	
<!DOCTYPE html>
<html class="no-js">
    
    <head>
    	<meta charset="utf-8"/>
        <title>Admin System</title>
        <!-- Bootstrap -->
        
        <link href="<%=path %>/Back/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/Back/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/Back/vendors/easypiechart/jquery.easy-pie-chart.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/Back/assets/styles.css" rel="stylesheet" media="screen">
        <script type="text/javascript" src="<%=path %>/Back/assets/json_parse.js"></script>
        <script type="text/javascript"  src="<%=path %>/Back/assets/Index.js"></script>
        <link href="<%=path %>/Back/common/jquery.min.js" rel="stylesheet" media="screen">
        
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="<%=path %>/Back/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
   		<script type="text/javascript">
   		function getTableList() {
    		var xmlhttp = null;
        		if(window.XMLHttpRequest){
        			xmlhttp = new XMLHttpRequest();
        		}else if(window.ActiveXObject){
        			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        		}
        		xmlhttp.onreadystatechange = function(){
        			if(xmlhttp.readyState == 4){
        				/* var sumList = eval('('+xmlhttp.responseText+')'); */
        				var jsonDate = xmlhttp.responseText;
        				var json = json_parse(jsonDate);
        				getArticleList(json);

        			}
        		};
        		xmlhttp.open("GET", "<%=path%>/back/index_getTableList_Ajax.do",true);
        		xmlhttp.send();
}
   		</script>
        
        <script type="text/javascript" >
        	
        	function getSumList(){
        		var xmlhttp = null;
        		if(window.XMLHttpRequest){
        			xmlhttp = new XMLHttpRequest();
        		}else if(window.ActiveXObject){
        			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        		}
        		xmlhttp.onreadystatechange = function(){
        			if(xmlhttp.readyState == 4){
        				/* var sumList = eval('('+xmlhttp.responseText+')'); */
        				var jsonDate = xmlhttp.responseText;
        				var json = json_parse(jsonDate);
        				var ipSum = json[0].number;
        				var articleSum = json[1].number;
        				var blogSum = json[2].number;
        				var draftsSum = json[3].number;
        				document.getElementById("ipSum").innerHTML = ipSum;
        				document.getElementById("articleSum").innerHTML = articleSum;
        				document.getElementById("blogSum").innerHTML = blogSum;
        				document.getElementById("draftsSum").innerHTML = draftsSum;
        			}
        		};
        		xmlhttp.open("GET", "<%=path%>/back/index_getSumList_Ajax.do",true);
        		xmlhttp.send();
        	}
        	window.onload = function (){
        	getSumList();
        	getTableList();
        	};
        </script>
       
       
    </head>
    <!--
    	作者：18805698598@163.com
    	时间：2018-01-11
    	描述：style="background-image: url(images/sunny.jpg); background-size:100%,100% ;"
    -->
    <body >
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container-fluid">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                     <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Admin System</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav pull-right">
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown"> <i class="icon-user"></i> <%=request.getSession().getAttribute("LoginOK") %><i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                            <a href="#myModal" data-toggle="modal" class="btn btn-primary">查看信息</a>
                                        
                                    </li>
                                    
                                    <li class="divider"></li>
                                    <li>
                                       <a tabindex="-1" href="<%=path%>/back/loginOut.do">注销 <i class="icon-off"></i></a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav">
                            <li class="active">
                                <a href="#">首页</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">日志 <b class="caret"></b>

                                </a>
                                <ul class="dropdown-menu" id="menu1">
                                    <li>
                                        <a href="<%=path%>/Back/log.jsp">Log

                                        </a>

                                       
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">跳转 <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                    <li>
                                        <a tabindex="-1" href="<%=path%>/index/index.jsp">主页</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="<%=path%>/blogControl/blogPage.do">博客</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="<%=path%>/informalEssayControl/informalEssayPage.do">随笔</a>
                                    </li>
                                    <li>
                                        <a tabindex="-1" href="<%=path%>/articleControl/articlePage.do">文章</a>
                                    </li>
                                   
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">状态 <i class="caret"></i>

                                </a>
                                <ul class="dropdown-menu">
                                  
                                    <li>
                                        <a tabindex="-1" href="http://asd2569484392.usa.j2ee.wang/jspwebadmin/">查看服务器信息</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!--/.nav-collapse -->
                </div>
            </div>
        </div>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="span3" id="sidebar">
                    <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li class="active">
                            <a href="<%=path%>/Back/index.jsp"><i class="icon-chevron-right"></i> 项目概述</a>
                        </li>
                        <li>
                            <a href="<%=path%>/back/readCalender.do"><i class="icon-chevron-right"></i> 留言面板</a>
                        </li>
                        <li>
                            <a href="<%=path%>/back/articlePage.do"><i class="icon-chevron-right"></i> 文章管理</a>
                        </li>
                        <li>
                            <a href="<%=path%>/back/blogPage.do"><i class="icon-chevron-right"></i>博客管理</a>
                        </li>
                          <li>
                            <a href="<%=path%>/back/informalEssayPage.do"><i class="icon-chevron-right"></i>随笔管理</a>
                        </li>
                        <li>
                            <a href="<%=path%>/back/draftsPage.do"><i class="icon-chevron-right"></i>草稿箱</a>
                        </li>
                        
                        <li>
                            <a href="<%=path%>/Back/Editor.jsp"><i class="icon-chevron-right"></i>添加博客&&文章</a>
                        </li>
                        
                        
                    </ul>
                </div>
                
                <!--/span-->
                <div class="span9" id="content">
                    <div class="row-fluid">
                       <!-- <div class="alert alert-success">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
                            <h4>Success</h4>
                        	The operation completed successfully</div>-->
                        	<div class="navbar">
                            	<div class="navbar-inner">
	                                <ul class="breadcrumb">
	                                    <i class="icon-chevron-left hide-sidebar"><a href='#' title="Hide Sidebar" rel='tooltip'>&nbsp;</a></i>
	                                    <i class="icon-chevron-right show-sidebar" style="display:none;"><a href='#' title="Show Sidebar" rel='tooltip'>&nbsp;</a></i>
	                                    <li>
	                                        <a href="#">项目概述</a>
	                                    </li>
	                                   
	                                </ul>
                            	</div>
                        	</div>
                    	</div>
                    <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">数量统计</div>
                                <div class="pull-right"><a href = "#" onclick="getSumList()"><span class="badge badge-important">刷新</span></a>

                                </div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span3">
                                   <h1 id = "ipSum" class="text-center" style="line-height: 95px;">0</h1>
                                    <div class="chart-bottom-heading"><span class="label label-success">总访问量</span>

                                    </div>
                                </div>
                                <div class="span3">
                                   <h1 id = "articleSum" class="text-center" style="line-height: 95px;">0</h1>
                                    <div class="chart-bottom-heading"><span class="label label-inverse">文章总数</span>

                                    </div>
                                </div>
                                <div class="span3">
                                   <h1 id = "blogSum" class="text-center" style="line-height: 95px;">0</h1>
                                    <div class="chart-bottom-heading"><span class="label label-inverse">博客总数</span>

                                    </div>
                                </div>
                                <div class="span3">
                                   <h1 id = "draftsSum" class="text-center" style="line-height: 95px;">0</h1>
                                    <div class="chart-bottom-heading"><span class="label label-warning">当前草稿</span>

                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">随笔</div>
                                    <div class="pull-right"><span class="badge badge-info"></span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                               <th>id</th>
                                                <th>标题</th>
                                                <th>作者</th>
                                                <th>时间</th>
                                            </tr>
                                        </thead>
                                        <tbody id = "informalEssayTable">
                                           
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">文章</div>
                                    <div class="pull-right"><span class="badge badge-info"></span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>标题</th>
                                                <th>关键字</th>
                                                <th>时间</th>
                                            </tr>
                                        </thead>
                                        <tbody id = "articleTable">
                                        <%--   <%for(Article article:articleList){ %>
                                          	<tr>
                                                <th><%=article.getId() %></th>
                                                <th><%=article.getArticle_title() %></th>
                                                <th><%=article.getArticle_keyword() %></th>
                                                <th><%=article.getArticle_time() %></th>
                                            </tr>
                                          <%} %> --%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                    </div>
                    <div class="row-fluid">
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">博客</div>
                                    <div class="pull-right"><span class="badge badge-info"></span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>标题</th>
                                                <th>关键字</th>
                                                <th>时间</th>
                                            </tr>
                                        </thead>
                                        <tbody id = "blogTable">
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                        <div class="span6">
                            <!-- block -->
                            <div class="block">
                                <div class="navbar navbar-inner block-header">
                                    <div class="muted pull-left">草稿</div>
                                    <div class="pull-right"><span class="badge badge-info"></span>

                                    </div>
                                </div>
                                <div class="block-content collapse in">
                                    <table class="table table-striped">
                                        <thead>
                                            <tr>
                                                <th>id</th>
                                                <th>标题</th>
                                                <th>类型</th>
                                                <th>时间</th>
                                                
                                            </tr>
                                        </thead>
                                        <tbody id = "draftsTable">
                                           
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <!-- /block -->
                        </div>
                    </div>
                    <div class="row-fluid">
                        <!-- block -->
                        <!--<div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">Gallery</div>
                                <div class="pull-right"><span class="badge badge-info">1,462</span>

                                </div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="row-fluid padd-bottom">
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                </div>

                                <div class="row-fluid padd-bottom">
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                </div>

                                <div class="row-fluid padd-bottom">
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                  <div class="span3">
                                      <a href="#" class="thumbnail">
                                        <img data-src="holder.js/260x180" alt="260x180" style="width: 260px; height: 180px;" src="data:image/png;base64,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">
                                      </a>
                                  </div>
                                </div>
                            </div>
                        </div>-->
                        <!-- /block -->
                    </div>
                </div>
            </div>
            <hr>
            <div id="myModal" class="modal hide">
											<div class="modal-header">
												<button data-dismiss="modal" class="close" type="button">&times;</button>
												<h3><%=request.getSession().getAttribute("LoginOK") %></h3>
											</div>
											<div class="modal-body">
												<p>管理员,开发者</p>
											</div>
										</div>
            <footer>
                <p>&copy; Vincent Gabriel 2013 - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="cssmoban">cssmoban</a>
            </footer>
        </div>
        <!--/.fluid-container-->
        <script src="<%=path %>/Back/vendors/jquery-1.9.1.min.js"></script>
        <script src="<%=path %>/Back/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=path %>/Back/vendors/easypiechart/jquery.easy-pie-chart.js"></script>
        <script src="<%=path %>/Back/assets/scripts.js"></script>
         <script>
        $(function() {
            // Easy pie charts
            $('.chart').easyPieChart({animate: 1000});
        });
        </script>
    </body>

</html>