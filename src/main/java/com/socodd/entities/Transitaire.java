package com.socodd.entities;
// Generated 7 sept. 2018 13:04:21 by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Transitaire generated by hbm2java
 */
@Entity
@Table(name = "transitaire", catalog = "db_socodd")
public class Transitaire implements java.io.Serializable {

	private Integer id;
	private String code;
	private String adresse;
	private String nom;
	private String email;
	private String telephone;
	private String fax;
	private int numAgrement;
	private int numCC;
	private int numCompteTiers;
	private int numRccm;

	public Transitaire() {
	}

	public Transitaire(String code, String adresse, String nom, String email, String telephone, String fax,
			int numAgrement, int numCC, int numCompteTiers, int numRccm) {
		this.code = code;
		this.adresse = adresse;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.fax = fax;
		this.numAgrement = numAgrement;
		this.numCC = numCC;
		this.numCompteTiers = numCompteTiers;
		this.numRccm = numRccm;
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

	@Column(name = "code", nullable = false, length = 9)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "adresse", nullable = false)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telephone", nullable = false, length = 10)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "fax", nullable = false, length = 10)
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name = "num_agrement", nullable = false)
	public int getNumAgrement() {
		return this.numAgrement;
	}

	public void setNumAgrement(int numAgrement) {
		this.numAgrement = numAgrement;
	}

	@Column(name = "num_c_c", nullable = false)
	public int getNumCC() {
		return this.numCC;
	}

	public void setNumCC(int numCC) {
		this.numCC = numCC;
	}

	@Column(name = "num_compte_tiers", nullable = false)
	public int getNumCompteTiers() {
		return this.numCompteTiers;
	}

	public void setNumCompteTiers(int numCompteTiers) {
		this.numCompteTiers = numCompteTiers;
	}

	@Column(name = "num_rccm", nullable = false)
	public int getNumRccm() {
		return this.numRccm;
	}

	public void setNumRccm(int numRccm) {
		this.numRccm = numRccm;
	}

}
