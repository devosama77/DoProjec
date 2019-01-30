<%@ taglib prefix="srping" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        table {
            float:left;
            width:33%;
            cellspacing:"10";
            cellPadding:"10";
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
                        <a class="dropdown-item" href="/customers">Customers</a>
                    </div>

                    <srping:url value="/logout" var="logout" ></srping:url>
                </li>
                <a class="nav-link" href="/">Booking</a>
                <a class="nav-link" href="${logout}">Log Out</a>
                </li>
                </li>
            </ul>
        </nav>
        <div class="container">
            <div class="row">
            <%----------------------------------Liquid Type ----------------------------------------%>
                <div class="col-sm-4">
                    <div class="table-responsive">
                        <table class="table table-striped">
        <%--<table style="border-right: 2px solid black">--%>
            <tr>
                <td>
                    <!-- Button to Open the Modal -->
                    <button type="button" class="btn btn-primary bouton-image monBouton" data-toggle="modal" data-target="#typeLiquid">
                       Type Liquid
                    </button>
                    <!-- The Modal -->
                    <div class="modal fade" id="typeLiquid">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Type of Liquid Industry</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>

                                <!-- Modal body -->
                                <div class="modal-body">
                                    <form:form action="/saveLiquidType" method="post" modelAttribute="typeLiquid" class="form-group">
                                    <form:label path="typeLiquid">type Liquid:</form:label>
                                    <form:input path="typeLiquid"  class="form-control" required="required" type="text" />

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
                </td>
            </tr>
            <tr>
                <td><strong>Types OF Liquid</strong></td>
            </tr>
            <c:forEach items="${typeLiquids}" var="ty">
                <tr>
                    <td>${ty.typeLiquid}</td>

                    <td> <spring:url value="typeLiquid/delete/${ty.id}" var="deleteUrl"></spring:url>
                        <a href="${deleteUrl}" class="btn btn-secondary bouton-image monBoutonDelete">Delete</a></td>
                </tr>
            </c:forEach>
        </table >
     </div>
</div>
            <%--------------------------------------------------------------Size Tanker------------------------------%>
                <div class="col-sm-4">
                    <div class="table-responsive">
                        <table class="table table-striped">

            <%--<table style="border-right:2px solid black">--%>
                <tr>
                    <td>
                        <!-- Button to Open the Modal -->
                        <button type="button" class="btn btn-primary bouton-image monBouton" data-toggle="modal" data-target="#sizeTanker">
                           Size Tanker
                        </button>
                        <!-- The Modal -->
                        <div class="modal fade" id="sizeTanker">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Size Tanker</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <form:form action="/saveSizeTanker" method="post" modelAttribute="sizeTanker" class="form-group">
                                        <form:label path="sizeTanker">Size Tanker:</form:label>
                                        <form:input path="sizeTanker"  class="form-control" required="required" type="text"/>
                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-secondary" value="save" >Save</button>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><strong>sizes tanker</strong></td>
                 </tr>
                <c:forEach items="${sizeTankers}" var="sizeT">
                <tr>
                    <td>${sizeT.sizeTanker}</td>
                    <td> <spring:url value="sizeTanker/delete/${sizeT.id}" var="deleteUrl"></spring:url>
                        <a href="${deleteUrl}" class="btn btn-secondary bouton-image monBoutonDelete">Delete</a></td>
                </tr>
                </c:forEach>
            </table>
      </div>
   </div>
                <%--------------------------------------------------Remarks ---------------------%>
                <div class="col-sm-4">
                    <div class="table-responsive">
                        <table class="table table-striped">
            <%--<table style="border-right: 2px solid black">--%>
                <tr>
                    <td>
                        <button type="button" class="btn btn-primary monBouton bouton-image" data-toggle="modal" data-target="#remark">
                             Remark
                        </button>
                        <!-- The Modal -->
                        <div class="modal fade" id="remark">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">

                                    <!-- Modal Header -->
                                    <div class="modal-header">
                                        <h4 class="modal-title">Remark</h4>
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    </div>

                                    <!-- Modal body -->
                                    <div class="modal-body">
                                        <form:form action="/saveRemark" method="post" modelAttribute="remark" class="form-group">
                                        <form:label path="remark">Remark:</form:label>
                                        <form:input path="remark"  class="form-control" required="required" type="text"/>
                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-secondary" value="save" >Save</button>
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td><strong>Remarks</strong></td>
                </tr>
                <c:forEach items="${remarks}" var="re">
                <tr>
                    <td>${re.remark}</td>
                    <td> <spring:url value="remark/delete/${re.id}" var="deleteUrl"></spring:url>
                        <a href="${deleteUrl}" class="btn btn-secondary bouton-image monBoutonDelete">Delete</a></td>
                </tr>
                </c:forEach>
            </table>
         </div>
     </div>
</div>
    <%--Taneker Numbor ................................--%>
<div class="row">
       <div class="col-sm-4">
              <div class="table-responsive">
                   <table class="table table-striped">
                                <%--<table style="border-right: 2px solid black">--%>
                       <tr>
                           <td>
                               <button type="button" class="btn btn-primary monBouton bouton-image" data-toggle="modal" data-target="#numberTanker">
                                        Number Tanker
                                  </button>
                                    <!-- The Modal -->
                                    <div class="modal fade" id="numberTanker">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">

                                                <!-- Modal Header -->
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Number Tanker</h4>
                                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                                </div>

                                                <!-- Modal body -->
                                                <div class="modal-body">
                                                    <form:form action="/saveNumberTanker" method="post" modelAttribute="numberTanker" class="form-group">
                                                    <form:label path="numberTanker">Number Tanker:</form:label>
                                                    <form:input path="numberTanker"  class="form-control" required="required" type="text"/>
                                                </div>

                                                <!-- Modal footer -->
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-secondary" value="save" >Save</button>
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                </div>
                                                </form:form>
                                            </div>
                                        </div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><strong>Number Tanker</strong></td>
                            </tr>
                            <c:forEach items="${numberTankers}" var="numb">
                                <tr>
                                    <td>${numb.numberTanker}</td>
                                    <td> <spring:url value="numberTanker/delete/${numb.id}" var="deleteUrl"></spring:url>
                                        <a href="${deleteUrl}" class="btn btn-secondary bouton-image monBoutonDelete">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
</div>
    </security:authorize>
</security:authorize>
</body>
</html>
