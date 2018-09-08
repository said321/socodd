package com.socodd.entities;
// Generated 7 sept. 2018 13:04:21 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ReceptionProduits generated by hbm2java
 */
@Entity
@Table(name = "reception_produits", catalog = "db_socodd")
public class ReceptionProduits implements java.io.Serializable {

	private Integer id;
	private Variete variete;
	private Fournisseur fournisseur;
	private ContratAchat contratAchat;
	private ParcAuto parcAuto;
	private Transporteur transporteur;
	private TypeSac typeSac;
	private Usine usine;
	private Produit produit;
	private int numBon;
	private String reference;
	private int chauffeur;
	private Date dateReception;
	private int numConnaissement;

	public ReceptionProduits() {
	}

	public ReceptionProduits(Variete variete, Fournisseur fournisseur, ContratAchat contratAchat, ParcAuto parcAuto,
			Transporteur transporteur, TypeSac typeSac, Usine usine, Produit produit, int numBon, String reference,
			int chauffeur, Date dateReception, int numConnaissement) {
		this.variete = variete;
		this.fournisseur = fournisseur;
		this.contratAchat = contratAchat;
		this.parcAuto = parcAuto;
		this.transporteur = transporteur;
		this.typeSac = typeSac;
		this.usine = usine;
		this.produit = produit;
		this.numBon = numBon;
		this.reference = reference;
		this.chauffeur = chauffeur;
		this.dateReception = dateReception;
		this.numConnaissement = numConnaissement;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "variete", nullable = false)
	public Variete getVariete() {
		return this.variete;
	}

	public void setVariete(Variete variete) {
		this.variete = variete;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fournisseur", nullable = false)
	public Fournisseur getFournisseur() {
		return this.fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contrat_achat", nullable = false)
	public ContratAchat getContratAchat() {
		return this.contratAchat;
	}

	public void setContratAchat(ContratAchat contratAchat) {
		this.contratAchat = contratAchat;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "camion", nullable = false)
	public ParcAuto getParcAuto() {
		return this.parcAuto;
	}

	public void setParcAuto(ParcAuto parcAuto) {
		this.parcAuto = parcAuto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "transporteur", nullable = false)
	public Transporteur getTransporteur() {
		return this.transporteur;
	}

	public void setTransporteur(Transporteur transporteur) {
		this.transporteur = transporteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_sac", nullable = false)
	public TypeSac getTypeSac() {
		return this.typeSac;
	}

	public void setTypeSac(TypeSac typeSac) {
		this.typeSac = typeSac;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usine", nullable = false)
	public Usine getUsine() {
		return this.usine;
	}

	public void setUsine(Usine usine) {
		this.usine = usine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produit", nullable = false)
	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Column(name = "num_bon", nullable = false)
	public int getNumBon() {
		return this.numBon;
	}

	public void setNumBon(int numBon) {
		this.numBon = numBon;
	}

	@Column(name = "reference", nullable = false, length = 50)
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "chauffeur", nullable = false)
	public int getChauffeur() {
		return this.chauffeur;
	}

	public void setChauffeur(int chauffeur) {
		this.chauffeur = chauffeur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_reception", nullable = false, length = 10)
	public Date getDateReception() {
		return this.dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}

	@Column(name = "num_connaissement", nullable = false)
	public int getNumConnaissement() {
		return this.numConnaissement;
	}

	public void setNumConnaissement(int numConnaissement) {
		this.numConnaissement = numConnaissement;
	}

}
