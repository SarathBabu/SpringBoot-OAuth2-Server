
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
		<h2>Please Confirm</h2>
		<p>You hereby authorize ${client.clientId} to access your
			protected resources.</p>

		<form id="confirmationForm" name="confirmationForm"
			action="/oauth/authorize" method="post">
			<input name="user_oauth_approval" value="true" type="hidden" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<ul>
				<#list auth_request.getScope() as scope>
				<li><div class="form-group">
						${scope} <input type="radio" name="scope.${scope}" value="true">Approve</input>
						<input type="radio" name="scope.${scope}" value="false" checked>Deny</input>
					</div></li>
				</#list>
			</ul>
			<label><input name="authorize" value="Authorize"
				type="submit" /></label>
		</form>
	</section>
</body>
</html>