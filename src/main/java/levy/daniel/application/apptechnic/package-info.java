/**
 * class package-info :<br/>
 * Ce package contient toutes les classes <b>purement techniques</b> 
 * ne dépendant pas de la logique métier du domaine 
 * mais indispensables pour le fonctionnement de l'application.<br/>
 * On y trouve :
 * <ul>
 * <li>les exceptions typées que le développeur a codées.</li>
 * <li>le gestionnaire de la Locale sélectionnée dans l'application.</li>
 * <li>les ConfigurationManagers qui fournissent à l'application 
 * des singletons pour l'accès aux ressources internes 
 * (dans le classpath) et externes (hors classpath).</li>
 * </ul>
 * Ces classes sont absolument indépendantes de la technologie 
 * d'accès au modèle de l'application (web, standalone, ...).<br/>
 * Le package apptechnic doit être livré avec le package model 
 * lorsque l'on veut réutiliser la logique métier (model).<br/>
 * La logique métier (model) est décomposée en [SERVICES - METIER - DAO].<br/>
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
 * @since 6 mai 2018
 *
 */
package levy.daniel.application.apptechnic;
