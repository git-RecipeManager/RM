<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.manager.recipe.model.CategoryBean" import="com.manager.recipe.model.CategoryDAO"
 	import="java.util.ArrayList" import="com.manager.recipe.model.LoginBean"
     import="java.time.LocalDate"
     import="com.manager.recipe.model.RecipeDAO"
     import="com.manager.recipe.model.RecipeBean" pageEncoding="ISO-8859-1" %>


<%
		Integer idUser = 0;
		String email = "";
  		String fullName = "";
  		String sms = "";
  		String cel ="";
  		String indirizzo = "";
  		Integer role = 1;
		
		Boolean flag = false;	
		if ((session.getAttribute("customerBean") != null)) {
				LoginBean cb = (LoginBean) session.getAttribute("customerBean");
		 		idUser = cb.getIdUser();
				email = cb.getEmail();
		 		fullName = cb.getFullName();
		 		cel = cb.getCellulare();
		 		indirizzo = cb.getIndirizzo();
		 		role = cb.getRole();		 					 		
			}		
		if(session.getAttribute("message") != null)
		sms = (String)session.getAttribute("message");
		
   %>    
<!DOCTYPE html>
<html>
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
    <link rel="stylesheet" href="css/custom.css"><title>Insert title here</title>
</head>
<body>
<script>
	function  inputFileDetails(surce,destination){
	  var x = document.getElementById(surce);
	  var txt = "";
	  if ('files' in x) {
	    if (x.files.length == 0) {
	      txt = "Selezioa uno o più file.";
	    } else {
	      for (var i = 0; i < x.files.length; i++) {
	        var file = x.files[i];
	        if ('name' in file) {
	          txt += "Nome: " + file.name + " -- ";
	        }
	        if ('size' in file) {
	          txt += "Dimensione: " + file.size + " bytes ";
	        }
	      }
	    }
	  } 
	  else {
	    if (x.value == "") {
	      txt += "Seleziona uno o più file.";
	    } else {
	      txt += "The files property is not supported by your browser!";
	      txt  += "<br>The path of the selected file: " + x.value; // If the browser does not support the files property, it will return the path of the selected file instead. 
	    }
	  }
	  document.getElementById(destination).innerHTML = txt;
	}
</script>
  <p id="messageBar" style=" text-align:center; ;position:relative; width:100%; height:2em; " class=" bg-sea-green fg.light-grey"><%= sms %></p>
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
<% CategoryDAO dao=new CategoryDAO();
ArrayList<CategoryBean> lista=dao.findAllCategories();%>

<form method="post" action="RecipeServlet"enctype="multipart/form-data" name="AddRecipe" id="addRecipe">
  <div class="form-group row">
    <label for="titoloRicetta" class="col-sm-6 col-form-label">Titolo Ricetta</label>
    <div class="col-12">
      <input  type="text" class="form-control" id="titoloRicetta" name="titoloRicetta" placeholder="Titolo Ricetta">
    </div>
  </div>
  <div class="form-group row">
		  <div class="col-md-4">
		  	  <label class="col-sm-4  col-form-label" for="categoriaRicetta">Categoria</label>
			  <select class="form-control" name="categoriaRicetta" id="categoriaRicetta">
			  <%for(CategoryBean bean:lista){%>
			   	<option value="<%=bean.getNomeCategoria()%>"><%=bean.getNomeCategoria()%></option><%}%>
			  </select>
		  </div>
		  <div class="col-md-4">
		  	  <label class="col-sm-4 col-form-label" for="unitaMisuraIngrediente">Misura</label>
			  <select id="unita_misura" class="form-control" name="unita_misura">
			    <option value="ml">ml</option>
			    <option value="cl">cl</option>
			    <option value="Lt">Lt</option>
		 	    <option value="Kg">Kg</option>
			  </select>
		  </div>
    	  <div class="col-md-4">
    	  	    <label class="col-sm-4  col-form-label"for="ValoreMisurato" ">Valore</label>
          		<input  type="text" id="ValoreMisurato" name="valore_misurato" class="form-control"  placeholder="Valore">
    	  </div>
    	  <div class="col-md-4">
    	  	    <label class="col-sm-4  col-form-label"for="NomeIngrediente" ">Ingrediente</label>
          		<input  type="text" id="NomeIngrediente" name="nomeIngrediente" class="form-control"  placeholder="Nome">
    	  </div>
		  
	</div> 
   <div class="form-group row">
    <label for="descrizioneRicetta" class="col-sm-6 col-form-label">Modalità di Preparazione</label>
    <div class="col-12">
      <textarea  id="descrizioneRicetta" name="descrizioneRicetta" class="form-control">Scrivi Quì</textarea>
    </div>
  </div>
  <div class="form-group row">
	    <div class="input-group mb-3 col-12">
			<label  for="imgFullRicetta"><i class="fas fa-upload fa-3x"></i></label>
			<p id="dettagliInputFile3">Scegli un'immagine full per la ricetta (JPG,PNG)</p>
			<input  onchange="inputFileDetails('imgFullRicetta','dettagliInputFile3');" type="file" id="imgFullRicetta" name="imgFullRicetta" accept=".jpg, .jpeg, .png">	 
		</div>
  </div>
  <div class="form-group row">
    <div class="col-12">
      <button type="submit" id="btnRecipeAdd" class="btn bg-sea-green" style="color:white; width:30%">AGGIUNGI</button>
    </div>
  </div>
</form>
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
                                <p><!-- Donâ€™t miss to subscribe to our new feeds, kindly fill the form below. -->
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