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
                        <h1 class="page-header"> <fmt:message code="common.contratAchat.titre" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <fmt:message code="common.contratAchat.soustitre2" />
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	<c:url value="/u/contratAchat/enregistrer" var ="urlEnregistrer" />
								<f:form modelAttribute="contratAchat" action="${urlEnregistrer }" role = "form">
									<f:hidden path="id"/>
									<f:hidden path="code"/>
									<div class="form-group">
                                        <label>Référence</label>
                                        <f:input path="reference" class="form-control" placeholder="Reference" />
                                    </div>
                                    

										<div class="form-group">
		                                    <label>Fournisseur</label>
		                                    <select name="fid" class = "form-control">
		                                    	<option value = "1">Select Fournisseur</option>
		                                    	<c:forEach items = "${fournisseurs }" var = "fournisseur">
		                                    		<option value = "${fournisseur.getId() }" >${fournisseur.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Decision</label>
		                                    <select name="decision" class = "form-control" >
		                                    	<option value = "1">Select Decision</option>
		                                    	<option value = "attente">En Attente</option>
		                                    	<option value = "accepte">Accepté</option>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Produit</label>
		                                    <select name="pid" class = "form-control" >
		                                    	<option value = "1">Select Produit</option>
		                                    	<c:forEach items = "${produits }" var = "produit">
		                                    		<option value = "${produit.getId() }" >${produit.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Unite Mesure</label>
		                                    <select name="umid" class = "form-control" >
		                                    	<option value = "-1">Select Unité Mesure</option>
		                                    	<c:forEach items = "${uniteMesure }" var = "um">
		                                    		<option value = "${um.getId() }" >${um.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
		                                <div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Date Achat</label>
			                                	<input name="date_achat" type="date" class="form-control" required/>
			                                </div>
		                                </div>
		                                
		                                <div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Au Date</label>
			                                	<input name="au_Date" type="date" class="form-control" required/> 
			                                </div>
		                                </div> 
		                                
		                                <div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Du Date</label>
			                                	<input name="du_Date" type="date" class="form-control" required/> 
			                                </div> 
		                                </div>
		                                
		                                
									<div class="form-group">
                                        <label>Quantité</label>
                                        <f:input path="quantite" class="form-control" placeholder="Quantite" required="true"/>
                                    </div>
		                                
		                                
									<div class="form-group">
                                        <label>Prix Unitaire Indicatif</label>
                                        <f:input path="prixUIndicatif" class="form-control" placeholder="00.00" required="true"/>
                                    </div>
		                                
	                      
                                    
                                    
                                    
                                    
	                                <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/u/contratAchat/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
                                    </div>
								</f:form>	                        
	                        </div>
	                        <!-- /.panel-body -->
	                    </div>
	                    <!-- /.panel -->
	                </div>
                <!-- /.col-lg-12 -->
            </div>
                <!-- /.row -->
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

</body>

</html>
