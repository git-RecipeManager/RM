<%@ page language="java" contentType="text/html; charset=utf-8/>"
    pageEncoding="utf-8" import="com.extraordinary.italy.model.LoginBean" %>
   <%
		String name = "";
  		String surname = "";
  		String role = "";
  		String maskDescription= "Seleziona una maschera di inserimento dal menu dashboard";
		if (session != null) {
			if ((session.getAttribute("securedBean") != null) && (session.getAttribute("prompt") != null)) {
				LoginBean sb = (LoginBean) session.getAttribute("securedBean");
		 		surname = sb.getSurname();
		 		name = sb.getName();
				 role = sb.getRole();
			} else {
				response.sendRedirect("/extraordinary-italy.com/Secured");
			}
		}
	
		// dash view parameter check
		if(request.getAttribute("dash_view") == null){
			request.setAttribute("dash_view", "");
		}
		if(request.getAttribute("maskDescription") != null){
			maskDescription = (String)request.getAttribute("maskDescription");
		}
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>DASHBOARD EXTRAORDINARYITALY:COM</title>
        <script src="http://localhost:8080/extraordinary-italy.com//jquery/jquery-3.3.1.js"></script>

<link rel="stylesheet" href="http://localhost:8080/extraordinary-italy.com/css/bootstrap.css">
    <link rel="stylesheet" href="http://localhost:8080/extraordinary-italy.com/css/all.css">
    <link rel="stylesheet" href="http://localhost:8080/extraordinary-italy.com/css/secured-backend.css">
</head>
<body>
<div class="page-wrapper  toggled">
        <nav id="sidebar" class="sidebar-wrapper">
            <div class="sidebar-content">
                <div class=" row sidebar-brand">
                	<div class="col-sm-10">
                	   <a href="http://localhost:8080/extraordinary-italy.com">extraordinary-italy.com</a>
                	</div>
                	<div class="col-sm-2">
                		<a href="/extraordinary-italy.com/BackLogout">
                    			 <i class="fa fa-power-off">&nbsp;Logout </i>
               		    </a>
                	</div>
                </div>
                <div class="sidebar-header">
                    <div class="user-pic">
                        <img class="img-responsive img-rounded" src="/extraordinary-italy.com/image/boy.png" alt="User picture">
                    </div>
                    <div class="user-info">
                        <span class="user-name"><%= name %>
                            <strong><%= surname %></strong>
                        </span>
                        <span class="user-role"><%= role %></span>
                        <span class="user-status">
                            <i class="fa fa-circle"></i>
                            <span>Online</span>
                        </span>
                    </div>
                </div>
                <!-- sidebar-header  -->
                
                <div class="sidebar-menu">
                    <ul>
                        <li class="header-menu">
                            <span>General</span>
                        </li>
                        <li class="sidebar-dropdown">
                            <a href="#">
                                <i class="fa fa-tachometer-alt"></i>
                                <span>Dashboard</span>
                                <span class="badge badge-pill badge-danger">New</span>
                            </a>
                            <div class="sidebar-submenu">
                                <ul>
                                     <li>
                                        <a href="DashManagmentServlet?dashboard=add_category">Aggiungi Categoria</a>
                                    </li>
                                    <li>
                                        <a href="DashManagmentServlet?dashboard=add_product">Aggiungi Prodotto</a>
                                    </li>
                                    <li>
                                        <a href="WEB-INF/dashboard/backend.jsp?dashboard=add_order">Aggiungi Ordine</a>
                                    </li>
                                </ul>
                            </div>
                        </li>
                        
                        
                    </ul>
                </div>
                <!-- sidebar-menu  -->
            </div>
            >
            <!-- sidebar-content-logout  -->
            <div class="sidebar-footer">
                
            </div>
            <!-- end sidebar-content-logout  -->
        </nav>
        <!-- PAGE CONTENT  -->
        <section class="page-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="form-group col-md-12">
                        <h1 style="color:#03A696; font-weight:bold;" >Pannello Amministrativo</h1>
                        <h4 class="fg-light-grey"><%= maskDescription %></h4>
                        <div id="categoryMessageContainer">
                        </div>
                    </div>
                </div>
  
                <hr>
                <div class="row">
                    <div class="form-group col-md-12">                
                       <%= request.getAttribute("dash_view") %>      
                    </div>
                </div>
            </div>
   		 </section>
    	 <!-- END PAGE CONTENT  -->
   
    </div>
        <script>
        // script per gestire l'effeto slide della voce dashBoard
        jQuery(function ($) {

            $(".sidebar-dropdown > a").click(function () {
                $(".sidebar-submenu").slideUp(200);
                if ($(this).parent().hasClass("active")) {
                    $(".sidebar-dropdown").removeClass("active");
                    $(this).parent().removeClass("active");
                } else {
                    $(".sidebar-dropdown").removeClass("active");
                    $(this).next(".sidebar-submenu").slideDown(200);
                    $(this).parent().addClass("active");
                }

            });

            $("#toggle-sidebar").click(function () {
                $(".page-wrapper").toggleClass("toggled");
            });    
            
        });
    
        </script>
    
</body>
</html>