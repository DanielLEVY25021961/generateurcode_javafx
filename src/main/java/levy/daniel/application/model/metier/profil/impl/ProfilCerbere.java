package levy.daniel.application.model.metier.profil.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.metier.profil.AbstractProfil;



/**
 * CLASSE CONCRETE <b>ProfilCerbere</b> :<br/>
 * <p>
 * <span style="text-decoration: underline;">CONCEPT MODELISE</span>
 * </p>
 * <p>
 * <b>ProfilCerbere</b> modélise un un <i>concept</i> 
 * de <b>Profil</b>, c'est à dire 
 * <b></b> ou  <b></b> 
 * qui  <i></i> <b></b>.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE DE :
 * </span>
 * </p>
 * <li><b>AbstractProfil</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * ATTRIBUTS :
 * </span>
 * </p>
 * <li><b>id</b> pour la mise en base.</li>
 * <li><b>profilString</b>.</li>
 * <li><b>porteeProfil</b>.</li>
 * <li><b>restrictionProfil</b>.</li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">EGALITE METIER</span>
 * </p>
 * <ul>
 * <li>L'<b>égalité metier</b> d'un ProfilCerbere est vérifiée sur :</li>
 * <ul>
 * <li><b>profilString</b>.</li>
 * <li><b>porteeProfil</b>.</li>
 * </ul>
 * </ul>
 *
 * <p>
 * <span style="text-decoration: underline;">DIAGRAMME DE CLASSES D'IMPLEMENTATION</span>
 * </p>
 * <ul>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/classes_implementation_Profil.png" 
 * alt="classes d'implémentation des Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * ENTITIES JPA
 * </span>
 * </p>
 * <ul>
 * <li>la classe concrète ProfilCerbere 
 * est transformée en <b>Entity JPA</b> au moyen de 
 * <b>javax.persistence annotations</b>.</li>
 * <li>La <b>stratégie de jointure des tables</b> entre la classe abstraite 
 * et ses descendants concrets est <b>InheritanceType.JOINED</b>.</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/implementation_Profil_entities.png" 
 * alt="implémentation des entities de Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <p>
 * <span style="text-decoration: underline;">
 * TABLES
 * </span>
 * </p>
 * <ul>
 * <li>Les <b>tables en base</b> résultantes des entities JPA sont :</li>
 * <br/>
 * <li>
 * <img src="../../../../../../../../../../javadoc/images/tables-abstract_Profils_Profils.png" 
 * alt="implémentation des tables de Profil" border="1" align="center" />
 * </li>
 * </ul>
 * 
 * <br/>
 * <p>
 * <span style="text-decoration: underline;">REGLES DE GESTION</span>
 * </p>
 * <ul>
 * <li>
 * Les <b>Règles de Gestion (RG)</b> applicables aux attributs 
 * d'un Profil sont les suivantes :
 * </li>
 * <br/>
 * <table border="1">
 * <tr>
 * <th>Attribut</th><th>Règle de Gestion</th>
 * </tr>
 * 
 * <tr>
 * <td rowspan="2">
 * profilString
 * </td>
 * <td>
 * RG_PROFIL_PROFILSTRING_RENSEIGNE_01 : 
 * le profilString du Profil doit être renseigné (obligatoire)
 * </td>
 * </tr>
 * <tr>
 * <td>
 * RG_PROFIL_PROFILSTRING_NOMENCLATURE_02 : 
 * le profilString du Profil doit respecter un ensemble fini de valeurs (nomenclature)
 * </td>
 * </tr>
 * <tr>
 * <td rowspan="1">
 * porteeProfil
 * </td>
 * <td>
 * RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
 * le porteeProfil du Profil doit être renseigné (obligatoire)
 * </td>
 * </tr>
 * </table>
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
 * @since 26 février 2018
 *
 */
public class ProfilCerbere extends AbstractProfil {

	// ************************ATTRIBUTS************************************/

	/**
	 * CLASSE_PROFIL_CERBERE : String :<br/>
	 * "Classe ProfilCerbere".<br/>
	 */
	public static final String CLASSE_PROFIL_CERBERE 
		= "Classe ProfilCerbere";


	/**
	 * serialVersionUID : long :<br/>
	 * serialVersionUID = 1L.<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG 
		= LogFactory.getLog(ProfilCerbere.class);


	// *************************METHODES************************************/


	/**
	 * method CONSTRUCTEUR ProfilCerbere() :<br/>
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 */
	public ProfilCerbere() {

		this(null, null, null, null);

	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________



	/**
	 * method CONSTRUCTEUR ProfilCerbere(
	 *  String pProfilString
	 * , String pPorteeProfil
	 * , String pRestrictionProfil) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET.</li>
	 * <li>SANS ID en base.</li>
	 * </ul>
	 * 
	 * @param pProfilString : String : 
	 * profilString du ProfilCerbere.<br/>
	 * @param pPorteeProfil : String : 
	 * porteeProfil du ProfilCerbere.<br/>
	 * @param pRestrictionProfil : String : 
	 * restrictionProfil du ProfilCerbere.<br/>
	 */
	public ProfilCerbere(
			final String pProfilString
				, final String pPorteeProfil
					, final String pRestrictionProfil) {

		this(null, pProfilString, pPorteeProfil, pRestrictionProfil);

	} // Fin de CONSTRUCTEUR COMPLET.______________________________________



	/**
	 * method CONSTRUCTEUR ProfilCerbere(
	 * Long pId
	 * , String pProfilString
	 * , String pPorteeProfil
	 * , String pRestrictionProfil) :<br/>
	 * <ul>
	 * <li>CONSTRUCTEUR COMPLET BASE.</li>
	 * <li>AVEC ID en base.</li>
	 * </ul>
	 * 
	 * @param pId : Long : ID en base.<br/>
	 * @param pProfilString : String : 
	 * profilString du ProfilCerbere.<br/>
	 * @param pPorteeProfil : String : 
	 * porteeProfil du ProfilCerbere.<br/>
	 * @param pRestrictionProfil : String : 
	 * restrictionProfil du ProfilCerbere.<br/>
	 */
	public ProfilCerbere(
			final Long pId
				, final String pProfilString
					, final String pPorteeProfil
						, final String pRestrictionProfil) {

		super(pId, pProfilString, pPorteeProfil, pRestrictionProfil);

	} // Fin de CONSTRUCTEUR COMPLET BASE._________________________________



} // FIN DE LA CLASSE ProfilCerbere.-----------------------------------------