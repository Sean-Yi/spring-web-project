<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/header.jsp"%>
    
    
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Order successfully canceled</h1>

                    <p>Thank you see you for visit our website !</p>
                </div>
            </div>
        </section>

        <section class="container">
            <p>
                <a href="<spring:url value="/" />" class="btn btn-default">OK</a>
            </p>
        </section>

    </div>
    
    
<%@include file="/WEB-INF/view/footer.jsp" %>