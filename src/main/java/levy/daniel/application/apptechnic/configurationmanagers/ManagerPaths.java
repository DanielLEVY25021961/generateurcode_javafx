package levy.daniel.application.apptechnic.configurationmanagers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * CLASSE <b>ManagerPaths</b> :<br/>
 * <ul>
 * <li>Classe <b>utilitaire (méthodes static)</b> chargée de fournir
 * les caractéristiques du projet courant 
 * (chemin du Workspace courant, nom du projet courant
 * , path des sources java dans le projet courant, ...).</li>
 * <li>
 * classe chargée de fournir des SINGLETONS pour :
 * <ol>
 * <li><b>l'unité de disque dur</b> sur laquelle est située 
 * le projet courant <b>pathUniteCourante</b>.</li>
 * <li>l'emplacement du <b>Workspace Eclipse</b> courant 
 * <b>pathPresentWorkspace</b>.</li>
 * <li>l'emplacement du <b>projet Eclipse</b> courant 
 * <b>pathPresentProjet</b>.</li>
 * </ol>
 * </li>
 * </ul>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * séparateur de fichiers, separateur, antislash, <br/>
 * Singleton, singleton, <br/>
 * transformer String en Path, Paths.get(String), <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 27 janv. 2018
 *
 */
public final class ManagerPaths {

	// ************************ATTRIBUTS************************************/

	/**
	 * SEPARATEUR_FICHIERS : String :<br/>
	 * <ul>
	 * <li>Séparateur de fichiers de la plateforme.</li>
	 * <li>fourni par System.getProperty("file.separator").</li>
	 * <li>antislash '\' sur la plateforme Windows.</li>
	 * </ul>
	 */
	public static final String SEPARATEUR_FICHIERS 
		= System.getProperty("file.separator");
	
	
	/**
	 * SLASH : char :<br/>
	 * Séparateur générique des fichiers slash.<br/>
	 * '/'.<br/>
	 */
	public static final char SLASH = '/';
	
	
	/**
	 * pathUniteCouranteString : String :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * de <b>l'unité courante sur laquelle est situé le présent projet
	 * </b> sous forme de <i>String</i>.</li>
	 * <li>calculé à l'aide de la position de File("\")</li>
	 * <li>Par exemple : <br/>
	 * D:/
	 * </li>
	 * </ul>
	 */
	private static String pathUniteCouranteString;
	
	
	/**
	 * pathUniteCourante : Path :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * de <b>l'unité courante sur laquelle est situé le présent projet
	 * </b> sous forme de <i>Path</i>.</li>
	 * <li>calculé à l'aide de la position de File("\")</li>
	 * <li>Par exemple : <br/>
	 * D:/
	 * </li>
	 * </ul>
	 */
	private static Path pathUniteCourante;
	
	
	/**
	 * pathPresentWorkspaceString : String :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent workspace Eclipse</b> sous forme de <i>String</i>.</li>
	 * <li>calculé avec pathPresentProjet.getParent().</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon
	 * </li>
	 * </ul>
	 */
	private static String pathPresentWorkspaceString;
	
	
	/**
	 * pathPresentWorkspace : Path :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent workspace Eclipse</b> sous forme de <i>Path</i>.</li>
	 * <li>calculé avec pathPresentProjet.getParent().</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon
	 * </li>
	 * </ul>
	 */
	private static Path pathPresentWorkspace;
	

	/**
	 * pathPresentProjetString : String :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent projet Eclipse</b> sous forme de <i>String</i>.</li>
	 * <li>calculé avec la position de File("").</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon/generation_code
	 * </li>
	 * </ul>
	 */
	private static String pathPresentProjetString;
	
	
	/**
	 * pathPresentProjet : Path :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent projet Eclipse</b> sous forme de <i>Path</i>.</li>
	 * <li>calculé avec la position de File("").</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon/generation_code
	 * </li>
	 * </ul>
	 */
	private static Path pathPresentProjet;
	
	
	/**
	 * nomPresentProjet : String :<br/>
	 * <ul>
	 * <li><b>nom du présent projet Eclipse</b>.</li>
	 * </ul>
	 */
	private static String nomPresentProjet;
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ManagerPaths.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR ManagerPaths() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	private ManagerPaths() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	/**
	 * method getPathUniteCouranteString() :<br/>
	 * <ul>
	 * <li><b>path "générique"</b> (avec des séparateurs slash) 
	 * de <b>l'unité courante sur laquelle est situé le présent projet
	 * </b> sous forme de <i>String</i>.</li>
	 * <li>calculé à l'aide de la position de File("\")</li>
	 * <li>Par exemple : <br/>
	 * D:/
	 * </li>
	 * </ul>
	 *
	 * @return : pathUniteCouranteString : String.<br/>
	 * 
	 * @throws IOException 
	 */
	public static String getPathUniteCouranteString() throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (pathUniteCouranteString == null) {
				
				/* Unité courante. */
				final File fileSousUnite = new File("\\");
				final Path pathWindowsUnite = fileSousUnite.toPath();
				final Path realPath = pathWindowsUnite.toRealPath();
				
				/* passage de Path à String. */
				final String cheminWindowsString = realPath.toString();
				
				/* remplacement des antislash par des slash. */
				pathUniteCouranteString 
					= retournerPathGenerique(cheminWindowsString);
												
			}
			
			return pathUniteCouranteString;
			
		} //Fin de synchronized. ________________________________
		
	} // Fin de getPathUniteCouranteString().______________________________


		
	/**
	 * method getPathUniteCourante() :<br/>
	 * <ul>
	 * <li>Getter du <b>path "générique"</b> (avec des séparateurs slash) 
	 * de <b>l'unité courante sur laquelle est situé le présent projet
	 * </b> sous forme de <i>Path</i>.</li>
	 * <li>calculé à l'aide de la position de File("\")</li>
	 * <li>Par exemple : <br/>
	 * D:/
	 * </li>
	 * </ul>
	 *
	 * @return pathUniteCourante : Path.<br/>
	 * 
	 * @throws IOException
	 */
	public static Path getPathUniteCourante() throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (pathUniteCourante == null) {
				
				getPathUniteCouranteString();
				
				/* String vers Path. */
				pathUniteCourante = Paths.get(pathUniteCouranteString);
			}
			
			return pathUniteCourante;
			
		} //Fin de synchronized. ________________________________
		
	} // Fin de getPathUniteCourante().____________________________________
	

	
	/**
	 * method getPathPresentWorkspaceString() :<br/>
	 * <ul>
	 * <li>Getter du <b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent workspace Eclipse</b> sous forme de <i>String</i>.</li>
	 * <li>retourne un <b>Singleton</b>.</li>
	 * <li>calculé avec pathPresentProjet.getParent().</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon
	 * </li>
	 * </ul>
	 *
	 * @return : pathPresentWorkspaceString : String.<br/>
	 * 
	 * @throws IOException 
	 */
	public static String getPathPresentWorkspaceString() throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (pathPresentWorkspaceString == null) {
				
				getPathPresentProjet();
				
				/* calcule le parent du path du présent projet. */
				final Path pathWorkspace = pathPresentProjet.getParent();
				
				if (pathWorkspace != null) {
					
					/* passage de Path à String. */
					final String cheminWindowsString = pathWorkspace.toString();
					
					/* remplacement des antislash par des slash. */
					pathPresentWorkspaceString 
						= retournerPathGenerique(cheminWindowsString);
				}
																				
			}
			
			return pathPresentWorkspaceString;
			
		} //Fin de synchronized. ________________________________
		
	} // Fin de getPathPresentWorkspaceString().______________________________


		
	/**
	 * method getPathPresentWorkspace() :<br/>
	 * <ul>
	 * <li>getter du <b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent workspace Eclipse</b> sous forme de <i>Path</i>.</li>
	 * <li>calculé avec pathPresentProjet.getParent().</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon
	 * </li>
	 * </ul>
	 *
	 * @return pathPresentWorkspace : Path.<br/>
	 * 
	 * @throws IOException
	 */
	public static Path getPathPresentWorkspace() throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (pathPresentWorkspace == null) {
				
				getPathPresentWorkspaceString();
				
				/* String vers Path. */
				pathPresentWorkspace = Paths.get(pathPresentWorkspaceString);
			}
			
			return pathPresentWorkspace;
			
		} //Fin de synchronized. ________________________________
		
	} // Fin de getPathPresentWorkspace().____________________________________
	
	
	
	/**
	 * method getPathPresentProjetString() :<br/>
	 * <ul>
	 * <li>Getter du <b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent projet Eclipse</b> sous forme de <i>String</i>.</li>
	 * <li>retourne un <b>Singleton</b>.</li>
	 * <li>calculé avec la position de File("").</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon/generation_code
	 * </li>
	 * </ul>
	 *
	 * @return : pathPresentProjetString : String.<br/>
	 * 
	 * @throws IOException 
	 */
	public static String getPathPresentProjetString() throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (pathPresentProjetString == null) {
				
				/* File désignant le projet courant. */
				final File fileSousProjet = new File(".");
				final Path pathWindowsProjet = fileSousProjet.toPath();
				final Path realPath = pathWindowsProjet.toRealPath();
				
				/* passage de Path à String. */
				final String cheminWindowsString = realPath.toString();
				
				/* remplacement des antislash par des slash. */
				pathPresentProjetString 
					= retournerPathGenerique(cheminWindowsString);
												
			}
			
			return pathPresentProjetString;
			
		} //Fin de synchronized. ________________________________
		
	} // Fin de getPathPresentProjetString().______________________________


		
	/**
	 * method getPathPresentProjet() :<br/>
	 * <ul>
	 * <li>getter du <b>path "générique"</b> (avec des séparateurs slash) 
	 * du <b>présent projet Eclipse</b> sous forme de <i>Path</i>.</li>
	 * <li>calculé avec la position de File("").</li>
	 * <li>Par exemple : <br/>
	 * D:/Donnees/eclipse/eclipseworkspace_neon/generation_code
	 * </li>
	 * </ul>
	 *
	 * @return pathPresentProjet : Path.<br/>
	 * 
	 * @throws IOException
	 */
	public static Path getPathPresentProjet() throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (pathPresentProjet == null) {
				
				getPathPresentProjetString();
				
				/* String vers Path. */
				pathPresentProjet = Paths.get(pathPresentProjetString);
			}
			
			return pathPresentProjet;
			
		} //Fin de synchronized. ________________________________
		
	} // Fin de getPathPresentProjet().____________________________________
	

		
	/**
	 * method getNomPresentProjet() :<br/>
	 * <ul>
	 * <li>Getter du <b>nom du présent projet Eclipse</b>.</li>
	 * <li>utilise <code>
	 * pathPresentWorkspace.relativize(pathPresentProjet)
	 * </code></li>
	 * </ul>
	 *
	 * @return nomPresentProjet : String.<br/>
	 * 
	 * @throws IOException 
	 */
	public static String getNomPresentProjet() 
			throws IOException {
		
		synchronized (ManagerPaths.class) {
			
			if (nomPresentProjet == null) {
				
				getPathPresentWorkspace();
				getPathPresentProjet();
				
				final Path path 
					= pathPresentWorkspace.relativize(pathPresentProjet);
				
				nomPresentProjet = path.toString();
				
			}
			
			return nomPresentProjet;
						
		} //Fin de synchronized. ________________________________
		
	} // Fin de getNomPresentProjet()._____________________________________



	/**
	 * method retournerPathGenerique(
	 * String pPathString) :<br/>
	 * <ul>
	 * <li><b>Remplace les séparateurs de fichier antislash</b> 
	 * dans pPath par des <b>séparateurs génériques slash '/'</b>.</li>
	 * <li>Par exemple : <br/>
	 * <code>retournerPathGenerique("D:\Donnees
	 * \eclipse\eclipseworkspace_neon\generation_code")</code> 
	 * retourne 
	 * <code>
	 * "D:/Donnees/eclipse/eclipseworkspace_neon/generation_code"
	 * </code>
	 * </li>
	 * </ul>
	 *
	 * @param pPathString : String.<br/>
	 * 
	 * @return : String : String avec des slashes
	 *  à la place des antislash.<br/>
	 */
	private static String retournerPathGenerique(
			final String pPathString) {
		
		/* retourne null si pPathString est blank. */
		if (StringUtils.isBlank(pPathString)) {
			return null;
		}
		
		final String resultat 
			= StringUtils.replaceChars(pPathString, '\\', SLASH);
		
		return resultat;
		
	} // Fin de retournerPathGenerique(...)._______________________________
	
	
	
} // FIN DE LA CLASSE ManagerPaths.------------------------------------------
