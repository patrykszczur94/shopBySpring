<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<section>
		<div class="jumbotron">
			<div class="container">
				<p class="control-label col-lg-2 col-lg-2">New article</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newProduct" class="form-horizontal">
			<fieldset>

				<table style="with: 50%">
					<tr>
						<td class="blueCol">ProductId</td>
						<td><form:input id="productId" path="productId" type="text"
								class="form:input-large" /></td>
					</tr>

					<tr>
						<td>Name</td>
						<td><form:input id="name" path="name" type="text"
								class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Manufacturer</td>
						<td><form:input id="manufacturer" path="manufacturer"
								type="text" class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Unit price</td>
						<td><form:input id="unitPrice" path="unitPrice" type="text"
								class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><form:input id="description" path="description"
								type="text" class="form:input-large" /></td>
					</tr>
					<tr>
						<td>category</td>
						<td><form:input id="category" path="category" type="text"
								class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Units in stock</td>
						<td><form:input id="unitsInStock" path="unitsInStock"
								type="text" class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Units in order</td>
						<td><form:input id="unitsInOrder" path="unitsInOrder"
								type="text" class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Discounted</td>
						<td><form:checkbox id="discounted" path="discounted" /></td>
					</tr>
					<tr>
						<td>Discounted</td>
						<td><form:radiobutton path="condition" value="New" /> New <form:radiobutton
								path="condition" value="Old" /> Old <form:radiobutton
								path="condition" value="Refurbished" /> Refurbished</td>
					</tr>
					<tr>
						<td><input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" /></td>
					</tr>
				</table>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
