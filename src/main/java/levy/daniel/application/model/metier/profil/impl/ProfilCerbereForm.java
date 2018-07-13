package levy.daniel.application.model.metier.profil.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * CLASSE CONCRETE <b>ProfilCerbereForm</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>ProfilCerbereForm</b> modélise un un <i>concept</i> 
 * de <b>Profil</b>, c'est à dire 
 * <b></b> ou  <b></b> 
 * qui  <i></i> <b></b>.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE DE :
 * </span>
 * </p>
 * <li><b>AbstractProfil</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * ATTRIBUTS :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
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
public class ProfilCerbereForm {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_PROFIL_CERBERE_FORM : String :<br/>
	 * "Classe ProfilCerbereForm".<br/>
	 */
	public static final String CLASSE_PROFIL_CERBERE_FORM 
		= "Classe ProfilCerbereForm";




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
	protected String profilStringString;


	/**
	 * porteeProfil : String :<br/>
	 * porteeProfil du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
	 * le porteeProfil du Profil doit être renseigné (obligatoire).</li>
	 * </ul>
	 */
	protected String porteeProfilString;


	/**
	 * restrictionProfil : String :<br/>
	 * restrictionProfil du Profil.<br/>
	 */
	protected String restrictionProfilString;


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
		= LogFactory.getLog(ProfilCerbereForm.class);


	// *************************METHODES************************************/


	/**
	 * method CONSTRUCTEUR ProfilCerbereForm() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilCerbereForm() {

		this(null, null, null);

	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * method CONSTRUCTEUR ProfilCerbereForm(
	 *  String pProfilStringString
	 * , String pPorteeProfilString
	 * , String pRestrictionProfilString) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 * 
	 * @param pProfilStringString : String : 
	 * profilStringString du ProfilCerbereForm.<br/>
	 * @param pPorteeProfilString : String : 
	 * porteeProfilString du ProfilCerbereForm.<br/>
	 * @param pRestrictionProfilString : String : 
	 * restrictionProfilString du ProfilCerbereForm.<br/>
	 */
	public ProfilCerbereForm(
			final String pProfilStringString
				, final String pPorteeProfilString
					, final String pRestrictionProfilString) {

		super();

		this.profilStringString = pProfilStringString;
		this.porteeProfilString = pPorteeProfilString;
		this.restrictionProfilString = pRestrictionProfilString;

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



	/**
	 * method getProfilStringString() :<br/>
	 * Getter de profilStringString.<br/>
	 * <br/>
	 *
	 * @return : String : this.profilStringString.<br/>
	 */
	public String getProfilStringString() {
		return this.profilStringString;
	} // Fin de getProfilStringString().___________________________________



	/**
	 * method setProfilStringString(
	 * String pProfilStringString) :<br/>
	 * Setter de profilStringString.<br/>
	 * <br/>
	 *
	 * @param pProfilStringString : String : 
	 * valeur à passer à this.profilStringString.<br/>
	 */
	public void setProfilStringString(
			final String pProfilStringString) {
		this.profilStringString = pProfilStringString;
	} // Fin de setProfilStringString().___________________________________



	/**
	 * method getPorteeProfilString() :<br/>
	 * Getter de porteeProfilString.<br/>
	 * <br/>
	 *
	 * @return : String : this.porteeProfilString.<br/>
	 */
	public String getPorteeProfilString() {
		return this.porteeProfilString;
	} // Fin de getPorteeProfilString().___________________________________



	/**
	 * method setPorteeProfilString(
	 * String pPorteeProfilString) :<br/>
	 * Setter de porteeProfilString.<br/>
	 * <br/>
	 *
	 * @param pPorteeProfilString : String : 
	 * valeur à passer à this.porteeProfilString.<br/>
	 */
	public void setPorteeProfilString(
			final String pPorteeProfilString) {
		this.porteeProfilString = pPorteeProfilString;
	} // Fin de setPorteeProfilString().___________________________________



	/**
	 * method getRestrictionProfilString() :<br/>
	 * Getter de restrictionProfilString.<br/>
	 * <br/>
	 *
	 * @return : String : this.restrictionProfilString.<br/>
	 */
	public String getRestrictionProfilString() {
		return this.restrictionProfilString;
	} // Fin de getRestrictionProfilString().______________________________



	/**
	 * method setRestrictionProfilString(
	 * String pRestrictionProfilString) :<br/>
	 * Setter de restrictionProfilString.<br/>
	 * <br/>
	 *
	 * @param pRestrictionProfilString : String : 
	 * valeur à passer à this.restrictionProfilString.<br/>
	 */
	public void setRestrictionProfilString(
			final String pRestrictionProfilString) {
		this.restrictionProfilString = pRestrictionProfilString;
	} // Fin de setRestrictionProfilString().______________________________



} // FIN DE LA CLASSE ProfilCerbereForm.-------------------------------------

















































































































































































































































