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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Prefecture generated by hbm2java
 */
@Entity
@Table(name = "prefecture", catalog = "db_socodd")
public class Prefecture implements java.io.Serializable {

	private Integer id;
	private Region region;
	private String code;
	private String nom;
	private float longitude;
	private float latitude;
	private Set<SousPrefecture> sousPrefectures = new HashSet<SousPrefecture>(0);

	public Prefecture() {
	}

	public Prefecture(Region region, String code, String nom, float longitude, float latitude) {
		this.region = region;
		this.code = code;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Prefecture(Region region, String code, String nom, float longitude, float latitude,
			Set<SousPrefecture> sousPrefectures) {
		this.region = region;
		this.code = code;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.sousPrefectures = sousPrefectures;
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
	@JoinColumn(name = "region", nullable = false)
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
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

	@Column(name = "longitude", nullable = false, precision = 12, scale = 0)
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Column(name = "latitude", nullable = false, precision = 12, scale = 0)
	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prefecture")
	public Set<SousPrefecture> getSousPrefectures() {
		return this.sousPrefectures;
	}

	public void setSousPrefectures(Set<SousPrefecture> sousPrefectures) {
		this.sousPrefectures = sousPrefectures;
	}

}