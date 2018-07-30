package com.socodd.entities;
// Generated 30 juil. 2018 14:57:08 by Hibernate Tools 3.6.0.Final

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
 * Nationalite generated by hbm2java
 */
@Entity
@Table(name = "nationalite", catalog = "db_socodd")
public class Nationalite implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private Set<Superviseur> superviseurs = new HashSet<Superviseur>(0);
	private Set<Producteur> producteurs = new HashSet<Producteur>(0);
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Nationalite() {
	}

	public Nationalite(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public Nationalite(String code, String nom, Set<Superviseur> superviseurs, Set<Producteur> producteurs,
			Set<Employee> employees) {
		this.code = code;
		this.nom = nom;
		this.superviseurs = superviseurs;
		this.producteurs = producteurs;
		this.employees = employees;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nationalite")
	public Set<Superviseur> getSuperviseurs() {
		return this.superviseurs;
	}

	public void setSuperviseurs(Set<Superviseur> superviseurs) {
		this.superviseurs = superviseurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nationalite")
	public Set<Producteur> getProducteurs() {
		return this.producteurs;
	}

	public void setProducteurs(Set<Producteur> producteurs) {
		this.producteurs = producteurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "nationalite")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
