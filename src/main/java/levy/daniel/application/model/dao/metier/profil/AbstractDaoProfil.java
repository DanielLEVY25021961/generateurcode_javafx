package levy.daniel.application.model.dao.metier.profil;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.dao.AbstractDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.profil.IProfil;



/**
 * CLASSE ABSTRAITE <b>AbstractDaoProfil</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>IProfil</b> Modélise un <i>concept</i> de <b>Profil</b>, 
 * *********** 
 * associé de manière ***** à une <b>******</b>.
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * AbstractDaoProfil</span>
 * </p>
 * <ul>
 * <li>
 * DAO ABSTRAIT SPRING pour les <b>IProfil</b>.
 * </li>
 * <li>
 * Comporte l'implémentation des méthodes <b>spécifiques</b> aux 
 * IProfil.
 * </li>
 * <li>IMPLEMENTE L'INTERFACE IDaoProfil.</li>
 * <li>
 * HERITE DE LA CLASSE ABSTRAITE 
 * AbstractDaoGenericJPASpring&lt;IProfil, Long&gt;.
 * </li>
 * <li>
 * <b>FACTORISE</b> les attributs et comportements 
 * des <i>descendants concrets</i>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES AbstractDaoProfil</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../javadoc/images/implementation_DAO_Profil.png" 
 * alt="implémentation des DAOs Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
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
 * @since 28 février 2018
 *
 */
public abstract class AbstractDaoProfil 
		extends AbstractDaoGenericJPASpring<IProfil, Long> 
									implements IDaoProfil {


	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_ABSTRACT_DAO_PROFIL : String :<br/>
	 * "Classe AbstractDaoProfil".<br/>
	 */
	public static final String CLASSE_ABSTRACT_DAO_PROFIL 
		= "Classe AbstractDaoProfil";


	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	public static final char SAUT_LIGNE_JAVA = '\n';


	/**
	 * SELECT_OBJET : String :<br/>
	 * "select profil from 
	 * AbstractProfil as profil ".<br/>
	 */
	public static final String SELECT_OBJET 
		= "select profil from "
				+ "AbstractProfil as profil ";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(AbstractDaoProfil.class);


	// *************************METHODES************************************/


	/**
	 * method CONSTRUCTEUR AbstractDaoProfil() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public AbstractDaoProfil() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long createReturnId(
			final IProfil pObject) throws AbstractDaoException {

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
		}

		/* retourne null si pObject est un doublon. */
		if (this.exists(pObject)) {
			return null;
		}

		/* Crée l'Objet en base ou jette une AbstractDaoException. */
		final IProfil objetPersistant 
			= this.create(pObject);

		/* retourne null si l'objet pObject n'a pu être créé en base. */
		if (objetPersistant == null) {
			return null;
		}

		/* retourne l'ID de l'objet persistant. */
		return objetPersistant.getId();	

	} // Fin de createReturnId(...)._______________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public IProfil retrieve(
			final IProfil pObject) throws AbstractDaoException {

		/* return null si pObject == null. */
		if (pObject == null) {
			return null;
		}

		IProfil objetResultat = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where profil.profilString = :pProfilString and profil.porteeProfil = :pPorteeProfil;";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pProfilString", pObject.getProfilString());
		requete.setParameter("pPorteeProfil", pObject.getPorteeProfil());

		try {

			/* Execution de la requete HQL. */
			objetResultat 
				= (IProfil) requete.getSingleResult();

		}
		catch (NoResultException noResultExc) {

			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACT_DAO_PROFIL
						, "Méthode retrieve(IProfil pObject)", e);
		}

		return objetResultat;

	} // Fin de retrieve(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IProfil retrieveByIdMetier(
			final IProfil pObjet) throws AbstractDaoException {
		return this.retrieve(pObjet);	
	} // Fin de retrieveByIdMetier(...).___________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final IProfil retrieveByAttributs(
			final String pProfilString
				, final String pPorteeProfil)
					throws AbstractDaoException {

		/* return null si pProfilString est blank. */
		if (StringUtils.isBlank(pProfilString)) {
			return null;
		}

		/* return null si pPorteeProfil est blank. */
		if (StringUtils.isBlank(pPorteeProfil)) {
			return null;
		}

		IProfil objetResultat = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where profil.profilString = :pProfilString and profil.porteeProfil = :pPorteeProfil;";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pProfilString", pProfilString);
		requete.setParameter("pPorteeProfil", pPorteeProfil);

		try {

			/* Execution de la requete HQL. */
			objetResultat 
				= (IProfil) requete.getSingleResult();

		}
		catch (NoResultException noResultExc) {

			/* retourne null si l'Objet métier n'existe pas en base. */
			return null;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_ABSTRACT_DAO_PROFIL
						, "Méthode retrieveByAttributs(IProfil pObject)", e);
		}

		return objetResultat;

	} // Fin de retrieveByAttributs(...).__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract IProfil findById(Long pId) 
				throws AbstractDaoException;



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(
			final Long pId) throws AbstractDaoException {

		/* ne fait rien si pId == null. */
		if (pId == null) {
			return;
		}

		IProfil objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
		+ "where profil.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IProfil) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
		}


		try {

			if (objetPersistant != null) {

				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);

				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);

			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACT_DAO_PROFIL
						, "Méthode deleteById(Long pId)", e);
		}

	} // Fin de deleteById(...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean deleteByIdBoolean(
			final Long pId) throws AbstractDaoException {

		/* retourne false si pId == null. */
		if (pId == null) {
			return false;
		}

		boolean resultat = false;

		IProfil objetPersistant = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
		= SELECT_OBJET 
			+ "where profil.id = :pId";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pId", pId);

		try {
			/* Execution de la requete HQL. */
			objetPersistant 
			= (IProfil) requete.getSingleResult();
		}
		catch (NoResultException noResultExc) {
			objetPersistant = null;
			resultat = false;
		}

		try {

			if (objetPersistant != null) {

				/* Merge avant destruction. */
				this.entityManager.merge(objetPersistant);

				/* DESTRUCTION. */
				this.entityManager.remove(objetPersistant);

				resultat = true;
			}

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACT_DAO_PROFIL
						, "Méthode deleteByIdBoolean(Long pId)", e);
		}

		return resultat;

	} // Fin de deleteByIdBoolean(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final IProfil pObject) throws AbstractDaoException {

		/* retourne false si pObject == null. */
		if (pObject == null) {
			return false;
		}

		boolean resultat = false;		
		IProfil objetResultat = null;

		/* REQUETE HQL PARAMETREE. */
		final String requeteString 
			= SELECT_OBJET
				+ "where profil.profilString = :pProfilString and profil.porteeProfil = :pPorteeProfil;";

		/* Construction de la requête HQL. */
		final Query requete 
			= this.entityManager.createQuery(requeteString);

		/* Passage des paramètres de la requête HQL. */
		requete.setParameter("pProfilString", pObject.getProfilString());
		requete.setParameter("pPorteeProfil", pObject.getPorteeProfil());

		try {

			/* Execution de la requete HQL. */
			objetResultat 
			= (IProfil) requete.getSingleResult();

			/* retourne true si l'objet existe en base. */
			if (objetResultat != null) {
				resultat = true;
			}

		}
		catch (NoResultException noResultExc) {

			/* retourne false si l'Objet métier n'existe pas en base. */
			return false;

		}
		catch (Exception e) {

			/* LOG. */
			if (LOG.isDebugEnabled()) {
				LOG.debug(e.getMessage(), e);
			}

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(CLASSE_ABSTRACT_DAO_PROFIL
						, "Méthode exists(IProfil pObject)", e);
		}

		return resultat;

	} // Fin de exists(...)._______________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean exists(
			final Long pId) throws AbstractDaoException {

		/* retourne false si pId == null . */
		if (pId == null) {
			return false;
		}

		/* retourne true si l'objet métier existe en base. */
		if (this.findById(pId) != null) {
			return true;
		}

		return false;

	} // Fin de exists(Long...).___________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public String afficherListe(
			final List<IProfil> pListe) {

		/* retourne null si pListe == null. */
		if (pListe == null) {
			return null;
		}

		final StringBuilder stb = new StringBuilder();

		for (final IProfil objet : pListe) {
			stb.append(objet.toString());
			stb.append(SAUT_LIGNE_JAVA);
		}

		return stb.toString();			

	} // Fin de afficherListe(...).________________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * this.<b>classObjetMetier</b> dans AbstractDaoProfil : 
	 * <b>IProfil.class</b><br/>
	 * <br/>
	 */
	@Override
	protected final void renseignerClassObjetMetier() {

		this.setClassObjetMetier(IProfil.class);

	} // Fin de renseignerClassObjetMetier().______________________________



} // FIN DE LA CLASSE AbstractDaoProfil.-------------------------------------