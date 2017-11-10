<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/view/header.jsp"%>



    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <img src="${pageContext.request.contextPath}/img/${product.productId}.jpg" alt="image" alt="image" style="width:100%; height: 300px" />
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                       <strong>Manufacturer</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                    <h4>${product.productPrice} USD</h4>
                    
                    	
                    	<a href="${pageContext.request.contextPath}/product/list" class="btn btn-info" role="button">Back</a>
                        <a href="${pageContext.request.contextPath}/customer/cart/${product.productId}" class="btn btn-info" role="button" onclick="myFunction()">Add To Cart</a>
                        <a href="${pageContext.request.contextPath}/customer/cart" class="btn btn-info" role="button">View Cart</a>
                      
                </div>
            </div>
        </div>
	</div>
		
		<script>
		function myFunction() {
		    alert("Product successfully added to the cart!, click again to increase quantity of the product");
		}
		</script>


<%@include file="/WEB-INF/view/footer.jsp" %>
