<%@ include file="/WEB-INF/views/includes/includes.jsp" %>
<!DOCTYPE html>
<html lang="fr">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Blank Page</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    
                                <script type="text/javascript">
	                            function test(){
	                            	var t = '${titre }';
	                            	alert(t);
	                            }
                            	</script>

    

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            
            <%@ include file="/WEB-INF/views/menu_top/topMenu.jsp" %>
			
            <%@ include file="/WEB-INF/views/menu_left/leftMenu.jsp" %>
            
            <!-- /.navbar-static-side -->
        </nav>
        
    
  <!-- Page Content -->
        <div id="page-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        
                        
                        <h1 class="page-header">fisrt chart</h1>
                        
                <div class="col-lg-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            ${titre }
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <canvas id="myChart"></canvas>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                        
                        
                        <button onclick="test()" class="btn btn-link">salam<i class="fa fa-th-list"></i></button>
                        <a class="btn btn-primary" href="#" role="button">Link</a>
						<button class="btn btn-primary" type="submit">Button</button>
						<input class="btn btn-primary" type="button" value="Input">
						<input class="btn btn-primary" type="submit" value="Submit">
						<input class="btn btn-primary" type="reset" value="Reset">
                        
                        
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
  
  

    <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/resources/dist/js/sb-admin-2.js"></script>
    
    <script src="<%=request.getContextPath() %>/resources/vendor/Chart.min.js"></script>

<script>

var labels = [];
var dt = [];

$.getJSON('http://localhost:8099/app/json', function (zones) {
     for(var i=0; i<zones.length; i++){
        labels[i] = zones[i].nom;
        dt[i] = zones[i].id;
     } 
    
     console.log(dt);
     console.log(labels);
     
});

var lab = '${titre}';
var data = ${data};
var d = [];

for(var i=0; i<data.length; i++){
    d[i] = data[i].id;
 }
 
console.log(d);


var ctx = document.getElementById('myChart').getContext('2d');
var chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'bar',

    // The data for our dataset
    data: {
        labels: labels,
        datasets: [{
            label: lab,
            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: dt
        },
        {
            label: "My First dataset",
            backgroundColor: 'rgb(25, 9, 232)',
            borderColor: 'rgb(25, 9, 232)',
            data: d
        }
        ]
    },

    // Configuration options go here
    options: {}
});

</script>







</body>

</html>
