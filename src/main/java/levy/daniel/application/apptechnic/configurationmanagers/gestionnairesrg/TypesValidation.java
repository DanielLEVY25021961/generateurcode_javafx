package levy.daniel.application.apptechnic.configurationmanagers.gestionnairesrg;



/**
 * Enumeration TypesValidation :<br/>
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
 * @since 7 déc. 2017
 *
 */
public enum TypesValidation {
	
	/**
	 * RENSEIGNE : TypesValidation :<br/>
	 * Attribut devant être renseigné.<br/>
	 */
	RENSEIGNE
	
	, /**
	 * LITTERAL : TypesValidation :<br/>
	 * Attribut devant être entièrement littéral avec des lettres 
	 * de l'alphabet et des caractères spéciaux (-, _, ...)
	 * (pas de chiffres).<br/>
	 */
	LITTERAL
	
	, /**
	 * LITTERAL_ALPHABETIQUE : TypesValidation :<br/>
	 * Attribut devant être entièrement littéral avec uniquement 
	 * des lettres de l'alphabet ([a-z[A-Z]).<br/>
	 */
	LITTERAL_ALPHABETIQUE
	
	, /**
	 * NUMERIQUE : TypesValidation :<br/>
	 * Attribut devant être entièrement numérique (pas de lettres).<br/>
	 */
	NUMERIQUE
	
	, /**
	 * LONGUEUR : TypesValidation :<br/>
	 * Attribut devant avoir une longueur bornée.<br/>
	 */
	LONGUEUR
	
	, /**
	 * MOTIF : TypesValidation :<br/>
	 * Attributs devant suivre un motif (Regex).<br/>
	 */
	MOTIF
	
	, /**
	 * NOMENCLATURE : TypesValidation :<br/>
	 * Attributs devant se conformer à une nomenclature.<br/>
	 */
	NOMENCLATURE
	
	, /**
	 * FOURCHETTE : TypesValidation :<br/>
	 * Attribut devant avoir une valeur numérique bornée.<br/>
	 */
	FOURCHETTE;

	
} // Fin de Enumeration TypesValidation.___________________________________
