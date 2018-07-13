package levy.daniel.application;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.ConfigurationBundlesManager;
import levy.daniel.application.apptechnic.exceptions.technical.impl.BundleManquantRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.CleManquanteRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.CleNullRunTimeException;
import levy.daniel.application.apptechnic.exceptions.technical.impl.FichierInexistantRunTimeException;

/**
 * class ConfigurationApplicationManager :<br/>
 * <ul>
 * <li>Classe UTILITAIRE (méthodes statiques)
 * Chargée de gérer la configuration de l'application.</li>
 * <li>DISPONIBLE POUR TOUTE L'APPLICATION.</li>
 * <li>Met à disposition de l'ensemble de l'application 
 * des <b>Singletons</b> pour 
 * les fichiers .properties et tout ce dont l'application 
 * a besoin pour fonctionner 
 * (Descriptions de fichiers, nomenclatures, ...).</li>
 * <li>DELEGUE à des ConfigurationCCCManagers.</li>
 * <br/>
 * <img src="../../../../../../javadoc/images/configuration_bundles.JPG" 
 * alt="diagramme de classes des ConfigurationManagers" border="1" align="center" />
 * <br/>
 * </li>
 * <br/>
 * <li>Les méthodes getBundleZZZ fournissent 
 * un singleton de BundleZZZ.<br/> 
 * Par exemple : getBundleApplication() fournit un Singleton 
 * de bundleApplication qui est le ResourceBundle encapsulant 
 * 'application_fr_FR.properties'.</li>
 * <li>Les méthodes getNomNomenclatureXXXChampYYY fournissent un singleton  
 * du nom du fichier de la nomenclature du champ YYY 
 * dans le fichierXXX 
 * (HIT, HISTO_F07, Darwin.csv, ...).</li>
 * </ul>
 * </ul>
 *
 * - Exemple d'utilisation :<br/>
 * <code> // Récupération du ResourceBundle encapsulant 
 * 'application.properties'.<br/></code>
 * <code>final ResourceBundle bundleApplication 
 * = ConfigurationApplicationManager.getBundleApplication();<br/>
 * // RAPPORT AU FORMAT CSV si problème (le rapport est alors non null).<br/>
 * ConfigurationApplicationManager.getRapportConfigurationCsv().</code><br/> 
 *<br/>
 * 
 * - Mots-clé :<br/>
 * pattern délégation, DELEGATION, <br/>
 * pattern Singleton, singleton, Singleton,<br/>
 * Rapport du chargement de la configuration au format csv,<br/>
 * classpath,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 15 avr. 2016
 *
 */
public final class ConfigurationApplicationManager {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_CONFIGURATION_APPLICATION_MANAGER : String :<br/>
	 * "Classe ConfigurationApplicationManager".<br/>
	 */
	public static final String CLASSE_CONFIGURATION_APPLICATION_MANAGER 
		= "Classe ConfigurationApplicationManager";


	
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
	 * Locale France new Locale("fr", "FR").<br/>
	 */
	public static final Locale LOCALE_FR = new Locale("fr", "FR");
	

	/**
	 * rapportConfigurationCsv : String :<br/>
	 * <ul>
	 * <li>Rapport Technique (pour les développeurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport AVEC en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * messages de chargement de la configuration;<br/>
	 * Classe ConfigurationBundlesManager - 
	 * Méthode getBundleInterne(String pNomBaseProperties, Locale pLocale) - 
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin;<br/>
	 */
	private static transient String rapportConfigurationCsv;
	
		
	/**
	 * rapportUtilisateurCsv : String :<br/>
	 * <ul>
	 * <li>Rapport NON Technique (pour les utilisateurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport AVEC en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * messages de chargement de la configuration;<br/>
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin
	 *  - veuillez prévenir le centre-serveur svp.;<br/>
	 */
	private static String rapportUtilisateurCsv;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(ConfigurationApplicationManager.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ConfigurationApplicationManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * private pour interdire l'instanciation.<br/>
	 * <br/>
	 */
	private ConfigurationApplicationManager() {
		super();
	} // Fin du CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method getBundleApplication() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleApplication.</li>
	 * <li>DELEGUE au ConfigurationBundlesManager.</li>
	 * <li>bundleApplication encapsule le properties INTERNE 
	 * (dans le classpath) './src/application_fr_FR.properties'.</li>
	 * <li>bundleApplication contient les paramétrages généraux 
	 * de l'application (chemins vers les menus
	 * , titre de l'application, ...).</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA. 
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
	 *  @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 */
	public static ResourceBundle getBundleApplication() 
											throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			ResourceBundle bundleApplication = null;
			
			try {
				
				/* DELEGATION au ConfigurationBundlesManager. */
				/* Récupération du Bundle. */
				bundleApplication = ConfigurationBundlesManager
					.getBundleApplication();
			}
			
			catch (Exception e) {
				
				/* constitue rapportConfigurationCsv 
				 * et rapportUtilisateurCsv. 
				 * Jette une BundleManquantRunTimeException 
				 * qui encapsule e. */
				traiterException(e);
				
			}
			
			return bundleApplication;
			
		} // Fin de synchronized.________________________________
				
	} // Fin de getBundleApplication().____________________________________
	
	
	
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
		synchronized (ConfigurationApplicationManager.class) {
			
			ResourceBundle bundleRessourcesExternes = null;
			
			try {
				
				/* DELEGATION au ConfigurationBundlesManager. */
				/* Récupération du Bundle. */
				bundleRessourcesExternes = ConfigurationBundlesManager
					.getBundleRessourcesExternes();
			}
			
			catch (Exception e) {
				
				/* constitue rapportConfigurationCsv 
				 * et rapportUtilisateurCsv. 
				 * Jette une BundleManquantRunTimeException 
				 * qui encapsule e. */
				traiterException(e);
			}
			
			return bundleRessourcesExternes;
			
		} // Fin de synchronized.________________________________
								
	} // Fin de getBundleRessourcesExternes().____________________________________
	

	
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
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 * - CleManquanteRunTimeException si la clé est introuvable.<br/>
	 * - CleNullRunTimeException si la valeur 
	 * n'est pas renseignée pour la clé dans le properties.<br/>
	 * - FichierInexistantRunTimeException si le 
	 * répertoire est inexistant ou pas un répertoire.<br/>
	 */
	public static String getPathRessourcesExternes() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
						
			String pathRessourcesExternes = null;
			
			try {
				
				pathRessourcesExternes 
					= ConfigurationBundlesManager
						.getPathRessourcesExternes();
				
			}
			catch (BundleManquantRunTimeException bundleManquantExc) {
				
				traiterException(bundleManquantExc);
				
			}
			catch (CleManquanteRunTimeException cleManquanteExc) {
				
				traiterCleManquanteException(cleManquanteExc);
				
			}
			catch (CleNullRunTimeException cleNullExc) {
				
				traiterCleNullRunTimeException(cleNullExc);
			}
			catch (FichierInexistantRunTimeException fichierInexistantExc) {
				
				traiterFichierInexistantRunTimeException(
						fichierInexistantExc);
			}
			
			return pathRessourcesExternes;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathRessourcesExternes()._______________________________
	

	
	/**
	 * method getPathRapportsControle() :<br/>
	 * <ul>
	 * <li>Fournit le path <b>EXTERNE</b> (hors classpath) 
	 * du <b>répertoire des rapports de contrôle</b> accessibles 
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
		synchronized (ConfigurationApplicationManager.class) {
						
			String pathRapportsControle = null;
			
			try {
				
				pathRapportsControle 
					= ConfigurationBundlesManager
						.getPathRapportsControle();
				
			}
			catch (BundleManquantRunTimeException bundleManquantExc) {
				
				traiterException(bundleManquantExc);
				
			}
			catch (CleManquanteRunTimeException cleManquanteExc) {
				
				traiterCleManquanteException(cleManquanteExc);
				
			}
			catch (CleNullRunTimeException cleNullExc) {
				
				traiterCleNullRunTimeException(cleNullExc);
			}
			catch (FichierInexistantRunTimeException fichierInexistantExc) {
				
				traiterFichierInexistantRunTimeException(
						fichierInexistantExc);
			}
			
			return pathRapportsControle;
			
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathRapportsControle()._________________________________


	
	/**
	 * method getPathLogs() :<br/>
	 * <ul>
	 * <li>Fournit le path <b>EXTERNE</b> (hors classpath) 
	 * du répertoire des logs accessibles 
	 * par la MOE et les centre-serveur.</li>
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
		synchronized (ConfigurationApplicationManager.class) {

			String pathLogs = null;

			try {

				pathLogs 
					= ConfigurationBundlesManager
						.getPathLogs();

			}
			catch (BundleManquantRunTimeException bundleManquantExc) {

				traiterException(bundleManquantExc);

			}
			catch (CleManquanteRunTimeException cleManquanteExc) {

				traiterCleManquanteException(cleManquanteExc);

			}
			catch (CleNullRunTimeException cleNullExc) {

				traiterCleNullRunTimeException(cleNullExc);
			}
			catch (FichierInexistantRunTimeException fichierInexistantExc) {

				traiterFichierInexistantRunTimeException(
						fichierInexistantExc);
			}

			return pathLogs;
		
		} // Fin de synchronized.__________________________________

	} // Fin de getPathLogs()._____________________________________________


		
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
		synchronized (ConfigurationApplicationManager.class) {

			String pathData = null;

			try {

				pathData 
					= ConfigurationBundlesManager
						.getPathData();

			}
			catch (BundleManquantRunTimeException bundleManquantExc) {

				traiterException(bundleManquantExc);

			}
			catch (CleManquanteRunTimeException cleManquanteExc) {

				traiterCleManquanteException(cleManquanteExc);

			}
			catch (CleNullRunTimeException cleNullExc) {

				traiterCleNullRunTimeException(cleNullExc);
			}
			catch (FichierInexistantRunTimeException fichierInexistantExc) {

				traiterFichierInexistantRunTimeException(
						fichierInexistantExc);
			}

			return pathData;
		
		} // Fin de synchronized.__________________________________
		
	} // Fin de getPathData()._____________________________________________

	
	
	/**
	 * method getBundleMessagesControle() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleMessagesControle.</li>
	 * <li>DELEGUE au ConfigurationBundlesManager.</li>
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
		synchronized (ConfigurationApplicationManager.class) {
			
			/* DELEGATION au ConfigurationBundlesManager. */
			/* Récupération du Bundle. */
			final ResourceBundle bundleMessagesControles 
				= ConfigurationBundlesManager
					.getBundleMessagesControle();
			
			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager
					.getMessageIndividuelRapport();
			
			/* Ajout du message de rapport éventuel 
			 * au rapportConfigurationCsv. */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}
			
			return bundleMessagesControles;
			
		} // Fin de synchronized.________________________________
		
	} // Fin de getBundleMessagesControle()._______________________________
	


	
	/**
	 * method getBundleMessagesTechnique() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleMessagesTechnique.</li>
	 * <li>DELEGUE au ConfigurationBundlesManager.</li>
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
		synchronized (ConfigurationApplicationManager.class) {

			/* DELEGATION au ConfigurationBundlesManager. */
			/* Récupération du Bundle. */
			final ResourceBundle bundleMessagesTechniques 
				= ConfigurationBundlesManager
					.getBundleMessagesTechnique();

			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager
					.getMessageIndividuelRapport();

			/*
			 * Ajout du message de rapport éventuel au
			 * rapportConfigurationCsv.
			 */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}

			return bundleMessagesTechniques;

		} // Fin de synchronized.________________________________

	} // Fin de getBundleMessagesTechnique().______________________________


	
	/**
	 * method getBundleMessagesDiff() :<br/>
	 * <ul>
	 * <li>Fournit un <b>SINGLETON</b> de bundleMessagesDiff.</li>
	 * <li>DELEGUE au ConfigurationBundlesManager.</li>
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
		synchronized (ConfigurationApplicationManager.class) {

			/* DELEGATION au ConfigurationBundlesManager. */
			/* Récupération du Bundle. */
			final ResourceBundle bundleMessagesDiffs 
				= ConfigurationBundlesManager
					.getBundleMessagesDiff();

			/* Récupération du message de rapport éventuel. */
			final String messageRapport 
				= ConfigurationBundlesManager
					.getMessageIndividuelRapport();

			/*
			 * Ajout du message de rapport éventuel au
			 * rapportConfigurationCsv.
			 */
			if (!StringUtils.isBlank(messageRapport)) {
				ajouterMessageAuRapportConfigurationCsv(messageRapport);
			}

			return bundleMessagesDiffs;

		} // Fin de synchronized.________________________________

	} // Fin de getBundleMessagesDiff().___________________________________


	
	/**
	 * method getRapportConfigurationCsv() :<br/>
	 * <ul>
	 * <li>Getter du Rapport Technique (pour les développeurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport AVEC en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * messages de chargement de la configuration;<br/>
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
		synchronized (ConfigurationApplicationManager.class) {
			
			return rapportConfigurationCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportConfigurationCsv().______________________________


	
	/**
	 * method getRapportUtilisateurCsv() :<br/>
	 * <ul>
	 * <li>Getter du Rapport NON Technique (pour les utilisateurs) 
	 * du chargement de la configuration au format csv.</li>
	 * <li>Rapport AVEC en-tête 
	 * [messages de chargement de la configuration;].</li>
	 * <li>Le rapport est <b>null</b> si il n'y a eu aucun 
	 * problème d'initialisation de l'application.</li>
	 * </ul>
	 * exemple : <br/>
	 * messages de chargement de la configuration;<br/>
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin
	 *  - veuillez prévenir le centre serveur svp.;<br/>
	 * <br/>
	 *
	 * @return rapportUtilisateurCsv : String.<br/>
	 */
	public static String getRapportUtilisateurCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			return rapportUtilisateurCsv;
			
		} // Fin de synchronized.________________________________________
		
	} // Fin de getRapportUtilisateurCsv().________________________________

	
	
	/**
	 * method ajouterMessageAuRapportConfigurationCsv(
	 * String pMessage) :<br/>
	 * <ul>
	 * Rajoute le message pMessage au rapport 
	 * de chargement de la configuration au format csv (à la ligne).<br/>
	 * </ul>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Rajoute l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport de chargement de la configuration si nécessaire.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport de chargement de la configuration.<br/>
	 */
	private static void ajouterMessageAuRapportConfigurationCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			/* Rajoute l'en-tête (avec BOM_UTF-8) 
			 * pour le rapport de chargement de la configuration 
			 * si nécessaire. */
			if (StringUtils.isBlank(rapportConfigurationCsv)) {
				rapportConfigurationCsv 
					= fournirEnTeteRapportConfigurationCsv();
			}
			
			/* Rajoute le message au rapport de 
			 * chargement de la configuration au format csv (à la ligne). */			
			stb.append(rapportConfigurationCsv);
			stb.append(NEWLINE);
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
	 * Rajoute le message pMessage au rapport 
	 * utilisateur de la configuration au format csv (à la ligne).<br/>
	 * </ul>
	 * - Ne fait rien si pMessage est blank.<br/>
	 * - Rajoute l'en-tête (avec BOM_UTF-8) 
	 * pour le rapport utilisateur si nécessaire.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : Message à rajouter 
	 * au rapport utilisateur.<br/>
	 */
	private static void ajouterMessageAuRapportUtilisateurCsv(
			final String pMessage) {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			/* Ne fait rien si pMessage est blank. */
			if (StringUtils.isBlank(pMessage)) {
				return;
			}
			
			final StringBuilder stb = new StringBuilder();
			
			/* Rajoute l'en-tête (avec BOM_UTF-8) 
			 * pour le rapport utilisateur 
			 * si nécessaire. */
			if (StringUtils.isBlank(rapportUtilisateurCsv)) {
				rapportUtilisateurCsv 
					= fournirEnTeteRapportConfigurationCsv();
			}
			
			/* Rajoute le message au rapport 
			 * utilisateur au format csv (à la ligne). */			
			stb.append(rapportUtilisateurCsv);
			stb.append(NEWLINE);
			stb.append(pMessage);
			
			rapportUtilisateurCsv = stb.toString();
			
		} // Fin de synchronized.________________________________________
			
	} // Fin de ajouterMessageAuRapportUtilisateurCsv(
	 // String pMessage).__________________________________________________


	
	/**
	 * method fournirEnTeteRapportConfigurationCsv() :<br/>
	 * Fournit l'en-tête pour le rapport de chargement de la configuration 
	 * au format csv 'rapportConfigurationCsv'.<br/>
	 * <br/>
	 * - rajoute un caractère BOM_UTF-8 au début de l'en-tête 
	 * pour forcer Excel à détecter l'encodage UTF-8.<br/>
	 * <br/>
	 *
	 * @return : String : en-tête pour le rapport de chargement 
	 * de la configuration.<br/>
	 */
	private static String fournirEnTeteRapportConfigurationCsv() {
		
		/* Bloc synchronized. */
		synchronized (ConfigurationApplicationManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			/* rajoute un caractère BOM_UTF-8 au début de l'en-tête 
			 * pour forcer Excel à détecter l'encodage UTF-8. */
			stb.append(BOM_UTF_8);
			stb.append("messages de chargement de la configuration");
			stb.append(SEP_PV);
						
			return stb.toString();
			
		} // Fin de synchronized.________________________________________
				
	} // Fin de fournirEnTeteRapportConfigurationCsv().____________________

	
		
	/**
	 * method traiterException(
	 * Exception pE) :<br/>
	 * <ul>
	 * <li>récupère le rapport de configuration csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportConfigutrationCsv'.</li>
	 * <li>récupère le rapport utilisateur csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une BundleManquantRunTimeException 
	 * qui encapsule PE.</li>
	 * </ul>
	 *
	 * @param pE : Exception.<br/>
	 * 
	 * @throws BundleManquantRunTimeException
	 */
	private static void traiterException(
			final Exception pE) 
					throws BundleManquantRunTimeException {
		
		/* Récupération du message de rapport 
		 * de configuration éventuel. */
		final String messageRapport 
			= ConfigurationBundlesManager
					.getRapportConfigurationCsv();
		
		/* Récupération du message de rapport 
		 * utilisateur éventuel. */
		final String messageUtilisateur 
		= ConfigurationBundlesManager.getRapportUtilisateurCsv();
		
		/* Ajout du message de rapport éventuel 
		 * au rapportConfigurationCsv. */
		if (!StringUtils.isBlank(messageRapport)) {
			ajouterMessageAuRapportConfigurationCsv(
					messageRapport);
		}
		
		/* Ajout du message de rapport éventuel 
		 * au rapportUtilisateurCsv. */
		if (!StringUtils.isBlank(messageUtilisateur)) {
			ajouterMessageAuRapportUtilisateurCsv(
					messageUtilisateur);
		}
					
		/* Jette une BundleManquantRunTimeException 
		 * si le properties est manquant. */
		throw new BundleManquantRunTimeException(
				messageRapport, pE);
		
	} // Fin de traiterException(...)._____________________________________
	

	
	/**
	 * method traiterCleManquanteException() :<br/>
	 * <ul>
	 * <li>récupère le rapport de configuration csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportConfigutrationCsv'.</li>
	 * <li>récupère le rapport utilisateur csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une CleManquanteRunTimeException 
	 * qui encapsule PE.</li>
	 * </ul>
	 *
	 * @param pE : Exception.<br/>
	 * 
	 * @throws CleManquanteRunTimeException
	 */
	private static void traiterCleManquanteException(
			final Exception pE) 
					throws CleManquanteRunTimeException {
		
		/* Récupération du message de rapport 
		 * de configuration éventuel. */
		final String messageRapport 
			= ConfigurationBundlesManager
					.getRapportConfigurationCsv();
		
		/* Récupération du message de rapport 
		 * utilisateur éventuel. */
		final String messageUtilisateur 
		= ConfigurationBundlesManager.getRapportUtilisateurCsv();
		
		/* Ajout du message de rapport éventuel 
		 * au rapportConfigurationCsv. */
		if (!StringUtils.isBlank(messageRapport)) {
			ajouterMessageAuRapportConfigurationCsv(
					messageRapport);
		}
		
		/* Ajout du message de rapport éventuel 
		 * au rapportUtilisateurCsv. */
		if (!StringUtils.isBlank(messageUtilisateur)) {
			ajouterMessageAuRapportUtilisateurCsv(
					messageUtilisateur);
		}
					
		/* Jette une CleManquanteRunTimeException 
		 * si la clé est manquante dans le properties. */
		throw new CleManquanteRunTimeException(
				messageRapport, pE);
		
	} // Fin de traiterCleManquanteException(...).________________________-
	
	
	
	/**
	 * method traiterCleNullRunTimeException(
	 * Exception pE) :<br/>
	 * <ul>
	 * <li>récupère le rapport de configuration csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportConfigutrationCsv'.</li>
	 * <li>récupère le rapport utilisateur csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une CleNullRunTimeException 
	 * qui encapsule PE.</li>
	 * </ul>
	 *
	 * @param pE : Exception.<br/>
	 * 
	 * @throws CleNullRunTimeException
	 */
	private static void traiterCleNullRunTimeException(
			final Exception pE) throws CleNullRunTimeException {
		
		/* Récupération du message de rapport 
		 * de configuration éventuel. */
		final String messageRapport 
			= ConfigurationBundlesManager
				.getRapportConfigurationCsv();
		
		/* Récupération du message de rapport 
		 * utilisateur éventuel. */
		final String messageUtilisateur 
		= ConfigurationBundlesManager.getRapportUtilisateurCsv();
		
		/* Ajout du message de rapport éventuel 
		 * au rapportConfigurationCsv. */
		if (!StringUtils.isBlank(messageRapport)) {
			ajouterMessageAuRapportConfigurationCsv(
					messageRapport);
		}
		
		/* Ajout du message de rapport éventuel 
		 * au rapportUtilisateurCsv. */
		if (!StringUtils.isBlank(messageUtilisateur)) {
			ajouterMessageAuRapportUtilisateurCsv(
					messageUtilisateur);
		}
					
		/* Jette une CleNullRunTimeException 
		 * si la clé nepossède pas de valeur. */
		throw new CleNullRunTimeException(
				messageRapport, pE);
		
	} // Fin de traiterCleNullRunTimeException(...)._______________________
	

	
	/**
	 * method traiterFichierInexistantRunTimeException(
	 * Exception pE) :<br/>
	 * <ul>
	 * <li>récupère le rapport de configuration csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportConfigutrationCsv'.</li>
	 * <li>récupère le rapport utilisateur csv produit 
	 * par le ConfigurationBundlesManager en cas d'Exception.</li>
	 * <li>ajoute ce rapport à 'rapportUtilisateurCsv'.</li>
	 * <li>Jette une FichierInexistantRunTimeException 
	 * qui encapsule PE.</li>
	 * </ul>
	 *
	 * @param pE : Exception.<br/>
	 * 
	 * @throws FichierInexistantRunTimeException
	 */
	private static void traiterFichierInexistantRunTimeException(
			final Exception pE) throws FichierInexistantRunTimeException {
		
		/* Récupération du message de rapport 
		 * de configuration éventuel. */
		final String messageRapport 
			= ConfigurationBundlesManager
					.getRapportConfigurationCsv();
		
		/* Récupération du message de rapport 
		 * utilisateur éventuel. */
		final String messageUtilisateur 
		= ConfigurationBundlesManager.getRapportUtilisateurCsv();
		
		/* Ajout du message de rapport éventuel 
		 * au rapportConfigurationCsv. */
		if (!StringUtils.isBlank(messageRapport)) {
			ajouterMessageAuRapportConfigurationCsv(
					messageRapport);
		}
		
		/* Ajout du message de rapport éventuel 
		 * au rapportUtilisateurCsv. */
		if (!StringUtils.isBlank(messageUtilisateur)) {
			ajouterMessageAuRapportUtilisateurCsv(
					messageUtilisateur);
		}
					
		/* Jette une FichierInexistantRunTimeException 
		 * si le répertoire est inexistant ou fichier simple. */
		throw new FichierInexistantRunTimeException(
				messageRapport, pE);

	} // Fin de traiterFichierInexistantRunTimeException(...)._____________
	
	
	
} // FIN DE LA CLASSE ConfigurationApplicationManager.-----------------------
