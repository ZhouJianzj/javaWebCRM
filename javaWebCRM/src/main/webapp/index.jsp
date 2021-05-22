<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>可切换的精美CSS3登录注册表单DEMO演示</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="./style.css">
	<script src="jQuery/jquery-3.6.0.js"></script>
	<script>
		//为了实现点击和按回车都可以登录把登录的时间封装一下
		function login(){
			$.ajax({
				data:{
					"email": $("#SignInEmail").val() ,
					"psd":$("#SignInPassword").val()
				},
				url:"user/login?",
				type:"post",
				dataType:"json",
				success:function (d) {

				},
			})
		}
		$(function () {
			$("#button1").on("click",login)
			$(window).keydown(function (event) {
				var keyCode = event.keyCode;
				if (keyCode == 13){
					login()
				}
			})


		})
	</script>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container right-panel-active">
			<!-- Sign Up -->
			<div class="container__form container--signup">
				<form action="#" class="form" id="form1">
					<h2 class="form__title">Sign Up</h2>
					<input type="text" placeholder="User" class="input" />
					<input type="email" placeholder="Email" class="input" />
					<input type="password" placeholder="Password" class="input" />
					<button class="btn">Sign Up</button>
				</form>
			</div>

			<!-- Sign In -->
			<div class="container__form container--signin">
				<form action="#" class="form" id="form2">
					<h2 class="form__title">Sign In</h2>
					<input type="email" placeholder="Email" class="input" id="SignInEmail" />
					<input type="password" placeholder="Password" class="input" id="SignInPassword"/>
					<a href="#" class="link" id="errorMsg">Forgot your password?</a>
					<button class="btn" id="button1">Sign In</button>
				</form>
			</div>

			<!-- Overlay -->
			<div class="container__overlay">
				<div class="overlay">
					<div class="overlay__panel overlay--left">
						<button class="btn" id="signIn">Sign In</button>
					</div>
					<div class="overlay__panel overlay--right">
						<button class="btn" id="signUp">Sign Up</button>
					</div>
				</div>
			</div>
		</div>
<!-- partial -->
  <script  src="./script.js"></script>

</body>
</html>
