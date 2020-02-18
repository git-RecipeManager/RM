<%@ page language="java" contentType="text/html; charset=utf-8/>"
    pageEncoding="utf-8" import="com.manager.recipe.model.LoginBean" session="true" %>
<%
Integer idUser = 0;
String email = "";
	String fullName = "";
	String sms = "";
	String cel ="";
	String username="";
	String indirizzo = "";
	Integer role = 1;

Boolean flag = false;	
if ((session.getAttribute("customerBean") != null)) {
		LoginBean cb = (LoginBean) session.getAttribute("customerBean");
 		idUser = cb.getIdUser();
		email = cb.getEmail();
 		fullName = cb.getFullName();
 		username=cb.getUsername();
 		cel = cb.getCellulare();
 		indirizzo = cb.getIndirizzo();
 		role = cb.getRole();		 					 		
	}			

if(session.getAttribute("message") != null)
	sms = (String)session.getAttribute("message");
   %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!--  Dice ai browswe di impostare il viewport ovvero la finestra del browser alle stesse dimensioni del device -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Disabilita il riconoscimentoautomatico da parte dei browser dei numeri di telefono che non Ã¨ standardizzato useremo invece html5 -->
	<meta name="format-detection" content="telephone=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/custom.css">
    
   	<title>Recipe Manager</title>
  </head>
  <body>
  <p id="messageBar" style=" text-align:center; ;position:relative; width:100%; height:2em; display:none" class=" bg-sea-green fg.light-grey"><%= sms %></p>
    <!-- MENU ALTO -->
	<nav class="navbar navbar-expand-sm" id="navbar-nav-1">  
	  <!--  sx  Campo di ricerca, telefono, spedizioni gratis -->
	  <ul class="navbar-nav">
		  <li>
			  	 <form class="form-inline" action="/action_page.php">	
					    <input class="form-control mr-sm-2" type="text" placeholder="Search">
					    <button class="btn btn-success" type="submit"><i class="fas fa-search"></i></button>
				</form>
		  </li>
	      <li class="nav-item"><a class="nav-link" href="tel:+393518282721"><i class="fas fa-phone"></i> +39 351 8282721</a></li>
	      <li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-shipping-fast"></i> Gratis</a></li>
	 </ul>
	 <!--  DX    btn modal login or user dropdown setting/area/profile , btn shopping cart -->
	 <ul class="navbar-nav">
		 <li class="nav-item">
		 	<div style="display:inline-block;" class="dropdown">
				 <a style="display:none" class="nav-link dropdown-toggle"  id="dropdownMenuUserSetting" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   				    <i class="fas fa-user-cog fa-2x"></i>
  				 </a>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenuUserSetting">
				    <a class="dropdown-item" href="profile.jsp">Profilo</a>
				    <a class="dropdown-item" href="add_recipe.jsp">Aggiungi Ricetta</a>
				    <a class="dropdown-item" href="LogoutServlet">Logout</a>
				  </div>
			 </div>
		</li>
		<li class="nav-item">
			<a href="#" id="btnUserLock" class="nav-link" data-toggle="modal" data-target="#loginModal"><i class="fas fa-user-lock fa-2x"></i></a>
		</li>
		</ul>	
		
	
		<!-- Sub menu login Modal -->
<div id="loginModal" class="modal fade" role="dialog">
  <div class="modal-dialog modal-lg">
    <!-- Modal content-->
    <div class="modal-content">
      	<div class="modal-header">
        	<button type="button" class="close" data-dismiss="modal"><i class="fas fa-times-circle"></i></button>
      	</div>
      	<div class="modal-body">
        	<div class="login-container container">
               <div class="row">
                	<div class="col-md-6 login-form-1">
                    	<h3>Accedi</h3>
                    	<form   action="LoginServlet"  method="POST" name="loginForm" id="loginForm" enctype="application/x-www-form-urlencoded">
	                        <div class="form-group">
	                            <input type="hidden" class="form-control"  name="role" value="customer" />
	                        </div>
	                        <div class="form-group">
	                            <input type="text" class="form-control" placeholder="La tua Email o Username" name="user" value="" />
	                        </div>
	                        <div class="form-group">
	                            <input type="password" class="form-control" placeholder="La tua Password" name="password" value="" />
	                        </div>
	                        <div class="form-group">
	                            <input type="submit" class="btnSubmit" name="btnLogin" id="btnModalLogin" value="Login" />
	                        </div>
	                        <div class="form-group ">
	                        	<a href="#" class="ForgetPwd">Password Dimenticata?</a>
	                        </div>
	                         <div class="form-group ">
	                        	<label class="form-check-label"> &nbsp; Ricordami 
    							<input type="checkbox" class="form-check-input" name="optradio"> 
 								 </label>
	                        </div>
                    	</form>
                     </div>
                <div class="col-md-6 login-form-2">
                    <h3>Registrati</h3>
                    <form action="RegistrationServlet" method="POST" id="registrationForm" enctype="application/x-www-form-urlencoded">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Inserisci un Username" name="username" value="" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Inserisci una Mail" name="email" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" id="registrationPassword" class="form-control" placeholder="Inserisci una Password" name="password" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Re-Inserisci Password" name="password2" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Registrati" />
                        </div>
                    </form>
                </div>
            </div>
       	    </div>
		</div>
    </div>
  </div>
</div><!--  End sub menu login modal -->
<!-- ************************************* END MENU ALTO  *****************************************   -->
	
	<!--MENU ALTO 2-->
	</nav>
	<nav class="navbar navbar-dark  navbar-expand-md bg-wine">	
	 <div class="container">
  <a class="navbar-brand" href="index.jsp">RecipeManager.com</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbar">
   <ul class="navbar-nav mr-auto">
    <li class="nav-item  megamenu-li"><a class="nav-link" href="#">Migliori piatti</a></li>
    <li class="nav-item  megamenu-li"><a class="nav-link"href="#">Nuovi piatti</a></li>
    <li class="nav-item  megamenu-li"><a class="nav-link" href="#">Antichi piatti</a></li>
    <li class="nav-item  megamenu-li"><a class="nav-link" href="#">I piatti piu commentati</a></li>
   </ul>
  </div>
 </div>
	</nav>








	
<% 

// main view parameter check
if(request.getAttribute("main") == null){
	request.setAttribute("main", "");
}
/*<div class="col-sm-3"><!--left col-->         
		     <div class="text-center">
		        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
		        <h6>Upload a different photo...</h6>
		        <input type="file" class="text-center center-block file-upload">
		      </div>
     	</div><!--/col-3-->*/
%>
<%= request.getAttribute("main") %>







<hr>
<div class="container bootstrap snippet">
    <div class="row">
    	<div class="col-sm-9">    
          <div class="tab-content">
            <div class="tab-pane active" id="home">
                <hr>
                  <form class="form" action="ProfileServlet"  method="post" id="registrationForm">
                      <div class="form-group">
                          <input type="hidden" name="idUtente" value=<%=idUser%>>
                          <div class="col-xs-6">
                              <label class="fg-sea-green" for="first_name"><h4>Nome e Cognome</h4></label>
                              <input type="text"  required pattern="^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$" class="form-control" name="fullName" id="fullName" value="<%= fullName %>" >
                          </div>
                      </div>
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label class="fg-sea-green" for="email"><h4>Email</h4></label>
							 <input type="email" required class="form-control" name="email" id="email" value="<%=email%>" readonly>  </div>
                      </div>
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label class="fg-sea-green" required pattern"^[a-zA-Z][a-zA-Z0-9-_\.]{1,20}$" for="username"><h4>Username</h4></label>
							 <input type="text" class="form-control" name="username" id="username" value="<%=username%>" readonly>          </div>
                      </div>
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label class="fg-sea-green" for="cell"><h4>Cellulare</h4></label>
							 <input type="tel" required  pattern="^[0-9\-\+]{9,15}$" class="form-control" name="cellulare" id="cellulare" value="<%=cel%>">                          </div>
                      </div>
                     
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label class="fg-sea-green" for="indirizzo"><h4>Indirizzo</h4></label>
                              <input type="text" required pattern="[A-Za-z0-9'\.\-\s\,][10,50]"class="form-control" id="indirizzo" name="indirizzo" value="<%=indirizzo %>">
                          </div>
                      </div>
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label class="fg-sea-green" required  patterrn"(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$
                             "for="password"><h4>Nuova Password</h4></label>
							 <input type="password" class="form-control" name="password" id="password" value="" >                          </div>
                      </div>
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label class="fg-sea-green" required pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$
                             " for="password2"><h4>Ripeti Password</h4></label>
							 <input type="password" class="form-control" name="password2" id="password2" value="">                          </div>
                      </div>
                      <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button style="color:white;" class="btn btn-lg bg-sea-green" id="salva" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Salva</button>
                            </div>
                      </div>
              	</form>
              
              <hr>
              
             </div><!--/tab-pane-->
             <div class="tab-pane" id="messages">
               
               <h2></h2>
               
               <hr>
                  <form class="form" action="##" method="post" id="registrationForm">
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name"><h4>First name</h4></label>
                              <input type="text" class="form-control" name="first_name" id="first_name" placeholder="first name" title="enter your first name if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="last_name"><h4>Last name</h4></label>
                              <input type="text" class="form-control" name="last_name" id="last_name" placeholder="last name" title="enter your last name if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="phone"><h4>Phone</h4></label>
                              <input type="text" class="form-control" name="phone" id="phone" placeholder="enter phone" title="enter your phone number if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="mobile"><h4>Mobile</h4></label>
                              <input type="text" class="form-control" name="mobile" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email</h4></label>
                              <input type="email" class="form-control" name="email" id="email" placeholder="you@email.com" title="enter your email.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Location</h4></label>
                              <input type="email" class="form-control" id="location" placeholder="somewhere" title="enter a location">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="password"><h4>Password</h4></label>
                              <input type="password" class="form-control" name="password" id="password" placeholder="password" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Verify</h4></label>
                              <input type="password" class="form-control" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                          </div>
                      </div>
                      <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                               	<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>
                            </div>
                      </div>
              	</form>
               
             </div><!--/tab-pane-->
             <div class="tab-pane" id="settings">
            		
               	
                  <hr>
                  <form class="form" action="##" method="post" id="registrationForm">
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="first_name"><h4>First name</h4></label>
                              <input type="text" class="form-control" name="first_name" id="first_name" placeholder="first name" title="enter your first name if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="last_name"><h4>Last name</h4></label>
                              <input type="text" class="form-control" name="last_name" id="last_name" placeholder="last name" title="enter your last name if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="phone"><h4>Phone</h4></label>
                              <input type="text" class="form-control" name="phone" id="phone" placeholder="enter phone" title="enter your phone number if any.">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="mobile"><h4>Mobile</h4></label>
                              <input type="text" class="form-control" name="mobile" id="mobile" placeholder="enter mobile number" title="enter your mobile number if any.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email</h4></label>
                              <input type="email" class="form-control" name="email" id="email" placeholder="you@email.com" title="enter your email.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Location</h4></label>
                              <input type="email" class="form-control" id="location" placeholder="somewhere" title="enter a location">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="password"><h4>Password</h4></label>
                              <input type="password" class="form-control" name="password" id="password" placeholder="password" title="enter your password.">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="password2"><h4>Verify</h4></label>
                              <input type="password" class="form-control" name="password2" id="password2" placeholder="password2" title="enter your password2.">
                          </div>
                      </div>
                      <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button class="btn btn-lg btn-success pull-right" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Save</button>
                               	<!--<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Reset</button>-->
                            </div>
                      </div>
              	</form>
              </div>
               
              </div><!--/tab-pane-->
          </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
                                  












<footer id="dk-footer" class="dk-footer container-fluid">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-lg-4">
                    <div class="dk-footer-box-info bg-dark-wine fg-light-grey">
                        <a href="index.html" class="footer-logo">
                            <img src="images/footer_logo.png" alt="footer_logo" class="img-fluid">
                        </a>
                        <p class="footer-info-text">
                           Reference site about Lorem Ipsum, giving information on its origins, as well as a random Lipsum generator.
                        </p>
                        <div class="footer-social-link">
                            <h3>Follow us</h3>
                            <ul>
                                <li>
                                    <a href="#">
                                        <i class="fab fa-facebook-square"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fab fa-twitter"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fab fa-linkedin"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
                                        <i class="fab fa-instagram"></i>
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <!-- End Social link -->
                    </div>
                    <!-- End Footer info -->
                    <div class="footer-awarad">
                        <img src="images/icon/best.png" alt="">
                        <p>Best Design Web Aggency 2019</p>
                    </div>
                </div>
                <!-- End Col -->
                <div class="col-md-12 col-lg-8">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="contact-us">
                                <div class="contact-icon">
                                    <i class="fa fa-map-o" aria-hidden="true"></i>
                                </div>
                                <!-- End contact Icon -->
                                <div class="contact-info">
                                    <span>S Michele di S. (AV) Italy</span><br>
                                    <span>Via Roma 18 83028</span>
                                </div>
                                <!-- End Contact Info -->
                            </div>
                            <!-- End Contact Us -->
                        </div>
                        <!-- End Col -->
                        <div class="col-md-6">
                            <div class="contact-us contact-us-last">
                                <div class="contact-icon">
                                    <i class="fa fa-volume-control-phone" aria-hidden="true"></i>
                                </div>
                                <!-- End contact Icon -->
                                <div class="contact-info">
                                    <span>351 82 82 721</span><br>
                                    <span>Chiamaci</span>
                                </div>
                                <!-- End Contact Info -->
                            </div>
                            <!-- End Contact Us -->
                        </div>
                        <!-- End Col -->
                    </div>
                    <!-- End Contact Row -->
                    <div class="row">
                        <div class="col-md-12 col-lg-6">
                            <div class="footer-widget footer-left-widget">
                                <div class="section-heading">
                                    <h3>Link Utili</h3>
                                    <span class="animate-border border-black bg-sea-green"></span>
                                </div>
                                <ul>
                                    <li>
                                        <a href="#">Chi Siamo</a>
                                    </li>
                                    <li>
                                        <a href="#">Servizi</a>
                                    </li>
                                    <li>
                                        <a href="#">Proggetti</a>
                                    </li>
                                    <li>
                                        <a href="#">Il nostro Team</a>
                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <a href="#">Contattaci</a>
                                    </li>
                                    <li>
                                        <a href="#">Blog</a>
                                    </li>
                                    <li>
                                        <a href="#">Dicono di noi</a>
                                    </li>
                                    <li>
                                        <a href="#">Faq</a>
                                    </li>
                                </ul>
                            </div>
                            <!-- End Footer Widget -->
                        </div>
                        <!-- End col -->
                        <div class="col-md-12 col-lg-6">
                            <div class="footer-widget">
                                <div class="section-heading">
                                    <h3>Iscriviti</h3>
                                    <span class="animate-border border-black bg-sea-green"></span>
                                </div>
                                <p><!-- Donât miss to subscribe to our new feeds, kindly fill the form below. -->
                                Reference site about Lorem Ipsum, giving information on its origins, as well.</p>
                                <form action="#">
                                    <div class="form-row">
                                        <div class="col dk-footer-form">
                                            <input type="email" class="form-control" placeholder="Indirizzo Email">
                                            <button type="submit">
                                                <i class="fas fa-paper-plane"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                                <!-- End form -->
                            </div>
                            <!-- End footer widget -->
                        </div>
                        <!-- End Col -->
                    </div>
                    <!-- End Row -->
                </div>
                <!-- End Col -->
            </div>
            <!-- End Widget Row -->
        </div>
        <!-- End Contact Container -->


        <div class="copyright bg-dark-wine">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <span>Copyright Â© 2019, All Right Reserved UNISA 0512105210</span>
                    </div>
                    <!-- End Col -->
                    <div class="col-md-6">
                        <div class="copyright-menu">
                            <ul>
                                <li>
                                    <a href="#">Home</a>
                                </li>
                                <li>
                                    <a href="#">Termini</a>
                                </li>
                                <li>
                                    <a href="#">Privacy Policy</a>
                                </li>
                                <li>
                                    <a href="#">Contatti</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- End col -->
                </div>
                <!-- End Row -->
            </div>
            <!-- End Copyright Container -->
        </div>
        <!-- End Copyright -->   
</footer>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="jquery/jquery-3.3.1.js"></script>
    <script src="js/bootstrap.bundle.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
    <script src="js/custom.js"></script>
    <% if(session.getAttribute("message")!=null && session.getAttribute("messaggio").equals("false")){%>
<script>
$( document ).ready(function() 
		{
		    $("#loginForm input[name='email']").val("");
			   $("#loginForm input[name='password']").val("");
			   $("#loginForm input[name='optradio']").prop("checked",false);
		 	   $("#messageBar").css("display","block");
		 	  $(".fa-user-lock").css("display","none");
		 	 $("#dropdownMenuUserSetting").css("display","block");
		 	<%session.setAttribute("messaggio","null");%>
 	 	});
</script>
<%}else if(session.getAttribute("message")!=null && session.getAttribute("messaggio").equals("true")){%>
<script>
$( document ).ready(function() {
 	   $("#messageBar").css("display","block");
 	  $(".fa-user-lock").css("display","block");
 	 $("#dropdownMenuUserSetting").css("display","none");
 	<%session.setAttribute("messaggio","null");%>
 	 
});
</script>
<%} else if(session.getAttribute("message")!=null && session.getAttribute("messaggio").equals("null")){%>
    <script>
    $( document ).ready(function() {
    	$("#messageBar").css("display","none");
    	  $(".fa-user-lock").css("display","none");
    	 $("#dropdownMenuUserSetting").css("display","block");
    });
    </script>

<%} else {%>
    <script>
    $( document ).ready(function() {
    	$("#messageBar").css("display","none");
    	  $(".fa-user-lock").css("display","block");
    	 $("#dropdownMenuUserSetting").css("display","none");
    }); <%}%>
    </script>

  </body>
</html>


