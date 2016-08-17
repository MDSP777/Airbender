<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>


    <div class="section" id = "categories">
      <div class="container" style="margin-top: 30px;">
        <div class="row">
          <div class="col-md-12">
            <ul class="nav nav-pills">
          	  <c:choose>
          	    <c:when test="${type=='boots' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="categories?type=boots">Boots</a>
              </li>
              <c:choose>
          	    <c:when test="${type=='shoes' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="categories?type=shoes">Shoes</a>
              </li>
              <c:choose>
          	    <c:when test="${type=='sandals' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="categories?type=sandals">Sandals</a>
              </li>
              <c:choose>
          	    <c:when test="${type=='slippers' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="categories?type=slippers">Slippers</a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </div>
    <div class="section">
      <div class="container">
        <div class="row">
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
	                  <td><a href="item?id=${product.id }">${product.name }</a></td>
	                  <td>${product.description }</td>
	                  <td>P${product.price }</td>
	                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>

</html>