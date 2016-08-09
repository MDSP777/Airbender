<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
              <li>
                <a href="#">Total Sales</a>
              </li>
              <li class="active">
                <a href="#">Sales by Category</a>
              </li>
              <li>
                <a href="#">Sales by product</a>
              </li>
            </ul>
            <h2 style="margin-bottom: 20px;">Sales Report</h2>
            <table class="table">
              <thead>
                <tr>
                  <th>Category</th>
                  <th>Sales</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Boots</td>
                  <td>69.00</td>
                </tr>
                <tr>
                  <td>Shoes</td>
                  <td>69.00</td>
                </tr>
                <tr>
                  <td>Sandals</td>
                  <td>69.00</td>
                </tr>
                <tr>
                  <td>Slippers</td>
                  <td>69.00</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

</body>
</html>