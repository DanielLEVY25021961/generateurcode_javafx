package levy.daniel.application.model.services.valideurs;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;

/**
 * class AbstractValideurGeneric :<br/>
 * .<br/>
 * <br/>
 *
 * - Exemple d'utilisation :<br/>
 *<br/>
 * 
 * - Mots-clé :<br/>
 * Tri d'une Collection, Collections.sort(List...), <br/>
 * Tri de Map, SortedMap, TreeMap, <br/>
 * <br/>
 *
 * - Dépendances :<br/>
 * <br/>
 *
 *
 * @author dan Lévy
 * @version 1.0
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @since 30 août 2017
 *
 */
public abstract class AbstractValideurGeneric<T> 
		implements IValideurGeneric<T> {

	// ************************ATTRIBUTS************************************/

	
	/**
	 * listeRGImplementees : List&lt;LigneRG&gt; :<br/>
	 * Liste des RG implémentées dans le Service.<br/>
	 * Une LigneRG encapsule :<br/>
	 * <br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 */
	protected transient List<LigneRG> listeRGImplementees 
		= new ArrayList<LigneRG>();

		
	/**
	 * erreurs : Map<String,Map<String,String>> :<br/>
	 * map&lt;String, map&lt;String, String&gt;&gt; 
	 * contenant les messages d'erreur avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le message d'erreur (par exemple "prénom").</li>
	 * <li>map&lt;String, String&gt; : une map contenant :
	 * <ul>
	 * <li>String : le nom de la RG violée (par exemple 
	 * "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.").</li>
	 * <li>String : le message d'erreur relatif à la RG 
	 * (par exemple : "Le nom n'est pas renseigné (obligatoire).").</li>
	 * </ul>
	 * </ul>
	 * </ul>
	 * this.erreurs n'est jamais null. 
	 * Elle est vide si il n'y a aucune erreur.<br/>
	 */
	protected transient Map<String, Map<String, String>> erreurs 
			= new ConcurrentHashMap<String, Map<String, String>>();
	
	
	/**
	 * controles : Map<String,Map<String,LigneRapportValidation>> :<br/>
	 * map&lt;String, map&lt;String, LigneRapportValidation&gt;&gt; 
	 * contenant les rapports de contrôle (validation) avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le rapport de contrôle (par exemple "prénom").</li>
	 * <li>map&lt;String, LigneRapportValidation&gt; : une map contenant :
	 * <ul>
	 * <li>String : le nom de la RG violée (par exemple 
	 * "RG_CLIENT_NOM_01 : le nom du client doit être renseigné.").</li>
	 * <li>LigneRapportValidation : Pure fabrication encapsulant 
	 * tous les éléments d'information relatifs à un contrôle 
	 * (validation d'une RG).</li>
	 * <br/>
	 * Une LigneRapportValidation encapsule : <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * </ul>
	 * </ul>
	 * </ul>
	 * this.controles n'est jamais null. 
	 * Elle est vide si il n'y a aucun contrôle effectué 
	 * dans l'application.<br/>
	 */
	protected transient Map<String, Map<String, LigneRapportValidation>> controles 
	= new ConcurrentHashMap<String, Map<String, LigneRapportValidation>>();
	
			
			
	/**
	 * controlesList : List&lt;LigneRapportValidation&gt; :<br/>
	 * Liste des Pures fabrications encapsulant 
	 * tous les éléments d'information relatifs à un contrôle 
	 * (validation d'une RG).</li>
	 * <br/>
	 * Une LigneRapportValidation encapsule : <br/>
	 * "id;nom de la RG;Résultat de la Validation;
	 * Message d'Erreur du contrôle;Actif;
	 * activité des contrôles sur l'attribut;activité de la RG;
	 * clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;
	 * Classe implémentant la RG;Méthode implémentant la RG;".<br/>
	 * </ul>
	 * </ul>
	 * </ul>
	 */
	protected transient List<LigneRapportValidation> controlesList 
		= new ArrayList<LigneRapportValidation>();

	
	/**
	 * valide : Boolean :<br/>
	 * Boolean qui stipule si le contrôle effectué par le validateur 
	 * est sans erreur ou pas.<br/>
	 */
	protected transient Boolean valide;
	

	/**
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';
	
	
	/**
	 * SAUT_LIGNE : String :<br/>
	 * "\n".<br/>
	 */
	public static final String SAUT_LIGNE = "\n";
	

	/**
	 * SAUT_LIGNE_HTML : String :<br/>
	 * "<br/>".<br/>
	 */
	public static final String SAUT_LIGNE_HTML = "<br/>";
	

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractValideurGeneric.class);

	// *************************METHODES************************************/
	
		
	 /**
	 * method CONSTRUCTEUR AbstractValideurGeneric() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractValideurGeneric() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract Map<String, Map<String, String>> validate(T pObject) 
			throws MalformedURLException;


	
	/**
	 * method determinerSiControleValide() :<br/>
	 * Détermine si le controle est OK 
	 * (map d'erreurs vide pour tous les attributs dans this.erreurs) 
	 * ou pas.<br/>
	 * <br/>
	 *
	 * @return : Boolean : true aucun attribut ne comporte d'erreur.<br/>
	 */
	private Boolean determinerSiControleValide() {
		
		boolean resultat = true;
		
		final Set<Entry<String, Map<String, String>>> entrySet 
			= this.erreurs.entrySet();
		
		final Iterator<Entry<String, Map<String, String>>> ite 
			= entrySet.iterator();
				
		while (ite.hasNext()) {
			
			final Entry<String, Map<String, String>> entry = ite.next();
						
			final Map<String, String> erreurAttr = entry.getValue();
			
			if (!erreurAttr.isEmpty()) {
				resultat = false;
				break;
			}
			
		}
		
		return resultat;
		
	} // Fin de determinerSiControleValide().______________________________
	
	
	
	/**
	 * method alimenterListeRGImplementees(
	 * LigneRG pLigneRG) :<br/>
	 * <ul>
	 * <li>Ajoute une LigneRG à this.listeRGImplementees 
	 * comportant toutes les RG 
	 * contrôlées par la présente classe.</li>
	 * <li> Une ligneRG csv se présente comme suit :<br/> 
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".</li>
	 * </ul>
	 * <br/>
	 * retourne null si this.listeRGImplementees == null.<br/>
	 * <br/>
	 *
	 * @param pLigneRG : LigneRG.<br/>
	 * 
	 * @return : List&lt;LigneRG&gt; : this.listeRGImplementees.<br/>
	 */
	protected final List<LigneRG> alimenterListeRGImplementees(
				final LigneRG pLigneRG) {
		
		/* retourne null si this.listeRGImplementees == null. */
		if (this.listeRGImplementees == null) {
			return null;
		}
				
		this.listeRGImplementees.add(pLigneRG);
		
		return this.listeRGImplementees;
		
	} // Fin de alimenterListeRGImplementees(...)._________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirEnTeteCsvRGImplementees() {
		
		return "id;Actif;activité des contrôles sur l'attribut;"
				+ "activité de la RG;RG implémentée;clé du type de contrôle;"
				+ "type de contrôle;"
				+ "Message d'erreur;Objet Métier concerné;"
				+ "Attribut concerné;Classe implémentant la RG;"
				+ "Méthode implémentant la RG;properties;clé;";
		
	} // Fin de fournirEnTeteCsvRGImplementees().__________________________
	
	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringListeCsvRGImplementees() {
		
		/* retourne null si this.listeRGImplementees == null. */
		if (this.listeRGImplementees == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		/* Instanciation d'un Comparator. */
		final ComparatorLigneRG comparatorLigneRG 
			= new ComparatorLigneRG();
		
		/* Tri de la liste. */
		Collections.sort(this.listeRGImplementees, comparatorLigneRG);
		
		for (final LigneRG ligneRGCsv : this.listeRGImplementees) {
			stb.append(ligneRGCsv.toStringCsv());
			stb.append('\n');
		}
				
		return stb.toString();
		
	} // Fin de fournirStringListeCsvRGImplementees()._____________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringListeCsvRGImplementeesAvecEntete() {
		
		/* retourne null si . */
		if (this.listeRGImplementees == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		stb.append(this.fournirEnTeteCsvRGImplementees());
		stb.append(SAUT_LIGNE);
		stb.append(this.fournirStringListeCsvRGImplementees());
		
		return stb.toString();
		
	} // Fin de fournirStringListeCsvRGImplementeesAvecEntete().___________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, String> fournirMapErreursAttribut(
			final String pAttribut) {
		
		/* retourne null si pAttribut == null. */
		if (pAttribut == null) {
			return null;
		}
		
		/* retourne null si this.erreurs == null. */
		if (this.erreurs == null) {
			return null;
		}
		
		return this.erreurs.get(pAttribut);
		
	} // Fin de fournirMapErreursAttribut(...).____________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringErreursAttribut(
			final String pAttribut
				, final String pSautLigne) {
		
		/* retourne null si pAttribut == null. */
		if (pAttribut == null) {
			return null;
		}
		
		/* retourne null si this.erreurs == null. */
		if (this.erreurs == null) {
			return null;
		}
		
		final Map<String, String> mapErr 
			= this.fournirMapErreursAttribut(pAttribut);
		
		final Collection<String> collErr 
			= this.fournirListeMessagesErreurs(mapErr);
		
		final String resultat 
			= this.fournirStringMessagesErreur(collErr, pSautLigne);
		
		return resultat;
		
	} // Fin de fournirStringErreursAttribut(...)._________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection<String> fournirListeMessagesErreurs(
			final Map<String, String> pMap) {
		
		/* retourne null si pMap == null. */
		if (pMap == null) {
			return null;
		}
		
		final Collection<String> collMessages = pMap.values();
		
		/* Tri de la Collection. */
		final List<String> listMessages 
			= new ArrayList<String>(collMessages);
		
		Collections.sort(listMessages);
		
		return listMessages;
		
	} // Fin de fournirListeMessagesErreurs(...).__________________________
	
	
	
	/**
	 * method fournirStringMessagesErreur(
	 * Collection&lt;String&gt; pStrings
	 * , String pSautLigne) :<br/>
	 * Retourne les messages contenus dans 
	 * la Collection&lt;String&gt; pStrings sous forme 
	 * d'une unique String incorporant des sauts de ligne ("\n" ou "br").<br/>
	 * <br/>
	 * retourne null si pStrings == null.<br/>
	 * <br/>
	 *
	 * @param pStrings : Collection&lt;String&gt;.<br/>
	 * @param pSautLigne : String : "\n" ou "br".<br/>
	 * 
	 * @return : String : Messages d'erreur sous forme de String.<br/>
	 */
	private String fournirStringMessagesErreur(
			final Collection<String> pStrings
				, final String pSautLigne) {
		
		/* retourne null si pStrings == null. */
		if (pStrings == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		final Iterator<String> ite = pStrings.iterator();
		
		final int tailleCollection = pStrings.size();
		int compteur = 0;
		
		while (ite.hasNext()) {
			
			compteur++;
			final String messageErreur = ite.next();
			stb.append(messageErreur);
			
			if (compteur < tailleCollection) {
				stb.append(pSautLigne);
			}
		}
		
		return stb.toString();
		
	} // Fin de fournirStringMessagesErreur(...).__________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherErreurs() {
		
		final StringBuilder stb = new StringBuilder();
		
		/* Tri de la Map*/
		final SortedMap<String, Map<String, String>> mapTriee 
			= new TreeMap<String, Map<String, String>>(this.erreurs);
		
		final Set<Entry<String, Map<String, String>>> entrySet 
			= mapTriee.entrySet();
		
		final Iterator<Entry<String, Map<String, String>>> ite 
			= entrySet.iterator();
		
		final int tailleGenerale = mapTriee.size();
		int compteurGeneral = 0;
		
		while (ite.hasNext()) {
			
			compteurGeneral++;
			
			final Entry<String, Map<String, String>> entry = ite.next();
			
			final String nomAttribut = entry.getKey();
			
			final Map<String, String> erreurAttr = entry.getValue();
			
			final int tailleMap = erreurAttr.size();
			
			/* Tri de la Map. */
			final SortedMap<String, String> erreurAttrTrie 
				= new TreeMap<String, String>(erreurAttr);
			
			final Set<Entry<String, String>> entrySet1 
				= erreurAttrTrie.entrySet();
			
			final Iterator<Entry<String, String>> ite1 
				= entrySet1.iterator();
			
			int compteur = 0;
			
			while (ite1.hasNext()) {
				
				compteur++;
				
				final Entry<String, String> entry1 = ite1.next();
				
				final String nomRG = entry1.getKey();
				final String messageErr = entry1.getValue();
				
				stb.append(nomAttribut);
				stb.append(POINT_VIRGULE);
				stb.append(nomRG);
				stb.append(POINT_VIRGULE);
				stb.append(messageErr);
				stb.append(POINT_VIRGULE);
				
				if (compteur < tailleMap) {
					stb.append(SAUT_LIGNE);
				}				
			}
			
			if (compteurGeneral < tailleGenerale) {
				stb.append(SAUT_LIGNE);
			}
			
		}
		
		return stb.toString();
		
	} // Fin de afficherErreurs()._________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, LigneRapportValidation> 
				fournirMapControlesAttribut(
							final String pAttribut) {
		
		/* retourne null si pAttribut == null. */
		if (pAttribut == null) {
			return null;
		}
		
		/* retourne null si this.controles == null. */
		if (this.controles == null) {
			return null;
		}
		
		return this.controles.get(pAttribut);
		
	} // Fin de fournirMapControlesAttribut(...).__________________________

	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String fournirStringControlesAttribut(
			final String pAttribut
				, final String pSautLigne) {
		
		/* retourne null si pAttribut == null. */
		if (pAttribut == null) {
			return null;
		}
		
		/* retourne null si this.controles == null. */
		if (this.controles == null) {
			return null;
		}
		
		final Map<String, LigneRapportValidation> mapControlesAttr 
			= this.fournirMapControlesAttribut(pAttribut);
		
		final Collection<LigneRapportValidation> collectionControles 
			= this.fournirListeMessagesControles(mapControlesAttr);
		
		final String resultat 
		= this.fournirStringMessagesControle(
				collectionControles, pSautLigne);
		
		return resultat;
		
	} // Fin de fournirStringControlesAttribut(...)._______________________

	
		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Collection<LigneRapportValidation> 
			fournirListeMessagesControles(
					final Map<String, LigneRapportValidation> pMap) {
		
		/* retourne null si pMap == null. */
		if (pMap == null) {
			return null;
		}
		
		final Collection<LigneRapportValidation> collectionLignes 
			= pMap.values();
		
		/* Tri d'une Collection. */
		final List<LigneRapportValidation> listLignes 
			= new ArrayList<LigneRapportValidation>(collectionLignes);
		
		Collections.sort(listLignes);
		
		return listLignes;
		
	} // Fin de fournirListeMessagesControles(...).________________________
	

	
	/**
	 * method fournirStringMessagesControle(
	 * Collection&lt;LigneRapportValidation&gt; pLignesRapport
	 * , String pSautLigne) :<br/>
	 * <ul>
	 * <li>Retourne les messages de contrôle contenus dans 
	 * la Collection&lt;LigneRapportValidation&gt; pLignesRapport 
	 * sous forme d'une unique String incorporant des sauts de ligne 
	 * ("\n" ou "br").</li>
	 * <li>Retourne nomRG;Résultat du contrôle;message du contrôle;</li>
	 * </ul>
	 * retourne null si pLignesRapport == null.<br/>
	 * <br/>
	 *
	 * @param pLignesRapport : Collection&lt;LigneRapportValidation&gt;.<br/>
	 * @param pSautLigne : String : "\n" ou "br".<br/>
	 * 
	 * @return : String : Messages de contrôle sous forme de String.<br/>
	 */
	private String fournirStringMessagesControle(
			final Collection<LigneRapportValidation> pLignesRapport
				, final String pSautLigne) {
		
		/* retourne null si pLignesRapport == null. */
		if (pLignesRapport == null) {
			return null;
		}
		
		final StringBuilder stb = new StringBuilder();
		
		final Iterator<LigneRapportValidation> ite 
			= pLignesRapport.iterator();
		
		final int tailleCollection = pLignesRapport.size();
		int compteur = 0;
		
		while (ite.hasNext()) {
			
			compteur++;
			final LigneRapportValidation ligneRapport = ite.next();
			
			final String nomRG = ligneRapport.getNomRG();
			final String resultat = ligneRapport.getResultatValidationRG();
			final String messageControle 
				= ligneRapport.getMessageErreurValidation();
			
			stb.append(nomRG);
			stb.append(POINT_VIRGULE);
			stb.append(resultat);
			stb.append(POINT_VIRGULE);
			stb.append(messageControle);
			stb.append(POINT_VIRGULE);
			
			if (compteur < tailleCollection) {
				stb.append(pSautLigne);
			}
		}
		
		return stb.toString();
		
	} // Fin de fournirStringMessagesControle(...).________________________
	

		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String afficherControles() {
		
		final StringBuilder stb = new StringBuilder();
		
		/* Tri de la Map*/
		final SortedMap<String, Map<String, LigneRapportValidation>> mapTriee 
		= new TreeMap<String, Map<String, LigneRapportValidation>>(this.controles);
		
		final Set<Entry<String, Map<String, LigneRapportValidation>>> entrySet 
			= mapTriee.entrySet();
		
		final Iterator<Entry<String, Map<String, LigneRapportValidation>>> ite 
			= entrySet.iterator();
				
		while (ite.hasNext()) {
			
			final Entry<String, Map<String, LigneRapportValidation>> entry 
				= ite.next();
			
			final String nomAttribut = entry.getKey();
			
			final Map<String, LigneRapportValidation> controleAttr 
				= entry.getValue();
			
			/* Tri de la Map. */
			final SortedMap<String, LigneRapportValidation> controleAttrTrie 
			= new TreeMap<String, LigneRapportValidation>(controleAttr);
			
			final Set<Entry<String, LigneRapportValidation>> entrySet1 
				= controleAttrTrie.entrySet();
			
			final Iterator<Entry<String, LigneRapportValidation>> ite1 
				= entrySet1.iterator();
			
			while (ite1.hasNext()) {
				
				final Entry<String, LigneRapportValidation> entry1 
					= ite1.next();
				
				final String nomRG = entry1.getKey();
				final LigneRapportValidation messageContr 
					= entry1.getValue();
				
				stb.append(nomAttribut);
				stb.append(POINT_VIRGULE);
				stb.append(nomRG);
				stb.append(POINT_VIRGULE);
				
				if (messageContr != null) {
					
					stb.append(messageContr.getResultatValidationRG());
					stb.append(POINT_VIRGULE);
					stb.append(messageContr.getMessageErreurValidation());
					stb.append(POINT_VIRGULE);
					
				}
				
				stb.append(SAUT_LIGNE);
			}
			
		}
		
		return stb.toString();
		
	} // Fin de afficherControles()._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<LigneRG> getListeRGImplementees() {
		return this.listeRGImplementees;
	} // Fin de getListeRGImplementees().__________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, Map<String, String>> getErreurs() {
		return this.erreurs;
	} // Fin de getErreurs().______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Map<String, Map<String, LigneRapportValidation>> getControles() {
		return this.controles;
	} // Fin de getControles().____________________________________________


		
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<LigneRapportValidation> getControlesList() {
		return this.controlesList;
	} // Fin de getControlesList().________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Boolean getValide() {
		
		this.valide = this.determinerSiControleValide();
		
		return this.valide;
		
	} // Fin de getValide()._______________________________________________


	
} // FIN DE LA CLASSE AbstractValideurGeneric.-------------------------------
