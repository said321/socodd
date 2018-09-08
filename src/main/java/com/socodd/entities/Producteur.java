package com.socodd.entities;
// Generated 7 sept. 2018 13:04:21 by Hibernate Tools 3.6.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Producteur generated by hbm2java
 */
@Entity
@Table(name = "producteur", catalog = "db_socodd")
public class Producteur implements java.io.Serializable {

	private Integer id;
	private Nationalite nationalite;
	private String code;
	private String nom;
	private String adresse;
	private String telephone;
	private String fax;
	private String email;
	private Date dateNaissance;
	private Date lieuNaissance;
	private String pere;
	private String mere;
	private int nbEnfants;
	private int nbFemme;
	private Date dateEntree;
	private int referencePiece;
	private String photo;
	private String sexe;

	public Producteur() {
	}

	public Producteur(Nationalite nationalite, String code, String nom, String adresse, String telephone, String fax,
			String email, Date dateNaissance, Date lieuNaissance, String pere, String mere, int nbEnfants, int nbFemme,
			Date dateEntree, int referencePiece, String photo, String sexe) {
		this.nationalite = nationalite;
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.pere = pere;
		this.mere = mere;
		this.nbEnfants = nbEnfants;
		this.nbFemme = nbFemme;
		this.dateEntree = dateEntree;
		this.referencePiece = referencePiece;
		this.photo = photo;
		this.sexe = sexe;
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
	@JoinColumn(name = "nationalite", nullable = false)
	public Nationalite getNationalite() {
		return this.nationalite;
	}

	public void setNationalite(Nationalite nationalite) {
		this.nationalite = nationalite;
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

	@Column(name = "adresse", nullable = false, length = 65535)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
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

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance", nullable = false, length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "lieu_naissance", nullable = false, length = 10)
	public Date getLieuNaissance() {
		return this.lieuNaissance;
	}

	public void setLieuNaissance(Date lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	@Column(name = "pere", nullable = false, length = 50)
	public String getPere() {
		return this.pere;
	}

	public void setPere(String pere) {
		this.pere = pere;
	}

	@Column(name = "mere", nullable = false, length = 50)
	public String getMere() {
		return this.mere;
	}

	public void setMere(String mere) {
		this.mere = mere;
	}

	@Column(name = "nb_enfants", nullable = false)
	public int getNbEnfants() {
		return this.nbEnfants;
	}

	public void setNbEnfants(int nbEnfants) {
		this.nbEnfants = nbEnfants;
	}

	@Column(name = "nb_femme", nullable = false)
	public int getNbFemme() {
		return this.nbFemme;
	}

	public void setNbFemme(int nbFemme) {
		this.nbFemme = nbFemme;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_entree", nullable = false, length = 10)
	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	@Column(name = "reference_piece", nullable = false)
	public int getReferencePiece() {
		return this.referencePiece;
	}

	public void setReferencePiece(int referencePiece) {
		this.referencePiece = referencePiece;
	}

	@Column(name = "photo", nullable = false, length = 200)
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "sexe", nullable = false, length = 10)
	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

}
