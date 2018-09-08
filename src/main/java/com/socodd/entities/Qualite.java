package com.socodd.entities;
// Generated 7 sept. 2018 13:04:21 by Hibernate Tools 3.6.0.Final

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
 * Qualite generated by hbm2java
 */
@Entity
@Table(name = "qualite", catalog = "db_socodd")
public class Qualite implements java.io.Serializable {

	private Integer id;
	private Produit produit;
	private int code;
	private String nom;
	private String abrege;
	private int ordre;
	private float prixAchat;
	private float PUVteProvisoire;
	private float PUVteDefinitif;

	public Qualite() {
	}

	public Qualite(Produit produit, int code, String nom, String abrege, int ordre, float prixAchat,
			float PUVteProvisoire, float PUVteDefinitif) {
		this.produit = produit;
		this.code = code;
		this.nom = nom;
		this.abrege = abrege;
		this.ordre = ordre;
		this.prixAchat = prixAchat;
		this.PUVteProvisoire = PUVteProvisoire;
		this.PUVteDefinitif = PUVteDefinitif;
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

	@Column(name = "code", nullable = false)
	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
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

	@Column(name = "ordre", nullable = false)
	public int getOrdre() {
		return this.ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

	@Column(name = "prix_achat", nullable = false, precision = 12, scale = 0)
	public float getPrixAchat() {
		return this.prixAchat;
	}

	public void setPrixAchat(float prixAchat) {
		this.prixAchat = prixAchat;
	}

	@Column(name = "p_u_vte_provisoire", nullable = false, precision = 12, scale = 0)
	public float getPUVteProvisoire() {
		return this.PUVteProvisoire;
	}

	public void setPUVteProvisoire(float PUVteProvisoire) {
		this.PUVteProvisoire = PUVteProvisoire;
	}

	@Column(name = "p_u_vte_definitif", nullable = false, precision = 12, scale = 0)
	public float getPUVteDefinitif() {
		return this.PUVteDefinitif;
	}

	public void setPUVteDefinitif(float PUVteDefinitif) {
		this.PUVteDefinitif = PUVteDefinitif;
	}

}
