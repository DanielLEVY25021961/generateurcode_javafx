package levy.daniel.application.apptechnic.configurationmanagers;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractRunTimeTechnicalException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.BundleManquantRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.CleManquanteRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.CleNullRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierInexistantRunTimeException;


/**
 * class ConfigurationBundlesManager :<br/>
 * <ul>
 * <li>Classe UTILITAIRE 
 * Chargée de gérer la configuration des <b>RESOURCEBUNDLES</b> 
 * de l'application.</li>
 * <li>Gère aussi bien les properties INTERNES (dans la classpath) 
 * qu'EXTERNES (hors classpath) pour les properties 
 * paramétrable par la MOA.</li>
 * <p>
 * <br/>
 * <img src="../../../../../../../../javadoc/images/properties_internes_externes.png" 
 * alt="properties internes et externes" border="1" align="center" />
 * <br/>
 * </p>
 * <li>Met à disposition de l'ensemble de l'application 
 * des <b>Singletons</b> pour 
 * les fichiers .properties et tout ce dont l'application 
 * a besoin pour fonctionner.</li>
 * <ul>
 * <br/>
 * <li>Les méthodes getBundleXXX fournissent 
 * un singleton de BundleXXX.<br/> 
 * (par exemple : getBundleApplication() fournit un Singleton 
 * de ResourceBundle encapsulant 'application_fr_FR.properties').</li>
 * <li>Les méthodes getPathXXX fournissent pathXXX.<br/> 
 * (par exemple : getPathRapportsControle() fournit le chemin
 * vers le répertoire des rapports de contrôle).</li>
 * <li>
 * Type les Exceptions : <br/>
 * <p>
 * <br/>
 * <img src="../../../../../../../../javadoc/images/exceptions_resourcebundle.png" 
 * alt="Typage des exceptions" border="1" align="center" />
 * <br/>
 * </p>
 * </li>
 * </ul>
 * </ul>
 *
 * - Exemple d'utilisation :<br/>
 *<code>final ResourceBundle bundleApplication 
 * = ConfigurationBundlesManager.getBundleApplication();<br/>
 * // RAPPORT AU FORMAT CSV si problème (le rapport est alors non null).<br/>
 * ConfigurationBundlesManager.getRapportConfigurationCsv().</code><br/> 
 *<br/>
 * 
 * - Mots-clé :<br/>
 * pattern délégation, DELEGATION, <br/>
 * pattern Singleton, singleton, <br/>
 * Rapport du chargement de la configuration au format csv,<br/>
 * ressources externes, properties externes, hors classpath, <br/>
 * properties paramétrables, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 16 avr. 2016
 *
 */
public final class ConfigurationBundlesManager {

	// ************************ATTRIBUTS************************************/
	/**
	 * CLASSE_CONFIGURATIONBUNDLESMANAGER : String :<br/>
	 * "Classe ConfigurationBundlesManager".<br/>
	 */
	public static final String CLASSE_CONFIGURATIONBUNDLESMANAGER 
		= "Classe ConfigurationBundlesManager";
	
	
	/**
	 * METHODE_GET_BUNDLEAPPLICATION : String :<br/>
	 * "Méthode getBundleApplication()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEAPPLICATION 
		= "Méthode getBundleApplication()";

	
	/**
	 * METHODE_GET_BUNDLERESSOURCESEXTERNES : String :<br/>
	 * "Méthode getBundleRessourcesExternes()".<br/>
	 */
	public static final String METHODE_GET_BUNDLERESSOURCESEXTERNES
		= "Méthode getBundleRessourcesExternes()";


	/**
	 * METHODE_GET_PATH_RESSOURCES_EXTERNES : String :<br/>
	 * "Méthode getPathRessourcesExternes()".<br/>
	 */
	public static final String METHODE_GET_PATH_RESSOURCES_EXTERNES 
		= "Méthode getPathRessourcesExternes()";

	
	/**
	 * METHODE_GET_PATH_RAPPORTS_CONTROLE : String :<br/>
	 * "Méthode getPathRapportsControles()".<br/>
	 */
	public static final String METHODE_GET_PATH_RAPPORTS_CONTROLE 
		= "Méthode getPathRapportsControles()";

	
	/**
	 * METHODE_GET_PATH_LOGS : String :<br/>
	 * "Méthode getPathLogs()".<br/>
	 */
	public static final String METHODE_GET_PATH_LOGS 
		= "Méthode getPathLogs()";

	
	/**
	 * METHODE_GET_PATH_DATA : String :<br/>
	 * "Méthode getPathData()".<br/>
	 */
	public static final String METHODE_GET_PATH_DATA 
		= "Méthode getPathData()";

	
	/**
	 * METHODE_GET_BUNDLE_INTERNE : String :<br/>
	 * "Méthode getBundleInterne(
	 * String pNomBaseProperties, Locale pLocale)".<br/>
	 */
	public static final String METHODE_GET_BUNDLE_INTERNE 
		= "Méthode getBundleInterne(String pNomBaseProperties"
				+ ", Locale pLocale)";

	
	/**
	 * METHODE_GET_BUNDLE_EXTERNE : String :<br/>
	 * "Méthode getBundleExterne(String pNomBaseProperties
	 * , Locale pLocale, String pCheminRessourcesExterne)".<br/>
	 */
	public static final String METHODE_GET_BUNDLE_EXTERNE 
	= "Méthode getBundleExterne(String pNomBaseProperties"
			+ ", Locale pLocale, String pCheminRessourcesExterne)";
	
	
	/**
	 * METHODE_GET_BUNDLEMESSAGESCONTROLE : String :<br/>
	 * "Méthode getBundleMessagesControle()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEMESSAGESCONTROLE 
		= "Méthode getBundleMessagesControle()";
	
	
	/**
	 * METHODE_GET_BUNDLEMESSAGESTECHNIQUE : String :<br/>
	 * "Méthode getBundleMessagesTechnique()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEMESSAGESTECHNIQUE 
		= "Méthode getBundleMessagesTechnique()";

	
	/**
	 * METHODE_GET_BUNDLEMESSAGESDIFF : String :<br/>
	 * "Méthode getBundleMessagesDiff()".<br/>
	 */
	public static final String METHODE_GET_BUNDLEMESSAGESDIFF 
		= "Méthode getBundleMessagesDiff()";

	
	//*****************************************************************/
	//**************************** BOM_UTF-8 **************************/
	//*****************************************************************/
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 pour forcer Excel 2010 à lire en UTF-8.<br/>
	 */
	public static final char BOM_UTF_8 = '\uFEFF';

	
	//*****************************************************************/
	//**************************** SEPARATEURS ************************/
	//*****************************************************************/
	
	/**
	 * PREVENIR_CS : String :<br/>
	 * "veuillez prévenir le centre-serveur svp.".<br/>
	 */
	public static final String PREVENIR_CS 
		= "veuillez prévenir le centre-serveur svp.";
	

	/**
	 * SEP_PV : String :<br/>
	 * Séparateur pour les CSV ";".<br/>
	 */
	public static final String SEP_PV = ";";

    
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


	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");

	
	//*****************************************************************/
	//**************************** LOCALE *****************************/
	//*****************************************************************/
	/**
	 * LOCALE_FR : Locale : <br/>
	 * Locale France.<br/>
	 */
	public static final Locale LOCALE_FR = new Locale("fr", "FR");


	
	//*****************************************************************/
	//**************************** BUNDLES ****************************/
	//*****************************************************************/
	/**
	 * bundleApplication : ResourceBundle : <br/>
	 * <ul>
	 * <li><b>SINGLETON</b>.</li>
	 * <li>Contient les <b>paramétrages généraux</b> 
	 * de l'application (nom de l'application
	 * , fichier des menus, ...).</li>
	 * <li>encapsule racine_binaires/<b>application.properties</b>.</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA.</li> 
	 * <li>Uniquement accessible pour le centre serveur.</li>
	 * </ul>
	 */
	private static ResourceBundle bundleApplication;


	/**
	 * bundleRessourcesExternes : ResourceBundle : <br/>
	 * <ul>
	 * <li><b>SINGLETON</b>.</li>
	 * <li>Contient les <b>chemins</b> vers les fichiers <b>EXTERNES 
	 * PARAMETRABLES PAR LA MOA</b>
	 * (donc, hors classpath) de l'application.</li>
	 * <li>encapsule racine_binaires/<b>configuration_ressources_
	 * externes.properties</b>.</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA.</li> 
	 * <li>Uniquement accessible pour le centre serveur.</li>
	 * </ul>
	 */
	private static transient ResourceBundle bundleRessourcesExternes;

	
	/**
	 * bundleMessagesControle : ResourceBundle : <br/>
	 * 'pathExterne/messagescontrole_fr_FR.properties'.<br/>
	 * Properties EXTERNE (hors classpath).<br/>
	 * Contient les paramétrages des contrôles 
	 * de l'application.<br/>
	 */
	private static ResourceBundle bundleMessagesControle;

	
	/**
	 * bundleMessagesTechnique : ResourceBundle : <br/>
	 * 'pathExterne/messagestechnique_fr_FR.properties'.<br/>
	 * Properties EXTERNE (hors classpath).<br/>
	 * Contient les paramétrages des messages techniques 
	 * de l'application.<br/>
	 */
	private static ResourceBundle bundleMessagesTechnique;

	
	/**
	 * bundleMessagesDiff : ResourceBundle : <br/>
	 * 'pathExterne/messagesdiff_fr_FR.properties'.<br/>
	 * Properties EXTERNE (hors classpath).<br/>
	 * Contient les paramétrages des messages 
	 * pour les différences entre objets métier 
	 * de l'application.<br/>
	 */
	private static ResourceBundle bundleMessagesDiff;
	

	/**
	 * rapportConfigurationCsv : String :<br/>
	 * <ul>
	 * <li>Rapport Technique (pour les développeurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport SANS en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * Classe ConfigurationBundlesManager - 
	 * Méthode getBundleInterne(String pNomBaseProperties, Locale pLocale) - 
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin;<br/>
	 */
	private static String rapportConfigurationCsv;

	
	/**
	 * rapportUtilisateurCsv : String :<br/>
	 * <ul>
	 * <li>Rapport NON Technique (pour les utilisateurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport SANS en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin
	 *  - veuillez prévenir le centre-serveur svp.;<br/>
	 */
	private static String rapportUtilisateurCsv;
	

	/**
	 * messageIndividuelRapport : String :<br/>
	 * Message pour le Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 */
	private static String messageIndividuelRapport;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(ConfigurationBundlesManager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationBundlesManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationBundlesManager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________

	
	
	/**
	 * method getBundleApplication() :<br/>
	 * <ul>
	 * <ul>
	 * <li>Getter de bundleApplication.</li>
	 * <li>Fournit un <b>singleton</b> de bundleApplication 
	 * (application.properties).</li>
	 * <li>bundleApplication encapsule 
	 * racine_binaires/<b>application.properties</b>.</li>
	 * <li>bundleApplication contient les <b>paramétrages généraux</b> 
	 * de l'application (nom de l'application
	 * , fichier des menus, ...).</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA.</li> 
	 * <li>Uniquement accessible pour le centre serveur.</li>
	 * <br/>
	 * - Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleApplication() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleApplication.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 */
	public static ResourceBundle getBundleApplication() 
											throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
						
			if (bundleApplication == null) {
								
				bundleApplication 
					= getBundleInterne(getNomBasePropertiesApplication()
							, LocaleManager.getLocaleApplication());
				
			} // Fin de if (bundleApplication == null).__________
			
			return bundleApplication;
			
		} // Fin de synchronized.__________________________________
				
	} // Fin de getBundleApplication().____________________________________
	

	
	/**
	 * method getNomBasePropertiesApplication() :<br/>
	 * <ul>
	 * <li>Retourne le nom de base du properties contenant propriétés 
	 * générales de l'application (nom, chemin vers les menus, ...).</li>
	 * <li>"application".</li>
	 * </ul>
	 *
	 * @return : String : "application".<br/>
	 */
	private static String getNomBasePropertiesApplication() {
		return "application";
	} // Fin de getNomBasePropertiesApplication()._________________________
	
	
	
	/**
	 * method getBundleRessourcesExternes() :<br/>
	 * <ul>
	 * <ul>
	 * <li>Getter de bundleRessourcesExternes.</li>
	 * <li>Fournit un <b>singleton</b> de bundleRessourcesExternes 
	 * (configuration_ressources_externes.properties).</li>
	 * <li>bundleRessourcesExternes encapsule 
	 * racine_binaires/<b>configuration_ressources_externes.properties</b>.</li>
	 * <li>bundleRessourcesExternes contient les <b>chemins</b> 
	 * vers les fichiers <b>EXTERNES PARAMETRABLES PAR LA MOA</b>
	 * (donc, hors classpath) de l'application.</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA.</li> 
	 * <li>Uniquement accessible pour le centre serveur.</li>
	 * <br/>
	 * - Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleRessourcesExternes() 
	 * - Le fichier 'configuration_ressources_externes_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleRessourcesExternes.<br/>
	 * 
	 *  @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 */
	public static ResourceBundle getBundleRessourcesExternes() 
											throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
						
			if (bundleRessourcesExternes == null) {
								
				bundleRessourcesExternes 
					= getBundleInterne(
							getNomBasePropertiesRessourcesExternes()
							, LocaleManager.getLocaleApplication());
				
			} // Fin de if (bundleRessourcesExternes == null).__________
			
			return bundleRessourcesExternes;
			
		} // Fin de synchronized.__________________________________
				
	} // Fin de getBundleRessourcesExternes()._____________________________
	

	
	/**
	 * method getNomBasePropertiesRessourcesExternes() :<br/>
	 * <ul>
	 * <li>Retourne le nom de base du properties contenant les chemins 
	 * vers les ressources externes.</li>
	 * <li>"configuration_ressources_externes".</li>
	 * </ul>
	 *
	 * @return : String : "configuration_ressources_externes".<br/>
	 */
	private static String getNomBasePropertiesRessourcesExternes() {
		return "configuration_ressources_externes";
	} // Fin de getNomBasePropertiesRessourcesExternes().__________________
	
	
	
	/**
	 * method getPathRessourcesExternes() :<br/>
	 * <ul>
	 * <li>Fournit le path des ressources <b>EXTERNES</b> 
	 * (hors classpath) paramétrables par la MOA.</li>
	 * <li>Le path des ressources externes n'est accessible 
	 * qu'au centre-serveur et doit être écrit en dur dans 
	 * le properties 'configuration_ressources_externes.properties'. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/ressources_externes'</li>
	 * <li>clé = "ressourcesexternes".</li>
	 * </ul>
	 *
	 * @return : String : path vers les ressources externes.<br/>
	 * 
	 * @throws Exception : 
	 * - BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 * - CleManquanteRunTimeException si la clé est introuvable.<br/>
	 * - CleNullRunTimeException si la valeur 
	 * n'est pas renseignée pour la clé dans le properties.<br/>
	 * - FichierInexistantRunTimeException si le 
	 * répertoire est inexistant ou pas un répertoire.<br/>
	 */
	public static String getPathRessourcesExternes() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* Récupération du nom de base du properties. */
			final String nomBaseProperties 
				= getNomBasePropertiesRessourcesExternes();
			
			String pathRessourcesExternes = null;
			
			try {
				
				/* Récupération du bundleRessourcesExternes. */
				if (bundleRessourcesExternes == null) {
					getBundleRessourcesExternes();
				}
				
			}
			catch (BundleManquantRunTimeException bundleManquantExc) {
				
				/* cas où bundleRessourcesExternes est manquant. */
				traiterBundleManquantRunTimeException(
						METHODE_GET_PATH_RESSOURCES_EXTERNES
							, nomBaseProperties
								, bundleManquantExc);
				
			}
			
			try {
				pathRessourcesExternes 
				= bundleRessourcesExternes
					.getString(getClePathRessourcesExternes());
			}
			catch (MissingResourceException mre) {
				
				/* cas où la clé est manquante dans le properties. */
				traiterMissingResourceException(
						METHODE_GET_PATH_RESSOURCES_EXTERNES
							, nomBaseProperties
								, mre
								, getClePathRessourcesExternes());
				
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathRessourcesExternes)) {
				
				traiterCleVide(
						METHODE_GET_PATH_RESSOURCES_EXTERNES
						, getClePathRessourcesExternes()
						, nomBaseProperties);
				
			}
			
			/* Répertoire inexistant ou 
			 * pas un répertoire (fichier simple). */
			traiterRepertoireDefectueux(
					METHODE_GET_PATH_RESSOURCES_EXTERNES
						, pathRessourcesExternes);
			
			
			return pathRessourcesExternes;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathRessourcesExternes()._______________________________
	

	
	/**
	 * method getClePathRessourcesExternes() :<br/>
	 * <ul>
	 * <li>Fournit la clé du path des ressources <b>EXTERNES</b> 
	 * (hors classpath) paramétrables par la MOA.</li>
	 * <li>Cette clé est stockée dans 
	 * <b>'configuration_ressources_externes.properties'</b> 
	 * sous la racine.</li>
	 * <li>Le path des ressources externes n'est accessible 
	 * qu'au centre-serveur et doit être écrit en dur dans le properties. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/ressources_externes'</li>
	 * <li>clé = "ressourcesexternes".</li>
	 * </ul>
	 *
	 * @return : String : "ressourcesexternes".<br/>
	 */
	private static String getClePathRessourcesExternes() {
		
			return "ressourcesexternes";
	
	} // Fin de getClePathRessourcesExternes().____________________________
	

	
	/**
	 * method getPathRapportsControle() :<br/>
	 * <ul>
	 * <li>Fournit le path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des rapports de contrôle accessibles 
	 * par la MOA et les utilisateurs.</li>
	 * <li>Le path du répertoire des rapports de contrôle 
	 * est déterminé par le centre-serveur et doit être écrit en dur dans 
	 * le properties 'configuration_ressources_externes.properties'. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/rapports_controle'</li>
	 * <li>clé = "rapportscontrole".</li>
	 * </ul>
	 *
	 * @return : String : path vers le répertoire des 
	 * rapports de contrôle.<br/>
	 * 
	 * @throws Exception : 
	 * - BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 * - CleManquanteRunTimeException si la clé est introuvable.<br/>
	 * - CleNullRunTimeException si la valeur 
	 * n'est pas renseignée pour la clé dans le properties.<br/>
	 * - FichierInexistantRunTimeException si le 
	 * répertoire est inexistant ou pas un répertoire.<br/>
	 */
	public static String getPathRapportsControle() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesRessourcesExternes();
			
			String pathRapportsControles = null;
			
			try {
				
				/* Récupération du bundleRessourcesExternes. */
				if (bundleRessourcesExternes == null) {
					getBundleRessourcesExternes();
				}
				
			}
			catch (BundleManquantRunTimeException bundleManquantExc) {
				
				/* cas où bundleRessourcesExternes est manquant. */
				traiterBundleManquantRunTimeException(
						METHODE_GET_PATH_RAPPORTS_CONTROLE
							, nomBaseProperties
								, bundleManquantExc);
				
			}
			
			try {
				pathRapportsControles 
				= bundleRessourcesExternes
					.getString(getClePathRapportsControles());
			}
			catch (MissingResourceException mre) {
				
				/* cas où la clé est manquante dans le properties. */
				traiterMissingResourceException(
						METHODE_GET_PATH_RAPPORTS_CONTROLE
							, nomBaseProperties
								, mre
								, getClePathRapportsControles());
				
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathRapportsControles)) {
				
				traiterCleVide(
						METHODE_GET_PATH_RAPPORTS_CONTROLE
						, getClePathRapportsControles()
						, nomBaseProperties);
				
			}
			
			/* Répertoire inexistant ou 
			 * pas un répertoire (fichier simple). */
			traiterRepertoireDefectueux(
					METHODE_GET_PATH_RAPPORTS_CONTROLE
						, pathRapportsControles);
			
			return pathRapportsControles;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathRapportsControle()._________________________________
	

	
	
	/**
	 * method getClePathRapportsControles() :<br/>
	 * <ul>
	 * <li>Fournit la clé du path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des rapports de contrôle accessibles 
	 * par la MOA et les utilisateurs.</li>
	 * <li>Cette clé est stockée dans 
	 * <b>'configuration_ressources_externes.properties'</b> 
	 * sous la racine.</li>
	 * <li>Le path du répertoire des rapports de contrôle n'est accessible 
	 * qu'au centre-serveur et doit être écrit en dur dans le properties. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/rapports_controle'</li>
	 * <li>clé = "rapportscontrole".</li>
	 * </ul>
	 *
	 * @return : String : "rapportscontrole".<br/>
	 */
	private static String getClePathRapportsControles() {
		
			return "rapportscontrole";
	
	} // Fin de getClePathRapportsControles()._____________________________
	

	
	/**
	 * method getPathLogs() :<br/>
	 * <ul>
	 * <li>Fournit le path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des logs accessibles 
	 * par la MOE et le centre-serveur.</li>
	 * <li>Le path du répertoire des logs 
	 * est déterminé par le centre-serveur et doit être écrit en dur dans 
	 * le properties 'configuration_ressources_externes.properties'. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/logs'</li>
	 * <li>clé = "logs".</li>
	 * </ul>
	 *
	 * @return : String : path vers le répertoire des 
	 * logs.<br/>
	 * 
	 * @throws Exception : 
	 * - BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 * - CleManquanteRunTimeException si la clé est introuvable.<br/>
	 * - CleNullRunTimeException si la valeur 
	 * n'est pas renseignée pour la clé dans le properties.<br/>
	 * - FichierInexistantRunTimeException si le 
	 * répertoire est inexistant ou pas un répertoire.<br/>
	 */
	public static String getPathLogs() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesRessourcesExternes();
			
			String pathLogs = null;
			
			try {
				
				/* Récupération du bundleRessourcesExternes. */
				if (bundleRessourcesExternes == null) {
					getBundleRessourcesExternes();
				}
				
			}
			catch (BundleManquantRunTimeException bundleManquantExc) {
				
				/* cas où bundleRessourcesExternes est manquant. */
				traiterBundleManquantRunTimeException(
						METHODE_GET_PATH_LOGS
							, nomBaseProperties
								, bundleManquantExc);
				
			}
			
			try {
				pathLogs 
				= bundleRessourcesExternes
					.getString(getClePathLogs());
			}
			catch (MissingResourceException mre) {
				
				/* cas où la clé est manquante dans le properties. */
				traiterMissingResourceException(
						METHODE_GET_PATH_LOGS
							, nomBaseProperties
								, mre
								, getClePathLogs());
				
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathLogs)) {
				
				traiterCleVide(
						METHODE_GET_PATH_LOGS
						, getClePathLogs()
						, nomBaseProperties);
				
			}
			
			/* Répertoire inexistant ou 
			 * pas un répertoire (fichier simple). */
			traiterRepertoireDefectueux(
					METHODE_GET_PATH_LOGS
						, pathLogs);
			
			return pathLogs;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathLogs()._____________________________________________
	

		
	/**
	 * method getClePathLogs() :<br/>
	 * <ul>
	 * <li>Fournit la clé du path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des logs accessibles 
	 * par la MOE et le contre-serveur.</li>
	 * <li>Cette clé est stockée dans 
	 * <b>'configuration_ressources_externes.properties'</b> 
	 * sous la racine.</li>
	 * <li>Le path du répertoire des logs n'est accessible 
	 * qu'au centre-serveur et doit être écrit en dur dans le properties. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/logs'</li>
	 * <li>clé = "logs".</li>
	 * </ul>
	 *
	 * @return : String : "logs".<br/>
	 */
	private static String getClePathLogs() {
		
			return "logs";
	
	} // Fin de getClePathLogs().__________________________________________
	

		
	/**
	 * method getPathData() :<br/>
	 * <ul>
	 * <li>Fournit le path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des data accessibles 
	 * par la MOA et les utilisateurs.</li>
	 * <li>Le path du répertoire des data 
	 * est déterminé par le centre-serveur et doit être écrit en dur dans 
	 * le properties 'configuration_ressources_externes.properties'. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/data'</li>
	 * <li>clé = "data".</li>
	 * </ul>
	 *
	 * @return : String : path vers le répertoire des 
	 * sata.<br/>
	 * 
	 * @throws Exception : 
	 * - BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 * - CleManquanteRunTimeException si la clé est introuvable.<br/>
	 * - CleNullRunTimeException si la valeur 
	 * n'est pas renseignée pour la clé dans le properties.<br/>
	 * - FichierInexistantRunTimeException si le 
	 * répertoire est inexistant ou pas un répertoire.<br/>
	 */
	public static String getPathData() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesRessourcesExternes();
			
			String pathData = null;
			
			try {
				
				/* Récupération du bundleRessourcesExternes. */
				if (bundleRessourcesExternes == null) {
					getBundleRessourcesExternes();
				}
				
			}
			catch (BundleManquantRunTimeException bundleManquantExc) {
				
				/* cas où bundleRessourcesExternes est manquant. */
				traiterBundleManquantRunTimeException(
						METHODE_GET_PATH_DATA
							, nomBaseProperties
								, bundleManquantExc);
				
			}
			
			try {
				pathData 
				= bundleRessourcesExternes
					.getString(getClePathData());
			}
			catch (MissingResourceException mre) {
				
				/* cas où la clé est manquante dans le properties. */
				traiterMissingResourceException(
						METHODE_GET_PATH_DATA
							, nomBaseProperties
								, mre
								, getClePathData());
				
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathData)) {
				
				traiterCleVide(
						METHODE_GET_PATH_DATA
						, getClePathData()
						, nomBaseProperties);
				
			}
			
			/* Répertoire inexistant ou 
			 * pas un répertoire (fichier simple). */
			traiterRepertoireDefectueux(
					METHODE_GET_PATH_DATA
						, pathData);
			
			return pathData;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathData()._____________________________________________
	

		
	/**
	 * method getClePathData() :<br/>
	 * <ul>
	 * <li>Fournit la clé du path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des data accessibles 
	 * par la MOA et les utilisateurs.</li>
	 * <li>Cette clé est stockée dans 
	 * <b>'configuration_ressources_externes.properties'</b> 
	 * sous la racine.</li>
	 * <li>Le path du répertoire des data n'est accessible 
	 * qu'au centre-serveur et doit être écrit en dur dans le properties. 
	 * <br/>Par exemple : 'D:/Donnees/eclipse/eclipseworkspace_neon
	 * /tuto_maven_sonatype/data'</li>
	 * <li>clé = "data".</li>
	 * </ul>
	 *
	 * @return : String : "data".<br/>
	 */
	private static String getClePathData() {
		
			return "data";
	
	} // Fin de getClePathData().__________________________________________
	

	
	/**
	 * method getBundleInterne(
	 * String pNomBaseProperties
	 * , Locale pLocale) :<br/>
	 *<ul>
	 * <li>Retourne un ResourceBundle encapsulant pNomBaseProperties.</li>
	 * <li>Le properties doit être un fichier <b>INTERNE</b> situé 
	 * sous le contexte (racine) et donc incorporé au classpath.</li>
	 * <li>Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleInterne(..., ....) 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin".</li>
	 * </ul>
	 * retourne null si pNomBaseProperties est blank.<br/>
	 * Choisit la Locale de la plateforme si pLocale == null.<br/>
	 * <br/>
	 *
	 * @param pNomBaseProperties : String : nom de base du properties 
	 * à encapsuler dans un ResourceBundle.<br/>
	 * Par exemple, 'application' pour 'application_fr_FR.properties'.<br/>
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : ResourceBundle.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 */
	private static ResourceBundle getBundleInterne(
			final String pNomBaseProperties
				, final Locale pLocale) throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* retourne null si pNomBaseProperties est blank. */
			if (StringUtils.isBlank(pNomBaseProperties)) {
				return null;
			}
			
			/* Choisit la Locale de la plateforme si pLocale == null. */
			final Locale locale = fournirLocaleParDefaut(pLocale);
			
			ResourceBundle resultat = null;
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			try {
				
				resultat 
				= ResourceBundle.getBundle(pNomBaseProperties, locale);
				
			} catch (MissingResourceException mre) {
				
				final String nomProperties 
				= reconstituerNomProperties(pNomBaseProperties, locale);
				
				/* Création du message pour le rapport technique. */
				messageIndividuelRapport 
				= creerMessage(
						METHODE_GET_BUNDLE_INTERNE
							, nomProperties);
				
				/* LOG.FATAL. */
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageIndividuelRapport, mre);
				}
				
				/* Rapport. */
				/* Ajout du message au rapport de configuration. */
				ajouterMessageAuRapportConfigurationCsv(
						messageIndividuelRapport);
				
				/* Ajout du message au rapport utilisateur. */
				ajouterMessageAuRapportUtilisateurCsv(
						creerMessageUtilisateur(
								messageIndividuelRapport));
				
				/* Jette une BundleManquantRunTimeException 
				 * si le properties est manquant. */
				throw new BundleManquantRunTimeException(
						messageIndividuelRapport, mre);
				
			}
			
			return resultat;
			
		} // Fin de synchronized.___________________________________
				
	} // Fin de getBundleInterne(...)._____________________________________
	

	
	/**
	 * method getBundleMessagesControle() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleMessagesControle.</li>
	 * <li>bundleMessagesControle encapsule le properties EXTERNE 
	 * (hors classpath) 'pathExterne/
	 * messagescontrole_fr_FR.properties'.</li>
	 * <li>bundleMessagesControle contient les paramétrages des contrôles 
	 * de l'application.</li>
	 * <li>Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleMessagesControle() 
	 * - Le fichier 'messagescontrole_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver dans D:/ressources_externes".</li>
	 * </ul>
	 *
	 * @return : ResourceBundle : bundleMessagesControle.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/> 
	 */
	public static ResourceBundle getBundleMessagesControle() 
												throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {

			if (bundleMessagesControle == null) {

				bundleMessagesControle 
				= getBundleExterne(
						"messagescontrole"
						, LocaleManager.getLocaleApplication()
						, fournirPathRepRessourcesExternes());

			} // Fin de if (bundleMessagesControle == null).___

			return bundleMessagesControle;

		} // Fin de synchronized.__________________________________
				
	} // Fin de getBundleMessagesControle()._______________________________
	

	
	/**
	 * method getBundleMessagesTechnique() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleMessagesTechnique.</li>
	 * <li>bundleMessagesTechnique encapsule le properties EXTERNE 
	 * (hors classpath) 'pathExterne/
	 * messagestechnique_fr_FR.properties'.</li>
	 * <li>bundleMessagesTechnique contient les paramétrages des  
	 * messages techniques de l'application.</li>
	 * <li>Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleMessagesTechnique() 
	 * - Le fichier 'messagestechnique_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver dans D:/ressources_externes".</li>
	 * </ul>
	 *
	 * @return : ResourceBundle : bundleMessagesTechnique.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/> 
	 */
	public static ResourceBundle getBundleMessagesTechnique() 
												throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {

			if (bundleMessagesTechnique == null) {

				bundleMessagesTechnique 
				= getBundleExterne(
						"messagestechnique"
						, LocaleManager.getLocaleApplication()
						, fournirPathRepRessourcesExternes());

			} // Fin de if (bundleMessagesTechnique == null).____

			return bundleMessagesTechnique;

		} // Fin de synchronized.__________________________________
				
	} // Fin de getBundleMessagesTechnique().______________________________
	
	
	
	/**
	 * method getBundleMessagesDiff() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleMessagesDiff.</li>
	 * <li>bundleMessagesDiff encapsule le properties EXTERNE 
	 * (hors classpath) 'pathExterne/
	 * messagesdiff_fr_FR.properties'.</li>
	 * <li>bundleMessagesDiff contient les paramétrages des  
	 * messages des différences entre objets métier 
	 * de l'application.</li>
	 * <li>Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleMessagesDiff() 
	 * - Le fichier 'messagesdiff_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver dans D:/ressources_externes".</li>
	 * </ul>
	 *
	 * @return : ResourceBundle : bundleMessagesDiff.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/> 
	 */
	public static ResourceBundle getBundleMessagesDiff() 
												throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {

			if (bundleMessagesDiff == null) {

				bundleMessagesDiff 
				= getBundleExterne(
						"messagesdiff"
						, LocaleManager.getLocaleApplication()
						, fournirPathRepRessourcesExternes());

			} // Fin de if (bundleMessagesDiff == null).____

			return bundleMessagesDiff;

		} // Fin de synchronized.__________________________________
				
	} // Fin de getBundleMessagesDiff().___________________________________
	

	
	/**
	 * method getBundleExterne(
	 * String pNomBaseProperties
	 * , Locale pLocale
	 * , String pPathRepRessourcesExternes) :<br/>
	 * <ul>
	 * <li>Retourne un ResourceBundle encapsulant pNomBaseProperties.</li>
	 * <li>Le properties doit être un fichier <b>EXTERNE</b> situé 
	 * hors classpath afin d'être accessible pour la MOA.</li>
	 * <li>Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe ConfigurationBundlesManager 
	 * - Méthode getBundleExterne(..., ..., ...) 
	 * - Le fichier 'messagescontrole_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver dans D:/ressources_externes".</li>
	 * </ul>
	 * retourne null si pNomBaseProperties est blank.<br/>
	 * Choisit la Locale de la plateforme si pLocale == null.<br/>
	 * <br/>
	 *
	 * @param pNomBaseProperties : String : nom de base du properties 
	 * à encapsuler dans un ResourceBundle.<br/>
	 * Par exemple, 'messagescontrole' pour 
	 * 'messagescontrole_fr_FR.properties'.<br/>
	 * @param pLocale : Locale.<br/>
	 * @param pPathRepRessourcesExternes : String : 
	 * Path <b>absolu</b> vers le répertoire <b>externe</b> 
	 * (hors classpath) contenant les properties 
	 * accessibles à la MOA.<br/>
	 * 
	 * @return : ResourceBundle.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 */
	private static ResourceBundle getBundleExterne(
			final String pNomBaseProperties
				, final Locale pLocale
					, final String pPathRepRessourcesExternes) 
							throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* retourne null si pNomBaseProperties est blank. */
			if (StringUtils.isBlank(pNomBaseProperties)) {
				return null;
			}
			
			/* Choisit la Locale de la plateforme si pLocale == null. */
			final Locale locale = fournirLocaleParDefaut(pLocale);
			
			ResourceBundle resultat = null;
			
			/* Reset du messageIndividuelRapport. */
			messageIndividuelRapport = null;

			
			try {
				
				/* Accède au répertoire externe 
				 * contenant le properties. */
				final File repertoireRessourcesParametrables 
				= new File(pPathRepRessourcesExternes);
				
				/* Récupére les URL de tous les properties 
				 * contenus dans le répertoire externe
				 * (xxx_fr_FR.properties, xxx_en_US.properties, ...). */
				final URL[] urlsRessourcesParametrables 
				= {repertoireRessourcesParametrables.toURI().toURL()};

				/* Instancie un ClassLoader pointant 
				 * sur le répertoire externe. */
				final ClassLoader loaderRessourcesParametrables 
					= new URLClassLoader(urlsRessourcesParametrables);
				
				/* Récupère le properties externe voulu. */
				resultat 
					= ResourceBundle
						.getBundle(pNomBaseProperties
										, locale
											, loaderRessourcesParametrables);			
				
			}
			catch (Exception exc) {
				
				final String nomProperties 
				= reconstituerNomProperties(pNomBaseProperties, locale);
				
				/* Création du message. */
				messageIndividuelRapport 
				= creerMessage(
						METHODE_GET_BUNDLE_EXTERNE
							, nomProperties
								, pPathRepRessourcesExternes);
				
				/* LOG.FATAL. */
				if (LOG.isFatalEnabled()) {
					LOG.fatal(messageIndividuelRapport, exc);
				}
				
				/* Rapport. */
				/* Ajout du message au rapport. */
				ajouterMessageAuRapportConfigurationCsv(
						messageIndividuelRapport);
				
				/* Jette une BundleManquantRunTimeException 
				 * si le properties est manquant. */
				throw new BundleManquantRunTimeException(
						messageIndividuelRapport, exc);
				
			}
			
			return resultat;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getBundleExterne(...)._____________________________________
	
	
	
	/**
	 * method getRapportConfigurationCsv() :<br/>
	 * <ul>
	 * <li>Getter du Rapport Technique (pour les développeurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport SANS en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * Classe ConfigurationBundlesManager - 
	 * Méthode getBundleInterne(String pNomBaseProperties, Locale pLocale) - 
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin;<br/>
	 * <br/>
	 *
	 * @return rapportConfigurationCsv : String.<br/>
	 */
	public static String getRapportConfigurationCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			return rapportConfigurationCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportConfigurationCsv().______________________________


	
	/**
	 * method getRapportUtilisateurCsv() :<br/>
	 * <ul>
	 * <li>Getter du Rapport NON Technique (pour les utilisateurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport SANS en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin
	 *  - Veuillez appeler le centre-serveur svp;<br/>
	 * <br/>
	 *
	 * @return rapportUtilisateurCsv : String.<br/>
	 */
	public static String getRapportUtilisateurCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			return rapportUtilisateurCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportUtilisateurCsv().________________________________
	
	
	
	/**
	 * method getMessageIndividuelRapport() :<br/>
	 * Getter du Message pour le 
	 * Rapport du chargement de la configuration au format csv 
	 * généré par chaque méthode individuellement.<br/>
	 * <br/>
	 *
	 * @return messageIndividuelRapport : String.<br/>
	 */
	public static String getMessageIndividuelRapport() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			return messageIndividuelRapport;
		} // Fin de synchronized.________________________________________
		
	} // Fin de getMessageIndividuelRapport()._____________________________


	
	/**
	 * method fournirLocaleParDefaut(
	 * Locale pLocale) :<br/>
	 * <ul>
	 * <li>fournit la Locale de la plateforme (Locale.getDefault()) 
	 * si pLocale == null.</li>
	 * <li>retourne pLocale si pLocale != null.</li>
	 * </ul>
	 *
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : Locale.<br/>
	 */
	private static Locale fournirLocaleParDefaut(
			final Locale pLocale) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			Locale locale = null;
			
			if (pLocale == null) {
				locale= Locale.getDefault();
			}
			else {
				locale = pLocale;
			}
			
			return locale;
			
		} // Fin de synchronized.__________________________________
				
	} // Fin de fournirLocaleParDefaut(...)._______________________________


	
	/**
	 * method reconstituerNomProperties(
	 * String pNomBaseProperties
	 * , Locale pLocale) :<br/>
	 * <ul>
	 * <li>Reconstitue le nom complet d'un properties à partir 
	 * de son nom de base et d'une Locale.</li>
	 * <li>Par exemple, 'application_fr_FR.properties' à partir 
	 * de pNomBaseProperties = 'application' et 
	 * pLocale = Locale("fr", "FR").</li>
	 * <li>Retourne le nom du properties reconstitué.</li>
	 * </ul>
	 * retourne null si pNomBaseProperties est blank.<br/>
	 * Choisit la Locale de la plateforme si pLocale == null.<br/>
	 * <br/>
	 *
	 * @param pNomBaseProperties : String : nom de base du properties 
	 * comme 'application' dans 'application_fr_FR.properties'.<br/>
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : String : Nom complet du properties.<br/>
	 */
	private static String reconstituerNomProperties(
			final String pNomBaseProperties
				, final Locale pLocale) {
		
		/* retourne null si pNomBaseProperties est blank. */
		if (StringUtils.isBlank(pNomBaseProperties)) {
			return null;
		}
		
		final Locale locale = fournirLocaleParDefaut(pLocale);
		
		final String langage = locale.getLanguage();
		final String country = locale.getCountry();
		final String suffixe = langage + UNDERSCORE + country;
		
		final String resultat 
		= pNomBaseProperties 
		+ UNDERSCORE 
		+ suffixe 
		+ ".properties";
		
		return resultat;
		
	} // Fin de reconstituerNomProperties(...).____________________________
	

	
	/**
	 * method fournirPathRepRessourcesExternes() :<br/>
	 * <ul>
	 * <li>fournit le path <b>en dur</b> vers le répertoire 
	 * <b>EXTERNE</b> (hors classpath) contenant 
	 * les properties accessibles à la MOA.</li>
	 * <li>Par exemple : 'D:/ressources_externes'.</li>
	 * <ol>
	 * <li>Tente de trouver le chemin dans 
	 * src/configuration_ressources_externes.properties.</li>
	 * <li>Tente de trouver le chemin dans fournirPathRepExtEnDur().</li>
	 * </ol>
	 * </ul>
	 *
	 * @return : String : path vers le répertoire 
	 * des properties externes.<br/>
	 */
	public static String fournirPathRepRessourcesExternes() {
		 
		String path = null;
		
		try {
			/* Tente de trouver le chemin dans 
			 * src/configuration_ressources_externes.properties. */
			path 
				= bundleApplication.getString(fournirClePathRepExt());
		}
		catch (Exception e) {
			
			/* Tente de trouver le chemin dans 
			 * fournirPathRepExtEnDur(). */
			path = fournirPathRepExtEnDur();
			
		}
				
		return path;
		 
	} // Fin de fournirPathRepRessourcesExternes().________________________
	
	

	/**
	 * method fournirClePathRepExt() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans 
	 * configuration_ressources_externes.properties du chemin 
	 * du répertoire des ressources EXTERNES 
	 * contenant les properties accessibles à la MOA.</li>
	 * </ul>
	 *
	 * @return : String : 
	 * "ressourcesexternes".<br/>
	 */
	private static String fournirClePathRepExt() {
		return "ressourcesexternes";
	} // Fin de fournirClePathRepExt().____________________________________
	

	
	/**
	 * method fournirPathRepExtEnDur() :<br/>
	 * <ul>
	 * <li>Retourne le chemin en dur du répertoire 
	 * des ressources EXTERNES 
	 * contenant les properties accessibles à la MOA.</li>
	 * <li>ATTENTION : utile uniquement pour le DEVELOPPEMENT 
	 * au cas où application.properties ne contiendrait 
	 * pas cette valeur.<br/> 
	 * Ce chemin n'est valable que sur une machine donnée 
	 * et peut être changé par le centre serveur 
	 * lors de la mise en PROD.</li>
	 * </ul>
	 *
	 * @return : String : 
	 * "D:/Donnees/eclipse/eclipseworkspace_neon/
	 * tuto_maven_sonatype/ressources_externes".<br/>
	 */
	private static String fournirPathRepExtEnDur() {
		return "D:/Donnees/eclipse/eclipseworkspace_neon"
				+ "/tuto_maven_sonatype/ressources_externes";
	} // Fin de fournirPathRepExtEnDur().__________________________________
	
	
	
	/**
	 * method creerMessage(
	 * String pMethode
	 * , String pFichier) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si problème lors du chargement des ResourceBundle.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleApplication() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin".<br/>
	 * <br/>
	 *
	 * @param pMethode : String : Nom de la méthode appelante.<br/>
	 * @param pFichier : String : Nom du .properties à charger.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessage(
			final String pMethode
				, final String pFichier) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONBUNDLESMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("Le fichier '");
			stb.append(pFichier);
			stb.append("' est introuvable. "
					+ "Il devrait se trouver juste "
					+ "sous la racine des binaires /bin");
			
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de creerMessage(
	 // String pMethode
	 // , String pFichier).________________________________________________


	
	/**
	 * method creerMessage(
	 * String pMethode
	 * , String pFichier
	 * , String pPathRepRessourcesExternes) :<br/>
	 * Crée un message pour le LOG et le rapport de configuration csv 
	 * si problème lors du chargement des ResourceBundle.<br/>
	 * <br/>
	 * Par exemple :<br/>
	 * "Classe ConfigurationApplicationManager 
	 * - Méthode getBundleMessagesControle() 
	 * - Le fichier 'messagescontrole_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver ici : D:/ressources_externes".<br/>
	 * <br/>
	 *
	 * @param pMethode : String : Nom de la méthode appelante.<br/>
	 * @param pFichier : String : Nom du .properties à charger.<br/>
	 * @param pPathRepRessourcesExternes : String : 
	 * Path <b>absolu</b> vers le répertoire <b>externe</b> 
	 * (hors classpath) contenant les properties 
	 * accessibles à la MOA.<br/>
	 * 
	 * @return : String : message pour le LOG 
	 * et le rapport de configuration csv.<br/>
	 */
	private static String creerMessage(
			final String pMethode
				, final String pFichier
					, final String pPathRepRessourcesExternes) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_CONFIGURATIONBUNDLESMANAGER);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append(pMethode);
			stb.append(SEPARATEUR_MOINS_AERE);
			stb.append("Le fichier '");
			stb.append(pFichier);
			stb.append("' est introuvable. "
					+ "Il devrait se trouver ici : ");
			stb.append(pPathRepRessourcesExternes);
			
			return stb.toString();
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de creerMessage(...)._________________________________________
	

	
	/**
	 * method creerMessageUtilisateur(
	 * String pMessageTechnique) :<br/>
	 * <ul>
	 * <li>Epure un message technique en enlevant 
	 * les informations sur la classe et la méthode 
	 * et constitue un message à l'attention des utilisateurs.</li>
	 * </ul>
	 * Retourne null si pMessageTechnique est blank.<br/>
	 * <br/>
	 *
	 * @param pMessageTechnique : String.<br/>
	 * 
	 * @return : String : Message à l'attention des utilisateurs.<br/>
	 */
	private static String creerMessageUtilisateur(
			final String pMessageTechnique) {
		
		/* Retourne null si pMessageTechnique est blank. */
		if (StringUtils.isBlank(pMessageTechnique)) {
			return null;
		}
		
		final String[] tableau 
			= StringUtils.splitByWholeSeparator(
					pMessageTechnique, SEPARATEUR_MOINS_AERE);
		
		final String baseMessage = tableau[2];
		
		String messageUtilisateur = null;
		
		if (baseMessage != null) {
			messageUtilisateur 
				= baseMessage 
				+ SEPARATEUR_MOINS_AERE 
					+ PREVENIR_CS;
			
		} else {
			messageUtilisateur = PREVENIR_CS;
		}
		
		return messageUtilisateur;
		
	} // Fin de creerMessageUtilisateur(...).______________________________
	
	
	
	/**
	 * method ajouterMessageAuRapportConfigurationCsv(
	 * String pMessage) :<br/>
	 * <ul>
	 * <li>Rajoute le message pMessage au rapport 
	 * de chargement de la configuration au format csv (à la ligne).</li>
	 * </ul>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Ne Rajoute PAS l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport de chargement de la configuration.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport de chargement de la configuration.<br/>
	 */
	private static void ajouterMessageAuRapportConfigurationCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
						
			/* Rajoute le message au rapport de 
			 * chargement de la configuration au format csv (à la ligne). */
			if (!StringUtils.isBlank(rapportConfigurationCsv)) {
				stb.append(rapportConfigurationCsv);
				stb.append(NEWLINE);
			}
			
			stb.append(pMessage);
			stb.append(SEP_PV);
			
			rapportConfigurationCsv = stb.toString();
			
		} // Fin de synchronized.________________________________________
			
	} // Fin de ajouterMessageAuRapportConfigurationCsv(
	 // String pMessage).__________________________________________________

	
	
	
	/**
	 * method ajouterMessageAuRapportUtilisateurCsv(
	 * String pMessage) :<br/>
	 * <ul>
	 * <li>Rajoute le message pMessage au rapport 
	 * utilisateur au format csv (à la ligne).</li>
	 * </ul>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Ne Rajoute PAS l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport utilisateur.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport utilisateur.<br/>
	 */
	private static void ajouterMessageAuRapportUtilisateurCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationBundlesManager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
						
			/* Rajoute le message au rapport de 
			 * chargement utilisateur au format csv (à la ligne). */
			if (!StringUtils.isBlank(rapportUtilisateurCsv)) {
				stb.append(rapportUtilisateurCsv);
				stb.append(NEWLINE);
			}
			
			stb.append(pMessage);
			stb.append(SEP_PV);
			
			rapportUtilisateurCsv = stb.toString();
			
		} // Fin de synchronized.________________________________________
			
	} // Fin de ajouterMessageAuRapportUtilisateurCsv(
	 // String pMessage).__________________________________________________
	
	
	
	/**
	 * method traiterBundleManquantRunTimeException(
	 * String pMethode
	 * , String pNomBaseProperties
	 * , BundleManquantRunTimeException pBundleManquantExc) :<br/>
	 * <ul>
	 * <li>Prend en paramètre une BundleManquantRunTimeException
	 * , ajoute des lignes aux rapports développeurs et utilisateurs
	 * , logge fatal et jette une Exception 
	 * typée BundleManquantRunTimeException.</li>
	 * <li>crée une ligne dans le rapport de configuration csv.</li>
	 * <li>ajoute cette ligne à 'rapportConfigutrationCsv'.</li>
	 * <li>crée une ligne dans le rapport utilisateur csv.</li>
	 * <li>ajoute cette ligne à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une BundleManquantRunTimeException 
	 * qui encapsule pBundleManquantExc.</li>
	 * </ul>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pNomBaseProperties : nom de base du properties comme 
	 * 'application' pour application_fr_FR.properties.<br/>
	 * @param pBundleManquantExc : BundleManquantRunTimeException.<br/>
	 * 
	 * @throws BundleManquantRunTimeException
	 */
	private static void traiterBundleManquantRunTimeException(
			final String pMethode
				, final String pNomBaseProperties
					, final BundleManquantRunTimeException pBundleManquantExc) 
							throws BundleManquantRunTimeException {
		
		final String nomProperties 
		= reconstituerNomProperties(
				pNomBaseProperties
					, LocaleManager.getLocaleApplication());
		
		/* Création du message pour le rapport technique. */
		messageIndividuelRapport 
		= creerMessage(
				pMethode
					, nomProperties);
		
		/* LOG.FATAL. */
		if (LOG.isFatalEnabled()) {
			LOG.fatal(messageIndividuelRapport, pBundleManquantExc);
		}
		
		/* Rapport. */
		/* Ajout du message au rapport de configuration. */
		ajouterMessageAuRapportConfigurationCsv(
				messageIndividuelRapport);
		
		/* Ajout du message au rapport utilisateur. */
		ajouterMessageAuRapportUtilisateurCsv(
				creerMessageUtilisateur(
						messageIndividuelRapport));
		
		/* Jette une BundleManquantRunTimeException 
		 * si le properties est manquant. */
		throw new BundleManquantRunTimeException(
				messageIndividuelRapport, pBundleManquantExc);
		
	} // Fin de traiterBundleManquantRunTimeException(...).________________


	
	/**
	 * method traiterMissingResourceException(
	 * String pMethode
	 * , String pNomBaseProperties
	 * , MissingResourceException pMre) :<br/>
	 * <ul>
	 * <li>Prend en paramètre une MissingResourceException
	 * , ajoute des lignes aux rapports développeurs et utilisateurs
	 * , logge fatal et jette une Exception 
	 * typée BundleManquantRunTimeException.</li>
	 * <li>crée une ligne dans le rapport de configuration csv.</li>
	 * <li>ajoute cette ligne à 'rapportConfigutrationCsv'.</li>
	 * <li>crée une ligne dans le rapport utilisateur csv.</li>
	 * <li>ajoute cette ligne à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une BundleManquantRunTimeException 
	 * qui encapsule pMre.</li>
	 * </ul>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pNomBaseProperties : nom de base du properties comme 
	 * 'application' pour application_fr_FR.properties.<br/>
	 * @param pMre : MissingResourceException.<br/>
	 * 
	 * @throws BundleManquantRunTimeException
	 */
	private static void traiterMissingResourceException(
			final String pMethode
				, final String pNomBaseProperties
					, final MissingResourceException pMre) 
							throws BundleManquantRunTimeException {
		
		final String nomProperties 
		= reconstituerNomProperties(
				pNomBaseProperties
					, LocaleManager.getLocaleApplication());
		
		/* Création du message pour le rapport technique. */
		messageIndividuelRapport 
		= creerMessage(
				pMethode
					, nomProperties);
		
		/* LOG.FATAL. */
		if (LOG.isFatalEnabled()) {
			LOG.fatal(messageIndividuelRapport, pMre);
		}
		
		/* Rapport. */
		/* Ajout du message au rapport de configuration. */
		ajouterMessageAuRapportConfigurationCsv(
				messageIndividuelRapport);
		
		/* Ajout du message au rapport utilisateur. */
		ajouterMessageAuRapportUtilisateurCsv(
				creerMessageUtilisateur(
						messageIndividuelRapport));
		
		/* Jette une BundleManquantRunTimeException 
		 * si le properties est manquant. */
		throw new BundleManquantRunTimeException(
				messageIndividuelRapport, pMre);
		
	} // Fin de traiterMissingResourceException(...).______________________


	
	/**
	 * method traiterMissingResourceException(
	 * String pMethode
	 * , String pNomBaseProperties
	 * , MissingResourceException pMre
	 * , String pCle) :<br/>
	 * <ul>
	 * <li>Prend en paramètre une MissingResourceException 
	 * et une clé de properties
	 * , ajoute des lignes aux rapports développeurs et utilisateurs
	 * , logge fatal et jette une Exception 
	 * typée BundleManquantRunTimeException.</li>
	 * <li>crée une ligne dans le rapport de configuration csv.</li>
	 * <li>ajoute cette ligne à 'rapportConfigutrationCsv'.</li>
	 * <li>crée une ligne dans le rapport utilisateur csv.</li>
	 * <li>ajoute cette ligne à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une CleManquanteRunTimeException 
	 * qui encapsule pMre.</li>
	 * </ul>
	 *
	 * @param pMethode : String : nom de la méthode appelante.<br/>
	 * @param pNomBaseProperties : nom de base du properties comme 
	 * 'application' pour application_fr_FR.properties.<br/>
	 * @param pMre : MissingResourceException.<br/>
	 * @param pCle : String : Clé du properties pour laquelle on
	 *  recherche une valeur.<br/>
	 * 
	 * @throws CleManquanteRunTimeException
	 */
	private static void traiterMissingResourceException(
			final String pMethode
				, final String pNomBaseProperties
					, final MissingResourceException pMre
						, final String pCle) 
							throws CleManquanteRunTimeException {
		
		final String nomProperties 
		= reconstituerNomProperties(
				pNomBaseProperties
					, LocaleManager.getLocaleApplication());
		
		/* Création du message pour le rapport technique. */
		messageIndividuelRapport 
		= CLASSE_CONFIGURATIONBUNDLESMANAGER 
		+ SEPARATEUR_MOINS_AERE 
		+ pMethode 
		+ SEPARATEUR_MOINS_AERE 
		+ "La clé : '" 
		+ pCle 
		+ "' est introuvable dans " 
		+ nomProperties;
		
		/* LOG.FATAL. */
		if (LOG.isFatalEnabled()) {
			LOG.fatal(messageIndividuelRapport, pMre);
		}
		
		/* Rapport. */
		/* Ajout du message au rapport de configuration. */
		ajouterMessageAuRapportConfigurationCsv(
				messageIndividuelRapport);
		
		/* Ajout du message au rapport utilisateur. */
		ajouterMessageAuRapportUtilisateurCsv(
				creerMessageUtilisateur(
						messageIndividuelRapport));
		
		/* Jette une CleManquanteRunTimeException 
		 * si le properties est manquant. */
		throw new CleManquanteRunTimeException(
				messageIndividuelRapport, pMre);
		
	} // Fin de traiterMissingResourceException(...).______________________



	
	/**
	 * method traiterCleVide(
	 * String pMethode
	 * , String pCle
	 * , String pNomBaseProperties) :<br/>
	 * <ul>
	 * <li>Methode jetant une <b>CleNullRunTimeException</b> 
	 * en cas d'absence de valeur associée à la clé d'un properties.</li>
	 * <li>Rédige un message à l'attention des développers.</li>
	 * <li>LOG.FATAL.</li>
	 * <li>Ajoute le message au rapport de configuration 
	 * rapportConfigurationCsv.</li>
	 * <li>Ajoute le message utilisateur au rapport 
	 * utilisateur rapportUtilisateurCsv.</li>
	 * <li>Jette la CleNullRunTimeException encapsulant le message.</li>
	 * </ul>
	 *
	 * @param pMethode
	 * @param pCle
	 * @param pNomBaseProperties
	 * 
	 * @throws CleNullRunTimeException : si la valeur 
	 * n'est pas renseignée pour la clé dans le properties.<br/>
	 */
	private static void traiterCleVide(
			final String pMethode
				, final String pCle
					, final String pNomBaseProperties) 
							throws CleNullRunTimeException {
		
		/* Rédige un message à l'attention des développers. */
		final String messageValeurnull 
		= CLASSE_CONFIGURATIONBUNDLESMANAGER 
		+ SEPARATEUR_MOINS_AERE
		+ pMethode
		+ SEPARATEUR_MOINS_AERE
		+ "Pas de valeur indiquée pour la clé '" 
		+ pCle 
		+ "' dans " 
		+ reconstituerNomProperties(
				pNomBaseProperties
				, LocaleManager.getLocaleApplication());
		
		/* LOG.FATAL. */
		if (LOG.isFatalEnabled()) {
			LOG.fatal(messageValeurnull);
		}
		
		/* Rapport. */
		/* Ajoute le message au rapport de configuration 
		 * rapportConfigurationCsv. */
		ajouterMessageAuRapportConfigurationCsv(
				messageValeurnull);
		
		/* Ajoute le message utilisateur au rapport 
		 * utilisateur rapportUtilisateurCsv. */
		ajouterMessageAuRapportUtilisateurCsv(
				creerMessageUtilisateur(
						messageValeurnull));
		
		final AbstractRunTimeTechnicalException excValeurNull 
			= new CleNullRunTimeException(messageValeurnull);
		
		/* Jette la CleNullRunTimeException encapsulant le message. */
		throw excValeurNull;
		
	} // Fin de traiterCleVide(...)._______________________________________
	

		
	/**
	 * method traiterRepertoireDefectueux(
	 * String pMethode
	 * , String pPath) :<br/>
	 * <ul>
	 * <li>Methode jetant une <b>FichierInexistantRunTimeException</b> 
	 * si le répertoire visé par pPath n'existe pas ou n'est 
	 * pas un répertoire (fichier simple).</li>
	 * <li>Rédige un message à l'attention des développers.</li>
	 * <li>LOG.FATAL.</li>
	 * <li>Ajoute le message au rapport de configuration 
	 * rapportConfigurationCsv.</li>
	 * <li>Ajoute le message utilisateur au rapport 
	 * utilisateur rapportUtilisateurCsv.</li>
	 * <li>Jette la FichierInexistantRunTimeException encapsulant le message.</li>
	 * </ul>
	 *
	 * @param pMethode : String : méthode appelante.<br/>
	 * @param pPath : String : chemin vers un répertoire
	 * 
	 * @throws FichierInexistantRunTimeException : si le 
	 * répertoire est inexistant ou pas un répertoire.<br/>
	 */
	private static void traiterRepertoireDefectueux(
			final String pMethode
				, final String pPath) 
						throws FichierInexistantRunTimeException {
		
		final Path path = Paths.get(pPath);
		final boolean existRepertoire 
			= Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		final boolean estRepertoire 
			= Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS);
		
		if (!existRepertoire || !estRepertoire) {
			
			/* Rédige un message à l'attention des développers. */
			final String messageRepInexistant 
			= CLASSE_CONFIGURATIONBUNDLESMANAGER
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE
			+ "Le répertoire '" 
			+ pPath 
			+ "' est inexistant ou n'est pas un répertoire";
			
			/* LOG.FATAL. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(messageRepInexistant);
			}
			
			/* Rapport. */
			/* Ajoute le message au rapport de configuration 
			 * rapportConfigurationCsv. */
			ajouterMessageAuRapportConfigurationCsv(
					messageRepInexistant);
			
			/* Ajoute le message utilisateur au rapport 
			 * utilisateur rapportUtilisateurCsv. */
			ajouterMessageAuRapportUtilisateurCsv(
					creerMessageUtilisateur(
							messageRepInexistant));
			
			final AbstractRunTimeTechnicalException excRepInexistant 
				= new FichierInexistantRunTimeException(
						messageRepInexistant);
			
			/* Jette la FichierInexistantRunTimeException 
			 * encapsulant le message.*/
			throw excRepInexistant;
							
		}
		
	} // Fin de traiterRepertoireDefectueux(...).__________________________
	

} // FIN DE LA CLASSE ConfigurationBundlesManager.---------------------------
