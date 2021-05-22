<%@ page contentType="text/html;charset=UTF-8" language="java" %><html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>可切换的精美CSS3登录注册表单DEMO演示</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
<link rel="stylesheet" href="./style.css">

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
					<input type="email" placeholder="Email" class="input" />
					<input type="password" placeholder="Password" class="input" />
					<a href="#" class="link">Forgot your password?</a>
					<button class="btn">Sign In</button>
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
