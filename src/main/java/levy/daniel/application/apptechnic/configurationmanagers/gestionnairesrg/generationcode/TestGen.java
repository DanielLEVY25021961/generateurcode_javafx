package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.generationcode;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class TestGen :<br/>
 * .<br/>
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
 * @since 7 déc. 2017
 *
 */
public final class TestGen {

	// ************************ATTRIBUTS************************************/

	/**
	 * RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : String :<br/>
	 * "RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
	 * la civilite du UserSimple doit respecter 
	 * un ensemble fini de valeurs (nomenclature)".<br/>
	 */
	public static final String RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 
	= "RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01"
			+ " : la civilite du UserSimple "
			+ "doit respecter un ensemble fini de valeurs (nomenclature)";


	/**
	 * RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : String :<br/>
	 * "RG_USERSIMPLE_PRENOM_RENSEIGNE_02 : 
	 * le prénom du UserSimple doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_PRENOM_RENSEIGNE_02 
		= "RG_USERSIMPLE_PRENOM_RENSEIGNE_02"
			+ " : le prénom du UserSimple "
				+ "doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_PRENOM_LITTERAL_03 : String :<br/>
	 * "RG_USERSIMPLE_PRENOM_LITTERAL_03 : 
	 * le prénom du UserSimple 
	 * ne doit contenir que des lettres ou des 
	 * caractères spéciaux '-', '_', ... (aucun chiffre)".<br/>
	 */
	public static final String RG_USERSIMPLE_PRENOM_LITTERAL_03 
		= "RG_USERSIMPLE_PRENOM_LITTERAL_03"
				+ " : le prénom du UserSimple "
				+ "ne doit contenir que des "
				+ "lettres ou des caractères spéciaux '-', '_', ... "
				+ "(aucun chiffre)";


	/**
	 * RG_USERSIMPLE_PRENOM_LONGUEUR_04 : String :<br/>
	 * "RG_USERSIMPLE_PRENOM_LONGUEUR_04 : 
	 * le prénom du UserSimple doit contenir 
	 * entre [1] et [30] lettres".<br/>
	 */
	public static final String RG_USERSIMPLE_PRENOM_LONGUEUR_04 
		= "RG_USERSIMPLE_PRENOM_LONGUEUR_04"
				+ " : le prénom du UserSimple "
				+ "doit contenir entre [1] et [30] lettres";


	/**
	 * RG_USERSIMPLE_NOM_RENSEIGNE_05 : String :<br/>
	 * "RG_USERSIMPLE_NOM_RENSEIGNE_05
	 *  : le nom du UserSimple doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_NOM_RENSEIGNE_05 
		= "RG_USERSIMPLE_NOM_RENSEIGNE_05"
				+ " : le nom du UserSimple "
				+ "doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_NOM_LITTERAL_06 : String :<br/>
	 * "RG_USERSIMPLE_NOM_LITTERAL_06
	 *  : le nom du UserSimple 
	 *  ne doit contenir que des lettres ou des caractères spéciaux 
	 *  '-', '_', ... (aucun chiffre)".<br/>
	 */
	public static final String RG_USERSIMPLE_NOM_LITTERAL_06 
	= "RG_USERSIMPLE_NOM_LITTERAL_06"
			+ " : le nom du UserSimple "
			+ "ne doit contenir que des lettres ou des "
			+ "caractères spéciaux '-', '_', ... (aucun chiffre)";


	/**
	 * RG_USERSIMPLE_NOM_LONGUEUR_07 : String :<br/>
	 * "RG_USERSIMPLE_NOM_LONGUEUR_07
	 *  : le nom du UserSimple doit contenir entre 
	 *  [1] et [50] lettres".<br/>
	 */
	public static final String RG_USERSIMPLE_NOM_LONGUEUR_07 
		= "RG_USERSIMPLE_NOM_LONGUEUR_07"
				+ " : le nom du UserSimple "
				+ "doit contenir "
				+ "entre [1] et [50] lettres";


	/**
	 * RG_USERSIMPLE_EMAIL_MOTIF_08 : String :<br/>
	 * "RG_USERSIMPLE_EMAIL_MOTIF_08
	 *  : l'email du UserSimple doit respecter un motif (Regex) 
	 *  d'un email (du type albacor.trust@google.fr)".<br/>
	 */
	public static final String RG_USERSIMPLE_EMAIL_MOTIF_08 
		= "RG_USERSIMPLE_EMAIL_MOTIF_08"
				+ " : l'email du UserSimple "
				+ "doit respecter le motif "
				+ "(Regex) d'un email (du type albacor.trust@google.fr)";


	/**
	 * RG_USERSIMPLE_LOGIN_RENSEIGNE_09 : String :<br/>
	 * "RG_USERSIMPLE_LOGIN_RENSEIGNE_09
	 *  : le login du UserSimple
	 *   doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_LOGIN_RENSEIGNE_09 
		= "RG_USERSIMPLE_LOGIN_RENSEIGNE_09"
				+ " : le login du UserSimple"
				+ " doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_LOGIN_LONGUEUR_10 : String :<br/>
	 * "RG_USERSIMPLE_LOGIN_LONGUEUR_10
	 *  : le login du UserSimple 
	 *  doit contenir entre [1] et [100] caractères".<br/>
	 */
	public static final String RG_USERSIMPLE_LOGIN_LONGUEUR_10 
		= "RG_USERSIMPLE_LOGIN_LONGUEUR_10"
				+ " : le login du UserSimple"
				+ " doit contenir entre [1] et [100] caractères";


	/**
	 * RG_USERSIMPLE_MDP_RENSEIGNE_11 : String :<br/>
	 * "RG_USERSIMPLE_MDP_RENSEIGNE_11
	 *  : le mdp du UserSimple
	 *   doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_MDP_RENSEIGNE_11 
		= "RG_USERSIMPLE_MDP_RENSEIGNE_11"
				+ " : le mdp du UserSimple"
				+ " doit être renseigné (obligatoire)";


	/**
	 * RG_USERSIMPLE_MDP_LONGUEUR_12 : String :<br/>
	 * "RG_USERSIMPLE_MDP_LONGUEUR_12
	 *  : le mdp du UserSimple
	 *   doit contenir entre [3] et [20] caractères".<br/>
	 */
	public static final String RG_USERSIMPLE_MDP_LONGUEUR_12 
		= "RG_USERSIMPLE_MDP_LONGUEUR_12"
				+ " : le mdp du UserSimple"
				+ " doit contenir entre [3] et [20] caractères";


	/**
	 * RG_USERSIMPLE_MDP_MOTIF_13 : String :<br/>
	 * "RG_USERSIMPLE_MDP_MOTIF_13
	 *  : le mdp du UserSimple doit respecter un motif (Regex)".<br/>
	 */
	public static final String RG_USERSIMPLE_MDP_MOTIF_13 
		= "RG_USERSIMPLE_MDP_MOTIF_13"
				+ " : le mdp du UserSimple"
				+ " doit respecter un motif (Regex)";

	
	/**
	 * RG_USERSIMPLE_PROFIL_RENSEIGNE_14 : String :<br/>
	 * "RG_USERSIMPLE_PROFIL_RENSEIGNE_14
	 *  : le profil du UserSimple
	 *   doit être renseigné (obligatoire)".<br/>
	 */
	public static final String RG_USERSIMPLE_PROFIL_RENSEIGNE_14 
		= "RG_USERSIMPLE_PROFIL_RENSEIGNE_14"
				+ " : le profil du UserSimple"
				+ " doit être renseigné (obligatoire)";

		
	/**
	 * RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 : String :<br/>
	 * "RG_USERSIMPLE_PROFIL_NOMENCLATURE_15
	 *  : le profil du UserSimple
	 *   doit respecter un ensemble fini de valeurs (nomenclature)".<br/>
	 */
	public static final String RG_USERSIMPLE_PROFIL_NOMENCLATURE_15 
		= "RG_USERSIMPLE_PROFIL_NOMENCLATURE_15"
				+ " : le profil du UserSimple"
				+ " doit respecter un ensemble fini de valeurs"
				+ " (nomenclature)";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */

	private static final Log LOG = LogFactory.getLog(TestGen.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR TestGen() :<br/>
	 * .<br/>
	 * <br/>
	 *
	 */
	private TestGen() {
		super();
	}
	
	
} // FIN DE LA CLASSE TestGen.-----------------------------------------------
