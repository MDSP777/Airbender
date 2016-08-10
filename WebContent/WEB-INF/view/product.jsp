<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
	<script src="<c:url value="/resources/js/confirmPurchase.js" />" type="text/javascript"></script>

   
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
                <h4 contenteditable="false" class="text-muted" id="quantity-txt">Quantity:&nbsp;</h4>
              </div>
              <div class="col-md-1">
                
              <form class="quantity-input">
                  <input type="number" class="quantity-input" name="quantity" id="quantity">
                  <input type="hidden" name="price" val="69.00">
              </div>
              <div class="col-md-2 text-right">
                <h4 class="text-muted" contenteditable="false" id="total-price">Total: 69.00 php</h4>
              </div>
              <div class="col-md-2">
                <button type="button" class="btn btn-info btn-lg" id="purchase" data-toggle="modal" data-target="#purchaseModal">Purchase</button>
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
			          <p id="confirmMessage"></p>
			        </div>
			        <div class="modal-footer">
			          <button type="submit" class="btn btn-default" data-dismiss="modal">Confirm</button>
			          <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
			        </div>
			      </div>
			    </form>
			    <script>
				    $('#purchase').click(function(){
				        $('#confirmMessage').text('You are purchasing ' + $('#quantity').val() + ' Shoes 1 for ' + parseFloat($('#quantity').val()) * parseFloat($('#price').val())+ ' php')
				   	})
	
				   $('#quantity').click(function(){
				        $('#total-price').text('Total Price: ' + (number($('#quantity').val()) * number($('#price').val())))
				   })
			    
			    </script>
			     
			    </div>
			  </div>
			  
            </div>
          </div>
        </div>
      </div>
    </div>

</body>
</html>