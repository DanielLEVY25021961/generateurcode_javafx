package levy.daniel.application.model.metier.profil;

import java.io.Serializable;

import levy.daniel.application.model.metier.IExportateurCsv;
import levy.daniel.application.model.metier.IExportateurJTable;



/**
 * INTERFACE <b>IProfil</b> :<br/>
 * <p>
 * <b>IProfil</b> modélise un <i>concept</i> 
 * de <b>Profil</b> 
 * , c'est à dire  <b></b>  
 * <i>une ou plusieurs</i> <b></b>.
 * </p>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * HERITE de :
 * </span>
 * </p>
 * <li><b>IExportateurCsv</b> pour l'export d'un Objet 
 * métier en csv.</li>
 * <li><b>IExportateurJTable</b> pour l'affichage dans 
 * une JTable (Swing).</li>
 * <li><b>Comparable</b> pour l'affichage des Collections 
 * sous forme triée.</li>
 * <li><b>Cloneable</b> pour garantir que tout objet métier 
 * implémentant cette interface saura se cloner.</li>
 * <li><b>Serializable</b> pour garantir que tout objet métier 
 * implémentant cette interface pourra être serialisé.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout Profil implémentant 
 * IProfil sait :
 * </span>
 * </p>
 * <li>se <b>comparer</b> à un autre IProfil.</li>
 * <li>se <b>cloner</b>.</li>
 * <li>s'exporter sous forme <b>csv</b>.</li>
 * <li>s'exporter sous forme <b>JTable</b>.</li>
 * </ul>
 * 
 * <ul>
 * <p>
 * <span style="text-decoration: underline;">
 * Garantit que tout Profil implémentant 
 * IProfil possède à minima :
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
 * <li>L'<b>égalité metier</b> d'un IProfil est vérifiée sur :</li>
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
public interface IProfil extends IExportateurCsv, IExportateurJTable, Comparable<IProfil>, Cloneable, Serializable {



	/**
	 * method compareTo(
	 * IProfil pObject) :<br/>
	 * <ol>
	 * Comparaison de 2 IProfil par rapport à :
	 * <li>profilString.</li>
	 * <li>porteeProfil.</li>
	 * </ol>
	 *
	 * @param pObject : IProfil.<br/>
	 * 
	 * @return : int : négatif si la présente instance 
	 * est "avant" pObject.<br/>
	 */
	@Override
	int compareTo(IProfil pObject);



	/**
	 * method clone() :<br/>
	 * Clone un IProfil.<br/>
	 * <br/>
	 *
	 * @return IProfil : clone.<br/>
	 * 
	 * @throws CloneNotSupportedException
	 */
	IProfil clone() throws CloneNotSupportedException;



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête csv pour un IProfil</b> :<br/>
	 * "id;profilString;porteeProfil;restrictionProfil;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne csv pour un IProfil</b> :<br/>
	 * "id;profilString;porteeProfil;restrictionProfil;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>en-tête Jtable pour un IProfil</b> :<br/>
	 * "id;profilString;porteeProfil;restrictionProfil;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);



	/**
	 * {@inheritDoc}
	 * <br/>
	 * <b>ligne Jtable pour un IProfil</b> :<br/>
	 * "id;profilString;porteeProfil;restrictionProfil;".<br/>
	 * <br/>
	 */
	@Override
	Object getValeurColonne(int pI);



	/**
	 * method getId() :<br/>
	 * Getter de l'ID en base.<br/>
	 * <br/>
	 *
	 * @return id : Long.<br/>
	 */
	Long getId();



	/**
	* method setId(
	* Long pId) :<br/>
	* Setter de l'ID en base.<br/>
	* <br/>
	*
	* @param pId : Long : valeur à passer à id.<br/>
	*/
	void setId(Long pId);



	/**
	 * method getProfilString() :<br/>
	 * Getter du profilString du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PROFILSTRING_RENSEIGNE_01 : 
	 * le profilString du Profil doit être renseigné (obligatoire).</li>
	 * <li>RG_PROFIL_PROFILSTRING_NOMENCLATURE_02 : 
	 * le profilString du Profil doit respecter un ensemble fini de valeurs (nomenclature).</li>
	 * </ul>
	 *
	 * @return profilString : String.<br/>
	 */
	String getProfilString();



	/**
	* method setProfilString(
	* String pProfilString) :<br/>
	* Setter du profilString du Profil.<br/>
	* <br/>
	*
	* @param pProfilString : String : 
	* valeur à passer à profilString.<br/>
	*/
	void setProfilString(String pProfilString);



	/**
	 * method getPorteeProfil() :<br/>
	 * Getter du porteeProfil du Profil.<br/>
	 * <ul>
	 * <li>RG_PROFIL_PORTEEPROFIL_RENSEIGNE_01 : 
	 * le porteeProfil du Profil doit être renseigné (obligatoire).</li>
	 * </ul>
	 *
	 * @return porteeProfil : String.<br/>
	 */
	String getPorteeProfil();



	/**
	* method setPorteeProfil(
	* String pPorteeProfil) :<br/>
	* Setter du porteeProfil du Profil.<br/>
	* <br/>
	*
	* @param pPorteeProfil : String : 
	* valeur à passer à porteeProfil.<br/>
	*/
	void setPorteeProfil(String pPorteeProfil);



	/**
	 * method getRestrictionProfil() :<br/>
	 * Getter du restrictionProfil du Profil.<br/>
	 *
	 * @return restrictionProfil : String.<br/>
	 */
	String getRestrictionProfil();



	/**
	* method setRestrictionProfil(
	* String pRestrictionProfil) :<br/>
	* Setter du restrictionProfil du Profil.<br/>
	* <br/>
	*
	* @param pRestrictionProfil : String : 
	* valeur à passer à restrictionProfil.<br/>
	*/
	void setRestrictionProfil(String pRestrictionProfil);



} // FIN DE L'INTERFACE IProfil.---------------------------------------------