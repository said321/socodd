package com.socodd.entities;
// Generated 7 sept. 2018 13:04:21 by Hibernate Tools 3.6.0.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypeFournisseur generated by hbm2java
 */
@Entity
@Table(name = "type_fournisseur", catalog = "db_socodd")
public class TypeFournisseur implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private Set<Fournisseur> fournisseurs = new HashSet<Fournisseur>(0);

	public TypeFournisseur() {
	}

	public TypeFournisseur(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public TypeFournisseur(String code, String nom, Set<Fournisseur> fournisseurs) {
		this.code = code;
		this.nom = nom;
		this.fournisseurs = fournisseurs;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeFournisseur")
	public Set<Fournisseur> getFournisseurs() {
		return this.fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

}
