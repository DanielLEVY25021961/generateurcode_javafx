package levy.daniel.application.model.services.utilitaires.generateurscode.generateursmethodes.impl;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * CLASSE GenerateurMethodeGetEnTeteCsvTest :<br/>
 * Test JUnit de la classe GenerateurMethodeGetEnTeteCsv.<br/>
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
 * @since 21 juin 2018
 *
 */
public class GenerateurMethodeGetEnTeteCsvTest {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;
	
	
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
	 * CLASSE : File :<br/>
	 * "D:\\Donnees\\eclipse\\eclipseworkspace_oxygen\\traficweb_javafx\\src\\main\\java\\levy\\daniel\\application\\model\\services\\utilitaires\\fournisseurarbotrafic\\impl\\ArboTrafic.java".<br/>
	 */
	public static final File CLASSE 
		= new File("D:\\Donnees\\eclipse\\eclipseworkspace_oxygen\\traficweb_javafx\\src\\main\\java\\levy\\daniel\\application\\model\\services\\utilitaires\\fournisseurarbotrafic\\impl\\ArboTrafic.java");
	
	/**
	 * generateur : GenerateurMethodeGetEnTeteCsv :<br/>
	 * .<br/>
	 */
	public final transient GenerateurMethodeGetEnTeteCsv generateur 
		= new GenerateurMethodeGetEnTeteCsv();
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GenerateurMethodeGetEnTeteCsvTest.class);

	// *************************METHODES************************************/
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public GenerateurMethodeGetEnTeteCsvTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * .<br/>
	 * @throws Exception 
	 */
	@Test
	public void testMapperAttributs() throws Exception {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = true;
		// **********************************
				
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE GenerateurMethodeGetEnTeteCsvTest - méthode testListerAttributs() ********** ");
		}
		
		final Map<String, String> attributsMap 
			= this.generateur.mapperAttributsPrivate(CLASSE);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println(this.generateur.afficherMapAttributs(attributsMap));
		}
		
		
		assertTrue("BIDON : ", 1 == 1); 

	} // Fin de testListerAttributs()._____________________________________

	
	
	/**
	 * .<br/>
	 * <ul>
	 * <li>.</li>
	 * </ul>
	 *
	 * @throws Exception :  :  .<br/>
	 */
	@Test
	public void testRegEx() throws Exception {
		
		final String chaineATester = "private String meduse;";
		
//		final String motif = "\\A(private){1}(\\s+){1}(.)*+(\\S+){1}(\\s+){1}(\\S+){1}(;){1}\\z";
		final String motif = "\\A(private){1}(\\s+){1}(.*?)(\\S+){1}(\\s+){1}(\\S+){1}(;){1}\\z";
		
		
		final Pattern pattern = Pattern.compile(motif);
		final Matcher matcher = pattern.matcher(chaineATester);
		
		if (matcher.matches()) {
			
			for (int i=0; i <= matcher.groupCount(); i++) {
		        // affichage de la sous-chaîne capturée
		        System.out.println("Groupe " + i + " : " + matcher.group(i));
		    }
		}
		
		assertTrue("BIDON : ", 1 == 1); 
		
	} // Fin de testRegEx()._______________________________________________
	
	
	
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
	public String afficherMap(
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
			
			stb.append("clé ");
			stb.append(compteur);
			stb.append(EGAL_AERE);
			stb.append(cle);
			stb.append(TAB2);
			stb.append("valeur ");
			stb.append(compteur);
			stb.append(EGAL_AERE);
			stb.append(valeur);
			
			if (compteur < taille) {
				stb.append(SAUT_LIGNE_JAVA);
			}
			
		}
		
		
		return stb.toString();
		
	} // Fin de afficherMap(...).__________________________________________
	

	
} // Fin de CLASSE GenerateurMethodeGetEnTeteCsvTest.------------------------
