<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Java Stock Quotes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
</head>
<body>

<!-- Static navbar -->
<nav class="navbar navbar-default navbar-static-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">Java Stock App</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Home</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <!-- Table -->
    <table class='table table-striped'>
        <thead>
        <tr>
            <th>Stock Symbol</th>
            <th>Stock Price</th>
            <th>Stock Date</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${quote.symbol}</td>
            <td>${quote.price}</td>
            <td>${quote.date}</td>
        </tr>
        </tbody>
    </table>

</div> <!-- /container -->
<hr/>
<footer class="footer">
    <div class="container">

        <div class="row">
            <address class="col-md-6 col-md-offset-3 text-center">
                <strong>Conal Ryan</strong><br>
                7 Attitash Ave<br>
                Merrimac, MA 01860<br>
                <abbr title="Phone">P:</abbr> (978) 456-7890
            </address>
            <p class="col-md-4 col-md-offset-8 text-right">Copyright &copy; <?php date("Y") ?> Conal Ryan</p>
        </div>

    </div>
</footer>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>