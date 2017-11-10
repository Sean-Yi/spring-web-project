<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/header.jsp"%>

	<div class="container">
	    <div class="page-header">
	        <h1>All Products</h1>
	
	        <p class="lead">Checkout all the awesome products available now!</p>
	    </div>
	
	    <table class="table table-striped table-hover">
	        <thead>
		        <tr class="success">
		            <th>Photo Thumb</th>
		            <th>Product Name</th>
		            <th>Category</th>
		            <th>Condition</th>
		            <th>Price</th>
		            <th></th>
		        </tr>
	        </thead>
	        <c:forEach items="${products}" var="product">
	        	
	        	<!-- construct an "viewProduct" link with Product id -->
				<c:url var="viewProductdetailInfo" value="/product/detailInfo">
					<c:param name = "productId" value="${product.productId}"/>
				</c:url>
	    
	            <tr>
	                <td><img src="${pageContext.request.contextPath}/img/${product.productId}.jpg" alt="image" style="width:100%"/></td>
	                <td>${product.productName}</td>
	                <td>${product.productCategory}</td>
	                <td>${product.productCondition}</td>
	                <td>${product.productPrice} USD</td>
	                <td>
	                 <a href="${viewProductdetailInfo}">
	                 	<span class="glyphicon glyphicon-info-sign"></span>
	                 </a>
	                </td>
	            </tr>
	        </c:forEach>
	      </table>
	</div>



<%@include file="/WEB-INF/view/footer.jsp" %>
