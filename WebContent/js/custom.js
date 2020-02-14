
$(document).ready(function(){
	/*********************************************************************/
	/*************************** VALIDAZIONE FORM DI LOGIN   *************/
	 /********************************************************************/
	 // Selezione form e definizione dei metodi di validazione
	var $loginForm = $("#loginForm");
	$loginForm.validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // fullName - nome del campo di input da validare
          
            email : {
                required : true,
                // Definiamo il campo email come un campo di tipo email
                email : true
            },
            password : {
                required : true,
                // Settiamo la lunghezza minima e massima per il campo password
                minlength : 6,
                maxlength : 12
            },
            fullName : {
                // Definiamo il campo Ricordami come non Obligatorio "non necessario"
                required : false
              }
        },
        // Personalizzimao i mesasggi di errore
        messages: {
            fullName: "Inserisci Nome E Cognome",
            password: {
                required: "Inserisci una password ",
                minlength: "La password deve essere lunga minimo 6 caratteri",
                maxlength: "La password deve essere lunga al massimo 12 caratteri"
            },
            email: "Inserisci la tua email"
        }
    });
	
	
    /*********************************************************************/
	/*************************** VALIDAZIONE FORM DI REGISTRAZIONE    ****/
	 /********************************************************************/
    $("#registrationForm").validate({
        // Definiamo le nostre regole di validazione
        rules : {
            // fullName - nome del campo di input da validare
            fullName : {
              // Definiamo il campo login come obbligatorio
              required : true
            },
            email : {
                required : true,
                // Definiamo il campo email come un campo di tipo email
                email : true
            },
            password : {
                required : true,
                // Settiamo la lunghezza minima e massima per il campo password
                minlength : 6,
                maxlength : 12
            },
            password2 : {
            	required: true,
            	equalTo: "#registrationPassword"
            }
        },
        // Personalizzimao i mesasggi di errore
        messages: {            fullName: "Campo Fullname Obbligatorio",
            password: {
                required: "Campo password Obbligatorio ",
                minlength: "La password deve essere lunga minimo 6 caratteri",
                maxlength: "La password deve essere lunga al massimo 12 caratteri"
            },
            email: {
            	email:"Inserisci una mail valida",
            	required:"Campo email Obbligatorio"
            	},
            password2 : {
            	 required: "Campo re-Password Obbligatorio ",
            	 equalTo: "Reinserisci La Stessa Password"
            }
        }
    });
	
	
	/**********************************************************************/
	/*************************** MODAL LOGIN  *****************************
	 ********************************************************************/
	
  
    /*$("#loginForm").on("submit",function(event){  
    	event.preventDefault();
		datas = $(this).serialize();
    $.ajax({
        type: "POST",
	    url:"/extraordinary-italy.com/CustomerLoginServlet",
        data: datas,
        contentType: "application/x-www-form-urlencoded",
        dataType: "html",
        success: function (response) {
        	$("#loginForm input[name='email']").val("");
	    	   $("#loginForm input[name='password']").val("");
	    	   $("#loginForm input[name='optradio']").prop("checked",false);
		    	   setTimeout(function(){
		    		   $("button[data-dismiss='modal']").trigger("click");
		    	   }, 6000);
        	
        }
    		
       
      });  // end Ajax        
      
    });
*/
	/*********************************************************************/
	/***************************  END MODAL LOGIN SECTION    *************/
	 /********************************************************************/
	// consente di lasciare aperto il sottomenu quando si opera su 
	// di esso disabilitando il click che lo avrebbe chiuso
    $("#navbar-nav-1 ul ul.dropdown-menu").click(function () {
        return false;
    });
  // megamenu click action
	$(".megamenu").on("click", function(e) {
		e.stopPropagation();
	});
 // Window futured carusel
    $('.carousel.carousel-multi-item.v-2 .carousel-item').each(function(){
    	var next = $(this).next();
    	if (!next.length) {
    	next = $(this).siblings(':first');
    	}
    	next.children(':first-child').clone().appendTo($(this));

    	for (var i=0;i<3;i++) { next=next.next(); if (!next.length) { next=$(this).siblings(':first'); }
    	  next.children(':first-child').clone().appendTo($(this)); } });
    
 /************************************ MENAGE MEGAMENU   ***************************************************************/   
   // CARICA CONTENUTO MEGAMENU DA IN FILE JASON: megamenu.jason
    $("#dropdown02").click(function(evt){
    	
    	var active = "active";
    	var styles = "";
    	var images = "";
    	if($(this).attr("aria-expanded")=="false"){// aria-expanded è modificato dinamicamente
    		// Local file url: json/MegaMenu.json
    		// remote file url:https://api.myjson.com/bins/13x3oj 
    		// storage service myjson.com
    		$.getJSON("http://localhost:8080/extraordinary-italy.com/json/megamenu_content.json", function(result){
    			if($("#beerStyles_g1,#beerStyles_g2,#beerStyles_g3,#beerStyles_g4").is(":empty"))
				{
    			$.each(result.styles,function(i, field){
    				
    					if((i+4)%4 == 0)
    	    				$("#beerStyles_g1").append("<li class='list-group-item'><a href='http://localhost:8080/extraordinary-italy.com/ListingProduct?listBy=all'>"+field+"</a></li>");
    	    				else if((i+4)%4 == 1)
    	        				$("#beerStyles_g2").append("<li class='list-group-item'><a href='http://localhost:8080/extraordinary-italy.com/ListingProduct?listBy=all'>"+field+"</a></li>");
    	    				else if((i+4)%4 == 2)
    	        				$("#beerStyles_g3").append("<li class='list-group-item'><a href='http://localhost:8080/extraordinary-italy.com/ListingProduct?listBy=all'>"+field+"</a></li>");
    	    				else if((i+4)%4 == 3)
    	        				$("#beerStyles_g4").append("<li class='list-group-item'><a href='http://localhost:8080/extraordinary-italy.com/ListingProduct?listBy=all'>"+field+"</a></li>");
    				
    			
    			});
				}
    			$("#megaMenuPresantation").html(result.presantation);
    		});
    	}
    	
    });
    
    
/************************************  MENAGE  MAINCARUSEL CONTENT   ****************************************************/    


    var html="";
    var active = "active";
	var setting ={
			       type:"GET",
			       url:"http://localhost:8080/extraordinary-italy.com/json/main_carusel_content.json",
			       contentType: "application/x-www-form-urlencoded;charset=utf-8",
			       dataType:"json",
			       success:function(result){
					    $.each(result.mainSlide, function(i, field){
					    	if(i > 0) active = "";
					    	html+='<div class="carousel-item '+active+'">'+
					    				'<h3 class="fg-sea-green" style="text-align:center; position:relative;top:1.5em;">'+field.header+'</h3>'+
					    			    '<div><img  src="image/maincaruselimages/'+field.img_src+'" class="'+field.img_class+'" alt="'+field.img_alt+'"/>'+
					    				      '<p class="fg-light-grey" style="position:relative; top:2.5em;">'+field.description+'</p></div>'+
					    		   '</div>';
					    });
			    		$("#mainSlideShow").prepend(html); 
					    	 
					    	 			
			             
			       	}// end  function on success
	            };// end setting
	var jqxhr = $.ajax(setting);
	
	
/************************************************************************************/
/********************************* CUSTOMER PROFILE IMG UPLOAD **********************/
/************************************************************************************/
	
	

	    
	    var readURL = function(input) {
	        if (input.files && input.files[0]) {
	            var reader = new FileReader();

	            reader.onload = function (e) {
	                $('.avatar').attr('src', e.target.result);
	            }
	    
	            reader.readAsDataURL(input.files[0]);
	        }
	    }
	    

	    $(".file-upload").on('change', function(){
	        readURL(this);
	    });
	
	
});


/************************************************************************************/
/********************************* INSERT CATEGORIA **********************/
/************************************************************************************/





		$("#btnCategoriaAdd").on("click",function(event){  
		event.preventDefault();
		datas = $("#addCategory").serialize();
				$.ajax({
						type: "POST",
						url:"Category",
						data: datas,
						contentType: "multipart/form-data",
						dataType: "html",
						success: function (response) {
							
							$("#categoryMessageContainer").html(response);
						}
				});  // end Ajax        

});