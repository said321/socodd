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
 * ConsommablesPieces generated by hbm2java
 */
@Entity
@Table(name = "consommables_pieces", catalog = "db_socodd")
public class ConsommablesPieces implements java.io.Serializable {

	private Integer id;
	private FamilleConsommables familleConsommables;
	private TypeFormat typeFormat;
	private String code;
	private String refInterne;
	private String refFournisseur;
	private String nom;
	private float PUAchat;
	private float PUVente;
	private float stockSeuil;

	public ConsommablesPieces() {
	}

	public ConsommablesPieces(FamilleConsommables familleConsommables, TypeFormat typeFormat, String code,
			String refInterne, String refFournisseur, String nom, float PUAchat, float PUVente, float stockSeuil) {
		this.familleConsommables = familleConsommables;
		this.typeFormat = typeFormat;
		this.code = code;
		this.refInterne = refInterne;
		this.refFournisseur = refFournisseur;
		this.nom = nom;
		this.PUAchat = PUAchat;
		this.PUVente = PUVente;
		this.stockSeuil = stockSeuil;
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
	@JoinColumn(name = "famille", nullable = false)
	public FamilleConsommables getFamilleConsommables() {
		return this.familleConsommables;
	}

	public void setFamilleConsommables(FamilleConsommables familleConsommables) {
		this.familleConsommables = familleConsommables;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_format", nullable = false)
	public TypeFormat getTypeFormat() {
		return this.typeFormat;
	}

	public void setTypeFormat(TypeFormat typeFormat) {
		this.typeFormat = typeFormat;
	}

	@Column(name = "code", nullable = false, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "ref_interne", nullable = false, length = 50)
	public String getRefInterne() {
		return this.refInterne;
	}

	public void setRefInterne(String refInterne) {
		this.refInterne = refInterne;
	}

	@Column(name = "ref_fournisseur", nullable = false, length = 50)
	public String getRefFournisseur() {
		return this.refFournisseur;
	}

	public void setRefFournisseur(String refFournisseur) {
		this.refFournisseur = refFournisseur;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "p_u_achat", nullable = false, precision = 12, scale = 0)
	public float getPUAchat() {
		return this.PUAchat;
	}

	public void setPUAchat(float PUAchat) {
		this.PUAchat = PUAchat;
	}

	@Column(name = "p_u_vente", nullable = false, precision = 12, scale = 0)
	public float getPUVente() {
		return this.PUVente;
	}

	public void setPUVente(float PUVente) {
		this.PUVente = PUVente;
	}

	@Column(name = "stock_seuil", nullable = false, precision = 12, scale = 0)
	public float getStockSeuil() {
		return this.stockSeuil;
	}

	public void setStockSeuil(float stockSeuil) {
		this.stockSeuil = stockSeuil;
	}

}
