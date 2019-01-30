<%@ page import="java.util.Date" %>
<%@ page import="org.springframework.ui.Model" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="display" uri="http://displaytag.sf.net" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16/1/2018
  Time: 10:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Driver Order</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

</head>
<style>
    /* Make the image fully responsive */
    .carousel-inner img {
        width: 100%;
        height: 100%;
    }
    .bouton-image:before {
        content: "";
        width: 16px;
        height: 16px;
        display: inline-block;
        margin-right: 5px;
        vertical-align: text-top;
        background-color: transparent;
        background-position : center center;
        background-repeat:no-repeat;
    }
    .monBoutonUpdate:before{
        background: url("http://icons.iconarchive.com/icons/oxygen-icons.org/oxygen/16/Actions-edit-redo-icon.png");
    }
    .monBouton:before{
        background-image : url(http://icons.iconarchive.com/icons/custom-icon-design/flatastic-10/16/New-file-icon.png);
    }
    .monBoutonDelete:before{
        background: url("http://icons.iconarchive.com/icons/hopstarter/sleek-xp-basic/16/Close-2-icon.png");
    }
    .monBoutonSave:before{
        background :url("http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-7/16/Save-icon.png")  ;
    }
</style>
<body>

Welcome !
<security:authorize access="isAnonymous()">
    Guest
</security:authorize>
<!-- Print the logged in user name -->
<security:authorize access="isAuthenticated()">
    <security:authentication property="principal.username" />
</security:authorize>
<%------------------------------------------------------------------------------------------------------%>
<security:authorize access="isAnonymous()">
    <nav class="navbar navbar-expand-sm bg-light navbar-light">
        <!-- Brand -->
        <a class="navbar-brand" href="/">
            <img src="/resources/imgs/logo.jpg" alt="Logo" style="width:40px;">
        </a>

        <!-- Links -->
        <ul class="navbar-nav">
            <!-- Dropdown -->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                   Log In
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="/user">User</a>
                    <a class="dropdown-item" href="/admin">Admin</a>
                </div>
                    <srping:url value="/logout" var="logout" ></srping:url>
        </ul>
    </nav>
    <%---------------------------------------------------------------------------------------%>
    <div id="demo" class="carousel slide" data-ride="carousel">
        <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
        </ul>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container">
                    <img src="/resources/imgs/1.jpg" alt="Los Angeles" width="1100" height="400">
                </div>
                <div class="carousel-caption">
                    <%--<h3>Los Angeles</h3>--%>
                    <%--<p>We had such a great time in LA!</p>--%>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <img src="/resources/imgs/2.jpg"  alt="Terasek" width="1100" height="400">
                </div>
                <div class="carousel-caption">
                    <%--<h3>Chicago</h3>--%>
                    <%--<p>Thank you, Chicago!</p>--%>
                </div>
            </div>
            <div class="carousel-item">
                <div class="container">
                    <img src="/resources/imgs/3.jpg"  alt="New York" width="1100" height="400">
                </div>
                <div class="carousel-caption">
                    <%--<h3>New York</h3>--%>
                    <%--<p>We love the Big Apple!</p>--%>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon"></span>
        </a>
        <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon"></span>
        </a>
    </div>
</security:authorize>
<%-------------------------------------------------------------------------------------------------------%>
<security:authorize access="isAuthenticated()">
  <security:authorize access="hasAnyRole('USER','ADMIN')">
      <nav class="navbar navbar-expand-sm bg-light navbar-light">
          <!-- Brand -->
          <a class="navbar-brand" href="/">
              <img src="/resources/imgs/logo.jpg" alt="Logo" style="width:40px;">
          </a>

          <!-- Links -->
          <ul class="navbar-nav">
              <!-- Dropdown -->
              <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbardrop1" data-toggle="dropdown">
                      Data Config
                  </a>
                  <div class="dropdown-menu">
                      <a class="dropdown-item" href="/customers">Customers</a>
                      <a class="dropdown-item" href="/drivers">Drivers</a>
                      <a class="dropdown-item" href="/tankers">Tanker</a>
                  </div>
              </li>

              <%--<li class="nav-item dropdown">--%>

                  <%--<a class="nav-link dropdown-toggle" href="#" id="navbardrop2" data-toggle="dropdown">--%>
                      <%--Download--%>
                  <%--</a>--%>
                  <%--<div class="dropdown-menu">--%>
                      <%--<a class="dropdown-item" href="/Excel">EXCEL</a>--%>
                      <%--<a class="dropdown-item" href="/PDF">PDF</a>--%>
                  <%--</div>--%>
              <%--</li>--%>

              <srping:url value="/logout" var="logout" ></srping:url>
              <li class="nav-item">
                  <a class="nav-link" href="${logout}">Log Out</a>
              </li>
          </ul>
          <srping:url value="/download?type=xlsx" var="xlsUrl" ></srping:url>
          <%--<srping:url value="/download?type=pdf" var="pdfUrl"></srping:url>--%>
          <div class="btn-group">
              <button type="button" class="btn btn-primary">Download</button>
              <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown">
                  <span class="caret"></span>
              </button>
              <div class="dropdown-menu">
                  <a class="dropdown-item" href="${xlsUrl}">Excel</a>
                  <%--<a class="dropdown-item" href="${pdfUrl}">PDF</a>--%>
              </div>
          </div>
              <%----------------------------End Downoad ----------------------------------------------------%>

          <!-- Button to Open the Modal -->
          <button  type="button" class="btn btn-primary bouton-image monBouton" data-toggle="modal" data-target="#myModal">
              Booking
          </button>
      </nav>
<%---------------------------  Download ------------------------------------------------------------------------------------------------%>

     <strong>Booking</strong>
    <!-- The Modal -->
    <div class="modal fade" id="myModal">
        <div class="modal-dialog modal-lg" >
            <div class="modal-content" >

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Add New Customer</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form:form action="/saveUpdateBook" method="post" modelAttribute="book" class="form-group">
                  <div class="table-responsive">
                      <table class="table table-striped">
                        <tr>
                            <td>
                                <form:select path="customerName" cssClass="form-control">
                                    <form:option value="No Customer Name">Select Customer Name</form:option>
                                    <form:options items="${customersName}"></form:options>
                                </form:select>
                            </td>
                            <td>
                                <form:select path="driverName" cssClass="form-control">
                                    <form:option value="No Driver Name">Select Driver Name</form:option>
                                    <form:options items="${driversName}"></form:options>
                                </form:select>
                            </td>
                            <td>
                                <form:select path="customerAddress" cssClass="form-control">
                                    <form:option value="No Address">Select Customer Address</form:option>
                                    <form:options items="${customerAddresses}"></form:options>
                                </form:select>
                            </td>
                        </tr>
                  </table>
                 </div>
                                    <div class="table-responsive">
                                        <table class="table table-striped">
                         <tr>
                             <td>
                                 <form:label path="booking">Booking:</form:label>
                                 <form:input path="booking"  class="form-control" type="number" required="required" value="0"/>
                             </td>
                             <td>
                                 <form:label path="tripDone">Trip Done:</form:label>
                                 <form:input path="tripDone"  class="form-control" type="number" required="required" value="0" ></form:input>
                             </td>
                            <td>
                                <form:label path="tripMissing">Trip Missing:</form:label>
                                <form:input path="tripMissing"  class="form-control" type="number" required="required" value="0"></form:input>
                            </td>
                            <td>
                                <form:label path="tripCancel">Trip Cancel:</form:label>
                                <form:input path="tripCancel"  class="form-control" type="number" required="required" value="0"></form:input>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <form:label path="remark">Remark:</form:label>
                                <form:input path="remark" list="remarkD" class="form-control" type="text" required="required"/>
                                <datalist id= "remarkD">
                                    <c:forEach items="${remarks}" var="r">
                                        <option vlue="${r.remark}">${r.remark}</option>
                                    </c:forEach>
                                </datalist>
                            </td>
                            <td>
                                <form:label path="typeWater">Type Liquid:</form:label>
                                <form:input path="typeWater" list="typeWaterList" class="form-control" type="text" required="required"/>
                                <datalist id= "typeWaterList">
                                    <c:forEach items="${typeLiquids}" var="ty">
                                        <option vlue="${ty.typeLiquid}">${ty.typeLiquid}</option>
                                    </c:forEach>
                                </datalist>
                             </td>
                            <td>
                                <form:label path="sizeTanker">Size Tanker:</form:label>
                                <form:input path="sizeTanker" list="sizeTankerList" class="form-control" type="text" required="required"/>
                                <datalist id= "sizeTankerList">
                                    <c:forEach items="${sizeTankers}" var="si">
                                        <option vlue="${si.sizeTanker}">${si.sizeTanker}</option>
                                    </c:forEach>
                                </datalist>
                            </td>
                            <td>
                                <form:label path="numberTanker">Tanker Number:</form:label>
                                <form:input path="numberTanker" list="numberTankersList" class="form-control" type="text" required="required"/>
                                <datalist id= "numberTankersList">
                                    <c:forEach items="${numberTankers}" var="num">
                                        <option vlue="${num.numberTanker}">${num.numberTanker}</option>
                                    </c:forEach>
                                </datalist>

                            </td>
                        </tr>
                         <tr>
                            <td>

                            <form:label path="date">Date:</form:label>
                            <form:input type="date" path="date"  class="form-control"  ></form:input>
                            </td>
                         </tr>

                    </table>
                   </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-secondary monBoutonSave bouton-image" value="save" >Save</button>
                    <button type="button" class="btn btn-secondary bouton-image monBoutonDelete" data-dismiss="modal">Close</button>
                </div>
                </form:form>
            </div>
        </div>
    </div>



          <display:table name="${books}" id="bo" requestURI="/" pagesize="8" class="table table-bordered table-hover">
          <display:column property="driverName" title="Driver Name"></display:column>
          <display:column property="customerName" title="Customer Name"></display:column>
          <display:column property="customerAddress" title="Customer Address"></display:column>
          <display:column property="booking"  title="Booking" ></display:column>
          <display:column property="tripDone"  title="Trip Done" ></display:column>
          <display:column property="tripCancel"  title="Trip Cancel" ></display:column>
          <display:column property="tripMissing"  title="Trip Missing" ></display:column>
          <display:column property="remark"  title="Remark" ></display:column>
              <display:column property="numberTanker"  title="Tanker Number" ></display:column>
          <display:column property="typeWater"  title="Water Type" ></display:column>
          <display:column property="date"  title="Date" ></display:column>
              <display:column title="Update">
                  <c:set var="col_id" value="${bo.id}"/>
                  <a href="book/update/${col_id}" class="btn btn-secondary bouton-image monBoutonUpdate">Update</a>
              </display:column>
              <display:column title="Delete">
                  <c:set var="col_id" value="${bo.id}"/>
                   <a href="book/delete/${col_id}" class="btn btn-secondary bouton-image monBoutonDelete">Delete</a>
              </display:column>
          </display:table>
        </security:authorize>
</security:authorize>
</body>
</html>
