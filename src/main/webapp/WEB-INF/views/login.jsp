<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<html>
<head>
<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<div class="panel-body">
		<c:if test="${not empty error}">
			<div>wrong user name or password</div>
		</c:if>
		<form action="<c:url value = "/j_spring_security_check"></c:url>"
			method="post">
			<fieldset>
				<div>
					<input class="form-control" placeholder="username"
						name='j_username' type="text" value="">
				</div>
				<div>
					<input class="form-control" placeholder="password"
						name='j_password' type="password" value="">
				</div>
				<div>
					<input class="btn btn-lg btn-succes btn-block" type="submit"
						value="login">
				</div>
			</fieldset>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>