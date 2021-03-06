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
                        <h1 class="page-header"> <fmt:message code="common.route.titre" /></h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                
                <div class="row">
	                <div class="col-lg-12">
	                    <div class="panel panel-primary">
	                        <div class="panel-heading">
	                            <fmt:message code="common.route.soustitre2" />
	                        </div>
	                        <!-- /.panel-heading -->
	                        <div class="panel-body">
	                        	<c:url value="/u/route/enregistrer" var ="urlEnregistrer" />
								<f:form modelAttribute="route" action="${urlEnregistrer }" role = "form">
									<f:hidden path="id"/>
									<f:hidden path="code"/>
                                    
                                    <c:if test="${ttt=='nouveau' }">
										<div class="form-group">
		                                    <label>Sous-Prefecture</label>
		                                    <select name="s_pref_id" class = "form-control" >
		                                    	<option value = "1">Select Sous-Prefecture</option>
		                                    	<c:forEach items = "${sousPrefectures }" var = "sousPrefecture">
		                                    		<option value = "${sousPrefecture.getId() }" >${sousPrefecture.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
										<div class="form-group">
		                                    <label>Porte</label>
		                                    <select name="port_id" class = "form-control" >
		                                    	<option value = "-1">Select Port</option>
		                                    	<c:forEach items = "${ports }" var = "port">
		                                    		<option value = "${port.getId() }" >${port.getNom() }</option>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
	                                </c:if>
	                                
	                                
	                                
	                               <c:if test="${ttt=='modifier' }"> 
		                                <div class="form-group">
		                                    <label>Sous-Prefecture</label>
		                                    <select name="s_pref_id" class = "form-control">
		                                    	<option value = "${route.getSousPrefecture().getId() }">${route.getSousPrefecture().getNom() }</option>
		                                    	<c:forEach items = "${sousPrefectures }" var = "sousPrefecture">
		                                    		<c:if test="${route.getSousPrefecture().getId()!=sousPrefecture.getId() }"> 
		                                    			<option value = "${sousPrefecture.getId() }">${sousPrefecture.getNom() }</option>
		                                    		</c:if>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
		                                <div class="form-group">
		                                    <label>Porte</label>
		                                    <select name="port_id" class = "form-control" >
		                                    	<option value = "${route.getPort().getId() }">${route.getPort().getNom() }</option>
		                                    	<c:forEach items = "${ports }" var = "port">
		                                    		<c:if test="${route.getPort().getId()!=port.getId() }"> 
		                                    			<option value = "${port.getId() }">${port.getNom() }</option>
		                                    		</c:if>
		                                    	</c:forEach>
		                                    </select>
		                                </div>
		                                
	                                </c:if>
                                    
                                    
                                    
                                    
									<div class="form-group">
                                        <label>Cout TKM</label>
                                        <f:input path="coutTkm" class="form-control" required="true" />
                                    </div>
                                    
									<div class="form-group">
                                        <label>Prix Entr�e Usine</label>
                                        <f:input path="prixEntreeUsine" class="form-control" required="true" />
                                    </div>
                                    
                                    
	                                <div class="panel-footer">
                                    	<button type="submit" class="btn btn-primary"><i class="fa fa-save">&nbsp;<fmt:message code="common.enregister" /></i></button>
                                    	<a href="<c:url value="/u/route/" />" class="btn btn-danger"> <i class="fa fa-arrow-left">&nbsp;<fmt:message code="common.annuler" /></i></a>
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
