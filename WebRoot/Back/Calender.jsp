<%@page import="xyz.yangchaojie.entity.Calender"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
    <%List<Calender> calenderList = (List<Calender>)request.getAttribute("calenderList"); %>
    <head>
        <title>Calendar</title>
        <!-- Bootstrap -->
        <meta charset="utf-8" />
        <link href="<%=path %>/Back/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/Back/vendors/fullcalendar/fullcalendar.css" rel="stylesheet" media="screen">
        <link href="<%=path %>/Back/assets/styles.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script src="<%=path %>/Back/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
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
                        <li  class="active">
                            <a href="<%=path%>/back/readCalender.do"><i class="icon-chevron-right"></i> 留言面板</a>
                        </li>
                        <li>
                            <a href="<%=path%>/back/articlePage.do"><i class="icon-chevron-right"></i> 文章管理</a>
                        </li>
                        <li>
                            <a href="<%=path%>/back/blogPage.do"><i class="icon-chevron-right"></i>博客管理</a>
                        </li>
                          <li >
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
                        <!-- block -->
                        <%for(Calender c:calenderList){ %>
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left"><%=c.getName() %></div>
                                <div class="pull-right"><span class="badge badge-warning"><%=c.getEmail() %></span>
									
                                </div>
                                
                            </div>
                            <span class="label label-warning" style="margin-left: 3%"><%=c.getSubject() %></span>
                                 <p style="font-size: 20px; margin-left: 8%"><%=c.getContent() %></p>
                        </div>
                        <%} %>
                        <!-- /block -->
                    </div>
                </div>
            </div>
            <hr>
       
        </div>
        <style>
        #external-events {
            float: left;
            width: 150px;
            padding: 0 10px;
            border: 1px solid #ccc;
            background: #eee;
            text-align: left;
            }
            
        #external-events h4 {
            font-size: 16px;
            margin-top: 0;
            padding-top: 1em;
            }
            
        .external-event { /* try to mimick the look of a real event */
            margin: 10px 0;
            padding: 2px 4px;
            background: #3366CC;
            color: #fff;
            font-size: .85em;
            cursor: pointer;
            z-index: 99999999;
            }
            
        #external-events p {
            margin: 1.5em 0;
            font-size: 11px;
            color: #666;
            }
            
        #external-events p input {
            margin: 0;
            vertical-align: middle;
            }

        </style>
        <!--/.fluid-container-->
        <script src="<%=path %>/Back/vendors/jquery-1.9.1.min.js"></script>
        <script src="<%=path %>/Back/vendors/jquery-ui-1.10.3.js"></script>
        <script src="<%=path %>/Back/bootstrap/js/bootstrap.min.js"></script>
      
       
    </body>

</html>
