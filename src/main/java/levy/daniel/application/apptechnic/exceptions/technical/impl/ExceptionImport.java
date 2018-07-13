package levy.daniel.application.apptechnic.exceptions.technical.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractTechnicalException;

/**
 * class ExceptionImport :<br/>
 * Hérite de AbstractTechnicalException.<br/>
 * Typée pour signaler qu'un import de fichier
 * a échoué.<br/>
 * Utilise la liste static listeExceptions de
 * AbstractTechnicalException pour y logger les
 * messages d'Exception.<br/>
 * <br/>
 * 
 * - Exemple d'utilisation :<br/>
 * <br/>
 *
 * - Mots-clé :<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 * @author Daniel Lévy
 * @version 1.0
 * @since 29 juil. 2010
 *
 */
public class ExceptionImport extends AbstractTechnicalException {

	// ***************************ATTRIBUTS*******************************/

	/**
	 * serialVersionUID : long :
	 * .
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ExceptionImport.class);

	// ***************************METHODES********************************/

	

	/**
	 * method CONSTRUCTEUR ExceptionImport() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Permet de construire une ExceptionImport
	 * sans message ni propagation d'exception cause.<br/>
	 */
	public ExceptionImport() {
		super();
	} // Fin de ExceptionImport(.__________________________________________
	


	/**
	 * method CONSTRUCTEUR ExceptionImport(String pMessage) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une ExceptionImport
	 * qui propage un message.<br/>
	 * <br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 */
	public ExceptionImport(final String pMessage) {
		super(pMessage);
	} // Fin de CONSTRUCTEUR ExceptionImport(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR ExceptionImport(Throwable pCause) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une ExceptionImport
	 * qui propage un Throwable qui a causé la présente
	 * exception.<br/>
	 * <br/>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public ExceptionImport(final Throwable pCause) {
		super(pCause);
	} // Fin de CONSTRUCTEUR ExceptionImport(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR ExceptionImport(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une ExceptionImport
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public ExceptionImport(
			final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	} // Fin de CONSTRUCTEUR ExceptionImport(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR ExceptionImport(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une ExceptionImport
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
	public ExceptionImport(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause, pListeExceptions);
		
	} // Fin de CONSTRUCTEUR ExceptionImport(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	

	
} // FIN DE LA CLASSE ExceptionImport.--------------------------------------
