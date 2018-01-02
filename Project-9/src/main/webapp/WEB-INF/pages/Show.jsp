<%@page import="java.util.List"%>
<%@page import="practice.sv.bai1.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show</title>
</head>
<body>
	<%		List<Student> students = (List<Student>) request.getAttribute("listStudent");
            for(Student student : students){
     %>
            <div>
                <%= student.toString() %>
            </div>
     <%}%>
</body>
</html>