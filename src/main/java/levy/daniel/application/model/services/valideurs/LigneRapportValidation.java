package levy.daniel.application.model.services.valideurs;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;


/**
 * class LigneRapportValidation :<br/>
 * Pure fabrication encapsulant tous les éléments 
 * d'information relatifs à un contrôle (validation d'une RG).<br/>
 * <br/>
 * Une LigneRapportValidation encapsule : <br/>
 * "id;nom de la RG;Résultat de la Validation;
 * Message d'Erreur du contrôle;Actif;
 * activité des contrôles sur l'attribut;activité de la RG;
 * clé du type de contrôle;type de contrôle;Message d'erreur;
 * Objet Métier concerné;Attribut concerné;
 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 30 août 2017
 *
 */
public class LigneRapportValidation 
	implements Serializable, Comparable<LigneRapportValidation>, Cloneable
				, IExportateurCsv, IExportateurJTable {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	public static final String VIRGULE_ESPACE = ", ";
	
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";
	
	
	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	private Long id;

	
	/**
	 * nomRG : String :<br/>
	 * nom de la RG (exemple RG-Client-01 : 
	 * le nom du client doit être renseigné).<br/>
	 */
	private transient String nomRG;

	
	/**
	 * resultatValidationRG : String :<br/>
	 * résultat de la validation de la RG (OK, KO, sans objet).<br/>
	 */
	private String resultatValidationRG;

	
	/**
	 * messageErreurValidation : String :<br/>
	 * Message utilisateur en cas de violation de la RG.<br/>
	 */
	private String messageErreurValidation;


	/**
	 * ligneRG : LigneRG :<br/>
	 * Encapsulation des éléments relatifs à la RG 
	 * concernée par la présente ligne de rapport.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 */
	private LigneRG ligneRG;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(LigneRapportValidation.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR LigneRapportValidation() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LigneRapportValidation() {
		this(null, null, null, null);
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

		
	 /**
	 * method CONSTRUCTEUR LigneRapportValidation(CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * <br/>
	 *
	 * @param pResultatValidationRG : String : 
	 * résultat de la validation de la RG (OK, KO, sans objet).<br/>
	 * @param pMessageErreurValidation : String : 
	 * Message utilisateur en cas de violation de la RG.<br/>
	 * @param pLigneRG : LigneRG : 
	 * Encapsulation des éléments relatifs à la RG 
	 * concernée par la présente ligne de rapport.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 */
	public LigneRapportValidation(
			final String pResultatValidationRG
			, final String pMessageErreurValidation
			, final LigneRG pLigneRG) {
		
		this(null
				, pResultatValidationRG
				, pMessageErreurValidation
				, pLigneRG);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LigneRapportValidation(
	 * Long pId
	 * , String pResultatValidationRG
	 * , String pMessageErreurValidation
	 * , LigneRG pLigneRG) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * Constructeur passant tous les attributs de l'objet 
	 * y compris l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pResultatValidationRG : String : 
	 * résultat de la validation de la RG (OK, KO, sans objet).<br/>
	 * @param pMessageErreurValidation : String : 
	 * Message utilisateur en cas de violation de la RG.<br/>
	 * @param pLigneRG : LigneRG : 
	 * Encapsulation des éléments relatifs à la RG 
	 * concernée par la présente ligne de rapport.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 */
	public LigneRapportValidation(
			final Long pId
			, final String pResultatValidationRG
			, final String pMessageErreurValidation
			, final LigneRG pLigneRG) {
		
		super();
		
		this.id = pId;
		this.resultatValidationRG = pResultatValidationRG;
		this.messageErreurValidation = pMessageErreurValidation;
		this.ligneRG = pLigneRG;
		
		this.rafraichirNomRG();
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



	/**
	 * method rafraichirNomRG() :<br/>
	 * Recalcule this.nomRG à chaque modification de this.ligneRG.<br/>
	 * <br/>
	 */
	private void rafraichirNomRG() {
		
		if (this.ligneRG != null) {
			this.nomRG = this.ligneRG.getNomRG();
		}
		else {
			this.nomRG = null;
		}
		
	} // Fin de rafraichirNomRG()._________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result 
				+ ((this.id == null) ? 0 : this.id.hashCode());
		result = prime * result 
				+ ((this.ligneRG == null) ? 0 : this.ligneRG.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(
			final Object pObj) {
		
		if (this == pObj) {
			return true;
		}
		
		if (pObj == null) {
			return false;
		}
		
		if (!(pObj instanceof LigneRapportValidation)) {
			return false;
		}
		
		final LigneRapportValidation other = (LigneRapportValidation) pObj;
		
		/* id. */
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		
		/* ligneRG. */
		if (this.ligneRG == null) {
			if (other.ligneRG != null) {
				return false;
			}
		} else if (!this.ligneRG.equals(other.ligneRG)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final LigneRapportValidation pLigneRapport) {
		
		if (this == pLigneRapport) {
			return 0;
		}
		
		if (pLigneRapport == null) {
			return -1;
		}
		
		int compareId = 0;
		int compareLigneRG = 0;
		
		/* id. */
		if (this.getId() == null) {
			if (pLigneRapport.getId() != null) {
				return +1;
			}
		} else {
			
			if (pLigneRapport.getId() == null) {
				return -1;
			}
			
			compareId = this.getId().compareTo(pLigneRapport.getId());
			
			if (compareId != 0) {
				return compareId;
			}
		}
		
		
		/* ligneRG. */
		if (this.getLigneRG() == null) {
			if (pLigneRapport.getLigneRG() != null) {
				return +1;
			}
			
			return 0;
		}
		
		if (pLigneRapport.getLigneRG() == null) {
			return -1;
		}
		
		compareLigneRG 
			= this.getLigneRG().compareTo(pLigneRapport.getLigneRG());
		
		return compareLigneRG;
		
	} // Fin de compareTo(...).____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public LigneRapportValidation clone() 
			throws CloneNotSupportedException {
		
		final LigneRapportValidation ligneClone 
			= (LigneRapportValidation) super.clone();
		
		ligneClone.setId(this.getId());
		ligneClone.setResultatValidationRG(this.getResultatValidationRG());
		ligneClone
			.setMessageErreurValidation(this.getMessageErreurValidation());
		
		/* Clonage profond. */
		if (this.getLigneRG() != null) {
			final LigneRG ligneRGClone = this.getLigneRG().clone();
			ligneClone.setLigneRG(ligneRGClone);
		} else {
			ligneClone.setLigneRG(null);
		}
		
		return ligneClone;
		
	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * <br/>
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("LigneRapportValidation [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.nomRG != null) {
			builder.append("nomRG=");
			builder.append(this.nomRG);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.resultatValidationRG != null) {
			builder.append("resultatValidationRG=");
			builder.append(this.resultatValidationRG);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.messageErreurValidation != null) {
			builder.append("messageErreurValidation=");
			builder.append(this.messageErreurValidation);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.ligneRG != null) {
			
			builder.append("RG active=");
			builder.append(this.ligneRG.getActif());			
			builder.append(VIRGULE_ESPACE);
			
			builder.append("activiteControleAttribut=");
			builder.append(this.ligneRG.getActiviteControleAttribut());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("activiteRG=");
			builder.append(this.ligneRG.getActiviteRG());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("typeControleInt=");			
			builder.append(this.ligneRG.getTypeControleInt());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("typeControle=");
			builder.append(this.ligneRG.getTypeControle());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("messageRG=");
			builder.append(this.ligneRG.getMessageRG());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("nomObjetMetier=");
			builder.append(this.ligneRG.getNomObjetMetier());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("nomAttributObjetMetier=");
			builder.append(this.ligneRG.getNomAttributObjetMetier());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("classeControle=");
			builder.append(this.ligneRG.getClasseControle());
			builder.append(VIRGULE_ESPACE);
			
			builder.append("methodeControle=");
			builder.append(this.ligneRG.getMethodeControle());
			
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________



	/**
	 * method getEnTeteCsv() :<br/>
	 * Retourne l'en-tête pour les fichiers csv avec séparateur ';'.<br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * <br/>
	 *
	 * @return : String : en-tête pour les fichiers csv.<br/>
	 */
//	@Transient
	@Override
	public String getEnTeteCsv() {
		
		return "id;nom de la RG;Résultat de la Validation;"
				+ "Message d'Erreur du contrôle;Actif;"
				+ "activité des contrôles sur l'attribut;activité de la RG;"
				+ "clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;";
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * method toStringCsv() :<br/>
	 * LigneRG sous forme de Csv avec séparateur ';'.<br/>
	 * <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * <br/>
	 *
	 * @return : String : LigneRG sous forme de Csv 
	 * avec séparateur ';'.<br/>
	 */
	@Override
	public String toStringCsv() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append(this.id);
		builder.append(POINT_VIRGULE);
		builder.append(this.nomRG);
		builder.append(POINT_VIRGULE);
		builder.append(this.resultatValidationRG);
		builder.append(POINT_VIRGULE);
		builder.append(this.messageErreurValidation);
		builder.append(POINT_VIRGULE);
		
		if (this.ligneRG != null) {
			
			builder.append(this.ligneRG.getActif());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getActiviteControleAttribut());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getActiviteRG());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getTypeControleInt());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getTypeControle());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getMessageRG());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getNomObjetMetier());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getNomAttributObjetMetier());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getClasseControle());
			builder.append(POINT_VIRGULE);
			builder.append(this.ligneRG.getMethodeControle());
			builder.append(POINT_VIRGULE);
			
		} else {
			
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			builder.append(NULL);
			builder.append(POINT_VIRGULE);
			
		}
		
		return builder.toString();
		
	} // Fin de toStringCsv()._____________________________________________
	
	

	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * <br/>
	 */
//	@Transient
	@Override
	public String getEnTeteColonne(
			final int pI) {
		
		String entete = null;
		
		switch (pI) {
		
		case 0:
			entete = "id";
			break;
			
		case 1:
			entete = "nom de la RG";
			break;
			
		case 2:
			entete = "Résultat de la Validation";
			break;
			
		case 3:
			entete = "Message d'Erreur du contrôle";
			break;
			
		case 4:
			entete = "Actif";
			break;
			
		case 5:
			entete = "activité des contrôles sur l'attribut";
			break;
			
		case 6:
			entete = "activité de la RG";
			break;
			
		case 7:
			entete = "clé du type de contrôle";
			break;
			
		case 8:
			entete = "type de contrôle";
			break;
			
		case 9:
			entete = "Message d'erreur";
			break;
			
		case 10:
			entete = "Objet Métier concerné";
			break;
			
		case 11:
			entete = "Attribut concerné";
			break;
			
		case 12:
			entete = "Classe implémentant la RG";
			break;
			
		case 13:
			entete = "Méthode implémentant la RG";
			break;
			
		default:
			entete = "invalide";
			break;
		
		} // Fin du Switch._________________________________
		
		return entete;
		
	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * <br/>
	 */
//	@Transient
	@Override
	public Object getValeurColonne(
			final int pI) {
			
		Object valeur = null;
		
		switch (pI) {
		
		case 0:
			valeur = this.id;
			break;

		case 1:
			valeur = this.nomRG;
			break;

		case 2:
			valeur = this.resultatValidationRG;
			break;
			
		case 3:
			valeur = this.messageErreurValidation;
			break;
			
		case 4:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getActif();
			} 		
			break;
			
		case 5:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getActiviteControleAttribut();
			}
			break;
			
		case 6:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getActiviteRG();
			}
			break;
			
		case 7:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getTypeControleInt();
			}	
			break;
			
		case 8:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getTypeControle();
			}	
			break;
			
		case 9:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getMessageRG();
			}	
			break;
			
		case 10:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getNomObjetMetier();
			}
			break;
			
		case 11:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getNomAttributObjetMetier();
			}
			break;

		case 12:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getClasseControle();
			}	
			break;

		case 13:
			if (this.ligneRG != null) {
				valeur = this.ligneRG.getMethodeControle();
			}
			break;

		default:
			valeur = "invalide";
			break;	
			
		} // Fin du Switch._________________________________
		
		return valeur;
		
	} // Fin de getValeurColonne(...)._____________________________________


	
	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________


	
	/**
	 * method getNomRG() :<br/>
	 * Getter du nom de la RG (exemple RG-Client-01 : 
	 * le nom du client doit être renseigné).<br/>
	 * <br/>
	 *
	 * @return nomRG : String.<br/>
	 */
	public String getNomRG() {
		return this.nomRG;
	} // Fin de getNomRG().________________________________________________


	
	/**
	 * method getResultatValidationRG() :<br/>
	 * Getter du résultat de la validation de la RG 
	 * (OK, KO, sans objet).<br/>
	 * <br/>
	 *
	 * @return resultatValidationRG : String.<br/>
	 */
	public String getResultatValidationRG() {
		return this.resultatValidationRG;
	} // Fin de getResultatValidationRG()._________________________________



	
	/**
	* method setResultatValidationRG(
	* String pResultatValidationRG) :<br/>
	* Setter du résultat de la validation de la RG 
	* (OK, KO, sans objet).<br/>
	* <br/>
	*
	* @param pResultatValidationRG : String : 
	* valeur à passer à resultatValidationRG.<br/>
	*/
	public void setResultatValidationRG(
			final String pResultatValidationRG) {
		this.resultatValidationRG = pResultatValidationRG;
	} // Fin de setResultatValidationRG(String).___________________________


	
	/**
	 * method getMessageErreurValidation() :<br/>
	 * Getter du Message utilisateur en cas de violation de la RG.<br/>
	 * <br/>
	 *
	 * @return messageErreurValidation : String.<br/>
	 */
	public String getMessageErreurValidation() {
		return this.messageErreurValidation;
	} // Fin de getMessageErreurValidation().______________________________


	
	/**
	* method setMessageErreurValidation(
	* String pMessageErreurValidation) :<br/>
	* Setter du Message utilisateur en cas de violation de la RG.<br/>
	* <br/>
	*
	* @param pMessageErreurValidation : String : 
	* valeur à passer à messageErreurValidation.<br/>
	*/
	public void setMessageErreurValidation(
			final String pMessageErreurValidation) {
		this.messageErreurValidation = pMessageErreurValidation;
	} // Fin de setMessageErreurValidation(...).___________________________


	
	/**
	 * method getLigneRG() :<br/>
	 * Getter de l'Encapsulation des éléments relatifs à la RG 
	 * concernée par la présente ligne de rapport.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @return ligneRG : LigneRG.<br/>
	 */
	public LigneRG getLigneRG() {
		return this.ligneRG;
	} // Fin de getLigneRG().______________________________________________


	
	/**
	* method setLigneRG(
	* LigneRG pLigneRG) :<br/>
	* Setter de l'Encapsulation des éléments relatifs à la RG 
	* concernée par la présente ligne de rapport.<br/>
	* - Rafraichit this.nomRG.<br/>
	* <br/>
	* Une LigneRG encapsule :<br/>
	* [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	* ;RG implémentée;clé du type de contrôle;type de contrôle
	* ;Message d'erreur;Objet Métier concerné;Attribut concerné
	* ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	* <br/>
	*
	* @param pLigneRG : LigneRG : valeur à passer à ligneRG.<br/>
	*/
	public void setLigneRG(
			final LigneRG pLigneRG) {
		this.ligneRG = pLigneRG;
		this.rafraichirNomRG();
	} // Fin de setLigneRG(...).___________________________________________


	
} // FIN DE LA CLASSE LigneRapportValidation.--------------------------------
