<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/view/header.jsp"%> 
  
  
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Customer registered successfully!</h1>
                </div>
            </div>
        </section>

        <section class="container">
            <p>
                <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">View Products</a>
            </p>
        </section>
    </div>
    
<%@include file="/WEB-INF/view/footer.jsp" %>