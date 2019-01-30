<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16/1/2018
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdateDriver</title>
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

<div class="container" style="background-color: azure">
    <h4> >>>>> Driver (Update Form)</h4>
<form:form action="/saveUpdateDriver" method="post" modelAttribute="driver" class="form-group">
    <div class="table-responsive">
        <table class="table table-striped">
   <tr>
       <td><form:hidden path="id"></form:hidden></td>
       <td><form:label path="driverName" >First Name:</form:label>
       <form:input path="driverName"  class="form-control" required="required" type="text"/>
       </td>
          <td>
            <form:label path="lorryNumber" >Lorry Number:</form:label>
            <form:input path="lorryNumber"  class="form-control" required="required" type="text" ></form:input>
            </td>
            <td>
                <button type="submit" class="btn btn-secondary bouton-image monBoutonSave" value="Update" >Update</button>
            </td>
            <td>
                <a href="/drivers"> <button class="btn btn-secondary bouton-image monBoutonGoBack" value="Go Drivers" >Go Drivers</button></a>
            </td>
    </tr>
    </table>
    </div>
</form:form>
</div>
</body>
</html>
