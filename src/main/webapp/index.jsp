<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css">
<body class="container">
 
      <div class="col-sm-8 col-sm-offset-2">
      	    <h3> <span class="label-danger">${msg}</span></h3>
		 <form action="${pageContext.request.contextPath }/login/login" method="post">
		 	<div class="form-group">
		          <label class="control-label" for="uname"> 用户名： </label>
		          <input class="form-control" type="text" id="uname" name="uname"/>
		    </div>
		    <div class="form-group">
		          <label class="control-label" for="upwd"> 密码: </label>
		          <input class="form-control" type="password" id="upwd" name="upwd"/>
		    </div>
		 
		 <button class="btn btn-success">登录</button>
	     <a class="btn btn-link" href="${pageContext.request.contextPath }/reg.jsp">注册</a>
	 </form>
 
      </div>
</html>
