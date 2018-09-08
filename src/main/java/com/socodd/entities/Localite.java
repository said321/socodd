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
 * Localite generated by hbm2java
 */
@Entity
@Table(name = "localite", catalog = "db_socodd")
public class Localite implements java.io.Serializable {

	private Integer id;
	private SousPrefecture sousPrefecture;
	private String code;
	private String nom;
	private float longitude;
	private float latitude;
	private Set<Usine> usines = new HashSet<Usine>(0);
	private Set<Magasin> magasins = new HashSet<Magasin>(0);

	public Localite() {
	}

	public Localite(SousPrefecture sousPrefecture, String code, String nom, float longitude, float latitude) {
		this.sousPrefecture = sousPrefecture;
		this.code = code;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Localite(SousPrefecture sousPrefecture, String code, String nom, float longitude, float latitude,
			Set<Usine> usines, Set<Magasin> magasins) {
		this.sousPrefecture = sousPrefecture;
		this.code = code;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.usines = usines;
		this.magasins = magasins;
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
	@JoinColumn(name = "sous_prefecture", nullable = false)
	public SousPrefecture getSousPrefecture() {
		return this.sousPrefecture;
	}

	public void setSousPrefecture(SousPrefecture sousPrefecture) {
		this.sousPrefecture = sousPrefecture;
	}

	@Column(name = "code", nullable = false, length = 8)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localite")
	public Set<Usine> getUsines() {
		return this.usines;
	}

	public void setUsines(Set<Usine> usines) {
		this.usines = usines;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "localite")
	public Set<Magasin> getMagasins() {
		return this.magasins;
	}

	public void setMagasins(Set<Magasin> magasins) {
		this.magasins = magasins;
	}

}
