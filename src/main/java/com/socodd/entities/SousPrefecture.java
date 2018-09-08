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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SousPrefecture generated by hbm2java
 */
@Entity
@Table(name = "sous_prefecture", catalog = "db_socodd")
public class SousPrefecture implements java.io.Serializable {

	private Integer id;
	private Prefecture prefecture;
	private String code;
	private String nom;
	private float latitude;
	private float longitude;
	private Set<Route> routes = new HashSet<Route>(0);
	private Set<Localite> localites = new HashSet<Localite>(0);

	public SousPrefecture() {
	}

	public SousPrefecture(Prefecture prefecture, String code, String nom, float latitude, float longitude) {
		this.prefecture = prefecture;
		this.code = code;
		this.nom = nom;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public SousPrefecture(Prefecture prefecture, String code, String nom, float latitude, float longitude,
			Set<Route> routes, Set<Localite> localites) {
		this.prefecture = prefecture;
		this.code = code;
		this.nom = nom;
		this.latitude = latitude;
		this.longitude = longitude;
		this.routes = routes;
		this.localites = localites;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "prefecture", nullable = false)
	public Prefecture getPrefecture() {
		return this.prefecture;
	}

	public void setPrefecture(Prefecture prefecture) {
		this.prefecture = prefecture;
	}

	@Column(name = "code", nullable = false, length = 6)
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

	@Column(name = "latitude", nullable = false, precision = 12, scale = 0)
	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude", nullable = false, precision = 12, scale = 0)
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sousPrefecture")
	public Set<Route> getRoutes() {
		return this.routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sousPrefecture")
	public Set<Localite> getLocalites() {
		return this.localites;
	}

	public void setLocalites(Set<Localite> localites) {
		this.localites = localites;
	}

}
