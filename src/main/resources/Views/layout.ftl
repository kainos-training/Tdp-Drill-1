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
    <link href="/assets/css/styles.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" type="text/css" rel="stylesheet">
  </head>
  <body>

  <div class="pre-nav">

      <div class="container">

          <img src="https://cdn3.kainos.com/wp-content/themes/kainos.com/images/Kainos-Logo.png?e2bd8e" alt="kainos-logo" width="250px">

      </div>

  </div>

    <div class="container">




          <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="#">Project</a></li>
          </ul>

            <br>
            <br>

          <div class="page-nav">

              <a href="/project/${project.id}">${project.name}</a>

          </div>

    </div>
    <div class="container">

      <#nested/>

    </div><!-- /.container -->
  </body>
</html>
</#macro>
