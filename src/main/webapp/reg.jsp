<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 

<html>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/dist/css/bootstrap.min.css">

 <script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
 <script type="text/javascript">
  $(function(){
	  $("#uname").on("blur",function(){
		  //$.post(请求资源,请求的数据,回调函数);
		  $.post("user/exists",{"uname":$("#uname").val()},function(resp){
			  $("#info").html(resp.message);
			  if(!resp.tag){
				  $("button").removeAttr("disabled");
			  }
		  });
	  });
	  
  });
 
 </script>
<body class="container">
 
      <div class="col-sm-10 col-sm-offset-1">
      	 
		 <form class="form-horizontal"  action="user/save" method="post" enctype="multipart/form-data">
		 	<div class="form-group">
		          <label class="control-label col-sm-2" for="uname"> 用户名： </label>
		          <div class="col-sm-8">
		              <input class="form-control" type="text" id="uname" name="uname"/>
		          </div>  
		          <div class="col-sm-2">
		           <span style="color:red" id="info"></span>
		          </div>
		          
		    </div>
		    
		    <div class="form-group">
		          <label class="control-label col-sm-2" for="upwd"> 密码： </label>
		          <div class="col-sm-8">
		              <input class="form-control" type="password" id="upwd" name="upwd"/>
		          </div>
		    </div>
		    
		      <div class="form-group">
		          <label class="control-label col-sm-2" for="birthday"> 出生日期： </label>
		          <div class="col-sm-8">
		              <input class="form-control" type="date" value="1998-09-07" id="birthday"  name="birthday" />
		          </div>
		    </div>
		    
		     <div class="form-group">
		          <label class="control-label col-sm-2"  > 性别： </label>
		          <div class="col-sm-8">		              
		             <label class="radio-inline">
                       <input  type="radio"  name="sex"  value="男"/>男
                     </label>                      
                      <label class="radio-inline">
                       <input  type="radio"  value="女" name="sex">女<br>
                      </label>
		          </div>
		    </div>    
		       <div class="form-group">
		          <label class="control-label col-sm-2" for="img"> 头像: </label>
		          <div class="col-sm-8">
		              <input  type="file" id="img" name="img"/>
		          </div>
		    </div>
		    
		   <div class="form-group">
		   	 <div class="col-sm-8 col-sm-offset-2">
			     <button disabled="disabled"  class="btn btn-success">注册</button>
			 </div>
		   </div>
		   
	 </form>
 
      </div>
	

</body>
</body>
</html>
