<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>${session_user.uname }，登录成功
  <a href="login/logout">注销</a>
  <hr>
  <a href="user/findPages">查询</a>
 </h1>
</body>
</html>