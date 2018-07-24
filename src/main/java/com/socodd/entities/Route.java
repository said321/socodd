package com.socodd.entities;
// Generated 21 juil. 2018 07:15:20 by Hibernate Tools 5.1.7.Final

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
 * Route generated by hbm2java
 */
@Entity
@Table(name = "route", catalog = "db_socodd")
public class Route implements java.io.Serializable {

	private Integer id;
	private Port port;
	private SousPrefecture sousPrefecture;
	private String code;
	private int region;
	private int prefecture;
	private float coutTkm;
	private float prixEntreeUsine;

	public Route() {
	}

	public Route(Port port, SousPrefecture sousPrefecture, String code, int region, int prefecture, float coutTkm,
			float prixEntreeUsine) {
		this.port = port;
		this.sousPrefecture = sousPrefecture;
		this.code = code;
		this.region = region;
		this.prefecture = prefecture;
		this.coutTkm = coutTkm;
		this.prixEntreeUsine = prixEntreeUsine;
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
	@JoinColumn(name = "port_destination", nullable = false)
	public Port getPort() {
		return this.port;
	}

	public void setPort(Port port) {
		this.port = port;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sous_prefecture", nullable = false)
	public SousPrefecture getSousPrefecture() {
		return this.sousPrefecture;
	}

	public void setSousPrefecture(SousPrefecture sousPrefecture) {
		this.sousPrefecture = sousPrefecture;
	}

	@Column(name = "code", nullable = false, length = 8)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "region", nullable = false)
	public int getRegion() {
		return this.region;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	@Column(name = "prefecture", nullable = false)
	public int getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(int prefecture) {
		this.prefecture = prefecture;
	}

	@Column(name = "cout_tkm", nullable = false, precision = 12, scale = 0)
	public float getCoutTkm() {
		return this.coutTkm;
	}

	public void setCoutTkm(float coutTkm) {
		this.coutTkm = coutTkm;
	}

	@Column(name = "prix_entree_usine", nullable = false, precision = 12, scale = 0)
	public float getPrixEntreeUsine() {
		return this.prixEntreeUsine;
	}

	public void setPrixEntreeUsine(float prixEntreeUsine) {
		this.prixEntreeUsine = prixEntreeUsine;
	}

}
