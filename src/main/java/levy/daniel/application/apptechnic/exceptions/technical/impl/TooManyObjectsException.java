package levy.daniel.application.apptechnic.exceptions.technical.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractTechnicalException;

/**
 * class TooManyObjectsException :<br/>
 * Hérite de AbstractTechnicalException.<br/>
 * Typée pour signaler qu'une requête renvoie
 * trop de résultats (par exemple, plusieurs
 * au lieu d'un seul).<br/>
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
public class TooManyObjectsException extends AbstractTechnicalException {

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
			.getLog(TooManyObjectsException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR TooManyObjectsException() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Permet de construire une TooManyObjectsException
	 * sans message ni propagation d'exception cause.<br/>
	 *
	 */
	public TooManyObjectsException() {
		super();
	} // Fin de TooManyObjectsException()._________________________________
	


	/**
	 * method CONSTRUCTEUR TooManyObjectsException(
	 * String pMessage) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une TooManyObjectsException
	 * qui propage un message.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 */
	public TooManyObjectsException(
			final String pMessage) {
		super(pMessage);
	} // Fin de CONSTRUCTEUR TooManyObjectsException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR TooManyObjectsException(
	 * Throwable pCause) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une TooManyObjectsException
	 * qui propage un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public TooManyObjectsException(
			final Throwable pCause) {
		super(pCause);
	} // Fin de CONSTRUCTEUR TooManyObjectsException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR TooManyObjectsException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une TooManyObjectsException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public TooManyObjectsException(
			final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	} // Fin de CONSTRUCTEUR TooManyObjectsException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR TooManyObjectsException(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une TooManyObjectsException
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
	public TooManyObjectsException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause, pListeExceptions);
		
	} // Fin de CONSTRUCTEUR TooManyObjectsException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	

	
} // FIn DE LA CLASSE TooManyObjectsException.-------------------------------
