<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="header.jsp"/>

    <div class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-12"></div>
        </div>
        <div class="row">
          <div class="col-md-12">
            <ul class="nav nav-pills">
              <c:choose>
          	    <c:when test="${type=='total' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="view_sales_reports?type=total">Total Sales</a>
              </li>
              <c:choose>
          	    <c:when test="${type=='category' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="view_sales_reports?type=category">Sales by Category</a>
              </li>
              <c:choose>
          	    <c:when test="${type=='product' }">
              	  <li class="active">
                </c:when>
                <c:otherwise>
                  <li>
                </c:otherwise>
              </c:choose>
                <a href="view_sales_reports?type=product">Sales by product</a>
              </li>
            </ul>
            <h2 style="margin-bottom: 20px;">Sales Report</h2>
            <table class="table">
              <thead>
                <tr>
                  <th>Sales</th>
                  <th>Total Sales</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="sale" items="${sales }">
	                <tr>
	                  <td>${sale[0] }</td>
	                  <td>${sale[1] }</td>
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