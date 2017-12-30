

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User registration</title>
       <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/bootsrap-theme.min.css" rel="stylesheet">
    <link href="static/css/font-awesome.min.css" rel="stylesheet">
    <link href="static/css/mystyles.css" rel="stylesheet">
    
    <style>
        body {
            padding-top:50px;
        }
        fieldset {
            border: thin solid #ccc; 
             border-radius: 4px;
              padding: 20px;
             padding-left: 40px;
            background: #fbfbfb;
}
        legend {
            color: #678;
        }
        .form-control {
          width: 95%;
        }
        label small {
         color: #678 !important;
        }
        span.req {
             color:maroon;
            font-size: 112%;
        }
    </style>
    </head>
    <body>
         <h1>User Registration</h1>
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
        <div class="container">
	<div class="row">
        <div class="col-md-6">
            <s:url var="url_reg" value="/register"/>
            <f:form action="${url_reg}" modelAttribute="command">
            <fieldset><legend class="text-center">Valid information is required to register. <span class="req"><small> required *</small></span></legend>
                
             <div class="form-group">
            <label for="name"><span class="req">* </span> Name: </label>
             
               <f:input path="user.name" id="name" class="form-control"/>
            </div>
            <div class="form-group">
            <label for="phonenumber"><span class="req">* </span> Phone Number: </label>
             
               <f:input path="user.phone" id="phone" class="form-control phone"/>
            </div>


            <div class="form-group">
                <label for="email"><span class="req">* </span> Email Address: </label> 
                 <f:input path="user.email" id="email" class="form-control"/>
             
                <div class="status" id="status"></div>
            </div>
             <div class="form-group">
            <label for="address"><span class="req">* </span> Address: </label>
             
               <f:input path="user.address" id="address" class="form-control"/>
            </div>     
             

            <div class="form-group">
                <label for="username"><span class="req">* </span> User name:  <small>This will be your login user name</small> </label> 
                   <f:input path="user.loginName" id="username" class="form-control"/>
         
                <div id="errLast"></div>
            </div>

            <div class="form-group">
                <label for="password"><span class="req">* </span> Password: </label>
                   <f:password path="user.password" class="form-control inputpass" />
             </div>



            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit_reg" value="Register">
            </div>
            </fieldset>
            </f:form><!-- ends register form -->


        </div><!-- ends col-6 -->
   

	</div>
</div>
    </body>
</html>
