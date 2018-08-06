package levy.daniel.application.apptechnic.configurationmanagers.gestionnairestemplates;

import java.util.List;

/**
 * INTERFACE <b>IGestionnaireTemplates</b> :<br/>
 * Interface factorisant les comportements des GestionnaireTemplates.<br/>
 * 
 * <p><span style="text-decoration: underline;"><b>ROLE des GestionnaireTemplates</b></span></p>
 * Un gestionnaireTemplate est responsable de :
 * <ul>
 * <li><b>lire un template de code</b> stocké sous forme de fichier .txt sous le classpath.</li>
 * <li><b>substituer d'éventuelles variables</b> par des valeurs dans le template lu.</li>
 * <li><b>retourner le résultat du template lu et substitué</b> sous forme de <b>List&lt;String&gt;</b> ou de <b>String</b> unique.</li>
 * </ul>
 * Le développeur peut alors injecter le code résultant de la lecture et de la substitution du template où il le souhaite dans son code.<br/>
 * <br/><br/>
 * <img src="../../../../../../../../../javadoc/images/gestionnaire_templates_role.png" 
 * alt="Roles des Gestionnaire de templates" border="1" align="center" />
 * <br/><br/>
 * <p><span style="text-decoration: underline;"><b>DIAGRAMME DES CLASSES : </b></span></p>
 * <br/>
 * <img src="../../../../../../../../../javadoc/images/gestionnaire_templates.png" 
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
public interface IGestionnaireTemplates {

	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une String représentant la 
	 * liste de lignes substituées</b>.<br/>
	 * <b>Substitue la variable pVariable dans chaque ligne</b>.<br/>
	 * <b>N'UTILISER QUE SI IL N'Y A QU'UNE SEULE VARIABLE 
	 * A SUBSTITUER</b>.<br/>
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li>incorpore dans la String résultat les 
	 * sauts de ligne de la plateforme.</li>
	 * <li>ne substitue que si pVariable != null.</li>
	 * <li><b>retourne le template lu sans substitution 
	 * si pVariable == null</b>.</li>
	 * <li><b>Substitue</b> <i>pSubstituant</i> à la 
	 * variable <i>pVariable</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * @param pVariable : String : variable à substituer
	 * @param pSubstituant : String : valeur à substituer à variable.<br/>
	 * 
	 * @return : String : template substitué sous forme 
	 * d'une unique String.<br/>
	 * 
	 * @throws Exception 
	 */
	String fournirTemplateSubstitueSousFormeString(
			String pCheminRelatifTemplate, String pVariable, String pSubstituant)
					throws Exception;

	

	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une String représentant la 
	 * liste de lignes substituées</b>.<br/>
	 * <b>Substitue chaque variable du tableau pVariables par son 
	 * correspondant dans pSubstituants dans chaque ligne</b>.<br/>
	 * <b>UTILISER SI IL Y A PLUSIEURS VARIABLES 
	 * A SUBSTITUER</b>.<br/>
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li>incorpore dans la String résultat les 
	 * sauts de ligne de la plateforme.</li>
	 * <li>ne substitue que si pVariables != null.</li>
	 * <li><b>retourne le template lu sans substitution 
	 * si pVariables == null</b>.</li>
	 * <li><b>Substitue</b> <i>pSubstituant[i]</i> à la 
	 * variable <i>pVariable[i]</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * - retourne null si l'un des tableaux est null.<br/>
	 * - retourne null si les 2 tableaux n'ont pas la même taille.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * @param pVariables : String[] : 
	 * tableau de variables à substituer.<br/>
	 * @param pSubstituants : String [] : 
	 * tableau de valeurs à substituer aux variables.<br/>
	 * 
	 * @return : String : template substitué sous forme 
	 * d'une unique String.<br/>
	 * 
	 * @throws Exception
	 */
	String fournirTemplateSubstitueSousFormeString(
			String pCheminRelatifTemplate
				, String[] pVariables
					, String[] pSubstituants) throws Exception;
	
	

	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une liste de lignes substituées</b>.<br/>
	 * <b>Substitue la variable pVariable dans chaque ligne</b>.<br/>
	 * <b>N'UTILISER QUE SI IL N'Y A QU'UNE SEULE VARIABLE 
	 * A SUBSTITUER</b>.<br/>
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li>ne substitue que si pVariable != null.</li>
	 * <li><b>retourne le template lu sans substitution 
	 * si pVariable == null</b>.</li>
	 * <li><b>Substitue</b> <i>pSubstituant</i> à la 
	 * variable <i>pVariable</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * @param pVariable : String : variable à substituer
	 * @param pSubstituant : String : valeur à substituer à variable.<br/>
	 * 
	 * @return : List&lt;String&gt; : 
	 * Template sous forme de liste de lignes 
	 * avec la variable substituée.<br/>
	 * 
	 * @throws Exception
	 */
	List<String> fournirTemplateSubstitueSousFormeListe(
			String pCheminRelatifTemplate, String pVariable, String pSubstituant) 
					throws Exception;
	

	
	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une liste de lignes substituées</b>.<br/>
	 * <b>Substitue chaque variable du tableau pVariables par son 
	 * correspondant dans pSubstituants dans chaque ligne</b>.<br/>
	 * <b>UTILISER SI IL Y A PLUSIEURS VARIABLES 
	 * A SUBSTITUER</b>.<br/>
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li>ne substitue que si pVariables != null.</li>
	 * <li><b>retourne le template lu sans substitution 
	 * si pVariables == null</b>.</li>
	 * <li><b>Substitue</b> <i>pSubstituant[i]</i> à la 
	 * variable <i>pVariable[i]</i> 
	 * dans chaque ligne de pListe.</li>
	 * <li>Par exemple : <br/>
	 * Substitue "levy.daniel.application.model.metier" 
	 * à {$pathmetier} dans chaque ligne.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * - retourne null si pSubstituants est null et pVariables != null.<br/>
	 * - retourne null si les 2 tableaux n'ont pas la même taille.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * @param pVariables : String[] : 
	 * tableau de variables à substituer.<br/>
	 * @param pSubstituants : String [] : 
	 * tableau de valeurs à substituer aux variables.<br/>
	 * 
	 * @return : List&lt;String&gt; : 
	 * Template sous forme de liste de lignes 
	 * avec les variables substituées.<br/>
	 * 
	 * @throws Exception
	 */
	List<String> fournirTemplateSubstitueSousFormeListe(
			String pCheminRelatifTemplate
				, String[] pVariables
					, String[] pSubstituants) throws Exception;
	
	
	/**
	 * <b>Lit un template situé à 
	 * <code>cheminAbsoluMainResources/pCheminRelatifTemplate</code> 
	 * et retourne une liste de lignes</b>.
	 * <ul>
	 * <li>lit le fichier template avec le Charset UTF8.</li>
	 * <li>utilise la méthode lireStringsDansFile(
	 * templateFile, CHARSET_UTF8).</li>
	 * <li><b>Ne fait aucune substitution de variables</b>. 
	 * Lit le template et le retourne sous forme 
	 * de List&lt;String&gt;.</li>
	 * </ul>
	 * - retourne null si pCheminRelatifTemplate est blank.<br/>
	 * - retourne null si le fichier template n'existe pas.<br/>
	 * <br/>
	 *
	 * @param pCheminRelatifTemplate : String : 
	 * chemin relatif du template à lire par rapport à 
	 * cheminAbsoluMainResources (src/main/resources).<br/>
	 * 
	 * @return List&lt;String&gt; : 
	 * template sous forme de liste de lignes.<br/>
	 * 
	 * @throws Exception 
	 */
	List<String> lireTemplate(
			String pCheminRelatifTemplate) 
									throws Exception;
	
	
	
} // FIN DE L'INTERFACE IGestionnaireTemplates.------------------------------
