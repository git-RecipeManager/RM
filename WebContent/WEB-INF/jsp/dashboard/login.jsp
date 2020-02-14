<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
    <meta charset="utf-8">
    <!--  Dice ai browswe di impostare il viewport ovvero la finestra del browser alle stesse dimensioni del device -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Disabilita il riconoscimentoautomatico da parte dei browser dei numeri di telefono che non è standardizzato useremo invece html5 -->
	<meta name="format-detection" content="telephone=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="http://localhost:8080/extraordinary-italy.com/css/bootstrap.css">
    <link rel="stylesheet" href="http://localhost:8080/extraordinary-italy.com/css/all.css">
    <link rel="stylesheet" href="http://localhost:8080/extraordinary-italy.com/css/secured-login.css">
 	<title>Secured</title>
</head>
 <body bgcolor = "#ffffff">
      <div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
      <img src="http://danielzawadzki.com/codepen/01/icon.svg" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form method = "POST" action ="/extraordinary-italy.com/Secured">
      <input type="text" id="login" class="fadeIn second" name="user" placeholder="login">
      <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <span> </span>
    </div>

  </div>
</div>
     
      
   </body>
</html>