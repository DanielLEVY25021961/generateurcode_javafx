package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractGestionnaireRG :<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 5 déc. 2017
 *
 */
public abstract class AbstractGestionnaireRG implements IGestionnaireRG {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	
	
	/**
	 * mapRG : Map&lt;String,LigneRG&gt; :<br/>
	 * <ul>
	 * Map contenant toutes les RG implémentées 
	 * dans le Gestionnaire de RG avec :
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
	private final transient Map<String, LigneRG> mapRG 
		= new ConcurrentHashMap<String, LigneRG>();

	
	/**
	 * bundleExterneRG : ResourceBundle :<br/>
	 * ResourceBundle encapsulant rg-objet.properties.<br/>
	 * rg-objet.properties est un fichier EXTERNE (hors classpath) 
	 * qui doit être accessible à la Maîtrise d'Ouvrage (MOA).<br/>
	 */
	private transient ResourceBundle bundleExterneRG;

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
	= LogFactory.getLog(AbstractGestionnaireRG.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractGestionnaireRG() :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR D'ARITE NULLE.</li>
	 * <li>Instancie this.bundleExterneRG.</li>
	 * </ul>
	 */
	public AbstractGestionnaireRG() {
		
		super();
		
		try {
			/* Instancie this.bundleExterneRG. */
			this.bundleExterneRG = this.getBundleExterneRG();
		}
		catch (MalformedURLException e) {
			if (LOG.isFatalEnabled()) {
				LOG.info("Bundle externe introuvable : ", e);
			}
		}
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________

	

	/**
	 * method getBundleExterneRG(
	 * Locale pLocale) :<br/>
	 * <ul>
	 * <li>
	 * Fournit le ResourceBundle associé au fichier <i>externe</i> 
	 * (hors classpath) <b>rg-objet.properties</b> avec la Locale pLocale.
	 * </li>
	 * </ul>
	 * <br/>
	 *
	 * @param pLocale : Locale.<br/>
	 * 
	 * @return : ResourceBundle.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	private ResourceBundle getBundleExterneRG(
			final Locale pLocale) throws MalformedURLException {
	
		ResourceBundle resourceBundle = null;
	
		/* Accède au répertoire externe 
		 * contenant rg-objet.properties. */
		final File repertoireRessourcesParametrables 
			= new File(fournirCheminRessourceExterneRG());
	
		final URL[] urlsRessourcesParametrables 
			= { repertoireRessourcesParametrables.toURI().toURL() };
	
		final ClassLoader loaderRessourcesParametrables 
			= new URLClassLoader(urlsRessourcesParametrables);
	
		/* Récupère le ResourceBundle en utilisant le bon ClassLoader. */
		resourceBundle 
			= ResourceBundle.getBundle(
					this.fournirNomBasePropertiesRG()
						, pLocale
							, loaderRessourcesParametrables);
	
		return resourceBundle;
	
	} // Fin de getBundleExterneRG(...).___________________________________



	/**
	 * method fournirCheminRessourceExterneRG() :<br/>
	 * <ul>
	 * <li>fournit le chemin <b>externe</b> (hors classpath) du 
	 * <b>répertoire</b> contenant le fichier 
	 * <b>rg-objet.properties</b>.</li>
	 * <li>Ce chemin doit être écrit <b>EN ABSOLU</b> 
	 * (surtout pas relatif au projet Eclipse).</li>
	 * <li>Par exemple H:.../ressources_externes/rg/metier/ 
	 * pour le fichier "rg-usersimple_fr_FR.properties".</li>
	 * </ul>
	 *
	 * @return : String : chemin absolu vers le File 
	 * rg-objet.properties.<br/>
	 */
	protected abstract String fournirCheminRessourceExterneRG();


	
	/**
	 * method fournirNomBasePropertiesRG() :<br/>
	 * <ul>
	 * <li>
	 * fournit le <b>nom de base</b> du rg-objet.properties 
	 * en fonction de l'objet traité par le <b>GestionnaireRGObjet</b>.
	 * </li>
	 * <li>Par exemple : "rg-usersimple" pour l'Object UserSimple.</li>
	 * </ul>
	 *
	 * @return : String : Nom de base du rg-objet.properties.<br/>
	 */
	protected abstract String fournirNomBasePropertiesRG();

	
	
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
	 * des RG implémentées dans le GestionnaireRG.</li>
	 * <li>La String contient la liste des LignesRG au format csv.</li>
	 * </ul>
	 * Trie la Map this.mapRG en fonction du numéro et du 
	 * nom des Règles de Gestion (RG).<br/>
	 * <br/>
	 * retourne null si mapRG == null.<br/>
	 * <br/>
	 *
	 * @return : String : liste csv des RG implémentées.<br/>
	 */
	public String afficherListeRGImplementeesCsv() {

		/* retourne null si mapRG == null. */
		if (this.mapRG == null) {
			return null;
		}

		/* Tri de la Map en fonction du numéro des Règles de Gestion. */
		/*
		 * Instanciation d'un comparateur de RG qui trie 
		 * sur les numéros des RG.
		 */
		final ComparatorRG comparateurRG = new ComparatorRG();

		/* Instanciation d'une SortedMap vide avec le comparateur */
		final SortedMap<String, LigneRG> mapTriee 
			= new TreeMap<String, LigneRG>(comparateurRG);

		/* Remplissage de la map triée. */
		mapTriee.putAll(this.mapRG);

		final StringBuilder stb = new StringBuilder();

		stb.append(getEnTeteCsv());
		stb.append(SAUT_LIGNE);

		final Set<Entry<String, LigneRG>> entrySet = mapTriee.entrySet();

		final Iterator<Entry<String, LigneRG>> ite = entrySet.iterator();

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

	} // Fin de afficherListeRGImplementeesCsv().__________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, LigneRG> getMapRG() {
		return this.mapRG;
	} // Fin de getMapRG().________________________________________________
	
	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final ResourceBundle getBundleExterneRG() 
			throws MalformedURLException {
		
			if (this.bundleExterneRG == null) {
				this.bundleExterneRG 
					= this.getBundleExterneRG(Locale.getDefault());
			}
			
			return this.bundleExterneRG;
			
	} // Fin de getBundleExterneRG().______________________________________
	

	
		
} // FIN DE LA CLASSE AbstractGestionnaireRG.--------------------------------
