            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath() %>/home"><i class="fa fa-dashboard fa-fw"></i> Dashboard </a>
                        </li>
                        
                        
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Conseil Agricole <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/zone">Zone</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/region">Region</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/prefecture">Prefecture</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/sousPrefecture">Sous-Prefecture</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/localite">Localité</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/apparielTraitement">Appariel Traitement</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Achats <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/contratAchat">Contrat d'achat</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/produit">Produit</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/variete">Variétés</a>
                                </li>
                                <li>
                                    <a href="#">Type de Sacs</a>
                                </li>
                                <li>
                                    <a href="#">Analyses</a>
                                </li>
                                <li>
                                    <a href="#">Qualité</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/route">Routes</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/unite_mesure">Unité de Mesure</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/typeFournisseur">Type Fournisseur</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/fournisseur">Fournisseurs</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Ventes <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/typeClient">Type Client</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/client">Client</a>
                                </li>
                                <li>
                                    <a href="#">Transitaire</a>
                                </li>
                                <li>
                                    <a href="#">Marque</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/usine">Usine</a>
                                </li>
                                <li>
                                    <a href="#">Type de Contrat</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/devise">Devises</a>
                                </li>
                                <li>
                                    <a href="#">Assurance</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/chargeur">Chargeur</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/port">Port</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Logistique & Stock<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/magasin">Magasin</a>
                                </li>
                                <li>
                                    <a href="#">type parc auto</a>
                                </li>
                                <li>
                                    <a href="#">type de mouvement de parc</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Outils <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/utilisateur">Utilisateur</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/societe">Parametre Sciété</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/listeConnectes">liste des Utilisateurs Connectés</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>