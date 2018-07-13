package levy.daniel.application.apptechnic.exceptions.technical.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.exceptions.technical.AbstractTechnicalException;

/**
 * class MauvaisFormatException :<br/>
 * Hérite de AbstractTechnicalException.<br/>
 * Typée pour signaler que le fichier que l'on cherche
 * à lire ne possède pas la bonne extension.<br/>
 * Utilise la liste static listeExceptions de
 * AbstractTechnicalException pour y logger les
 * messages d'Exception.<br/>
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
public class MauvaisFormatException extends AbstractTechnicalException {

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
			.getLog(MauvaisFormatException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR MauvaisFormatException() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * Permet de construire une MauvaisFormatException
	 * sans message ni propagation d'exception cause.<br/>
	 *
	 */
	public MauvaisFormatException() {
		super();
	} // Fin de MauvaisFormatException().__________________________________
	


	/**
	 * method CONSTRUCTEUR MauvaisFormatException(String pMessage) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une MauvaisFormatException
	 * qui propage un message.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 */
	public MauvaisFormatException(final String pMessage) {
		super(pMessage);
	} // Fin de CONSTRUCTEUR MauvaisFormatException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR MauvaisFormatException(Throwable pCause) :<br/>
	 * Constructeur d'arité 1.<br/>
	 * Permet de construire une MauvaisFormatException
	 * qui propage un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public MauvaisFormatException(final Throwable pCause) {
		super(pCause);
	} // Fin de CONSTRUCTEUR MauvaisFormatException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR MauvaisFormatException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * Constructeur d'arité 2.<br/>
	 * Permet de construire une MauvaisFormatException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public MauvaisFormatException(
			final String pMessage, final Throwable pCause) {
		super(pMessage, pCause);
	} // Fin de CONSTRUCTEUR MauvaisFormatException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR MauvaisFormatException(
	 * String pMessage
	 * , Throwable pCause
	 * , List<String> pListeExceptions) :<br/>
	 * Constructeur d'arité 3.<br/>
	 * Permet de construire une MauvaisFormatException
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
	public MauvaisFormatException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause, pListeExceptions);
		
	} // Fin de CONSTRUCTEUR MauvaisFormatException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	

	
} // FIn DE LA CLASSE MauvaisFormatException.--------------------------------
