<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>4SV</title>
</head>
<body>
	<div style="margin-right: 500px">
		<form  style="float: left; margin-right: 10px" action="InsertData" method="post" accept-charset="utf-8" enctype="multipart/form-data">
		<input style="float: left;" type="file" name="file" >
		<input type="submit" name="upload" value="upload">
	</form>
	</div>
	<form action="ReadData" method="post" accept-charset="utf-8">
		<input type="submit" name="read" value="read">
	</form>
</body>
</html>