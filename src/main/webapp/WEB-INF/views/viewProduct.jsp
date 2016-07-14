<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
	<div class="container">
		<div class="page-header">
			<h1>Product Detail</h1>

			<p class="lead">Here is detailed information of the product</p>
			<hr />
			<div class="container" ng-app="cartApp">
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
						
						<!-- use JSTL to define variables since we will use it in EL -->
						<c:set var="role" scope="page" value="${param.role}}"/>
						<c:set var="url" scope="page" value="/productList"/>
						<c:if test="${role=='admin'}">
							<c:set var="url" scope="page" value="/admin/productInventory" />
						</c:if>
						
						<p ng-controller="cartCtrl">
							<a href="<c:url value="${url}"/>" class="btn btn-default">Back</a>
							<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"><span class="glyphicon glyphicon-shopping-cart"></span>Order now</a>
							<a href="<c:url value="/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
						</p>
					</div>

				</div>
			</div>

		</div>
	</div>
</div>

<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>