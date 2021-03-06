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
 * Usine generated by hbm2java
 */
@Entity
@Table(name = "usine", catalog = "db_socodd")
public class Usine implements java.io.Serializable {

	private Integer id;
	private Localite localite;
	private String code;
	private String nom;
	private float longitude;
	private float latitude;
	private Set<ReceptionProduits> receptionProduitses = new HashSet<ReceptionProduits>(0);
	private Set<FabricationLots> fabricationLotses = new HashSet<FabricationLots>(0);

	public Usine() {
	}

	public Usine(Localite localite, String code, String nom, float longitude, float latitude) {
		this.localite = localite;
		this.code = code;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Usine(Localite localite, String code, String nom, float longitude, float latitude,
			Set<ReceptionProduits> receptionProduitses, Set<FabricationLots> fabricationLotses) {
		this.localite = localite;
		this.code = code;
		this.nom = nom;
		this.longitude = longitude;
		this.latitude = latitude;
		this.receptionProduitses = receptionProduitses;
		this.fabricationLotses = fabricationLotses;
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
	@JoinColumn(name = "localite", nullable = false)
	public Localite getLocalite() {
		return this.localite;
	}

	public void setLocalite(Localite localite) {
		this.localite = localite;
	}

	@Column(name = "code", nullable = false, length = 50)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usine")
	public Set<ReceptionProduits> getReceptionProduitses() {
		return this.receptionProduitses;
	}

	public void setReceptionProduitses(Set<ReceptionProduits> receptionProduitses) {
		this.receptionProduitses = receptionProduitses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usine")
	public Set<FabricationLots> getFabricationLotses() {
		return this.fabricationLotses;
	}

	public void setFabricationLotses(Set<FabricationLots> fabricationLotses) {
		this.fabricationLotses = fabricationLotses;
	}

}
