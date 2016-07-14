<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Here is detailed information of the product</p>
			<hr />
			<div class="container">
				<div class="row">
					<div class="col-md-5">
						<img
							src="<c:url value="/resources/images/${product.productId }.png"/>"
							alt="image" style="width: 100%;height=300px;" />
					</div>
					<div class="col-md-7">
						<h3>${product.productName }</h3>
						<p>${product.productDescription }</p>
						<p>
							<strong>Manufacturer</strong>: ${product.productManufacturer }
						</p>
						<p>
							<strong>Category</strong>: ${product.productCategory }
						</p>
						<p>
							<strong>Condition</strong>: ${product.productCondition }
						</p>
						<p>
							<strong>Price</strong>: ${product.productPrice }
						</p>
					</div>

				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>