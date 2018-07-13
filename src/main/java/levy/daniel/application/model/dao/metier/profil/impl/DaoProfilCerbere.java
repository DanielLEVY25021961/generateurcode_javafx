package levy.daniel.application.model.dao.metier.profil.impl;

import java.util.List;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.dao.metier.profil.AbstractDaoProfil;
import levy.daniel.application.model.metier.profil.IProfil;
import levy.daniel.application.model.metier.profil.impl.ProfilCerbere;



/**
 * CLASSE CONCRETE <b>DaoProfilCerbere</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT 
 * CONCERNE PAR CE DAO</span>
 * </p>
 * <p>
 * <b>ProfilCerbere</b> modélise un un <i>concept</i> 
 * de <b>Profil</b> avec ********
 * <b>*****</b>  qui identifie <i>une ou plusieurs</i> <b>****</b>.<br/>
 * </p>
 * 
 * <p>
 * <span style="text-decoration: underline;">DESCRIPTION DE 
 * DaoProfilCerbere</span>
 * </p>
 * <ul>
 * <li>DAO <b>CONCRET</b> pour les <b>ProfilCerbere</b>.</li>
 * <li>
 * HERITE DU DAO ABSTRAIT AbstractDaoProfil.
 * </li>
 * <li>
 * Certaines méthodes (getOne(ID), ...) sont 
 * <b>compatibles SPRING DATA</b>.
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">IMPLEMENTATION DES DaoProfilCerbere</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/implementation_DAO_Profil.png" 
 * alt="implémentation des DAOs Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">UTILISATION DES DaoProfilCerbere</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../../../javadoc/images/utilisation_DaoProfilCerbere.png" 
 * alt="utilisation des DAOs DaoProfilCerbere" border="1" align="center" />
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
 * @since 01 mars 2018
 *
 */
@Repository(value="DaoProfilCerbere")
public class DaoProfilCerbere extends AbstractDaoProfil {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_DAO_PROFIL_CERBERE : String :<br/>
	 * "Classe DaoProfilCerbere".<br/>
	 */
	public static final String CLASSE_DAO_PROFIL_CERBERE 
		= "Classe DaoProfilCerbere";


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(DaoProfilCerbere.class);


	// *************************METHODES************************************/


	/**
	 * method CONSTRUCTEUR DaoProfilCerbere() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public DaoProfilCerbere() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * {@inheritDoc}
	 * <br/>
	 * REDEFINI DANS LA CLASSE CONCRETE EN REMPLACANT 
	 * T PAR LA CLASSE CONCRETE.<br/>
	 * <br/>
	 */
	@Override
	public IProfil findById(
			final Long pId) throws AbstractDaoException {

		ProfilCerbere objetTrouve = null;

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
				= this.entityManager.find(ProfilCerbere.class, pId);

		}
		catch (Exception e) {

			/* Gestion de la DAO Exception. */
			this.gestionnaireException
				.gererException(
						CLASSE_DAO_PROFIL_CERBERE
						, "Méthode findById(ID)", e);

		}

		return objetTrouve;

	} // Fin de findById(...)._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IProfil> findAllSousClasse() 
							throws AbstractDaoException {
		return this.findAllProfilCerbere();
	} // Fin de findAllSousClasse()._______________________________________



	/**
	 * method findAllProfilCerbere() :<br/>
	 * <ul>
	 * <li>Retourne la liste de tous les objets métier 
	 * de Type ProfilCerbere présents en base sous forme 
	 * de List&lt;IProfil&gt;.</li>
	 * </ul>
	 *
	 * @return List&lt;IProfil&gt; : 
	 * liste de tous les objets métier de Type <b>ProfilCerbere</b> 
	 * présents en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private List<IProfil> findAllProfilCerbere() 
			throws AbstractDaoException {

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
			= "from ProfilCerbere";

		List<IProfil> resultat = null;

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
						CLASSE_DAO_PROFIL_CERBERE
						, "Méthode findAllProfilCerbere()", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllProfilCerbere().________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final List<IProfil> findAllMaxSousClasse(
			final Long pMax) throws AbstractDaoException {
		return this.findAllMaxProfilCerbere(pMax);
	} // Fin de findAllMaxSousClasse(...)._________________________________



	/**
	 * method findAllMaxProfilCerbere(
	 * Long pMax) :<br/>
	 * <ul>
	 * <li>Retourne sous forme de List&lt;IProfil&gt; 
	 * la liste des pMax premiers Objets métier 
	 * de Type <b>ProfilCerbere</b> présents en base 
	 * et retournés par findAllProfilCerbere().</li>
	 * <li>Le champ de tri des Objets métier semble être l'ID.</li>
	 * </ul>
	 * retourne null si pMax == null.<br/>
	 * retourne null si pMax < 1L.<br/>
	 * <br/>
	 * 
	 * @param pMax : Long : Nombre maximal d'objets métier 
	 * à remonter de la base.<br/>
	 * 
	 * @return List&lt;IProfil&gt; :
	 * liste des pMax premiers objets métier 
	 * de Type <b>ProfilCerbere</b> présents en base.<br/>
	 *  
	 * @throws AbstractDaoException
	 */
	private List<IProfil> findAllMaxProfilCerbere(
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
			= "from ProfilCerbere";

		List<IProfil> resultat = null;

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
				.gererException(CLASSE_DAO_PROFIL_CERBERE
						, "Méthode findAllMaxProfilCerbere(Long pMax)", e);

		}

		/* Retourne la liste résultat. */
		return resultat;

	} // Fin de findAllMaxProfilCerbere(...).__________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void deleteAllSousClasse() 
					throws AbstractDaoException {
		this.deleteAllProfilCerbere();
	} // Fin de deleteAllSousClasse()._____________________________________



	/**
	 * method deleteAllProfilCerbere() :<br/>
	 * <ul>
	 * <li>Détruit en base toutes les instances 
	 * d'Objets métier de Type <b>ProfilCerbere</b>.</li>
	 * </ul>
	 *
	 * @throws AbstractDaoException
	 */
	private void deleteAllProfilCerbere() 
							throws AbstractDaoException {

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
			= "delete from ProfilCerbere";

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
						CLASSE_DAO_PROFIL_CERBERE
						, "Méthode deleteAllProfilCerbere()", e);

		}

	} // Fin de deleteAllProfilCerbere().______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean deleteAllBooleanSousClasse() 
								throws AbstractDaoException {
		return this.deleteAllBooleanProfilCerbere();
	} // Fin de deleteAllBooleanSousClasse().______________________________



	/**
	 * method deleteAllBooleanProfilCerbere() :<br/>
	 * <ul>
	 * <li>Détruit en base tous les enregistrements 
	 * d'Objets métier de Type <b>ProfilCerbere</b>.</li>
	 * <li>Retourne true si la destruction a bien été effectuée.</li>
	 * </ul>
	 * 
	 * @return boolean : true si tous les enregistrements 
	 * ont été détruits en base.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	private boolean deleteAllBooleanProfilCerbere() 
									throws AbstractDaoException {

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
			= "delete from ProfilCerbere";

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
						CLASSE_DAO_PROFIL_CERBERE
						, "Méthode deleteAllBooleanProfilCerbere()", e);

		}

		return resultat;

	} // Fin de deleteAllBooleanProfilCerbere()._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Long countSousClasse() 
						throws AbstractDaoException {
		return this.countProfilCerbere();
	} // Fin de countSousClasse()._________________________________________



	/**
	 * method countProfilCerbere() :<br/>
	 * <ul>
	 * <li>Retourne le nombre d'Objets metier 
	 * de type <b>ProfilCerbere</b> présents en base.</li>
	 * </ul>
	 *
	 * @return : Long : 
	 * le nombre d'Objets metier de type <b>ProfilCerbere</b> 
	 * présents en base.<br/>
	 *
	 * @throws AbstractDaoException
	 */
	private Long countProfilCerbere() 
						throws AbstractDaoException {

		/* Récupère la liste d'Objets métier de Type ProfilCerbere. */
		final List<IProfil> listObjects 
			= this.findAllProfilCerbere();

		if (listObjects != null) {

			/* Retourne la taille de la liste. */
			return Long.valueOf(listObjects.size()) ;
		}

		return 0L;

	} // Fin de countProfilCerbere().__________________________________



} // FIN DE LA CLASSE DaoProfilCerbere.--------------------------------------