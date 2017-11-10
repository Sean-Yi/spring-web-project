<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/view/header.jsp"%>



<!-- Carousel -->
<div class="container-fluid" style="margin-top:-20px;">
<div class="row">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">

      <div class="item active">
        <img src="<c:url value="/resources/images/pic1.jpg"/>" alt="Los Angeles" style="width:100%;">
        <div class="carousel-caption">
          <h3>Welcome to Sean's website</h3>
          <p>This website is for a personal e-commerce project</p>
        </div>
      </div>

      <div class="item">
        <img src="<c:url value="/resources/images/pic2.png"/>" alt="Chicago" style="width:100%;">
        <div class="carousel-caption">
          <h3>Welcome to Sean's website</h3>
          <p>This website is for a personal e-commerce project</p>
        </div>
      </div>
    
      <div class="item">
        <img src="<c:url value="/resources/images/pic3.jpg"/>" style="width:100%;">
        <div class="carousel-caption">
          <h3>Welcome to Sean's website</h3>
          <p>This website is for a personal e-commerce project</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
</div>

<div class="container marketing" style="margin-top:100px;">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/women.jpg" />" alt="Generic placeholder image" width="140" height="140">
            <h2>Women</h2>
            <p>Perfect women clothing in the world</p>
            <p><a class="btn btn-default" href="<spring:url value="/product/list"/>" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/men.jpg" />" alt="Generic placeholder image" width="140" height="140">
            <h2>Men</h2>
            <p>very suitable men clothing in the world</p>
            <p><a class="btn btn-default" href="<spring:url value="/product/list"/>" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
            <img class="img-circle" src="<c:url value="/resources/images/baby.jpg" />" alt="Generic placeholder image" width="140" height="140">
            <h2>Children</h2>
            <p>very soft and safest children clothing</p>
            <p><a class="btn btn-default" href="<spring:url value="/product/list"/>" role="button">View details &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
    </div><!-- /.row -->


</div>




<%@include file="/WEB-INF/view/footer.jsp" %>
