package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.IExportateurCsv;
import levy.daniel.application.apptechnic.configurationmanagers.IExportateurJTable;

/**
 * class LigneRG :<br/>
 * Pure fabrication encapsulant tous les éléments 
 * d'information relatifs à une Règle de Gestion (RG).<br/>
 * <br/>
 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
 * ;RG implémentée;clé du type de contrôle;type de contrôle
 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
 * ;Classe implémentant la RG;Méthode implémentant la RG;
 * properties;clé;].<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Règle de Gestion, RG, contrôle, controle,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 août 2017
 *
 */
public class LigneRG 
		implements Serializable, Comparable<LigneRG>, Cloneable
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
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	private Long id;

	
	/**
	 * actif : Boolean :<br/>
	 * Boolean qui stipule si ce contrôle de RG est actif.<br/>
	 * vaut toujours activiteControleAttribut && activiteRG.<br/>
	 */
	private transient Boolean actif;

	
	/**
	 * activiteControleAttribut : Boolean :<br/>
	 * Boolean qui stipule si l'ensemble des contrôles des RG 
	 * s'appliquant à l'attribut s'appliquent.<br/>
	 */
	private Boolean activiteControleAttribut;

	
	/**
	 * activiteRG : Boolean :<br/>
	 * Boolean qui stipule si le contrôle de la présente RG 
	 * s'applique pour l'attribut.<br/>
	 */
	private Boolean activiteRG;

	
	/**
	 * nomRG : String :<br/>
	 * nom de la RG (exemple RG-Client-01 : 
	 * le nom du client doit être renseigné).<br/>
	 */
	private String nomRG;

	
	/**
	 * typeControleInt : Integer :<br/>
	 * clé numérique du type de contrôle 
	 * (1-nullité, 2-format, ...).<br/>
	 */
	private Integer typeControleInt;

	
	/**
	 * typeControle : String :<br/>
	 * type de contrôle (nullité, format, ...).<br/>
	 */
	private transient String typeControle;

	
	/**
	 * messageRG : String :<br/>
	 * Message d'erreur lorsque la RG est violée.<br/>
	 * Par exemple 'Le nom n'est pas renseigné (obligatoire).'.<br/>
	 */
	private String messageRG;

	
	/**
	 * nomObjetMetier : String :<br/>
	 * Nom de l'objet métier contenant l'attribut sur lequel 
	 * s'applique la présente RG.<br/>
	 * Par exemple Client, Commande, ...<br/>
	 */
	private String nomObjetMetier;

	
	/**
	 * nomAttributObjetMetier : String :<br/>
	 * Nom de l'attribut de l'objet métier sur lequel 
	 * s'applique la RG.<br/>
	 * Par exemple nom du client, prénom du client, ...<br/>
	 */
	private String nomAttributObjetMetier;

	
	/**
	 * classeControle : String :<br/>
	 * nom de la classe implémentant le contrôle de la RG.<br/>
	 */
	private String classeControle;

	
	/**
	 * methodeControle : String :<br/>
	 * méthode implémentant le contrôle de la RG.<br/>
	 */
	private String methodeControle;

	
	/**
	 * fichierProperties : String :<br/>
	 * Nom du fichier properties dans lequel est implémenté 
	 * le contrôle de la RG.<br/>
	 * Par exemple, fichier externe 
	 * "/ressources_externes/rg_fr_FR.properties".<br/>
	 */
	private String fichierProperties;
	
	
	/**
	 * cleDansProperties : String :<br/>
	 * Clé du Boolean d'activation du contrôle de la RG dans le properties.<br/>
	 * Par exemple : "interrogationmeteo.pays.rginterropays02.actif".<br/>
	 */
	private String cleDansProperties;

	
	/**
	 * mapTypesControle : Map&lt;Integer,String&gt; :<br/>
	 * Map contenant les types de contrôle avec :
	 * <ul>
	 * <li>Integer : clé numérique du type de contrôle(1, 2, ...)</li>
	 * <li>String : label du type de contrôle (nullité, format, ...).</li>
	 * </ul>
	 */
	private static transient Map<Integer, String> mapTypesControle 
		= new ConcurrentHashMap<Integer, String>();

	
static {
	mapTypesControle.put(1, "nullité");
	mapTypesControle.put(2, "format");
	mapTypesControle.put(3, "fourchette [Min-Max]");
	mapTypesControle.put(4, "nomenclature");
	mapTypesControle.put(5, "valeur par défaut");
	mapTypesControle.put(6, "longueur");
	mapTypesControle.put(7, "expression régulière (Regex)");
}


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(LigneRG.class);


	// *************************METHODES************************************/
	

	
	 /**
	 * method CONSTRUCTEUR LigneRG() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LigneRG() {
		
		this(null
				, null, null, null
				, null, null, null, null, null, null, null, null);
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LigneRG(CONSTRUCTEUR COMPLET) :<br/>
	 * CONSTRUCTEUR COMPLET.<br/>
	 * Constructeur passant tous les attributs de l'objet 
	 * sauf l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pActiviteControleAttribut : Boolean : Boolean qui stipule 
	 * si l'ensemble des contrôles des RG s'appliquant 
	 * à l'attribut s'appliquent.<br/>
	 * @param pActiviteRG : Boolean : Boolean qui stipule 
	 * si le contrôle de la présente RG s'applique pour l'attribut.<br/>
	 * @param pNomRG : String : nom de la RG 
	 * (exemple RG-Client-01 : le nom du client doit être renseigné).<br/>
	 * @param pTypeControleInt : Integer : clé numérique 
	 * du type de contrôle (1-nullité, 2-format, ...).<br/>
	 * @param pMessageRG : String : Message d'erreur 
	 * lorsque la RG est violée.<br/>
	 * Par exemple 'Le nom n'est pas renseigné (obligatoire).'.<br/>
	 * @param pNomObjetMetier : String : Nom de l'objet métier 
	 * contenant l'attribut sur lequel s'applique la présente RG.<br/>
	 * Par exemple Client, Commande, ...<br/>
	 * @param pNomAttributObjetMetier : String : 
	 * Nom de l'attribut de l'objet métier 
	 * sur lequel s'applique la RG.<br/>
	 * Par exemple nom du client, prénom du client, ...<br/>
	 * @param pClasseControle : String : nom de la classe implémentant 
	 * le contrôle de la RG.<br/>
	 * @param pMethodeControle : String : méthode implémentant 
	 * le contrôle de la RG.<br/>
	 * @param pFichierProperties : String : Nom du fichier properties 
	 * dans lequel est implémenté le contrôle de la RG.<br/>
	 * @param pCleDansProperties : String : Clé du Boolean d'activation 
	 * du contrôle de la RG dans le properties.<br/>
	 */
	public LigneRG(
			final Boolean pActiviteControleAttribut
			, final Boolean pActiviteRG
			, final String pNomRG
			, final Integer pTypeControleInt
			, final String pMessageRG
			, final String pNomObjetMetier
			, final String pNomAttributObjetMetier
			, final String pClasseControle
			, final String pMethodeControle
			, final String pFichierProperties
			, final String pCleDansProperties) {
		
		this(null
				, pActiviteControleAttribut, pActiviteRG
				, pNomRG, pTypeControleInt, pMessageRG
				, pNomObjetMetier, pNomAttributObjetMetier
				, pClasseControle, pMethodeControle
				, pFichierProperties, pCleDansProperties);
		
	} // Fin de CONSTRUCTEUR COMPLET.______________________________________
	
	
	
	 /**
	 * method CONSTRUCTEUR LigneRG(CONSTRUCTEUR COMPLET BASE) :<br/>
	 * CONSTRUCTEUR COMPLET BASE.<br/>
	 * Constructeur passant tous les attributs de l'objet 
	 * y compris l'ID en base.<br/>
	 * <br/>
	 *
	 * @param pId : Long : ID en base.<br/>
	 * @param pActiviteControleAttribut : Boolean : Boolean qui stipule 
	 * si l'ensemble des contrôles des RG s'appliquant 
	 * à l'attribut s'appliquent.<br/>
	 * @param pActiviteRG : Boolean : Boolean qui stipule 
	 * si le contrôle de la présente RG s'applique pour l'attribut.<br/>
	 * @param pNomRG : String : nom de la RG 
	 * (exemple RG-Client-01 : le nom du client doit être renseigné).<br/>
	 * @param pTypeControleInt : Integer : clé numérique 
	 * du type de contrôle (1-nullité, 2-format, ...).<br/>
	 * @param pMessageRG : String : Message d'erreur lorsque 
	 * la RG est violée.<br/>
	 * Par exemple 'Le nom n'est pas renseigné (obligatoire).'.<br/>
	 * @param pNomObjetMetier : String : Nom de l'objet métier 
	 * contenant l'attribut sur lequel s'applique la présente RG.<br/>
	 * Par exemple Client, Commande, ...<br/>
	 * @param pNomAttributObjetMetier : String : Nom de l'attribut 
	 * de l'objet métier sur lequel s'applique la RG.<br/>
	 * Par exemple nom du client, prénom du client, ...<br/>
	 * @param pClasseControle : String : nom de la classe implémentant 
	 * le contrôle de la RG.<br/>
	 * @param pMethodeControle : String : méthode implémentant 
	 * le contrôle de la RG.<br/>
	 * @param pFichierProperties : String : Nom du fichier properties 
	 * dans lequel est implémenté le contrôle de la RG.<br/>
	 * @param pCleDansProperties : String : Clé du Boolean d'activation 
	 * du contrôle de la RG dans le properties.<br/>
	 */
	public LigneRG(
			final Long pId
			, final Boolean pActiviteControleAttribut
			, final Boolean pActiviteRG
			, final String pNomRG
			, final Integer pTypeControleInt
			, final String pMessageRG
			, final String pNomObjetMetier
			, final String pNomAttributObjetMetier
			, final String pClasseControle
			, final String pMethodeControle
			, final String pFichierProperties
			, final String pCleDansProperties) {
		
		super();
		
		this.id = pId;
		this.activiteControleAttribut = pActiviteControleAttribut;
		this.activiteRG = pActiviteRG;
		this.rafraichirActif();	
		this.nomRG = pNomRG;
		this.typeControleInt = pTypeControleInt;
		this.typeControle = fournirTypeControle(this.typeControleInt);
		this.messageRG = pMessageRG;
		this.nomObjetMetier = pNomObjetMetier;
		this.nomAttributObjetMetier = pNomAttributObjetMetier;
		this.classeControle = pClasseControle;
		this.methodeControle = pMethodeControle;
		this.fichierProperties = pFichierProperties;
		this.cleDansProperties = pCleDansProperties;
		
	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________


	
	/**
	 * method rafraichirActif() :<br/>
	 * Recalcule la valeur de this.actif en fonction de la valeur 
	 * de this.activiteControleAttribut et de this.activiteRG.<br/>
	 * this.actif = this.activiteControleAttribut && this.activiteRG.<br/>
	 * <br/>
	 */
	private void rafraichirActif() {
		
		if (this.activiteControleAttribut != null 
				&& this.activiteRG != null) {
			
			this.actif = this.activiteControleAttribut && this.activiteRG;
			
		} else {
			this.actif = null;
		}	
		
	} // Fin de rafraichirActif()._________________________________________
	

	
	/**
	 * method fournirTypeControle(
	 * Integer pTypeControleInt) :<br/>
	 * <ul>
	 * <li>Retourne le type du contrôle (label) en fonction 
	 * de sa clé numérique.</li>
	 * <li>Par exemple, retourne 'nullité' pour '1'.</li>
	 * </ul>
	 * retourne null si pTypeControleInt == null.<br/>
	 * <br/>
	 *
	 * @param pTypeControleInt : Integer : 
	 * clé numérique du type de contrôle.<br/>
	 * 
	 * @return : String : type du contrôle (label).<br/>
	 */
	private String fournirTypeControle(
			final Integer pTypeControleInt) {
		
		/* retourne null si pTypeControleInt == null. */
		if (pTypeControleInt == null) {
			return null;
		}
		
		String resultat = null;
		
		resultat = mapTypesControle.get(pTypeControleInt);
		
		return resultat;
		
	} // Fin de fournirTypeControle(...).__________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		
		final int prime = 31;
		
		int result = 1;
		
		result = prime * result
				+ ((this.classeControle == null) 
						? 0 : this.classeControle.hashCode());
		result = prime * result 
				+ ((this.nomObjetMetier == null) 
						? 0 : this.nomObjetMetier.hashCode());
		result = prime * result 
				+ ((this.nomRG == null) ? 0 : this.nomRG.hashCode());
		result = prime * result 
				+ ((this.typeControleInt == null) 
						? 0 : this.typeControleInt.hashCode());
		
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
			
		if (this.getClass() != pObj.getClass()) {
			return false;
		}
			
		final LigneRG other = (LigneRG) pObj;

		/*nomRG. */
		if (this.nomRG == null) {
			if (other.nomRG != null) {
				return false;
			}				
		} else if (!this.nomRG.equals(other.nomRG)) {
			return false;
		}

		/* nomObjetMetier. */
		if (this.nomObjetMetier == null) {
			if (other.nomObjetMetier != null) {
				return false;
			}				
		} else if (!this.nomObjetMetier.equals(other.nomObjetMetier)) {
			return false;
		}
		
		/* classeControle. */
		if (this.classeControle == null) {
			if (other.classeControle != null) {
				return false;
			}				
		} else if (!this.classeControle.equals(other.classeControle)) {
			return false;
		}
			
		/* typeControleInt. */	
		if (this.typeControleInt == null) {
			if (other.typeControleInt != null) {
				return false;
			}				
		} else if (!this.typeControleInt.equals(other.typeControleInt)) {
			return false;
		}
			
		return true;
		
	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final LigneRG pLigneRG) {
		
		if (this == pLigneRG) {
			return 0;
		}
		
		if (pLigneRG == null) {
			return -1;
		}
				
		int compareNomObjetMetier = 0;
		int compareNomRG = 0;
		int compareClasseControle = 0;
		int compareTypeControleInt = 0;

		
		/*nomRG. */
		if (this.getNomRG() == null) {
			if (pLigneRG.getNomRG() != null) {
				return +1;
			}
		}
		else {
			
			if (pLigneRG.getNomRG() == null) {
				return -1;
			}
			
			compareNomRG 
			= this.getNomRG()
				.compareToIgnoreCase(pLigneRG.getNomRG());
		
			if (compareNomRG != 0) {
				return compareNomRG;
			}
		}
						
		/* nomObjetMetier. */
		if (this.getNomObjetMetier() == null) {
			if (pLigneRG.getNomObjetMetier() != null) {
				return +1;
			}
		} else {
			
			if (pLigneRG.getNomObjetMetier() == null) {
				return -1;
			}
			
			compareNomObjetMetier 
			= this.getNomObjetMetier()
				.compareToIgnoreCase(pLigneRG.getNomObjetMetier()); 
		
			if (compareNomObjetMetier != 0) {
				return compareNomObjetMetier;
			}
			
		}
						
		/* classeControle. */
		if (this.getClasseControle() == null) {
			if (pLigneRG.getClasseControle() != null) {
				return +1;
			}
		} else {
			
			if (pLigneRG.getClasseControle() == null) {
				return -1;
			}
			
			compareClasseControle 
			= this.getClasseControle()
				.compareToIgnoreCase(pLigneRG.getClasseControle());
		
			if (compareClasseControle != 0) {
				return compareClasseControle;
			}
		}
		
		
		/* typeControleInt. */
		if (this.getTypeControleInt() == null) {
			if (pLigneRG.getTypeControleInt() != null) {
				return +1;
			}
			return 0;
		}
		
		if (pLigneRG.getTypeControleInt() == null) {
			return -1;
		}
		
		compareTypeControleInt 
			= this.getTypeControleInt()
				.compareTo(pLigneRG.getTypeControleInt()); 
		
		return compareTypeControleInt;
		
	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public LigneRG clone() throws CloneNotSupportedException {
		
		final LigneRG ligneClone = (LigneRG) super.clone();
		
		ligneClone.setId(this.getId());
		ligneClone.setActiviteControleAttribut(
				this.getActiviteControleAttribut());
		ligneClone.setActiviteRG(this.getActiviteRG());
		ligneClone.setNomRG(this.getNomRG());
		ligneClone.setTypeControleInt(this.getTypeControleInt());
		ligneClone.setMessageRG(this.getMessageRG());
		ligneClone.setNomObjetMetier(this.getNomObjetMetier());
		ligneClone.setNomAttributObjetMetier(
				this.getNomAttributObjetMetier());
		ligneClone.setClasseControle(this.getClasseControle());
		ligneClone.setMethodeControle(this.getMethodeControle());
		ligneClone.setFichierProperties(this.getFichierProperties());
		ligneClone.setCleDansProperties(this.getCleDansProperties());
		
		return ligneClone;
		
	} // Fin de clone().___________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("LigneRG [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.actif != null) {
			builder.append("actif=");
			builder.append(this.actif);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.activiteControleAttribut != null) {
			builder.append("activiteControleAttribut=");
			builder.append(this.activiteControleAttribut);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.activiteRG != null) {
			builder.append("activiteRG=");
			builder.append(this.activiteRG);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.nomRG != null) {
			builder.append("nomRG=");
			builder.append(this.nomRG);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.typeControleInt != null) {
			builder.append("typeControleInt=");
			builder.append(this.typeControleInt);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.typeControle != null) {
			builder.append("typeControle=");
			builder.append(this.typeControle);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.messageRG != null) {
			builder.append("messageRG=");
			builder.append(this.messageRG);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.nomObjetMetier != null) {
			builder.append("nomObjetMetier=");
			builder.append(this.nomObjetMetier);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.nomAttributObjetMetier != null) {
			builder.append("nomAttributObjetMetier=");
			builder.append(this.nomAttributObjetMetier);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.classeControle != null) {
			builder.append("classeControle=");
			builder.append(this.classeControle);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.methodeControle != null) {
			builder.append("methodeControle=");
			builder.append(this.methodeControle);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.fichierProperties != null) {
			builder.append("properties=");
			builder.append(this.fichierProperties);
			builder.append(VIRGULE_ESPACE);
		}
		if (this.cleDansProperties != null) {
			builder.append("clé=");
			builder.append(this.cleDansProperties);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________


	/**
	 * method getEnTeteCsv() :<br/>
	 * Retourne l'en-tête pour les fichiers csv avec séparateur ';'.<br/>
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;".<br/>
	 * <br/>
	 *
	 * @return : String : en-tête pour les fichiers csv.<br/>
	 */
//	@Transient
	@Override
	public String getEnTeteCsv() {
		
		return "id;Actif;activité des contrôles sur l'attribut;"
				+ "activité de la RG;RG implémentée;clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;properties;clé;";
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * method toStringCsv() :<br/>
	 * LigneRG sous forme de Csv avec séparateur ';'.<br/>
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;".<br/>
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
		builder.append(this.actif);
		builder.append(POINT_VIRGULE);
		builder.append(this.activiteControleAttribut);
		builder.append(POINT_VIRGULE);
		builder.append(this.activiteRG);
		builder.append(POINT_VIRGULE);
		builder.append(this.nomRG);
		builder.append(POINT_VIRGULE);
		builder.append(this.typeControleInt);
		builder.append(POINT_VIRGULE);
		builder.append(this.typeControle);
		builder.append(POINT_VIRGULE);
		builder.append(this.messageRG);
		builder.append(POINT_VIRGULE);
		builder.append(this.nomObjetMetier);
		builder.append(POINT_VIRGULE);
		builder.append(this.nomAttributObjetMetier);
		builder.append(POINT_VIRGULE);
		builder.append(this.classeControle);
		builder.append(POINT_VIRGULE);
		builder.append(this.methodeControle);
		builder.append(POINT_VIRGULE);
		builder.append(this.fichierProperties);
		builder.append(POINT_VIRGULE);
		builder.append(this.cleDansProperties);
		builder.append(POINT_VIRGULE);
		
		return builder.toString();
		
	} // Fin de toStringCsv()._____________________________________________
	


	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;".<br/>
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
			entete = "Actif";
			break;
			
		case 2:
			entete = "activité des contrôles sur l'attribut";
			break;
			
		case 3:
			entete = "activité de la RG";
			break;
			
		case 4:
			entete = "RG implémentée";
			break;
			
		case 5:
			entete = "clé du type de contrôle";
			break;
			
		case 6:
			entete = "type de contrôle";
			break;
			
		case 7:
			entete = "Message d'erreur";
			break;
			
		case 8:
			entete = "Objet Métier concerné";
			break;
			
		case 9:
			entete = "Attribut concerné";
			break;
			
		case 10:
			entete = "Classe implémentant la RG";
			break;
			
		case 11:
			entete = "Méthode implémentant la RG";
			break;
			
		case 12:
			entete = "Properties";
			break;
			
		case 13:
			entete = "Clé";
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
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;".<br/>
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
			valeur = this.actif;
			break;

		case 2:
			valeur = this.activiteControleAttribut;
			break;
			
		case 3:
			valeur = this.activiteRG;
			break;
			
		case 4:
			valeur = this.nomRG;
			break;
			
		case 5:
			valeur = this.typeControleInt;
			break;
			
		case 6:
			valeur = this.typeControle;
			break;
			
		case 7:
			valeur = this.messageRG;
			break;
			
		case 8:
			valeur = this.nomObjetMetier;
			break;
			
		case 9:
			valeur = this.nomAttributObjetMetier;
			break;
			
		case 10:
			valeur = this.classeControle;
			break;
			
		case 11:
			valeur = this.methodeControle;
			break;
			
		case 12:
			valeur = this.fichierProperties;
			break;
			
		case 13:
			valeur = this.cleDansProperties;
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
	 * method getActif() :<br/>
	 * Getter du Boolean qui stipule si ce contrôle de RG est actif.<br/>
	 * vaut toujours activiteControleAttribut && activiteRG.<br/>
	 * <br/>
	 *
	 * @return actif : Boolean.<br/>
	 */
	public Boolean getActif() {
		return this.actif;
	} // Fin de getActif().________________________________________________


	
	/**
	 * method getActiviteControleAttribut() :<br/>
	 * Getter du Boolean qui stipule si l'ensemble des contrôles 
	 * des RG s'appliquant à l'attribut s'appliquent.<br/>
	 * <br/>
	 *
	 * @return activiteControleAttribut : Boolean.<br/>
	 */
	public Boolean getActiviteControleAttribut() {
		return this.activiteControleAttribut;
	} // Fin de getActiviteControleAttribut()._____________________________


	
	/**
	* method setActiviteControleAttribut(
	* Boolean pActiviteControleAttribut) :<br/>
	* Setter du Boolean qui stipule si l'ensemble des contrôles 
	* des RG s'appliquant à l'attribut s'appliquent.<br/>
	* Rafraîchit this.actif.<br/>
	* <br/>
	*
	* @param pActiviteControleAttribut : Boolean : 
	* valeur à passer à activiteControleAttribut.<br/>
	*/
	public void setActiviteControleAttribut(
			final Boolean pActiviteControleAttribut) {
		this.activiteControleAttribut = pActiviteControleAttribut;
		this.rafraichirActif();
	} // Fin de setActiviteControleAttribut(...).__________________________


	
	/**
	 * method getActiviteRG() :<br/>
	 * Getter du Boolean qui stipule si le contrôle de la présente RG 
	 * s'applique pour l'attribut.<br/>
	 * <br/>
	 *
	 * @return activiteRG : Boolean.<br/>
	 */
	public Boolean getActiviteRG() {
		return this.activiteRG;
	} // Fin de getActiviteRG().___________________________________________


	
	/**
	* method setActiviteRG(
	* Boolean pActiviteRG) :<br/>
	* Setter du Boolean qui stipule si le contrôle de la présente RG 
	* s'applique pour l'attribut.<br/>
	* Rafraîchit this.actif.<br/>
	* <br/>
	*
	* @param pActiviteRG : Boolean : valeur à passer à activiteRG.<br/>
	*/
	public void setActiviteRG(
			final Boolean pActiviteRG) {
		this.activiteRG = pActiviteRG;
		this.rafraichirActif();
	} // Fin de setActiviteRG(...).________________________________________


	
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
	* method setNomRG(
	* String pNomRG) :<br/>
	* Setter du nom de la RG (exemple RG-Client-01 : 
	* le nom du client doit être renseigné).<br/>
	* <br/>
	*
	* @param pNomRG : String : valeur à passer à nomRG.<br/>
	*/
	public void setNomRG(
			final String pNomRG) {
		this.nomRG = pNomRG;
	} // Fin de setNomRG(...)._____________________________________________


		
	/**
	 * method getTypeControleInt() :<br/>
	 * Getter de la clé numérique du type de contrôle 
	 * (1-nullité, 2-format, ...).<br/>
	 * <br/>
	 *
	 * @return typeControleInt : Integer.<br/>
	 */
	public Integer getTypeControleInt() {
		return this.typeControleInt;
	} // Fin de getTypeControleInt().______________________________________


	
	/**
	* method setTypeControleInt(
	* Integer pTypeControleInt) :<br/>
	* Setter de la clé numérique du type de contrôle (
	* 1-nullité, 2-format, ...).<br/>
	* rafraîchit this.typeControle.<br/>
	* <br/>
	*
	* @param pTypeControleInt : Integer : 
	* valeur à passer à typeControleInt.<br/>
	*/
	public void setTypeControleInt(
			final Integer pTypeControleInt) {
		this.typeControleInt = pTypeControleInt;
		this.typeControle = this.fournirTypeControle(this.typeControleInt);
	} // Fin de setTypeControleInt(...).___________________________________



	/**
	 * method getTypeControle() :<br/>
	 * Getter du type de contrôle (nullité, format, ...).<br/>
	 * <br/>
	 *
	 * @return typeControle : String.<br/>
	 */
	public String getTypeControle() {
		return this.typeControle;
	} // Fin de getTypeControle()._________________________________________



	/**
	 * method getMessageRG() :<br/>
	 * Getter du Message d'erreur lorsque la RG est violée.<br/>
	 * Par exemple 'Le nom n'est pas renseigné (obligatoire).'.<br/>
	 * <br/>
	 *
	 * @return messageRG : String.<br/>
	 */
	public String getMessageRG() {
		return this.messageRG;
	} // Fin de getMessageRG().____________________________________________



	
	/**
	* method setMessageRG(
	* String pMessageRG) :<br/>
	* Setter du Message d'erreur lorsque la RG est violée.<br/>
	* Par exemple 'Le nom n'est pas renseigné (obligatoire).'.<br/>
	* <br/>
	*
	* @param pMessageRG : String : valeur à passer à messageRG.<br/>
	*/
	public void setMessageRG(
			final String pMessageRG) {
		this.messageRG = pMessageRG;
	} // Fin de setMessageRG(...)._________________________________________


	
	/**
	 * method getNomObjetMetier() :<br/>
	 * Getter du Nom de l'objet métier contenant l'attribut 
	 * sur lequel s'applique la présente RG.<br/>
	 * Par exemple Client, Commande, ...<br/>
	 * <br/>
	 *
	 * @return nomObjetMetier : String.<br/>
	 */
	public String getNomObjetMetier() {
		return this.nomObjetMetier;
	} // Fin de getNomObjetMetier()._______________________________________


	
	/**
	* method setNomObjetMetier(
	* String pNomObjetMetier) :<br/>
	* Setter du Nom de l'objet métier contenant l'attribut 
	* sur lequel s'applique la présente RG.<br/>
	* Par exemple Client, Commande, ...<br/>
	* <br/>
	*
	* @param pNomObjetMetier : String : 
	* valeur à passer à nomObjetMetier.<br/>
	*/
	public void setNomObjetMetier(
			final String pNomObjetMetier) {
		this.nomObjetMetier = pNomObjetMetier;
	} // Fin de setNomObjetMetier(...).____________________________________


	
	/**
	 * method getNomAttributObjetMetier() :<br/>
	 * Getter du Nom de l'attribut de l'objet métier 
	 * sur lequel s'applique la RG.<br/>
	 * Par exemple nom du client, prénom du client, ...<br/>
	 * <br/>
	 *
	 * @return nomAttributObjetMetier : String.<br/>
	 */
	public String getNomAttributObjetMetier() {
		return this.nomAttributObjetMetier;
	} // Fin de getNomAttributObjetMetier()._______________________________


	
	/**
	* method setNomAttributObjetMetier(
	* String pNomAttributObjetMetier) :<br/>
	* Setter du Nom de l'attribut de l'objet métier 
	* sur lequel s'applique la RG.<br/>
	* Par exemple nom du client, prénom du client, ...<br/>
	* <br/>
	*
	* @param pNomAttributObjetMetier : String : 
	* valeur à passer à nomAttributObjetMetier.<br/>
	*/
	public void setNomAttributObjetMetier(
			final String pNomAttributObjetMetier) {
		this.nomAttributObjetMetier = pNomAttributObjetMetier;
	} // Fin de setNomAttributObjetMetier(...).____________________________


	
	/**
	 * method getClasseControle() :<br/>
	 * Getter du nom de la classe implémentant le contrôle de la RG.<br/>
	 * <br/>
	 *
	 * @return classeControle : String.<br/>
	 */
	public String getClasseControle() {
		return this.classeControle;
	} // Fin de getClasseControle()._______________________________________


	
	/**
	* method setClasseControle(
	* String pClasseControle) :<br/>
	* Setter du nom de la classe implémentant le contrôle de la RG.<br/>
	* <br/>
	*
	* @param pClasseControle : String : 
	* valeur à passer à classeControle.<br/>
	*/
	public void setClasseControle(
			final String pClasseControle) {
		this.classeControle = pClasseControle;
	} // Fin de setClasseControle(...).____________________________________


	
	/**
	 * method getMethodeControle() :<br/>
	 * Getter de la méthode implémentant le contrôle de la RG.<br/>
	 * <br/>
	 *
	 * @return methodeControle : String.<br/>
	 */
	public String getMethodeControle() {
		return this.methodeControle;
	} // Fin de getMethodeControle().______________________________________


	
	/**
	* method setMethodeControle(
	* String pMethodeControle) :<br/>
	* Setter de la méthode implémentant le contrôle de la RG.<br/>
	* <br/>
	*
	* @param pMethodeControle : String : 
	* valeur à passer à methodeControle.<br/>
	*/
	public void setMethodeControle(
			final String pMethodeControle) {
		this.methodeControle = pMethodeControle;
	} // Fin de setMethodeControle(...).___________________________________


	
	/**
	 * method getFichierProperties() :<br/>
	 * Getter Nom du fichier properties dans lequel 
	 * est implémenté le contrôle de la RG.<br/>
	 * Par exemple, fichier externe 
	 * "/ressources_externes/rg_fr_FR.properties".<br/>
	 * <br/>
	 *
	 * @return fichierProperties : String.<br/>
	 */
	public String getFichierProperties() {	
		return this.fichierProperties;
	} // Fin de getFichierProperties().____________________________________


	
	/**
	* method setFichierProperties(
	* String pFichierProperties) :<br/>
	* Setter Nom du fichier properties dans lequel 
	* est implémenté le contrôle de la RG.<br/>
	* Par exemple, fichier externe 
	* "/ressources_externes/rg_fr_FR.properties".<br/>
	* <br/>
	*
	* @param pFichierProperties : String : 
	* valeur à passer à fichierProperties.<br/>
	*/
	public void setFichierProperties(
			final String pFichierProperties) {	
		this.fichierProperties = pFichierProperties;
	} // Fin de setFichierProperties(...)._________________________________


	
	/**
	 * method getCleDansProperties() :<br/>
	 * Getter de la Clé du Boolean d'activation du contrôle 
	 * de la RG dans le properties.<br/>
	 * Par exemple : "interrogationmeteo.pays.rginterropays02.actif".<br/>
	 * <br/>
	 *
	 * @return cleDansProperties : String.<br/>
	 */
	public String getCleDansProperties() {	
		return this.cleDansProperties;
	} // Fin de getCleDansProperties().____________________________________


	
	/**
	* method setCleDansProperties(
	* String pCleDansProperties) :<br/>
	* Setter de la Clé du Boolean d'activation du contrôle 
	* de la RG dans le properties.<br/>
	* Par exemple : "interrogationmeteo.pays.rginterropays02.actif".<br/>
	* <br/>
	*
	* @param pCleDansProperties : String : 
	* valeur à passer à cleDansProperties.<br/>
	*/
	public void setCleDansProperties(
			final String pCleDansProperties) {	
		this.cleDansProperties = pCleDansProperties;
	} // Fin de setCleDansProperties(...)._________________________________


		
} // FIN DE LA CLASSE LigneRG.-----------------------------------------------
