package levy.daniel.application.apptechnic.exceptions.technical;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * class AbstractTechnicalException :
 * <ul>
 * <li>Classe <b>abstraite</b> de base commune a toutes les exceptions 
 * techniques <b>VERIFIEES</b> susceptibles d'être catchées dans le code 
 * de l'application par les développeurs.</li>
 * <li>Les exceptions techniques concrètes doivent provoquer l'affichage 
 * d'un message stocké dans une liste commune à toutes les
 * Exceptions Techniques VERIFIEES héritant de AbstractTechnicalException 
 * (SINGLETON 'listeExceptions').</li>
 * <li>Les exceptions techniques concrètes doivent provoquer 
 * l'enregistrement dans le journal (log4j) du detail 
 * des exceptions reelles.</li>
 * </ul>
 *
 *
 * - Exemple d'utilisation : <br/>
 * <br/>
 *
 * - Mots-clé :<br/>
 * <br/>
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
public abstract class AbstractTechnicalException extends Exception {

	// ************************ATTRIBUTS************************************/

	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	/**
	 * listeExceptions : List&lt;String&gt; : 
	 * <ul>
	 * <li>SINGLETON.</li>
	 * <li>Liste de messages de violation des règles techniques.</li>
	 * <li>Utile pour afficher en une seule fois l'ensemble des 
	 * messages des Exceptions Techniques VERIFIEES 
	 * jetées par l'application.</li>
	 * </ul>
	 */
	protected static List<String> listeExceptions;
	
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory
			.getLog(AbstractTechnicalException.class);

	// *************************METHODES************************************/
	

	/**
	 * method CONSTRUCTEUR AbstractTechnicalException() :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR D'ARITE NULLE.</li>
	 * <li>Permet de construire une AbstractTechnicalException
	 * sans message ni propagation d'exception cause.</li>
	 * <li>Instancie le singleton 'listeExceptions' 
	 * si ce n'est déjà fait.</li>
	 * <li>Ajoute le message de la présente Exception 
	 * à 'listeExceptions'.</li>
	 * </ul>
	 *
	 */
	public AbstractTechnicalException() {
		
		super();
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de AbstractTechnicalException(.______________________________
	


	/**
	 * method CONSTRUCTEUR AbstractTechnicalException(String pMessage) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR D'ARITE 1.</li>
	 * <li>Permet de construire une AbstractTechnicalException
	 * qui propage un message.</li>
	 * <li>Instancie le singleton 'listeExceptions' 
	 * si ce n'est déjà fait.</li>
	 * <li>Ajoute le message de la présente Exception 
	 * à 'listeExceptions'.</li>
	 * </ul>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 */
	public AbstractTechnicalException(final String pMessage) {
		
		super(pMessage);
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractTechnicalException(
	// String pMessage).___________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR AbstractTechnicalException(Throwable pCause) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR D'ARITE 1.</li>
	 * <li>Permet de construire une AbstractTechnicalException
	 * qui propage un Throwable qui a causé la présente
	 * exception.</li>
	 * <li>Instancie le singleton 'listeExceptions' 
	 * si ce n'est déjà fait.</li>
	 * <li>Ajoute le message de la présente Exception 
	 * à 'listeExceptions'.</li>
	 * </ul>
	 *
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public AbstractTechnicalException(final Throwable pCause) {
		
		super(pCause);
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractTechnicalException(
	// Throwable pCause).__________________________________________________
	
	
	
	/**
	 * method CONSTRUCTEUR AbstractTechnicalException(
	 * String pMessage
	 * , Throwable pCause) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR D'ARITE 2.</li>
	 * <li>Permet de construire une AbstractTechnicalException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.</li>
	 * <li>Instancie le singleton 'listeExceptions' 
	 * si ce n'est déjà fait.</li>
	 * <li>Ajoute le message de la présente Exception 
	 * à 'listeExceptions'.</li>
	 * </ul>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 */
	public AbstractTechnicalException(
			final String pMessage, final Throwable pCause) {
		
		super(pMessage, pCause);
		
		/* N'instancie la listeExceptions que
		 * si ce n'est pas déjà fait. */
		if (listeExceptions == null) {
			listeExceptions = new ArrayList<String>();
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractTechnicalException(
	 // String pMessage, Throwable pCause).________________________________

	
	
	/**
	 * method CONSTRUCTEUR AbstractTechnicalException(
	 * String pMessage
	 * , Throwable pCause
	 * , List&lt;String&gt; pListeExceptions) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET D'ARITE 3.</li>
	 * <li>Permet de construire une AbstractTechnicalException
	 * qui propage :<br/>
	 * - un message,<br/>
	 * - un Throwable qui a causé la présente
	 * exception.<br/>
	 * - Une liste de String susceptible d'encapsuler
	 * le message de la présente Exception et des 
	 * AbstractTechnicalExceptions suivantes.</li>
	 * <li>Passe le singleton 'listeExceptions'.</li>
	 * <li>Ajoute le message de la présente Exception 
	 * à 'listeExceptions'.</li>
	 * </ul>
	 *
	 * @param pMessage : String : le message à propager.<br/>
	 * @param pCause : Throwable : l'exception qui a
	 * causé la présente et que l'on veut propager.<br/>
	 * @param pListeExceptions : List&lt;String&gt; : 
	 * Liste dans laquelle on veut
	 * insérer le message de la présente Exception.<br/>
	 */
	public AbstractTechnicalException(
			final String pMessage
				, final Throwable pCause
					, final List<String> pListeExceptions) {
		
		super(pMessage, pCause);
		
		/* Ne passe la pListeExceptions en paramètre que
		 * si listeExceptions n'existait pas déjà en attribut. */
		if (listeExceptions == null) {
			listeExceptions = pListeExceptions;
		}
		
		/* Ajout de la présente Exception
		 * dans la liste listeExceptions. */
		this.addException();
		
	} // Fin de CONSTRUCTEUR AbstractTechnicalException(
	 // String pMessage
	 // , Throwable pCause
	 // , List<String> pListeExceptions).__________________________________
	
	
	
	/**
	 * method addException() :
	 * <ul>
	 * <li>Ajoute le message de la présente Exception
	 * à la liste des Exceptions (SINGLETON 'listeExceptions').</li>
	 * </ul>
	 */
	public final void addException() {
		
		if (listeExceptions != null) {
			
			final StringBuffer stb = new StringBuffer();
			
			stb.append("\nprésente Exception : ");
			stb.append(this.getClass());
			if (this.getCause() != null) {
				stb.append("\ncausée par : ");
				stb.append(this.getCause().getClass());
			}
			stb.append("\n - ");
			stb.append(this.getMessage());
						
			listeExceptions.add(stb.toString());
		}
		
	} // Fin de addException().____________________________________________
	
	
	
	/**
	 * method getListeExceptions() :<br/>
	 * <ul>
	 * <li>getter du SINGLETON 'listeExceptions'.</li>
	 * <li>Liste de messages de violation des règles techniques.</li>
	 * <li>Utile pour afficher en une seule fois l'ensemble des 
	 * messages des Exceptions Techniques VERIFIEES 
	 * jetées par l'application.</li>
	 * </ul>
	 * 
	 * @return listeExceptions : List&lt;String&gt;<br/>
	 */
	public final List<String> getListeExceptions() {
		return listeExceptions;
	} // Fin de getListeExceptions().______________________________________


	
	/**
	 * method listeExceptionsToString() :<br/>
	 * <ul>
	 * <li>Construit et retourne une String pour l'affichage de
	 * la liste des messages des Exceptions avec
	 * passages à la ligne.</li>
	 * </ul>
	 * - Retourne une String <b>vide</b> si la liste est null
	 * ou vide.<br/>
	 * <br/>
	 * 
	 * @return String.<br/>
	 */
	public final String listeExceptionsToString() {
		
		/* Retourne une String vide si la liste est null ou vide. */
		if (listeExceptions == null 
				|| listeExceptions.isEmpty()) {
			return "";
		}
			
		final StringBuffer stb = new StringBuffer();
		stb.append('\n');
		
		for (final String message : listeExceptions) {
			
			stb.append(message);
			stb.append('\n');
		}
			
			return stb.toString();
					
	} // Fin de listeExceptionsToString()._________________________________
	
	
} // FIN DE LA CLASSE AbstractTechnicalException.----------------------------
