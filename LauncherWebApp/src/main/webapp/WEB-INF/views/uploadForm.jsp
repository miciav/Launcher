
<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<title>Being Java Guys | Hello World</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<div id="featured-wrapper">
	
		<div class="extra2 container2">
			<div class="ebox1">
        <center>
                <h2>Being Java Guys | Hello World</h2>
                <h3>Please select a file to upload !</h3>


                <form:form method="post" enctype="multipart/form-data"
                        modelAttribute="uploadedFile" action="fileUpload">
                        <table>
                                <tr>
                                        <td>Upload File:</td>
                                        <td><input type="file" name="file" /></td>
                                        <td style="color: red; font-style: italic;"><form:errors
                                                        path="file" /></td>
                                </tr>
                                <tr>
                                        <td></td>
                                        <td><input type="submit" value="Upload" /></td>
                                        <td></td>
                                </tr>
                        </table>
                </form:form>
        </center>
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