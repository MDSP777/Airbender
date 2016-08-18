<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>

<div id="fullcarousel-example" data-interval="false" class="carousel slide"
    data-ride="carousel">
      <div class="carousel-inner">
          <div class="item active">
          <img src="<c:url value="/resources/images/Carousel1.jpg" />"
          id="carousel1">
          <div class="carousel-caption"></div>
        </div>
        <div class="item">
          <img src="<c:url value="/resources/images/Carousel2.jpg" />"
          id="carousel2">
          <div class="carousel-caption"></div>
        </div>
        <div class="item">
          <img src="<c:url value="/resources/images/Carousel3.jpg" />"
          id="carousel3">
          <div class="carousel-caption"></div>
        </div>
      </div>
      <a class="left carousel-control" href="#fullcarousel-example" data-slide="prev"><i class="icon-prev fa fa-angle-left"></i></a>
      <a class="right carousel-control" href="#fullcarousel-example" data-slide="next"><i class="icon-next fa fa-angle-right"></i></a>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-3">
            <a href="categories?type=boots"><img src="<c:url value="/resources/images/Boots.jpg" />" class="img-responsive" id="bootsimg"></a>
            <h2>Boots</h2>
            <p>If it's for fashion or for the rainy season, we have here the boots to warm up your style or to warm up the heart of your cold love!</p>
          </div>	
          <div class="col-md-3">
            <a href="categories?type=shoes"><img src="<c:url value="/resources/images/Shoes.jpg" />" class="img-responsive" id="shoesimg"></a>
            <h2>Shoes</h2>
            <p>Leather or rubber, Boat shoes or sneakers. Get 2 pairs of shoes for yourself or for the both of you!</p>
          </div>
          <div class="col-md-3">
            <a href="categories?type=sandals"><img src="<c:url value="/resources/images/Sandals.jpg" />" class="img-responsive" id="sandalsimg"></a>
            <h2>Sandals</h2>
            <p>Kailangan mo ng masasandal-an? These sandals won't let down your feet. Be proud to be single! Be fashionable and chill at the same time!</p>
          </div>
          <div class="col-md-3">
            <a href="categories?type=slippers"><img src="<c:url value="/resources/images/Slippers.jpg" />" class="img-responsive" id="slippersimg"></a>
            <h2>Slippers</h2>
            <p>Rubber flip-flops, comfy flip flops. These slippers will make you comfortable with its strong grip and protection.</p>
          </div>
        </div>
      </div>
    </div>
</body>
</html>