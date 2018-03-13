<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<p>All products in shops</p>
			</div>
		</div>
	</section>
	<div align="middle">
		<a href="<spring:url value="/products/add"/>"
			class="btn btn-info btn-large">Add material</a>
	</div>
	<br/><br/><br/>
	<section class="container">
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="row">
						<div class="caption">
							<p>product name : ${product.name}</p>
							<p>Unit in stock : ${product.unitsInStock}</p>
							<p>${product.description}</p>

							<a
								href="<spring:url value="/products/product?id=${product.productId}"/>"
								class="btn btn-info btn-large"> show article details </a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>