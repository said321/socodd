package com.socodd.entities;
// Generated 21 juil. 2018 07:15:20 by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Devise generated by hbm2java
 */
@Entity
@Table(name = "devise", catalog = "db_socodd")
public class Devise implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private float monnaieLocale;

	public Devise() {
	}

	public Devise(String code, String nom, float monnaieLocale) {
		this.code = code;
		this.nom = nom;
		this.monnaieLocale = monnaieLocale;
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

	@Column(name = "monnaie_locale", nullable = false, precision = 12, scale = 0)
	public float getMonnaieLocale() {
		return this.monnaieLocale;
	}

	public void setMonnaieLocale(float monnaieLocale) {
		this.monnaieLocale = monnaieLocale;
	}

}
