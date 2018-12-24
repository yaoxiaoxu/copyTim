<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/tim/login" method="post">
<input type="text" name="userName" /><br>
<input  type="text" name="pwd"/>
<input type="submit" value="登陆"  />
</form>
<br>
<hr>
<form action="/yao/oa/vacation/deploy" method="post" enctype="multipart/form-data">
<input type="file" name="file">
<input type="submit" value="上传"  />
</form>

</body>
</html>