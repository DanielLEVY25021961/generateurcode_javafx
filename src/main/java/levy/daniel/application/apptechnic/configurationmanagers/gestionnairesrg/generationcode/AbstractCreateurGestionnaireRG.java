package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.generationcode;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.text.WordUtils;

/**
 * class AbstractCreateurGestionnaireRG :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Reflection, Reflexion, introspection, modificateurs,<br/>
 * Class, Field, attribut, complémenter 0 à gauche, zero à gauche,<br/>
 * zéro à gauche,<br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @since 7 déc. 2017
 *
 */
public abstract class AbstractCreateurGestionnaireRG {

	// ************************ATTRIBUTS************************************/

	/**
	 * RG : String :<br/>
	 * "RG".<br/>
	 */
	public static final String RG = "RG";

	
	/**
	 * PARENTHESES : String :<br/>
	 * "() ".<br/>
	 */
	public static final String PARENTHESES = "() ";

	
	/**
	 * CROCHET_OUVRANT : char :<br/>
	 * '{'.<br/>
	 */
	public static final char CROCHET_OUVRANT = '{';

	
	/**
	 * CROCHET_FERMANT : char :<br/>
	 * '}'.<br/>
	 */
	public static final char CROCHET_FERMANT = '}';

	
	/**
	 * POINT : char :<br/>
	 * '.'.<br/>
	 */
	public static final char POINT = '.';
	
	
	/**
	 * UNDERSCORE : char :<br/>
	 * '_'.<br/>
	 */
	public static final char UNDERSCORE = '_';
	
		
	/**
	 * SAUT_LIGNE : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE = '\n';
	

	/**
	 * MOINS_ESPACE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String MOINS_ESPACE = " - ";

	
	/**
	 * EGAL_ESPACE : String :<br/>
	 * " = ".<br/>
	 */
	public static final String EGAL_ESPACE = " = ";

	
	/**
	 * DOUBLE_COTES : char :<br/>
	 * '"'.<br/>
	 */
	public static final char DOUBLE_COTES = '"';
	
	
	/**
	 * PLUS_ESPACE : String :<br/>
	 * " + ".<br/>
	 */
	public static final String PLUS_ESPACE = " + ";
	
	
	/**
	 * DEUX_POINTS_ESPACE : String :<br/>
	 * " : ".<br/>
	 */
	public static final String DEUX_POINTS_ESPACE = " : ";

	
	/**
	 * DU : String :<br/>
	 * " du ".<br/>
	 */
	public static final String DU = " du ";

	
	/**
	 * ESPACE : char :<br/>
	 * ' '.<br/>
	 */
	public static final char ESPACE = ' ';

	
	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
		
	/**
	 * TIRETS : String :<br/>
	 * "--------------------------------------------------------".<br/>
	 */
	public static final String TIRETS 
	= "--------------------------------------------------------";


	/**
	 * nomCompletClasse : String :<br/>
	 * <b>Nom complet</b> (qualifié) de la classe comme 
	 * "levy.daniel.application.model.metier.usersimple
	 * .impl.UserSimple".<br/>
	 */
	public transient String nomCompletClasse;
	
	
	/**
	 * nomSimpleClasse : String :<br/>
	 * <b>Nom simple</b> (court) de la classe comme "UserSimple" 
	 * pour 
	 * "levy.daniel.application.model.metier.usersimple
	 * .impl.UserSimple".<br/>
	 */
	public transient String nomSimpleClasse;
	
	
	/**
	 * nomSimpleClasseMaj : String :<br/>
	 * <b>Nom simple</b> de la classe en <i>majuscules</i> 
	 * comme "USERSIMPLE" pour 
	 * "levy.daniel.application.model.metier.usersimple
	 * .impl.UserSimple".<br/>
	 */
	public transient String nomSimpleClasseMaj;
	
	
	/**
	 * nomSimpleClasseMin : String :<br/>
	 * <b>Nom simple</b> de la classe en <i>minuscules</i> 
	 * comme "usersimple" pour 
	 * "levy.daniel.application.model.metier.usersimple
	 * .impl.UserSimple".<br/>
	 */
	public transient String nomSimpleClasseMin;
	
	
	/**
	 * attributs : Field[] :<br/>
	 * <b>Tableau des attributs</b> <i>déclarés dans la classe</i> 
	 * de l'objet métier pour lequel on veut construire un 
	 * GestionnaireRG.<br/>
	 */
	public transient Field[] attributs;
	
	
	/**
	 * attributsPrivate : List<Field> :<br/>
	 * <b>Liste des attributs</b> private 
	 * <i>déclarés dans la classe</i>.<br/>
	 * <ul>
	 * <li>Sans les attributs PRIVATE STATIC.</li>
	 * <li>Sans les attributs commençant par "id".</li>
	 * </ul>
	 */
	public transient List<Field> attributsPrivate;
	
	
	/**
	 * nomsAttributsPrivate : List<String> :<br/>
	 * <b>Liste des noms des attributs</b> private 
	 * <i>déclarés dans la classe</i>.<br/>
	 * <ul>
	 * <li>Sans les attributs PRIVATE STATIC.</li>
	 * <li>Sans les attributs commençant par "id".</li>
	 * </ul>
	 */
	public transient List<String> nomsAttributsPrivate;

	
	/**
	 * mapRgsParAttribut : Map&lt;String,List&lt;String&gt;&gt; :<br/>
	 * <ul>
	 * Map contenant les Types de RG à vérifier par attribut avec :
	 * <li>String : nom de l'attribut</li>
	 * <li>List&lt;String&gt; : 
	 * liste des types de RG à appliquer pour l'attribut.</li>
	 * </ul>
	 */
	public transient Map<String, List<String>> mapRgsParAttribut 
		= new ConcurrentHashMap<String, List<String>>();
	
	
	/**
	 * listIdsRgs : List&lt;String&gt; :<br/>
	 * <ul>
	 * <b>Liste des identifiants des RG</b> comme :
	 * <li>RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01.</li>
	 * <li>RG_USERSIMPLE_PRENOM_RENSEIGNE_02.</li>
	 * <li>RG_USERSIMPLE_PRENOM_LITTERAL_03.</li>
	 * </ul>
	 * Toujours :<br/>
	 * <b>[RG_CLASSE_ATTRIBUT_TYPE-RG_NUMERO]</b><br/>
	 */
	public transient List<String> listIdsRgs 
		= new ArrayList<String>();

	
	/**
	 * listLignesCodeRgs : List&lt;String&gt; :<br/>
	 * <ul>
	 * <b>Liste des lignes de code des RG</b> à incorporer 
	 * dans une classe GestionnaireRGxxx comme :
	 * <li>public static final String RG_USERSIMPLE
	 * _CIVILITE_NOMENCLATURE_01 
	 * = "RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
	 * civilite du UserSimple doit respecter un ensemble 
	 * fini de valeurs (nomenclature)";</li>
	 * <li>public static final String RG_USERSIMPLE
	 * _PRENOM_RENSEIGNE_02 = "RG_USERSIMPLE_PRENOM_RENSEIGNE_02 
	 * : prenom du UserSimple doit être renseigné (obligatoire)";</li>
	 * <li>public static final String RG_USERSIMPLE
	 * _PRENOM_LITTERAL_03 = "RG_USERSIMPLE_PRENOM_LITTERAL_03 : 
	 * prenom du UserSimple ne doit contenir que des lettres 
	 * ou des caractères spéciaux '-', '_', ... (aucun chiffre)";</li>
	 * </ul>
	 * Une RG s'écrit Toujours :<br/>
	 * <b>[RG_CLASSE_ATTRIBUT_TYPE-RG_NUMERO]</b><br/>
	 */
	public transient List<String> listLignesCodeRgs 
		= new ArrayList<String>();

	
	/**
	 * listBooleansValideurs : List&lt;String&gt; :<br/>
	 * <ul>
	 * Liste des <b>lignes de code</b> relatives aux 
	 * <b>Booleans de validation</b> comme par exemple :
	 * <li>private static Boolean validerUserSimpleNom;</li>
	 * <li>private static Boolean validerUserSimpleNomRenseigne05;</li>
	 * <li>private static Boolean validerUserSimpleNomLitteral06;</li>
	 * <li>private static Boolean validerUserSimpleNomLongueur07;</li>
	 * </ul>
	 */
	public transient List<String> listBooleansValideurs 
		= new ArrayList<String>();
	
	
	/**
	 * listMethodesFournirCle : List&lt;String&gt; :<br/>
	 * <ul>
	 * Liste des <b>lignes de code</b> relatives aux 
	 * <b>méthodes fournirCleBooleanxxx</b> comme par exemple :
	 * <li>private String fournirCleValiderUserSimpleNom() 
	 * {return "valider.UserSimple.Nom";}</li>
	 * <li>private String fournirCleValiderUserSimpleNomRenseigne05() 
	 * {return "valider.UserSimple.Nom.Renseigne.05";}</li>
	 * <li>private String fournirCleValiderUserSimpleNomLitteral06() 
	 * {return "valider.UserSimple.Nom.Litteral.06";}</li>
	 * <li>private String fournirCleValiderUserSimpleNomLongueur07()
	 *  {return "valider.UserSimple.Nom.Longueur.07";}</li>
	 * </ul>
	 */
	public transient List<String> listMethodesFournirCle 
		= new ArrayList<String>();
	
	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
	 = LogFactory.getLog(AbstractCreateurGestionnaireRG.class);


	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractCreateurGestionnaireRG() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	protected AbstractCreateurGestionnaireRG() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	/**
	 * method creerGestionnaireRG(
	 * String pClasse) :<br/>
	 * .<br/>
	 * <br/>
	 *
	 * @param pClasse :  :  .<br/>
	 * @throws ClassNotFoundException 
	 */
	public void creerGestionnaireRG(
			final String pClasse) throws ClassNotFoundException {
		
		if (StringUtils.isBlank(pClasse)) {
			return;
		}
		
		final Class<?> classe = Class.forName(pClasse);
		
		/* Récupère le nom complet de la classe. */
		this.nomCompletClasse = recupererNomCompletClass(classe);
		
		/* Récupère le nom simple de la classe. */
		this.nomSimpleClasse = recupererNomSimpleClass(classe);
		/* Récupère le nom simple de la classe en majuscules. */
		this.nomSimpleClasseMaj = mettreEnMajuscules(this.nomSimpleClasse);
		/* Récupère le nom simple de la classe en minuscules. */
		this.nomSimpleClasseMin = mettreEnMinuscules(this.nomSimpleClasse);
		
		/* récupère tous les attributs de la classe. */
		this.attributs = recupererAttributs(classe);
		/* récupère tous les attributs private de la classe. */
		this.attributsPrivate = recupererAttributsPrivate(classe);
		/* récupère les noms de tous les attributs private de la classe. */
		this.nomsAttributsPrivate = recupererNomsAttributsPrivate(classe);
		
		/* AFFICHAGE DES ATTRIBUTS PRIVATE. */
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("LISTE DES ATTRIBUTS SIMPLEMENT PRIVATE DE LA CLASSE (sans id) : ");
		System.out.println(afficherListString(this.nomsAttributsPrivate));
		System.out.println(TIRETS);
		System.out.println();
		
		/* CREE LA MAP DES REGLES PAR ATTRIBUT. */
		this.affecterRgAuxAttributs();
		
		/* CREE la liste des identifiants des RG listIdsRgs. */
		/* CREE la liste des lignes de code des RG listLignesCodeRgs. */
		this.creerListesRG();
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("LISTE DES IDENTIFIANTS DES RG : ");
		System.out.println(afficherListString(this.listIdsRgs));
		System.out.println(TIRETS);
		System.out.println();
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("LISTE DES LIGNES DE CODE RG : ");
		System.out.println(afficherListString(this.listLignesCodeRgs));
		System.out.println(TIRETS);
		System.out.println();
		
		/* CREE LA LISTE DES BOOLEANS. */
		this.creerBooleans();
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("LISTE DES VALIDEURS : ");
		System.out.println(afficherListString(this.listBooleansValideurs));
		System.out.println(TIRETS);
		System.out.println();
		
		/* CREE LA LISTE DES METHODES fournirCle. */
		this.creerMethodesFournirCle();
		
		System.out.println();
		System.out.println(TIRETS);
		System.out.println("LISTE DES METHODES fournirCle : ");
		System.out.println(afficherListString(this.listMethodesFournirCle));
		System.out.println(TIRETS);
		System.out.println();
		
	} // Fin de creerGestionnaireRG(...).__________________________________
	

	
	/**
	 * method affecterRgAuxAttributs() :<br/>
	 * <ul>
	 * <li>CREE la <b>mapRgsParAttribut</b>.</li>
	 * <li>A FAIRE A LA MAIN DANS CHAQUE CREATEUR CONCRET.</li>
	 * </ul>
	 */
	protected abstract void affecterRgAuxAttributs();
	

	
	/**
	 * method creerListesRG() :<br/>
	 * <ul>
	 * <li>crée la liste des <b>identifiants des RG "listIdsRgs"</b> 
	 * (RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01
	 * , RG_USERSIMPLE_PRENOM_RENSEIGNE_02, ...).</li>
	 * <li>crée la liste des <b>lignes de code des RG 
	 * "listLignesCodeRgs"</b> à intégrer 
	 * dans la classe GestionnaireRGxxx
	 * comme :<br/>
	 * public static final String 
	 * RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 = 
	 * "RG_USERSIMPLE_CIVILITE_NOMENCLATURE_01 : 
	 * civilite du UserSimple doit respecter 
	 * un ensemble fini de valeurs (nomenclature)";.</li>
	 * </ul>
	 *
	 */
	private void creerListesRG() {

		int compteur = 0;

		for (final String nomAttribut : this.nomsAttributsPrivate) {

			final List<String> typesRg 
				= this.mapRgsParAttribut.get(nomAttribut);

			for (final String type : typesRg) {

				compteur++;
				final StringBuilder stbCode = new StringBuilder();
				final StringBuilder stbId = new StringBuilder();

				/* Ligne de code RG. */
				stbCode.append("public static final String ");

				/* Identifiant RG. */
				stbId.append(RG);
				stbId.append(UNDERSCORE);
				stbId.append(this.nomSimpleClasseMaj);
				stbId.append(UNDERSCORE);
				stbId.append(mettreEnMajuscules(nomAttribut));
				stbId.append(UNDERSCORE);
				stbId.append(mettreEnMajuscules(type));
				stbId.append(UNDERSCORE);
				stbId.append(formaterNumero(compteur));

				this.listIdsRgs.add(stbId.toString());
				
				/* Ligne de code RG. */
				stbCode.append(stbId);
				stbCode.append(EGAL_ESPACE);
				stbCode.append(DOUBLE_COTES);
				stbCode.append(stbId);
				
				stbCode.append(DEUX_POINTS_ESPACE);
				stbCode.append(nomAttribut);
				stbCode.append(DU);
				stbCode.append(this.nomSimpleClasse);
				stbCode.append(ESPACE);
				stbCode.append(fournirMessageType(type));
				stbCode.append(DOUBLE_COTES);
				stbCode.append(POINT_VIRGULE);

				this.listLignesCodeRgs.add(stbCode.toString());

			} // Fin de TypeRG.__________________________________
		}

	} // Fin de creerListesRG(...).________________________________________

	
	
	/**
	 * method fournirMessageType(
	 * String pType) :<br/>
	 * <ul>
	 * <li>Fournit une partie du <b>message</b> d'une RG 
	 * en fonction de son <b>type</b>.</li>
	 * <li>Par exemple "doit être renseigné" 
	 * si pType vaut "RENSEIGNE".</li>
	 * </ul>
	 * retourne null si pType est blank.<br/>
	 * <br/>
	 *
	 * @param pType : String : valeur possible dans 
	 * l'Enumeration TypesValidation.<br/>
	 * 
	 * @return : String : fin du message de la RG 
	 * en fonction du type.<br/>
	 */
	private static String fournirMessageType(
			final String pType) {
		
		/* retourne null si pType est blank. */
		if (StringUtils.isBlank(pType)) {
			return null;
		}
		
		String resultat = null;
		
		if (StringUtils.equalsIgnoreCase(
				"RENSEIGNE", pType)) {
			resultat = "doit être renseigné (obligatoire)";
		}
		else if (StringUtils.equalsIgnoreCase(
				"LITTERAL", pType)) {
			resultat = "ne doit contenir que des lettres ou des "
					+ "caractères spéciaux '-', '_', "
					+ "... (aucun chiffre)";
		}
		else if (StringUtils.equalsIgnoreCase(
				"LITTERAL_ALPHABETIQUE", pType)) {
			resultat = "ne doit contenir que des lettres de l'alphabet "
					+ "(aucun caractères spéciaux '-', '_', "
					+ "et aucun chiffre)";
		}
		else if (StringUtils.equalsIgnoreCase(
				"NUMERIQUE", pType)) {
			resultat = "ne doit contenir que des chiffres "
					+ "(aucune lettre ou caractère spécial)";
		}
		else if (StringUtils.equalsIgnoreCase(
				"LONGUEUR", pType)) {
			resultat = "doit contenir entre [min] et [max] caractères";
		}
		else if (StringUtils.equalsIgnoreCase(
				"MOTIF", pType)) {
			resultat = "doit respecter un motif (Regex)";
		}
		else if (StringUtils.equalsIgnoreCase("NOMENCLATURE", pType)) {
			resultat = "doit respecter un ensemble "
					+ "fini de valeurs (nomenclature)";
		}
		else if (StringUtils.equalsIgnoreCase("FOURCHETTE", pType)) {
			resultat = "doit être compris entre [min] et [max]";
		}
		
		return resultat;
		
	} // Fin de fournirMessageType(...).___________________________________
	

	
	/**
	 * method creerBooleans() :<br/>
	 * <ul>
	 * Crée la liste <b>listBooleansValideurs</b> des <b>lignes de code</b> 
	 * relatives aux <b>Booleans de validation</b> comme par exemple :
	 * <li>private static Boolean validerUserSimpleNom;</li>
	 * <li>private static Boolean validerUserSimpleNomRenseigne05;</li>
	 * <li>private static Boolean validerUserSimpleNomLitteral06;</li>
	 * <li>private static Boolean validerUserSimpleNomLongueur07;</li>
	 * </ul>
	 */
	private void creerBooleans() {
		
		int compteur = 0;
		

		for (final String nomAttribut : this.nomsAttributsPrivate) {
			
			final StringBuilder stbValideurBoolean = new StringBuilder();
			
			/* Base Ligne de code Valideur. */
			stbValideurBoolean.append("private static Boolean ");
			stbValideurBoolean.append("valider");
			stbValideurBoolean.append(this.nomSimpleClasse);
			stbValideurBoolean.append(mettrePremiereEnMajuscule(nomAttribut));
			
			final String baseAttribut = stbValideurBoolean.toString();
			this.listBooleansValideurs.add(
					baseAttribut + POINT_VIRGULE);

			final List<String> typesRg 
				= this.mapRgsParAttribut.get(nomAttribut);

			for (final String type : typesRg) {

				compteur++;
				
				final StringBuilder stb = new StringBuilder();
				
				stb.append(baseAttribut);
				stb.append(mettrePremiereEnMajuscule(type));
				stb.append(formaterNumero(compteur));
				
				this.listBooleansValideurs.add(
						stb.toString() + POINT_VIRGULE);

			} // Fin de TypeRG.__________________________________
			
		}
		
	} // Fin de creerBooleans().___________________________________________
	
	
	
	/**
	 * method creerMethodesFournirCle() :<br/>
	 * <ul>
	 * Crée la Liste <b>"listMethodesFournirCle"</b> 
	 * des <b>lignes de code</b> relatives aux 
	 * <b>méthodes fournirCleBooleanxxx</b> comme par exemple :
	 * <li>private String fournirCleValiderUserSimpleNom() 
	 * {return "valider.UserSimple.Nom";}</li>
	 * <li>private String fournirCleValiderUserSimpleNomRenseigne05() 
	 * {return "valider.UserSimple.Nom.Renseigne.05";}</li>
	 * <li>private String fournirCleValiderUserSimpleNomLitteral06() 
	 * {return "valider.UserSimple.Nom.Litteral.06";}</li>
	 * <li>private String fournirCleValiderUserSimpleNomLongueur07()
	 *  {return "valider.UserSimple.Nom.Longueur.07";}</li>
	 * </ul>
	 */
	private void creerMethodesFournirCle() {
		
		int compteur = 0;
		
		for (final String nomAttribut : this.nomsAttributsPrivate) {
			
			final StringBuilder stbValideurBoolean = new StringBuilder();
			final StringBuilder stbCorpsMethode = new StringBuilder();
			final StringBuilder stbCle = new StringBuilder();
			
			/* Base Ligne de code Valideur. */
			stbValideurBoolean.append("private String fournirCle");
			stbValideurBoolean.append("Valider");
			stbValideurBoolean.append(this.nomSimpleClasse);
			stbValideurBoolean.append(mettrePremiereEnMajuscule(nomAttribut));
			
			/* private String fournirCleValiderUserSimpleNom. */
			final String baseAttribut = stbValideurBoolean.toString();
			
			stbCorpsMethode.append(baseAttribut);
			stbCorpsMethode.append(PARENTHESES);
			stbCorpsMethode.append(CROCHET_OUVRANT);
			
			stbCle.append("valider");
			stbCle.append(POINT);
			stbCle.append(this.nomSimpleClasse);
			stbCle.append(POINT);
			stbCle.append(mettrePremiereEnMajuscule(nomAttribut));
			
			stbCorpsMethode.append(stbCle);
			stbCorpsMethode.append(CROCHET_FERMANT);
			stbCorpsMethode.append(POINT_VIRGULE);
			
			/* valider.UserSimple.Nom */
			final String baseCle = stbCle.toString();
			final String corpsMethode = stbCorpsMethode.toString();
			
			this.listMethodesFournirCle.add(corpsMethode);

			final List<String> typesRg 
				= this.mapRgsParAttribut.get(nomAttribut);

			for (final String type : typesRg) {

				compteur++;
				
				final StringBuilder stb = new StringBuilder();
				final StringBuilder stbCorpsMethodeInterne = new StringBuilder();
				
				/* private String fournirCleValiderUserSimpleNom. */
				stb.append(baseAttribut);
				stb.append(mettrePremiereEnMajuscule(type));
				stb.append(formaterNumero(compteur));
				
				stbCorpsMethodeInterne.append(stb);
				stbCorpsMethodeInterne.append(PARENTHESES);
				stbCorpsMethodeInterne.append(CROCHET_OUVRANT);
				stbCorpsMethodeInterne.append(baseCle);
				stbCorpsMethodeInterne.append(POINT);
				stbCorpsMethodeInterne.append(mettrePremiereEnMajuscule(type));
				stbCorpsMethodeInterne.append(POINT);
				stbCorpsMethodeInterne.append(formaterNumero(compteur));
				stbCorpsMethodeInterne.append(CROCHET_FERMANT);
				stbCorpsMethodeInterne.append(POINT_VIRGULE);
				
				this.listMethodesFournirCle.add(
						stbCorpsMethodeInterne.toString());

			} // Fin de TypeRG.__________________________________
			
		}
		
	} // Fin de creerMethodesFournirCle()._________________________________



	/**
	 * method recupererNomCompletClass(
	 * Class<?> pClasse) :<br/>
	 * <ul>
	 * <li>fournit le <b>nom complet</b> de pClasse.</li>
	 * <li>Par exemple : 
	 * <b>"levy.daniel.application.model.metier.usersimple.
	 * impl.UserSimple"</b>.</li>
	 * </ul>
	 * retourne null si pClasse == null.<br/>
	 * <br/>
	 *
	 * @param pClasse : java.lang.Class.<br/>
	 * 
	 * @return : String : nom complet de la classe.<br/>
	 */
	private String recupererNomCompletClass(
			final Class<?> pClasse) {
		
		/* retourne null si pClasse == null. */
		if (pClasse == null) {
			return null;
		}
		
		return pClasse.getName();
		
	} // Fin de recupererNomCompletClass(...)._____________________________
	
	
	
	/**
	 * method recupererNomSimpleClass(
	 * Class<?> pClasse) :<br/>
	 * <ul>
	 * <li>fournit le <b>nom court</b> (simple) de pClasse.</li>
	 * <li>Par exemple : 
	 * <b>"UserSimple"</b> pour 
	 * "levy.daniel.application.model.metier.usersimpleimpl
	 * .UserSimple".</li>
	 * </ul>
	 * retourne null si pClasse == null.<br/>
	 * <br/>
	 *
	 * @param pClasse : java.lang.Class.<br/>
	 * 
	 * @return : String : nom complet de la classe.<br/>
	 */
	private String recupererNomSimpleClass(
			final Class<?> pClasse) {
		
		/* retourne null si pClasse == null. */
		if (pClasse == null) {
			return null;
		}
		
		return pClasse.getSimpleName();
		
	} // Fin de recupererNomSimpleClass(...).______________________________
	
	
	
	/**
	 * method recupererAttributs(
	 * Class<?> pClasse) :<br/>
	 * <ul>
	 * <li>Fournit le <b>tableau des attributs</b> 
	 * <i>déclarés dans la classe</i> pClasse.</li>
	 * </ul>
	 * retourne null si pClasse == null.<br/>
	 * <br/>
	 *
	 * @param pClasse : Class.<br/>
	 * 
	 * @return : Field[] : Tableau des attributs 
	 * déclarés DANS la classe.<br/>
	 */
	private Field[] recupererAttributs(
			final Class<?> pClasse) {
		
		/* retourne null si pClasse == null. */
		if (pClasse == null) {
			return null;
		}
		
		final Field[] resultat = pClasse.getDeclaredFields();
		
		return resultat;
		
	} // Fin de recupererAttributs(...).___________________________________

	
	
	/**
	 * method recupererAttributsPrivate(
	 * Class<?> pClasse) :<br/>
	 * <ul>
	 * <li>Fournit la <b>liste des attributs simplement PRIVATE</b> 
	 * <i>déclarés dans la classe</i> pClasse.</li>
	 * <li>Elimine les attributs PRIVATE STATIC.</li>
	 * <li>Elimine les attributs commençant par "id".</li>
	 * </ul>
	 * retourne null si pClasse == null.<br/>
	 * retourne null si le tableau des attributs 
	 * de la classe est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : Class.<br/>
	 * 
	 * @return : List&lt;Field&gt; : liste des <b>attributs</b> 
	 * simplement PRIVATE déclarés DANS la classe (sans l'id).<br/>
	 */
	private List<Field> recupererAttributsPrivate(
			final Class<?> pClasse) {
		
		/* retourne null si pClasse == null. */
		if (pClasse == null) {
			return null;
		}
		
		final List<Field> resultat = new ArrayList<Field>();
		
		final Field[] attributsClasse = pClasse.getDeclaredFields();
		
		/* retourne null si le tableau des 
		 * attributs de la classe est null. */
		if (attributsClasse == null) {
			return null;
		}
		
		for (int i = 0; i < attributsClasse.length; i++) {
			
			final Field attribut = attributsClasse[i];
			final String nomAttribut = attribut.getName();
			final int modifiers = attribut.getModifiers();
			
			if (Modifier.isPrivate(modifiers)) {
				if (!Modifier.isStatic(modifiers)) {
					if (!StringUtils.startsWith(nomAttribut, "id")) {
						resultat.add(attribut);
					}					
				}				
			}			
		}
		
		return resultat;
		
	} // Fin de recupererAttributsPrivate(...).___________________________________

	
		
	/**
	 * method recupererNomsAttributsPrivate(
	 * Class<?> pClasse) :<br/>
	 * <ul>
	 * <li>Fournit la <b>liste des <i>noms</i> des 
	 * attributs simplement PRIVATE</b> 
	 * <i>déclarés dans la classe</i> pClasse.</li>
	 * <li>Elimine les attributs PRIVATE STATIC.</li>
	 * <li>Elimine les attributs commençant par "id".</li>
	 * </ul>
	 * retourne null si pClasse == null.<br/>
	 * retourne null si le tableau des attributs 
	 * de la classe est null.<br/>
	 * <br/>
	 *
	 * @param pClasse : Class.<br/>
	 * 
	 * @return : List&lt;String&gt; : liste des <b>noms</b> des attributs 
	 * simplement PRIVATE déclarés DANS la classe (sans l'id).<br/>
	 */
	private List<String> recupererNomsAttributsPrivate(
			final Class<?> pClasse) {
		
		/* retourne null si pClasse == null. */
		if (pClasse == null) {
			return null;
		}
		
		final List<String> resultat = new ArrayList<String>();
		
		final Field[] attributsClasse = pClasse.getDeclaredFields();
		
		/* retourne null si le tableau des 
		 * attributs de la classe est null. */
		if (attributsClasse == null) {
			return null;
		}
		
		for (int i = 0; i < attributsClasse.length; i++) {
			
			final Field attribut = attributsClasse[i];
			final String nomAttribut = attribut.getName();
			final int modifiers = attribut.getModifiers();
			
			if (Modifier.isPrivate(modifiers)) {
				if (!Modifier.isStatic(modifiers)) {
					if (!StringUtils.startsWith(nomAttribut, "id")) {
						resultat.add(nomAttribut);
					}					
				}				
			}			
		}
		
		return resultat;
		
	} // Fin de recupererNomsAttributsPrivate(...).________________________


	
	/**
	 * method mettreEnMajuscules(
	 * String pString) :<br/>
	 * <ul>
	 * <li>passe tous les caractères de pString en <b>majuscules</b>.</li>
	 * </ul>
	 * retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : chaine à passer 
	 * intégralement en majuscules.<br/>
	 * 
	 * @return : String : chaine entièrement en majuscules.<br/>
	 */
	private String mettreEnMajuscules(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		String resultat = null;
		
		/* Met en majuscules. */
		resultat = pString.toUpperCase(Locale.getDefault());
		
		return resultat;
		
	} // Fin de mettreEnMajuscules(...).___________________________________


	
	/**
	 * method mettrePremiereEnMajuscule() :<br/>
	 * <ul>
	 * <li>Met la première lettre de chaque mots séparés 
	 * par des espaces en majuscule.</li>
	 * <li>Met les autres de lettres de chaque mots séparés 
	 * par un espace en minuscule.</li>
	 * <li>Par exemple : "premier" est transformé en "Premier".</li>
	 * <li>"PREMIER" est transformé en "Premier".</li>
	 * </ul>
	 * retourne null si pString == null.<br/>
	 * <br/>
	 * 
	 *
	 * @param pString : String. <br/>
	 * 
	 * @return : String.<br/>
	 */
	private String mettrePremiereEnMajuscule(
			final String pString) {
		
		/* retourne null si pString == null. */
		if (pString == null) {
			return null;
		}
		
		return WordUtils.capitalizeFully(pString);
		
	} // Fin de mettrePremiereEnMajuscule(...).____________________________
	
	
	
	/**
	 * method mettreEnMinuscules(
	 * String pString) :<br/>
	 * <ul>
	 * <li>passe tous les caractères de pString en <b>minuscules</b>.</li>
	 * </ul>
	 * retourne null si pString est blank.<br/>
	 * <br/>
	 *
	 * @param pString : String : chaine à passer 
	 * intégralement en minuscules.<br/>
	 * 
	 * @return : String : chaine entièrement en minuscules.<br/>
	 */
	private String mettreEnMinuscules(
			final String pString) {
		
		/* retourne null si pString est blank. */
		if (StringUtils.isBlank(pString)) {
			return null;
		}
		
		String resultat = null;
		
		/* Met en minuscules. */
		resultat = pString.toLowerCase(Locale.getDefault());
		
		return resultat;
		
	} // Fin de mettreEnMinuscules(...).___________________________________
	
	
	
	/**
	 * method modifierFromString(
	 * String pString) :<br/>
	 * <ul>
	 * <li>Fournit la <b>valeur entière</b> de la constante stockée 
	 * dans la classe Modifier pour un modificateur.</li>
	 * <li>Par exemple, modifierFromString("static") 
	 * retourne 8.</li>
	 * 
	 * </ul>
	 *
	 * @param pString : modificateur comme "static".<br/>
	 * 
	 * @return : int : Valeur entière de la Constante associée 
	 * au modificateur dans la classe Modifier.<br/>
	 */
	private int modifierFromString(
			final String pString) {

		int m = 0x0;
		
		if ("public".equalsIgnoreCase(pString)) {
			m |= Modifier.PUBLIC;
		}
		else if ("protected".equalsIgnoreCase(pString)) {
			m |= Modifier.PROTECTED;
		}
		else if ("private".equalsIgnoreCase(pString)) {
			m |= Modifier.PRIVATE;
		}
		else if ("static".equalsIgnoreCase(pString)) {
			m |= Modifier.STATIC;
		}
		else if ("final".equalsIgnoreCase(pString)) {
			m |= Modifier.FINAL;
		}
		else if ("transient".equalsIgnoreCase(pString)) {
			m |= Modifier.TRANSIENT;
		}
		else if ("volatile".equalsIgnoreCase(pString)) {
			m |= Modifier.VOLATILE;
		}
		
		return m;
		
	} // Fin de modifierFromString(...).___________________________________

	
	
	/**
	 * method formaterNumero(
	 * int pNumero) :<br/>
	 * <ul>
	 * <li>Formate un <b>numéro entier</b> en <b>String</b>.</li>
	 * <li>Complémente avec un 0 à gauche les entiers < 10.</li>
	 * <li>Par exemple, 2 est transformé en "02", 12 en "12".</li>
	 * </ul>
	 *
	 * @param pNumero : int : numéro.<br/>
	 * 
	 * @return : String : entier transformé en String avec un zéro 
	 * en complément à gauche si pNumero < 10.<br/>
	 */
	private String formaterNumero(
			final int pNumero) {
		
		String resultat = null;
		
		/* Si le nombre < 10, rajoute un zéro à gauche. */
		if (pNumero < 10) {
			
			resultat 
				= String.format(
						Locale.getDefault()
						, "%1$02d"
						, pNumero);
		}
		else {
			
			resultat 
			= String.format(
					Locale.getDefault()
					, "%1$d"
					, pNumero);
		}
				
		return resultat;
		
	} // Fin de formaterNumero(...)._______________________________________


	
	/**
	 * method afficherAttributs(
	 * Field[] pAttributs) :<br/>
	 * <ul>
	 * fabrique une String pour l'affichage des attributs 
	 * contenus dans le tableau pAttributs.
	 * <li>affiche le <b>nom</b> de l'attribut.</li>
	 * <li>affiche le <b>type</b> de l'attribut.</li>
	 * <li>affiche les <b>modificateurs</b> de l'attribut 
	 * (public, protected, private, static, final, abstract
	 * , transient, ...).</li>
	 * </ul>
	 * retourne null si pAttributs == null.<br/>
	 * <br/>
	 * 
	 *
	 * @param pAttributs : Field[].<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherAttributs(
			final Field[] pAttributs) {
		
		/* retourne null si pAttributs == null. */
		if (pAttributs == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (int i = 0; i < pAttributs.length; i++) {
			
			final Field attribut = pAttributs[i];
			final String nomAttribut = attribut.getName();
			final Class<?> typeAttribut = attribut.getType();
			
			final int modifiers = attribut.getModifiers();
			final String modificateurs = Modifier.toString(modifiers);
			
			
			final String affichage 
			= String.format(Locale.getDefault()
					, "nom : %1$-30s      type : %2$-45s       modificateurs : %3$-35s"     
					, nomAttribut, typeAttribut, modificateurs);
			
			stb.append(affichage);
			stb.append(SAUT_LIGNE);
		}
		
		return stb.toString();
		
	} // Fin de afficherAttributs(...).____________________________________

	
	
	/**
	 * method afficherListAttributs(
	 * List&lt;Field&gt; pAttributs) :<br/>
	 * <ul>
	 * fabrique une String pour l'affichage des attributs 
	 * contenus dans la liste pAttributs.
	 * <li>affiche le <b>nom</b> de l'attribut.</li>
	 * <li>affiche le <b>type</b> de l'attribut.</li>
	 * <li>affiche les <b>modificateurs</b> de l'attribut 
	 * (public, protected, private, static, final, abstract
	 * , transient, ...).</li>
	 * </ul>
	 * retourne null si pAttributs == null.<br/>
	 * <br/>
	 *
	 * @param pAttributs : List&lt;Field&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListAttributs(
			final List<Field> pAttributs) {
		
		/* retourne null si pAttributs == null. */
		if (pAttributs == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		for (final Field attribut : pAttributs) {
			
			final String nomAttribut = attribut.getName();
			final Class<?> typeAttribut = attribut.getType();
			
			final int modifiers = attribut.getModifiers();
			final String modificateurs = Modifier.toString(modifiers);
			
			
			final String affichage 
			= String.format(Locale.getDefault()
					, "nom : %1$-30s      type : %2$-45s       modificateurs : %3$-35s"     
					, nomAttribut, typeAttribut, modificateurs);
			
			stb.append(affichage);
			stb.append(SAUT_LIGNE);
		}
		
		return stb.toString();
		
	} // Fin de afficherListAttributs(...).________________________________


	
	/**
	 * method afficherListString(
	 * List&lt;String&gt; pList) :<br/>
	 * <ul>
	 * fabrique une String pour l'affichage des Strings 
	 * contenus dans la liste pList.
	 * </ul>
	 * retourne null si pList == null.<br/>
	 * <br/>
	 *
	 * @param pList : List&lt;String&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherListString(
			final List<String> pList) {
		
		/* retourne null si pList == null. */
		if (pList == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		int compteur = 0;
		final int tailleListe = pList.size();
		
		for (final String chaine : pList) {
			
			compteur++;
			
			stb.append(chaine);
			
			if (compteur < tailleListe) {
				stb.append(SAUT_LIGNE);
			}			
		}
		
		return stb.toString();
		
	} // Fin de afficherListString(...).___________________________________
	

	
	
	/**
	 * method afficherMapStringList(
	 * Map&lt;String, List&lt;String&gt;&gt; pMap) :<br/>
	 * <ul>
	 * <li>.</li>
	 * <li>.</li>
	 * </ul>
	 * return null si pMap == null.<br/>
	 * <br/>
	 *
	 * @param pMap : Map&lt;String, List&lt;String&gt;&gt;.<br/>
	 * 
	 * @return : String.<br/>
	 */
	public String afficherMapStringList(
			final Map<String, List<String>> pMap) {
		
		/* return null si pMap == null. */
		if (pMap == null) {
			return null;
		}
		
		
		final StringBuilder stb = new StringBuilder();
		
		final Set<Entry<String, List<String>>> entrySet 
			= pMap.entrySet();
		
		final Iterator<Entry<String, List<String>>> ite 
			= entrySet.iterator();
		
		while (ite.hasNext()) {
			
			final Entry<String, List<String>> entry = ite.next();
			final String nomAttribut = entry.getKey();
			final List<String> listeTypesRg = entry.getValue();
			
			stb.append(nomAttribut);
			stb.append(SAUT_LIGNE);
			
			int compteur = 0;
			
			for (final String type : listeTypesRg) {
				compteur++;
				stb.append(type);
				
				if (compteur < listeTypesRg.size()) {
					stb.append(MOINS_ESPACE);
				}
			}
			
			stb.append(SAUT_LIGNE);
			
		}
		
		return stb.toString();
		
	} // Fiin de afficherMapStringList(...)._______________________________
	
		

} // FIN DE LA CLASSE AbstractCreateurGestionnaireRG.------------------------
