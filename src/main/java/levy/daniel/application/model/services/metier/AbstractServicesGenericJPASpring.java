package levy.daniel.application.model.services.metier;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;
import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.services.valideurs.IValideurGeneric;
import levy.daniel.application.model.services.valideurs.LigneRapportValidation;

/**
 * CLASSE ABSTRAITE <b<AbstractServicesGenericJPASpring</b> :<br/>
 * <ul>
 * <li><b>SERVICE ABSTRAIT GENERIQUE</b> pour <b>SPRING AVEC JPA</b>.</li>
 * <li>
 * Comporte l'implémentation des méthodes <b>CRUD</b> valables 
 * pour <b>tous les objets métier</b>.
 * </li>
 * <li>Les transactions sont gérées par le conteneur SPRING.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../javadoc/images/implementation_SERVICEs_1.png" 
 * alt="implémentation des SERVICEs" border="1" align="center" />
 * </li>
 * </ul>
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
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @param <ID> : Type paramétré : type de l'ID en base d'un Objet métier 
 * (Long, Integer, String, ...).<br/>
 * @since 26 août 2017
 *
 */
public abstract class AbstractServicesGenericJPASpring<T, ID extends Serializable> 
					implements IServicesGenericJPASpring<T, ID> {

	
	// ************************ATTRIBUTS************************************/

	
	/**
	 * CLASS_ABSTRACT_SERVICE_GENERIC : String :<br/>
	 * "Classe AbstractServicesGenericJPASpring".<br/>
	 */
	public static final String CLASS_ABSTRACT_SERVICE_GENERIC 
		= "Classe AbstractServicesGenericJPASpring";

	
	/**
	 * METHODE_CREATE : String :<br/>
	 * "Méthode create(T pObject)".<br/>
	 */
	public static final String METHODE_CREATE 
		= "Méthode create(T pObject)";
	
	
	/**
	 * SEPARATEUR_MOINS_AERE : String :<br/>
	 * " - ".<br/>
	 */
	public static final String SEPARATEUR_MOINS_AERE = " - ";
	

	
	
	/**
	 * dao : IDaoGenericJPASpring&lt;T ,ID&gt; :<br/>
	 * DAO pour le service.<br/>
	 */
	protected IDaoGenericJPASpring<T, ID> dao;
	
		
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
	 * objetMetier : T :<br/>
	 * Objet métier géré par le présent service.<br/>
	 */
	protected transient T objetMetier;
	
		
	/**
	 * classObjetMetier : Class&lt;T&gt; :<br/>
	 * Class (.Class Reflexion = Introspection) réelle 
	 * de l'Objet métier de Type paramétré T 
	 * concerné par le présent Service.<br/>
	 */
	protected transient Class<T> classObjetMetier;



	
	/**
	 * valideur : IValideurGeneric<T> :<br/>
	 * Valideur dédié à la validation de l'objet métier 
	 * de type paramétré T traité par ce service.<br/>
	 */
	protected transient IValideurGeneric<T> valideur;
	
	
		
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
	 * POINT_VIRGULE : char :<br/>
	 * ';'.<br/>
	 */
	public static final char POINT_VIRGULE = ';';

	
	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractServicesGenericJPASpring.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * method CONSTRUCTEUR AbstractServicesGenericJPASpring() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public AbstractServicesGenericJPASpring() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________
	

	
	 /**
	 * method CONSTRUCTEUR AbstractServiceGenericSpring(
	 * IDaoGenericJPASpring&lt;T, ID&gt; pDao) :<br/>
	 * CONSTRUCTEUR AVEC DAO.<br/>
	 * <br/>
	 *
	 * @param pDao : IDaoGenericJPASpring&lt;T, ID&gt; pDao.<br/>
	 */
	public AbstractServicesGenericJPASpring(
			final IDaoGenericJPASpring<T, ID> pDao) {
		
		super();
		
		this.dao = pDao;
		
	} // Fin de CONSTRUCTEUR AVEC DAO._____________________________________
	

	
	
	/* CREATE ************/


	/**
	 * {@inheritDoc}
	 */
	@Transactional(propagation = Propagation.REQUIRED
			, readOnly = false)
	@Override
	public T create(
			final T pObject) {
		
		try {
			
			if (this.dao != null) {
				return this.dao.create(pObject);
			}

			if (LOG.isFatalEnabled()) {
				LOG.fatal("DAO null");
			}
			
			
		}
		catch (AbstractDaoException e) {
			System.out.println(CLASS_ABSTRACT_SERVICE_GENERIC 
					+ SEPARATEUR_MOINS_AERE 
					+ METHODE_CREATE + SEPARATEUR_MOINS_AERE 
					+ "MESSAGE UTILISATEUR : " + e.getMessageUtilisateur());
		}
		
		return null;
		
	} // Fin de create(...)._______________________________________________

	


	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> S save(
			final S pObject) {
		return null;
	} // Fin de save(...)._________________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void persist(
			final T pObject) {
		return; // NOPMD by daniel.levy on 05/02/18 16:11
	} // Fin de persist(...).______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> void persistSousClasse(
			final S pObject) {
		return; // NOPMD by daniel.levy on 05/02/18 16:12
	} // Fin de persistSousClasse(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ID createReturnId(
			final T pObject) {
		
		return null;
		
	} // Fin de createReturnId(...)._______________________________________

	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <S extends T> Iterable<S> save(
			final Iterable<S> pObjects) {
		return null;
	} // Fin de save(...)._________________________________________________
	
	

	
	/* READ *************/

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T retrieve(
			final T pObject) {
		
		return null;
		
	} // Fin de retrieve(...)._____________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findById(
			final ID pId) {
		return null;
	} // Fin de findById(...)._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T getOne(
			final ID pId) {
		
		return null;
		
	} // Fin de getOne(...)._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		
		return null;
		
	} // Fin de findAll()._________________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAllMax(
			final Long pMax) {
		
		return null;
		
	} // Fin de findAllMax(...).___________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Iterable<T> findAll(
			final Iterable<ID> pIds) {
		
		return null;
		
	} // Fin de findAll(...).______________________________________________
	
	
	

	/* UPDATE *************/

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public T update(
			final T pObject) {
		
		return null;
		
	} // Fin de update(...)._______________________________________________
	
	
	

	/* DELETE *************/
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(
			final T pObject) {
		
		return false;
		
	} // Fin de delete(...)._______________________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final ID pId) {
		
		/***/
		
	} // Fin de deleteById(...).___________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final ID pId) {
		
		return false;
		
	} // Fin de deleteByIdBoolean(...).____________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteAll() {
		
		/***/
		
	} // Fin de deleteAll()._______________________________________________
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteAllBoolean() {
		return false;
	} // Fin de deleteAllBoolean().________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(
			final Iterable<? extends T> pObjects) {
		
		/****/
		
	} // Fin de delete(...)._______________________________________________

	
	
	/* TOOLS *************/


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final T pObject) {
		return false;
	} // Fin de exists(...)._______________________________________________
	

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final ID pId) {
		
		return false;
		
	} // Fin de exists(...)._______________________________________________

	
	
	/**
	 * method count() :<br/>
	 * Returns the number of entities available.<br/>
	 * <br/>
	 *
	 * @return : Long : the number of entities.<br/>
	 */
	@Override
	public Long count() {
		
		return null;
		
	} // Fin de count().___________________________________________________

	

	/* VALIDATION ************/
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Map<String, String>> validate(
			final T pObject) 
					throws MalformedURLException {
		
		this.valideur.validate(pObject);
		
		/* Remplit this.erreurs. */
		this.erreurs.putAll(this.valideur.getErreurs());
		
		/* Remplit this.Controle */
		this.controles.putAll(this.valideur.getControles());
		
		/* Remplit this.listeRGImplementees. */
		this.listeRGImplementees.addAll(
				this.valideur.getListeRGImplementees());
		
		/* Remplit this.controlesList. */
		this.controlesList.addAll(this.valideur.getControlesList());
		
		/* Remplit this.valide. */
		this.valide = this.valideur.getValide();
		
		return this.erreurs;
		
	} // Fin de validate(...)._____________________________________________
	
	
	
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
				+ "Méthode implémentant la RG;";
		
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
	public final String fournirNomObjetMetier() {
		return this.objetMetier.getClass().getSimpleName();
	} // Fin de fournirNomObjetMetier().___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String founirNomClasse();
	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IValideurGeneric<T> getValideur() {
		return this.valideur;
	} // Fin de getValideur()._____________________________________________
	

	
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
		return this.valide;
	} // Fin de getValide()._______________________________________________


	
	/**
	 * method getDao() :<br/>
	 * Getter du DAO pour le service.<br/>
	 * <br/>
	 *
	 * @return dao : 
	 * IDaoGenericJPASpring&lt;T, ID&gt;.<br/>
	 */
	public IDaoGenericJPASpring<T, ID> getDao() {	
		return this.dao;
	} // Fin de getDao().__________________________________________________


	
	/**
	* method setDao(
	* IDaoGenericJPASpring&lt;T, ID&gt; pDao) :<br/>
	* Setter du DAO pour le service.<br/>
	* <br/>
	*
	* @param pDao : IDaoGenericJPASpring&lt;T, ID&gt; : 
	* valeur à passer à dao.<br/>
	*/
	public void setDao(
			final IDaoGenericJPASpring<T, ID> pDao) {	
		this.dao = pDao;
	} // Fin de setDao(...)._______________________________________________

		
	
} // FIN DE LA CLASSE AbstractServicesGenericJPASpring.----------------------
