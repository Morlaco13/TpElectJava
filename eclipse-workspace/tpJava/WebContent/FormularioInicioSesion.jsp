<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">

    <title>E-SHOP LOG IN</title>

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" action="Signin" method="post">
      <img class="mb-4" src="style/bootstrap-solid.html" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Ingrese usuario:</h1>
      <label for="inputEmail" class="sr-only">Email:</label>
      <input id="inputEmail" name="email" class="form-control" placeholder="Email address" required="" autofocus="" type="email">
      <label for="inputPassword" class="sr-only">Password</label>
      <input id="inputPassword" name="password" class="form-control" placeholder="Password" required="" type="password">
      <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      <p class="mt-5 mb-3 text-muted">© 2017-2018</p>
    </form>
  

</body></html>