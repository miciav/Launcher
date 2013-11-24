<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@page import="it.ciavotta.Launcher.domain.User"%>
<%@page import="it.ciavotta.Launcher.dao.BaseDao"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>jLauncher</title>
</head>
<body>
<h1>
	jLauncher V 0.1  
</h1>

<P>  Home page</P>

<% 
WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(application);
BaseDao baseDao = (BaseDao)context.getBean("baseDao");
User us = new User();
us.setUsername("Mario");
us.setPassword("ciavotta1");
us.setEmail("miciav@libero.it");

try{
	baseDao.persist(us);
}
catch(Exception e){
	out.print("l'utente già esiste");
}

for(User us1 : baseDao.getAll(User.class))
{
	out.print(us1.getUsername()+"--"+us1.getPassword()+"--"+us1.getEmail()+"<br>");
}
%>
</body>
</html>
