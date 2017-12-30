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
    position: fixed;
    top: 235px;
    left: 60px;
    right:650px;
    
            }
                        .pp2{
    position: fixed;
    top: 235px;
    right: 60px;
    left:700px;
    
            }
            .nura{
                margin-top: 190px;
            }
            .fi {
    position: fixed;
    top: 190px;
    left: 680px;
    
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
     ${st}  ${id}
          <div class="nura">
      
                    <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
        <div class="container">
	<div class="row">
        <div class="col-md-6">
            <!--
            <s:url var="url_reg" value="/user/dashboard/create_classroom/save"/>
            <form action="${url_reg}">
            <fieldset>
                

            <div class="form-group">
            <label for="Course No"><span class="req">* </span> Type Your Comment: </label>
             
               <input name="classRoom.course_no" id="course_no" class="form-control phone"/>
            </div>


            <div class="form-group">
                
                <div class="status" id="status"></div>
            </div>
            <div class="form-group">
                <input class="btn btn-success" type="submit" name="submit_reg" value="Submit">
            </div>
            </fieldset>
            </form><!-- ends register form -->
               -->
               
               
                <spring:url var="url_add" value="/user/dashboard/DISC"/>
            <form action="${url_add}">
        
            
             <input type="text" name="student" placeholder="Student Name"/>
             <input type="hidden" name="u_id" value="${id}">
             <input type="submit" value="Add" />
            
            
            </form>


        </div><!-- ends col-6 -->
   
        </div>
	</div>
     
            
            <div class="fi">
                
                                   <c:if test="${err!=null}">
                        <p class="error">${err}</p>
                    </c:if>
        <div class="container">
	<div class="row">
        <div class="col-md-6">
            <spring:url var="url_add" value="/user/dashboard/addStudent"/>
            <form action="${url_add}">
                <!--
            <div class="form-group">
            <label for="Course No"><span class="req">* </span> Student ID: </label>
                 <input type="hidden" name="u_id" value="${id}">
               <input name="student" id="course_no" class="form-control phone"/>
            </div>

             <input type="hidden" name="u_id" value="${id}">
            
            <div class="form-group">
                
                <div class="status" id="status"></div>
            </div>
            <div class="form-group">
                <input class="btn btn-success" type="submit" value="Add" />
            </div>
            -->
            
             <input type="text" name="student" placeholder="Student Name"/>
             <input type="hidden" name="u_id" value="${id}">
             <input type="submit" value="Add" />
            
            
            </form>


        </div><!-- ends col-6 -->
   
        </div>

</div>
     
     <div class="pp">
     <div class="row-content">
        <h1>${msg}</h1>
        <div class="passwordShowDiv" id="showPwdDiv" >  </div>
       
        
        <table class="table">
 
    <tbody>
         
       
                
                
    </tbody>
        </table>
     </div>
     </div>
        <div class="pp2">
     <div class="row-content">
        <h1>${msg}</h1>
        <div class="passwordShowDiv" id="showPwdDiv" >  </div>
        <table class="table">
 
    <tbody>
            <tr>
                    <td>Members</td>
                </tr>
                
                <c:forEach items="${students}" var="sts" varStatus="st" >
                    
                    
                <tr class="info" >
                    <td>${sts.student_name}</td>
                                       
                </tr>
                
            </c:forEach>
    </tbody>
        </table>
     </div>
     </div>
    </body>
</html>