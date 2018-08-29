package com.socodd.entities;
// Generated 25 ao�t 2018 14:31:28 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Analyse generated by hbm2java
 */
@Entity
@Table(name = "analyse", catalog = "db_socodd")
public class Analyse implements java.io.Serializable {

	private Integer id;
	private Produit produit;
	private String code;
	private String nom;
	private String abrege;
	private boolean ecranLot;
	private boolean ecranReception;
	private boolean etatLot;
	private boolean etatReception;
	private String formuleCalcul;
	private float norme;
	private int ordre;

	public Analyse() {
	}

	public Analyse(Produit produit, String code, String nom, String abrege, boolean ecranLot, boolean ecranReception,
			boolean etatLot, boolean etatReception, String formuleCalcul, float norme, int ordre) {
		this.produit = produit;
		this.code = code;
		this.nom = nom;
		this.abrege = abrege;
		this.ecranLot = ecranLot;
		this.ecranReception = ecranReception;
		this.etatLot = etatLot;
		this.etatReception = etatReception;
		this.formuleCalcul = formuleCalcul;
		this.norme = norme;
		this.ordre = ordre;
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
	@JoinColumn(name = "produit", nullable = false)
	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Column(name = "code", nullable = false, length = 5)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "abrege", nullable = false, length = 50)
	public String getAbrege() {
		return this.abrege;
	}

	public void setAbrege(String abrege) {
		this.abrege = abrege;
	}

	@Column(name = "ecran_lot", nullable = false)
	public boolean isEcranLot() {
		return this.ecranLot;
	}

	public void setEcranLot(boolean ecranLot) {
		this.ecranLot = ecranLot;
	}

	@Column(name = "ecran_reception", nullable = false)
	public boolean isEcranReception() {
		return this.ecranReception;
	}

	public void setEcranReception(boolean ecranReception) {
		this.ecranReception = ecranReception;
	}

	@Column(name = "etat_lot", nullable = false)
	public boolean isEtatLot() {
		return this.etatLot;
	}

	public void setEtatLot(boolean etatLot) {
		this.etatLot = etatLot;
	}

	@Column(name = "etat_reception", nullable = false)
	public boolean isEtatReception() {
		return this.etatReception;
	}

	public void setEtatReception(boolean etatReception) {
		this.etatReception = etatReception;
	}

	@Column(name = "formule_calcul", nullable = false, length = 100)
	public String getFormuleCalcul() {
		return this.formuleCalcul;
	}

	public void setFormuleCalcul(String formuleCalcul) {
		this.formuleCalcul = formuleCalcul;
	}

	@Column(name = "norme", nullable = false, precision = 12, scale = 0)
	public float getNorme() {
		return this.norme;
	}

	public void setNorme(float norme) {
		this.norme = norme;
	}

	@Column(name = "ordre", nullable = false)
	public int getOrdre() {
		return this.ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

}
