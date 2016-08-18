<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
	<script src="<c:url value="/resources/js/reviewError.js" />" type="text/javascript"></script>

   
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <div class="row">
              <div class="col-md-2">
                <h1 style="width: 200px;">${product.name }</h1>
              </div>

              
            </div>
            <h3 class="text-muted">Price: ${product.price } php</h3>
            <h3>Details</h3>
            <p class="lead">${product.description }</p>
            <h3>Reviews</h3>
            <ul class="list-group">
              <c:forEach var="review" items="${product.reviews }">
	              <li class="list-group-item">
	                <h4>${review.username }</h4>${review.content }
	<!--                 <span class="badge">5/5</span> -->
	              </li>
              </c:forEach>
            </ul>
            <c:if test="${isLoggedIn=='yes' }">
	            <form action="review" method="post">
	              <input type="hidden" name="productId" value="${product.id }" />
	              <input name="review" placeholder=" Write a review ... " id="review"><br>
	              <button type="submit" class="btn btn-success">Submit Review</button>
	            </form>
            <div class="row">
              <div class="col-md-6"></div>
              <div class="col-md-1">
                <h4 contenteditable="false" class="text-muted" id="quantity-txt">Quantity:&nbsp;</h4>
              </div>
              <form action="purchase" method="post">
	              <div class="col-md-1">
	                  <input type="number" class="quantity-input" name="quantity" id="quantity" min="1" value="0" required/>
	              </div>
	              <div class="col-md-2 text-right">
	                <h4 class="text-muted" contenteditable="false" id="total-price">Total: 0 php</h4>
	              </div>
	              <div class="col-md-2">
	                <button type="button" class="btn btn-success btn-lg" id="purchase" data-toggle="modal" data-target="#purchaseModal">Purchase</button>
	              </div>
	              
	              
				  <div class="modal fade" id="purchaseModal" role="dialog">
					    <div class="modal-dialog">
					    
					      <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h4 class="modal-title">Confirm Purchase</h4>
					        </div>
					        <div class="modal-body">
					          <p id="confirmMessage"></p><br>  
			                  <label for="inputEmail3" class="control-label">Credit Card Number: &nbsp; </label>
			                  <input type="hidden" name="price" value="${product.price }" id="price"/>
			                  <input type="hidden" name="productId" value="${product.id }" id="productId"/>
			                  <input type="text" class="text-input" name="creditcard" id="creditcard"/>
					        </div>
					        <div class="modal-footer">
					          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
					          <input class="btn btn-default" type="submit"/>
					        </div>
					      </div>
					    <script>
						    $('#purchase').click(function(){
						    	$('#confirmMessage').text('You are purchasing ' + $('#quantity').val() + ' ${product.name } for ' + parseFloat($('#quantity').val()) * parseFloat(${product.price }) + ' php')
						   	});
			
						   $('#quantity').click(function(){
							   total = parseFloat($('#quantity').val()) * parseFloat(${product.price });
							   if(isNaN(total)) total = 0;
						       $('#total-price').text('Total: ' + total + ' php');
						   });
					    
					    </script>
					     
					    </div>
			  		</div>
			  
			    </form>
			    </c:if>
            </div>
          </div>
        </div>
      </div>
    </div>

</body>
</html>