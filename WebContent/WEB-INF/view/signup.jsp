<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>
    
    
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1 class="text-success">Sign Up</h1>
            <h4>&nbsp;</h4>
            <h4 class="text-muted">Enter your Username</h4>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form" action="register" method="post">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Username</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="Username"
                  name="username">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Email</label>
                </div>
                <div class="col-sm-10">
                  <input type="email" class="form-control" id="inputEmail3" placeholder="Email"
                  name="email">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Password</label>
                </div>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="inputPassword3" placeholder="Password"
                  name="password">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Confirm Password</label>
                </div>
                <div class="col-sm-10">
                  <input type="password" class="form-control" id="inputPassword3" placeholder="Password"
                  name="confirmpassword">
                </div>
              </div>
              <h4>&nbsp;</h4>
              <h4 class="text-muted">User Details</h4>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">First Name</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="First Name" name="fname">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Middle Name</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Middle Name" name="mname">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Last Name</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Last Name" name="lname">
                </div>
              </div>
              <h4>&nbsp;</h4>
              <h4 class="text-muted">Billing Address</h4>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">House Number</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="House Number" name="billHouseNum">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Street</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Street" name="billStreet">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Subdivision</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Subdivision" name="billSubd">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">City</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="City" name="billCity">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Postal Code</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Postal Code" name="billPostal">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Country</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Country" name="billCountry">
                </div>
              </div>
              <h4>&nbsp;</h4>
              <h4 class="text-muted">Shipping Address</h4>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">House Number</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="House Number" name="shipHouseNum">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Street</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Street" name="shipStreet">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Subdivision</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Subdivision" name="shipSubd">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">City</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="City" name="shipCity">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Postal Code</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Postal Code" name="shipPostal">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Country</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" placeholder="Country" name="shipCountry">
                </div>
              </div>
              
              <!-- Used when an admin adds a product or financial manager -->
              <div class="form-group" style="display: none;">
                <div class="col-sm-2">
                  <label class="control-label">Role</label>
                </div>
                <div class="col-sm-10">
                  <select class="form-control">
                    <option>Product Manager</option>
                    <option>Financial Manager</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-success" contenteditable="true">Sign Up</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
</body>
</html>