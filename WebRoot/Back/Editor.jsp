<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html>
<html>
    
    <head>
        <title>WYSIWYG Editors</title>
        <!-- Bootstrap -->
        <link href="<%=path%>/Back/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="<%=path%>/Back/assets/styles.css" rel="stylesheet" media="screen">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <link href="<%=path%>/Back/vendors/uniform.default.css" rel="stylesheet" media="screen">
        <!-- FileUpload -->
    	<link rel="stylesheet" type="text/css" href="<%=path %>/Back/vendors/FileUpload/css/jquery.filer.css">
    	<link rel="stylesheet" type="text/css" href="<%=path %>/Back/vendors/FileUpload/css/jquery.filer-dragdropbox-theme.css">
    	<link rel="stylesheet" type="text/css" href="<%=path %>/Back/vendors/FileUpload/css/custom.css">
        
        <script src="<%=path%>/Back/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
        <script type="text/javascript" src="<%=path%>/Back/vendors/Editor/samples/js/sample.js" ></script>
        <script type="text/javascript" src="<%=path%>/Back/vendors/Editor/ckeditor.js" ></script>
        
        
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
                <div class="span2" id="sidebar">
                     <ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
                        <li >
                            <a href="<%=path%>/Back/index.jsp"><i class="icon-chevron-right"></i> 项目概述</a>
                        </li>
                        <li >
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
                        
                        <li class="active">
                            <a href="<%=path%>/Back/Editor.jsp"><i class="icon-chevron-right"></i>添加博客&&文章</a>
                        </li>
                        
                        
                    </ul>
                </div>
                <!--/span-->
                
                
                
                
                <div class="span10">
                	<div class="row-fluid">

  <div class="row-fluid">
                         <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">多写点东西</div>
                                
                            </div>
                         
                            <div class="block-content collapse in">
                            
                                <div class="span12">
					<!-- BEGIN FORM-->
					<form action="<%=path %>/back/insert.do"  method="post" enctype="multipart/form-data" id="form_sample_1" class="form-horizontal" onsubmit="return verificationForm();">
						<fieldset>
							
  							<div id = "title_d" class="control-group">
  								<label class="control-label">标题<span class="required">*</span></label>
  								<div id = "title" class="controls">
  									<input type="text" id = "title_input" name="title"  data-required="1" class="span6 m-wrap"/>
  								</div>
  							</div>
  							 
  							
  							<div id = "intro_d" class="control-group">
  								<label class="control-label">介绍<span class="required">*</span></label>
  								<div id = "intro" class="controls">
  									<input name="intro" id = "intro_input"  type="text" class="span6 m-wrap"/>
  								</div>
  							</div>
  							
  							<div class="control-group">
  								<label class="control-label">标签&nbsp;&nbsp;</label>
  								<div class="controls">
  									<input name="keyword" type="text" class="span6 m-wrap"/>
<!--   									<span class="help-block">optional field</span>
 -->  								</div>
  							</div>
  							<div class="control-group">
  								<label class="control-label">类型<span class="required">*</span></label>
  								<div class="controls">
  									<select class="span6 m-wrap" name="type">
  										<option value="Blog">博客</option>
  										<option value="Article">文章</option>
  										<option value="InformalEssay">随笔</option>
  									</select>
  								</div>
  					
  							
  							</div>
  								<div id = "img_d" class="control-group">
  							<label class="control-label">封面<span class="required">*</span></label>
                                          <div id = "img" class="controls">
                                            
                                            <input type="file" name="file" id="demo-fileInput-7" multiple="multiple">
                                            </div>
  						</div>
  					
  						
  						  								<hr style = "border:2px solid;">
  						
  							 <div class="span12" id="content">
		                    <div class="row-fluid">
		                        <!-- block -->
		                        <div class="block">
		                           
		                           <div class="adjoined-bottom">
		<div class="grid-container">
			<div class="grid-width-100">
				<div id="editor">
							<textarea cols="100" id="editor1" name = "editor1" rows="3"></textarea>

			<script type="text/javascript">CKEDITOR.replace('editor1',  
				{ 
					filebrowserImageUploadUrl : '<%=path%>/back/imgUpload.do',  
					language : 'zh-cn',  
					
					
				} );
			</script>  				
				</div>
			</div>
		</div>
	</div>
		                        </div>
		                       
		                    </div>
		                </div>
		                <input name = "draft"  id = "draft" type = "hidden" value = "false">
  							<div class="form-actions">
  								<button type="submit" onclick="toSubmit()" id = "notification" class="btn btn-primary notification">提交</button>
  								<button class="btn btn-primary" type = "submit"  onclick="toDraft()">保存到草稿箱</button>
  								<a type="button" class="btn"  >重置</a>
  								
  								
  							</div>
						</fieldset>
					</form>
					<!-- END FORM-->
				</div>
			    </div>
			</div>
                     	<!-- /block -->
		    </div>
                	</div>
                </div>

            </div>
            <hr>
            <footer>
                <p>&copy; Vincent Gabriel 2013 - More Templates <a href="http://www.cssmoban.com/" target="_blank" title="cssmoban">cssmoban</a>
            </footer>
        </div>

        <!--/.fluid-container-->
        
    <script src="vendors/jquery-1.9.1.min.js"></script>
    <script src="vendors/jquery-ui-1.10.3.js"></script>
    <script src="<%=path %>/Back/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=path %>/Back/vendors/FileUpload/js/jquery.filer.js" type="text/javascript"></script>
    <script src="<%=path %>/Back/vendors/FileUpload/js/prettify.js" type="text/javascript"></script>
    <script src="<%=path %>/Back/vendors/FileUpload/js/custom.js" type="text/javascript"></script>
    <script type="text/javascript">
    	function toDraft(){
    		document.getElementById("draft").value = "true";
    	}
    </script>
    <script type="text/javascript">
    	function toSubmit(){
    	document.getElementById("draft").value = "false";
    	}
    </script>
	<script type="text/javascript">
	    function addClass(element,value){  
        if(!element.className){  
            element.className=value;  
        }else{  
            newClassName=element.className;  
            newClassName+=" ";  
            newClassName=value;  
            element.className=newClassName;  
        }  
    }  
    
    		var error = document.createElement("span");
			error.innerHTML = "输入有误,请核对之后提交！";
			error.className+="help-inline";
			var error2 = document.createElement("span");
			error2.innerHTML = "输入有误,请核对之后提交！";
			error2.className+="help-inline";
			var error3 = document.createElement("span");
			error3.innerHTML = "请上传一张封面图片！";
			error3.className+="help-inline";
    	
		function verificationForm(){
			if(document.getElementById("title_input").value==""||
				document.getElementById("intro_input").value==""||
				document.getElementById("demo-fileInput-7").value==""
				){
				document.getElementById("title_d").className+=" "+"error" ;
				document.getElementById("intro_d").className+=" "+"error" ;
				document.getElementById("img_d").className+=" "+"error" ;
				document.getElementById("title").appendChild(error);
				document.getElementById("intro").appendChild(error2);
				document.getElementById("img").appendChild(error3);
				
				return false;
				
			}else{
				return true;
			}
		}
		
	</script>
	

<script type="text/javascript">
	function GetContents() {
	// Get the editor instance that you want to interact with.
 var text=CKEDITOR.instances.content.getData(); 
	// Get editor contents editor.getData()
	// https://docs.ckeditor.com/ckeditor4/docs/#!/api/CKEDITOR.editor-method-getData
	document.getElementById("editor").value = text;
	alert(text);
};
	
</script>
   
    </body>

</html>