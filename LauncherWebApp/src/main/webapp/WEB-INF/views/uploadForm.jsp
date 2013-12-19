<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<title>Being Java Guys | Hello World</title>
</head>
<body>

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
</body>
</html>
