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
                                <p><!-- Don’t miss to subscribe to our new feeds, kindly fill the form below. -->
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
                        <span>Copyright © 2019, All Right Reserved UNISA 0512105210</span>
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