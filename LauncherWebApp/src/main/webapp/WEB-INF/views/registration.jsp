<%@  page import="java.io.*,java.util.*" language="java" contentType="text/html;                      
charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="it.ciavotta.Launcher.domain.User"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<script type="text/javascript" src="resources/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="resources/jquery.slidertron-1.3.js"></script>
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="resources/default.css" rel="stylesheet" type="text/css" media="all" />
<link href="resources/fonts.css" rel="stylesheet" type="text/css" media="all" />

<!--[if IE 6]><link href="default_ie6.css" rel="stylesheet" type="text/css" /><![endif]-->

</head>
<body>
<div id="header-wrapper">
	<div id="header" class="container">
		<div id="logo">
			<span class="icon icon-group"></span>
			<h1><a href="#">jLauncher</a></h1>
			<span>Open-source experiments launcher application 
			<a href="https://github.com/miciav/Launcher" rel="nofollow">jLauncher
			</a>
			</span> 
			</div>
		</div>
		<div id="triangle-up"></div>
	</div>
<div id="menu-wrapper">
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="#" accesskey="1" title="">Homepage</a></li>
				<li><a href="login" accesskey="2" title="">Login</a></li>
				<li><a href="registration" accesskey="3" title="">Registration</a></li>
				<li><a href="#" accesskey="4" title="">About Us</a></li>
				<li><a href="#" accesskey="5" title="">Careers</a></li>
				<li><a href="#" accesskey="6" title="">Contact Us</a></li>
			</ul>
		</div>
</div>
<div id="wrapper">
	<div id="featured-wrapper">
	
		<div class="extra2 container">
			<div class="ebox1">
				<div class="hexagon"><span class="icon icon-lightbulb"></span></div>
				<font color="red"><span>${errorMessage}</span></font>
				<form action="registration" method="post" >
					<table>
						<tr>
							<td>Username:</td>
							<td>
								<input type="text" name="username" value="${user.username}" />
							</td>
							<td>
							<font color="red"><span>${usernameMessage}</span></font>
							</td>
						</tr>
						<tr>
							<td>Password:</td>
							<td>
								<input type="password" name="password" value="${user.password}"/> 
							</td>
							<td>
							<font color="red"><span>${passwordMessage}</span></font>
							</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td>
								<input type="text" name="email" value="${user.email}"/>
							</td>
							<td>
							<font color="red"><span>${emailMessage}</span></font>
							</td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<input class="button" type="submit" value="Login"/>
							</td>
						</tr>
					</table>
				</form>
				</div>
				
				<p>This is <strong>Plushiness</strong>, a free, fully standards-compliant CSS template designed by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>. The photos in this template are from <a href="http://fotogrph.com/"> Fotogrph</a>. This free template is released under a <a href="http://creativecommons.org/licenses/by/3.0/">Creative Commons Attributions 3.0</a> license, so you are pretty much free to do whatever you want with it (even use it commercially) provided you keep the links in the footer intact. Aside from that, have fun with it :) </p>
				<a href="#" class="button">Etiam posuere</a>
			</div>		

			<div class="ebox2">
				<div class="hexagon"><span class="icon icon-bullhorn"></span></div>
				<div class="title">
					<h2>Donec dictum metus</h2>
					<span class="byline">Integer sit amet pede vel arcu aliquet pretium</span>
				</div>
				<p>In posuere eleifend odio. Quisque semper augue mattis wisi. Maecenas ligula. Pellentesque viverra vulputate enim. Aliquam erat volutpat. Pellentesque tristique ante ut risus. Quisque dictum. Integer nisl risus, sagittis convallis, rutrum id, elementum congue, nibh. Suspendisse dictum porta lectus. Donec placerat odio vel elit. Nullam ante orci, pellentesque eget, tempus quis, ultrices in, est. Curabitur sit amet nulla. Nam in massa. Sed vel tellus. Curabitur sem urna, consequat vel, suscipit in, mattis placerat, nulla. Sed ac leo. Pellentesque imperdiet.</p>
				<a href="#" class="button">Etiam posuere</a>
			</div>		

		</div>	

	</div>
</div>
<div id="stamp" class="container">
	<div class="hexagon"><span class="icon icon-wrench"></span></div>
</div>
<div id="copyright" class="container">
	<p>Copyright (c) 2013 Sitename.com. All rights reserved. | Photos by <a href="http://fotogrph.com/">Fotogrph</a> | Design by <a href="http://www.freecsstemplates.org/" rel="nofollow">FreeCSSTemplates.org</a>.</p>
</div>
</body>
</html>
