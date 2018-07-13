package levy.daniel.application.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.daoexceptions.GestionnaireDaoException;




/**
 * CLASSE ABSTRAITE <b>AbstractDaoGenericJPASpring</b> :<br/>
 * <ul>
 * <li><b>DAO ABSTRAIT GENERIQUE</b> pour SPRING utilisant JPA.</li>
 * <li>
 * Comporte l'implémentation des méthodes <b>CRUD</b> valables 
 * pour <b>tous les objets métier</b>.
 * </li>
 * <li>l'attribut JPA <b>EntityManager</b> est injecté par SPRING. 
 * Il comporte l'annotation SPRING <b>"PersistenceContext"</b>.</li>
 * <li>Les transactions sont gérées par le conteneur SPRING.</li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../javadoc/images/implementation_dao_usersimple.png" 
 * alt="implémentation des DAOs" border="1" align="center" />
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
 * 
 * @param <T> : Type paramétré : Classe réelle d'un Objet métier.<br/>
 * @param <ID> : Type paramétré : type de l'ID en base d'un Objet métier 
 * (Long, Integer, String, ...).<br/>
 *  
 * @since 8 sept. 2017
 *
 */
public abstract class AbstractDaoGenericJPASpring<T, ID extends Serializable> 
											implements IDaoGenericJPASpring<T, ID> {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING : String :<br/>
	 * "Classe AbstractDaoGenericJPASpring".<br/>
	 */
	public static final String CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING 
		= "Classe AbstractDaoGenericJPASpring";


	/**
	 * METHODE_CREATE : String :<br/>
	 * "Méthode create(T pObject)".<br/>
	 */
	public static final String  METHODE_CREATE 
		= "Méthode create(T pObject)";


	/**
	 * entityManager : javax.persistence.EntityManager :<br/>
	 * JPA EntityManager fourni par SPRING.<br/>
	 */
	@PersistenceContext
	protected transient EntityManager entityManager;


	/**
	 * classObjetMetier : Class&lt;T&gt; :<br/>
	 * Class (.Class Reflexion = Introspection) réelle 
	 * de l'Objet métier de Type paramétré T 
	 * concerné par le présent DAO.<br/>
	 */
	protected transient Class<T> classObjetMetier;


	/**
	 * gestionnaireException : GestionnaireDaoException :<br/>
	 * Gestionnaire pour les Exceptions de DAO.<br/>
	 */
	protected transient GestionnaireDaoException gestionnaireException 
		= new GestionnaireDaoException();


	/**
	 * MESSAGE_ENTITYMANAGER_NULL : String :<br/>
	 * "this.entityManager est NULL dans AbstractDaoGenericJPASpring".<br/>
	 */
	public static final String MESSAGE_ENTITYMANAGER_NULL 
	= "this.entityManager est NULL dans AbstractDaoGenericJPASpring";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(AbstractDaoGenericJPASpring.class);



	// *************************METHODES************************************/


	 /**
	 * method CONSTRUCTEUR AbstractDaoGeneric() :<br/>
	 * <ul>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <li>renseigne this.classObjetMetier (.class de l'objet métier 
	 * concerné par le présent DAO).</li>
	 * <li>Lance la persistence.</li>
	 * <ul>
	 * <li>Récupère la session Hibernate auprès de HibernateUtilNG.</li>
	 * <li>Récupère la Factory auprès de la Session.</li>
	 * <li>Récupère l'EntityManager auprès de la Factory.</li>
	 * </ul>
	 * </ul>
	 */
	public AbstractDaoGenericJPASpring() {

		super();

		/* renseigne this.classObjetMetier. */
		this.renseignerClassObjetMetier();

	} // Fin de  CONSTRUCTEUR D'ARITE NULLE._______________________________





	/* CREATE ************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final T create(
			final T pObject) throws AbstractDaoException {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		T persistentObject = null;

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		try {

			/* ***************** */
			/* PERSISTE en base. */
			this.entityManager.persist(pObject);

			persistentObject = pObject;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
							, METHODE_CREATE, e);

		}

		/* retourne l'Objet persistant. */
		return persistentObject;

	} // Fin de create(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final <S extends T> S save(
			final S pObject) throws AbstractDaoException {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		S persistentObject = null;

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		try {

			/* PERSISTE en base. */
			this.entityManager.persist(pObject);

			persistentObject = pObject;

		} 
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
							, "Méthode save(S pObject)", e);

		}

		/* retourne l'Objet persistant. */
		return persistentObject;

	} // Fin de save(...)._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void persist(
			final T pObject) throws AbstractDaoException {

		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* ne fait rien si pObject est un doublon. */
		if (this.exists(pObject)) {
			return;
		}


		try {

			/* PERSISTE en base. */
			this.entityManager.persist(pObject);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
							, "Méthode persist(T Object)", e);

		}

	} // Fin de persist(...).______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final <S extends T> void persistSousClasse(
			final S pObject) throws AbstractDaoException {

		/* ne fait rien si pObject == null. */
		if (pObject == null) {
			return;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}

		/* ne fait rien si pObject est un doublon. */
		if (this.exists(pObject)) {
			return;
		}

		try {

			/* PERSISTE en base. */
			this.entityManager.persist(pObject);

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode persistSousClasse(S pObject)", e);

		}

	} // Fin de persistSousClasse(...).____________________________________



	/**
	 * {@inheritDoc}
	 * Méthode à implémenter dans une sous-classe dès 
	 * que l'on connait le Type réel de pObject.<br/>
	 * <br/>
	 */
	@Override
	public abstract ID createReturnId(T pObject) 
			throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final <S extends T> Iterable<S> save(
			final Iterable<S> pObjects) 
			throws AbstractDaoException {

		/* retourne null si pObjects == null. */
		if (pObjects == null) {
			return null;
		}


		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		final List<S> resultat = new ArrayList<S>();

		final Iterator<S> iteS = pObjects.iterator();

		try {

			while (iteS.hasNext()) {

				final S objet = iteS.next();

				/* Passe les doublons existants en base. */
				if (!this.exists(objet)) {

					/* passe un null dans le lot. */
					if (objet != null) {

						S objetPersistant = null;

						try {

							/* PERSISTE en base. */
							this.entityManager.persist(objet);

							objetPersistant = objet;

						} catch (Exception e) {

							/* LOG. */
							if (LOG.isDebugEnabled()) {
								LOG.debug(e.getMessage(), e);
							}

							/* Gestion de la DAO Exception. */
							this.gestionnaireException
								.gererException(
										CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
											, "Méthode save(Iterable)", e);
						}


						/* ne sauvegarde pas un doublon 
						 * présent dans le lot. */
						if (objetPersistant != null) {

							/* Ajoute à l'iterable resultat. */
							resultat.add(objetPersistant);								
						}						
					}					
				}				
			} // Next._____________________________________

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
							, "Méthode save(Iterable)", e);

		}

		/* retourne l'iterable resultat. */
		return resultat;

	} // Fin de save(...)._________________________________________________



	/* READ *************/



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract T retrieve(T pObject) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public T findById(
			final ID pId) throws AbstractDaoException {

		T objetTrouve = null;

		/* retourne null si pId == null. */
		if (pId == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		try {

			objetTrouve 
				= this.entityManager.find(this.classObjetMetier, pId);

		}
		catch (Exception e) {

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode findById(ID)", e);

		}

		return objetTrouve;

	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final T getOne(
			final ID pId) throws AbstractDaoException {

		return this.findById(pId);

	} // Fin de getOne(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from " + this.classObjetMetier.getName();

		List<T> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode findall()", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAll()._________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<T> findAllMax(
			final Long pMax) throws AbstractDaoException {

		/* retourne null si pMax == null. */
		if (pMax == null) {
			return null;
		}

		/* retourne null si pMax < 1L. */
		if (pMax < 1L) {
			return null;
		}


		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "from " + this.classObjetMetier.getName();

		List<T> resultat = null;

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString)
					.setFirstResult(0).setMaxResults(pMax.intValue());

			/* Exécute la javax.persistence.Query. */
			resultat = query.getResultList();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode findAllMax()", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllMax(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Iterable<T> findAll(
			final Iterable<ID> pIds) throws AbstractDaoException {

		/* retourne null si pIds == null. */
		if (pIds == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		}

		final List<T> resultat = new ArrayList<T>();		

		final Iterator<ID> iteratorID = pIds.iterator();

		while (iteratorID.hasNext()) {

			final ID id = iteratorID.next();
			/* Recherche en base sur ID. */
			final T objetEnBase = this.findById(id);

			if (objetEnBase != null) {
				resultat.add(objetEnBase);
			}			
		}

		return resultat;

	} // Fin de findAll(...).______________________________________________



	/* UPDATE *************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final T update(
			final T pObject) throws AbstractDaoException {

		/* retourne null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return null;
		} // Fin de this.entityManager == null.____________


		/* retourne pObject si l'objet n'est pas 
		 * déjà persistant en base. */
		if (!this.exists(pObject)) {
			return pObject;
		}

		T persistentObject = null;

		try {

			/* MODIFIE en base. */
			this.entityManager.merge(pObject);

			persistentObject = pObject;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode update(T Object)", e);

		}

		/* retourne l'Objet persistant modifié. */
		return persistentObject;

	} // Fin de update(...)._______________________________________________



	/* DELETE *************/


	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean delete(
			final T pObject) throws AbstractDaoException {

		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}

		boolean resultat = false;

		/* Vérifie qu'il existe une instance persistante. */
		final T persistanceInstance = this.retrieve(pObject);

		try {

			if (persistanceInstance != null) {

				/* merge avant de pouvoir détruire. */
				this.entityManager.merge(persistanceInstance);

				/* DESTRUCTION. */
				this.entityManager.remove(persistanceInstance);

				resultat = true;

			}
			else {
				resultat = false;
			}

		} catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode delete(T pObject)", e);

		}

		return resultat;

	} // Fin de delete(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void deleteById(ID pId) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean deleteByIdBoolean(ID pId) 
			throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAll() throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return;
		}


		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from " + this.classObjetMetier.getName();

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode deleteAll()", e);

		}

	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBoolean() throws AbstractDaoException {

		/* Cas où this.entityManager == null. */
		if (this.entityManager == null) {

			/* LOG. */
			if (LOG.isFatalEnabled()) {
				LOG.fatal(MESSAGE_ENTITYMANAGER_NULL);
			}
			return false;
		}


		boolean resultat = false;

		/* Création de la requête HQL sous forme de String. */
		final String requeteString 
			= "delete from " + this.classObjetMetier.getName();

		try {

			/* Crée la requête javax.persistence.Query. */
			final Query query 
				= this.entityManager.createQuery(requeteString);

			/* EXECUTION DE LA REQUETE. */
			query.executeUpdate();

			resultat = true;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
						, "Méthode deleteAllBoolean()", e);

		}

		return resultat;

	} // Fin de deleteAll()._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void delete(
			final Iterable<? extends T> pObjects) 
						throws AbstractDaoException {

		/* ne fait rien si pObjects == null. */
		if (pObjects == null) {
			return;
		}

		final Iterator<? extends T> itePersistants = pObjects.iterator();
		final List<T> listePersistants 
			= new ArrayList<T>();

		/* Récupération préalable des objets persistans en base. */
		while (itePersistants.hasNext()) {
			final T objet = itePersistants.next();
			final T objetPersistant = this.retrieve(objet);

			if (objetPersistant != null) {
				listePersistants.add(objetPersistant);
			}
		}


		/* Itération uniquement sur la liste des Objets persistants. */
		final Iterator<? extends T> ite = listePersistants.iterator();

		try {

			while (ite.hasNext()) {

				final T objectPersistant = ite.next();

				/* DESTRUCTION. */
				this.entityManager.remove(objectPersistant);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException.gererException(
					CLASSE_ABSTRACTDAOGENERIC_JPA_SPRING
					, "Méthode delete(Iterable)", e);

		}

	} // Fin de delete(...)._______________________________________________



	/* TOOLS *************/

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean exists(T pObject) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract boolean exists(ID pId) throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long count() throws AbstractDaoException {

		/* Récupère la liste d'Objets métier de Type paramétré T. */
		final List<T> listObjects = this.findAll();

		if (listObjects != null) {

			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}

		return 0L;

	} // Fin de count().___________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Class<T> getClassObjetMetier() {
		return this.classObjetMetier;
	} // Fin de getClassObjetMetier()._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setClassObjetMetier(
			final Class<T> pClassObjetMetier) {
		this.classObjetMetier = pClassObjetMetier;
	} // Fin de setClassObjetMetier(...).__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract String afficherListe(List<T> pListe);



	/**
	 * method renseignerClassObjetMetier() :<br/>
	 * <ul>
	 * <li>Impose aux DAO <i>descendants</i> de <b>renseigner le .class</b> 
	 * de l'<b>objet métier</b> concerné par le présent DAO 
	 * (this.classObjetMetier).</li>
	 * <li><b>automatiquement appelé</b> dans le constructeur 
	 * AbstractDaoGenericJPASpring().</li>
	 * <li>Par exemple : Book.class ou IUserSimple.class.</li>
	 * </ul>
	 */
	protected abstract void renseignerClassObjetMetier();



} // FIN DE LA CLASSE AbstractDaoGenericJPASpring.---------------------------
