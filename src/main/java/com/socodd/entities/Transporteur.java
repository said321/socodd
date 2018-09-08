package com.socodd.entities;
// Generated 7 sept. 2018 13:04:21 by Hibernate Tools 3.6.0.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transporteur generated by hbm2java
 */
@Entity
@Table(name = "transporteur", catalog = "db_socodd")
public class Transporteur implements java.io.Serializable {

	private Integer id;
	private String code;
	private String nom;
	private String adresse;
	private String telephone;
	private String fax;
	private String email;
	private Date dateEntree;
	private int numCompteTiers;
	private int numCC;
	private int numRccm;
	private int numAgrement;
	private String importBic;
	private Set<ReceptionProduits> receptionProduitses = new HashSet<ReceptionProduits>(0);

	public Transporteur() {
	}

	public Transporteur(String code, String nom, String adresse, String telephone, String fax, String email,
			Date dateEntree, int numCompteTiers, int numCC, int numRccm, int numAgrement, String importBic) {
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.dateEntree = dateEntree;
		this.numCompteTiers = numCompteTiers;
		this.numCC = numCC;
		this.numRccm = numRccm;
		this.numAgrement = numAgrement;
		this.importBic = importBic;
	}

	public Transporteur(String code, String nom, String adresse, String telephone, String fax, String email,
			Date dateEntree, int numCompteTiers, int numCC, int numRccm, int numAgrement, String importBic,
			Set<ReceptionProduits> receptionProduitses) {
		this.code = code;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.email = email;
		this.dateEntree = dateEntree;
		this.numCompteTiers = numCompteTiers;
		this.numCC = numCC;
		this.numRccm = numRccm;
		this.numAgrement = numAgrement;
		this.importBic = importBic;
		this.receptionProduitses = receptionProduitses;
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

	@Column(name = "code", nullable = false, length = 9)
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
	@Column(name = "date_entree", nullable = false, length = 10)
	public Date getDateEntree() {
		return this.dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}

	@Column(name = "num_compte_tiers", nullable = false)
	public int getNumCompteTiers() {
		return this.numCompteTiers;
	}

	public void setNumCompteTiers(int numCompteTiers) {
		this.numCompteTiers = numCompteTiers;
	}

	@Column(name = "num_c_c", nullable = false)
	public int getNumCC() {
		return this.numCC;
	}

	public void setNumCC(int numCC) {
		this.numCC = numCC;
	}

	@Column(name = "num_rccm", nullable = false)
	public int getNumRccm() {
		return this.numRccm;
	}

	public void setNumRccm(int numRccm) {
		this.numRccm = numRccm;
	}

	@Column(name = "num_agrement", nullable = false)
	public int getNumAgrement() {
		return this.numAgrement;
	}

	public void setNumAgrement(int numAgrement) {
		this.numAgrement = numAgrement;
	}

	@Column(name = "import_bic", nullable = false, length = 50)
	public String getImportBic() {
		return this.importBic;
	}

	public void setImportBic(String importBic) {
		this.importBic = importBic;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transporteur")
	public Set<ReceptionProduits> getReceptionProduitses() {
		return this.receptionProduitses;
	}

	public void setReceptionProduitses(Set<ReceptionProduits> receptionProduitses) {
		this.receptionProduitses = receptionProduitses;
	}

}
