package levy.daniel.application.model.services.utilitaires.generateurscode.generateursmethodes.impl;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE GenerateurMethodeGetEnTeteCsv :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * afficherMapStringString, afficherMap String String, <br/>
 * afficher Map String String, afficherMap<String, String>, <br/>
 * trim, liste trimee, <br/>
 * Expression regulière, Regex, reguliere, <br/>
 * LinkedHashMap, conserver ordre de saisie des champs, attributs,<br/>
 * String.format(...), String.format, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 19 juin 2018
 *
 */
public class GenerateurMethodeGetEnTeteCsv {

	// ************************ATTRIBUTS************************************/

	/**
	 * fichier .java (classe java) dans laquelle on va intégrer 
	 * la méthode générée par le présent générateur.<br/>
	 */
	private File classe;
	
	/**
	 * EGAL_AERE : String :<br/>
	 * " = ".<br/>
	 */
	public static final String EGAL_AERE = " = ";
	
	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';
	
	/**
	 * TAB : String :<br/>
	 * "\t".<br/>
	 */
	public static final String TAB = "\t";
	
	/**
	 * TAB2 : String :<br/>
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
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GenerateurMethodeGetEnTeteCsv.class);
	

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GenerateurMethodeGetEnTeteCsv() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
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
		final Map<String, String> mapAttributsPrivate 
			= this.detecterAttributsPrivate(listeTrimee);
				
		return mapAttributsPrivate;
		
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
	 * .<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 *
	 * @param pClasse
	 * @return : Map<String,String> :  .<br/>
	 */
	public Map<String, String> listerMethodes(
			final File pClasse) {
		
		final Class<?> clazz = pClasse.getClass();
		
		final Method[] methodes = clazz.getDeclaredMethods();

		final Map<String, String> resultat 
		= new ConcurrentHashMap<String, String>();
	
		for (final Method methode : methodes) {
			
			final String nomMethode = methode.getName();
			final String typeMethode 
				= methode.getGenericReturnType().getTypeName();
			
			resultat.put(nomMethode, typeMethode);
		}
		
		return resultat;
		
	} // Fin de listerMethodes(...)._______________________________________
	

	
	/**
	 * Retourne une String pour affichage d'une 
	 * Map&lt;String, String&gt;.<br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * - retourne null si pMap == null.<br/>
	 * <br/>
	 *
	 * @param pMap : Map&lt;String, String&gt;.<br/>
	 * @return : String : String pour affichage.<br/>
	 */
	public String afficherMapAttributs(
			final Map<String, String> pMap) {
		
		/* retourne null si pMap == null. */
		if (pMap == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		final Set<Entry<String, String>> entrySet = pMap.entrySet();
		final Iterator<Entry<String, String>> ite = entrySet.iterator();
		
		final int taille = entrySet.size();
		int compteur = 0;
		
		while (ite.hasNext()) {
			
			compteur++;
			
			final Entry<String, String> entry = ite.next();
			
			final String cle = entry.getKey();
			final String valeur =  entry.getValue();
			
			final String format = "attribut %3$-3d : %1$-50s	type %3$-3d : %2$-45s";
				
			final String resultat 
				= String.format(Locale.getDefault(), format
						, cle, valeur, compteur);
						
			stb.append(resultat);
			
			if (compteur < taille) {
				stb.append(SAUT_LIGNE_JAVA);
			}
			
		}
				
		return stb.toString();
		
	} // Fin de afficherMapAttributs(...)._________________________________
	
	
	
	/**
	 * Fournit une String pour l'affichage 
	 * d'une List&lt;String&gt;.<br/>
	 * <br/>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListeString(
			final List<String> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		for (final String ligne : pList) {
			stb.append(ligne);
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		return stb.toString();
		
	} // Fin de afficherListeString(...).__________________________________
	

	
	/**
	 * Getter du fichier .java (classe java) dans laquelle on va intégrer 
	 * la méthode générée par le présent générateur.<br/>
	 * <br/>
	 *
	 * @return classe : File : this.classe.<br/>
	 */
	public File getClasse() {
		return this.classe;
	} // Fin de getClasse()._______________________________________________
	
	

	/**
	* Setter du fichier .java (classe java) dans laquelle on va intégrer 
	* la méthode générée par le présent générateur.<br/>
	* <br/>
	*
	* @param pClasse : File : 
	* valeur à passer à this.classe.<br/>
	*/
	public void setClasse(
			final File pClasse) {
		this.classe = pClasse;
	} // Fin de setClasse(...).____________________________________________


	
	
	

} // FIN DE LA CLASSE GenerateurMethodeGetEnTeteCsv.-------------------------
