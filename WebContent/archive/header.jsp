<%@ page language="java" contentType="text/html; charset=utf-8/>"
    pageEncoding="utf-8" import="com.extraordinary.italy.model.LoginBean" session="true" %>
<%
		String email = "";
  		String name = "";
  		String sms = "";
		Boolean flag = false;	
		if ((session.getAttribute("customerBean") != null) && (session.getAttribute("message") != null)) {
				LoginBean cb = (LoginBean) session.getAttribute("customerBean");
				sms = (String)session.getAttribute("message");
		 		email = cb.getEmail();
		 		name = cb.getName();
		 		
			}else{
				flag = true;
			}
		
	
		
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
    
   	<title>Extraordinary-Italy</title>
  </head>
  <body>
  <p id="messageBar" style=" text-align:center; ;position:relative; width:100%; height:2em; display:none" class=" bg-sea-green fg.light-grey"><%= sms %></p>
    <!-- MENU ALTO -->
	<nav class="navbar navbar-expand-sm" id="navbar-nav-1">  
	  <!--  sx  Campo di ricerca, telefono, sèedizioni gratis -->
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
				    <a class="dropdown-item" href="#">Registrati</a>
				    <a class="dropdown-item" href="index.jsp?page=profile">Profilo</a>
				    <a class="dropdown-item" href="CostumerLogout">Logout</a>
				  </div>
			 </div>
		</li>
		<li class="nav-item">
			<a href="#" id="btnUserLock" class="nav-link" data-toggle="modal" data-target="#loginModal"><i class="fas fa-user-lock fa-2x"></i></a>
			
		</li>
		<li class="nav-item dropdown">
			<a  href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fas fa-shopping-cart fa-2x"></i> </a> 
			<!-- Sub menu cart -->
			<ul class="dropdown-menu">
				<li  class="dropdown-item">
					<div class="row">
						<div class="col-3">
							<img src="https://via.placeholder.com/64" alt="placeholder thumbnail" title="placeholder thumbnail" width="70" height="70"/>
						</div>
						<div class="col-6"> 
							<h4>Heading 1</h4>
							<span>25&euro;</span>
						</div>
						<div class="col-3">
							<a class="fas fa-plus-square"></a> 
							<a class="fas fa-minus-square"></a> 
							<a class="far fa-trash-alt"></a>
						</div>
					</div>
					
				</li>
				<li  class="dropdown-item">
					<div class="row">
						<div class="col-3">
							<img src="https://via.placeholder.com/64" alt="placeholder thumbnail" title="placeholder thumbnail" width="70" height="70"/>
						</div>
						<div class="col-6"> 
							<h4>Heading 2</h4>
							<span>25&euro;</span>
						</div>
						<div class="col-3">
							<a class="fas fa-plus-square"></a> 
							<a class="fas fa-minus-square"></a> 
							<a class="far fa-trash-alt"></a>
						</div>
					</div>
				</li>
				<li  class="dropdown-item">
					<div class="row">
						<div class="col-3">
							<img src="https://via.placeholder.com/64" alt="placeholder thumbnail" title="placeholder thumbnail" width="70" height="70"/>
						</div>
						<div class="col-6"> 
							<h4>Heading 3</h4>
							<span>25&euro;</span>
						</div>
						<div class="col-3">
							<a class="fas fa-plus-square"></a> 
							<a class="fas fa-minus-square"></a> 
							<a class="far fa-trash-alt"></a>
						</div>
					</div>
				</li>
			</ul>
		</li>
	</ul><!-- end sub menu cart  -->
	
	
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
                    	<form   action="CustomerLoginServlet"  method="POST" name="loginForm" id="loginForm" enctype="application/x-www-form-urlencoded">
	                        <div class="form-group">
	                            <input type="hidden" class="form-control"  name="role" value="customer" />
	                        </div>
	                        <div class="form-group">
	                            <input type="text" class="form-control" placeholder="La tua Email" name="email" value="" />
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
                    <form action="SignUpControlServlet" method="POST" id="registrationForm" enctype="application/x-www-form-urlencoded">
                    	<div class="form-group">
                    	    <input type="text" class="form-control" placeholder="Inserisci Nome e Cognome" name="fullName" value="" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="Inserisci una Mail" name="email" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" id="registationPassword" class="form-control" placeholder="Inserisci una Password" name="password" value="" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control" placeholder="Re-Inserisci Password" name="password2" value="" />
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btnSubmit" value="Login" />
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
  <a class="navbar-brand" href="#">ExtraordinaryItaly.com</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbar">
   <ul class="navbar-nav mr-auto">
    
    <li class="nav-item dropdown megamenu-li">
     <a class="nav-link dropdown-toggle" href="" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Birre</a>
     <div class="dropdown-menu megamenu" aria-labelledby="dropdown02">
      <div class="row" id="megamenucontent">
       <div class="col-12 " style="margin-left:1em;">
        <h5 class="fg-sea-green">Top Styles</h5>
       </div>
       <div  class="col-sm-6 col-lg-3">
        <ul style="font-family: extraordinary-italy-text" id="beerStyles_g1" class="fg-dark-grey"></ul>
       </div>
        <div  class="col-sm-6 col-lg-3">
        <ul style="font-family: extraordinary-italy-text" id="beerStyles_g2" class="fg-dark-grey"></ul>
       </div>
       <div  class="col-sm-6 col-lg-3">
        <ul style="font-family: extraordinary-italy-text" id="beerStyles_g3" class="fg-dark-grey"></ul>
       </div>
        <div  class="col-sm-6 col-lg-3">
        <ul style="font-family: extraordinary-italy-text" id="beerStyles_g4" class="fg-dark-grey"></ul>
       </div>
       <div class="col-12 " style="text-align:center; margin-top:1em;">
        <h5 class="fg-sea-green" >LA NOSTRA OFFERTA</h5>
        <p id="megaMenuPresantation" class="fg-light-grey"><!-- Qui testo dal file json --></p>
       </div>
      </div>
     </div>
    </li>
    <li class="nav-item  megamenu-li"><a class="nav-link" href="#">Confezioni Regalo</a></li>
    <li class="nav-item  megamenu-li"><a class="nav-link"href="#">Bicchieri</a></li>
    <li class="nav-item  megamenu-li"><a class="nav-link" href="#">Novità</a></li>
    <li class="nav-item  megamenu-li"><a class="nav-link" href="#">Promozioni</a></li>
   </ul>
  </div>
 </div>
	</nav>

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
    <% 
if(session.getAttribute("message")!= null){%>
<script>
$( document ).ready(function() {
    $("#loginForm input[name='email']").val("");
	   $("#loginForm input[name='password']").val("");
	   $("#loginForm input[name='optradio']").prop("checked",false);
 	   $("#messageBar").css("display","block");
 	  $(".fa-user-lock").css("display","none");
 	 $("#dropdownMenuUserSetting").css("display","block");
 	 
});
</script>
<%
}else{%>
	
	<script>
$( document ).ready(function() {
      
 	   $("#messageBar").css("display","none");
 	  $(".fa-user-lock").css("display","block");
 	 $("#dropdownMenuUserSetting").css("display","none");
 	 
});
</script>
<% 
}
%>
  </body>
</html>
