<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>

<div id="signup" >
		<h1 class = "boxheader">Sign Up</h1>
		<div class="signupBox">
		<form action="signup" method="post">
			<div class="form-text" >Username</div>
			<input type="text" name="username"/>
			<div class="form-text" >Email Address</div>
			<input type="text" name="email"/>
			<div class="form-text" >Password</div>
			<input type="password" name="password"/>
			<div class="form-text" >First Name</div>
			<input type="text" name="fname"/>
			<div class="form-text" >Middle Name</div>
			<input type="text" name="mname"/>
			<div class="form-text" >Last Name</div>
			<input type="text" name="lname"/>
			<div class="form-text" >Billing Address</div>
			<div class="form-text" >House Number</div>
			<input type="text" name="billingAddHouse"/>
			<div class="form-text" >Street</div>
			<input type="text" name="billingAddSt"/>
			<div class="form-text" >Subdivision</div>
			<input type="text" name="billingAddSub"/>
			<div class="form-text" >City</div>
			<input type="text" name="billingAddCity"/>
			<div class="form-text" >Postal Code</div>
			<input type="text" name="billingAddPost"/>
			<div class="form-text" >Country</div>
			<input type="text" name="billingAddCountry"/>
			<div class="form-text" >Shipping Address</div>
			<div class="form-text" >House Number</div>
			<input type="text" name="ShippingAddHouse"/>
			<div class="form-text" >Street</div>
			<input type="text" name="ShippingAddSt"/>
			<div class="form-text" >Subdivision</div>
			<input type="text" name="ShippingAddSub"/>
			<div class="form-text" >City</div>
			<input type="text" name="ShippingAddCity"/>
			<div class="form-text" >Postal Code</div>
			<input type="text" name="ShippingAddPost"/>
			<div class="form-text" >Country</div>       
			<input type="text" name="ShippingAddCountry"/>
			<div class="loginButtons">
				<div class = "row">
					<button type="button" class="cancel">Cancel</button>
					<button type="submit" class="submit-user">Sign Up</button>
				</div>
			</div>
		</form>
		</div>
	</div>
</body>
</html>