<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>权限分配</title>
	<link rel="shortcut icon" href="${absoluteContextPath}/images/demoimg/tit.ico">
    <link rel="stylesheet" href="${absoluteContextPath}/css/style.css">
    <link rel="stylesheet" href="${absoluteContextPath}/css/public.css">
	<script src="js/jquery.js"></script>
	<script src="js/index.js"></script>
</head>
<body>
	<div class="login-wrap">
		<div class="login-con">
			<div class="login-top clearfix">
				<span></span>
				<h2>欢迎登陆锦医卫后台管理系统</h2>
			</div>
			<div class="login-int">
				<dl>
					<dt>
						<img src="images/demoimg/lg-logo.png" alt="logo" />
					</dt>
					<dd>
						<div class="top-txt">
							<h3>用户登陆</h3>
						</div>
						<div class="user-login">
							<i></i>
							<input type="text" id="userName" />
							<label>用户名</label>
						</div>
						<div class="pass-login">
							<i></i>
							<input type="password" id="password"/>
							<label>密码</label>
						</div>
						<div class="login-error" style="display: none;">
							<p>您输入的用户名或密码有误！</p>
						</div>
						<div class="log-click clearfix">
							<p>
								<input type="button" onclick="login()" value="登录" />
							</p>
							<div>
								<input type="checkbox"  onclick="remember();"/><span>记住密码</span>
							</div>
						</div>
						<div class="log-note">
							<p>温馨提示：文集密码请及时联系故那里员</p>
						</div>
					</dd>
				</dl>
			</div>
		</div>
	</div>
</body>
<script>
    $(document).ready(function(){
        //记住密码功能
        var str = getCookie("loginInfo");

		alert(str);
        str = str.substring(1,str.length-1);
        var username = str.split(",")[0];
        var password = str.split(",")[1];
        //自动填充用户名和密码
        $("#userName").val(username);
        $("#password").val(password);
    });
    //获取cookie
    function getCookie(cname) {
        var name = cname + "=";
        var ca = document.cookie.split(';');
        for(var i=0; i<ca.length; i++) {
            var c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1);
            if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
        }
        return "";
    }
    //记住密码功能
    function remember(){
        var remFlag = $("input[type='checkbox']").is(':checked');
        if(remFlag==true){ //如果选中设置remFlag为1
            //cookie存用户名和密码,回显的是真实的用户名和密码,存在安全问题.
            var conFlag = confirm("记录密码功能不宜在公共场所(如网吧等)使用,以防密码泄露.您确定要使用此功能吗?");
            if(conFlag){ //确认标志
                $("#remFlag").val("1");
                var userName=$("#userName").val();
                var password=$("#password").val();
				alert("123456")
				$.post("${absoluteContextPath}/login/remember",{ "userName": userName ,"password":  password},null);
            }else{
                $("input[type='checkbox']").removeAttr('checked');
             //   $("#remFlag").val("");
            }
        }else{ //如果没选中设置remFlag为""
           // $("#remFlag").val("");
        }
    }



	//用户名输入框
	$('.user-login input').focus(function(){
		$(this).siblings('label').hide();
		$(this).parent().css({
			border:'1px solid #8BB7D9'
		})
		$(this).siblings('i').css({
			background: 'url(images/demoimg/lg-user2.png)'
		})
	})
	$('.user-login label').click(function(){
		$(this).siblings('input').focus();
	})
	$('.user-login input').blur(function(){
		$(this).parent().css({
			border:'1px solid #B8B8B8'
		})
		if ($(this).val() == '') {
			$(this).siblings('label').show();
			$(this).siblings('i').css({
			background: 'url(images/demoimg/lg-user1.png)'

		})
		};
	})
	//密码输入框
	$('.pass-login input').focus(function(){
		$(this).siblings('label').hide();
		$(this).parent().css({
			border:'1px solid #8BB7D9'
		})
		$(this).siblings('i').css({
			background: 'url(images/demoimg/lg-pass2.png)'
		})
	})
	$('.pass-login label').click(function(){
		$(this).siblings('input').focus();
	})
	$('.pass-login input').blur(function(){
		$(this).parent().css({
			border:'1px solid #B8B8B8'
		})
		if ($(this).val() == '') {
			$(this).siblings('label').show();
			$(this).siblings('i').css({
			background: 'url(images/demoimg/lg-pass1.png)'
		})
		};
	})

	function login(){
		var userName=$("#userName").val();
		var password=$("#password").val();
        $.ajax({
            type:"POST",   //http请求方式
            async:true,
            url:"${absoluteContextPath}/login/login", //发送给服务器的url
            data:{ "userName": userName ,"password":  password} , //发送给服务器的参数

            success: function(data){
			if(data=="true"){
                window.location.href="${absoluteContextPath}/admin";
            }else{
                $(".login-error").css('display','block');
			}
               /* maxValue =data;
                document.getElementById("typeValue").value=maxValue;*/
			//alert("123");
            }
        });
	}


</script>
</html>