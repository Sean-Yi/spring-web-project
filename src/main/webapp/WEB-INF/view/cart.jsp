<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/header.jsp"%>


	<div class="container">
		<div class="jumbotron">              
			<h1>Cart</h1>
			<p>All the selected products in your shopping cart</p>
		</div>
		
	    <table class="table table-striped table-hover">
	        <thead>
		        <tr class="success">
					<th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
		        </tr>
	        </thead>
	        
	        <c:forEach var="cartItem" items="${cart.cartItems}">
	        	
	        	<!-- construct an "removeProductFromCart" link with Product id -->
				<c:url var="removeItemFromCart" value="/customer/cart/remove">
					<c:param name = "cartItemId" value="${cartItem.cartItemId}"/>
				</c:url>
	        
	            <tr>
                    <td>${cartItem.product.productName}</td>
                    <td>${cartItem.product.productPrice}</td>
                    <td>${cartItem.quantity}</td>
                    <td>${cartItem.totalPrice}</td>
                    <td><a href="${removeItemFromCart}" class="label label-danger">
	                        <span class="glyphicon glyphicon-remove"></span>
	                        remove
                        </a>
                    </td>
	            </tr>
	    
	        </c:forEach>
	        
	        	<tr>
                    <th></th>
                    <th></th>
                    <th>Grand Total</th>
                    <th>${cart.grandTotal}</th>
                    <th></th>
                </tr>
        
	      </table>
	</div>
	
	<div class="container">
           
      <a href="<spring:url value="/product/list"/>" class="btn btn-default">Continue Shopping</a>

       <a href="<spring:url value="/customer/cart/remove"/>" class="btn btn-danger pull-left">
       	<span class="glyphicon glyphicon-remove-sign"> </span>
       	Clear Cart
       </a>
       
       <a href="<spring:url value="/order/${cart.cartId}"/>" class="btn btn-default">Order Now</a>
       
    </div>
    

<%@include file="/WEB-INF/view/footer.jsp" %>