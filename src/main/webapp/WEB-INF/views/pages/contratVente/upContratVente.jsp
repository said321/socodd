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
                        <h1 class="page-header"> <fmt:message code="common.contratVente.titre" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <fmt:message code="common.contratVente.soustitre2" />
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	<c:url value="/contratVente/enregistrer" var ="urlEnregistrer" />
								<f:form modelAttribute="contratVente" action="${urlEnregistrer }" role = "form">
									<f:hidden path="id"/>
									<f:hidden path="code"/>
									<div class="form-group">
                                        <label>R�f�rence</label>
                                        <f:input path="reference" class="form-control" placeholder="Reference" required="true"/>
                                    </div>
                                    

										<div class="form-group">
		                                    <label>Client</label>
		                                    <select name="cid" class = "form-control" >
		                                    	<option value = "${contratVente.getClient().getId() }">${contratVente.getClient().getNom() }</option>
		                                    	<c:forEach items = "${clients }" var = "client">
		                                    		<c:if test="${contratVente.getClient().getId() != client.getId() }">
		                                    			<option value = "${client.getId() }" >${client.getNom() }</option>
		                                    		</c:if>
		                                    		
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Decision</label>
		                                    <select name="decision" class = "form-control" >
		                                    	<c:if test="${contratVente.getDecision() == 'en_cours' }">
		                                    		<option value = "${contratVente.getDecision() }">En cours</option>
		                                    		<option value = "accepte">Ex�cut�</option>
		                                    	</c:if>
		                                    	<c:if test="${contratVente.getDecision() == 'execute' }">
		                                    		<option value = "${contratVente.getDecision() }">Ex�cut�</option>
		                                    		<option value = "attente">En cours</option>
		                                    	</c:if>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Produit</label>
		                                    <select name="pid" class = "form-control">
		                                    	<option value = "${contratVente.getProduit().getId() }">${contratVente.getProduit().getNom() }</option>
		                                    	<c:forEach items = "${produits }" var = "produit">
		                                    		<c:if test="${contratVente.getClient().getId() != produit.getId() }">
		                                    			<option value = "${produit.getId() }" >${produit.getNom() }</option>
		                                    		</c:if>
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Devise</label>
		                                    <select name="devid" class = "form-control" >
		                                    	<option value = "${contratVente.getDevise().getId() }">${contratVente.getDevise().getNom() }</option>
		                                    	<c:forEach items = "${devise }" var = "dv">
		                                    		<c:if test="${contratVente.getDevise().getId() != dv.getId() }">
		                                    			<option value = "${dv.getId() }" >${dv.getNom() }</option>
		                                    		</c:if>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
		                              	<div class="form-group">
			                                	<label>Date De vente</label>
			                                	<input name="date_vente" value="${contratVente.getDateVente() }" type="date" class="form-control" required/>
		                                </div> 



		                                
									<div class="form-group">
                                        <label>Poids</label>
                                        <f:input path="poids" class="form-control" placeholder="poids" required="true"/>
                                    </div>
		                                
		                                
									<div class="form-group">
                                        <label>Prix Fix�</label>
                                        <f:input path="prixFixe" class="form-control" placeholder="prix fixe" required="true"/>
                                    </div>
                                    
           
									<div class="form-group">
                                        <label>Valeur</label>
                                        ${contratVente.getPrixFixe()*contratVente.getPoids() }
                                    </div>
                                    
									<div class="form-group">
                                        <label>Parit�</label>
                                        <f:input path="parite" class="form-control" placeholder="parite" required="true"/>
                                    </div>
                                    
									<div class="form-group">
                                        <label>Reste</label>
                                        <f:input path="reste" class="form-control" placeholder="reste" required="true"/>
                                    </div> 
                                    
                                    
                                    
	                                <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/contratVente/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
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
