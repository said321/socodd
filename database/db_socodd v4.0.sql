-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Aug 10, 2018 at 11:16 AM
-- Server version: 5.6.34-log
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_socodd`
--

-- --------------------------------------------------------

--
-- Table structure for table `analyse`
--

CREATE TABLE `analyse` (
  `id` int(4) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `abrege` varchar(50) NOT NULL,
  `ecran_lot` tinyint(1) NOT NULL,
  `ecran_reception` tinyint(1) NOT NULL,
  `etat_lot` tinyint(1) NOT NULL,
  `etat_reception` tinyint(1) NOT NULL,
  `formule_calcul` varchar(100) NOT NULL,
  `norme` float NOT NULL,
  `ordre` int(11) NOT NULL,
  `produit` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `appariel_traitement`
--

CREATE TABLE `appariel_traitement` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appariel_traitement`
--

INSERT INTO `appariel_traitement` (`id`, `code`, `nom`) VALUES
(1, 'AP1', 'app-trait1');

-- --------------------------------------------------------

--
-- Table structure for table `assurance`
--

CREATE TABLE `assurance` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `chargeur`
--

CREATE TABLE `chargeur` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chargeur`
--

INSERT INTO `chargeur` (`id`, `code`, `nom`) VALUES
(1, 'CG1', 'chargeur1'),
(4, 'CG4', 'chargeur2');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id` int(7) NOT NULL,
  `code` varchar(9) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` text NOT NULL,
  `date_entree` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `fax` varchar(10) NOT NULL,
  `banque` int(11) NOT NULL,
  `import_bic` varchar(50) NOT NULL,
  `num_agrement` int(11) NOT NULL,
  `num_c_c` int(11) NOT NULL,
  `num_compte` int(11) NOT NULL,
  `num_compte_tiers` int(11) NOT NULL,
  `num_rccm` int(11) NOT NULL,
  `type_client` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `compagnie_maritime`
--

CREATE TABLE `compagnie_maritime` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `consommables_pieces`
--

CREATE TABLE `consommables_pieces` (
  `id` int(8) NOT NULL,
  `code` varchar(10) NOT NULL,
  `ref_interne` varchar(50) NOT NULL,
  `ref_fournisseur` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `famille` int(3) NOT NULL,
  `p_u_achat` float NOT NULL,
  `p_u_vente` float NOT NULL,
  `type_format` int(3) NOT NULL,
  `stock_seuil` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contrat_achat`
--

CREATE TABLE `contrat_achat` (
  `id` int(8) NOT NULL,
  `code` varchar(10) DEFAULT NULL,
  `reference` varchar(50) DEFAULT NULL,
  `fournisseur` int(3) DEFAULT NULL,
  `date_achat` date DEFAULT NULL,
  `decision` varchar(50) DEFAULT NULL,
  `produit` int(3) DEFAULT NULL,
  `unite_mesure` int(3) DEFAULT NULL,
  `du_date` date DEFAULT NULL,
  `au_date` date DEFAULT NULL,
  `quantite` float DEFAULT NULL,
  `prix_u_indicatif` float DEFAULT NULL,
  `quantite_livree` float DEFAULT NULL,
  `reste_livrer` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contrat_achat`
--

INSERT INTO `contrat_achat` (`id`, `code`, `reference`, `fournisseur`, `date_achat`, `decision`, `produit`, `unite_mesure`, `du_date`, `au_date`, `quantite`, `prix_u_indicatif`, `quantite_livree`, `reste_livrer`) VALUES
(1, 'CP1', 'ref1', 1, '2018-09-01', 'attente', 1, 1, '2018-08-09', '2018-08-08', 300, 20, 0, 300),
(2, 'CP2', 'ref2', 1, '2018-09-08', 'accepte', 1, 1, '2018-08-17', '2018-08-15', 300, 30, 0, 300),
(3, 'CP3', 'ref3', 1, '2018-08-09', 'accepte', 2, 1, '2018-08-12', '2018-08-10', 20, 12, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `departement`
--

CREATE TABLE `departement` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departement`
--

INSERT INTO `departement` (`id`, `code`, `nom`) VALUES
(1, 'DP1', 'dept1');

-- --------------------------------------------------------

--
-- Table structure for table `devise`
--

CREATE TABLE `devise` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `monnaie_locale` float NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `devise`
--

INSERT INTO `devise` (`id`, `code`, `monnaie_locale`, `nom`) VALUES
(1, 'D1', 0, 'DH');

-- --------------------------------------------------------

--
-- Table structure for table `documents_joindre`
--

CREATE TABLE `documents_joindre` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(5) NOT NULL,
  `code` int(7) NOT NULL,
  `matricule` varchar(10) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `date_naissance` date NOT NULL,
  `adresse` text NOT NULL,
  `date_entree` date NOT NULL,
  `num_compte_tier` int(20) NOT NULL,
  `nationalite` int(3) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `departement` int(3) NOT NULL,
  `fonction_occupee` varchar(10) NOT NULL,
  `equipe` int(3) NOT NULL,
  `banque` varchar(50) NOT NULL,
  `num_compte` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

CREATE TABLE `equipe` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `superviseur` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fabrication_lots`
--

CREATE TABLE `fabrication_lots` (
  `id` int(5) NOT NULL,
  `code` varchar(7) NOT NULL,
  `date` date NOT NULL,
  `produit` int(3) NOT NULL,
  `usine` int(3) NOT NULL,
  `magasin` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `famille_consommables`
--

CREATE TABLE `famille_consommables` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `type_fournisseur` int(3) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` text NOT NULL,
  `date_entree` date NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `fax` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `num_compte_tiers` int(11) NOT NULL,
  `num_cc` int(11) NOT NULL,
  `num_rccm` int(11) NOT NULL,
  `num_agrement` int(11) NOT NULL,
  `num_bic` varchar(50) NOT NULL,
  `banque` varchar(50) NOT NULL,
  `num_banque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `code`, `type_fournisseur`, `nom`, `adresse`, `date_entree`, `telephone`, `fax`, `email`, `num_compte_tiers`, `num_cc`, `num_rccm`, `num_agrement`, `num_bic`, `banque`, `num_banque`) VALUES
(1, 'FR1', 1, 'fournisseur1', 'aaa aaa aaa  aaaa', '2018-08-10', '8494834212', '8494834212', 'fournisseur1@gmail.com', 321, 12, 23, 45, 'assujeti', 'banque1', 456765),
(2, 'FR2', 1, 'fournisseur2', 'hgdf dkufg skhgf87 ', '2018-08-11', '1234567890', '12347890', 'fourniseeur2@gmail.com', 76, 0, 0, 0, 'exonore', 'banque2', 0);

-- --------------------------------------------------------

--
-- Table structure for table `items_debours`
--

CREATE TABLE `items_debours` (
  `id` int(4) NOT NULL,
  `code` varchar(5) NOT NULL,
  `produit` int(3) NOT NULL,
  `type_calcule` int(3) NOT NULL,
  `modifiable` tinyint(1) NOT NULL,
  `valeur` float NOT NULL,
  `ordre` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `localite`
--

CREATE TABLE `localite` (
  `id` int(6) NOT NULL,
  `code` varchar(8) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `sous_prefecture` int(4) NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `localite`
--

INSERT INTO `localite` (`id`, `code`, `nom`, `sous_prefecture`, `longitude`, `latitude`) VALUES
(1, 'LC1', 'localite1', 1, 45.876, 67.768);

-- --------------------------------------------------------

--
-- Table structure for table `magasin`
--

CREATE TABLE `magasin` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` int(50) NOT NULL,
  `localite` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `marque`
--

CREATE TABLE `marque` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `abrege` varchar(50) NOT NULL,
  `ordre` int(11) NOT NULL,
  `produit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `nationalite`
--

CREATE TABLE `nationalite` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nationalite`
--

INSERT INTO `nationalite` (`id`, `code`, `nom`) VALUES
(11, 'NA11', 'nat6'),
(14, 'NA14', 'nat9'),
(15, 'NA15', 'nat15');

-- --------------------------------------------------------

--
-- Table structure for table `parc_auto`
--

CREATE TABLE `parc_auto` (
  `id` int(8) NOT NULL,
  `code` varchar(10) NOT NULL,
  `immatriculation` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date_entree` date NOT NULL,
  `type_parc_auto` int(3) NOT NULL,
  `capacite_reservoire` float NOT NULL,
  `conso` float NOT NULL,
  `poids_brut` float NOT NULL,
  `tare` float NOT NULL,
  `date_exp_visite_tech` date NOT NULL,
  `date_exp_assurance` date NOT NULL,
  `date_exp_patente` date NOT NULL,
  `date_exp_vignette` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `periode_embarquement`
--

CREATE TABLE `periode_embarquement` (
  `id` int(3) NOT NULL,
  `code` varchar(2) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `port`
--

CREATE TABLE `port` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `port`
--

INSERT INTO `port` (`id`, `code`, `nom`) VALUES
(1, 'P1', 'port1');

-- --------------------------------------------------------

--
-- Table structure for table `prefecture`
--

CREATE TABLE `prefecture` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `region` int(11) NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `prefecture`
--

INSERT INTO `prefecture` (`id`, `code`, `nom`, `region`, `longitude`, `latitude`) VALUES
(1, 'P1', 'prefecture1', 1, 32.8767, 45.7657);

-- --------------------------------------------------------

--
-- Table structure for table `producteur`
--

CREATE TABLE `producteur` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` text NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `fax` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date_naissance` date NOT NULL,
  `lieu_naissance` date NOT NULL,
  `nationalite` int(3) NOT NULL,
  `pere` varchar(50) NOT NULL,
  `mere` varchar(50) NOT NULL,
  `nb_enfants` int(2) NOT NULL,
  `nb_femme` int(2) NOT NULL,
  `date_entree` date NOT NULL,
  `reference_piece` int(50) NOT NULL,
  `photo` varchar(200) NOT NULL,
  `sexe` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `produit`
--

CREATE TABLE `produit` (
  `id` int(3) NOT NULL,
  `code` varchar(5) DEFAULT NULL,
  `nom` varchar(50) DEFAULT NULL,
  `titre_compagne` varchar(50) DEFAULT NULL,
  `sac_brousse` int(4) DEFAULT NULL,
  `sac_export` int(4) DEFAULT NULL,
  `pref_num_b_e` int(10) DEFAULT NULL,
  `prochain_achat_num` int(10) DEFAULT NULL,
  `cpte_achat` int(10) DEFAULT NULL,
  `taux_achat_bic` float DEFAULT NULL,
  `pref_num_b_s` int(10) DEFAULT NULL,
  `prochain_vente_num` int(10) DEFAULT NULL,
  `cpte_vte` int(10) DEFAULT NULL,
  `cpte_vente_bic` int(10) DEFAULT NULL,
  `prix_achat_indicatif` float DEFAULT NULL,
  `prix_vente_indicatif` float DEFAULT NULL,
  `frais_transport` float DEFAULT NULL,
  `mnt_debours_transit` int(10) DEFAULT NULL,
  `taux_debours_transit` float DEFAULT NULL,
  `prefixe_num_cdc` int(10) DEFAULT NULL,
  `poids_therorique` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produit`
--

INSERT INTO `produit` (`id`, `code`, `nom`, `titre_compagne`, `sac_brousse`, `sac_export`, `pref_num_b_e`, `prochain_achat_num`, `cpte_achat`, `taux_achat_bic`, `pref_num_b_s`, `prochain_vente_num`, `cpte_vte`, `cpte_vente_bic`, `prix_achat_indicatif`, `prix_vente_indicatif`, `frais_transport`, `mnt_debours_transit`, `taux_debours_transit`, `prefixe_num_cdc`, `poids_therorique`) VALUES
(1, 'PR1', 'cacoa', 'ti com1', 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 7, 87, 0, 0, 0, 0, 79),
(2, 'PR2', 'cafe', 'ti com2', 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 23, 33, 0, 0, 0, 0, 12);

-- --------------------------------------------------------

--
-- Table structure for table `profile_utilisateur`
--

CREATE TABLE `profile_utilisateur` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `qualite`
--

CREATE TABLE `qualite` (
  `id` int(3) NOT NULL,
  `code` int(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `produit` int(5) NOT NULL,
  `abrege` varchar(50) NOT NULL,
  `ordre` int(5) NOT NULL,
  `prix_achat` float NOT NULL,
  `p_u_vte_provisoire` float NOT NULL,
  `p_u_vte_definitif` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reception_produits`
--

CREATE TABLE `reception_produits` (
  `id` int(10) NOT NULL,
  `num_bon` int(50) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `produit` int(3) NOT NULL,
  `usine` int(3) NOT NULL,
  `fournisseur` int(3) NOT NULL,
  `transporteur` int(7) NOT NULL,
  `chauffeur` int(8) NOT NULL,
  `date_reception` date NOT NULL,
  `num_connaissement` int(50) NOT NULL,
  `variete` int(3) NOT NULL,
  `contrat_achat` int(8) NOT NULL,
  `type_sac` int(4) NOT NULL,
  `camion` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `region`
--

CREATE TABLE `region` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `region`
--

INSERT INTO `region` (`id`, `code`, `nom`) VALUES
(1, 'RG1', 'region1'),
(3, 'RG3', 'region3');

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `id` int(11) NOT NULL,
  `code` varchar(8) NOT NULL,
  `cout_tkm` float NOT NULL,
  `prefecture` int(11) NOT NULL,
  `prix_entree_usine` float NOT NULL,
  `region` int(11) NOT NULL,
  `port_destination` int(11) NOT NULL,
  `sous_prefecture` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`, `code`, `cout_tkm`, `prefecture`, `prix_entree_usine`, `region`, `port_destination`, `sous_prefecture`) VALUES
(1, 'RT1', 12, 1, 89, 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `societe`
--

CREATE TABLE `societe` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `activite` varchar(50) NOT NULL,
  `adresse` longtext NOT NULL,
  `agrement` varchar(50) NOT NULL,
  `code_fiscal` varchar(50) NOT NULL,
  `code_imp_exp` varchar(50) NOT NULL,
  `compte_contrib` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `fax` varchar(10) NOT NULL,
  `pays` varchar(50) NOT NULL,
  `raison_sociale` varchar(50) NOT NULL,
  `site_web` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sous_prefecture`
--

CREATE TABLE `sous_prefecture` (
  `id` int(11) NOT NULL,
  `code` varchar(6) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prefecture` int(11) NOT NULL,
  `latitude` float NOT NULL,
  `longitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sous_prefecture`
--

INSERT INTO `sous_prefecture` (`id`, `code`, `nom`, `prefecture`, `latitude`, `longitude`) VALUES
(1, 'P1', 'sous-prefecture1', 1, 87.989, 45.87);

-- --------------------------------------------------------

--
-- Table structure for table `superviseur`
--

CREATE TABLE `superviseur` (
  `id` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` longtext NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `date_entree` date NOT NULL,
  `date_naissance` date NOT NULL,
  `lieu_naissance` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `num_compte_tiers` int(11) NOT NULL,
  `nationalite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transitaire`
--

CREATE TABLE `transitaire` (
  `id` int(11) NOT NULL,
  `code` varchar(9) NOT NULL,
  `adresse` longtext NOT NULL,
  `nom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `fax` varchar(10) NOT NULL,
  `num_agrement` int(11) NOT NULL,
  `num_c_c` int(11) NOT NULL,
  `num_compte_tiers` int(11) NOT NULL,
  `num_rccm` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transporteur`
--

CREATE TABLE `transporteur` (
  `id` int(7) NOT NULL,
  `code` varchar(9) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `adresse` text NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `fax` varchar(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date_entree` date NOT NULL,
  `num_compte_tiers` int(50) NOT NULL,
  `num_c_c` int(20) NOT NULL,
  `num_rccm` int(20) NOT NULL,
  `num_agrement` int(20) NOT NULL,
  `import_bic` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_calcule`
--

CREATE TABLE `type_calcule` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_client`
--

CREATE TABLE `type_client` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_contrat`
--

CREATE TABLE `type_contrat` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `nom2` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_format`
--

CREATE TABLE `type_format` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_fournisseur`
--

CREATE TABLE `type_fournisseur` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_fournisseur`
--

INSERT INTO `type_fournisseur` (`id`, `code`, `nom`) VALUES
(1, 'TF1', 'type fourn1');

-- --------------------------------------------------------

--
-- Table structure for table `type_mvmt_parc_auto`
--

CREATE TABLE `type_mvmt_parc_auto` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_mvmt_stock`
--

CREATE TABLE `type_mvmt_stock` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_parc_auto`
--

CREATE TABLE `type_parc_auto` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_sac`
--

CREATE TABLE `type_sac` (
  `id` int(4) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `tare` float NOT NULL,
  `stock_dernier_inventaire` int(10) NOT NULL,
  `date` date NOT NULL,
  `stock_disponible` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_sac`
--

INSERT INTO `type_sac` (`id`, `code`, `nom`, `tare`, `stock_dernier_inventaire`, `date`, `stock_disponible`) VALUES
(1, 'TF1', 'type_f1', 23, 22, '2018-08-01', 233);

-- --------------------------------------------------------

--
-- Table structure for table `unite_mesure`
--

CREATE TABLE `unite_mesure` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `unite_mesure`
--

INSERT INTO `unite_mesure` (`id`, `code`, `nom`) VALUES
(1, 'um1', 'unite mesure1');

-- --------------------------------------------------------

--
-- Table structure for table `usine`
--

CREATE TABLE `usine` (
  `id` int(3) NOT NULL,
  `code` int(5) NOT NULL,
  `nom` int(50) NOT NULL,
  `localite` int(6) NOT NULL,
  `longitude` float NOT NULL,
  `latitude` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `cel` varchar(10) NOT NULL,
  `code` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fonction` varchar(50) NOT NULL,
  `matricule` varchar(50) NOT NULL,
  `mot_passe` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `telephone` varchar(10) NOT NULL,
  `profile` int(11) NOT NULL,
  `active` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `variete`
--

CREATE TABLE `variete` (
  `id` int(3) NOT NULL,
  `code` varchar(5) NOT NULL,
  `produit` int(4) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `abrege` varchar(20) NOT NULL,
  `ordre` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `zone`
--

CREATE TABLE `zone` (
  `id` int(11) NOT NULL,
  `code` varchar(5) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `zone`
--

INSERT INTO `zone` (`id`, `code`, `nom`) VALUES
(1, 'Z1', 'Casa'),
(2, 'Z2', 'agadir'),
(4, 'Z4', 'Fes'),
(6, 'Z6', 'Taza');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `analyse`
--
ALTER TABLE `analyse`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`);

--
-- Indexes for table `appariel_traitement`
--
ALTER TABLE `appariel_traitement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `assurance`
--
ALTER TABLE `assurance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `chargeur`
--
ALTER TABLE `chargeur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type_client` (`type_client`);

--
-- Indexes for table `compagnie_maritime`
--
ALTER TABLE `compagnie_maritime`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `consommables_pieces`
--
ALTER TABLE `consommables_pieces`
  ADD PRIMARY KEY (`id`),
  ADD KEY `famille` (`famille`),
  ADD KEY `type_format` (`type_format`);

--
-- Indexes for table `contrat_achat`
--
ALTER TABLE `contrat_achat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`),
  ADD KEY `unite_mesure` (`unite_mesure`),
  ADD KEY `fournisseur` (`fournisseur`);

--
-- Indexes for table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `devise`
--
ALTER TABLE `devise`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `documents_joindre`
--
ALTER TABLE `documents_joindre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `departement` (`departement`),
  ADD KEY `nationalite` (`nationalite`),
  ADD KEY `employe_ibfk_2` (`equipe`),
  ADD KEY `FK4722E6AE5412D7C` (`nationalite`);

--
-- Indexes for table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipe_ibfk_1` (`superviseur`);

--
-- Indexes for table `fabrication_lots`
--
ALTER TABLE `fabrication_lots`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`),
  ADD KEY `usine` (`usine`),
  ADD KEY `magasin` (`magasin`);

--
-- Indexes for table `famille_consommables`
--
ALTER TABLE `famille_consommables`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type_fournisseur` (`type_fournisseur`);

--
-- Indexes for table `items_debours`
--
ALTER TABLE `items_debours`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`),
  ADD KEY `type_calcule` (`type_calcule`);

--
-- Indexes for table `localite`
--
ALTER TABLE `localite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `localite_ibfk_1` (`sous_prefecture`);

--
-- Indexes for table `magasin`
--
ALTER TABLE `magasin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `localite` (`localite`),
  ADD KEY `FK316698AAE1B557F2` (`localite`);

--
-- Indexes for table `marque`
--
ALTER TABLE `marque`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`);

--
-- Indexes for table `nationalite`
--
ALTER TABLE `nationalite`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `parc_auto`
--
ALTER TABLE `parc_auto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `type_parc_auto` (`type_parc_auto`);

--
-- Indexes for table `periode_embarquement`
--
ALTER TABLE `periode_embarquement`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `port`
--
ALTER TABLE `port`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `prefecture`
--
ALTER TABLE `prefecture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `region` (`region`);

--
-- Indexes for table `producteur`
--
ALTER TABLE `producteur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `nationalite` (`nationalite`);

--
-- Indexes for table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD KEY `sac_brousse` (`sac_brousse`),
  ADD KEY `sac_export` (`sac_export`);

--
-- Indexes for table `profile_utilisateur`
--
ALTER TABLE `profile_utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `qualite`
--
ALTER TABLE `qualite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`);

--
-- Indexes for table `reception_produits`
--
ALTER TABLE `reception_produits`
  ADD PRIMARY KEY (`id`),
  ADD KEY `camion` (`camion`),
  ADD KEY `usine` (`usine`),
  ADD KEY `transporteur` (`transporteur`),
  ADD KEY `variete` (`variete`),
  ADD KEY `produit` (`produit`),
  ADD KEY `contrat_achat` (`contrat_achat`),
  ADD KEY `type_sac` (`type_sac`);

--
-- Indexes for table `region`
--
ALTER TABLE `region`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK67AB2498848833D` (`sous_prefecture`),
  ADD KEY `FK67AB24985674125` (`port_destination`),
  ADD KEY `region` (`region`),
  ADD KEY `prefecture` (`prefecture`);

--
-- Indexes for table `societe`
--
ALTER TABLE `societe`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sous_prefecture`
--
ALTER TABLE `sous_prefecture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `prefecture` (`prefecture`);

--
-- Indexes for table `superviseur`
--
ALTER TABLE `superviseur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKBFF3F4DD5412D7C` (`nationalite`);

--
-- Indexes for table `transitaire`
--
ALTER TABLE `transitaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transporteur`
--
ALTER TABLE `transporteur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_calcule`
--
ALTER TABLE `type_calcule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_client`
--
ALTER TABLE `type_client`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_contrat`
--
ALTER TABLE `type_contrat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_format`
--
ALTER TABLE `type_format`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_fournisseur`
--
ALTER TABLE `type_fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_mvmt_parc_auto`
--
ALTER TABLE `type_mvmt_parc_auto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_mvmt_stock`
--
ALTER TABLE `type_mvmt_stock`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_parc_auto`
--
ALTER TABLE `type_parc_auto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type_sac`
--
ALTER TABLE `type_sac`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unite_mesure`
--
ALTER TABLE `unite_mesure`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usine`
--
ALTER TABLE `usine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `localite` (`localite`),
  ADD KEY `FK6A69C82E1B557F2` (`localite`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKDD163383705E2C17` (`profile`);

--
-- Indexes for table `variete`
--
ALTER TABLE `variete`
  ADD PRIMARY KEY (`id`),
  ADD KEY `produit` (`produit`);

--
-- Indexes for table `zone`
--
ALTER TABLE `zone`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `analyse`
--
ALTER TABLE `analyse`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `appariel_traitement`
--
ALTER TABLE `appariel_traitement`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `assurance`
--
ALTER TABLE `assurance`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `chargeur`
--
ALTER TABLE `chargeur`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `compagnie_maritime`
--
ALTER TABLE `compagnie_maritime`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `consommables_pieces`
--
ALTER TABLE `consommables_pieces`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `contrat_achat`
--
ALTER TABLE `contrat_achat`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `departement`
--
ALTER TABLE `departement`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `devise`
--
ALTER TABLE `devise`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `documents_joindre`
--
ALTER TABLE `documents_joindre`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `equipe`
--
ALTER TABLE `equipe`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fabrication_lots`
--
ALTER TABLE `fabrication_lots`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `famille_consommables`
--
ALTER TABLE `famille_consommables`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fournisseur`
--
ALTER TABLE `fournisseur`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `items_debours`
--
ALTER TABLE `items_debours`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `localite`
--
ALTER TABLE `localite`
  MODIFY `id` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `magasin`
--
ALTER TABLE `magasin`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `marque`
--
ALTER TABLE `marque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `nationalite`
--
ALTER TABLE `nationalite`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `periode_embarquement`
--
ALTER TABLE `periode_embarquement`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `port`
--
ALTER TABLE `port`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `prefecture`
--
ALTER TABLE `prefecture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `producteur`
--
ALTER TABLE `producteur`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `profile_utilisateur`
--
ALTER TABLE `profile_utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `qualite`
--
ALTER TABLE `qualite`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reception_produits`
--
ALTER TABLE `reception_produits`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `region`
--
ALTER TABLE `region`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `route`
--
ALTER TABLE `route`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `societe`
--
ALTER TABLE `societe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `sous_prefecture`
--
ALTER TABLE `sous_prefecture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `superviseur`
--
ALTER TABLE `superviseur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transitaire`
--
ALTER TABLE `transitaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transporteur`
--
ALTER TABLE `transporteur`
  MODIFY `id` int(7) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_calcule`
--
ALTER TABLE `type_calcule`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_client`
--
ALTER TABLE `type_client`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_contrat`
--
ALTER TABLE `type_contrat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_format`
--
ALTER TABLE `type_format`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_fournisseur`
--
ALTER TABLE `type_fournisseur`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `type_mvmt_parc_auto`
--
ALTER TABLE `type_mvmt_parc_auto`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_mvmt_stock`
--
ALTER TABLE `type_mvmt_stock`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_parc_auto`
--
ALTER TABLE `type_parc_auto`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_sac`
--
ALTER TABLE `type_sac`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `unite_mesure`
--
ALTER TABLE `unite_mesure`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usine`
--
ALTER TABLE `usine`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `variete`
--
ALTER TABLE `variete`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `zone`
--
ALTER TABLE `zone`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `analyse`
--
ALTER TABLE `analyse`
  ADD CONSTRAINT `analyse_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`);

--
-- Constraints for table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`type_client`) REFERENCES `type_client` (`id`);

--
-- Constraints for table `consommables_pieces`
--
ALTER TABLE `consommables_pieces`
  ADD CONSTRAINT `consommables_pieces_ibfk_1` FOREIGN KEY (`famille`) REFERENCES `famille_consommables` (`id`),
  ADD CONSTRAINT `consommables_pieces_ibfk_2` FOREIGN KEY (`type_format`) REFERENCES `type_format` (`id`);

--
-- Constraints for table `contrat_achat`
--
ALTER TABLE `contrat_achat`
  ADD CONSTRAINT `contrat_achat_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `contrat_achat_ibfk_2` FOREIGN KEY (`unite_mesure`) REFERENCES `unite_mesure` (`id`),
  ADD CONSTRAINT `contrat_achat_ibfk_3` FOREIGN KEY (`fournisseur`) REFERENCES `fournisseur` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`departement`) REFERENCES `departement` (`id`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`equipe`) REFERENCES `equipe` (`id`),
  ADD CONSTRAINT `employee_ibfk_3` FOREIGN KEY (`nationalite`) REFERENCES `nationalite` (`id`);

--
-- Constraints for table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`superviseur`) REFERENCES `employee` (`id`);

--
-- Constraints for table `fabrication_lots`
--
ALTER TABLE `fabrication_lots`
  ADD CONSTRAINT `fabrication_lots_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `fabrication_lots_ibfk_2` FOREIGN KEY (`usine`) REFERENCES `usine` (`id`),
  ADD CONSTRAINT `fabrication_lots_ibfk_3` FOREIGN KEY (`magasin`) REFERENCES `magasin` (`id`);

--
-- Constraints for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD CONSTRAINT `fournisseur_ibfk_1` FOREIGN KEY (`type_fournisseur`) REFERENCES `type_fournisseur` (`id`);

--
-- Constraints for table `items_debours`
--
ALTER TABLE `items_debours`
  ADD CONSTRAINT `items_debours_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `items_debours_ibfk_2` FOREIGN KEY (`type_calcule`) REFERENCES `type_calcule` (`id`);

--
-- Constraints for table `localite`
--
ALTER TABLE `localite`
  ADD CONSTRAINT `localite_ibfk_1` FOREIGN KEY (`sous_prefecture`) REFERENCES `sous_prefecture` (`id`);

--
-- Constraints for table `magasin`
--
ALTER TABLE `magasin`
  ADD CONSTRAINT `magasin_ibfk_1` FOREIGN KEY (`localite`) REFERENCES `localite` (`id`);

--
-- Constraints for table `marque`
--
ALTER TABLE `marque`
  ADD CONSTRAINT `marque_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`);

--
-- Constraints for table `parc_auto`
--
ALTER TABLE `parc_auto`
  ADD CONSTRAINT `parc_auto_ibfk_1` FOREIGN KEY (`type_parc_auto`) REFERENCES `type_parc_auto` (`id`);

--
-- Constraints for table `prefecture`
--
ALTER TABLE `prefecture`
  ADD CONSTRAINT `prefecture_ibfk_1` FOREIGN KEY (`region`) REFERENCES `region` (`id`);

--
-- Constraints for table `producteur`
--
ALTER TABLE `producteur`
  ADD CONSTRAINT `producteur_ibfk_1` FOREIGN KEY (`nationalite`) REFERENCES `nationalite` (`id`);

--
-- Constraints for table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`sac_brousse`) REFERENCES `type_sac` (`id`),
  ADD CONSTRAINT `produit_ibfk_2` FOREIGN KEY (`sac_export`) REFERENCES `type_sac` (`id`);

--
-- Constraints for table `qualite`
--
ALTER TABLE `qualite`
  ADD CONSTRAINT `qualite_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`);

--
-- Constraints for table `reception_produits`
--
ALTER TABLE `reception_produits`
  ADD CONSTRAINT `reception_produits_ibfk_1` FOREIGN KEY (`camion`) REFERENCES `parc_auto` (`id`),
  ADD CONSTRAINT `reception_produits_ibfk_2` FOREIGN KEY (`usine`) REFERENCES `usine` (`id`),
  ADD CONSTRAINT `reception_produits_ibfk_3` FOREIGN KEY (`transporteur`) REFERENCES `transporteur` (`id`),
  ADD CONSTRAINT `reception_produits_ibfk_4` FOREIGN KEY (`variete`) REFERENCES `variete` (`id`),
  ADD CONSTRAINT `reception_produits_ibfk_5` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`),
  ADD CONSTRAINT `reception_produits_ibfk_6` FOREIGN KEY (`contrat_achat`) REFERENCES `contrat_achat` (`id`),
  ADD CONSTRAINT `reception_produits_ibfk_7` FOREIGN KEY (`type_sac`) REFERENCES `type_sac` (`id`);

--
-- Constraints for table `route`
--
ALTER TABLE `route`
  ADD CONSTRAINT `FK67AB24985674125` FOREIGN KEY (`port_destination`) REFERENCES `port` (`id`),
  ADD CONSTRAINT `FK67AB2498848833D` FOREIGN KEY (`sous_prefecture`) REFERENCES `sous_prefecture` (`id`),
  ADD CONSTRAINT `route_ibfk_1` FOREIGN KEY (`region`) REFERENCES `region` (`id`),
  ADD CONSTRAINT `route_ibfk_2` FOREIGN KEY (`prefecture`) REFERENCES `prefecture` (`id`);

--
-- Constraints for table `sous_prefecture`
--
ALTER TABLE `sous_prefecture`
  ADD CONSTRAINT `sous_prefecture_ibfk_1` FOREIGN KEY (`prefecture`) REFERENCES `prefecture` (`id`);

--
-- Constraints for table `superviseur`
--
ALTER TABLE `superviseur`
  ADD CONSTRAINT `FKBFF3F4DD5412D7C` FOREIGN KEY (`nationalite`) REFERENCES `nationalite` (`id`);

--
-- Constraints for table `usine`
--
ALTER TABLE `usine`
  ADD CONSTRAINT `usine_ibfk_1` FOREIGN KEY (`localite`) REFERENCES `localite` (`id`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FKDD163383705E2C17` FOREIGN KEY (`profile`) REFERENCES `profile_utilisateur` (`id`);

--
-- Constraints for table `variete`
--
ALTER TABLE `variete`
  ADD CONSTRAINT `variete_ibfk_1` FOREIGN KEY (`produit`) REFERENCES `produit` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
