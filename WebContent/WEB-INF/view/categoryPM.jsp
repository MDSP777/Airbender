<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>


    <div class="section">
    <div class="section">
      <div class="container">
        <div class="row">
    	<h3>Product Manager</h3>
          <div class="col-md-12">
            <table class="table">
              <thead>
                <tr>
                  <th>Product Name</th>
                  <th>Description</th>
                  <th>Price</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="product" items="${products }">
	                <tr>
	                  <td>${product.name }</td>
	                  <td>${product.description }</td>
	                  <td>P${product.price }</td>
	                  <td>
	                  	<div style="">
                			<a href="editproduct?id=${product.id }"><i class="fa fa-2x fa-edit fa-fw pull-right text-success"></i></a>
              			</div></td>
	                </tr>
                </c:forEach>
                <tr>
                	<td>
                	<div style="">
               			 <a href="addproduct"><i class="-square -square-o fa fa-3x fa-fw fa-plus-circle text-success"></i></a>
              		</div>
              		</td>
              		<td></td>
              		<td></td>
              		<td></td>
              	</tr>
              </tbody>
              
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>