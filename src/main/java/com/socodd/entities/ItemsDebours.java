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
 * ItemsDebours generated by hbm2java
 */
@Entity
@Table(name = "items_debours", catalog = "db_socodd")
public class ItemsDebours implements java.io.Serializable {

	private Integer id;
	private TypeCalcule typeCalcule;
	private Produit produit;
	private String code;
	private boolean modifiable;
	private float valeur;
	private int ordre;

	public ItemsDebours() {
	}

	public ItemsDebours(TypeCalcule typeCalcule, Produit produit, String code, boolean modifiable, float valeur,
			int ordre) {
		this.typeCalcule = typeCalcule;
		this.produit = produit;
		this.code = code;
		this.modifiable = modifiable;
		this.valeur = valeur;
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
	@JoinColumn(name = "type_calcule", nullable = false)
	public TypeCalcule getTypeCalcule() {
		return this.typeCalcule;
	}

	public void setTypeCalcule(TypeCalcule typeCalcule) {
		this.typeCalcule = typeCalcule;
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

	@Column(name = "modifiable", nullable = false)
	public boolean isModifiable() {
		return this.modifiable;
	}

	public void setModifiable(boolean modifiable) {
		this.modifiable = modifiable;
	}

	@Column(name = "valeur", nullable = false, precision = 12, scale = 0)
	public float getValeur() {
		return this.valeur;
	}

	public void setValeur(float valeur) {
		this.valeur = valeur;
	}

	@Column(name = "ordre", nullable = false)
	public int getOrdre() {
		return this.ordre;
	}

	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}

}
