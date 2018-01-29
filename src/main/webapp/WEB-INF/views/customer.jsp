<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<p>Our customers</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">
			
				<!-- div responsible for parallel placement of results -->
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="row">
						<div class="caption">
							<p>customer id :${customer.userId}</p>
							<p>customer name : ${customer.name}</p>
							<p>customer address : ${customer.address}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>