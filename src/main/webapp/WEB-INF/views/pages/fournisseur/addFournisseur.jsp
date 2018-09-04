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
                        <h1 class="page-header"> <fmt:message code="common.ajouter" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <fmt:message code="common.ajouter" />
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	<c:url value="/fournisseur/enregistrer" var ="urlEnregistrer" />
								<f:form modelAttribute="fournisseur" action="${urlEnregistrer }" role = "form">
									<f:hidden path="id"/>
									<f:hidden path="code"/>
									<div class="form-group">
                                        <label><fmt:message code="common.nom" /></label>
                                        <f:input path="nom" class="form-control" placeholder="Nom" />
                                    </div>
									<div class="form-group">
                                        <label>adresse</label>
                                        <f:input path="adresse" class="form-control" placeholder="Adresse" />
                                    </div>
									<div class="form-group">
                                        <label>Téléphone</label>
                                        <f:input path="telephone" class="form-control" placeholder="Telephone" />
                                    </div>
									<div class="form-group">
                                        <label>Fax</label>
                                        <f:input path="fax" class="form-control" placeholder="Fax" />
                                    </div>
									<div class="form-group">
                                        <label>E-mail</label>
                                        <f:input path="email" class="form-control" placeholder="Fax" />
                                    </div>


										<div class="form-group">
		                                    <label><fmt:message code="common.nom" /></label>
		                                    <select name="t_four_id" class = "form-control" id="listTypeFournisseurs">
		                                    	<option value = "-1">Type fournisseur</option>
		                                    	<c:forEach items = "${typeFournisseurs }" var = "typeFournisseur">
		                                    		<option value = "${typeFournisseur.getId() }" >${typeFournisseur.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
			                                
			                            <div class="form-group">
				                            <label>Date Entrée</label>
			                               	<input name="date_entree" type="date" class="form-control" required/>
			                            </div>
			                            
										<div class="form-group">
		                                    <label>Import B.I.C</label>
		                                    <select name="import_bic" class = "form-control" >
		                                    	<option value = "-1">Select Import B.I.C</option>
		                                    	<option value = "exonore">Exonoré</option>
		                                    	<option value = "assujeti">Assujeti</option>
		                                    </select>
		                                </div>
		                            
	                               
	                                
                                    
									<div class="form-group">
                                        <label>N° Compte Tiers</label>
                                        <f:input path="numCompteTiers" class="form-control" placeholder="" />
                                    </div>
                                    
									<div class="form-group">
                                        <label>N° C.C</label>
                                        <f:input path="numCc" class="form-control" placeholder="" />
                                    </div>
                                    
									<div class="form-group">
                                        <label>N° R.C.C.M</label>
                                        <f:input path="numRccm" class="form-control" placeholder="" />
                                    </div>
                                    
									<div class="form-group">
                                        <label>N° Agrement</label>
                                        <f:input path="numAgrement" class="form-control" placeholder="" />
                                    </div>
                                    
									<div class="form-group">
		                                  <label><fmt:message code="common.nom" /></label>
		                                  <select name="banque_id" class = "form-control" id="listTypeFournisseurs">
		                                   	<option value = "-1">Banque</option>
		                                   	<c:forEach items = "${banques }" var = "banque">
		                                   		<option value = "${banque.getId() }" >${banque.getNom() }</option>
		                                   	</c:forEach>
		                                  </select>
		                            </div>
                                    
									<div class="form-group">
                                        <label>N° Banque</label>
                                        <f:input path="numBanque" class="form-control" placeholder="" />
                                    </div>
	                                
	                                
                                    
	                                <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/fournisseur/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
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
