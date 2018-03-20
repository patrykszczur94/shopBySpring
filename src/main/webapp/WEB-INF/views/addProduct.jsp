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
	<section>
		<div class="jumbotron">
			<div class="container">
				<p class="control-label col-lg-2 col-lg-2">New article</p>
			</div>
		</div>
	</section>
	<c:url value="/logout" var="logoutUrl" />
	<a href="${logoutUrl}">Log Out</a>
	<form:form modelAttribute="newProduct" class="form-horizontal"
		encrypte="multipart/form-data">
		<fieldset>
			<table style="with: 50%">
				<tr>
					<td>product image</td>
					<td><div>

							<div class="form-group">
								<label class="control-label col-lg-2" for="productImage">
									<spring:message code="addProdcut.form.productImage.label" />
								</label>
								<div class="col-lg-10">
									<form:input id="productImage" path="productImage" name="productImage" type="file"
										class="form:input-large" />
								</div>
							</div>
						</div></td>
				</tr>
				<tr>
					<td><spring:message code="addProduct.form.productId.label" /></td>
					<td><form:input id="productId" path="productId" type="text"
							class="form:input-large" /></td>
				</tr>

				<tr>
					<td><spring:message code="addProduct.form.productName.label" /></td>
					<td><form:input id="name" path="name" type="text"
							class="form:input-large" /></td>
				</tr>
				<tr>
					<td><spring:message code="addProduct.form.manufacturer.label" /></td>
					<td><form:input id="manufacturer" path="manufacturer"
							type="text" class="form:input-large" /></td>
				</tr>
				<tr>
					<td><spring:message code="addProduct.form.unitPrice.label" /></td>
					<td><form:input id="unitPrice" path="unitPrice" type="text"
							class="form:input-large" /></td>
				</tr>
				<tr>
					<td><spring:message code="addProduct.form.description.label" /></td>
					<td><form:input id="description" path="description"
							type="text" class="form:input-large" /></td>
				</tr>
				<tr>
					<td><spring:message code="addProduct.form.category.label" /></td>
					<td><form:input id="category" path="category" type="text"
							class="form:input-large" /></td>
				</tr>
				<tr>
					<td><spring:message code="addProduct.form.unitsinstock.label" /></td>
					<td><form:input id="unitsInStock" path="unitsInStock"
							type="text" class="form:input-large" /></td>
				</tr>
				<%--<tr>
						<td>Units in order</td>
						<td><form:input id="unitsInOrder" path="unitsInOrder"
								type="text" class="form:input-large" /></td>
					</tr>
					<tr>
						<td>Discounted</td>
						<td><form:checkbox id="discounted" path="discounted" /></td>
					</tr> --%>
				<tr>
					<td><spring:message code="addProduct.form.condition.label" /></td>
					<td><form:radiobutton path="condition" value="New" /> <spring:message
							code="addProduct.form.new.label" /> <form:radiobutton
							path="condition" value="Old" /> Old <form:radiobutton
							path="condition" value="Refurbished" /> <spring:message
							code="addProduct.form.refurbished.label" /></td>
				</tr>
				<tr>
					<td><input type="submit" id="btnAdd" class="btn btn-primary"
						value="<spring:message code="addProduct.form.add.label"/>" /></td>
				</tr>
			</table>
		</fieldset>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form:form>
	</section>
</body>
</html>
