package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class GestionnaireRG :<br/>
 * Classe <b>utilitaire</b> (dotée de méthodes statiques) 
 * chargée de gérer en un <b>point unique</b> 
 * l'implémentation des <b>règles de gestion (RG)</b> 
 * de toute l'application.<br/>
 * <ul>
 * <li>La méthode <b>afficherListeRGImplementeesCsv()</b> 
 * retourne une String pour l'affichage de toutes 
 * les RG implémentées dans l'application.</li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code>
 * // Récupération du listing des RG.<br/>
 * final String listingRG 
 * = GestionnaireRG.afficherListeRGImplementeesCsv();<br/>
 * </code>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Manager, Configurateur, Règle de Gestion, RG, <br/>
 * Trier Map, Sort Collection, <br/>
 * Bloc static, Ressources externes, hors classpath,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 26 août 2017
 *
 */
public final class GestionnaireRG {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * RG_PROPERTIES : String :<br/>
	 * fichier properties contenant les booleans d'activation 
	 * des contrôles des RG.<br/>
	 * "rg.properties".<br/>
	 */
	public static final String RG_PROPERTIES 
		= "rg.properties";
	
	
	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	
	
	/**
	 * bundleExterneRG : ResourceBundle :<br/>
	 * ResourceBundle encapsulant rg.properties.<br/>
	 * rg.properties est un fichier EXTERNE (hors classpath) 
	 * qui doit être accessible à la Maîtrise d'Ouvrage (MOA).<br/>
	 */
	private static ResourceBundle bundleExterneRG;
	
	
	/**
	 * mapRG : Map&lt;String,LigneRG&gt; :<br/>
	 * <ul>
	 * Map contenant toutes les RG implémentées dans l'application avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 * Une ligne RG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;].<br/>
	 */
	private static Map<String, LigneRG> mapRG 
		= new ConcurrentHashMap<String, LigneRG>();

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(GestionnaireRG.class);
	
	
static {
	
	try {
		
		remplirMapRG();
		
	} catch (MalformedURLException malformedURLexc) {
		
		final String message 
			= "Impossible de fournir la liste des RG implémentées";
		
		if (LOG.isFatalEnabled()) {
			LOG.fatal(message, malformedURLexc);
		}
	}
}


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR GestionnaireRG() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private GestionnaireRG() {
		
		super();
				
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	


	/**
	 * method getBundleExterneRG() :<br/>
	 * Fournit le ResourceBundle associé au fichier <i>externe</i> 
	 * (hors classpath) <b>rg.properties</b> 
	 * avec la Locale Locale_fr_FR.<br/>
	 * <br/>
	 *
	 * @return : ResourceBundle : rg.properties.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	public static ResourceBundle getBundleExterneRG() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRG.class) {
			
			if (bundleExterneRG == null) {
				bundleExterneRG = getBundleExterneRG(Locale.getDefault());
			}
			
			return bundleExterneRG;
			
		} // Fin de bloc synchronized.__________________________
				
	} // Fin de getBundleExterneRG().______________________________________
	
	
	
	/**
	 * method getBundleExterneRG(
	 * Locale pLocale) :<br/>
	 * Fournit le ResourceBundle associé au fichier externe rg.properties 
	 * avec la Locale pLocale.<br/>
	 * <br/>
	 *
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : ResourceBundle.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private static ResourceBundle getBundleExterneRG(
			final Locale pLocale) throws MalformedURLException {
		
		synchronized (GestionnaireRG.class) {
			
			ResourceBundle resourceBundle = null;
							
			/* Accède au répertoire externe contenant rg.properties. */
			final File repertoireRessourcesParametrables 
			= new File(fournirCheminRessourceExterneRG());
							
			final URL[] urlsRessourcesParametrables 
			= {repertoireRessourcesParametrables.toURI().toURL()};
		
			final ClassLoader loaderRessourcesParametrables 
				= new URLClassLoader(urlsRessourcesParametrables);
			
			resourceBundle 
				= ResourceBundle
					.getBundle("rg"
							, pLocale
								, loaderRessourcesParametrables);
														
			return resourceBundle;
			
		} // Fin de bloc synchronized.__________________________
				
	} // Fin de getBundleExterneRG(...).___________________________________
	

	
	/**
	 * method fournirCheminRessourceExterneRG() :<br/>
	 * fournit le chemin (externe au projet) du répertoire 
	 * contenant le fichier rg.properties.<br/>
	 * "D:/Donnees/eclipse/eclipseworkspace_neon/
	 * tuto_maven_sonatype/ressources_externes".<br/>
	 * Ce chemin doit être écrit EN DUR 
	 * (surtout pas relatif au projet Eclipse).<br/>
	 * <br/>
	 *
	 * @return : String : "D:/Donnees/eclipse/eclipseworkspace_neon/
	 * tuto_maven_sonatype/ressources_externes".<br/>
	 */
	private static String fournirCheminRessourceExterneRG() {
					
		return "D:/Donnees/eclipse/eclipseworkspace_neon/"
				+ "tuto_maven_sonatype/ressources_externes";
					
	} // Fin de fournirCheminRessourceExterneRG()._________________________
	
	
	
	/**
	 * method remplirMapRG() :<br/>
	 * <ul>
	 * remplit et retourne la Map&lt;String, LigneRG&gt; mapRG 
	 * contenant toutes 
	 * les Règles de Gestion (RG) implémentées 
	 * dans les services de l'application avec :
	 * <li>String : le nom de la RG.</li>
	 * <li>LigneRG : pure fabrication encapsulant 
	 * tous les éléments relatifs à la RG.</li>
	 * </ul>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @return : Map&lt;String, LigneRG&gt; : mapRG.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private static Map<String, LigneRG> remplirMapRG() 
			throws MalformedURLException {
		
		synchronized (GestionnaireRG.class) {
			

			return mapRG;
			
		} // Fin de bloc synchronized.__________________________
		
	} // Fin de remplirMapRG().____________________________________________
	
	
	
	/**
	 * method getMapRG() :<br/>
	 * <ul>
	 * Getter de la Map contenant toutes les RG implémentées 
	 * dans l'application avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 * Trie la Map en fonction du nom des Règles de Gestion (RG).<br/>
	 * <br/>
	 *
	 * @return : Map&lt;String,LigneRG&gt; : 
	 * Map contenant toutes les RG implémentées dans l'application.<br/>
	 */
	public static Map<String, LigneRG> getMapRG() {
		
		/* Tri de la Map en fonction du nom des Règles de Gestion.*/
		final SortedMap<String, LigneRG> mapTriee 
			= new TreeMap<String, LigneRG>(mapRG);
		
		return mapTriee;
		
	} // Fin de getMapRG().________________________________________________
	

	
	/**
	 * method getEnTeteCsv() :<br/>
	 * <ul>
	 * <li>Retourne l'<b>en-tête csv</b> d'une <b>LigneRG</b>.</li>
	 * <li>"id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;"</li>
	 * </ul>
	 *
	 * @return : String : "id;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;"<br/>
	 */
	public static String getEnTeteCsv() {
		
		return "id;Actif;activité des contrôles sur l'attribut;"
				+ "activité de la RG;RG implémentée;clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;properties;clé;";
		
	} // Fin de getEnTeteCsv().____________________________________________
	
	
	
	/**
	 * method afficherListeRGImplementeesCsv() :<br/>
	 * <ul>
	 * <li>Retourne une String pour l'affichage de la liste 
	 * des RG implémentées dans l'application.</li>
	 * <li>La String contient la liste des LignesRG au format csv.</li>
	 * </ul>
	 * Trie la Map en fonction du nom des Règles de Gestion (RG).<br/>
	 * <br/>
	 * retourne null si mapRG == null.<br/>
	 * <br/>
	 *
	 * @return : String : liste csv des RG implémentées.<br/>
	 */
	public static String afficherListeRGImplementeesCsv() {
		
		synchronized (GestionnaireRG.class) {
			
			/* retourne null si mapRG == null. */
			if (mapRG == null) {
				return null;
			}
			
			/* Tri de la Map en fonction du numéro des Règles de Gestion.*/
			/* Instanciation d'un comparateur de RG 
			 * qui trie sur les numéros des RG. */
			final ComparatorRG comparateurRG = new ComparatorRG();
			
			/* Instanciation d'une SortedMap vide avec le comparateur */
			final SortedMap<String, LigneRG> mapTriee 
				= new TreeMap<String, LigneRG>(comparateurRG);
			
			/* Remplissage de la map triée. */
			mapTriee.putAll(mapRG);
			
			final StringBuilder stb = new StringBuilder();
			
			stb.append(getEnTeteCsv());
			stb.append(SAUT_LIGNE);
			
			final Set<Entry<String, LigneRG>> entrySet 
				= mapTriee.entrySet();
			
			final Iterator<Entry<String, LigneRG>> ite 
				= entrySet.iterator();
			
			final int nbreEntry = entrySet.size();
			
			int compteur = 0;
			
			while (ite.hasNext()) {
				
				compteur++;
				
				final Entry<String, LigneRG> entry = ite.next();
				final LigneRG ligneRG = entry.getValue();
				
				stb.append(ligneRG.toStringCsv());
				
				if (compteur < nbreEntry) {
					stb.append(SAUT_LIGNE);
				}				
			}
			
			return stb.toString();
			
		} // Fin de bloc synchronized.__________________________
		
	} // Fin de afficherListeRGImplementeesCsv().__________________________
	
	
	
	/**
	 * method getLigneRG(
	 * String pNomRG) :<br/>
	 * Retourne l'encapsulation LigneRG correspondant 
	 * à la RG de nom pNomRG dans la mapRG.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;].<br/>
	 * <br/>
	 *
	 * @param pNomRG : String : Nom de la Règle de Gestion (RG).<br/>
	 * 
	 * @return : LigneRG : pure fabrication.<br/>
	 * @throws MalformedURLException 
	 */
	public static LigneRG getLigneRG(
			final String pNomRG) throws MalformedURLException {
		
		return mapRG.get(pNomRG);
		
	} // Fin de getLigneRG(...).___________________________________________


	
} // FIN DE LA CLASSE GestionnaireRG.----------------------------------------
