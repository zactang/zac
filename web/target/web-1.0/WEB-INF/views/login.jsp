<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<body class="loginpage">
<div class="container-fluid loginpage ">
		<div class="row" >
			<div class="loginbox">
				<div class="loginboxinner">
					<!-- 标题 -->
					<h1 class="logo">后台管理系统</h1>
					<br>
					<!-- <h3 class="slogan">后台管理系统</h3> -->
					<!-- 错误信息提示 -->
					<div class="nopassword"  >
						<div class="loginmsg" id="loginmsg" <c:if test="${errMsg!=null}"> style='display:block;' </c:if> > ${errMsg}</div>
					</div>
					<!-- 表单 -->
					<form class="form-horizontal" action="${ctx}/login" method="post">
						<div class="form-group form_side">
							<label class="sr-only" for="inputusername">Email</label>
							<div class="input-group">
								<div class="input-group-addon"> <img src="${ctx}/common/assets/img/username.png"> </div>
								<input type="text" class="form-control" id="inputusername" placeholder="用户名" name="username" onkeypress="check_values();">
							</div>
						</div>
						<div class="form-group form_side">
							<label class="sr-only" for="inputpwd">password</label>
							<div class="input-group">
								<div class="input-group-addon">
									<img src="${ctx}/common/assets/img/password.png">
								</div>
								<input type="password" class="form-control" id="inputpwd" placeholder="密码" name="password" onkeypress="check_values();">
							</div>
						</div>
						<div class="form-group form_side">
							<div class="form-group col-md-12">
							    <div class="input-group" style="width: 298px;">
							        <img id="codeImg" src='${ctx}/login/code' onclick="changeImg()" style="height: 50px; width: 90px;border-radius: 5px;padding-left: 2px;">
							        <input type="text" class="form-control" id="validateCode" name="validateCode" placeholder="四位字符验证码" style="width: 205px" onkeypress="check_values();">
							    </div>
							</div>
						</div>
						<div class="form-group form_side">
							<button type="submit" class="btn btn-success">登录</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function changeImg() {
        var imgSrc = $("#codeImg");
        var src = imgSrc.attr("src");
        imgSrc.attr("src", chgUrl(src));
    }  

	//加入时间戳，去缓存机制   
    function chgUrl(url) {
        var timestamp = (new Date()).valueOf();if ((url.indexOf("&") >= 0)) {
            url = url + "&timestamp=" + timestamp;
        } else {
            url = url + "?timestamp=" + timestamp;
        }
        return url;
    }
	function check_values(){
		$("#loginmsg").hide();
	}

	



    </script>
</body>

