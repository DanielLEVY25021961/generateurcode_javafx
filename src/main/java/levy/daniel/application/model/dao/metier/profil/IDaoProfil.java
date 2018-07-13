package levy.daniel.application.model.dao.metier.profil;

import levy.daniel.application.model.dao.IDaoGenericJPASpring;
import levy.daniel.application.model.dao.daoexceptions.AbstractDaoException;
import levy.daniel.application.model.metier.profil.IProfil;



/**
 * INTERFACE <b>IDaoProfil</b> :<br/>
 * <ul>
 * <li>Interface des DAOs pour les <b>Profil</b>.</li>
 * <li>
 * HERITE DE L'INTERFACE GENERIQUE 
 * IDaoGenericJPASpring&lt;T, ID extends Serializable&gt;.
 * </li>
 * <li>
 * Définit les méthodes <i>spécifiques</i> aux Profil.
 * </li>
 * <li>
 * Définit en particulier la méthode de <b>recherche 
 * par identifiant métier</b>.
 * </li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_Dao_Profil.png" 
 * alt="implémentation des DAOs des Profil" border="1" align="center" />
 * </li>
 * </ul>
 * <br/>
 * 
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
 * @since 27 février 2018
 *
 */
public interface IDaoProfil
		extends IDaoGenericJPASpring<IProfil, Long> {



	/**
	 * method retrieveByIdMetier(
	 * IProfil pObjet) :<br/>
	 * <ul>
	 * <li>Recherche un IProfil pObjet en base 
	 * via son identifiant métier.</li>
	 * <li>Retourne IProfil trouvé en base.</li>
	 * </ul> 
	 * <br/>
	 *
	 * @param pObjet : IProfil : 
	 * Objet à rechercher en base.<br/>
	 * 
	 * @return : IProfil : 
	 * L'Objet trouvé en base.<br/>
	 * 
	 * @throws AbstractDaoException 
	 */
	IProfil 
		retrieveByIdMetier(IProfil pObjet) 
				throws AbstractDaoException;



	/**
	 * method retrieveByAttributs(
	 * String pProfilString
	 * , String pPorteeProfil) :
	 * <ul>
	 * <li>Recherche en base un IProfil ayant 
	 * pour attributs ceux passés en paramètre.</li>
	 * <li>Les attributs sont ceux de equals(...) et doivent 
	 * identifier un objet unique.</li>
	 * </ul>
	 * return null si l'un des paramètres est blank.<br/>
	 * <br/>
	 *
	 * @param pProfilString : String : profilString du IProfil.<br/>
	 * @param pPorteeProfil : String : porteeProfil du IProfil.<br/>
	 * 
	 * @return IProfil.<br/>
	 * 
	 * @throws AbstractDaoException
	 */
	IProfil retrieveByAttributs(
			String pProfilString
				, String pPorteeProfil)
					throws AbstractDaoException;



} // FIN DE L'INTERFACE IDaoProfil.------------------------------------------