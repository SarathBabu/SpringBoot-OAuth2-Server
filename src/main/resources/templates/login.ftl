<!DOCTYPE html>

<html lang="en">
<head>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet" href="/static/css/styles.css">
<script type="script" src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="script" src="/webjars/jquery/3.3.1-1/query.min.js"></script>
<link rel="stylesheet"
	href="/webjars/font-awesome/5.2.0/css/all.min.css">
<link rel="stylesheet" href="/static/css/bootstrap-social.css">

</head>

<body>
	<section class="app-heading">
		<div class="container header">
			<h1>OAuth 2.0 Server Application</h1>
		</div>
	</section>
	<section class="container main">
		<div class="row">
			<div class="col-lg-6 col-md-8 col-sm-12">
				<form name="f" action="/login" method="post">
				 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<div class="form-group">
						<label for="username">User name</label> <input
							type="text" class="form-control" id="username" name="username"
							aria-describedby="emailHelp" value="userone" placeholder="Enter username">
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input
							type="password" class="form-control" id="password" value="password" name="password"
							placeholder="Password">
					</div>
					<input type="submit" class="btn btn-primary"></input>
				</form>
			</div>
		</div>
	</section>

</body>


</html>