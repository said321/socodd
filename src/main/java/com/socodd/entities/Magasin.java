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
 * Magasin generated by hbm2java
 */
@Entity
@Table(name = "magasin", catalog = "db_socodd")
public class Magasin implements java.io.Serializable {

	private Integer id;
	private Localite localite;
	private String code;
	private int nom;

	public Magasin() {
	}

	public Magasin(Localite localite, String code, int nom) {
		this.localite = localite;
		this.code = code;
		this.nom = nom;
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
	@JoinColumn(name = "localite", nullable = false)
	public Localite getLocalite() {
		return this.localite;
	}

	public void setLocalite(Localite localite) {
		this.localite = localite;
	}

	@Column(name = "code", nullable = false, length = 5)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "nom", nullable = false)
	public int getNom() {
		return this.nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

}
