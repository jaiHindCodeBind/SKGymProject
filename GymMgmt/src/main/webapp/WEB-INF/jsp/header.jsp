<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SK Fitness </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#"> DASHBOARD</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> MEMBER MASTER<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="loadAddMember.do">ADD MEMBER</a></li>
          <li><a href="member/getAllMember.do">SEARCH MEMBER</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> FEES<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">UNPAID</a></li>
          <li><a href="#">PAID</a></li>
        </ul>
      </li>
      <li><a href="#">ATTENDANCE</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="gymInfo.do"><span class="glyphicon glyphicon-user"></span> About</a></li>
      <li><a href="/"><span class="glyphicon glyphicon-off"></span> Sign Out</a></li>
    </ul>
  </div>
</nav>
</body>
</html>
