package com.socodd.entities;
// Generated 25 ao�t 2018 14:31:28 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PeriodeEmbarquement generated by hbm2java
 */
@Entity
@Table(name = "periode_embarquement", catalog = "db_socodd")
public class PeriodeEmbarquement implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;

	public PeriodeEmbarquement() {
	}

	public PeriodeEmbarquement(String code, String nom) {
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

	@Column(name = "code", nullable = false, length = 2)
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
