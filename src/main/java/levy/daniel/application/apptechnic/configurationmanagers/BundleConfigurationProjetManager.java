package levy.daniel.application.apptechnic.configurationmanagers;

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
 * CLASSE <b>BundleConfigurationProjetManager</b> :<br/>
 * Classe <b>utilitaire (méthodes static)</b> chargée de gérer 
 * les données de configuration du code à générer 
 * (chemin du Workspace, nom du projet, path des sources java, ...).<br/>
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
 * @since 4 janv. 2018
 *
 */
public final class BundleConfigurationProjetManager {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER : String :<br/>
	 * "Classe BundleConfigurationProjetManager".<br/>
	 */
	public static final String CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER 
		= "Classe BundleConfigurationProjetManager";

	
	/**
	 * METHODE_GET_BUNDLE_CONFIGURATION_PROJET : String :<br/>
	 * "Méthode getBundleConfigurationProjet()".<br/>
	 */
	public static final String METHODE_GET_BUNDLE_CONFIGURATION_PROJET 
		= "Méthode getBundleConfigurationProjet()";
	

	
	/**
	 * METHODE_GET_BUNDLE_INTERNE : String :<br/>
	 * "Méthode getBundleInterne(
	 * String pNomBaseProperties, Locale pLocale)".<br/>
	 */
	public static final String METHODE_GET_BUNDLE_INTERNE 
		= "Méthode getBundleInterne(String pNomBaseProperties"
				+ ", Locale pLocale)";


	/**
	 * METHODE_GET_PATH_WORKSPACE : String :<br/>
	 * "Méthode getPathWorkspace()".<br/>
	 */
	public static final String METHODE_GET_PATH_WORKSPACE 
		= "Méthode getPathWorkspace()";
	
	
	/**
	 * METHODE_GET_NOMPROJET : String :<br/>
	 * "Méthode getNomProjet()".<br/>
	 */
	public static final String METHODE_GET_NOMPROJET 
		= "Méthode getNomProjet()";
	
	
	/**
	 * METHODE_GET_NOMREPERTOIRESRC : String :<br/>
	 * "Méthode getNomRepertoireSrc()".<br/>
	 */
	public static final String METHODE_GET_NOMREPERTOIRESRC 
		= "Méthode getNomRepertoireSrc()";
	
	
	/**
	 * METHODE_GET_PATHMAINJAVA : String :<br/>
	 * "Méthode getPathMainJava()".<br/>
	 */
	public static final String METHODE_GET_PATHMAINJAVA 
		= "Méthode getPathMainJava()";

	
	/**
	 * METHODE_GET_PATHMAINRESOURCES : String :<br/>
	 * "Méthode getPathMainResources()".<br/>
	 */
	public static final String METHODE_GET_PATHMAINRESOURCES
		= "Méthode getPathMainResources()";
	
	
	/**
	 * METHODE_GET_PATHTESTJAVA : String :<br/>
	 * "Méthode getPathTestJava()".<br/>
	 */
	public static final String METHODE_GET_PATHTESTJAVA 
		= "Méthode getPathTestJava()";

	
	/**
	 * METHODE_GET_PATHTESTRESOURCES : String :<br/>
	 * "Méthode getPathTestResources()".<br/>
	 */
	public static final String METHODE_GET_PATHTESTRESOURCES
		= "Méthode getPathTestResources()";

	
	/**
	 * METHODE_GET_GROUPID : String :<br/>
	 * "Méthode getGroupid()".<br/>
	 */
	public static final String METHODE_GET_GROUPID 
		= "Méthode getGroupid()";
	

	
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

	
	/**
	 * SLASH : char :<br/>
	 * '/'.<br/>
	 */
	public static final char SLASH = '/';
	
	
	/**
	 * ANTISLASH : char :<br/>
	 * '\'.<br/>
	 * ATTENTION : antislash est un caractère spécial 
	 * qui doit être échappé en Java ('\\')<br/>
	 */
	public static final char ANTISLASH = '\\';


	
	/**
	 * POINT : char :<br/>
	 * '.'.<br/>
	 */
	public static final char POINT = '.';




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
	 * bundleConfigurationProjet : ResourceBundle : <br/>
	 * <ul>
	 * <li><b>SINGLETON</b>.</li>
	 * <li>Contient les <b>paramétrages généraux</b> 
	 * du projet à générer (nom de l'application
	 * , répertoire des sources, ...).</li>
	 * <li>encapsule racine_binaires/
	 * <b>configuration_projet.properties</b>.</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA.</li> 
	 * <li>Uniquement accessible pour le centre serveur.</li>
	 * </ul>
	 */
	private static ResourceBundle bundleConfigurationProjet;


	/**
	 * pathWorkspace : String :<br/>
	 * path du workspace indiqué dans 
	 * configuration_projet.properties.<br/>
	 */
	private static String pathWorkspace;
	

	/**
	 * nomProjet : String :<br/>
	 * Nom du projet dans lequel générer du code.<br/>
	 */
	private static String nomProjet;

	
	/**
	 * nomRepertoireSrc : String :<br/>
	 * Nom du répertoire src dans lequel générer du code.<br/>
	 */
	private static String nomRepertoireSrc;
	
	
	/**
	 * pathRelMainJava : String :<br/>
	 * path relatif des sources java par rapport à src.<br/>
	 */
	private static String pathRelMainJava;
	
	
	/**
	 * pathRelMainResources : String :<br/>
	 * path relatif des ressources par rapport à src.<br/>
	 */
	private static String pathRelMainResources;

	
	/**
	 * pathRelTestJava : String :<br/>
	 * path relatif des sources des tests JUnit 
	 * par rapport à src.<br/>
	 */
	private static String pathRelTestJava;
	
	
	/**
	 * pathRelTestResources : String :<br/>
	 * path relatif des ressources des tests JUnit 
	 * par rapport à src.<br/>
	 */
	private static String pathRelTestResources;
	
	
	
	/**
	 * pathRelMainJava : String :<br/>
	 * path absolu des sources java.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java<br/>
	 */
	private static String racineMainJava;
	
	
	/**
	 * pathRelMainResources : String :<br/>
	 * path absolu des ressources.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/resources<br/>
	 */
	private static String racineMainResources;

	
	/**
	 * pathRelTestJava : String :<br/>
	 * path absolu des sources des tests JUnit.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/test/java<br/>
	 */
	private static String racineTestJava;
	
	
	/**
	 * pathRelTestResources : String :<br/>
	 * path absolu des ressources des tests JUnit.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/test/resources<br/>
	 */
	private static String racineTestResources;
	

	/**
	 * groupid : String :<br/>
	 * groupid Maven du projet.<br/>
	 * Exemple : "levy.daniel.application"<br/>
	 */
	private static String groupid;
	
	
	/**
	 * pathRelGroupId : String :<br/>
	 * path relatif du groupid Maven du projet par rapport 
	 * au path absolu des sources java.<br/>
	 * Exemple : "levy/daniel/application"<br/>
	 */
	private static String pathRelGroupId;

	
	/**
	 * pathAppTechnic : String :<br/>
	 * path absolu du repertoire apptechnic.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * apptechnic<br/>
	 */
	private static String pathAppTechnic;

		
	/**
	 * pathControllers : String :<br/>
	 * path absolu du repertoire controllers.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * controllers<br/>
	 */
	private static String pathControllers;

	
	/**
	 * pathModel : String :<br/>
	 * path absolu du repertoire model.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model<br/>
	 */
	private static String pathModel;

	
	/**
	 * pathVues : String :<br/>
	 * path absolu du repertoire vues.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * vues<br/>
	 */
	private static String pathVues;
	
	
	/**
	 * pathDao : String :<br/>
	 * path absolu du repertoire model/dao.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model/dao<br/>
	 */
	private static String pathDao;
	
	
	/**
	 * pathMetier : String :<br/>
	 * path absolu du repertoire model/metier.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model/metier<br/>
	 */
	private static String pathMetier;
	
	
	/**
	 * pathServices : String :<br/>
	 * path absolu du repertoire model/services.<br/>
	 * Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model/services<br/>
	 */
	private static String pathServices;

	
	
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
	 * Classe BundleConfigurationProjetManager - 
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
	private static final Log LOG 
		= LogFactory.getLog(BundleConfigurationProjetManager.class);

	// *************************METHODES************************************/
	
	
	
	 /**
	 * method CONSTRUCTEUR BundleConfigurationProjetManager() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private BundleConfigurationProjetManager() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * method getBundleConfigurationProjet() :<br/>
	 * <ul>
	 * <ul>
	 * <li>Getter de bundleConfigurationProjet.</li>
	 * <li>Fournit un <b>singleton</b> de bundleConfigurationProjet 
	 * (configuration_projet.properties).</li>
	 * <li>bundleConfigurationProjet encapsule 
	 * racine_binaires/<b>configuration_projet.properties</b>.</li>
	 * <li>bundleConfigurationProjet contient les <b>paramétrages généraux</b> 
	 * du projet à générer (nom de l'application
	 * , répertoire des sources, ...).</li>
	 * <li>Situé sous la racine des binaires, donc dans le classpath
	 * , et donc présent dans les jar/war.</li>
	 * <li>NON PARAMETRABLE PAR LA MOA.</li> 
	 * <li>Uniquement accessible pour le centre serveur.</li>
	 * <br/>
	 * - Jette une BundleManquantRunTimeException, LOG.FATAL et rapporte 
	 * si le properties est introuvable.<br/>
	 * Exemple de message :<br/>
	 * "Classe BundleConfigurationProjetManager 
	 * - Méthode getBundleConfigurationProjet() 
	 * - Le fichier 'application_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin".<br/>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : bundleConfigurationProjet.<br/>
	 * 
	 * @throws Exception : BundleManquantRunTimeException 
	 * si le properties est introuvable.<br/>
	 */
	public static ResourceBundle getBundleConfigurationProjet() 
											throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
						
			if (bundleConfigurationProjet == null) {
								
				bundleConfigurationProjet 
					= getBundleInterne(
							getNomBasePropertiesConfigurationProjet()
							, LocaleManager.getLocaleApplication());
				
			} // Fin de if (bundleConfigurationProjet == null).__________
			
			return bundleConfigurationProjet;
			
		} // Fin de synchronized.__________________________________
				
	} // Fin de getBundleConfigurationProjet().____________________________
	

	
	/**
	 * method getNomBasePropertiesConfigurationProjet() :<br/>
	 * <ul>
	 * <li>Retourne le nom de base du properties contenant propriétés 
	 * générales du projet à générer (nom, répertoire des sources, ...).</li>
	 * <li>"configuration_projet".</li>
	 * </ul>
	 *
	 * @return : String : "configuration_projet".<br/>
	 */
	private static String getNomBasePropertiesConfigurationProjet() {
		return "configuration_projet";
	} // Fin de getNomBasePropertiesConfigurationProjet()._________________
	
	

	
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
	 * "Classe BundleConfigurationProjetManager 
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
		synchronized (BundleConfigurationProjetManager.class) {
			
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
	 * method getPathWorkspace() :<br/>
	 * <ul>
	 * <li>Getter du path du workspace indiqué 
	 * dans configuration_projet.properties.</li>
	 * <li>Exemple : "D:/Donnees/eclipse/eclipseworkspace_neon/"</li>
	 * </ul>
	 *
	 * @return pathWorkspace : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathWorkspace() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (pathWorkspace == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					pathWorkspace 
						= bundleConfigurationProjet
							.getString(getClePathWorkspace()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_PATH_WORKSPACE
								, nomBaseProperties
									, mre
									, getClePathWorkspace());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathWorkspace)) {
				
				traiterCleVide(
						METHODE_GET_PATH_WORKSPACE
						, getClePathWorkspace()
						, nomBaseProperties);
				
			}
			
			return pathWorkspace;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getPathWorkspace().________________________________________


	
	/**
	 * method getClePathWorkspace() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au path du workspace.</li>
	 * <li>"workspace.home".</li>
	 * </ul>
	 *
	 * @return : String : "workspace.home".<br/>
	 */
	private static String getClePathWorkspace() {
		return "workspace.home";
	} // Fin de getClePathWorkspace()._____________________________________
	

	
	
	/**
	 * method getNomProjet() :<br/>
	 * <ul>
	 * <li>Getter du nom du projet dans lequel générer du code.</li>
	 * <li>Exemple : "users"</li>
	 * </ul>
	 *
	 * @return nomProjet : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getNomProjet() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (nomProjet == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					nomProjet 
						= bundleConfigurationProjet
							.getString(getCleNomProjet()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_NOMPROJET
								, nomBaseProperties
									, mre
									, getCleNomProjet());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(nomProjet)) {
				
				traiterCleVide(
						METHODE_GET_NOMPROJET
						, getCleNomProjet()
						, nomBaseProperties);
				
			}
			
			return nomProjet;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getNomProjet().____________________________________________



	/**
	 * method getCleNomProjet() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au nom du projet dans lequel générer du code.</li>
	 * <li>"projet.nom".</li>
	 * </ul>
	 *
	 * @return : String : "projet.nom".<br/>
	 */
	private static String getCleNomProjet() {
		return "projet.nom";
	} // Fin de getCleNomProjet()._________________________________________
	

	
	/**
	 * method getNomRepertoireSrc() :<br/>
	 * <ul>
	 * <li>Getter du nom du répertoire des sources 
	 * dans lequel générer du code.</li>
	 * <li>Exemple : "src"</li>
	 * </ul>
	 *
	 * @return nomRepertoireSrc : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getNomRepertoireSrc() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (nomRepertoireSrc == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					nomRepertoireSrc 
						= bundleConfigurationProjet
							.getString(getCleNomRepertoireSrc()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_NOMREPERTOIRESRC
								, nomBaseProperties
									, mre
									, getCleNomRepertoireSrc());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(nomRepertoireSrc)) {
				
				traiterCleVide(
						METHODE_GET_NOMREPERTOIRESRC
						, getCleNomRepertoireSrc()
						, nomBaseProperties);
				
			}
			
			return nomRepertoireSrc;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getNomRepertoireSrc()._____________________________________



	/**
	 * method getCleNomRepertoireSrc() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au répertoire des sources dans lequel générer du code.</li>
	 * <li>"root.src".</li>
	 * </ul>
	 *
	 * @return : String : "root.src".<br/>
	 */
	private static String getCleNomRepertoireSrc() {
		return "root.src";
	} // Fin de getCleNomRepertoireSrc().__________________________________
	

	
	/**
	 * method getPathRelMainJava() :<br/>
	 * <ul>
	 * <li>Getter du path relatif des sources java par rapport à src
	 * dans lequel générer du code.</li>
	 * <li>Exemple : "main/java"</li>
	 * </ul>
	 *
	 * @return pathRelMainJava : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathRelMainJava() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (pathRelMainJava == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					pathRelMainJava 
						= bundleConfigurationProjet
							.getString(getClePathRelMainJava()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_PATHMAINJAVA
								, nomBaseProperties
									, mre
									, getClePathRelMainJava());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathRelMainJava)) {
				
				traiterCleVide(
						METHODE_GET_PATHMAINJAVA
						, getClePathRelMainJava()
						, nomBaseProperties);
				
			}
			
			return pathRelMainJava;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getPathRelMainJava().______________________________________



	/**
	 * method getClePathRelMainJava() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au path relatif des sources Java par rapport à src
	 * dans lequel générer du code.</li>
	 * <li>"main.java".</li>
	 * </ul>
	 *
	 * @return : String : "main.java".<br/>
	 */
	private static String getClePathRelMainJava() {
		return "main.java";
	} // Fin de getClePathRelMainJava().___________________________________
	

	
	/**
	 * method getPathRelMainResources() :<br/>
	 * <ul>
	 * <li>Getter du path relatif des ressources java par rapport à src
	 * dans lequel générer du code.</li>
	 * <li>Exemple : "main/resources"</li>
	 * </ul>
	 *
	 * @return pathRelMainResources : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathRelMainResources() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (pathRelMainResources == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					pathRelMainResources 
						= bundleConfigurationProjet
							.getString(getClePathRelMainResources()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_PATHMAINRESOURCES
								, nomBaseProperties
									, mre
									, getClePathRelMainResources());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathRelMainResources)) {
				
				traiterCleVide(
						METHODE_GET_PATHMAINRESOURCES
						, getClePathRelMainResources()
						, nomBaseProperties);
				
			}
			
			return pathRelMainResources;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getPathRelMainResources()._________________________________



	/**
	 * method getClePathRelMainResources() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au path relatif des ressources java par rapport à src 
	 * dans lequel générer du code.</li>
	 * <li>"main.resources".</li>
	 * </ul>
	 *
	 * @return : String : "main.resources".<br/>
	 */
	private static String getClePathRelMainResources() {
		return "main.resources";
	} // Fin de getClePathRelMainResources().______________________________
	

	
	/**
	 * method getPathRelTestJava() :<br/>
	 * <ul>
	 * <li>Getter du path relatif des sources des tests JUnit 
	 * par rapport à src
	 * dans lequel générer du code.</li>
	 * <li>Exemple : "test/java"</li>
	 * </ul>
	 *
	 * @return pathRelTestJava : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathRelTestJava() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (pathRelTestJava == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					pathRelTestJava 
						= bundleConfigurationProjet
							.getString(getClePathRelTestJava()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_PATHTESTJAVA
								, nomBaseProperties
									, mre
									, getClePathRelTestJava());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathRelTestJava)) {
				
				traiterCleVide(
						METHODE_GET_PATHTESTJAVA
						, getClePathRelTestJava()
						, nomBaseProperties);
				
			}
			
			return pathRelTestJava;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getPathRelTestJava().______________________________________



	/**
	 * method getClePathRelTestJava() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au path relatif des sources des tests JUnit 
	 * par rapport à src
	 * dans lequel générer du code.</li>
	 * <li>"test.java".</li>
	 * </ul>
	 *
	 * @return : String : "test.java".<br/>
	 */
	private static String getClePathRelTestJava() {
		return "test.java";
	} // Fin de getClePathRelTestJava().___________________________________
	

	
	/**
	 * method getPathRelTestResources() :<br/>
	 * <ul>
	 * <li>Getter du path relatif des ressources des tests JUnit 
	 * par rapport à src
	 * dans lequel générer du code.</li>
	 * <li>Exemple : "test/resources"</li>
	 * </ul>
	 *
	 * @return pathRelTestResources : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathRelTestResources() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (pathRelTestResources == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					pathRelTestResources 
						= bundleConfigurationProjet
							.getString(getClePathRelTestResources()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_PATHTESTRESOURCES
								, nomBaseProperties
									, mre
									, getClePathRelTestResources());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(pathRelTestResources)) {
				
				traiterCleVide(
						METHODE_GET_PATHTESTRESOURCES
						, getClePathRelTestResources()
						, nomBaseProperties);
				
			}
			
			return pathRelTestResources;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getPathRelTestResources()._________________________________



	/**
	 * method getClePathRelTestResources() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au path relatif des ressources des tests JUnit 
	 * par rapport à src 
	 * dans lequel générer du code.</li>
	 * <li>"test.resources".</li>
	 * </ul>
	 *
	 * @return : String : "test.resources".<br/>
	 */
	private static String getClePathRelTestResources() {
		return "test.resources";
	} // Fin de getClePathRelTestResources().______________________________
	

		
	/**
	 * method getRacineMainJava() :<br/>
	 * <ul>
	 * <li>Getter du path absolu des sources java.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java</li>
	 * </ul>
	 *
	 * @return racineMainJava : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getRacineMainJava() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (racineMainJava == null) {
				
				racineMainJava 
				= getPathWorkspace() 
				+ SLASH
				+ getNomProjet()
				+ SLASH
				+ getNomRepertoireSrc() 
				+ SLASH 
				+ getPathRelMainJava();
				
			}
			
			return racineMainJava;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getRacineMainJava()._______________________________________


	
	/**
	 * method getRacineMainResources() :<br/>
	 * <ul>
	 * <li>Getter du path absolu des ressources.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/resources</li>
	 * </ul>
	 *
	 * @return racineMainResources : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getRacineMainResources() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (racineMainResources == null) {
				
				racineMainResources 
				= getPathWorkspace() 
				+ SLASH
				+ getNomProjet()
				+ SLASH
				+ getNomRepertoireSrc() 
				+ SLASH 
				+ getPathRelMainResources();
				
			}
			
			return racineMainResources;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getRacineMainResources().__________________________________


	
	/**
	 * method getRacineTestJava() :<br/>
	 * <ul>
	 * <li>Getter du path absolu des sources des tests JUnit.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/test/java</li>
	 * </ul>
	 *
	 * @return racineTestJava : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getRacineTestJava() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (racineTestJava == null) {
				
				racineTestJava 
				= getPathWorkspace() 
				+ SLASH
				+ getNomProjet()
				+ SLASH
				+ getNomRepertoireSrc() 
				+ SLASH 
				+ getPathRelTestJava();
				
			}
			
			return racineTestJava;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getRacineTestJava()._______________________________________


	
	/**
	 * method getRacineTestResources() :<br/>
	 * <ul>
	 * <li>Getter du path absolu des ressources des tests JUnit.<br/>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/test/resources</li>
	 * </ul>
	 *
	 * @return racineTestResources : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getRacineTestResources() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (racineTestResources == null) {
				
				racineTestResources 
				= getPathWorkspace() 
				+ SLASH
				+ getNomProjet()
				+ SLASH
				+ getNomRepertoireSrc() 
				+ SLASH 
				+ getPathRelTestResources();
				
			}
			
			return racineTestResources;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getRacineTestResources().__________________________________


	
	/**
	 * method getGroupid() :<br/>
	 * <ul>
	 * <li>Getter du groupid Maven du projet.</li>
	 * <li>Exemple : "levy.daniel.application"</li>
	 * </ul>
	 *
	 * @return groupid : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getGroupid() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			final String nomBaseProperties 
				= getNomBasePropertiesConfigurationProjet();
			
			if (groupid == null) {
				
				if (bundleConfigurationProjet == null) {
					getBundleConfigurationProjet();
				}
				
				try {
					
					groupid 
						= bundleConfigurationProjet
							.getString(getCleGroupid()).trim();
					
				} catch (MissingResourceException mre) {
					
					/* cas où la clé est manquante dans le properties. */
					traiterMissingResourceException(
							METHODE_GET_GROUPID
								, nomBaseProperties
									, mre
									, getCleGroupid());
				}
			}
			
			/* Clé vide (sans valeur). */
			if (StringUtils.isBlank(groupid)) {
				
				traiterCleVide(
						METHODE_GET_GROUPID
						, getCleGroupid()
						, nomBaseProperties);
				
			}
			
			return groupid;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getGroupid().______________________________________________



	/**
	 * method getCleGroupid() :<br/>
	 * <ul>
	 * <li>Retourne la clé dans configuration_projet.properties 
	 * associée au groupid Maven du projet.</li>
	 * <li>"groupid".</li>
	 * </ul>
	 *
	 * @return : String : "groupid".<br/>
	 */
	private static String getCleGroupid() {
		return "groupid";
	} // Fin de getCleGroupid().___________________________________________
	
	
	
	/**
	 * method getPathRelGroupId() :<br/>
	 * <ul>
	 * <li> Getter du path relatif du groupid Maven du projet par rapport 
	 * au path absolu des sources java.</li>
	 * <li>Exemple : "levy/daniel/application"</li>
	 * </ul>
	 *
	 * @return pathRelGroupId : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathRelGroupId() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathRelGroupId == null) {
				
				if (groupid == null) {
					getGroupid();
				}
				
				pathRelGroupId = remplacerPointparSlash(groupid);
								
			}
			
			return pathRelGroupId;
			
		} // Fin de synchronized.___________________________________
			
	} // Fin de getPathRelGroupId()._______________________________________


	
	/**
	 * method getPathAppTechnic() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire apptechnic.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * apptechnic</li>
	 * </ul>
	 *
	 * @return pathAppTechnic : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathAppTechnic() throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathAppTechnic == null) {
				
				pathAppTechnic 
				= getRacineMainJava() 
				+ SLASH + getPathRelGroupId()
				+ SLASH 
				+ "apptechnic";
				
			}
			
			return pathAppTechnic;
			
		} // Fin de synchronized.___________________________________
					
	} // Fin de getPathAppTechnic()._______________________________________


	
	/**
	 * method getPathControllers() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire controllers.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * controllers</li>
	 * </ul>
	 *
	 * @return pathControllers : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathControllers() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathControllers == null) {
				
				pathControllers 
				= getRacineMainJava() 
				+ SLASH + getPathRelGroupId()
				+ SLASH 
				+ "controllers";
				
			}
			
			return pathControllers;
			
		} // Fin de synchronized.___________________________________
					
	} // Fin de getPathControllers().______________________________________


	
	/**
	 * method getPathModel() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire model.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model</li>
	 * </ul>
	 *
	 * @return pathModel : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathModel() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathModel == null) {
				
				pathModel 
				= getRacineMainJava() 
				+ SLASH + getPathRelGroupId()
				+ SLASH 
				+ "model";
				
			}
			
			return pathModel;
			
		} // Fin de synchronized.___________________________________
							
	} // Fin de getPathModel().____________________________________________


		
	/**
	 * method getPathVues() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire vues.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * vues</li>
	 * </ul>
	 *
	 * @return pathVues : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathVues() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathVues == null) {
				
				pathVues 
				= getRacineMainJava() 
				+ SLASH + getPathRelGroupId()
				+ SLASH 
				+ "vues";
				
			}
			
			return pathVues;
			
		} // Fin de synchronized.___________________________________
							
	} // Fin de getPathVues()._____________________________________________


	
	/**
	 * method getPathDao() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire model/dao.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model/dao</li>
	 * </ul>
	 *
	 * @return pathDao : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathDao() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathDao == null) {
				
				pathDao 
				= getPathModel()
				+ SLASH 
				+ "dao";
				
			}
			
			return pathDao;
			
		} // Fin de synchronized.___________________________________
							
	} // Fin de getPathDao().______________________________________________

	
	
	/**
	 * method getPathMetier() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire model/metier.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model/metier</li>
	 * </ul>
	 *
	 * @return pathMetier : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathMetier() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathMetier == null) {
				
				pathMetier 
				= getPathModel()
				+ SLASH 
				+ "metier";
				
			}
			
			return pathMetier;
			
		} // Fin de synchronized.___________________________________
							
	} // Fin de getPathMetier().___________________________________________


		
	/**
	 * method getPathServices() :<br/>
	 * <ul>
	 * <li>Getter du path absolu du repertoire model/services.</li>
	 * <li>Exemple : D:/Donnees/eclipse/eclipseworkspace_neon/
	 * generation_code/src/main/java/levy/daniel/application/
	 * model/services</li>
	 * </ul>
	 *
	 * @return pathServices : String.<br/>
	 * 
	 * @throws Exception 
	 */
	public static String getPathServices() 
			throws Exception {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
			if (pathServices == null) {
				
				pathServices 
				= getPathModel()
				+ SLASH 
				+ "services";
				
			}
			
			return pathServices;
			
		} // Fin de synchronized.___________________________________
							
	} // Fin de getPathServices()._________________________________________


	
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
	 * Classe BundleConfigurationProjetManager - 
	 * Méthode getBundleInterne(String pNomBaseProperties, Locale pLocale) - 
	 * Le fichier 'applicatio_fr_FR.properties' est introuvable. 
	 * Il devrait se trouver juste sous la racine des binaires /bin;<br/>
	 * <br/>
	 *
	 * @return rapportConfigurationCsv : String.<br/>
	 */
	public static String getRapportConfigurationCsv() {
		
		/* Bloc synchronized. */
		synchronized (BundleConfigurationProjetManager.class) {
			
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
		synchronized (BundleConfigurationProjetManager.class) {
			
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
		synchronized (BundleConfigurationProjetManager.class) {
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
		synchronized (BundleConfigurationProjetManager.class) {
			
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
		synchronized (BundleConfigurationProjetManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER);
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
		synchronized (BundleConfigurationProjetManager.class) {
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER);
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
		synchronized (BundleConfigurationProjetManager.class) {
			
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
		synchronized (BundleConfigurationProjetManager.class) {
			
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
		= CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER 
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
		= CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER 
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
			= CLASSE_BUNDLE_CONFIGURATION_PROJET_MANAGER
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
	

	
	/**
	 * method remplacerPointparSlash(
	 * String pString) :<br/>
	 * <ul>
	 * <li>Remplace les points '.' dans pString par des slashs '/'.</li>
	 * <li>Exemple : "levy.daniel.application" 
	 * remplacé par "levy/daniel/application".</li>
	 * </ul>
	 * retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String.<br/>
	 * 
	 * @return : String : String dans laquelle les points 
	 * ont été remplacés par des slash.<br/>
	 */
	private static String remplacerPointparSlash(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		String resultat = null;
		
		resultat = StringUtils.replaceChars(pString, POINT, SLASH);
		
		return resultat;
		
	} // Fin de remplacerPointparSlash(...)._______________________________
	
	
	
	/**
	 * method remplacerSlashparPoint(
	 * String pString) :<br/>
	 * <ul>
	 * <li>Remplace les slashs '/' dans pString par des points '.'.</li>
	 * <li>Exemple : "levy/daniel/application" 
	 * remplacé par "levy.daniel.application".</li>
	 * </ul>
	 * retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String.<br/>
	 * 
	 * @return : String : String dans laquelle les slashs 
	 * ont été remplacés par des points.<br/>
	 */
	private static String remplacerSlashparPoint(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		String resultat = null;
		
		resultat = StringUtils.replaceChars(pString, SLASH, POINT);
		
		return resultat;
		
	} // Fin de remplacerSlashparPoint(...)._______________________________
	

		
	/**
	 * method remplacerAntiSlashparPoint(
	 * String pString) :<br/>
	 * <ul>
	 * <li>Remplace les antislashs '\' dans pString par des points '.'.</li>
	 * <li>Exemple : "levy\daniel\application" 
	 * remplacé par "levy.daniel.application".</li>
	 * <li>ATTENTION : antislash est un caractère spécial 
	 * qui doit être échappé en Java ('\\')</li>
	 * </ul>
	 * retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String.<br/>
	 * 
	 * @return : String : String dans laquelle les antislashs 
	 * ont été remplacés par des points.<br/>
	 */
	private static String remplacerAntiSlashparPoint(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		String resultat = null;
		
		resultat = StringUtils.replaceChars(pString, ANTISLASH, POINT);
		
		return resultat;
		
	} // Fin de remplacerAntiSlashparPoint(...)._______________________________
	
	
	
} // FIN DE LA CLASSE BundleConfigurationProjetManager.----------------------
