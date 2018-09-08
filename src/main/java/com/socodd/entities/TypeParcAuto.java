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
 * TypeParcAuto generated by hbm2java
 */
@Entity
@Table(name = "type_parc_auto", catalog = "db_socodd")
public class TypeParcAuto implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private Set<ParcAuto> parcAutos = new HashSet<ParcAuto>(0);

	public TypeParcAuto() {
	}

	public TypeParcAuto(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public TypeParcAuto(String code, String nom, Set<ParcAuto> parcAutos) {
		this.code = code;
		this.nom = nom;
		this.parcAutos = parcAutos;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeParcAuto")
	public Set<ParcAuto> getParcAutos() {
		return this.parcAutos;
	}

	public void setParcAutos(Set<ParcAuto> parcAutos) {
		this.parcAutos = parcAutos;
	}

}
