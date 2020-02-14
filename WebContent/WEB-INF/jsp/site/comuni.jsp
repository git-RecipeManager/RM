<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/Province" method="post" name="prova" id="prova" >
province: <select name="province">
<option value ="0" >Scegli</option>
<option value="AV">Aveliino</option>
<option value="BN">Benevento</option>
<option value="CE">Caserta</option>
<option value="NA">Napoli</option>
<option value="SA">Salernpo</option>
</select>

 comuni: <select name="comuni" id="comuni">

</select>
</form>


<script>
var select = document.forms["prova"]["province"];
var comuni = document.getElementById("comuni");
select.onchange = function(event){
	alert();
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(event){
		 if (this.readyState == 4 && this.status == 200) {
		       comuni.innerHTML = xhr.responseText;
		    }
	}
	var optionValue = select.value;
	xhr.open("GET","http://localhost:8080/extraordinary-italy.com/Province?provincia="+optionValue,true);
	xhr.send();
}

</script>
</body>
</html>