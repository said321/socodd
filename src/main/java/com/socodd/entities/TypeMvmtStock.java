package com.socodd.entities;
// Generated 30 juil. 2018 14:57:08 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TypeMvmtStock generated by hbm2java
 */
@Entity
@Table(name = "type_mvmt_stock", catalog = "db_socodd")
public class TypeMvmtStock implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;

	public TypeMvmtStock() {
	}

	public TypeMvmtStock(String code, String nom) {
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
