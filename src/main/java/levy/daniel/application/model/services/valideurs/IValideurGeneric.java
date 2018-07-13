package levy.daniel.application.model.services.valideurs;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg.LigneRG;

/**
 * class IValideurGeneric :<br/>
 * .<br/>
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
 * @since 30 août 2017
 *
 */
public interface IValideurGeneric<T> {
	
	/**
	 * method validate(
	 * T pObject) :<br/>
	 * <ul>
	 * <li>valide l'Objet métier de type paramétré T pObject.</li>
	 * <li>retourne une map&lt;String, map&lt;String, String&gt;&gt; 
	 * 'this.erreurs' contenant les messages d'erreur avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le message d'erreur.</li>
	 * <li>map&lt;String, String&gt; : une map contenant la RG violée 
	 * ainsi que le message d'erreur relatif à la RG.</li>
	 * </ul>
	 * <li>alimente une map&lt;String, map&lt;String, 
	 * LigneRapportValidation&gt;&gt; 'this.controles'
	 * contenant les rapports de contrôle (validation) avec :
	 * <ul>
	 * <li>String : le nom de l'attribut de l'Objet métier concerné 
	 * par le rapport de contrôle (par exemple "prénom").</li>
	 * <li>map&lt;String, LigneRapportValidation&gt; : une Map avec :
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
	 * <li>Alimente la Liste des RG implémentées dans le Service 
	 * 'this.listeRGImplementees'.</li>
	 * <li>Alimente une liste des contrôles effectués 
	 * 'this.controlesList'.</li> 
	 * <br/>
	 *
	 * @param pObject : T : Objet métier de type paramétré T.<br/>
	 * 
	 * @return : map&lt;String, map&lt;String, String&gt;&gt; : 
	 * Map contenant les attributs de l'Objet métier violant des RG 
	 * ainsi que les messages d'erreur relatifs aux RG violées.<br/>
	 * 
	 * @throws MalformedURLException 
	 */
	Map<String, Map<String, String>> validate(T pObject) 
			throws MalformedURLException;
	
	
	
	/**
	 * method fournirEnTeteCsvRGImplementees() :<br/>
	 * Retourne l'en-Tête Csv pour la liste des 
	 * règles de gestion implémentées dans ce service.<br/>
	 * <br/>
	 * "id;Actif;activité des contrôles sur l'attribut;activité de la RG;
	 * RG implémentée;clé du type de contrôle;type de contrôle;Message d'erreur;
	 * Objet Métier concerné;Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 * <br/>
	 *
	 * @return : String : 
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;".<br/>
	 */
	String fournirEnTeteCsvRGImplementees();


	
	/**
	 * method fournirStringListeCsvRGImplementees() :<br/>
	 * <ul>
	 * <li>fournit sous forme de String en csv avec séparateur ':'
	 * et saut de ligne après chaque RG 
	 * la liste des règles de gestions (RG) contrôlées 
	 * dans le présent Service.</li>
	 * <li>Trie les LigneRG en fonction des numéros de RG 
	 * (Comparator).</li>
	 * <li>La liste csv ne comporte pas d'en-tête.</li>
	 * </ul>
	 * retourne null si this.listeRGImplementees == null.<br/>
	 * <br/>
	 * Une règle de gestion est décomposée comme suit :<br/>
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;".<br/>
	 * <br/>
	 *
	 * @return : String : liste des règles de gestions contrôlées 
	 * dans le présent Service en CSV sans en-tête.<br/>
	 */
	String fournirStringListeCsvRGImplementees();
	

	
	/**
	 * method fournirStringListeCsvRGImplementeesAvecEntete() :<br/>
	 * <ul>
	 * <li>fournit sous forme de String en csv avec séparateur ':'
	 * et saut de ligne après chaque RG 
	 * la liste des règles de gestions (RG) contrôlées 
	 * dans le présent Service.</li>
	 * <li>La liste csv comporte un en-tête.</li>
	 * <li>Utile pour créer un fichier Csv contenant les RG implémentées dans le Valideur.</li>
	 * </ul>
	 * retourne null si this.listeRGImplementees == null.<br/>
	 * <br/>
	 * Une règle de gestion est décomposée comme suit :<br/>
	 * "id;Actif;activité des contrôles sur l'attribut
	 * ;activité de la RG;RG implémentée;clé du type de contrôle;
	 * type de contrôle;Message d'erreur;Objet Métier concerné;
	 * Attribut concerné;Classe implémentant la RG;
	 * Méthode implémentant la RG;properties;clé;".<br/>
	 * <br/>
	 *
	 * @return : String : liste des règles de gestions contrôlées 
	 * dans le présent Service en CSV AVEC en-tête.<br/>
	 */
	String fournirStringListeCsvRGImplementeesAvecEntete();
	
	
	
	/**
	 * method fournirMapErreursAttribut(
	 * String pAttribut) :<br/>
	 * Fournit les erreurs concernant l'attribut pAttribut 
	 * sous forme de Map&lt;String, String&gt; avec :
	 * <ul>
	 * <li>String : le nom de la RG violée 
	 * (par exemple "RG_CLIENT_NOM_01 : le nom du client 
	 * doit être renseigné.").</li>
	 * <li>String : le message d'erreur relatif à la RG 
	 * (par exemple : "Le nom n'est pas renseigné (obligatoire).").</li>
	 * </ul>
	 * retourne null si pAttribut == null.<br/>
	 * retourne null si this.erreurs == null.<br/>
	 * <br/>
	 *
	 * @param pAttribut : String : Attribut du bean.<br/>
	 * 
	 * @return : Map&lt;String, String&gt; : 
	 * erreurs concernant l'attribut pAttribut.<br/>
	 */
	Map<String, String> fournirMapErreursAttribut(String pAttribut);

	
	
	/**
	 * method fournirStringErreursAttribut(
	 * String pAttribut
	 * , String pSautLigne) :<br/>
	 * <ul>
	 * <li>Retourne seulement les Messages d'erreurs 
	 * relatifs à l'attribut pAttribut concaténés 
	 * dans une unique String.</li>
	 * <li>Chaque message d'erreur est séparé par 
	 * le saut de ligne pSautLigne ("\n" ou "&lt;br/&gt;") 
	 * dans la String résultat.</li>
	 * <li>Utile pour les messages utilisateur dans les IHM.</li>
	 * <li>Par exemple pour l'attribut 'nom' :<br/>
	 * Le nom n'est pas renseigné (obligatoire).<br/>
	 * le nom du client ne doit contenir que des lettres (pas de chiffres).</li>
	 * </ul>
	 * retourne null si pAttribut == null.<br/>
	 * retourne null si this.erreurs == null.<br/>
	 * <br/>
	 *
	 * @param pAttribut : String : Attribut du bean.<br/>
	 * @param pSautLigne : String : "\n" ou "&lt;br/&gt;".<br/>
	 * 
	 * @return : String : Messages d'erreurs concaténés 
	 * dans une unique String.<br/>
	 */
	String fournirStringErreursAttribut(
			String pAttribut
				, String pSautLigne);
	
	
	
	/**
	 * method fournirListeMessagesErreurs(
	 *Map&lt;String, String&gt; pMap) :<br/>
	 * Retourne la Collection des values 
	 * d'une Map&lt;String, String&gt;.<br/>
	 * <br/>
	 * retourne null si pMap == null.<br/>
	 * <br/>
	 *
	 * @param pMap : Map&lt;String, String&gt;.<br/>
	 * 
	 * @return : Collection&lt;String&gt;.<br/>
	 */
	Collection<String> fournirListeMessagesErreurs(
								Map<String, String> pMap);
	

	
	/**
	 * method afficherErreurs() :<br/>
	 * <ul>
	 * <li>Retourne une String pour l'affichage de this.erreurs.</li>
	 * <li>La String retournée contient une ligne par erreur.</li>
	 * <li>Chaque ligne est de la forme "attribut;RG;message erreur RG;".</li>
	 * </ul>
	 * Exemple : <br/>
	 * "nom;RG_CLIENT_NOM_01 : 
	 * le nom du client doit être renseigné.;
	 * Le nom n'est pas renseigné (obligatoire)";<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	String afficherErreurs();
	

	
	/**
	 * method fournirMapControlesAttribut(
	 * String pAttribut) :<br/>
	 * Fournit les contrôles concernant l'attribut pAttribut 
	 * sous forme de Map&lt;String, LigneRapportValidation&gt; avec :
	 * <ul>
	 * <li>String : le nom de la RG violée 
	 * (par exemple "RG_CLIENT_NOM_01 : le nom du client 
	 * doit être renseigné.").</li>
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
	 * retourne null si pAttribut == null.<br/>
	 * retourne null si this.controles == null.<br/>
	 * <br/>
	 *
	 * @param pAttribut : String : Attribut du bean.<br/>
	 * 
	 * @return : Map&lt;String, LigneRapportValidation&gt; : 
	 * contrôles concernant l'attribut pAttribut.<br/>
	 */
	Map<String, LigneRapportValidation> 
				fournirMapControlesAttribut(String pAttribut);
	

	
	/**
	 * method fournirStringControlesAttribut(
	 * String pAttribut
	 * , String pSautLigne) :<br/>
	 * <ul>
	 * <li>Retourne les Messages de contrôle relatifs à 
	 * l'attribut pAttribut concaténés dans une unique String.</li>
	 * <li>Un message de contrôle est sous la forme 
	 * "nomRG;Résultat du contrôle;message du contrôle;"</li>
	 * <li>Chaque message de contrôle est séparé par 
	 * le saut de ligne pSautLigne ("\n" ou "&lt;br/&gt;") 
	 * dans la String résultat.</li>
	 * <li>Utile pour les rapports de contrôle à l'attention 
	 * de l'utilisateur.</li>
	 * </ul>
	 * Exemple :<br/>
	 * RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;
	 * KO;Le champ nom est null ou vide (que des espaces);<br/>
	 * RG_CLIENT_NOM_02 : le nom du client ne doit contenir 
	 * que des lettres.;OK;Le champ nom est blank (null ou vide). 
	 * Donc pas de chiffres !;<br/>
	 * <br/>
	 * 
	 * retourne null si pAttribut == null.<br/>
	 * retourne null si this.controles == null.<br/>
	 * <br/>
	 *
	 * @param pAttribut : String : Attribut du bean.<br/>
	 * @param pSautLigne : String : "\n" ou "&lt;br&gt;".<br/>
	 * 
	 * @return : String : Messages de contrôle concaténés 
	 * dans une unique String.<br/>
	 */
	String fournirStringControlesAttribut(
			String pAttribut
				, String pSautLigne);
	
	
	
	/**
	 * method fournirListeMessagesControles(
	 * Map&lt;String, LigneRapportValidation&gt; pMap) :<br/>
	 * Retourne la Collection des values 
	 * d'une Map&lt;String, LigneRapportValidation&gt;.<br/>
	 * <br/>
	 * retourne null si pMap == null.<br/>
	 * <br/>
	 *
	 * @param pMap : Map&lt;String, LigneRapportValidation&gt;.<br/>
	 * 
	 * @return : Collection&lt;LigneRapportValidation&gt;.<br/>
	 */
	Collection<LigneRapportValidation> 
			fournirListeMessagesControles(
					Map<String, LigneRapportValidation> pMap);
	

	
	/**
	 * method afficherControles() :<br/>
	 * <ul>
	 * <li>Retourne une String pour l'affichage de this.controles.</li>
	 * <li>La String retournée contient une ligne par contrôle.</li>
	 * <li>Chaque ligne est de la forme 
	 * "attribut;RG;Résultat du contrôle;message du contrôle;".</li>
	 * </ul>
	 * Exemple : <br/>
	 * nom;RG_CLIENT_NOM_01 : le nom du client doit être renseigné.;KO;
	 * Le champ nom est null ou vide (que des espaces);<br/>
	 * nom;RG_CLIENT_NOM_02 : le nom du client ne doit contenir 
	 * que des lettres.;OK;Le champ nom est blank (null ou vide). 
	 * Donc pas de chiffres !;<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	String afficherControles();
	
	
	
	/**
	 * method getListeRGImplementees() :<br/>
	 * Getter de la Liste des RG implémentées dans le Service.<br/>
	 * <br/>
	 * Une LigneRG encapsule :<br/>
	 * [id;Actif;activité des contrôles sur l'attribut;activité de la RG
	 * ;RG implémentée;clé du type de contrôle;type de contrôle
	 * ;Message d'erreur;Objet Métier concerné;Attribut concerné
	 * ;Classe implémentant la RG;Méthode implémentant la RG;].<br/>
	 * <br/>
	 *
	 * @return listeRGImplementees : List&lt;LigneRG&gt;.<br/>
	 */
	List<LigneRG> getListeRGImplementees();

	
	
	/**
	 * method getErreurs() :<br/>
	 * Getter de la map&lt;String, map&lt;String, String&gt;&gt; 
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
	 * <br/>
	 *
	 * @return erreurs : map&lt;String, map&lt;String, String&gt;&gt;.<br/>
	 */
	Map<String, Map<String, String>> getErreurs();
	

	
	/**
	 * method getControles() :<br/>
	 * Getter de la map&lt;String, map&lt;String
	 * , LigneRapportValidation&gt;&gt; 
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
	 * <br/>
	 *
	 * @return controles : map&lt;String, map&lt;String
	 * , LigneRapportValidation&gt;&gt;.<br/>
	 */
	Map<String, Map<String, LigneRapportValidation>> getControles();
	

	
	/**
	 * method getControlesList() :<br/>
	 * Getter de la Liste des Pures fabrications encapsulant 
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
	 * <br/>
	 *
	 * @return controlesList : 
	 * List&lt;LigneRapportValidation&gt;.<br/>
	 */
	List<LigneRapportValidation> getControlesList();
	
	
	
	/**
	 * method getValide() :<br/>
	 * Getter du Boolean qui stipule si le contrôle effectué 
	 * par le validateur est sans erreur ou pas.<br/>
	 * <br/>
	 *
	 * @return valide : Boolean.<br/>
	 */
	Boolean getValide();
	


} // FIN DE L'INTERFACE IValideurGeneric.------------------------------------
