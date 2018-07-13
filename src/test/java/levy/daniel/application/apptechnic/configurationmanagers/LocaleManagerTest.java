package levy.daniel.application.apptechnic.configurationmanagers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


/**
 * CLASSE LocaleManagerTest :<br/>
 * Test JUnit de la classe LocaleManager.<br/>
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
 * @since 12 juil. 2018
 *
 */
public class LocaleManagerTest {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * AFFICHAGE_GENERAL : Boolean :<br/>
	 * Boolean qui commande l'affichage pour tous les tests.<br/>
	 */
	public static final Boolean AFFICHAGE_GENERAL = true;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(LocaleManagerTest.class);

	// *************************METHODES************************************/

	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public LocaleManagerTest() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * Teste la méthode recupererLocaleIHM(String).<br/>
	 * <ul>
	 * <li>garantit que recupererLocaleIHM(localeFausseString) 
	 * retourne la Locale par défaut.</li>
	 * <li>garantit que recupererLocaleIHM(localeExistanteString) 
	 * retourne la Locale sélectionnée.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testRecupererLocaleIHM() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE LocaleManagerTest - méthode testRecupererLocaleIHM() ********** ");
		}
		
		// Locale INEXISTANTE. **************
		final String localeFausseString = "toto";
		
		final Locale localeFausse 
			= LocaleManager.recupererLocaleIHM(localeFausseString);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Locale fausse : " + localeFausse.toString());
		}
		
		/* garantit que recupererLocaleIHM(localeFausseString) 
		 * retourne la Locale par défaut. */
		assertNotNull("La Locale fausse ne doit pas être null : "
				, localeFausse);
		assertEquals("localeFausse doit être la Locale par défaut : "
				, Locale.getDefault(), localeFausse);
		
		
		// Locale EXISTANTE. **************
		final String localeString = "anglais (Etats-Unis)";
		
		final Locale locale 
			= LocaleManager.recupererLocaleIHM(localeString);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Locale : " + locale.toString());
		}
		
		/* garantit que recupererLocaleIHM(localeExistanteString) 
		 * retourne la Locale sélectionnée. */
		assertNotNull("La Locale sélectionnée ne doit pas être null : "
				, locale);
		assertEquals("locale doit être la Locale sélectionnée : "
				, Locale.US, locale);

	} // Fin de testRecupererLocaleIHM().__________________________________

	
	
	/**
	 * Teste la méthode selectionnerLocaleApplication(String).<br/>
	 * <ul>
	 * <li>garantit que selectionnerLocaleApplication(localeFausseString) 
	 * retourne la Locale par défaut.</li>
	 * <li>garantit que selectionnerLocaleApplication(localeFausseString) 
	 * affecte la Locale par défaut au SINGLETON localeApplication.</li>
	 * <li>garantit que selectionnerLocaleApplication(localeExistanteString) 
	 * retourne la Locale sélectionnée.</li>
	 * <li>garantit que selectionnerLocaleApplication(localeExistanteString) 
	 * affecte la Locale sélectionnée au SINGLETON localeApplication.</li>
	 * <li>garantit que localeApplication est TOUJOURS un SINGLETON.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSelectionnerLocaleApplication() {
		
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE LocaleManagerTest - méthode testSelectionnerLocaleApplication() ********** ");
		}

		// Locale INEXISTANTE. **************
		final String localeFausseString = "toto";
		
		/* SELECTION. */
		final Locale localeFausse 
			= LocaleManager.selectionnerLocaleApplication(localeFausseString);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Locale fausse : " + localeFausse.toString());
		}
		
		/* garantit que selectionnerLocaleApplication(localeFausseString) 
		 * retourne la Locale par défaut. */
		assertNotNull("La Locale fausse ne doit pas être null : "
				, localeFausse);
		assertEquals("localeFausse doit être la Locale par défaut : "
				, Locale.getDefault(), localeFausse);
		
		final Locale localeFausseApplication 
			= LocaleManager.getLocaleApplication();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Locale sélectionnée fausse : " + localeFausseApplication.toString());
		}
		
		/* garantit que selectionnerLocaleApplication(localeFausseString) 
		 * affecte la Locale par défaut au SINGLETON localeApplication. */
		assertNotNull("La Locale fausse dans l'application ne doit pas être null : "
				, localeFausseApplication);
		assertEquals("localeApplicationFausse doit être la Locale par défaut : "
				, Locale.getDefault(), localeFausseApplication);
		
		final Locale localeFausseApplication2 
			= LocaleManager.getLocaleApplication();
		
		/* garantit que localeApplication est TOUJOURS un SINGLETON. */
		assertSame("localeApplication doit être un SINGLETON : "
				, localeFausseApplication
					, localeFausseApplication2);
		
		
		// Locale EXISTANTE. **************
		final String localeString = "anglais (Etats-Unis)";
		
		/* SELECTION. */
		final Locale locale 
			= LocaleManager.selectionnerLocaleApplication(localeString);
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Locale sélectionnée : " + locale.toString());
		}
		
		/* garantit que selectionnerLocaleApplication(localeExistanteString) 
		 * retourne la Locale sélectionnée. */
		assertNotNull("La Locale sélectionnée ne doit pas être null : "
				, locale);
		assertEquals("locale doit être la Locale sélectionnée : "
				, Locale.US, locale);
		
		final Locale localeExistanteApplication = LocaleManager.getLocaleApplication();
	
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Locale mémorisée : " + localeExistanteApplication.toString());
		}
		
		/* garantit que selectionnerLocaleApplication(localeExistanteString) 
		 * affecte la Locale sélectionnée au SINGLETON localeApplication. */
		assertNotNull("La Locale sélectionnée dans l'application ne doit pas être null : "
				, localeExistanteApplication);
		assertEquals("localeApplication doit être la Locale sélectionnée : "
				, Locale.US, localeExistanteApplication);

	
		final Locale localeExistanteApplication2 
			= LocaleManager.getLocaleApplication();
	
		/* garantit que localeApplication est TOUJOURS un SINGLETON. */
		assertSame("localeApplication doit être un SINGLETON : "
				, localeExistanteApplication
					, localeExistanteApplication2);
		
	} // Fin de testSelectionnerLocaleApplication()._______________________


	
	/**
	 * Teste la méthode listerLocalesDisponibles().<br/>
	 * <ul>
	 * <li>garantit que listerLocalesDisponibles() retourne 
	 * la liste des langages disponibles.</li>
	 * </ul>
	 */
	@SuppressWarnings("unused")
	@Test
	public void testListerLocalesDisponibles() {
				
		// **********************************
		// AFFICHAGE DANS LE TEST ou NON
		final boolean affichage = false;
		// **********************************
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("********** CLASSE LocaleManagerTest - méthode testlisterLocalesDisponibles() ********** ");
		}

		final List<String> listeLangages 
			= LocaleManager.listerLocalesDisponibles();
		
		/* AFFICHAGE A LA CONSOLE. */
		if (AFFICHAGE_GENERAL && affichage) {
			System.out.println("Liste des langages disponibles : \n" 
					+ LocaleManager.afficherLangagesDisponibles());
		}
		
		/* garantit que listerLocalesDisponibles() retourne la liste des langages disponibles. */
		assertNotNull(
				"La liste des langages disponibles ne doit pas être null : "
					, listeLangages);
		
	} // Fin de testListerLocalesDisponibles().____________________________
	
	
	
} // FIN DE LA CLASSE LocaleManagerTest.-------------------------------------