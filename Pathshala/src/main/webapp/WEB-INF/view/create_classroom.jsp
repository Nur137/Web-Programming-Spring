

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
     <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/bootsrap-theme.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/font-awesome.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/mystyles.css" rel="stylesheet">
    
    <style>
       
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
        .nura{
            margin-top: 200px;
            margin-left: 400px;
        }
    </style>
    </head>
    <body>
  <nav  class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div backgroud="pic.png" class="container">
        <div align="center" class="pic">
<img src="<%=request.getContextPath()%>/static/images/cap.png" alt="Smiley face" height="42" width="42">
</div>

<div align="center">
<img src="<%=request.getContextPath()%>/static/images/line.png">
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
          </div>
            <jsp:include page="include/menu.jsp"/>
     </div>
     
    </nav>
     <div class="nura">
      
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
        <div class="container">
	<div class="row">
        <div class="col-md-6">
            <s:url var="url_reg" value="/user/dashboard/create_classroom/save"/>
            <f:form action="${url_reg}" modelAttribute="command">
            <fieldset><legend class="text-center">Valid information is required to register. <span class="req"><small> required *</small></span></legend>
                
             <div class="form-group">
            <label for="Course Name"><span class="req">* </span> Course Name: </label>
             
               <f:input path="classRoom.course_name" id="course_name" class="form-control"/>
            </div>
            <div class="form-group">
            <label for="Course No"><span class="req">* </span> Course No: </label>
             
               <f:input path="classRoom.course_no" id="course_no" class="form-control phone"/>
            </div>


            <div class="form-group">
                <f:hidden path="classRoom.instructor" id="instructor" value="${sessionScope.userId}" class="form-control"/>
             
                <div class="status" id="status"></div>
            </div>
            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit_reg" value="Register">
            </div>
            </fieldset>
            </f:form><!-- ends register form -->


        </div><!-- ends col-6 -->
   
        </div>
	</div>
</div>
    </body>
</html>
