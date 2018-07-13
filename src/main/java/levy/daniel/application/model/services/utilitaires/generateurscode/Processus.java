package levy.daniel.application.model.services.utilitaires.generateurscode;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE Processus :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * verifierBonFichier, verifier fichier, fichier existant, <br/>
 * extension, extension fichier, fournirExtensionFichier, <br/> 
 * fournirExtension, StringUtils.split(nomFichier, POINT), <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 21 juin 2018
 *
 */
public class Processus {

	// ************************ATTRIBUTS************************************/
	/**
	 * " = ".<br/>
	 */
	public static final String EGAL_AERE = " = ";
	
	/**
	 * '.'.<br/>
	 */
	public static final char POINT = '.';
	
	/**
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';
	
	/**
	 * "\t".<br/>
	 */
	public static final String TAB = "\t";
	
	/**
	 * TAB + TAB.<br/>
	 */
	public static final String TAB2 = TAB + TAB;
	

	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");


	/**
	 * CHARSET_ANSI : Charset :<br/>
	 * Charset.forName("windows-1252").<br/>
	 * ANSI, CP1252.<br/>
	 * 218 caractères imprimables.<br/>
	 * extension d’ISO-8859-1, qui rajoute quelques caractères: œ, € (euro), 
	 * guillemets anglais (« »), points de suspension (...)
	 * , signe «pour mille» (‰), 
	 * tirets cadratin (— = \u2014 en unicode ) et demi-cadratin (–), ...<br/>
	 */
	public static final Charset CHARSET_ANSI = Charset.forName("windows-1252");


	/**
	 * CHARSET_IBM850 : Charset :<br/>
	 * Charset IBM-850.<br/>
	 * Cp850, MS-DOS Latin-1.<br/>
	 */
	public static final Charset CHARSET_IBM850 = Charset.forName("IBM-850");


	/**
	 * fichier .java contenant le code source de la classe Java 
	 * dont on veut générer le code.<br/>
	 */
	private File classe;
	
	/**
	 * <b>Map&lt;String,String&gt; contenant les attributs 
	 * private dans leur ordre de déclaration</b> 
	 * d'une classe sans modérateurs static, final, transient... avec :
	 * <ul>
	 * <li>String : le nom de l'attribut private.</li>
	 * <li>String : le nom simple du TYPE (String, File, ...) 
	 * de l'attribut private.</li>
	 */
	private Map<String, String> mapAttributsPrivate;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(Processus.class);

	// *************************METHODES************************************/
	
	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pArgs : void :  .<br/>
	 */
	public static void main(
			final String[] pArgs) {
		// TODO Auto-generated method stub

	}

	
	
	/**
	 * Mappe tous les <b>attributs private hors modérateurs 
	 * static, final, transient, ...</b> d'une 
	 * classe Java pClasse en conservant l'ordre 
	 * des attributs dans la classe.<br/>
	 * <ul>
	 * <ul>
	 * Retourne une Map&lt;String,String&gt; avec :
	 * <ul>
	 * <li>String : le nom de l'attribut private.</li>
	 * <li>String : le nom simple du TYPE (String, File, ...) 
	 * de l'attribut private.</li>
	 * </ul>
	 * </ul>
	 * <ul>
	 * <li>lit toutes les lignes d'un fichier en UTF8 (classe Java)
	 * avec Files.readAllLines(..).</li>
	 * <li>trim toutes les lignes de la liste lue 
	 * avec Files.readAllLines(..).</li>
	 * <li>constitue la map des attributs private hors modérateurs 
	 * static, final, transient, ... en déléguant à la 
	 * méthode detecterAttributsPrives(listeTrimee).</li>
	 * </ul>
	 *
	 * @param pClasse : File : 
	 * le fichier .java contenant la source de la classe Java 
	 * dont on veut extraitre les attributs privés.<br/>
	 * 
	 * @return : Map&lt;String,String&gt; : 
	 * map ordonnée des attributs de la classe avec leurs types.<br/>
	 * 
	 * @throws Exception 
	 */
	public Map<String, String> mapperAttributsPrivate(
			final File pClasse) throws Exception {
		
		/* lit toutes les lignes d'un fichier en UTF8 (classe Java)
		 * avec Files.readAllLines(..). */
		final List<String> liste 
			= Files.readAllLines(pClasse.toPath(), CHARSET_UTF8);
		
		/* trim toutes les lignes de la liste lue 
		 * avec Files.readAllLines(..). */
		final List<String> listeTrimee = this.trimerListe(liste);
		
		/* constitue la map des attributs private hors modérateurs 
		 * static, final, transient, ... en déléguant à la 
		 * méthode detecterAttributsPrives(listeTrimee). */
		final Map<String, String> mapAttributsPrivateLocal 
			= this.detecterAttributsPrivate(listeTrimee);
				
		return mapAttributsPrivateLocal;
		
	} // Fin de listerAttributs(...).______________________________________
	

	
	/**
	 * <b>détecte les attributs private d'une classe (fichier.java)</b> 
	 * <i>hors modérateurs static, final, transient, ....</i> 
	 * fournie sous forme de liste de lignes pList.<br/>
	 * <b>retourne une Map&lt;String,String&gt; conservant 
	 * l'ordre des attributs dans la classe avec : </b><br/>
	 * <ul>
	 * <li>String : le nom de l'attribut private.</li>
	 * <li>String : le nom simple du TYPE (String, File, ...) 
	 * de l'attribut private.</li>
	 * </ul>
	 * <ul>
	 * <li>utilise une RegEx pour détecter les champs private.</li>
	 * <li>Utilise une LinkedHashMap pour conserver 
	 * l'ordre des attributs dans la classe.</li>
	 * <li>Elimine des champs private les 
	 * static, final, transient, ou autres.</li>
	 * </ul>
	 * - return null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;.<br/>
	 * 
	 * @return : Map&lt;String,String&gt; : 
	 * map ordonnée des attributs de la classe avec leurs types.<br/>
	 */
	private Map<String, String> detecterAttributsPrivate(
			final List<String> pList) {
		
		/* return null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		/* Expression régulière. */
		final String motif 
			= "\\A(private){1}(\\s+){1}(.*?)(\\S+){1}(\\s+){1}(\\S+){1}(;){1}\\z";
		
		final Pattern pattern = Pattern.compile(motif);
		
		/* Utilise une LinkedHashMap pour conserver 
		 * l'ordre des attributs dans la classe. */
		final Map<String, String> resultat 
		= new LinkedHashMap<String, String>();
		
		for (final String ligne : pList) {
			
			final Matcher matcher = pattern.matcher(ligne);
			
			if (matcher.matches()) {
				
				final int nombreGroupes = matcher.groupCount();
				final int indexNomAttribut = nombreGroupes - 1;
				final int indexType = indexNomAttribut -2;
				final int indexModificateurs = indexType - 1;
				
				final String nomAttribut 
					= matcher.group(indexNomAttribut);
				final String typeAttribut 
					= matcher.group(indexType);
				final String modificateurAttribut 
					= matcher.group(indexModificateurs);
				
				/* Elimine des champs private les static, final, transient, ou autres. */
				if (StringUtils.isBlank(modificateurAttribut)) {
					resultat.put(nomAttribut, typeAttribut);
				}
				
			}
			
		}
				
		return resultat;
		
	} // detecterAttributsPrivate(...).____________________________________
	
	
	
	/**
	 * retire les espaces avant et après (trim) 
	 * chaque ligne d'une liste pList.<br/>
	 * <br/>
	 * - return null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;.<br/>
	 * 
	 * @return : List&lt;String&gt; : 
	 * liste avec toutes les ligne trimees.<br/>
	 */
	private List<String> trimerListe(
			final List<String> pList) {
		
		/* return null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final List<String> resultat = new ArrayList<String>();
		
		for (final String ligne : pList) {
			
			resultat.add(StringUtils.trim(ligne));
		}
		
		return resultat;
		
	} // Fin de trimerListe(...).__________________________________________
	
	
	
	/**
	 * vérifie qu'un fichier simple pFile 
	 * est une classe java existante.<br/>
	 * retourne true si c'est la cas.<br/>
	 * <ul>
	 * <li>retourne false si pFile == null.</li>
	 * <li>retourne false si pFile n'existe pas.</li>
	 * <li>retourne false si pFile n'est pas un fichier simple.</li>
	 * <li>retourne false si pFile ne se termine pas par .java.</li>
	 * </ul>
	 *
	 * @param pFile : File : classe java (fichier source .java).<br/>
	 * 
	 * @return : boolean : 
	 * true si le fichier est un fichier source java.<br/>
	 */
	private static boolean verifierBonFichier(
			final File pFile) {
		
		synchronized (Processus.class) {
			
			/* retourne false si pFile == null. */
			if (pFile == null) {
				return false;
			}
			
			/* retourne false si pFile n'existe pas. */
			if (!pFile.exists()) {
				return false;
			}
			
			/* retourne false si pFile n'est pas un fichier simple. */
			if (!pFile.isFile()) {
				return false;
			}
			
			/* retourne false si pFile ne se termine pas par .java. */
			if (!fournirExtensionFichier(pFile).equals("java")) {
				return false;
			}
			
			return true;
			
		} // Fin du bloc synchronized._______________
		
	} // Fin de verifierBonFichier(...).___________________________________
	

	
	/**
	 * fournit l'extension d'un fichier simple pFile.<br/>
	 * <ul>
	 * <li>utilise StringUtils.split(nomFichier, POINT).</li>
	 * </ul>
	 * - retourne null si pFile == null.<br/>
	 * - retourne null si le nom du fichier est null.<br/>
	 * - retourne null si le fichier n'a pas d'extension.<br/>
	 * <br/>
	 *
	 * @param pFile
	 * @return : String :  .<br/>
	 */
	private static String fournirExtensionFichier(
			final File pFile) {
		
		synchronized (Processus.class) {
			
			/* retourne null si pFile == null. */
			if (pFile == null) {
				return null;
			}
			
			final String nomFichier = pFile.getName();
			
			final String[] tokens = StringUtils.split(nomFichier, POINT);
			
			/* retourne null si le nom du fichier est null. */
			if (tokens == null) {
				return null;
			}
			
			final int taille = tokens.length;
			
			/* retourne null si le fichier n'a pas d'extension. */
			if (taille <= 1) {
				return null;
			}
			
			return tokens[taille - 1];
			
		} // Fin du bloc synchronized._______________
		
	} // Fin de fournirExtensionFichier(...).______________________________

	
	
	/**
	 * Getter du fichier .java contenant le code source 
	 * de la classe Java 
	 * dont on veut générer le code.<br/>
	 *
	 * @return this.classe : File.<br/>
	 */
	public File getClasse() {
		return this.classe;
	} // Fin de getClasse()._______________________________________________

	
	
	/**
	* Setter du fichier .java contenant le code source 
	* de la classe Java 
	* dont on veut générer le code.<br/>
	*
	* @param pClasse : File : 
	* valeur à passer à this.classe.<br/>
	*/
	public void setClasse(
			final File pClasse) {
		this.classe = pClasse;
	} // Fin de setClasse(...).____________________________________________



	/**
	 * Getter de la <b>Map&lt;String,String&gt; contenant 
	 * les attributs private dans leur ordre de déclaration</b> 
	 * d'une classe sans modérateurs static, final, transient... avec :
	 * <ul>
	 * <li>String : le nom de l'attribut private.</li>
	 * <li>String : le nom simple du TYPE (String, File, ...) 
	 * de l'attribut private.</li>
	 *
	 * @return this.mapAttributsPrivate : Map&lt;String,String&gt;.<br/>
	 */
	public Map<String, String> getMapAttributsPrivate() {
		return this.mapAttributsPrivate;
	} // Fin de getMapAttributsPrivate().__________________________________



	/**
	* Setter de la <b>Map&lt;String,String&gt; contenant 
	* les attributs private dans leur ordre de déclaration</b> 
	* d'une classe sans modérateurs static, final, transient... avec :
	* <ul>
	* <li>String : le nom de l'attribut private.</li>
	* <li>String : le nom simple du TYPE (String, File, ...) 
	* de l'attribut private.</li>
	*
	* @param pMapAttributsPrivate : Map<String,String> : 
	* valeur à passer à this.mapAttributsPrivate.<br/>
	*/
	public void setMapAttributsPrivate(
			final Map<String, String> pMapAttributsPrivate) {
		this.mapAttributsPrivate = pMapAttributsPrivate;
	} // Fin de setMapAttributsPrivate(...)._______________________________


	
} // FIN DE LA CLASSE Processus.---------------------------------------------
