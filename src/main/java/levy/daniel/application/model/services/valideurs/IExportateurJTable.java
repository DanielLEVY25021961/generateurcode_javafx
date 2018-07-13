package levy.daniel.application.model.services.valideurs;

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
	* Fournit l'en-tête de la pIème colonne (0-based) 
	* pour affichage dans une JTable par exemple.<br/>
	* <br/>
	* Suit l'ordre défini dans le csv.<br/>
	* <br/>
	*
	* @param pI : int : pIème colonne (0 - based).<br/>
	* 
	* @return : String : En-tête de la pIème colonne (0 - based).<br/>
	*/
	String getEnTeteColonne(int pI);
	
	
	
	/**
	* method getValeurColonne(
	* int pI) :<br/>
	* Fournit la valeur de la pIème colonne (0-based) 
	* pour affichage dans une JTable par exemple.<br/>
	* <br/>
	* Suit l'ordre défini dans le csv.<br/>
	* <br/>
	*
	* @param pI : int : pIème colonne (0 - based).<br/>
	* 
	* @return : Object : valeur de la pIème colonne (0 - based).<br/>
	*/
	Object getValeurColonne(int pI);
	
	
	
} // FIN DE L'INTERFACE IExportateurJTable.----------------------------------
