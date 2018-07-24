package com.socodd.entities;
// Generated 21 juil. 2018 07:15:20 by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Chargeur generated by hbm2java
 */
@Entity
@Table(name = "chargeur", catalog = "db_socodd")
public class Chargeur implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;

	public Chargeur() {
	}

	public Chargeur(String code, String nom) {
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

}
