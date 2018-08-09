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
	                        	<c:url value="/contratAchat/enregistrer" var ="urlEnregistrer" />
								<f:form modelAttribute="contratAchat" action="${urlEnregistrer }" role = "form">
									<f:hidden path="id"/>
									<f:hidden path="code"/>
									<div class="form-group">
                                        <label>reference</label>
                                        <f:input path="reference" class="form-control" placeholder="Nom" />
                                    </div>
                                    
                                    
                                    
                                    <c:if test="${ttt=='nouveau' }">
										<div class="form-group">
		                                    <label>fournisseur</label>
		                                    <select name="fid" class = "form-control" id="listFournisseurs">
		                                    	<option value = "-1">select fournisseur</option>
		                                    	<c:forEach items = "${fournisseurs }" var = "fournisseur">
		                                    		<option value = "${fournisseur.getId() }" >${fournisseur.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Decision</label>
		                                    <select name="decision" class = "form-control" >
		                                    	<option value = "attente">En Attente</option>
		                                    	<option value = "accepte">Accepté</option>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label><fmt:message code="common.produit" /></label>
		                                    <select name="pid" class = "form-control" id="listProduits">
		                                    	<option value = "-1">Select Produit</option>
		                                    	<c:forEach items = "${produits }" var = "produit">
		                                    		<option value = "${produit.getId() }" >${produit.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Unite Mesure</label>
		                                    <select name="umid" class = "form-control" id="listUniteMesure">
		                                    	<option value = "-1">Select Unite Mesure</option>
		                                    	<c:forEach items = "${uniteMesure }" var = "um">
		                                    		<option value = "${um.getId() }" >${um.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
		                                <div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Date Achat</label>
			                                	<input name="date_achat" type="date" class="form-control"/>
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
                                        <label>Quantite</label>
                                        <f:input path="quantite" class="form-control" placeholder="Nom" />
                                    </div>
		                                
		                                
									<div class="form-group">
                                        <label>Prix Unitaire Indicatif</label>
                                        <f:input path="prixUIndicatif" class="form-control" placeholder="Nom" />
                                    </div>
		                                
	                                </c:if>
                                       
                                    
                                    <c:if test="${ttt=='modifier' }">
										<div class="form-group">
		                                    <label>fournisseur</label>
		                                    <select name="fid" class = "form-control" id="listFournisseurs">
		                                    	<option value = "${contratAchat.getFournisseur().getId() }">${contratAchat.getFournisseur().getNom() }</option>
		                                    	<c:forEach items = "${fournisseurs }" var = "fournisseur">
		                                    		<c:if test="${contratAchat.getFournisseur().getId() != fournisseur.getId() }">
		                                    			<option value = "${fournisseur.getId() }" >${fournisseur.getNom() }</option>
		                                    		</c:if>
		                                    		
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Decision</label>
		                                    <select name="decision" class = "form-control" >
		                                    	<c:if test="${contratAchat.getDecision() == 'attente' }">
		                                    		<option value = "${contratAchat.getDecision() }">En Attente</option>
		                                    		<option value = "accepte">Accepté</option>
		                                    	</c:if>
		                                    	<c:if test="${contratAchat.getDecision() == 'accepte' }">
		                                    		<option value = "${contratAchat.getDecision() }">Accepté</option>
		                                    		<option value = "attente">En Attente</option>
		                                    	</c:if>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label><fmt:message code="common.produit" /></label>
		                                    <select name="pid" class = "form-control" id="listProduits">
		                                    	<option value = "${contratAchat.getProduit().getId() }">${contratAchat.getProduit().getNom() }</option>
		                                    	<c:forEach items = "${produits }" var = "produit">
		                                    		<c:if test="${contratAchat.getFournisseur().getId() != produit.getId() }">
		                                    			<option value = "${produit.getId() }" >${produit.getNom() }</option>
		                                    		</c:if>
		                                    	</c:forEach>
		                                    </select>
		                                </div>

										<div class="form-group">
		                                    <label>Unite Mesure</label>
		                                    <select name="umid" class = "form-control" id="listUniteMesure">
		                                    	<option value = "${contratAchat.getUniteMesure().getId() }">${contratAchat.getUniteMesure().getNom() }</option>
		                                    	<c:forEach items = "${uniteMesure }" var = "um">
		                                    		<c:if test="${contratAchat.getUniteMesure().getId() != um.getId() }">
		                                    			<option value = "${um.getId() }" >${um.getNom() }</option>
		                                    		</c:if>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
		                              	<div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Date D'achat</label>
			                                	<input name="date_achat" value="${contratAchat.getDateAchat() }" type="date" class="form-control"/>
			                                </div>
		                                </div> 
		                                
		                                <div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Au Date</label>
		                                		<input name="au_Date" value="${contratAchat.getAuDate() }" type="date" class="form-control" required/> 
		                                	</div> 
		                                </div>
		                                
		                                <div class="form-group">
			                                <div class="col-md-4 mb-3">
			                                	<label>Du Date</label>
		                                		<input name="du_Date" value="${contratAchat.getDuDate() }" type="date" class="form-control" required/>
		                                	</div> 
		                                </div> 
		                                
		                                
									<div class="form-group">
                                        <label>Quantite</label>
                                        <f:input path="quantite" class="form-control" placeholder="Nom" />
                                    </div>
		                                
		                                
									<div class="form-group">
                                        <label>Prix Unitaire Indicatif</label>
                                        <f:input path="prixUIndicatif" class="form-control" placeholder="Nom" />
                                    </div>
                                    
           
									<div class="form-group">
                                        <label>Montant Indicatif</label>
                                        ${contratAchat.getPrixUIndicatif()*contratAchat.getQuantite() }
                                    </div>
                                    
									<div class="form-group">
                                        <label>Quantite livrée</label>
                                        <f:input path="quantiteLivree" class="form-control" placeholder="Nom" />
                                    </div>
                                    
									<div class="form-group">
                                        <label>Reste à Livrer</label>
                                        <f:input path="resteLivrer" class="form-control" placeholder="Nom" />
                                    </div>                         
		                                
	                                </c:if>
                                    
                                    
                                    
                                    
	                                <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/contratAchat/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
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
