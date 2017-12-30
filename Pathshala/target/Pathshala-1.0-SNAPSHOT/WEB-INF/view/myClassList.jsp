<%-- 
    Document   : userlist
    Created on : Aug 10, 2016, 10:11:17 PM
    Author     : irfan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        
       
        
        
        
        <script type="text/javascript" src="<%=request.getContextPath()%>/resource/jquery.min.js" ></script>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/bootsrap-theme.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/font-awesome.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/mystyles.css" rel="stylesheet">
        <script>
            
            
            

            function showPassword(userId) {
                $.post('<spring:url value="/getPassword" />', {userId: userId}, function(data) {
                    if (data != null && data != '') {
//                        alert("MESSAGE:\nYour password is " + data);
                        $('#showPwdDiv').html(data);
                        $('#showPwdDiv').fadeIn(500).delay(500).fadeOut(1000);
//                        $('#showPwdDiv').fadeOut(500);
                    } else {
                        alert("ERROR:\nFailed to fetch password.");
                    }
                });
            }
        </script>
        <style>
            .passwordShowDiv{
                background-color: black;
                width: 261px;
                margin: auto;
                min-height: 80px;
                color: white;
                font-size: 20px;
                position: absolute;
                text-align: center;
                line-height: 71px;
                white-space: nowrap;
                display: none;
                left: 39%;
                top: 40%;
            }
            .pp{
                margin-top: 220px;
                margin-left: 200px;
                margin-right: 200px;
            }
        </style>
        
        
    </head>
    <body bgcolor="pink">
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
     <div class="pp">
     <div class="row-content">
        <h1>${msg}</h1>
        <div class="passwordShowDiv" id="showPwdDiv" >  </div>
        <table class="table">
          <thead>
      <tr>
        <th>SL No.</th>
        <th>Course No.</th>
        <th>Course Name</th>
      </tr>
    </thead> 
    <tbody>
         
       
                
                <c:forEach items="${classes}" var="clss" varStatus="st" >
                    
                    
                <tr class="info" data-href="<spring:url value="/user/dashboard/editClassList"/>?courseNo=${clss.course_no}&courseName=${clss.course_name}&id=${clss.id}">
                    <td>${st.count}</td>
                    
                    
                    
                    <td>${clss.course_no}</td>
                    <td>${clss.course_name}</td>                    
                    <td>
                         <a href="<spring:url value="/user/dashboard/editClassList"/>?courseNo=${clss.course_no}&courseName=${clss.course_name}&id=${clss.id}">See Details</a>
                    </td>
                </tr>
                
            </c:forEach>
    </tbody>
        </table>
     </div>
     </div>
    </body>
</html>