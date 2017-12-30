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
    <title>Ristorante Con Fusion</title>
    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/bootsrap-theme.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/font-awesome.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/mystyles.css" rel="stylesheet">
     

</head>

<body>
  <nav  class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div backgroud="pic.png" class="container">
        <div align="center" class="pic">
<img src="cap.png" alt="Smiley face" height="42" width="42">
</div>

<div align="center">
<img src="line.png">
</div>
        <div align="center">
    <font size="5" color="black">Pathshala</font>
</div>
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed"
         data-toggle="collapse" data-target="#navbar" aria-expanded="false"
         aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Ristorante ConFusion</a>
          </div>
            <jsp:include page="include/menu.jsp"/>
     </div>
     
    </nav>
          
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