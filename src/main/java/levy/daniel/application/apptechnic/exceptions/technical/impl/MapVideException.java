package levy.daniel.application.apptechnic.exceptions.technical.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractTechnicalException;

/**
 * class MapVideException :<br/>
 * Hérite de AbstractTechnicalException.<br/>
 * Typée pour signaler qu'une Map passée en 
 * paramètre d'une méthode est vide.<br/>
 * Utilise la liste static listeExceptions de
 * AbstractTechnicalException pour y logger les
 * messages d'Exception.<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 *
 * - Mots-clé :<br/>
 * Bundle, ResourceBundle, .properties
 *<br/>
 *
 * - Dépendances :<br/>
 *<br/>
 *
 * @author Levy Lévy
 * @version 1.0
 * @since 23 mai 2011
 *
 */
public class MapVideException extends AbstractTechnicalException {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(MapVideException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR MapVideException() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Permet de construire une MapVideException
	 * sans message ni propagation d'exception cause.<br/>
	 *
	 */
	public MapVideException() {
		super();
	} // Fin de MapVideException().________________________________________
	


	/**
	 * method CONSTRUCTEUR MapVideException(String pMessage) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une MapVideException
	 * qui propage un message.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 */
	public MapVideException(final String pMessage) {
		super(pMessage);
	} // Fin de CONSTRUCTEUR MapVideException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR MapVideException(Throwable pCause) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une MapVideException
	 * qui propage un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public MapVideException(final Throwable pCause) {
		super(pCause);
	} // Fin de CONSTRUCTEUR MapVideException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR MapVideException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une MapVideException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public MapVideException(
			final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	} // Fin de CONSTRUCTEUR MapVideException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR MapVideException(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une MapVideException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 * - Une liste de String susceptible d'encapsuler
	 * le message de la présente Exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 * @param pListeExceptions : Liste dans laquelle on veut
	 * insérer le message de la présente Exception.<br/>
	 */
	public MapVideException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause, pListeExceptions);
		
	} // Fin de CONSTRUCTEUR MapVideException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	

	
} // FIn DE LA CLASSE MapVideException.--------------------------------------
