<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>

    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <h1>${headerName } Product</h1>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
          	<c:if test="${headerName=='Add' }">
            	<form class="form-horizontal" role="form" action="add_product" method="post">
          	</c:if>
          	<c:if test="${headerName=='Edit' }">
            	<form class="form-horizontal" role="form" action="edit_product" method="post">
          	</c:if>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputEmail3" class="control-label">Product Name</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputEmail3" name="productName" value="${product.name }">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Description</label>
                </div>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="inputPassword3" name="productDescription" value="${product.description }">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label for="inputPassword3" class="control-label">Price</label>
                </div>
                <div class="col-sm-10">
                  <input type="number" class="form-control" id="inputPassword3" name="productPrice" value="${product.price }">
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-2">
                  <label class="control-label">Category</label>
                </div>
                <input type="hidden" name="productId" value="${product.id }"/>
                <div class="col-sm-10">
                  <select class="form-control" name="productCategory">
                    <option <c:if test="${product.category=='boots' }">selected</c:if>>Boots</option>
                    <option <c:if test="${product.category=='shoes' }">selected</c:if>>Shoes</option>
                    <option <c:if test="${product.category=='sandals' }">selected</c:if>>Sandals</option>
                    <option <c:if test="${product.category=='slippers' }">selected</c:if>>Slippers</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <button type="submit" class="btn btn-default btn-sm">Save</button>
                  <button type="button" class="btn btn-default btn-sm" onclick="location.href='pm';">Cancel</button>
                  <c:if test="${headerName=='Edit' }">
                  <button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?id=${product.id }';">Delete Product</button>
                  </c:if>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

</body>
</html>