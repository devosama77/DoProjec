<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16/1/2018
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custoemrs</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
    <style>
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
        .monBoutonSave:before {
            background: url("http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-7/16/Save-icon.png");
        }
    </style>
</head>

<body>

        <security:authorize access="isAuthenticated()">
    <security:authorize access="hasAnyRole('USER','ADMIN')">
        Welcome !  <security:authentication property="principal.username"/>
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
                        Data Config
                    </a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item" href="/drivers">Drivers</a>
                        <a class="dropdown-item" href="/tankers">Tanker</a>
                        <a class="dropdown-item" href="/">Booking</a>
                    </div>
                        <srping:url value="/logout" var="logout" ></srping:url>

                 </li>
                    <a class="nav-link" href="${logout}">Log Out</a>
                </li>
                </li>
            </ul>
            <!-- Button to Open the Modal -->
            <button type="button" class="btn btn-primary bouton-image monBouton" data-toggle="modal" data-target="#myModal">
              Customer
            </button>
        </nav>


        <strong>Customers</strong>
            <!-- The Modal -->
            <div class="modal fade" id="myModal">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">

                        <!-- Modal Header -->
                        <div class="modal-header">
                            <h4 class="modal-title">Modal Heading</h4>
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                        </div>

                        <!-- Modal body -->
                        <div class="modal-body">
                            <form:form action="/saveUpdateCustomer" method="post" modelAttribute="customer" class="form-group">
                            <form:label path="customerName">Customer Name:</form:label>
                            <form:input path="customerName"  class="form-control" required="required"/>

                            <form:label path="address">Address:</form:label>
                            <form:input path="address"  class="form-control" required="required"></form:input>

                            <form:label path="comments">Comment:</form:label>
                            <form:input path="comments"  class="form-control" ></form:input>
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
        <display:table name="${customers}" id="cu" requestURI="/customers" pagesize="8" class="table table-bordered table-hover">
            <display:column property="customerName" title="Customer Name"></display:column>
            <display:column property="address"  title="address" ></display:column>
            <display:column property="comments"  title="comments" ></display:column>
            <display:column title="Update">
                <c:set var="col_id" value="${cu.id}"/>
                <a href="customer/update/${col_id}" class="btn btn-secondary bouton-image monBoutonUpdate">Update</a>
            </display:column>
            <display:column title="Delete">
                <c:set var="col_id" value="${cu.id}"/>
                <a href="customer/delete/${col_id}" class="btn btn-secondary bouton-image monBoutonDelete">Delete</a>
            </display:column>
        </display:table>
    </security:authorize>
</security:authorize>
</body>
</html>
