package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;

import java.net.MalformedURLException;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * INTERFACE IGestionnaireRG :<br/>
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
public interface IGestionnaireRG {
	
	
	/**
	 * method getMapRG() :<br/>
	 * <ul>
	 * Getter de la Map contenant toutes les RG implémentées dans 
	 * le Gestionnaire de RG avec :
	 * <li>String : nom de la RG</li>
	 * <li>LigneRG : Encapsulation des éléments relatifs à la RG</li>
	 * </ul>
	 * Une ligne RG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;
	 * properties;clé;].<br/>
	 *
	 * @return mapRG : Map<String,LigneRG>.<br/>
	 */
	Map<String, LigneRG> getMapRG();
	

		
	/**
	 * method getBundleExterneRG() :<br/>
	 * <ul>
	 * <li>
	 * Fournit le ResourceBundle associé au fichier <i>externe</i> 
	 * (hors classpath) <b>rg-objet.properties</b> 
	 * avec la Locale Locale_fr_FR.
	 * </li>
	 * </ul>
	 * <br/>
	 *
	 * @return : ResourceBundle : rg-objet.properties.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	ResourceBundle getBundleExterneRG() 
			throws MalformedURLException;


} // FIN DE L'INTERFACE IGestionnaireRG.-----------------------------------
