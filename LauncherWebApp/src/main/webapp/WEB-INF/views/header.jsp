<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<sec:authentication var="principal" property="principal" />
<title>Insert title here</title>
</head>
<body>
	<div id="menu-wrapper">
		<div id="menu">
			<ul>
				<li><span class="icon icon-group"></span></li>
				<li class="current_page_item"><a href="#" accesskey="1" title="">Homepage</a></li>
				<sec:authorize access="!isAuthenticated()">
				<li><a href="login" accesskey="2" title="">Login</a></li>
				<li><a href="registration" accesskey="3" title="">Registration</a></li>
				<li>
					<form action="j_spring_security_check" method="post"> 
						<input type="text" name="j_username"/>
						<input type="password" name="j_password"/>
						<input type="submit" value="Login"/>				
					</form>
				</li>
				</sec:authorize>
				<sec:authorize access="hasRole('USER')"> 
				<li><a>Welcome  ${principal.username}</a></li>
				<li><a href="fileUploadForm" accesskey="4" title="">New experiment</a></li>
				<li><a href="<c:url value="j_spring_security_logout" />" > Logout</a></li>				
				</sec:authorize>
				

			</ul>
		</div>
	</div>
	<div id="header-wrapper">
		<div id="header" class="container">
			<div id="logo">
				<!-- 			<span class="icon icon-group"></span> -->
				<h1>
					<a href="#">jLauncher</a>
				</h1>
				<span>Open-source experiments launcher application <a
					href="https://github.com/miciav/Launcher" rel="nofollow">jLauncher
				</a>
				</span>
			</div>
		</div>
	</div>

</body>
</html>