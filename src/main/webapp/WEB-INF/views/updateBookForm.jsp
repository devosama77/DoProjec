<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 17/1/2018
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
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
        .monBoutonNew:before{
            background-image : url(http://icons.iconarchive.com/icons/custom-icon-design/flatastic-10/16/New-file-icon.png);
        }
        .monBoutonDelete:before{
            background: url("http://icons.iconarchive.com/icons/hopstarter/sleek-xp-basic/16/Close-2-icon.png");
        }
        .monBoutonSave:before{
            background :url("http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-7/16/Save-icon.png")  ;
        }
        .monBoutonGoBack:before{
            background:url("http://icons.iconarchive.com/icons/custom-icon-design/flatastic-8/16/Go-back-icon.png");
        }
    </style>
</head>
<body>
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
                    <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                        Driver Orders
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/customers">Customers</a>
                        <a class="dropdown-item" href="/drivers">Drivers</a>
                        <a class="dropdown-item" href="/">Booking</a>
                    </div>
                        <srping:url value="/logout" var="logout" ></srping:url>
                <li class="nav-item">
                    <a class="nav-link" href="${logout}">Log Out</a>
                </li>
                </li>
            </ul>
        </nav>
    </security:authorize>
</security:authorize>

<div class="container">
    <div style="background-color: azure">
    <h4> >>>>>  Update (Booking Form)</h4>
<form:form action="/saveUpdateBook" method="post" modelAttribute="book" class="form-group">
        <div class="table-responsive">
            <table class="table table-striped">


    <tr>
        <td><form:hidden path="id" ></form:hidden></td>
        <td>
            <form:select path="customerName" cssClass="form-control">
               <form:option value="No Customer">Select Customer Name</form:option>
                <form:options items="${customersName}"></form:options>
            </form:select>
        </td>
        <td>
            <form:select path="customerAddress" cssClass="form-control">
                <form:option value="No Customer Address">Select Customer Address</form:option>
                <form:options items="${customerAddresses}"></form:options>
            </form:select>
        </td>
        <td>
            <form:select path="driverName" cssClass="form-control">
                <form:option value="No Driver">Select Driver Name</form:option>
                <form:options items="${driversName}"></form:options>
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="booking">Booking:</form:label>
            <form:input path="booking"  class="form-control" type="number" required="required"/>
        </td>
        <td>
            <form:label path="tripDone">Trip Done:</form:label>
            <form:input path="tripDone"  class="form-control" type="number" required="required"></form:input>
        </td>
        <td>
            <form:label path="tripMissing">Trip Missing:</form:label>
            <form:input path="tripMissing"  class="form-control" type="number" required="required"></form:input>
        </td>
        <td>
            <form:label path="tripCancel">Trip Cancel:</form:label>
            <form:input path="tripCancel"  class="form-control" type="number" required="required"></form:input>
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
     </tr>
     <tr>
         <td>
             <form:label path="numberTanker">Number Tanker:</form:label>
             <form:input path="numberTanker" list="numberTankersList" class="form-control" type="text" required="required"/>
             <datalist id= "numberTankersList">
                 <c:forEach items="${numberTankers}" var="num">
                     <option vlue="${num.numberTanker}">${num.numberTanker}</option>
                 </c:forEach>
             </datalist>

         </td>
         <td>
            <form:label path="date">Date:</form:label>
            <form:input type="date" path="date"  class="form-control" required="required"></form:input>
         </td>

    </tr>
    <tr>
        <td>
            <button type="submit" class="btn btn-secondary bouton-image monBoutonSave" value="Update" >Update</button>
        </td>
        <td>
          <a href="/"> <button class="btn btn-secondary bouton-image monBoutonGoBack" value="Go Booking" >Go Booking</button></a>
        </td>
    </tr>
</table>
        </div>
</form:form>
</div>
</div>
</body>
</html>
