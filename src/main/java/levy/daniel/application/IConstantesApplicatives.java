package levy.daniel.application;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;

/**
 * class IConstantesApplicatives :<br/>
 * <ul>
 * <li>INTERFACE contenant les constantes mises à disposition 
 * de l'ensemble de l'levy.daniel.application.</li>
 * <p>
 * <br/>
 * <img src="../../../../../../javadoc/images/IConstantesApplicatives.png" 
 * alt="IConstantesApplicatives" border="1" align="center" />
 * <br/>
 * </p>
 * </ul>
 *
 * - Exemple d'utilisation :<br/>
 * <code>// Appel depuis n'importe quelle classe de l'levy.daniel.application 
 * pour concaténer le point-virgule au StringBuilder stb : </code><br/>
 * <code>stb.append(IConstantesApplicatives.POINT_VIRGULE);</code><br/>
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
 * @since 6 oct. 2017
 *
 */
public interface IConstantesApplicatives {
	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	char POINT_VIRGULE = ';';

	
	/**
	 * VIRGULE_ESPACE : String :<br/>
	 * ", ".<br/>
	 */
	String VIRGULE_ESPACE = ", ";

	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	String SEPARATEUR_MOINS_AERE = " - ";
	
	
	/**
	 * UNDERSCORE : String :<br/>
	 * '_'.<br/>
	 */
	char UNDERSCORE = '_';

	
	/**
	 * CROCHET_OUVRANT : char :<br/>
	 * '['.<br/>
	 */
	char CROCHET_OUVRANT = '[';

	
	/**
	 * CROCHET_FERMANT : char :<br/>
	 * ']'.<br/>
	 */
	char CROCHET_FERMANT = ']';
	

	
	/**
	 * SAUT_LIGNE_JAVA : String :<br/>
	 * "\n".<br/>
	 */
	String SAUT_LIGNE_JAVA = "\n";
	

	/**
	 * SAUT_LIGNE_HTML : String :<br/>
	 * "<br/>".<br/>
	 */
	String SAUT_LIGNE_HTML = "<br/>";
	
	
	
	/**
	 * NULL : String :<br/>
	 * "null".<br/>
	 */
	String NULL = "null";
	

	
	/**
	 * DIMENSION_ECRAN : Dimension :<br/>
	 * La dimension de l'écran de l'utilisateur.<br/>
	 */
	Dimension DIMENSION_ECRAN 
		= Toolkit.getDefaultToolkit().getScreenSize();
	
	/**
	 * LARGEUR_ECRAN : int :<br/>
	 * Largeur de l'écran de l'utilisateur en pixels.<br/>
	 */
	int LARGEUR_ECRAN = DIMENSION_ECRAN.width;
	
	
	/**
	 * HAUTEUR_ECRAN : int :<br/>
	 * Hauteur de l'écran de l'utilisateur en pixels.<br/>
	 */
	int HAUTEUR_ECRAN = DIMENSION_ECRAN.height;
	

	
	/**
	 * LOCALE_FR : Locale : <br/>
	 * Locale France.<br/>
	 */
	Locale LOCALE_FR = new Locale("fr", "FR");
	
	
	
	/**
	 * SUCCES : String : <br/>
	 * "success".<br/>
	 */
	String SUCCES = "success";
	
	/**
	 * ECHEC : String : <br/>
	 * "failure".<br/>
	 */
	String ECHEC = "failure";
		
	/**
	 * LIST : String :<br/>
	 * "list".<br/>
	 */
	String LIST = "list";
	
	/**
	 * TROUVE : String :<br/>
	 * "trouve".<br/>
	 */
	String TROUVE = "trouve";


	/**
	 * SANS_OBJET : String :<br/>
	 * "Sans Objet (contrôle non effectué)".<br/>
	 */
	String SANS_OBJET 
		= "Sans Objet (contrôle non effectué)";
	

	/**
	 * NAMESPACE : String :<br/>
	 * Espace de noms pour les fichiers XML.<br/>
	 */
	String NAMESPACE = "levy.daniel.application";

	
	/**
	 * ROOT : String :<br/>
	 * "ROOT : ".<br/>
	 */
	String ROOT = "ROOT : ";

	
	/**
	 * NODE : String :<br/>
	 * "NOEUD (balise ou attribut) : ".<br/>
	 */
	String NODE = "NOEUD (balise ou attribut) : ";
	
	
	/**
	 * ELEMENT : String :<br/>
	 * "ELEMENT (Balise) : ".<br/>
	 */
	String ELEMENT = "ELEMENT (Balise) : ";
	
	
	/**
	 * ATTRIBUT : String :<br/>
	 * "ATTRIBUT".<br/>
	 */
	String ATTRIBUT = "ATTRIBUT";
	

	
	/**
	 * BOM_UTF : char :<br/>
	 * BOM UTF-8 pour forcer Excel 2010 à lire en UTF-8.<br/>
	 */
	char BOM_UTF_8 = '\uFEFF';


	
} // FIN DE L'INTERFACE IConstantesApplicatives.-----------------------------