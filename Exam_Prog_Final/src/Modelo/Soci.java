package Modelo;

public class Soci {
	private int id;
	private String nom;
	private String cognom;
	private String dni;
	private String domicili;
	private String localitat;
	private String tipusSoci;
	private float importQuota;

	public final static String[] TIPUS = {"A","B","C"};
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicili() {
		return domicili;
	}

	public void setDomicili(String domicili) {
		this.domicili = domicili;
	}

	public String getLocalitat() {
		return localitat;
	}

	public void setLocalitat(String localitat) {
		this.localitat = localitat;
	}

	public String getTipusSoci() {
		return tipusSoci;
	}

	public void setTipusSoci(String tipusSoci) {
		this.tipusSoci = tipusSoci;
	}

	public float getImportQuota() {
		return importQuota;
	}

	public void setImportQuota(float importQuota) {
		this.importQuota = importQuota;
	}

	public Soci() {
		
	}

}
