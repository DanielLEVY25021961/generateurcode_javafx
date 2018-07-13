package levy.daniel.application.model.dao.daoexceptions.technical.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;


/**
 * class DaoPSQLException :<br/>
 * Exception pour les problèmes avec PostgreSQL (table absente, ...).<br/>
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
 * @since 18 sept. 2017
 *
 */
public class DaoPSQLException extends AbstractDaoException {
	
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
	private static final Log LOG 
		= LogFactory.getLog(DaoPSQLException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR DaoPSQLException() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Permet de construire une DaoPSQLException
	 * sans message ni propagation d'exception cause.<br/>
	 */
	public DaoPSQLException() {
		super();
	} // Fin de DaoPSQLException().________________________________________
	


	/**
	 * method CONSTRUCTEUR DaoPSQLException(String pMessage) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une DaoPSQLException
	 * qui propage un message.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 */
	public DaoPSQLException(final String pMessage) {
		super(pMessage);
	} // Fin de CONSTRUCTEUR DaoPSQLException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR DaoPSQLException(Throwable pCause) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une DaoPSQLException
	 * qui propage un Throwable qui a causé la présente
	 * exception.<br/>
	 * <br/>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public DaoPSQLException(final Throwable pCause) {
		super(pCause);
	} // Fin de CONSTRUCTEUR DaoPSQLException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR DaoPSQLException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une DaoPSQLException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public DaoPSQLException(
			final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	} // Fin de CONSTRUCTEUR DaoPSQLException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR DaoPSQLException(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une DaoPSQLException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 * - Une liste de String susceptible d'encapsuler
	 * le message de la présente Exception.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 * @param pListeExceptions : Liste dans laquelle on veut
	 * insérer le message de la présente Exception.<br/>
	 */
	public DaoPSQLException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause, pListeExceptions);
		
	} // Fin de CONSTRUCTEUR DaoPSQLException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	


} // FIN DE LA CLASSE DaoPSQLException.--------------------------------------
