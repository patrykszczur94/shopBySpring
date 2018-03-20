<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html" ; charset=UTF-8>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<title>Product</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<p>Article details</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
		    <h3>Product id : ${product.productId}</h3>
			<h3>Product name : ${product.name}</h3>
			<h3>Product description : ${product.description}</h3>
			<h3>Product code : ${product.productId}</h3>
			<h3>Product manufacturer : ${product.manufacturer}</h3>
			<h3>Product category : ${product.category}</h3>
			<h3>Units in stock : ${product.unitsInStock}</h3>
			<h3>Units in order : ${product.unitsInOrder}</h3>
			<h3>Product condition : ${product.condition}</h3>
			<br>
			<h4>
				<strong>Product unitPrice : ${product.unitPrice} $</strong>
			</h4>
			<br> <a href="<spring:url value="/products"/>"
				class="btn btn-default btn-large"> Back </a> <a href='#'
				class="btn btn-warning btn-large"> Buy now </a>
		</div>
	</section>
</body>