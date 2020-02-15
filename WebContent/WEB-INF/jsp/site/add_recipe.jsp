<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    import="com.manager.recipe.model.CategoryBean" import="com.manager.recipe.model.CategoryDAO"
 	import="java.util.ArrayList" pageEncoding="ISO-8859-1" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</body>
</html>