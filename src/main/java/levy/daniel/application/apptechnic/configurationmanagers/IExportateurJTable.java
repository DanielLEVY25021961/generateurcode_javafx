package levy.daniel.application.apptechnic.configurationmanagers;

/**
 * class IExportateurJTable :<br/>
 * Interface qui garantit que tous les objets qui 
 * l'implémentent pourront être exportés dans des JTable.<br/>
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
 * @since 17 juin 2014
 *
 */
public interface IExportateurJTable {
	
		
	/**
	* method getEnTeteColonne(
	* int pI) :<br/>
	* <ul>
	* <li>Fournit l'en-tête de la pIème colonne (0-based) 
	* pour affichage dans une JTable par exemple.</li>
	* <li>Suit l'ordre défini dans le csv.</li>
	* </ul>
	*
	* @param pI : int : pIème colonne (0 - based).<br/>
	* 
	* @return : String : En-tête de la pIème colonne (0 - based).<br/>
	*/
	String getEnTeteColonne(int pI);
	
	
	
	/**
	* method getValeurColonne(
	* int pI) :<br/>
	* <ul>
	* <li>Fournit la valeur de la pIème colonne (0-based) 
	* pour affichage dans une JTable par exemple.</li>
	* <li>Suit l'ordre défini dans le csv.</li>
	* <li>Retourne toujours une <b>String</b> si l'objet n'est pas null.</li>
	* <li>Retourne null si la valeur dans l'objet est null.</li>
	* </ul>
	*
	* @param pI : int : pIème colonne (0 - based).<br/>
	* 
	* @return : Object : valeur de la pIème colonne (0 - based).<br/>
	*/
	Object getValeurColonne(int pI);
	
	
	
} // FIN DE L'INTERFACE IExportateurJTable.----------------------------------
