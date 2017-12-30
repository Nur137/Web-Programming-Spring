<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>

<s:url var="url_logout" value="/logout"/>

<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE-edge">
   <meta name="viewport" content="width=device-width,initial-scale=1"> 
   <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/static/css/bootsrap-theme.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/font-awesome.min.css" rel="stylesheet">
    <link href ="<%=request.getContextPath()%>/static/css/mystyles.css" rel="stylesheet">
     
     

</head>

 <c:if test="${sessionScope.userId == null}">
     <s:url var="url_reg_form" value="/reg_form"/>
          <div id="navbar" class="navbar-collapse collapse">
           
           <ul class="nav navbar-nav">
          <li class="active"><a href="#index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>
          Home</a></li>
          <li><a href="aboutus.html">About</a></li>
          <li><a href="#">Contact</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
             <s:url var="url_reg_form" value="/reg_form"/>
             <li><a  href="${url_reg_form}"><span class="glyphicon glyphicon-user"></span>Sign In</a></li>
           <li><a href="${url_reg_form}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li> 
        </ul>
        </div>
     </c:if>
        
     <c:if test="${sessionScope.userId != null && sessionScope.role==1}">
    <div id="navbar" class="navbar-collapse collapse">
           
           <ul class="nav navbar-nav">
          <li class="active"><a href="#index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>
          Home</a></li>
          <li><a href="#">Contact</a></li>
           <li><a href="#">User List</a></li>          <li><a href="aboutus.html">About</a></li>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <s:url var="url_logout" value="/logout"/>
            <li><a ><span class="glyphicon glyphicon-user"></span> ${sessionScope.loginName}</a></li>
           <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li> 
        </ul>
        </div>
    </c:if>
        
    <c:if test="${sessionScope.userId != null && sessionScope.role==2}">
    
         <div id="navbar" class="navbar-collapse collapse">
           
           <ul class="nav navbar-nav">
               <s:url var="url_home" value="/user/dashboard"/>
               
               <li><a href="${url_home}">
                       Home</a></li>
          <s:url var="url_create_class" value="/user/dashboard/create_classroom"/>
           <li><a href=${url_create_class}>Create Class</a></li>
          
           <s:url var="url_view_class" value="/user/dashboard/myClassList"/>
           <li><a href=${url_view_class}>My Classes</a></li>
            <s:url var="url_view_class" value="/user/dashboard/classList"/>
           <li><a href=${url_view_class}>Enrolled Classes</a></li>
       
           </ul>
        <ul class="nav navbar-nav navbar-right">
            <s:url var="url_logout" value="/logout"/>
           <li><a ><span class="glyphicon glyphicon-user"></span> ${sessionScope.loginName}</a></li>
           <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li> 
        </ul>
        </div>
    </c:if>
    