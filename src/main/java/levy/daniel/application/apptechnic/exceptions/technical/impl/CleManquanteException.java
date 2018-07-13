package levy.daniel.application.apptechnic.exceptions.technical.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractTechnicalException;

/**
 * class CleManquanteException :
 * Hérite de AbstractTechnicalException.<br/>
 * Typée pour signaler que la clé passée en paramètre
 * de la méthode getProperty(clé) de InitManager
 * est absente dans le application.properties.<br/>
 * Utilise la liste static listeExceptions de
 * AbstractTechnicalException pour y logger les
 * messages d'Exception.<br/>
 *
 * - Exemple d'utilisation :<br/>
 * <br/>
 *
 * - Mots-clé :<br/>
 *  Bundle, ResourceBundle, .properties
 *  <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author Levy Lévy
 * @version 1.0
 * @since 23 mai 2011
 *
 */
public class CleManquanteException extends AbstractTechnicalException {

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
			.getLog(CleManquanteException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR CleManquanteException() :
	 * CONSTRUCTEUR D'ARITE NULLE.
	 * Permet de construire une CleManquanteException
	 * sans message ni propagation d'exception cause.
	 *
	 */
	public CleManquanteException() {
		super();
	} // Fin de CleManquanteException().___________________________________
	


	/**
	 * method CONSTRUCTEUR CleManquanteException(String pMessage) :
	 * Constructeur d'arité 1.
	 * Permet de construire une CleManquanteException
	 * qui propage un message.
	 *
	 * @param pMessage : String : le message à propager.
	 */
	public CleManquanteException(final String pMessage) {
		super(pMessage);
	} // Fin de CONSTRUCTEUR CleManquanteException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR CleManquanteException(Throwable pCause) :
	 * Constructeur d'arité 1.
	 * Permet de construire une CleManquanteException
	 * qui propage un Throwable qui a causé la présente
	 * exception.
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.
	 */
	public CleManquanteException(final Throwable pCause) {
		super(pCause);
	} // Fin de CONSTRUCTEUR CleManquanteException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR CleManquanteException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une CleManquanteException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public CleManquanteException(
			final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	} // Fin de CONSTRUCTEUR CleManquanteException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR CleManquanteException(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une CleManquanteException
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
	public CleManquanteException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause, pListeExceptions);
		
	} // Fin de CONSTRUCTEUR CleManquanteException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	

	
} // FIN DE LA CLASSE CleManquanteException.---------------------------------
