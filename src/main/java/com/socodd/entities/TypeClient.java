package com.socodd.entities;
// Generated 25 ao�t 2018 14:31:28 by Hibernate Tools 3.6.0.Final

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
 * TypeClient generated by hbm2java
 */
@Entity
@Table(name = "type_client", catalog = "db_socodd")
public class TypeClient implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private Set<Client> clients = new HashSet<Client>(0);

	public TypeClient() {
	}

	public TypeClient(String code, String nom) {
		this.code = code;
		this.nom = nom;
	}

	public TypeClient(String code, String nom, Set<Client> clients) {
		this.code = code;
		this.nom = nom;
		this.clients = clients;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "typeClient")
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
