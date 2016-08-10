<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>

    
    
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1>${product.name }</h1>
            <h3 class="text-muted">Price: ${product.price } php</h3>
            <h3>Details</h3>
            <p class="lead">${product.description }</p>
            <h3>Reviews</h3>
            <ul class="list-group">
              <li class="list-group-item">
                <h4>User 1</h4>Item is shit, don't buy
                <span class="badge">5/5</span>
              </li>
            </ul>
            <form>
              <input name="review" placeholder=" Write a review ... " id="review">
            </form>
            <div class="row">
              <div class="col-md-6"></div>
              <div class="col-md-1">
                <h4 contenteditable="true" class="text-muted" id="quantity-txt">Quantity:&nbsp;</h4>
              </div>
              <div class="col-md-1">
                <form class="quantity-input">
                  <input type="number" class="quantity-input">
                </form>
              </div>
              <div class="col-md-2 text-right">
                <h4 class="text-muted" contenteditable="true">Total: 69.00 php</h4>
              </div>
              <div class="col-md-2">
                <a href="#" id="buy-btn"><i class="fa fa-4x fa-cart-arrow-down fa-fw pull-right t-plus text-success"></i></a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

</body>
</html>