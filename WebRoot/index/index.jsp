<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
  <head>
    <title>katrnia</title>
    <meta name="description" content="" />
    <meta name="author" content="templatemo">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href="<%=path%>/index/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/index/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=path%>/index/css/templatemo_misc.css">
   	<link type="text/css" rel="stylesheet" href="<%=path%>/index/css/easy-responsive-tabs.css" />
    <link href="<%=path%>/index/css/templatemo_style.css" rel="stylesheet"> 
    <link rel="shortcut icon" href="<%=path %>/Blog/img/blogger_16px_1148729_easyicon.net.ico" type="image/x-icon"/>  
     <script type="text/javascript" src = "<%=path %>/index/js/json_parse.js"></script>   
    <script type="text/javascript" src="<%=path%>/index/dist/smooth-scrollbar.js" ></script>
    <link rel="stylesheet" href="<%=path%>/index/dist/smooth-scrollbar.css" />
        
		<script src="<%=path%>/index/js/jquery-1.10.2.min.js"></script> 
		<script src="<%=path%>/index/js/jquery.lightbox.js"></script>
		<script src="<%=path%>/index/js/templatemo_custom.js"></script>
    <script src="<%=path%>/index/js/easyResponsiveTabs.js" type="text/javascript"></script>  
     <style type="text/css">
     	.img_1{
     		height:313.3px;
     		     }
     	.img_2{
     		height:149.733px;
     	}
     </style>
     <script>
    function showhide()
    {
        var div = document.getElementById("newpost");
		if (div.style.display !== "none") 
		{
			div.style.display = "none";
		}
		else 
		{
			div.style.display = "block";
		}
    }
  </script>
  <script type="text/javascript">
  	window.onload = function(){initIndex();  		document.getElementById("menu-container").style.display = "neno";
  	};
  	document.onreadystatechange = function(){
  		if(document.readyState = "complete"){
  		document.getElementById("menu-container").style.display = "block";
  			$(".loader").fadeOut();
  		}
  	};
  </script>
  <style type="text/css">
		.backImg{
  		background-image: url(images/fb03661146b79880a874bb07d37376eb.jpg!ordinary.jpg);
  		background-repeat: no-repeat;
  		background-attachment: fixed; 
  		background-size:100%,100%;
  	
  		
  	}
		#main-scrollbar {
		  position: fixed;
		  top: 0;
		  right: 0;
		  bottom: 0;
		  left: 0;
		}
		@media only screen and (max-width: 960px) and (max-height: 600px) {
				.backImg{
					background-color: #101010;
					background-size: cover;
				}
		}
		<style type="text/css">
		.loader {
		    width: 150px;
		    margin: 50px auto 70px;
		    position: relative;
		}
		.loader .loading-1 {
		    position: relative;
		    width: 100%;
		    height: 10px;
		    border: 1px solid #69d2e7;
		    border-radius: 10px;
		    animation: turn 4s linear 1.75s infinite;
		}
		.loader .loading-1:before {
		    content: "";
		    display: block;
		    position: absolute;
		    width: 0%;
		    height: 100%;
		    background: #69d2e7;
		    box-shadow: 10px 0px 15px 0px #69d2e7;
		    animation: load 2s linear infinite;
		}
		.loader .loading-2 {
		    width: 100%;
		    position: absolute;
		    top: 10px;
		    color: #69d2e7;
		    font-size: 22px;
		    text-align: center;
		    animation: bounce 2s  linear infinite;
		}
		@keyframes load {
		    0% {
		        width: 0%;
		    }
		    87.5%, 100% {
		        width: 100%;
		    }
		}
		@keyframes turn {
		    0% {
		        transform: rotateY(0deg);
		    }
		    6.25%, 50% {
		        transform: rotateY(180deg);
		    }
		    56.25%, 100% {
		        transform: rotateY(360deg);
		    }
		}
		@keyframes bounce {
		    0%,100% {
		        top: 10px;
		    }
		    12.5% {
		        top: 30px;
		    }
		}
	</style>
		
	
  </head>
  <body class="backImg" >
    	 <div class="loader">
    <div class="loading-1"></div>
    <div class="loading-2">Loading...</div>
	</div>     
                
    	<!-- logo start -->
    		<main class="htmleaf-container" id="main-scrollbar" data-scrollbar>

    <div class="logocontainer">
    	<div class="row">
        	<h1><a href="#"></a></h1>
            <div class="clear"></div>
            <div class="templatemo_smalltitle"></div>
       </div>
    </div>
    <!-- logo end -->    
    
   <div id="menu-container" class="main_menu" style="display: none;">
   <!-- homepage start -->
    <div class="content homepage" id="menu-1">
  	<div class="container">
          	<div class="col-md-3 col-sm-6 templatemo_leftgap">
            	<div class="templatemo_mainservice templatemo_botgap">
                	<div class="templatemo_link"><a href="<%=path%>/Login/Login.jsp">登录</a></div>
                	
                </div>
                <div id = "img_1" class="templatemo_mainimg">
                
                
                </div>
            </div>
            <div class="col-md-3 col-sm-6 templatemo_leftgap">
            	<div id = "img_2" class="templatemo_mainimg templatemo_botgap templatemo_portfotopgap">
            	
            	
            	
            	
            	</div>
                <div class="templatemo_mainportfolio">
                      <div class="templatemo_link"><a class="show-3 templatemo_page3" href="#">相册</a></div>
                	                   
                </div>
            </div>
            
            <div class="col-md-3 col-sm-6 templatemo_leftgap">
            	<div class="templatemo_maintesti templatemo_botgap templatemo_topgap">
                	<div class="templatemo_link"><a  href="<%=path%>/articleControl/articlePage.do">博客</a></div>
                </div>
                <div id = "img_3" class="templatemo_mainimg">
               
                </div>
            </div>
            <div class="col-md-3 col-sm-6 templatemo_leftgap">
            	 <div id = "img_4" class="templatemo_mainimg templatemo_botgap templatemo_topgap">
             	  
                </div>
                <div class="templatemo_mainabout templatemo_botgap">
                	<div class="templatemo_link"><a class="show-5 templatemo_page5" href="#">关于</a></div>
                </div>
                <div class="templatemo_maincontact">
                	<div class="templatemo_link"><a class="show-6 templatemo_page6" href="#">留言</a></div>
                </div>
            </div>
    </div>
    
   </div>
    <!-- homepage end -->
    <!--services start -->
   <div class="content services" id="menu-2">
		<div class="container">
        	<div class="row templatemo_bordergapborder">
            	<div class="col-md-3 col-sm-12 templatemo_leftgap">
                	<div class="templatemo_mainimg templatemo_botgap"><img src="<%=path%>/index/images/templatemo_service1.jpg" alt="service image"></div>
                    <div class="templatemo_mainservice templatemo_botgap">
                	<div class="templatemo_linkservice"><a class="show-1 templatemo_homeservice" href="#">Go Back</a></div>
                </div>
                </div>
                
                <div class="templatemo_col37 col-sm-12 templatemo_leftgap">
                	<div class="templatemo_graybg">
                    <div class="templatemo_frame">
                	<h2>Our Services</h2>
                    <div class="clear"></div>
                    <p><a href="#">Matrix HTML5 template</a> is new metro style <a href="#">website template</a> for you and it is available for free download. Credit goes to <a rel="nofollow" href="#">Unsplash</a> for all images used in this template. Praesent ut vehicula lorem. Nulla nec tellus id ligula egestas luctus fringilla vel dui. Nulla quis quam eget purus aliquam molestie. Nunc ligula magna, viverra eu eros vitae, aliquam tempor nunc. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.<br><br>
					Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse eget laoreet nunc. Suspendisse condimentum metus neque, at adipiscing metus venenatis eu. Mauris sit amet erat laoreet, ullamcorper justo sit amet, vehicula purus. Nulla sagittis pulvinar erat, sit amet venenatis lacus fringilla vitae.<br><br>
					Integer sit amet libero sed dui pretium tempor. Nam neque erat, euismod ut pulvinar in, bibendum eget mi. Phasellus porttitor purus sit amet condimentum mattis. Nulla non venenatis mauris.</p>
                    </div>
               	  </div>
              </div>
                <div class="templatemo_col37 col-sm-12 templatemo_leftgap templatemo_topgap">
                	<div class="templatemo_mainimg templatemo_botgap"><img src="<%=path%>/index/images/templatemo_service2.jpg" alt="service image"></div>
                </div>
            </div>
        </div>
     </div>
	    
    <!-- services end -->	

	<!-- portfilio start -->
    <div class="portfolio" id="menu-3" style="display: none;" >
    	<div class="container">
          	<div class="col-md-3 col-sm-6 templatemo_leftgap">
       	      <div class="templatemo_insideportfolio templatemo_botgap">
               	  <div class="templatemo_portfoliotext">
                	<h2>相册</h2>
                    <div class="clear"></div><br>
                    	<h2>纵使困顿难行,</h2>
                    	<h2>亦当砥砺奋进！</h2>
                    </div>
              </div>
            	<div class="templatemo_portfolioback">
                	<div class="templatemo_link"><a class="show-1 templatemo_homeportfolio" href="#">Go Back</a></div>
                </div>
                
            </div>
            <div class="col-md-3 col-sm-6 templatemo_leftgap">
                        <div class="templatemo_botgap templatemo_portfotopgap gallery-item">
							<img src="<%=path%>/index/images/portfolio/IMG_20180124_213532.jpg" alt="gallery 1">
							<div class="overlay">
								<a href="<%=path%>/index/images/portfolio/IMG_20180124_213532.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
						</div>				
                <div class="templatemo_botgap templatemo_topgap gallery-item">
             	   <img src="<%=path%>/index/images/portfolio/1517484868930.jpeg" alt="gallery 2">
                   <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/1517484868930.jpeg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
                <div class="templatemo_botgap templatemo_topgap gallery-item">
             	   <img src="<%=path%>/index/images/portfolio/mmexport1517484127399.jpg" alt="gallery 3">
                   <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484127399.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
               
            </div>
            <div class="col-md-3 col-sm-6 templatemo_leftgap">
				<div class="templatemo_botgap templatemo_topgap gallery-item">
             	  	 <img src="<%=path%>/index/images/portfolio/mmexport1517484167511.jpg" alt="gallery 4">
                     <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484167511.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
                <div class="templatemo_botgap templatemo_topgap gallery-item">
             	   <img src="<%=path%>/index/images/portfolio/mmexport1517484176700.jpg" alt="gallery 5">
                   <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484176700.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
                <div class="templatemo_botgap templatemo_topgap gallery-item">
             	   <img src="<%=path%>/index/images/portfolio/mmexport1517484236282.jpg" alt="gallery 6">
                   <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484236282.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
            </div>
            <div class="col-md-3 col-sm-6 templatemo_leftgap">
				<div class="templatemo_botgap templatemo_topgap gallery-item">
             	  	 <img src="<%=path%>/index/images/portfolio/mmexport1517484292008.jpg" alt="gallery 7">
                     <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484292008.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
                <div class="templatemo_botgap templatemo_topgap gallery-item">
             	   <img src="<%=path%>/index/images/portfolio/mmexport1517484442137.jpg" alt="gallery 8">
                   <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484442137.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
                <div class="templatemo_botgap templatemo_topgap gallery-item">
             	   <img src="<%=path%>/index/images/portfolio/mmexport1517484491957.jpg	" alt="gallery 9">
                   <div class="overlay">
								<a href="<%=path%>/index/images/portfolio/mmexport1517484491957.jpg" data-rel="lightbox" class="fa fa-arrows-alt"></a>
							</div>
                </div>
            </div>
    </div>
    </div>
	 <!-- portfolio end -->
     <div class="copyrights">Collect from </div>
	<!-- testimonial start -->
    <div class="content testimonial" id="menu-4">
    		    	<div class="container">
        	<div class="row templatemo_bordergapborder">
            <!--vertical Tabs-->
      		<div id="cmt">
            <div class="col-md-3 col-sm-12 templatemo_leftgap_about">
            <ul class="resp-tabs-list templatemo_testitab">
                <li>Testimonials</li>
                <li>Special Awards</li>
                <li>Recognitions</li>
            </ul>
            <div class="templatemo_aboutlinkwrapper">
     		<div class="templatemo_link"><a class="show-1 templatemo_hometestimonial" href="index.html">Go Back</a></div>
            </div>
            </div>
            <div class="resp-tabs-container templatemo_testicontainer">
                <div>
                	<div class="templatemo_col50 templatemo_rightgap_about">
                    	<div class="templatemo_graybg templatemo_botgap">
                         <div class="templatemo_frame">
                    	<h2>Testimonials</h2>
                    	<p>Aliquam accumsan, mauris ut hendrerit vehicula, elit massa facilisis nulla, ut auctor risus massa non elit. Vestibulum commodo, mauris quis accumsan pretium, mauris erat porttitor nibh, a eleifend ante elit eu velit. Sed molestie fringilla tellus ut venenatis. Nam ut eros augue. Nullam scelerisque enim eget ornare rutrum. Proin dignissim eget arcu a posuere. Sed ut lacinia enim, et adipiscing purus.<br><br>
						Etiam vitae elit euismod dui <a href="#">elementum</a> dapibus sed eleifend purus. Maecenas eleifend arcu arcu, vitae interdum erat sollicitudin vel. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.</p>
                        </div>
                        </div>
                    </div>
                    <div class="templatemo_col50 templatemo_leftgap templatemo_botgap"><img src="<%=path%>/index/images/templatemo_testimonial1.jpg" alt="testimonial image"></div>
                </div>
                <div>
                	<div class="templatemo_col50 templatemo_rightgap_about">
                    	<div class="templatemo_graybg templatemo_botgap">
                        <div class="templatemo_frame">
                    	<h2>Special Awards</h2>
                    	<p>Suspendisse eu nisl sit amet purus varius pellentesque quis id mi. Ut ac sodales massa. Suspendisse placerat malesuada ligula, et bibendum justo convallis in. Duis imperdiet nibh non sodales porttitor. Donec <a href="#">pellentesque</a> mollis ante, a bibendum turpis congue at. Maecenas ligula augue, pellentesque ac porttitor eu, facilisis at nisl.<br><br>
                        Duis nulla leo, posuere sit amet nibh nec, lacinia ullamcorper turpis. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aliquam aliquam facilisis metus, eget semper nisi mollis blandit. Vestibulum metus neque, vestibulum nec tempus vitae, viverra sit amet odio.</p>
                        </div>
                        </div>
                    </div>
                    <div class="templatemo_col50 templatemo_leftgap templatemo_botgap"><img src="<%=path%>/index/images/templatemo_testimonial2.jpg" alt="testimonial image"></div>
                </div>
                <div>
                	<div class="templatemo_col50 templatemo_rightgap_about">
                    	<div class="templatemo_graybg templatemo_botgap">
                        <div class="templatemo_frame">
                    	<h2>Recognitions</h2>
                    	<p>Quisque convallis neque eu nunc dictum, eget vehicula ipsum rhoncus. Fusce a egestas mauris, dapibus fermentum ligula. Donec ac scelerisque sem. Morbi mollis augue non nunc tincidunt, sit amet volutpat nisi commodo. <a href="#">Suspendisse</a> justo nisl, fringilla vehicula augue ut, mattis mattis lacus.<br><br>
                        Maecenas at urna non dolor sagittis suscipit. Nulla lacinia orci eu felis cursus ultricies. Vestibulum non leo feugiat, posuere mi sit amet, tristique nulla. Suspendisse dui est, sagittis ac pulvinar vel, venenatis ac nisi. Maecenas ac purus viverra, tincidunt dui at, rutrum lorem.</p>
                        </div>
                        </div>
                    </div>
                    <div class="templatemo_col50 templatemo_leftgap templatemo_botgap"><img src="<%=path%>/index/images/templatemo_testimonial3.jpg" alt="testimonial image"></div>
                </div>
            </div>
        </div>
        <div class="col-sm-12 templatemo_leftgap templatemo_aboutlinkwrapper1">
                	<div class="templatemo_aboutback templatemo_botgap">
                </div>
                </div>
    </div>
            </div>

    </div>
	 <!-- testimonial end -->
     <!-- about start -->
    <div class="content about" id="menu-5">
    	<div class="container">
        	<div class="row templatemo_bordergapborder">
            <!--vertical Tabs-->
      		<div id="ab">
            <div class="col-md-3 col-sm-12 templatemo_leftgap_about">
            <ul class="resp-tabs-list templatemo_tab">
                <li>Our Team</li>
                <li>Our History</li>
                <li>Our Vision</li>
            </ul>
            <div class="templatemo_aboutlinkwrapper">
     		<div class="templatemo_link"><a class="show-1 templatemo_homeabout" href="#">Go Back</a></div>
            </div>
            </div>
            <div class="resp-tabs-container templatemo_aboutcontainer">
                <div>
                	<div class="templatemo_col50 templatemo_rightgap_about">
                    	<div class="templatemo_graybg templatemo_botgap">
                         <div class="templatemo_frame">
                    	<h2>Our Team</h2>
                    	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum nibh urna, euismod ut ornare non, volutpat vel tortor. Integer laoreet placerat suscipit. Sed sodales scelerisque commodo. Nam porta cursus lectus. Proin nunc erat, gravida a facilisis quis, ornare id lectus. Proin consectetur nibh quis urna gravida mollis.<br><br>
                        Quisque vitae malesuada risus. Quisque at consequat erat. Cras sed fermentum ipsum. Maecenas aliquet commodo dui vel dapibus. Cras quis mi non nisl posuere vestibulum vitae id ipsum. Pellentesque mollis sem non facilisis aliquam. Curabitur eu fermentum odio.</p>
                        </div>
                        </div>
                    </div>
                    <div class="templatemo_col50 templatemo_leftgap templatemo_botgap"><img src="<%=path%>/index/images/templatemo_about.jpg" alt="about image"></div>
                </div>
                <div>
                	<div class="templatemo_col50 templatemo_rightgap_about">
                    	<div class="templatemo_graybg templatemo_botgap">
                        <div class="templatemo_frame">
                    	<h2>Our History</h2>
                    	<p>Pellentesque id ullamcorper justo. Vestibulum imperdiet justo vitae lacus pulvinar, ut tempus lacus porta. Nulla eget tellus elit. Proin ipsum mi, dictum nec massa quis, malesuada feugiat nisl. Nam tempus at eros ut volutpat.<br><br> 
                        Feel free to download our <a rel="nofollow" href="#">templates</a> for your websites. Aenean consectetur, libero non dapibus posuere, odio quam fringilla diam, et rutrum felis tortor gravida massa. Aenean tincidunt dolor id augue consectetur, eget suscipit lectus facilisis. Integer eleifend augue non euismod viverra.</p>
                        </div>
                        </div>
                    </div>
                    <div class="templatemo_col50 templatemo_leftgap templatemo_botgap"><img src="<%=path%>/index/images/templatemo_team.jpg" alt="history image"></div>
                </div>
                <div>
                	<div class="templatemo_col50 templatemo_rightgap_about">
                    	<div class="templatemo_graybg templatemo_botgap">
                        <div class="templatemo_frame">
                    	<h2>Our Vision</h2>
                    	<p>We provide <a href="#">mobile website templates</a> for everyone. Suspendisse eget iaculis velit, at ullamcorper justo. Nulla mi elit, mollis sit amet eros eget, tempus accumsan diam. Nunc blandit nisl eu massa ultrices, eget adipiscing purus posuere. Maecenas sapien libero, tempor eu pulvinar in, blandit vitae sem.<br><br>
                        Vestibulum pellentesque turpis orci, sit amet varius velit aliquet id. In fringilla nisi id lorem scelerisque, vitae elementum quam porta. Vestibulum bibendum egestas velit, id mollis lacus euismod nec. Duis fringilla dui sit amet felis eleifend auctor. Duis rhoncus, nulla eget egestas consequat, justo purus elementum ipsum, ut blandit quam libero sit amet metus.</p>
                        </div>
                        </div>
                    </div>
                    <div class="templatemo_col50 templatemo_leftgap templatemo_botgap"><img src="<%=path%>/index/images/templatemo_vision.jpg" alt="vision image"></div>
                </div>
            </div>
        </div>
			<div class="col-sm-12 templatemo_leftgap templatemo_aboutlinkwrapper1">
                	
                </div>
    </div>
            </div>
    </div>
    <!-- about end -->
    <!-- contact start -->
    <div class="content contact" id="menu-6">
    	<div class="container">
        	<div class="row templatemo_bordergapborder">
            	<div class="col-md-3 col-sm-12 templatemo_leftgap">
                	<div class="templatemo_mainimg templatemo_botgap"><img src="<%=path%>/index/images/templatemo_contact1.jpg" alt="contact image"></div>
                    <div class="templatemo_maincontact templatemo_botgap">
                	<div class="templatemo_linkcontact"><a class="show-1 templatemo_homecontact" href="#">Go Back</a></div>
                </div>
                </div>
                
                <div class="templatemo_col37 col-sm-12 templatemo_leftgap">
                	<div class="templatemo_graybg templatemo_paddinggap">
                	<h2>留言</h2>
                    <div class="clear"></div>
                    	<form role="form" action="<%=path %>/indexControl/calender.do" method="post" >
                          <div class="templatemo_form">
                            <input name="name" type="text" class="form-control" id="fullname" placeholder="Your Name" maxlength="40">
                          </div>
                          <div class="templatemo_form">
                            <input name="email" type="text" class="form-control" id="email" placeholder="Your Email" maxlength="40">
                          </div>
                           <div class="templatemo_form">
                            <input name="subject" type="text" class="form-control" id="subject" placeholder="Subject" maxlength="60">
                          </div>
                          <div class="templatemo_form">
                              <textarea name="content" class="form-control" id="message" placeholder="Your Message..."></textarea>
                          </div>
                          <div class="templatemo_form"><button type="submit" class="btn btn-primary" >Send</button></div>
            			</form>
               	  </div>
              </div>
                <div class="templatemo_col37 col-sm-12 templatemo_leftgap templatemo_topgap">
                	<div class="templatemo_graybg templatemo_paddinggap">
                    	
                        <div class="clear"></div>
                        <div class="templatemo_contactmap">
		    					<div id="templatemo_map"></div>                        
        		        </div>
                        
                    </div>
                </div>
            </div>
        </div>

    </div>
        <!-- contact end --> 
    
    </div>
    
    	<!-- logo start -->
    <div class="logocontainer">
    	<div class="row">
            <div class="templatemo_footer"></div>
       </div>
    </div>
    	</main>
    <!-- logo end -->  
   <script type="text/javascript">
    $(document).ready(function () {
        $('#horizontalTab').easyResponsiveTabs({
            type: 'default', //Types: default, vertical, accordion
            width: 'auto', //auto or any width like 600px
            fit: true, // 100% fit in a container
            closed: 'accordion', // Start closed if in accordion view
            activate: function(event) { // Callback function if tab is switched
                var $tab = $(this);
                var $info = $('#tabInfo');
                var $name = $('span', $info);

                $name.text($tab.text());

                $info.show();
				
            }
        });

        $('#ab').easyResponsiveTabs({
            type: 'vertical',
            width: 'auto',
            fit: true,
        });
		

		$('#cmt').easyResponsiveTabs({
            type: 'vertical',
            width: 'auto',
            fit: true,
        });
    });
</script>
<script type="text/javascript">
		Scrollbar.initAll({
			speed: 3,
			overscrollEffect: 'bounce',
			overscrollEffectColor: '#d2527f'
		});
	</script>
<script type="text/javascript">
function initIndex(){
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
        				var div_1 = document.getElementById("img_1");
        				var img_1 = document.createElement("img");
        				img_1.src = "<%=path%>/ArticleImg/"+json[0].url;
        				img_1.className = "img_1";
        				var a = document.createElement("a");
        				a.setAttribute("href", "<%=path%>/articleControl/readArticle.do?id="+json[0].id);
        				a.appendChild(img_1);
        				div_1.appendChild(a);
        				
        				var img_2 = document.createElement("img");
        				img_2.src = "<%=path%>/BlogImg/"+json[1].url;
        				img_2.className = "img_1";
        				var a_2 = document.createElement("a");
        				a_2.setAttribute("href", "<%=path%>/blogControl/readBlog.do?id="+json[1].id);
        				a_2.appendChild(img_2);
        				var div_2 = document.getElementById("img_2").appendChild(a_2);
        				
        				var img_3 = document.createElement("img");
        				img_3.src = "<%=path%>/BlogImg/"+json[2].url;
        				img_3.className = "img_1";
        				var a_3 = document.createElement("a");
        				a_3.setAttribute("href", "<%=path%>/blogControl/readBlog.do?id="+json[2].id);
        				a_3.appendChild(img_3);
        				var div_3 = document.getElementById("img_3").appendChild(a_3);
        				
        				
        				var img_4 = document.createElement("img");
        				img_4.src = "<%=path%>/InformalEssayImg/"+json[3].url;
        				img_4.className = "img_2";
        				var a_4 = document.createElement("a");
        				a_4.setAttribute("href", "<%=path%>/informalEssayControl/readInformalEssay.do?id="+json[3].id);
        				a_4.appendChild(img_4);
        				document.getElementById("img_4").appendChild(a_4);
        			};
        		};
        		xmlhttp.open("GET", "<%=path%>/indexControl/initIndex_Ajax.do",true);
        		xmlhttp.send();
};
	
	
</script>

  </body>
</html>
 
