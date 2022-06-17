<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UploadFile</title>
</head>
<body>
<form action="uploadfile.controller" method="post" enctype="multipart/form-data">
    Please Select Your Picture to Upload:<br/>
    <input type="file" name="myFiles"/>
    <input type="submit" value="upload"/>
</form>
</body>
</html>