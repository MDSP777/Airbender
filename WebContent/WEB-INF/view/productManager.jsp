<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>

    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1>Edit Product</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <form class="form-horizontal" role="form">
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Product Name</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputEmail3" placeholder="Email">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Description</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputPassword3" placeholder="Password">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Price</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputPassword3" placeholder="Password">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Category</label>
                </div>
                <div class="col-sm-10">
                  <select class="form-control">
                    <option>Boots</option>
                    <option>Shoes</option>
                    <option>Sandals</option>
                    <option>Slippers</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default btn-sm">Save</button>
                  <button type="button" class="btn btn-default btn-sm">Cancel</button>
                  <!-- if product == null then hide this -->
                  <button type="submit" class="btn btn-danger btn-sm">Delete Product</button>
                  
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

</body>
</html>