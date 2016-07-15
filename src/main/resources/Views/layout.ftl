<#macro layout>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap -->
    <title>Discovery Diary</title>
    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/style.css" rel="stylesheet">

  </head>
  <body>

    <div class="container">
    <img src="https://upload.wikimedia.org/wikipedia/en/6/61/Kainos_company_logo.png" alt="kainos-logo" width="250px">


          <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="#">Project</a></li>
          </ul>

            <br>
            <br>


    </div>
    <div class="container">

      <#nested/>

    </div><!-- /.container -->

  </body>
</html>
</#macro>
