<%@page import="xyz.yangchaojie.entity.Transform"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	Transform tranform = (Transform) request.getAttribute("update");
%>

<!DOCTYPE html>
<html>

<head>
<title>更新</title>
<!-- Bootstrap -->
<link href="<%=path%>/Back/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<link href="<%=path%>/Back/assets/styles.css" rel="stylesheet"
	media="screen">
<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
<link href="<%=path%>/Back/vendors/uniform.default.css" rel="stylesheet"
	media="screen">
<!-- FileUpload -->


<script
	src="<%=path%>/Back/vendors/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/Back/vendors/Editor/samples/js/sample.js"></script>
<script type="text/javascript"
	src="<%=path%>/Back/vendors/Editor/ckeditor.js"></script>

<script type="text/javascript">
        	function setContent(){
        			var editor =CKEDITOR.instances.editor1;
					var content = document.getElementById("htmlArea").value;
					editor.setData(content);
					
   				};
   				window.onload=function (){
				setContent();

				};
        </script>
</head>

<body>

	<!-- block -->
	<div class="navbar navbar-inner block-header" style="margin-top: -60px;" >
		<div class="muted pull-left">仔细改改，别出BUG</div>

	</div>

	<div class="block-content collapse in">

		<div class="span12">
			<!-- BEGIN FORM-->
			<form action="<%=path%>/back/submitUpdate.do" method="post"
				id="form_sample_1" class="form-horizontal"
				onsubmit="return verificationForm();">
				<fieldset style="margin-left: 20%;margin-right: 20%">

					<div id="title_d" class="control-group">
						<label class="control-label">标题<span class="required">*</span>
						</label>
						<div id="title" class="controls">
							<input type="text" id="title_input" name="title"
								data-required="1" class="span6 m-wrap"
								value="<%=tranform.getTitle()%>" />
						</div>
					</div>


					<div id="intro_d" class="control-group">
						<label class="control-label">介绍<span class="required">*</span>
						</label>
						<div id="intro" class="controls">
							<input name="intro" id="intro_input" type="text"
								value="<%=tranform.getIntro()%>" class="span6 m-wrap" />
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">标签&nbsp;&nbsp;</label>
						<div class="controls">
							<input name="keyword" value="<%=tranform.getKeyword()%>"
								type="text" class="span6 m-wrap" />
							<!--   									<span class="help-block">optional field</span>
 -->
						</div>
					</div>
					<hr style="border:2px solid;">

					<div class="span12">
						<div class="row-fluid">
							<!-- block -->
							<div class="block">

								<div class="adjoined-bottom">
									<div class="grid-container">
										<div class="grid-width-100">
											<div id="editor">
												<textarea cols="100" id="editor1" name="editor1" rows="3"></textarea>

												<script type="text/javascript">
												CKEDITOR.replace('editor1',  
																	{ 
																		filebrowserImageUploadUrl : '<%=path%>/back/imgUpload.do',
																		language : 'zh-cn',

																	});
												</script>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
					<textarea name="content" id="content" style="display:none; "></textarea> <textarea
					id="htmlArea"	style="display:none; " ><%=tranform.getContent()%></textarea>
					<input name="type" type="hidden" value="<%=tranform.getType()%>">
					<input type="hidden" name="id" value="<%=tranform.getId()%>">



					<div class="form-actions" style="margin-left: 25%">
						<button type="submit" onclick="GetContents()" id="notification"
							class="btn btn-inverse ">提交</button>
					</div>
				</fieldset>
			</form>
			<!-- END FORM-->
		</div>
	</div>
	<!-- /block -->







	<!--/.fluid-container-->

	<script src="vendors/jquery-1.9.1.min.js"></script>
	<script src="vendors/jquery-ui-1.10.3.js"></script>
	<script src="<%=path%>/Back/bootstrap/js/bootstrap.min.js"></script>


	<script type="text/javascript">
		function addClass(element, value) {
			if (!element.className) {
				element.className = value;
			} else {
				newClassName = element.className;
				newClassName += " ";
				newClassName = value;
				element.className = newClassName;
			}
		}

		var error = document.createElement("span");
		error.innerHTML = "你看数据库会不会屌你";
		error.className += "help-inline";
		var error2 = document.createElement("span");
		error2.innerHTML = "MyBatis已经很不耐烦了";
		error2.className += "help-inline";

		function verificationForm() {
			if (document.getElementById("title_input").value == ""
					|| document.getElementById("intro_input").value == ""
					|| document.getElementById("demo-fileInput-7").value == "") {
				document.getElementById("title_d").className += " " + "error";
				document.getElementById("intro_d").className += " " + "error";
				document.getElementById("title").appendChild(error);
				document.getElementById("intro").appendChild(error2);

				return false;

			} else {
				return true;
			}
		}
	</script>


	<script type="text/javascript">
		function GetContents() {
			var text = CKEDITOR.instances.editor1.getData();

			document.getElementById("content").value = text;
		};
	</script>

</body>

</html>