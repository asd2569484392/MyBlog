<%@page import="xyz.yangchaojie.entity.InformalEssay"%>
<%@page import="xyz.yangchaojie.entity.Article"%>
<%@page import="xyz.yangchaojie.entity.Blog"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%List<InformalEssay> informalEssayList = (List<InformalEssay>)request.getAttribute("informalEssayList");%>

<!DOCTYPE html>
<html>
    
    <head>
  	<title>Tables</title>
	<meta charset="utf-8" />
    <!-- Bootstrap -->
 	<link href="<%=path %>/Back/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">        
 	<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
    <link href="<%=path %>/Back/assets/styles.css" rel="stylesheet" media="screen">
    <link href="<%=path %>/Back/assets/DT_bootstrap.css" rel="stylesheet" media="screen">
	<style type="text/css">
	.light-theme a, .light-theme span {
	float: left;
	color: #666;
	font-size:14px;
	line-height:24px;
	font-weight: normal;
	text-align: center;
	border: 1px solid #BBB;
	min-width: 14px;
	padding: 0 7px;
	margin: 0 5px 0 0;
	border-radius: 3px;
	box-shadow: 0 1px 2px rgba(0,0,0,0.2);
	background: #efefef; /* Old browsers */
	background: -moz-linear-gradient(top, #ffffff 0%, #efefef 100%); /* FF3.6+ */
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,#ffffff), color-stop(100%,#efefef)); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(top, #ffffff 0%,#efefef 100%); /* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(top, #ffffff 0%,#efefef 100%); /* Opera11.10+ */
	background: -ms-linear-gradient(top, #ffffff 0%,#efefef 100%); /* IE10+ */
	background: linear-gradient(top, #ffffff 0%,#efefef 100%); /* W3C */
}

.light-theme a:hover {
	text-decoration: none;
	background: #FCFCFC;
}

.light-theme .current {
	background: #666;

	color: #FFF;
	border-color: #444;
	box-shadow: 0 1px 0 rgba(255,255,255,1), 0 0 2px rgba(0, 0, 0, 0.3) inset;
	cursor: default;
}

.light-theme .ellipse {
	background: none;
	border: none;
	border-radius: 0;
	box-shadow: none;
	font-weight: bold;
	cursor: default;
}


</style>
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
    </head>
    
    <body>
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
                        <li >
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
                          <li class="active">
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
                      <div class="block">
                                              <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">随笔管理</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                   <div class="table-toolbar">
                                      <div class="btn-group">
                                         <a href="#"><button class="btn btn-success">添加新博客 <i class="icon-plus icon-white"></i></button></a>
                                      </div>
                                      
                                   </div>
                                    
                                    <table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example2">
                                        <thead>
                                            <tr>
                                                <th>标题</th>
                                                <th>作者</th>
                                                <th>时间</th>
                                                <th>查看</th>
                                                <th>编辑</th>
                                                <th>删除</th>
                                        
                                            </tr>
                                        </thead>
                                        <tbody>
                            		<%for(InformalEssay i:informalEssayList){ %>
                                            <tr class="odd gradeX">
                                            
                                                <td><%=i.getInformalessay_title() %></td>
                                                <td><%=i.getInformalessay_author() %></td>
                                                 <td><%=i.getInformalessay_time() %></td>
                                                <td><a href="<%=path%>/informalEssayControl/readInformalEssay.do?id=<%=i.getId()%>" class="btn"><i class="icon-eye-open"></i> View</a></td>
                                                <td class="center"> <a href="<%=path %>/back/UpdateInformalEssay.do?id=<%=i.getId() %>" class="btn btn-primary"><i class="icon-pencil icon-white"></i> Edit</a></td>
                                                <td class="center"><a href="<%=path %>/back/removeInformalEssay.do?id=<%=i.getId() %>" class="btn btn-danger"><i class="icon-remove icon-white"></i> Delete</a></td>
                                           		
                                            </tr>
                                            <%} %>
                                              
                                        </tbody>
                                    </table>
                                </div>
                                
                            </div>
                        </div>
                           
                        
                           <div class="light-theme" id="pagination1"></div>
</div>
    </div>
                        <!-- /block -->
                    </div>
                </div>
            <hr>
            <footer>
                <p>&copy; Vincent Gabriel 2013 - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="cssmoban">cssmoban</a>
            </footer>
        <!--/.fluid-container-->

          <script src="<%=path %>/Back/vendors/jquery-1.9.1.js"></script>
        <script src="<%=path %>/Back/bootstrap/js/bootstrap.min.js"></script>
        <script src="<%=path %>/Back/vendors/datatables/js/jquery.dataTables.min.js"></script>

		<script type="text/javascript" src="<%=path %>/Back/assets/jquery.min.js" ></script>
		<script type="text/javascript" src="<%=path %>/Back/assets/jquery.page.js" ></script>
        <script src="<%=path %>/Back/assets/scripts.js"></script>
        <script src="<%=path %>/Back/assets/DT_bootstrap.js"></script>
        <script>
        $(function() {
            
        });
        </script>
  
<script type="text/javascript">
    $("#pagination1").createPage({
					pageCount :<%=request.getAttribute("pageCount")%>,
					current : <%=request.getAttribute("currentPageNum")%>,
					backFn : function(p) {
					//alert(p);
					window.location.href="<%=path%>/back/articlePage.do?p="+p;
		}
	});
   
</script>
    </body>

</html>