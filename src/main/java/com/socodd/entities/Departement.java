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
 * Departement generated by hbm2java
 */
@Entity
@Table(name = "departement", catalog = "db_socodd")
public class Departement implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Departement() {
	}

	public Departement(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public Departement(String code, String nom, Set<Employee> employees) {
		this.code = code;
		this.nom = nom;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departement")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}