package levy.daniel.application.model.metier.profil;

import javax.persistence.Transient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * CLASSE ABSTRAITE <b>AbstractProfil</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>AbstractProfil</b> modélise un un <i>concept</i> 
 * de <b>Profil</b>, c'est à dire 
 * <b></b> ou  <b></b> 
 * qui  <i></i> <b></b>.<br/>
 * <b>FACTORISE</b> les attributs et comportements 
 * des <i>descendants concrets</i>.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * IMPLEMENTE :
 * </span>
 * </p>
 * <li><b>IProfil</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout Profil héritant de 
 * AbstractProfil possède à minima :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>profilString</b>.</li>
 * <li><b>porteeProfil</b>.</li>
 * <li><b>restrictionProfil</b>.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un AbstractProfil est vérifiée sur :</li>
 * <ul>
 * <li><b>profilString</b>.</li>
 * <li><b>porteeProfil</b>.</li>
 * </ul>
 * </ul>
 *
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_Profil.png" 
 * alt="classes d'implémentation des Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * ENTITIES JPA
 * </span>
 * </p>
 * <ul>
 * <li>la classe abstraite AbstractProfil 
 * est transformée en <b>Entity JPA</b> au moyen de 
 * <b>javax.persistence annotations</b>.</li>
 * <li>La <b>stratégie de jointure des tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_Profil_entities.png" 
 * alt="implémentation des entities de Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * TABLES
 * </span>
 * </p>
 * <ul>
 * <li>Les <b>tables en base</b> résultantes des entities JPA sont :</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/tables-abstract_Profils_Profils.png" 
 * alt="implémentation des tables de Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">REGLES DE GESTION</span>
 * </p>
 * <ul>
 * <li>
 * Les <b>Règles de Gestion (RG)</b> applicables aux attributs 
 * d'un Profil sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * profilString
 * </td>
 * <td>
 * RG_PROFIL_PROFILSTRING_RENSEIGNE_01 : 
 * le profilString du Profil doit être renseigné (obligatoire)
 * </td>
 * </tr>
 * <tr>
 * <td>
 * RG_PROFIL_PROFILSTRING_NOMENCLATURE_02 : 
 * le profilString du Profil doit respecter un ensemble fini de valeurs (nomenclature)
 * </td>
 * </tr>
 * <tr>
 * <td rowspan="1">
 * porteeProfil
 * </td>
 * <td>
 * RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
 * le porteeProfil du Profil doit être renseigné (obligatoire)
 * </td>
 * </tr>
 * </table>
 * </ul>
 * 
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
 * @since 26 février 2018
 *
 */
public abstract class AbstractProfil implements IProfil {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_PROFIL : String :<br/>
	 * "Classe AbstractProfil".<br/>
	 */
	public static final String CLASSE_ABSTRACT_PROFIL 
		= "Classe AbstractProfil";


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
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";


	/**
	 * UNDERSCORE : String :<br/>
	 * "_".<br/>
	 */
	public static final String UNDERSCORE = "_";


	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	public static final String NULL = "null";



	/**
	 * id : Long :<br/>
	 * ID en base.<br/>
	 */
	protected Long id;


	/**
	 * profilString : String :<br/>
	 * profilString du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PROFILSTRING_RENSEIGNE_01 : 
	 * le profilString du Profil doit être renseigné (obligatoire).</li>
	 * <li>RG_PROFIL_PROFILSTRING_NOMENCLATURE_02 : 
	 * le profilString du Profil doit respecter un ensemble fini de valeurs (nomenclature).</li>
	 * </ul>
	 */
	protected String profilString;


	/**
	 * porteeProfil : String :<br/>
	 * porteeProfil du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
	 * le porteeProfil du Profil doit être renseigné (obligatoire).</li>
	 * </ul>
	 */
	protected String porteeProfil;


	/**
	 * restrictionProfil : String :<br/>
	 * restrictionProfil du Profil.<br/>
	 */
	protected String restrictionProfil;


	/**
	 * serialVersionUID : long :<br/>
	 * serialVersionUID = 1L.<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractProfil.class);


	// *************************METHODES************************************/


	/**
	 * method CONSTRUCTEUR AbstractProfil() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractProfil() {

		this(null, null, null, null);

	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * method CONSTRUCTEUR AbstractProfil(
	 *  String pProfilString
	 * , String pPorteeProfil
	 * , String pRestrictionProfil) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 * 
	 * @param pProfilString : String : 
	 * profilString du AbstractProfil.<br/>
	 * @param pPorteeProfil : String : 
	 * porteeProfil du AbstractProfil.<br/>
	 * @param pRestrictionProfil : String : 
	 * restrictionProfil du AbstractProfil.<br/>
	 */
	public AbstractProfil(
			final String pProfilString
				, final String pPorteeProfil
					, final String pRestrictionProfil) {

		this(null, pProfilString, pPorteeProfil, pRestrictionProfil);

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



	/**
	 * method CONSTRUCTEUR AbstractProfil(
	 * Long pId
	 * , String pProfilString
	 * , String pPorteeProfil
	 * , String pRestrictionProfil) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 * 
	 * @param pId : Long : ID en base.<br/>
	 * @param pProfilString : String : 
	 * profilString du AbstractProfil.<br/>
	 * @param pPorteeProfil : String : 
	 * porteeProfil du AbstractProfil.<br/>
	 * @param pRestrictionProfil : String : 
	 * restrictionProfil du AbstractProfil.<br/>
	 */
	public AbstractProfil(
			final Long pId
				, final String pProfilString
					, final String pPorteeProfil
						, final String pRestrictionProfil) {

		super();

		this.id = pId;
		this.profilString = pProfilString;
		this.porteeProfil = pPorteeProfil;
		this.restrictionProfil = pRestrictionProfil;

	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final int prime = 31;

		int result = 1;

		result = prime * result 
				+ ((this.profilString == null) 
					? 0 : this.profilString.hashCode());
		result = prime * result 
				+ ((this.porteeProfil == null) 
					? 0 : this.porteeProfil.hashCode());

		return result;

	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <ul>
	 * <b>equals(...) pour un AbstractProfil</b> sur :
	 * <li>profilString.</li>
	 * <li>porteeProfil.</li>
	 * </ul>
	 * <br/>
	 */
	@Override
	public boolean equals(
			final Object pObject) {

		if (this == pObject) {
			return true;
		}

		if (pObject == null) {
			return false;
		}

		if (!(pObject instanceof AbstractProfil)) {
			return false;
		}

		final AbstractProfil other = (AbstractProfil) pObject;

		/* profilString. */
		if (this.profilString == null) {
			if (other.profilString != null) {
				return false;
			}
		}
		else if (!this.profilString.equals(other.profilString)) {
			return false;
		}

		/* porteeProfil. */
		if (this.porteeProfil == null) {
			if (other.porteeProfil != null) {
				return false;
			}
		}
		else if (!this.porteeProfil.equals(other.porteeProfil)) {
			return false;
		}

		return true;

	} // Fin de equals(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public int compareTo(
			final IProfil pObject) {

		if (this == pObject) {
			return 0;
		}

		if (pObject == null) {
			return -1;
		}

		int compareProfilString;
		int comparePorteeProfil;

		/* profilString. */
		if (this.getProfilString() == null) {
			if (pObject.getProfilString() != null) {
				return +1;
			}
		} else {
			if (pObject.getProfilString() == null) {
				return -1;
			}

			compareProfilString 
				= this.getProfilString()
					.compareTo(pObject.getProfilString());

			if (compareProfilString != 0) {
				return compareProfilString;
			}
		}

		/* porteeProfil. */
		if (this.getPorteeProfil() == null) {
			if (pObject.getPorteeProfil() != null) {
				return +1;
			}
			return 0;
		} 

		if (pObject.getPorteeProfil() == null) {
			return -1;
		}

		comparePorteeProfil 
			= this.getPorteeProfil()
				.compareTo(pObject.getPorteeProfil());

		return comparePorteeProfil;

	} // Fin de compareTo(...).____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public AbstractProfil clone() throws CloneNotSupportedException {

		final AbstractProfil clone 
				= (AbstractProfil) super.clone();

		clone.setId(this.id);	
		clone.setProfilString(this.profilString);
		clone.setPorteeProfil(this.porteeProfil);
		clone.setRestrictionProfil(this.restrictionProfil);

		return clone;

	} // Fin de clone().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		final StringBuilder builder = new StringBuilder();

		builder.append("AbstractProfil [");

		builder.append("id=");
		if (this.id != null) {			
			builder.append(this.id);			
		} else {
			builder.append(NULL);
		}

		builder.append(VIRGULE_ESPACE);

		builder.append("profilString=");
		if (this.profilString != null) {			
			builder.append(this.profilString);
		} else {
			builder.append(NULL);
		}

		builder.append(VIRGULE_ESPACE);

		builder.append("porteeProfil=");
		if (this.porteeProfil != null) {			
			builder.append(this.porteeProfil);
		} else {
			builder.append(NULL);
		}

		builder.append(VIRGULE_ESPACE);

		builder.append("restrictionProfil=");
		if (this.restrictionProfil != null) {			
			builder.append(this.restrictionProfil);
		} else {
			builder.append(NULL);
		}

		builder.append(']');

		return builder.toString();

	} // Fin de toString().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public String getEnTeteCsv() {
		return "id;profilString;porteeProfil;restrictionProfil;";
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toStringCsv() {

		final StringBuilder stb = new StringBuilder();

		/* id. */
		stb.append(this.getId());
		stb.append(POINT_VIRGULE);

		/* profilString. */
		stb.append(this.getProfilString());
		stb.append(POINT_VIRGULE);

		/* porteeProfil. */
		stb.append(this.getPorteeProfil());
		stb.append(POINT_VIRGULE);

		/* restrictionProfil. */
		stb.append(this.getRestrictionProfil());
		stb.append(POINT_VIRGULE);

		return stb.toString();

	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public String getEnTeteColonne(
			final int pI) {

		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "profilString";
			break;

		case 2:
			entete = "porteeProfil";
			break;

		case 3:
			entete = "restrictionProfil";
			break;

		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transient
	public Object getValeurColonne(
			final int pI) {

		Object valeur = null;

		switch (pI) {

		case 0:
			if (this.getId() != null) {
				valeur = String.valueOf(this.getId());
			}
			break;

		case 1:
			valeur = this.getProfilString();		
			break;

		case 2:
			valeur = this.getPorteeProfil();		
			break;

		case 3:
			valeur = this.getRestrictionProfil();		
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return this.id;
	} // Fin de getId().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {
		this.id = pId;
	} // Fin de setId(...).________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getProfilString() {
		return this.profilString;
	} // Fin de getProfilString()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProfilString(
			final String pProfilString) {
		this.profilString = pProfilString;
	} // Fin de setProfilString()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPorteeProfil() {
		return this.porteeProfil;
	} // Fin de getPorteeProfil()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPorteeProfil(
			final String pPorteeProfil) {
		this.porteeProfil = pPorteeProfil;
	} // Fin de setPorteeProfil()._________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getRestrictionProfil() {
		return this.restrictionProfil;
	} // Fin de getRestrictionProfil().____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRestrictionProfil(
			final String pRestrictionProfil) {
		this.restrictionProfil = pRestrictionProfil;
	} // Fin de setRestrictionProfil().____________________________________



} // FIN DE LA CLASSE AbstractProfil.----------------------------------------