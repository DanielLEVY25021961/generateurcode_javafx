package levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.BundleConfigurationProjetManager;
import levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates.IGestionnaireTemplates;


/**
 * CLASSE <b>GestionnaireTemplates</b> :<br/>
 * GestionnaireTemplates concret.<br/>
 * Implémente IGestionnaireTemplates.<br/>
 * <p><span style="text-decoration: underline;"><b>ROLE des GestionnaireTemplates</b></span></p>
 * Un gestionnaireTemplate est responsable de :
 * <ul>
 * <li><b>lire un template de code</b> stocké sous forme de fichier .txt sous le classpath.</li>
 * <li><b>substituer d'éventuelles variables</b> par des valeurs dans le template lu.</li>
 * <li><b>retourner le résultat du template lu et substitué</b> sous forme de <b>List&lt;String&gt;</b> ou de <b>String</b> unique.</li>
 * </ul>
 * Le développeur peut alors injecter le code résultant de la lecture et de la substitution du template où il le souhaite dans son code.<br/>
 * <br/><br/>
 * <img src="../../../../../../../../../../javadoc/images/gestionnaire_templates_role.png" 
 * alt="Roles des Gestionnaire de templates" border="1" align="center" />
 * <br/><br/>
 * <p><span style="text-decoration: underline;"><b>DIAGRAMME DES CLASSES : </b></span></p>
 * <br/>
 * <img src="../../../../../../../../../../javadoc/images/gestionnaire_templates.png" 
 * alt="Diagramme de classes des Gestionnaires de templates" border="1" align="center" />
 * <br/><br/>
 *
 * - Exemple d'utilisation :<br/>
 * <code><i>// Instanciation d'un GestionnaireTemplates</i></code>.<br/>
 * <code>final <b>IGestionnaireTemplates gestionnaireTemplates = new GestionnaireTemplates();</b></code>.<br/>
 * <code><i>// récupération du template grâce à son chemin relatif par rapport aux resources internes</i></code>.<br/>
 * <code>final String <b>cheminRelatifTemplate = "commentaires_properties/commentaires_labels_properties.txt";</b></code>.<br/>
 * <code><i>// variables incorporées dans le template à lire</i></code>.<br/>
 * <code>final String[] <b>variables = {"{$Locale}", "{$langue}"};</b></code><br/>
 * <code><i>// valeurs à substituer aux variables dépendant d'une Locale paramétrée pLocale</i></code>.<br/>
 * <code>final String[] <b>substituants = {pLocale.toString(), LocaleManager.fournirLangueEtPaysEnFrancais(pLocale)};</b></code>.<br/>
 * <code><i>// Récupération du template lu/substitué sous forme de String</i></code>.<br/>
 * <code>final String <b>commentaire = gestionnaireTemplate.fournirTemplateSubstitueSousFormeString(cheminRelatifTemplate, variables, substituants);</b></code>.<br/>
 * <code>// commentaire peut alors être injecté où le veut le développeur.</code><br/>
 *<br/>

 * 
 * - Mots-clé :<br/>
 * template, Template, <br/>
 * lire fichier, lireFichier, fichier en liste, <br/>
 * transformer liste en String, Liste en String, <br/>
 * template, Template, liste de lignes à partir d'un fichier txt, <br/>
 * lire un fichier .txt, lire un fichier txt,<br/>
 * liste lignes à partir d'un fichier .txt, ListeLignes txt, <br/>
 * lire un template txt, lire un template .txt, obtenir liste lignes,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 15 juil. 2018
 *
 */
public class GestionnaireTemplates implements IGestionnaireTemplates {
	
	// ************************ATTRIBUTS************************************/
	
	/**
	 * "Classe GestionnaireTemplates".<br/>
	 */
	public static final String CLASSE_GESTIONNAIRE_TEMPLATES 
		= "Classe GestionnaireTemplates";

	//*****************************************************************/
	//**************************** SEPARATEURS ************************/
	//*****************************************************************/

	/**
	 * '/'.<br/>
	 */
	public static final char SEPARATEUR_FICHIER = '/';
		
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";

	
	//*****************************************************************/
	//**************************** CHARSETS ***************************/
	//*****************************************************************/

	/**
	 * CHARSET_UTF8 : Charset :<br/>
	 * Charset.forName("UTF-8").<br/>
	 * Eight-bit Unicode (or UCS) Transformation Format.<br/> 
	 */
	public static final Charset CHARSET_UTF8 
		= Charset.forName("UTF-8");

	//*****************************************************************/
	//**************************** SAUTS ******************************/
	//*****************************************************************/	
	/**
	 * NEWLINE : String :<br/>
	 * Saut de ligne spécifique de la plateforme.<br/>
	 * System.getProperty("line.separator").<br/>
	 */
	public static final String NEWLINE = System.getProperty("line.separator");
	

	/**
	 * METHODE_LIRE_STRINGS_DANS_FILE : String :<br/>
	 * "méthode lireStringsDansFile(File pFile, Charset pCharset)".<br/>
	 */
	public static final String METHODE_LIRE_STRINGS_DANS_FILE 
		= "méthode lireStringsDansFile(File pFile, Charset pCharset)";
	
	/**
	 * <b>Chemin absolu des ressources</b> internes de l'application.<br/>
	 * par exemple : <br/>
	 * <code>chemin du projet/src/main/resources</code>
	 */
	private static String cheminAbsoluMainResources;

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(GestionnaireTemplates.class);
	// *************************METHODES************************************/

	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <ul>
	 * <li>Initialise les attributs.</li>
	 * </ul>
	 * 
	 * @throws Exception 
	 */
	public GestionnaireTemplates() throws Exception {
		
		super();
		
		/* Initialise les attributs. */
		this.initialiserAttributs();
		
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * <b>Initialise les attributs</b>.
	 * <ul>
	 * <li>initialise le Chemin absolu des ressources internes 
	 * de l'application cheminAbsoluMainResources.</li>
	 * <li>utilise <code>BundleConfigurationProjetManager
	 * .getRacineMainResources();</code></li>
	 * </ul>
	 *
	 * @throws Exception
	 */
	private void initialiserAttributs() throws Exception {
		
		/* initialise le Chemin absolu des ressources internes 
		 * de l'application cheminAbsoluMainResources. */
		cheminAbsoluMainResources 
			= BundleConfigurationProjetManager.getRacineMainResources();
		
	} // Fin de initialiserAttributs().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirTemplateSubstitueSousFormeString(
			final String pCheminRelatifTemplate
				, final String pVariable
					, final String pSubstituant) throws Exception {
		
		/* retourne null si pCheminRelatifTemplate est blank. */
		if (StringUtils.isBlank(pCheminRelatifTemplate)) {
			return null;
		}
		
		List<String> resultatSubstitue = null;
		
		resultatSubstitue 
			= this.fournirTemplateSubstitueSousFormeListe(
					pCheminRelatifTemplate, pVariable, pSubstituant);
		
		String resultat = null;
		
		if (resultatSubstitue != null) {
			resultat 
				= this.creerStringAPartirDeListe(resultatSubstitue);
		}
		
		return resultat;
		
	} // Fin de fournirTemplateSubstitueSousFormeString(...).______________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirTemplateSubstitueSousFormeString(
			final String pCheminRelatifTemplate
				, final String[] pVariables
					, final String[] pSubstituants) throws Exception {
		
		/* retourne null si pCheminRelatifTemplate est blank. */
		if (StringUtils.isBlank(pCheminRelatifTemplate)) {
			return null;
		}
		
		/* retourne null si l'un des tableaux est null. */
		if (pVariables == null || pSubstituants == null) {
			return null;
		}
		
		/* retourne null si les 2 tableaux n'ont pas la même taille. */
		if (pVariables.length != pSubstituants.length) {
			return null;
		}

		List<String> resultatSubstitue = null;
		
		resultatSubstitue 
			= this.fournirTemplateSubstitueSousFormeListe(
					pCheminRelatifTemplate, pVariables, pSubstituants);
		
		String resultat = null;
		
		if (resultatSubstitue != null) {
			resultat 
				= this.creerStringAPartirDeListe(resultatSubstitue);
		}
		
		return resultat;
		
	} // Fin de fournirTemplateSubstitueSousFormeString(...).______________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<String> fournirTemplateSubstitueSousFormeListe(
			final String pCheminRelatifTemplate
				, final String pVariable
					, final String pSubstituant) throws Exception {
		
		/* retourne null si pCheminRelatifTemplate est blank. */
		if (StringUtils.isBlank(pCheminRelatifTemplate)) {
			return null;
		}
		
		final List<String> templateListe 
			= this.lireTemplate(pCheminRelatifTemplate);
		
		List<String> resultatSubstitue = null;
		
		/* ne substitue que si pVariable != null. */
		if (pVariable != null) {
						
			if (templateListe != null) {
				resultatSubstitue 
					= this.substituerVariablesDansLigne(
							templateListe, pVariable, pSubstituant);
			}
		
		/* retourne le template lu sans substitution si pVariable == null. */
		} else {
			resultatSubstitue = templateListe;
		}
		
		
		return resultatSubstitue;
		
	} // Fin de fournirTemplateSubstitueSousFormeListe(...)._______________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<String> fournirTemplateSubstitueSousFormeListe(
			final String pCheminRelatifTemplate
				, final String[] pVariables
					, final String[] pSubstituants) throws Exception {
		
		/* retourne null si pCheminRelatifTemplate est blank. */
		if (StringUtils.isBlank(pCheminRelatifTemplate)) {
			return null;
		}
		
		/* retourne null si pSubstituants est null et pVariables != null. */
		if (pSubstituants == null) {
			if (pVariables != null) {
				return null;
			}			
		}
		
		final List<String> templateListe 
			= this.lireTemplate(pCheminRelatifTemplate);
		
		/* retourne le template lu sans substitution 
		 * si pVariable == null. */
		if (pVariables == null) {
			return templateListe;
		}
		
		List<String> listeASubstituer = null;
		
		/* retourne null si les 2 tableaux n'ont pas la même taille. */
		if (pSubstituants != null) {
			
			if (pVariables.length != pSubstituants.length) {
				return null;
			}
						
			listeASubstituer = templateListe;
			
			for (int i = 0; i < pVariables.length; i++) {
				
				List<String> resultatSubstitue = null;
				
				if (listeASubstituer != null) {
					resultatSubstitue 
						= this.substituerVariablesDansLigne(
								listeASubstituer, pVariables[i], pSubstituants[i]);
				}
				
				listeASubstituer = resultatSubstitue;
				
			}
		}
									
		return listeASubstituer;
		
	} // Fin de fournirTemplateSubstitueSousFormeListe(...)._______________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<String> lireTemplate(
			final String pCheminRelatifTemplate) 
									throws Exception {
		
		/* retourne null si pCheminRelatifTemplate est blank. */
		if (StringUtils.isBlank(pCheminRelatifTemplate)) {
			return null;
		}
		
		final String cheminAbsoluTemplate 
			= cheminAbsoluMainResources 
				+ SEPARATEUR_FICHIER 
					+ pCheminRelatifTemplate;
		
		final File templateFile = new File(cheminAbsoluTemplate);
		
		/* retourne null si le fichier template n'existe pas. */
		if (!templateFile.exists()) {
			return null;
		}
		
		/* utilise la méthode 
		 * lireStringsDansFile(templateFile, CHARSET_UTF8). */
		final List<String> templateListe 
			= this.lireStringsDansFile(templateFile, CHARSET_UTF8);
		
		return templateListe;
		
	} // Fin de lireTemplate(...)._________________________________________
	
		
	
	/**
	 * <b>Substitue une valeur à une variable dans chaque ligne 
	 * d'une liste correspondant à un template</b>.<br/>
	 * Similaire au mécanisme des Expressions Langage (EL).<br/>
	 * <ul>
	 * <li><b>Substitue</b> <i>pSubstituant</i> à la 
	 * variable <i>pVariable</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * retourne null si pListe est null.<br/>
	 * <br/>
	 *
	 * @param pListe : List&lt;String&gt;
	 * @param pVariable : String : variable à substituer
	 * @param pSubstituant : String : valeur à substituer à variable.<br/>
	 * 
	 * @return : List&lt;String&gt; : Liste des lignes 
	 * avec les variables substituées.<br/>
	 */
	private List<String> substituerVariablesDansLigne(
			final List<String> pListe
				, final String pVariable
					, final String pSubstituant) {
		
		/* retourne null si pListe est null. */
		if (pListe == null) {
			return null;
		}
		
		final List<String> resultat = new ArrayList<String>();
		
		for (final String ligne : pListe) {
			
			final String nouvelleLigne 
				= StringUtils.replace(ligne, pVariable, pSubstituant);
			
			resultat.add(nouvelleLigne);
			
		}
		
		return resultat;
		
	} // Fin de substituerVariablesDansLigne(...)._________________________
	

	
	/**
	 * <b>Lit le contenu d'un fichier texte avec pCharset 
	 * et retourne une Liste de lignes</b>. 
	 * <ul>
	 * <li><b>Lit le contenu</b> d'un fichier texte 
	 * (fichier simple contenant du texte) pFile.</li>
	 * <li>Décode le contenu d'un fichier texte 
	 * (fichier simple contenant du texte) pFile 
	 * avec le Charset pCharset</li>
	 * <li><b>Retourne la liste des lignes</b> 
	 * du fichier simple texte pFile 
	 * lues avec le Charset pCharset.</li>
	 * <ul>
	 * <li>Utilise automatiquement le CHARSET_UTF8 
	 * si pCharset est null.</li>
	 * </ul>
	 * </ul>
	 * - Retourne null si pFile est null.<br/>
	 * - Retourne null si pFile n'existe pas.<br/>
	 * - Retourne null si pFile est un répertoire.<br/>
	 * - Retourne null en cas d'Exception loggée 
	 * (MalformedInputException, ...).<br/>
	 * <br/>
	 *
	 * @param pFile : File : fichier simple textuel à lire.<br/>
	 * @param pCharset : Charset : le Charset à utiliser pour 
	 * lire le fichier pFile.<br/>
	 * 
	 * @return : List&lt;String&gt; : Liste des lignes lues.<br/>
	 * 
	 * @throws Exception en cas d'Exception loggée 
	 * (IOException, MalformedInputException, ...).<br/>
	 */
	private List<String> lireStringsDansFile(
			final File pFile
				, final Charset pCharset) throws Exception {
		
		/* Retourne null si pFile est null. */
		if (pFile == null) {
			return null;
		}
		
		/* Retourne null si pFile n'existe pas. */
		if (!pFile.exists()) {
			return null;
		}
		
		/* Retourne null si pFile est un répertoire. */
		if (pFile.isDirectory()) {
			return null;
		}
		
		/* Utilise automatiquement le CHARSET_UTF8 si pCharset est null. */
		Charset charset = null;
		
		if (pCharset == null) {
			charset = CHARSET_UTF8;
		}
		else {
			charset = pCharset;
		}
		
		/* Récupère le Path de pFile. */
		final Path pathFichier = pFile.toPath();
		
		try {
			
			// *****************************************************
			/* Retourne la liste des lignes lues avec le charset. */
			return Files.readAllLines(pathFichier, charset);
			
		} 
		
		catch (MalformedInputException malformedInputException) {
			
			final String message 
			=  "Impossible de lire le contenu du fichier '" 
			+ pFile.getName() 
			+ "' avec le Charset " 
			+ charset.displayName(Locale.getDefault()) 
			+ " à cause d'un caractère qui ne peut être "
			+ "écrit dans ce Charset (MalformedInputException)";
			
			/* LOG de niveau Error. */
			loggerError(CLASSE_GESTIONNAIRE_TEMPLATES
					, METHODE_LIRE_STRINGS_DANS_FILE 
					+ SEPARATEUR_MOINS_AERE 
					+ message
					, malformedInputException);
			
			/* retourne null en cas d'Exception loggée 
			 * (IOException, MalformedInputException, ...). */
			return null;
	
		}
		
		catch (IOException ioe) {
			
			/* LOG de niveau Error. */
			loggerError(CLASSE_GESTIONNAIRE_TEMPLATES
					, METHODE_LIRE_STRINGS_DANS_FILE
					, ioe);
			
			final String message 
			= CLASSE_GESTIONNAIRE_TEMPLATES 
			+ SEPARATEUR_MOINS_AERE 
			+ METHODE_LIRE_STRINGS_DANS_FILE 
			+ SEPARATEUR_MOINS_AERE 
			+ "Impossible de lire le contenu du fichier '" 
			+ pFile.getName() 
			+ "' avec le Charset " 
			+ charset.displayName(Locale.getDefault());
			
			/* jette une Exception en cas d'Exception loggée 
			 * (IOException, MalformedInputException, ...). */
			throw new Exception(message, ioe);
		
		}
			
	} // Fin de lireStringsDansFile(...).__________________________________
	

	
	/**
	 * <b>Crée une String à partir d'une liste de Strings</b>.
	 * <ul>
	 * <li>ajoute un saut de ligne de la plateforme 
	 * NEWLINE à chaque ligne.</li>
	 * </ul>
	 * - retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	private String creerStringAPartirDeListe(
			final List<String> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final String ligne : pList) {
			
			stb.append(ligne);
			
			/* ajoute un saut de ligne de la plateforme 
			 * NEWLINE à chaque ligne. */
			stb.append(NEWLINE);
		}
		
		return stb.toString();
		
	} // Fin de creerStringAPartirDeListe(...).____________________________
	
	
	
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage) :<br/>
	 * <ul>
	 * <li>Crée un message de niveau INFO dans le LOG.</li>
	 * </ul>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 */
	private void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pMessage == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE
			+ pMessage;
			
			LOG.info(message);
		}
		
	} // Fin de la classe loggerInfo(...)._________________________________
	
	
	
	/**
	 * method loggerInfo(
	 * String pClasse
	 * , String pMethode
	 * , String pMessage
	 * , String pComplement) :<br/>
	 * <ul>
	 * <li>Créée un message de niveau INFO dans le LOG.</li>
	 * </ul>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pMessage : String : Message particulier de la méthode.<br/>
	 * @param pComplement : String : Complément au message de la méthode.<br/>
	 */
	private void loggerInfo(
			final String pClasse
				, final String pMethode
					, final String pMessage
						, final String pComplement) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null 
				|| pMessage == null || pComplement == null) {
			return;
		}
		
		/* LOG de niveau INFO. */			
		if (LOG.isInfoEnabled()) {
			
			final String message 
			= pClasse 
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE
			+ pMessage
			+ pComplement;
			
			LOG.info(message);
		}
		
	} // Fin de loggerInfo(...).___________________________________________
	
	
	
	/**
	 * method loggerError(
	 * String pClasse
	 * , String pMethode
	 * , Exception pException) :<br/>
	 * <ul>
	 * <li>Crée un message de niveau ERROR dans le LOG.</li>
	 * </ul>
	 * - Ne fait rien si un des paramètres est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : String : Classe appelante.<br/>
	 * @param pMethode : String : Méthode appelante.<br/>
	 * @param pException : Exception : Exception transmise 
	 * par la méthode appelante.<br/>
	 */
	private void loggerError(
			final String pClasse
				, final String pMethode
					, final Exception pException) {
		
		/* Ne fait rien si un des paramètres est null. */
		if (pClasse == null || pMethode == null || pException == null) {
			return;
		}
		
		/* LOG de niveau ERROR. */			
		if (LOG.isErrorEnabled()) {
			
			final String message 
			= pClasse 
			+ SEPARATEUR_MOINS_AERE
			+ pMethode
			+ SEPARATEUR_MOINS_AERE 
			+ pException.getMessage();
			
			LOG.error(message, pException);
			
		}
		
	} // Fin de loggerError(...).__________________________________________

	
	
} // FIN DE LA CLASSE GestionnaireTemplates.---------------------------------
