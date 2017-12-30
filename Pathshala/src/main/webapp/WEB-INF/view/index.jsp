<%-- 
    Document   : index
    Created on : Dec 23, 2017, 10:40:42 AM
    Author     : Asif Ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- saved from url=(0077)https://d396qusza40orc.cloudfront.net/phoenixassets/web-frameworks/index.html -->
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE-edge">
   <meta name="viewport" content="width=device-width,initial-scale=1"> 
    <title>Pathshala</title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/bootsrap-theme.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/font-awesome.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/mystyles.css" rel="stylesheet">
     
     

</head>

<body>
  <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
         data-toggle="collapse" data-target="#navbar" aria-expanded="false"
         aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Pathshala</a>
          </div>
            <jsp:include page="include/menu.jsp"/>
     </div>
     
    </nav>
          
    <header class="jumbotron">

        <!-- Main component for a primary marketing message or call to action -->

        <div class="container">
            <div class="row row-header">
                <div class="col-xs-12 col-sm-8">
                    <h1>Pathshala</h1>
                    <p style="padding:40px;"></p>
                    <p></p>
                </div>
                <div class="col-xs-12 col-sm-4">
                </div>
            </div>
        </div>
    </header>

<div class="container">
        <div  class="row row-content">
             
                    <%-- Page Content Area --%>
                    <h1>User Login</h1>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
                     <c:if test="${param.action eq 'logout'}">
                        <p class="success">Successfully logout</p>
                    </c:if>
                        <c:if test="${param.action eq 'reg'}">
                        <p class="success">User Registered Successfully. Please login</p>
                    </c:if>  
                    <s:url var="url_login" value="/login"/>
                    <f:form action="${url_login}" modelAttribute="command">
                        <table border="1">
                            <tr>
                                <td>Username</td>
                                <td><f:input path="loginName"/></td>
                                
                            </tr>
                             <tr>
                                <td>
                                    Password
                                </td>
                                <td><f:password path="password"/></td>
                               
                            </tr>
                             <tr>
                                 <td colspan="2" align="right">
                                     <button>LogIn</button><br/>
                                    <a href="#">New user reg</a>
                                </td>
                              
                            </tr>
                        </table>
                    </f:form>
               
        </div>


       
    </div>


    <footer class="row-footer">
        <div class="container">
            <div class="row">             
                <div class="col-xs-5 col-xs-offset-1 col-sm-2 col-sm-offset-1">
                    <h5>Links</h5>
                    <ul class="list-unstyled">
                        <li><a href="https://d396qusza40orc.cloudfront.net/phoenixassets/web-frameworks/index.html#">Home</a></li>
                        <li><a href="https://d396qusza40orc.cloudfront.net/phoenixassets/web-frameworks/index.html#">About</a></li>
                        <li><a href="https://d396qusza40orc.cloudfront.net/phoenixassets/web-frameworks/index.html#">Menu</a></li>
                        <li><a href="https://d396qusza40orc.cloudfront.net/phoenixassets/web-frameworks/index.html#">Contact</a></li>
                    </ul>
                </div>
                <div class=" col-xs-6 col-sm-5 ">
                    <h5>Our Address</h5>
                    <address>
		              121, Clear Water Bay Road<br>
		              Clear Water Bay, Kowloon<br>
		              HONG KONG<br>
		              <i class="fa fa-phone"></i>: +852 1234 5678<br>
		              <i class="fa fa-fax"></i>: +852 8765 4321<br>
		              <i class="fa fa-envelope"></i>: <a href="mailto:confusion@food.net">confusion@food.net</a>
		            </address>
                </div>
                <div class=" col-xs-12 col-sm-4">
                    <div class="nav navbar-nav" style="padding: 40px 10px;">
                           <a class="btn btn-social-icon btn-google-plus" href="http://google.com/+"><i class="fa fa-google-plus"></i></a>
                        <a class="btn btn-social-icon btn-facebook" href="http://www.facebook.com/profile.php?id="><i class="fa fa-facebook"></i></a>
                        <a class="btn btn-social-icon btn-linkedin"  href="http://www.linkedin.com/in/"><i class="fa fa-linkedin"></i></a>
                        <a class="btn btn-social-icon btn-twitter" href="http://twitter.com/"><i class="fa fa-twitter"></i></a>
    <a class="btn btn-social-icon btn-youtube" href="http://youtube.com/"><i class="fa fa-youtube"></i></a>                        <a class="btn btn-social-icon" href="mailto:"><i class="fa fa-envelope-o"></i></a>
                    </div>
                </div>
                 <div class="col-xs-12">
                    <p style="padding:10px;"></p>
                    <p align="center">© Copyright 2015 Ristorante Con Fusion</p>
                </div>
            </div>
        </div>
    </footer>

</div>



   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>   
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    
    // <script>
    //     $(document).ready(function(){
    //     $('[data-toggle="tooltip"]').tooltip();
    //      });
    // </script>



</body>
</html>