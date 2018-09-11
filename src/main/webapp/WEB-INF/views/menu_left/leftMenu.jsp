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
                                    <a href="<%=request.getContextPath() %>/u/zone">Zone</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/region">Region</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/prefecture">Prefecture</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/sousPrefecture">Sous-Prefecture</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/localite">Localité</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/apparielTraitement">Appariel Traitement</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Achats <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/contratAchat">Contrat d'achat</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/produit">Produit</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/variete">Variétés</a>
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
                                    <a href="<%=request.getContextPath() %>/u/route">Routes</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/unite_mesure">Unité de Mesure</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/typeFournisseur">Type Fournisseur</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/fournisseur">Fournisseurs</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Ventes <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/typeClient">Type Client</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/client">Client</a>
                                </li>
                                <li>
                                    <a href="#">Transitaire</a>
                                </li>
                                <li>
                                    <a href="#">Marque</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/usine">Usine</a>
                                </li>
                                <li>
                                    <a href="#">Type de Contrat</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/devise">Devises</a>
                                </li>
                                <li>
                                    <a href="#">Assurance</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/chargeur">Chargeur</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/port">Port</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> Logistique & Stock<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath() %>/u/magasin">Magasin</a>
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
                                    <a href="<%=request.getContextPath() %>/p/utilisateur">Utilisateur</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/p/societe">Parametre Sciété</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath() %>/p/listeConnectes">liste des Utilisateurs Connectés</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>