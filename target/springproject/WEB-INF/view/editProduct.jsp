<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/header.jsp"%>



    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>

            <p class="lead">Please update the product information here:</p>
        </div>

        <form:form action="addProduct" method="POST"  modelAttribute="product" enctype="multipart/form-data">
        
			<!-- need to associate this data with product Id -->
			<form:hidden path="productId" />
        	
	        <div class="form-group">
	            <label for="name">Name</label> 
	            <form:errors path="productName" cssStyle="color: #ff0000;" />
	            <form:input path="productName" id="name" class="form-Control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="category">Category</label>	   
	            <label class="checkbox-inline">
	            	<form:radiobutton path="productCategory" id="category" value="instrument" />Instrument
	            </label>
	            <label class="checkbox-inline">
	            	<form:radiobutton path="productCategory" id="category" value="record" />Record
	            </label>
	            <label class="checkbox-inline">
	            	<form:radiobutton path="productCategory" id="category" value="accessory" />Accessory
	            </label>
	        </div>
	
	        <div class="form-group">
	            <label for="description">Description</label>
	            <form:input path="productDescription" id="name" class="form-Control"/>
	            <form:textarea path="productDescription" id="description" class="form-Control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="price">Price</label>  
	            <form:errors path="productPrice" cssStyle="color: #ff0000;" />
	            <form:input path="productPrice" id="price" class="form-Control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="condition">Condition</label>
	            <label class="checkbox-inline">
	            	<form:radiobutton path="productCondition" id="condition" value="new" />New
	            </label>
	            <label class="checkbox-inline">
	            	<form:radiobutton path="productCondition" id="condition" value="used" />Used
	            </label>
	        </div>
	
	        <div class="form-group">
	            <label for="status">Status</label>
	            	<label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="active" />Active
	            </label>
	            	<label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="inactive" />Inactive
	            </label>
	        </div>
	
	        <div class="form-group">
	            <label for="unitInStock">Unit In Stock</label>  
	            <form:errors path="unitInStock" cssStyle="color: #ff0000;" />
	            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
	        </div>
	
	        <div class="form-group">
	            <label for="manufacturer">Manufacturer</label>
	            <form:input path="productManufacturer" id="name" class="form-Control"/>
	            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
	        </div>
			
				        
	        <div class="form-group">
	            <label class="control-label" for="productImage">Upload Picture</label>
	            <form:input id="productImage" path="productImage" type="file" class="form:input-large" />
	        </div>			
			
			
	        <br><br>
	        <input type="submit" value="submit" class="btn btn-default">
	        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
	        
        </form:form>      
	</div>

<%@include file="/WEB-INF/view/footer.jsp" %>