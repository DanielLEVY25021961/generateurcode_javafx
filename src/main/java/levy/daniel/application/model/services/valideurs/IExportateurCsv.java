package levy.daniel.application.model.services.valideurs;

/**
 * class IExportateurCsv :<br/>
 * Interface qui garantit que tous les objets qui 
 * l'implémentent pourront être exportés au format csv.<br/>
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
public interface IExportateurCsv {
	
	
	/**
	 * method getEnTeteCsv() :<br/>
	 * Fournit l'en-tête des lignes csv.<br/>
	 * <br/>
	 * Pourrait être static dans l'absolu, 
	 * mais ne pourrait alors plus figurer dans l'interface. 
	 * L'idée est de pouvoir demander à n'importe quel objet métier 
	 * de fournir son en-tête de fichier csv.<br/>
	 *
	 * @return : String.<br/>
	 */
	String getEnTeteCsv();

	
	
	/**
	 * method toStringCsv() :<br/>
	 * Fournit le ValueObject sous forme de ligne Csv.<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	String toStringCsv();



} // FIN DE L'INTERFACE IExportateurCsv.-------------------------------------
