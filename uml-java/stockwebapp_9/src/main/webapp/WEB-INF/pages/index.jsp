<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Java Stock App</title>
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
<!-- Main component for a primary marketing message or call to action -->
<div class="jumbotron">
    <h1>Java Stock Quote App</h1>
    <p>This app was designed by Conal Ryan for the Umass Lowell class - Advanced Java</p>
    <p>This app uses Java JSP, Spring, Hibernate, MySQL</p>

    <!-- Get Quote -->
    <div class="col-md-6 col-md-offset-3">
        <form class="form-inline" action="yahoo/quote" method="get">
            <div class="form-group">
                <div class="input-group input-group-lg">
                    <input type="text" class="form-control" name="symbol" id="symbol" placeholder="Stock Symbol">
                </div>
            </div>
            <button type="submit" class="btn btn-lg btn-primary">Get Quote</button>
        </form>
    </div>
</div>

<div class="col-md-8 col-md-offset-1">
<div class="row">
    <!-- Get Quote -->
    <form action="yahoo/quotes/interval" method="get">
        <div class="form-group">
            <label for="symbol">Stock Symbol</label>
            <input type="text" class="form-control" name="stocksymbol" id="stocksymbol" placeholder="Stock Symbol">
       </div>
        <div class="form-group">
            <label for="from">From</label>
            <input type="text" class="form-control" name="from" id="from" placeholder="From yyyy/MM/dd">
        </div>
        <div class="form-group">
            <label for="until">Until</label>
            <input type="text" class="form-control" name="until" id="until" placeholder="Until yyyy/MM/dd">
        </div>
        <div class="form-group">
            <label for="interval">Interval</label>
            <input type="text" class="form-control" name="interval" id="interval" placeholder="Interval">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</div>
<hr />
<!-- Columns -->
<div class="row">

    <div class="col-sm-6 col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">S&amp;P 500</h3>
            </div>
            <div class="panel-body">
                The S&amp;P 500, or the Standard &amp; Poor's 500, is an American stock market index based on the market capitalizations of 500 large companies having common stock listed on the NYSE or NASDAQ. The S&P 500 index components and their weightings are determined by S&P Dow Jones Indices. It differs from other U.S. stock market indices, such as the Dow Jones Industrial Average or the Nasdaq Composite index, because of its diverse constituency and weighting methodology. It is one of the most commonly followed equity indices, and many consider it one of the best representations of the U.S. stock market, and a bellwether for the U.S. economy. The National Bureau of Economic Research has classified common stocks as a leading indicator of business cycles.
            </div>
        </div>
    </div>

    <div class="col-sm-6 col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Nasdaq 100</h3>
            </div>
            <div class="panel-body">
                The NASDAQ-100 is a stock market index made up of 107 equity securities issued by 100 of the largest non-financial companies listed on the NASDAQ. It is a modified capitalization-weighted index. The stocks' weights in the index are based on their market capitalizations, with certain rules capping the influence of the largest components. It is based on exchange, and it is not an index of U.S.-based companies. It does not have any financial companies, since these were put in a separate index. Both of those criteria differentiate it from the Dow Jones Industrial Average, and the exclusion of financial companies distinguishes it from the S&amp;P 500.
            </div>
        </div>
    </div>

    <div class="col-sm-6 col-md-4">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h3 class="panel-title">Dow Jones</h3>
            </div>
            <div class="panel-body">
                The Dow Jones Industrial Average also called the Industrial Average, the Dow Jones, the Dow Jones Industrial, the Dow 30, or simply the Dow, is a stock market index, and one of several indices created by Wall Street Journal editor and Dow Jones & Company co-founder Charles Dow. The industrial average was first calculated on May 26, 1896.[1] Currently owned by S&P Dow Jones Indices, which is majority owned by McGraw-Hill Financial, it is the most notable of the Dow Averages, of which the first (non-industrial) was first published on February 16, 1885. The averages are named after Dow and one of his business associates, statistician Edward Jones. It is an index that shows how 30 large publicly owned companies based in the United States have traded during a standard trading session in the stock market. It is the second oldest U.S. market index after the Dow Jones Transportation Average, which was also created by Dow.
            </div>
        </div>
    </div>
</div>
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