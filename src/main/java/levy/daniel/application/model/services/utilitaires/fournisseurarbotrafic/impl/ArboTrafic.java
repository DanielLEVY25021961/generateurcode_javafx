package levy.daniel.application.model.services.utilitaires.fournisseurarbotrafic.impl;

import java.io.File;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import levy.daniel.application.model.services.utilitaires.fournisseurarbotrafic.IArboTrafic;


/**
 * CLASSE ArboTrafic :<br/>
 * Pure fabrication (encapsulation) chargée de <b>fournir 
 * tous les répertoires</b> d'une 
 * <i>année d'exploitation des trafics donnée</i> 
 * (sous une racine "Trafic_Histonat" donnée).<br/>
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
 * @since 12 juin 2018
 *
 */
public class ArboTrafic implements IArboTrafic {

	// ************************ATTRIBUTS************************************/
	
	/**
	 * serialVersionUID : long :<br/>
	 * .<br/>
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * CLASSE_ARBOTRAFIC : String :<br/>
	 * "Classe ArboTrafic".<br/>
	 */
	public static final String CLASSE_ARBOTRAFIC 
		= "Classe ArboTrafic";
	
	
	/**
	 * id : Long :<br/>
	 * id en base.<br/>
	 */
	private Long id;
		
	/**
	 * <b>RACINE (Trafic_Histonat)</b> des fichiers annuels de Trafic.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/racine_Trafic_Histonat.png" 
	 * alt="Racine des Trafics Trafic_Histonat" border="1" align="center" />
	 * <br/>
	 */
	private File rootFile;
	
	/**
	 * <b>année d'exploitation</b> des fichiers annuels de trafic 
	 * (2013, 2017, ...).<br/>
	 * sur 4 digits obligatoirement.<br/>
	 */
	private String anneeExploitation;
	
	/**
	 * <b>répertoire des Trafics annuels (Trafic_aaaa)</b> 
	 * sur un disque dur 
	 * pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Trafic_annuel.png" 
	 * alt="Trafic annuel" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireTraficAnnuel;
	
	/**
	 * <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <ul>
	 * <li>Les <b>fichiers des autoroutiers (DARWIN)</b> 
	 * sont nativement formatés en <b>CSV</b>.</li>
	 * <li>Les <b>fichiers des DIRs (HIT)</b> sont 
	 * nativement formatés en <b>ASCII</b>.</li>
	 * </ul>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux.png" 
	 * alt="fichiers originaux" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersOriginaux;
	
	/**
	 * <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en ANSI</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Ansi.png" 
	 * alt="fichiers originaux ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersOriginauxANSI;
	
	/**
	 * <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en ANSI</b> 
	 * et <b>formatés en CSV</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Ansi_csv.png" 
	 * alt="fichiers originaux ANSI en csv" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersOriginauxANSIcsv;
	
	/**
	 * <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en UTF8</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Utf8.png" 
	 * alt="fichiers originaux UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersOriginauxUTF8;
	
	/**
	 * <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en UTF8</b> 
	 * et <b>formatés en CSV</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Utf8_csv.png" 
	 * alt="fichiers originaux UTF8 en csv" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersOriginauxUTF8csv;
	
	/**
	 * <b>répertoire des fichiers HIT nettoyés 
	 * (sens de trafic confondus)</b>
	 * encodés en UTF-8 sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres) <b>en ASCII natif</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_Nettoyes_Utf8.png" 
	 * alt="fichiers nettoyés UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersNettoyesUTF8;
	
	/**
	 * <b>répertoire des fichiers HIT nettoyés 
	 * (sens de trafic confondus)</b>
	 * encodés en UTF-8 sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres) <b>formatés en CSV</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_Nettoyes_UTF8csv.png" 
	 * alt="fichiers nettoyés UTF8 csv" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersNettoyesUTF8csv;
	
	/**
	 * <b>répertoire des fichiers de réponse d'ISIDOR</b> 
	 * pour la <b>localisation</b> des fichiers fournis 
	 * par les gestionnaires encodés en UTF-8 sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <i>ISIDOR indique pour chaque section de trafic 
	 * d'un fichier de gestionnaire (HIT, DARWIN) 
	 * si elle existe ou pas</i>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_ReponseLocalisation_Utf8.png" 
	 * alt="fichiers réponse localisation ISIDOR" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireFichiersReponseLocalisationUTF8;
	
	/**
	 * <b>répertoire annee</b> contenant les sous-répertoires 
	 * pour chaque Gestionnaire ainsi que les 
	 * productions de l'application sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_annee.png" 
	 * alt="répertoire annee" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireAnnee;
	
	/**
	 * <b>répertoire DARWIN</b> contenant les données trafic des autoroutiers 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DARWIN.png" 
	 * alt="répertoire DARWIN" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDARWIN;
	
	/**
	 * <b>répertoire DIRA</b> contenant les données trafic 
	 * de la DIR Atlantique (DIRA) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRA.png" 
	 * alt="répertoire DIRA" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRA;
	
	/**
	 * <b>répertoire DIRCE</b> contenant les données trafic 
	 * de la DIR Centre-Est (DIRCE)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRCE.png" 
	 * alt="répertoire DIRCE" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRCE;
	
	/**
	 * <b>répertoire DIRCO</b> contenant les données trafic 
	 * de la DIR Centre-Ouest (DIRCO) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRCO.png" 
	 * alt="répertoire DIRCO" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRCO;
	
	/**
	 * <b>répertoire DIRE</b> contenant les données trafic 
	 * de la DIR Est (DIRE) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRE.png" 
	 * alt="répertoire DIRE" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRE;
	
	/**
	 * <b>répertoire DIRIF</b> contenant les données trafic 
	 * de la DIR Ile-de-France (DIRIF) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRIF.png" 
	 * alt="répertoire DIRIF" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRIF;
	
	/**
	 * <b>répertoire DIRMC</b> contenant les données trafic 
	 * de la DIR Massif-Central (DIRMC) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRMC.png" 
	 * alt="répertoire DIRMC" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRMC;
	
	/**
	 * <b>répertoire DIRMED</b> contenant les données trafic 
	 * de la DIR Méditerranée (DIRMED)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRMED.png" 
	 * alt="répertoire DIRMED" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRMED;
	
	/**
	 * <b>répertoire DIRN</b> contenant les données trafic 
	 * de la DIR Nord (DIRN)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRN.png" 
	 * alt="répertoire DIRN" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRN;
	
	/**
	 * <b>répertoire DIRNO</b> contenant les données trafic 
	 * de la DIR Nord-Ouest (DIRNO) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRNO.png" 
	 * alt="répertoire DIRNO" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRNO;
	
	/**
	 * <b>répertoire DIRO</b> contenant les données trafic 
	 * de la DIR Ouest (DIRO) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRO.png" 
	 * alt="répertoire DIRO" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRO;
	
	/**
	 * <b>répertoire DIRSO</b> contenant les données trafic 
	 * de la DIR Sud-Ouest (DIRSO) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRSO.png" 
	 * alt="répertoire DIRSO" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireDIRSO;

	/**
	 * <b>répertoire annee/Entree</b> contenant 
	 * les données de trafic en entrée de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_Entree.png" 
	 * alt="répertoire Entree" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntree;
	
	/**
	 * <b>répertoire Entree/Darwin</b> contenant 
	 * les données de trafic des autoroutiers 
	 * en entrée de l'application 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwin.png" 
	 * alt="répertoire Entree Darwin" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeDarwin;
	
	/**
	 * <b>répertoire Entree/Darwin/Darwin encodé en ANSI/</b> contenant 
	 * les données de trafic des autoroutiers 
	 * en entrée de l'application <b>encodées en ANSI</b> 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwinANSI.png" 
	 * alt="répertoire Entree Darwin ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeDarwinANSI;
	
	/**
	 * <b>répertoire Entree/Darwin/Darwin encodé en UTF8/</b> contenant 
	 * les données de trafic des autoroutiers 
	 * en entrée de l'application <b>encodées en UTF8</b> 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwinUTF8.png" 
	 * alt="répertoire Entree Darwin UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeDarwinUTF8;

	/**
	 * <b>répertoire Entree/Darwin/Darwin original/</b> contenant 
	 * les données de trafic des autoroutiers 
	 * en entrée de l'application <b>fournies par le gestionnaire</b> 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwinOriginal.png" 
	 * alt="répertoire Entree Darwin Original" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeDarwinOriginal;
	
	/**
	 * <b>répertoire Entree/Hit/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHit.png" 
	 * alt="répertoire Entree Hit" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHit;
	
	/**
	 * <b>répertoire Entree/Hit/Hit encodés en ANSI/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSI.png" 
	 * alt="répertoire Entree Hit ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitANSI;

	/**
	 * <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_Ascii/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en Ascii</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSIAscii.png" 
	 * alt="répertoire Entree Hit ANSI Ascii" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitANSIAscii;
	
	/**
	 * <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_Csv/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en Csv</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSICsv.png" 
	 * alt="répertoire Entree Hit ANSI Csv" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitANSICsv;

	/**
	 * <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_FeorXML/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en FeorXML</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSIFeorXML.png" 
	 * alt="répertoire Entree Hit ANSI FeorXML" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitANSIFeorXML;
	
	/**
	 * <b>répertoire Entree/Hit/Hit encodés en UTF8/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8.png" 
	 * alt="répertoire Entree Hit UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitUTF8;

	/**
	 * <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_Ascii/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en Ascii</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8Ascii.png" 
	 * alt="répertoire Entree Hit UTF8 Ascii" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitUTF8Ascii;
	
	/**
	 * <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_Csv/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en Csv</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8Csv.png" 
	 * alt="répertoire Entree Hit UTF8 Csv" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitUTF8Csv;

	/**
	 * <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_FeorXML/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en FeorXML</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8FeorXML.png" 
	 * alt="répertoire Entree Hit UTF8 FeorXML" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitUTF8FeorXML;
	
	/**
	 * <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit originaux/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>fournies par les gestionnaires</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitOriginal.png" 
	 * alt="répertoire Entree Hit Original" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireEntreeHitOriginal;
	
	/**
	 * <b>répertoire annee/Sortie</b> contenant 
	 * les données de trafic en sortie (productions) de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_Sortie.png" 
	 * alt="répertoire Sortie" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortie;
	
	/**
	 * <b>répertoire Sortie/HistonatF07/</b>
	 * contenant les données de trafic HistonatF07
	 *  en sortie (productions) de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07.png" 
	 * alt="répertoire Sortie HistonatF07" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en ASCII/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en Ascii</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07Ascii.png" 
	 * alt="répertoire Sortie HistonatF07 Ascii" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07Ascii;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en ASCII/
	 * HistonatF07 ASCII encodé en ANSI/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en Ascii</b> et <b>encodées en ANSI</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07AsciiANSI.png" 
	 * alt="répertoire Sortie HistonatF07 Ascii ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07AsciiANSI;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en ASCII/
	 * HistonatF07 ASCII encodé en UTF8/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en Ascii</b> et <b>encodées en UTF8</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07AsciiUTF8.png" 
	 * alt="répertoire Sortie HistonatF07 Ascii UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07AsciiUTF8;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en CSV/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en Csv</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07Csv.png" 
	 * alt="répertoire Sortie HistonatF07 Csv" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07Csv;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en CSV/
	 * HistonatF07 CSV encodé en ANSI/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en Csv</b> et <b>encodées en ANSI</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07CsvANSI.png" 
	 * alt="répertoire Sortie HistonatF07 Csv ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07CsvANSI;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en CSV/
	 * HistonatF07 CSV encodé en UTF8/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en Csv</b> et <b>encodées en UTF8</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07CsvUTF8.png" 
	 * alt="répertoire Sortie HistonatF07 Csv UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07CsvUTF8;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en FeorXML/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en FeorXML</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07FeorXML.png" 
	 * alt="répertoire Sortie HistonatF07 FeorXML" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07FeorXML;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en FeorXML/
	 * HistonatF07 FeorXML encodé en ANSI/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en FeorXML</b> et <b>encodées en ANSI</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07FeorXMLANSI.png" 
	 * alt="répertoire Sortie HistonatF07 FeorXML ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07FeorXMLANSI;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF07/HistonatF07 en FeorXML/
	 * HistonatF07 FeorXML encodé en UTF8/</b>
	 * contenant les données de trafic HistonatF07 
	 * <b>formatées en FeorXML</b> et <b>encodées en UTF8</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07FeorXMLUTF8.png" 
	 * alt="répertoire Sortie HistonatF07 FeorXML UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF07FeorXMLUTF8;

	/**
	 * <b>répertoire Sortie/HistonatF08/</b>
	 * contenant les données de trafic HistonatF08 
	 * pour l'INDICE DE CIRCULATION
	 *  en sortie (productions) de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF08.png" 
	 * alt="répertoire Sortie HistonatF08" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF08;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF08/HistonatF08 en ASCII/</b>
	 * contenant les données de trafic HistonatF08 
	 * pour l'INDICE DE CIRCULATION
	 * <b>formatées en Ascii</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF08Ascii.png" 
	 * alt="répertoire Sortie HistonatF08 Ascii" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF08Ascii;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF08/HistonatF08 en ASCII/
	 * HistonatF08 ASCII encodé en ANSI/</b>
	 * contenant les données de trafic HistonatF08 
	 * pour l'INDICE DE CIRCULATION
	 * <b>formatées en Ascii</b> et <b>encodées en ANSI</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF08AsciiANSI.png" 
	 * alt="répertoire Sortie HistonatF08 Ascii ANSI" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF08AsciiANSI;
	
	/**
	 * <b>répertoire
	 * Sortie/HistonatF08/HistonatF08 en ASCII/
	 * HistonatF08 ASCII encodé en UTF8/</b>
	 * contenant les données de trafic HistonatF08 
	 * pour l'INDICE DE CIRCULATION 
	 * <b>formatées en Ascii</b> et <b>encodées en UTF8</b>
	 * en sortie (productions) de l'application 
	 * sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF08AsciiUTF8.png" 
	 * alt="répertoire Sortie HistonatF08 Ascii UTF8" border="1" align="center" />
	 * <br/>
	 */
	private File repertoireSortieHistonatF08AsciiUTF8;
	

	/**
	 * LOG : Log : 
	 * Logger pour Log4j (utilisant commons-logging).
	 */
	private static final Log LOG = LogFactory.getLog(ArboTrafic.class);

	// *************************METHODES************************************/
	
	
	 /**
	 * CONSTRUCTEUR D'ARITE NULLE.<br/>
	 * <br/>
	 */
	public ArboTrafic() {
		super();
	} // Fin de CONSTRUCTEUR D'ARITE NULLE.________________________________


	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int hashCode() {
		
		final int prime = 31;
		int result = 1;
		
		/* rootFile. */
		result 
			= prime * result 
			+ ((this.rootFile == null) ? 0 
					: this.rootFile.hashCode());
		
		/* anneeExploitation. */
		result 
			= prime * result 
			+ ((this.anneeExploitation == null) ? 0 
					: this.anneeExploitation.hashCode());
		
		return result;
		
	} // Fin de hashCode().________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final boolean equals(
			final Object pObjet) {
		
		if (this == pObjet) {
			return true;
		}
		if (pObjet == null) {
			return false;
		}
		if (!(pObjet instanceof ArboTrafic)) {
			return false;
		}
		
		final ArboTrafic other = (ArboTrafic) pObjet;
		
		/* rootFile. */
		if (this.rootFile == null) {
			if (other.rootFile != null) {
				return false;
			}
		} else if (!this.rootFile
				.equals(other.rootFile)) {
			return false;
		}
		
		/* anneeExploitation. */
		if (this.anneeExploitation == null) {
			if (other.anneeExploitation != null) {
				return false;
			}
		} else if (!this.anneeExploitation
				.equals(other.anneeExploitation)) {
			return false;
		}
		
		return true;
		
	} // Fin de equals(...)._______________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int compareTo(
			final IArboTrafic pObjet) {
		
		if (this == pObjet) {
			return 0;
		}

		if (pObjet == null) {
			return -1;
		}

		int compareRootFile = 0;
		int compareAnneeExploitation = 0;
		
		/* rootFile. */
		if (this.getRootFile() == null) {
			if (pObjet.getRootFile() != null) {
				return +1;
			}
		} else {
			if (pObjet.getRootFile() == null) {
				return -1;
			}
		}
		
		compareRootFile 
			= this.getRootFile().compareTo(pObjet.getRootFile());
		
		if (compareRootFile != 0) {
			return compareRootFile;
		}
		
		/* anneeExploitation. */
		if (this.getAnneeExploitation() == null) {
			if (pObjet.getAnneeExploitation() != null) {
				return +1;
			}
			
			return 0;
		}
		if (pObjet.getAnneeExploitation() == null) {
			return -1;
		}
		
		compareAnneeExploitation 
			= this.getAnneeExploitation()
				.compareTo(pObjet.getAnneeExploitation());
		
		return compareAnneeExploitation;
		
	} // Fin de compareTo(...).____________________________________________
	
		
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toString() {
		
		final StringBuilder builder = new StringBuilder();
		
		builder.append("ArboTrafic [");
		
		if (this.id != null) {
			builder.append("id=");
			builder.append(this.id);
			builder.append(", ");
		}
		if (this.rootFile != null) {
			builder.append("rootFile=");
			builder.append(this.rootFile);
			builder.append(", ");
		}
		if (this.anneeExploitation != null) {
			builder.append("anneeExploitation=");
			builder.append(this.anneeExploitation);
			builder.append(", ");
		}
		if (this.repertoireTraficAnnuel != null) {
			builder.append("repertoireTraficAnnuel=");
			builder.append(this.repertoireTraficAnnuel);
			builder.append(", ");
		}
		if (this.repertoireFichiersOriginaux != null) {
			builder.append("repertoireFichiersOriginaux=");
			builder.append(this.repertoireFichiersOriginaux);
			builder.append(", ");
		}
		if (this.repertoireFichiersOriginauxANSI != null) {
			builder.append("repertoireFichiersOriginauxANSI=");
			builder.append(this.repertoireFichiersOriginauxANSI);
			builder.append(", ");
		}
		if (this.repertoireFichiersOriginauxANSIcsv != null) {
			builder.append("repertoireFichiersOriginauxANSIcsv=");
			builder.append(this.repertoireFichiersOriginauxANSIcsv);
			builder.append(", ");
		}
		if (this.repertoireFichiersOriginauxUTF8 != null) {
			builder.append("repertoireFichiersOriginauxUTF8=");
			builder.append(this.repertoireFichiersOriginauxUTF8);
			builder.append(", ");
		}
		if (this.repertoireFichiersOriginauxUTF8csv != null) {
			builder.append("repertoireFichiersOriginauxUTF8csv=");
			builder.append(this.repertoireFichiersOriginauxUTF8csv);
			builder.append(", ");
		}
		if (this.repertoireFichiersNettoyesUTF8 != null) {
			builder.append("repertoireFichiersNettoyesUTF8=");
			builder.append(this.repertoireFichiersNettoyesUTF8);
			builder.append(", ");
		}
		if (this.repertoireFichiersNettoyesUTF8csv != null) {
			builder.append("repertoireFichiersNettoyesUTF8csv=");
			builder.append(this.repertoireFichiersNettoyesUTF8csv);
			builder.append(", ");
		}
		if (this.repertoireFichiersReponseLocalisationUTF8 != null) {
			builder.append("repertoireFichiersReponseLocalisationUTF8=");
			builder.append(this.repertoireFichiersReponseLocalisationUTF8);
			builder.append(", ");
		}
		if (this.repertoireAnnee != null) {
			builder.append("repertoireAnnee=");
			builder.append(this.repertoireAnnee);
			builder.append(", ");
		}
		if (this.repertoireDARWIN != null) {
			builder.append("repertoireDARWIN=");
			builder.append(this.repertoireDARWIN);
			builder.append(", ");
		}
		if (this.repertoireDIRA != null) {
			builder.append("repertoireDIRA=");
			builder.append(this.repertoireDIRA);
			builder.append(", ");
		}
		if (this.repertoireDIRCE != null) {
			builder.append("repertoireDIRCE=");
			builder.append(this.repertoireDIRCE);
			builder.append(", ");
		}
		if (this.repertoireDIRCO != null) {
			builder.append("repertoireDIRCO=");
			builder.append(this.repertoireDIRCO);
			builder.append(", ");
		}
		if (this.repertoireDIRE != null) {
			builder.append("repertoireDIRE=");
			builder.append(this.repertoireDIRE);
			builder.append(", ");
		}
		if (this.repertoireDIRIF != null) {
			builder.append("repertoireDIRIF=");
			builder.append(this.repertoireDIRIF);
			builder.append(", ");
		}
		if (this.repertoireDIRMC != null) {
			builder.append("repertoireDIRMC=");
			builder.append(this.repertoireDIRMC);
			builder.append(", ");
		}
		if (this.repertoireDIRMED != null) {
			builder.append("repertoireDIRMED=");
			builder.append(this.repertoireDIRMED);
			builder.append(", ");
		}
		if (this.repertoireDIRN != null) {
			builder.append("repertoireDIRN=");
			builder.append(this.repertoireDIRN);
			builder.append(", ");
		}
		if (this.repertoireDIRNO != null) {
			builder.append("repertoireDIRNO=");
			builder.append(this.repertoireDIRNO);
			builder.append(", ");
		}
		if (this.repertoireDIRO != null) {
			builder.append("repertoireDIRO=");
			builder.append(this.repertoireDIRO);
			builder.append(", ");
		}
		if (this.repertoireDIRSO != null) {
			builder.append("repertoireDIRSO=");
			builder.append(this.repertoireDIRSO);
			builder.append(", ");
		}
		if (this.repertoireEntree != null) {
			builder.append("repertoireEntree=");
			builder.append(this.repertoireEntree);
			builder.append(", ");
		}
		if (this.repertoireEntreeDarwin != null) {
			builder.append("repertoireEntreeDarwin=");
			builder.append(this.repertoireEntreeDarwin);
			builder.append(", ");
		}
		if (this.repertoireEntreeDarwinANSI != null) {
			builder.append("repertoireEntreeDarwinANSI=");
			builder.append(this.repertoireEntreeDarwinANSI);
			builder.append(", ");
		}
		if (this.repertoireEntreeDarwinUTF8 != null) {
			builder.append("repertoireEntreeDarwinUTF8=");
			builder.append(this.repertoireEntreeDarwinUTF8);
			builder.append(", ");
		}
		if (this.repertoireEntreeDarwinOriginal != null) {
			builder.append("repertoireEntreeDarwinOriginal=");
			builder.append(this.repertoireEntreeDarwinOriginal);
			builder.append(", ");
		}
		if (this.repertoireEntreeHit != null) {
			builder.append("repertoireEntreeHit=");
			builder.append(this.repertoireEntreeHit);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitANSI != null) {
			builder.append("repertoireEntreeHitANSI=");
			builder.append(this.repertoireEntreeHitANSI);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitANSIAscii != null) {
			builder.append("repertoireEntreeHitANSIAscii=");
			builder.append(this.repertoireEntreeHitANSIAscii);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitANSICsv != null) {
			builder.append("repertoireEntreeHitANSICsv=");
			builder.append(this.repertoireEntreeHitANSICsv);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitANSIFeorXML != null) {
			builder.append("repertoireEntreeHitANSIFeorXML=");
			builder.append(this.repertoireEntreeHitANSIFeorXML);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitUTF8 != null) {
			builder.append("repertoireEntreeHitUTF8=");
			builder.append(this.repertoireEntreeHitUTF8);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitUTF8Ascii != null) {
			builder.append("repertoireEntreeHitUTF8Ascii=");
			builder.append(this.repertoireEntreeHitUTF8Ascii);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitUTF8Csv != null) {
			builder.append("repertoireEntreeHitUTF8Csv=");
			builder.append(this.repertoireEntreeHitUTF8Csv);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitUTF8FeorXML != null) {
			builder.append("repertoireEntreeHitUTF8FeorXML=");
			builder.append(this.repertoireEntreeHitUTF8FeorXML);
			builder.append(", ");
		}
		if (this.repertoireEntreeHitOriginal != null) {
			builder.append("repertoireEntreeHitOriginal=");
			builder.append(this.repertoireEntreeHitOriginal);
			builder.append(", ");
		}
		if (this.repertoireSortie != null) {
			builder.append("repertoireSortie=");
			builder.append(this.repertoireSortie);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07 != null) {
			builder.append("repertoireSortieHistonatF07=");
			builder.append(this.repertoireSortieHistonatF07);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07Ascii != null) {
			builder.append("repertoireSortieHistonatF07Ascii=");
			builder.append(this.repertoireSortieHistonatF07Ascii);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07AsciiANSI != null) {
			builder.append("repertoireSortieHistonatF07AsciiANSI=");
			builder.append(this.repertoireSortieHistonatF07AsciiANSI);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07AsciiUTF8 != null) {
			builder.append("repertoireSortieHistonatF07AsciiUTF8=");
			builder.append(this.repertoireSortieHistonatF07AsciiUTF8);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07Csv != null) {
			builder.append("repertoireSortieHistonatF07Csv=");
			builder.append(this.repertoireSortieHistonatF07Csv);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07CsvANSI != null) {
			builder.append("repertoireSortieHistonatF07CsvANSI=");
			builder.append(this.repertoireSortieHistonatF07CsvANSI);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07CsvUTF8 != null) {
			builder.append("repertoireSortieHistonatF07CsvUTF8=");
			builder.append(this.repertoireSortieHistonatF07CsvUTF8);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07FeorXML != null) {
			builder.append("repertoireSortieHistonatF07FeorXML=");
			builder.append(this.repertoireSortieHistonatF07FeorXML);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07FeorXMLANSI != null) {
			builder.append("repertoireSortieHistonatF07FeorXMLANSI=");
			builder.append(this.repertoireSortieHistonatF07FeorXMLANSI);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF07FeorXMLUTF8 != null) {
			builder.append("repertoireSortieHistonatF07FeorXMLUTF8=");
			builder.append(this.repertoireSortieHistonatF07FeorXMLUTF8);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF08 != null) {
			builder.append("repertoireSortieHistonatF08=");
			builder.append(this.repertoireSortieHistonatF08);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF08Ascii != null) {
			builder.append("repertoireSortieHistonatF08Ascii=");
			builder.append(this.repertoireSortieHistonatF08Ascii);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF08AsciiANSI != null) {
			builder.append("repertoireSortieHistonatF08AsciiANSI=");
			builder.append(this.repertoireSortieHistonatF08AsciiANSI);
			builder.append(", ");
		}
		if (this.repertoireSortieHistonatF08AsciiUTF8 != null) {
			builder.append("repertoireSortieHistonatF08AsciiUTF8=");
			builder.append(this.repertoireSortieHistonatF08AsciiUTF8);
		}
		
		builder.append(']');
		
		return builder.toString();
		
	} // Fin de toString().________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toStringFormate() {
		
		/* retourne null si this.rootFile == null. */
		if (this.rootFile == null) {
			return null;
		}
		
		/* retourne null si this.anneeExploitation == null. */
		if (this.anneeExploitation == null) {
			return null;
		}
		
		final StringBuffer stb = new StringBuffer();
		
		stb.append("RACINE : ");
		stb.append(this.rootFile.getAbsolutePath());
		stb.append(SAUT_LIGNE_JAVA);
		
		stb.append("ANNEE D'EXPLOITATION : ");
		stb.append(this.anneeExploitation);
		stb.append(SAUT_LIGNE_JAVA);
		
		if (this.repertoireTraficAnnuel != null) {
			stb.append("REPERTOIRE TRAFIC ANNUEL : ");
			stb.append(this.repertoireTraficAnnuel.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireFichiersOriginaux!= null) {
			stb.append(TAB);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS ORIGINAUX : ");
			stb.append(this.repertoireFichiersOriginaux.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireFichiersOriginauxANSI != null) {
			stb.append(TAB);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS ORIGINAUX ANSI : ");
			stb.append(this.repertoireFichiersOriginauxANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireFichiersOriginauxANSIcsv != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS ORIGINAUX ANSI en CSV : ");
			stb.append(this.repertoireFichiersOriginauxANSIcsv.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}

		if (this.repertoireFichiersOriginauxUTF8 != null) {
			stb.append(TAB);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS ORIGINAUX UTF8 : ");
			stb.append(this.repertoireFichiersOriginauxUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}

		if (this.repertoireFichiersOriginauxUTF8csv != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS ORIGINAUX UTF8 en CSV : ");
			stb.append(this.repertoireFichiersOriginauxUTF8csv.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireFichiersNettoyesUTF8 != null) {
			stb.append(TAB);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS NETTOYES UTF8 : ");
			stb.append(this.repertoireFichiersNettoyesUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireFichiersNettoyesUTF8csv != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS NETTOYES UTF8 en CSV : ");
			stb.append(this.repertoireFichiersNettoyesUTF8csv.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireFichiersReponseLocalisationUTF8 != null) {
			stb.append(TAB);
			stb.append("REPERTOIRE TRAFIC ANNUEL/FICHIERS REPONSE ISIDOR UTF8 : ");
			stb.append(this.repertoireFichiersReponseLocalisationUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireAnnee != null) {
			stb.append(TAB);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE : ");
			stb.append(this.repertoireAnnee.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDARWIN != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DARWIN : ");
			stb.append(this.repertoireDARWIN.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRA != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRA : ");
			stb.append(this.repertoireDIRA.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRCE != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRCE : ");
			stb.append(this.repertoireDIRCE.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRCO != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRCO : ");
			stb.append(this.repertoireDIRCO.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRE != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRE : ");
			stb.append(this.repertoireDIRE.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRIF != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRIF : ");
			stb.append(this.repertoireDIRIF.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRMC != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRMC : ");
			stb.append(this.repertoireDIRMC.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRMED != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRMED : ");
			stb.append(this.repertoireDIRMED.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}

		if (this.repertoireDIRN != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRN : ");
			stb.append(this.repertoireDIRN.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRNO != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRNO : ");
			stb.append(this.repertoireDIRNO.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}

		if (this.repertoireDIRO != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRO : ");
			stb.append(this.repertoireDIRO.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireDIRSO != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/DIRSO : ");
			stb.append(this.repertoireDIRSO.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntree != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree : ");
			stb.append(this.repertoireEntree.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}

		if (this.repertoireEntreeDarwin != null) {
			stb.append(TAB3);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Darwin : ");
			stb.append(this.repertoireEntreeDarwin.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeDarwinANSI != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Darwin/ANSI : ");
			stb.append(this.repertoireEntreeDarwinANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeDarwinUTF8 != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Darwin/UTF8 : ");
			stb.append(this.repertoireEntreeDarwinUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeDarwinOriginal != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Darwin/Original : ");
			stb.append(this.repertoireEntreeDarwinOriginal.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHit != null) {
			stb.append(TAB3);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit : ");
			stb.append(this.repertoireEntreeHit.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitANSI != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/ANSI : ");
			stb.append(this.repertoireEntreeHitANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitANSIAscii != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/ANSI/Ascii : ");
			stb.append(this.repertoireEntreeHitANSIAscii.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitANSICsv != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/ANSI/Csv : ");
			stb.append(this.repertoireEntreeHitANSICsv.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitANSIFeorXML != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/ANSI/FeorXML : ");
			stb.append(this.repertoireEntreeHitANSIFeorXML.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitUTF8 != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/UTF8 : ");
			stb.append(this.repertoireEntreeHitUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitUTF8Ascii != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/UTF8/Ascii : ");
			stb.append(this.repertoireEntreeHitUTF8Ascii.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitUTF8Csv != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/UTF8/Csv : ");
			stb.append(this.repertoireEntreeHitUTF8Csv.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitUTF8FeorXML != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/UTF8/FeorXML : ");
			stb.append(this.repertoireEntreeHitUTF8FeorXML.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireEntreeHitOriginal != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Entree/Hit/Originaux : ");
			stb.append(this.repertoireEntreeHitOriginal.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortie != null) {
			stb.append(TAB2);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie : ");
			stb.append(this.repertoireSortie.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07 != null) {
			stb.append(TAB3);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07 : ");
			stb.append(this.repertoireSortieHistonatF07.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07Ascii != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/Ascii : ");
			stb.append(this.repertoireSortieHistonatF07Ascii.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07AsciiANSI != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/Ascii/ANSI : ");
			stb.append(this.repertoireSortieHistonatF07AsciiANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07AsciiUTF8 != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/Ascii/UTF8 : ");
			stb.append(this.repertoireSortieHistonatF07AsciiUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
				
		if (this.repertoireSortieHistonatF07Csv != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/Csv : ");
			stb.append(this.repertoireSortieHistonatF07Csv.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07CsvANSI != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/Csv/ANSI : ");
			stb.append(this.repertoireSortieHistonatF07CsvANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07CsvUTF8 != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/Csv/UTF8 : ");
			stb.append(this.repertoireSortieHistonatF07CsvUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07FeorXML != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/FeorXML : ");
			stb.append(this.repertoireSortieHistonatF07FeorXML.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF07FeorXMLANSI != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/FeorXML/ANSI : ");
			stb.append(this.repertoireSortieHistonatF07FeorXMLANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}

		if (this.repertoireSortieHistonatF07FeorXMLUTF8 != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF07/FeorXML/UTF8 : ");
			stb.append(this.repertoireSortieHistonatF07FeorXMLUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF08 != null) {
			stb.append(TAB3);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF08 : ");
			stb.append(this.repertoireSortieHistonatF08.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF08Ascii != null) {
			stb.append(TAB4);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF08/Ascii : ");
			stb.append(this.repertoireSortieHistonatF08Ascii.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF08AsciiANSI != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF08/Ascii/ANSI : ");
			stb.append(this.repertoireSortieHistonatF08AsciiANSI.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		if (this.repertoireSortieHistonatF08AsciiUTF8 != null) {
			stb.append(TAB5);
			stb.append("REPERTOIRE TRAFIC ANNUEL/ANNEE/Sortie/HistonatF08/Ascii/UTF8 : ");
			stb.append(this.repertoireSortieHistonatF08AsciiUTF8.getAbsolutePath());
			stb.append(SAUT_LIGNE_JAVA);
		}
		
		return stb.toString();
		
	} // Fin de toStringFormate()._________________________________________
	
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getEnTeteCsv() {
		
		return "id;racine;anneeExploitation;"
				+ "repertoireTraficAnnuel;"
				+ "repertoireFichiersOriginaux;"
				+ "repertoireFichiersOriginauxANSI;repertoireFichiersOriginauxANSIcsv;"
				+ "repertoireFichiersOriginauxUTF8;repertoireFichiersOriginauxUTF8csv;"
				+ "repertoireFichiersNettoyesUTF8;repertoireFichiersNettoyesUTF8csv;"
				+ "repertoireFichiersReponseLocalisationUTF8;"
				+ "repertoireAnnee;"
				+ "repertoireDARWIN;repertoireDIRA;repertoireDIRCE;repertoireDIRCO;"
				+ "repertoireDIRE;repertoireDIRIF;repertoireDIRMC;repertoireDIRMED;"
				+ "repertoireDIRN;repertoireDIRNO;repertoireDIRO;repertoireDIRSO;"
				+ "repertoireEntree;"
				+ "repertoireEntreeDarwin;"
				+ "repertoireEntreeDarwinANSI;repertoireEntreeDarwinUTF8;repertoireEntreeDarwinOriginal;"
				+ "repertoireEntreeHit;"
				+ "repertoireEntreeHitANSI;"
				+ "repertoireEntreeHitANSIAscii;repertoireEntreeHitANSICsv;repertoireEntreeHitANSIFeorXML;"
				+ "repertoireEntreeHitUTF8;"
				+ "repertoireEntreeHitUTF8Ascii;repertoireEntreeHitUTF8Csv;repertoireEntreeHitUTF8FeorXML;"
				+ "repertoireEntreeHitOriginal;"
				+ "repertoireSortie;"
				+ "repertoireSortieHistonatF07;"
				+ "repertoireSortieHistonatF07Ascii;"
				+ "repertoireSortieHistonatF07AsciiANSI;repertoireSortieHistonatF07AsciiUTF8;"
				+ "repertoireSortieHistonatF07Csv;"
				+ "repertoireSortieHistonatF07CsvANSI;repertoireSortieHistonatF07CsvUTF8;"
				+ "repertoireSortieHistonatF07FeorXML;"
				+ "repertoireSortieHistonatF07FeorXMLANSI;repertoireSortieHistonatF07FeorXMLUTF8;"
				+ "repertoireSortieHistonatF08;"
				+ "repertoireSortieHistonatF08Ascii;"
				+ "repertoireSortieHistonatF08AsciiANSI;repertoireSortieHistonatF08AsciiUTF8;";
		
	} // Fin de getEnTeteCsv().____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String toStringCsv() {
		
		final StringBuilder stb = new StringBuilder();

		
		return stb.toString();
		
	} // Fin de toStringCsv()._____________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getEnTeteColonne(
			final int pI) {
		
		String entete = null;

		switch (pI) {

		case 0:
			entete = "id";
			break;

		case 1:
			entete = "racine";
			break;

		case 2:
			entete = "année d'exploitation";
			break;
			
		default:
			entete = "invalide";
			break;

		} // Fin du Switch._________________________________

		return entete;

	} // Fin de getEnTeteColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public final Object getValeurColonne(
			final int pI) {
		
		Object valeur = null;

		switch (pI) {

		case 0:
			valeur = this.getId();
			break;
			
		case 1:
			valeur = this.getRootFile().getAbsolutePath();
			break;
			
		case 2:
			valeur = this.getAnneeExploitation();
			break;

		default:
			valeur = "invalide";
			break;

		} // Fin du Switch._________________________________

		return valeur;

	} // Fin de getValeurColonne(...)._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {	
		return this.id;
	} // Fin de getId().___________________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(
			final Long pId) {	
		this.id = pId;
	} // Fin de setId(...).________________________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRootFile() {
		return this.rootFile;
	} // Fin de getRootFile()._____________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRootFile(
			final File pRootFile) {
		this.rootFile = pRootFile;
	} // Fin de setRootFile(...).__________________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAnneeExploitation() {
		return this.anneeExploitation;
	} // Fin de getAnneeExploitation().____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAnneeExploitation(
			final String pAnneeExploitation) {
		this.anneeExploitation = pAnneeExploitation;
	} // Fin de setAnneeExploitation(...)._________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireTraficAnnuel() {
		return this.repertoireTraficAnnuel;
	} // Fin de getRepertoireTraficAnnuel()._______________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireTraficAnnuel(
			final File pRepertoireTraficAnnuel) {
		this.repertoireTraficAnnuel = pRepertoireTraficAnnuel;
	} // Fin de setRepertoireTraficAnnuel(...).____________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersOriginaux() {
		return this.repertoireFichiersOriginaux;
	} // Fin de getRepertoireFichiersOriginaux().__________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersOriginaux(
			final File pRepertoireFichiersOriginaux) {
		this.repertoireFichiersOriginaux = pRepertoireFichiersOriginaux;
	} // Fin de setRepertoireFichiersOriginaux(...)._______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersOriginauxANSI() {
		return this.repertoireFichiersOriginauxANSI;
	} // Fin de getRepertoireFichiersOriginauxANSI().______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersOriginauxANSI(
			final File pRepertoireFichiersOriginauxANSI) {
		this.repertoireFichiersOriginauxANSI 
			= pRepertoireFichiersOriginauxANSI;
	} // Fin de setRepertoireFichiersOriginauxANSI(...).___________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersOriginauxANSIcsv() {
		return this.repertoireFichiersOriginauxANSIcsv;
	} // Fin de getRepertoireFichiersOriginauxANSIcsv().___________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersOriginauxANSIcsv(
			final File pRepertoireFichiersOriginauxANSIcsv) {
		this.repertoireFichiersOriginauxANSIcsv 
			= pRepertoireFichiersOriginauxANSIcsv;
	} // Fin de setRepertoireFichiersOriginauxANSIcsv(...).________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersOriginauxUTF8() {
		return this.repertoireFichiersOriginauxUTF8;
	} // Fin de getRepertoireFichiersOriginauxUTF8().______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersOriginauxUTF8(
			final File pRepertoireFichiersOriginauxUTF8) {
		this.repertoireFichiersOriginauxUTF8 
			= pRepertoireFichiersOriginauxUTF8;
	} // Fin de setRepertoireFichiersOriginauxUTF8(...).___________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersOriginauxUTF8csv() {
		return this.repertoireFichiersOriginauxUTF8csv;
	} // Fin de getRepertoireFichiersOriginauxUTF8csv().___________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersOriginauxUTF8csv(
			final File pRepertoireFichiersOriginauxUTF8csv) {
		this.repertoireFichiersOriginauxUTF8csv 
			= pRepertoireFichiersOriginauxUTF8csv;
	} // Fin de setRepertoireFichiersOriginauxUTF8csv(...).________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersNettoyesUTF8() {
		return this.repertoireFichiersNettoyesUTF8;
	} // Fin de getRepertoireFichiersNettoyesUTF8()._______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersNettoyesUTF8(
			final File pRepertoireFichiersNettoyesUTF8) {
		this.repertoireFichiersNettoyesUTF8 
			= pRepertoireFichiersNettoyesUTF8;
	} // Fin de setRepertoireFichiersNettoyesUTF8(...).____________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersNettoyesUTF8csv() {
		return this.repertoireFichiersNettoyesUTF8csv;
	} // Fin de getRepertoireFichiersNettoyesUTF8csv().____________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersNettoyesUTF8csv(
			final File pRepertoireFichiersNettoyesUTF8csv) {
		this.repertoireFichiersNettoyesUTF8csv 
			= pRepertoireFichiersNettoyesUTF8csv;
	} // Fin de setRepertoireFichiersNettoyesUTF8csv(...)._________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireFichiersReponseLocalisationUTF8() {
		return this.repertoireFichiersReponseLocalisationUTF8;
	} // Fin de getRepertoireFichiersReponseLocalisationUTF8().____________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireFichiersReponseLocalisationUTF8(
			final File pRepertoireFichiersReponseLocalisationUTF8) {
		this.repertoireFichiersReponseLocalisationUTF8 
			= pRepertoireFichiersReponseLocalisationUTF8;
	} // Fin de setRepertoireFichiersReponseLocalisationUTF8(...)._________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireAnnee() {
		return this.repertoireAnnee;
	} // Fin de getRepertoireAnnee().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireAnnee(
			final File pRepertoireAnnee) {
		this.repertoireAnnee = pRepertoireAnnee;
	} // Fin de setRepertoireAnnee(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDARWIN() {
		return this.repertoireDARWIN;
	} // Fin de getRepertoireDARWIN()._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDARWIN(
			final File pRepertoireDARWIN) {
		this.repertoireDARWIN = pRepertoireDARWIN;
	} // Fin de setRepertoireDARWIN(...).__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRA() {
		return this.repertoireDIRA;
	} // Fin de getRepertoireDIRA()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRA(
			final File pRepertoireDIRA) {
		this.repertoireDIRA = pRepertoireDIRA;
	} // Fin de setRepertoireDIRA(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRCE() {
		return this.repertoireDIRCE;
	} // Fin de getRepertoireDIRCE().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRCE(
			final File pRepertoireDIRCE) {
		this.repertoireDIRCE = pRepertoireDIRCE;
	} // Fin de setRepertoireDIRCE(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRCO() {
		return this.repertoireDIRCO;
	} // Fin de getRepertoireDIRCO().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRCO(
			final File pRepertoireDIRCO) {
		this.repertoireDIRCO = pRepertoireDIRCO;
	} // Fin de setRepertoireDIRCO(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRE() {
		return this.repertoireDIRE;
	} // Fin de getRepertoireDIRE()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRE(
			final File pRepertoireDIRE) {
		this.repertoireDIRE = pRepertoireDIRE;
	} // Fin de setRepertoireDIRE(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRIF() {
		return this.repertoireDIRIF;
	} // Fin de getRepertoireDIRIF().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRIF(
			final File pRepertoireDIRIF) {
		this.repertoireDIRIF = pRepertoireDIRIF;
	} // Fin de setRepertoireDIRIF(...).___________________________________

	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRMC() {
		return this.repertoireDIRMC;
	} // Fin de getRepertoireDIRMC().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRMC(
			final File pRepertoireDIRMC) {
		this.repertoireDIRMC = pRepertoireDIRMC;
	} // Fin de setRepertoireDIRMC(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRMED() {
		return this.repertoireDIRMED;
	} // Fin de getRepertoireDIRMED()._____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRMED(
			final File pRepertoireDIRMED) {
		this.repertoireDIRMED = pRepertoireDIRMED;
	} // Fin de setRepertoireDIRMED(...).__________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRN() {
		return this.repertoireDIRN;
	} // Fin de getRepertoireDIRN()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRN(
			final File pRepertoireDIRN) {
		this.repertoireDIRN = pRepertoireDIRN;
	} // Fin de setRepertoireDIRN(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRNO() {
		return this.repertoireDIRNO;
	} // Fin de getRepertoireDIRNO().______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRNO(
			final File pRepertoireDIRNO) {
		this.repertoireDIRNO = pRepertoireDIRNO;
	} // Fin de setRepertoireDIRNO(...).___________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRO() {
		return this.repertoireDIRO;
	} // Fin de getRepertoireDIRO()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRO(
			final File pRepertoireDIRO) {
		this.repertoireDIRO = pRepertoireDIRO;
	} // Fin de setRepertoireDIRO(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireDIRSO() {
		return this.repertoireDIRSO;
	} // Fin de getRepertoireDIRSO()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireDIRSO(
			final File pRepertoireDIRSO) {
		this.repertoireDIRSO = pRepertoireDIRSO;
	} // Fin de setRepertoireDIRSO(...).____________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntree() {
		return this.repertoireEntree;
	} // Fin de getRepertoireEntree()._______________________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntree(
			final File pRepertoireEntree) {
		this.repertoireEntree = pRepertoireEntree;
	} // Fin de setRepertoireEntree(...).____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeDarwin() {
		return this.repertoireEntreeDarwin;
	} // Fin de getRepertoireEntreeDarwin()._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeDarwin(
			final File pRepertoireEntreeDarwin) {
		this.repertoireEntreeDarwin = pRepertoireEntreeDarwin;
	} // Fin de setRepertoireEntreeDarwin(...).____________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeDarwinANSI() {
		return this.repertoireEntreeDarwinANSI;
	} // Fin de getRepertoireEntreeDarwinANSI().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeDarwinANSI(
			final File pRepertoireEntreeDarwinANSI) {
		this.repertoireEntreeDarwinANSI = pRepertoireEntreeDarwinANSI;
	} // Fin de setRepertoireEntreeDarwinANSI(...).________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeDarwinUTF8() {
		return this.repertoireEntreeDarwinUTF8;
	} // Fin de getRepertoireEntreeDarwinUTF8().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeDarwinUTF8(
			final File pRepertoireEntreeDarwinUTF8) {
		this.repertoireEntreeDarwinUTF8 = pRepertoireEntreeDarwinUTF8;
	} // Fin de setRepertoireEntreeDarwinUTF8(...).________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeDarwinOriginal() {
		return this.repertoireEntreeDarwinOriginal;
	} // Fin de getRepertoireEntreeDarwinOriginal()._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeDarwinOriginal(
			final File pRepertoireEntreeDarwinOriginal) {
		this.repertoireEntreeDarwinOriginal 
			= pRepertoireEntreeDarwinOriginal;
	} // Fin de setRepertoireEntreeDarwinOriginal(...).____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHit() {
		return this.repertoireEntreeHit;
	} // Fin de getRepertoireEntreeHit().__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHit(
			final File pRepertoireEntreeHit) {
		this.repertoireEntreeHit = pRepertoireEntreeHit;
	} // Fin de setRepertoireEntreeHit(...)._______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitANSI() {
		return this.repertoireEntreeHitANSI;
	} // Fin de getRepertoireEntreeHitANSI().______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitANSI(
			final File pRepertoireEntreeHitANSI) {
		this.repertoireEntreeHitANSI = pRepertoireEntreeHitANSI;
	} // Fin de setRepertoireEntreeHitANSI(...).___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitANSIAscii() {
		return this.repertoireEntreeHitANSIAscii;
	} // Fin de getRepertoireEntreeHitANSIAscii()._________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitANSIAscii(
			final File pRepertoireEntreeHitANSIAscii) {
		this.repertoireEntreeHitANSIAscii = pRepertoireEntreeHitANSIAscii;
	} // Fin de setRepertoireEntreeHitANSIAscii(...).______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitANSICsv() {
		return this.repertoireEntreeHitANSICsv;
	} // Fin de getRepertoireEntreeHitANSICsv().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitANSICsv(
			final File pRepertoireEntreeHitANSICsv) {
		this.repertoireEntreeHitANSICsv = pRepertoireEntreeHitANSICsv;
	} // Fin de setRepertoireEntreeHitANSICsv(...).________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitANSIFeorXML() {
		return this.repertoireEntreeHitANSIFeorXML;
	} // Fin de getRepertoireEntreeHitANSIFeorXML()._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitANSIFeorXML(
			final File pRepertoireEntreeHitANSIFeorXML) {
		this.repertoireEntreeHitANSIFeorXML = pRepertoireEntreeHitANSIFeorXML;
	} // Fin de setRepertoireEntreeHitANSIFeorXML(...).____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitUTF8() {
		return this.repertoireEntreeHitUTF8;
	} // Fin de getRepertoireEntreeHitUTF8().______________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitUTF8(
			final File pRepertoireEntreeHitUTF8) {
		this.repertoireEntreeHitUTF8 = pRepertoireEntreeHitUTF8;
	} // Fin de setRepertoireEntreeHitUTF8(...).___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitUTF8Ascii() {
		return this.repertoireEntreeHitUTF8Ascii;
	} // Fin de getRepertoireEntreeHitUTF8Ascii()._________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitUTF8Ascii(
			final File pRepertoireEntreeHitUTF8Ascii) {
		this.repertoireEntreeHitUTF8Ascii = pRepertoireEntreeHitUTF8Ascii;
	} // Fin de setRepertoireEntreeHitUTF8Ascii(...).______________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitUTF8Csv() {
		return this.repertoireEntreeHitUTF8Csv;
	} // Fin de getRepertoireEntreeHitUTF8Csv().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitUTF8Csv(
			final File pRepertoireEntreeHitUTF8Csv) {
		this.repertoireEntreeHitUTF8Csv = pRepertoireEntreeHitUTF8Csv;
	} // Fin de setRepertoireEntreeHitUTF8Csv(...).________________________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitUTF8FeorXML() {
		return this.repertoireEntreeHitUTF8FeorXML;
	} // Fin de getRepertoireEntreeHitUTF8FeorXML().___________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitUTF8FeorXML(
			final File pRepertoireEntreeHitUTF8FeorXML) {
		this.repertoireEntreeHitUTF8FeorXML = pRepertoireEntreeHitUTF8FeorXML;
	} // Fin de setRepertoireEntreeHitUTF8FeorXML(...).________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireEntreeHitOriginal() {
		return this.repertoireEntreeHitOriginal;
	} // Fin de getRepertoireEntreeHitOriginal().__________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireEntreeHitOriginal(
			final File pRepertoireEntreeHitOriginal) {
		this.repertoireEntreeHitOriginal = pRepertoireEntreeHitOriginal;
	} // Fin de setRepertoireEntreeHitOriginal(...)._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortie() {
		return this.repertoireSortie;
	} // Fin de getRepertoireSortie()._____________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortie(
			final File pRepertoireSortie) {
		this.repertoireSortie = pRepertoireSortie;
	} // Fin de setRepertoireSortie(...).__________________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07() {
		return this.repertoireSortieHistonatF07;
	} // Fin de getRepertoireSortieHistonatF07().__________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07(
			final File pRepertoireSortieHistonatF07) {
		this.repertoireSortieHistonatF07 = pRepertoireSortieHistonatF07;
	} // Fin de setRepertoireSortieHistonatF07(...)._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07Ascii() {
		return this.repertoireSortieHistonatF07Ascii;
	} // Fin de getRepertoireSortieHistonatF07Ascii()._____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07Ascii(
			final File pRepertoireSortieHistonatF07Ascii) {
		this.repertoireSortieHistonatF07Ascii 
			= pRepertoireSortieHistonatF07Ascii;
	} // Fin de setRepertoireSortieHistonatF07Ascii(...).__________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07AsciiANSI() {
		return this.repertoireSortieHistonatF07AsciiANSI;
	} // Fin de getRepertoireSortieHistonatF07AsciiANSI()._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07AsciiANSI(
			final File pRepertoireSortieHistonatF07AsciiANSI) {
		this.repertoireSortieHistonatF07AsciiANSI 
			= pRepertoireSortieHistonatF07AsciiANSI;
	} // Fin de setRepertoireSortieHistonatF07AsciiANSI(...).______________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07AsciiUTF8() {
		return this.repertoireSortieHistonatF07AsciiUTF8;
	} // Fin de getRepertoireSortieHistonatF07AsciiUTF8()._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07AsciiUTF8(
			final File pRepertoireSortieHistonatF07AsciiUTF8) {
		this.repertoireSortieHistonatF07AsciiUTF8 
			= pRepertoireSortieHistonatF07AsciiUTF8;
	} // Fin de setRepertoireSortieHistonatF07AsciiUTF8(...).______________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07Csv() {
		return this.repertoireSortieHistonatF07Csv;
	} // Fin de getRepertoireSortieHistonatF07Csv()._____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07Csv(
			final File pRepertoireSortieHistonatF07Csv) {
		this.repertoireSortieHistonatF07Csv 
			= pRepertoireSortieHistonatF07Csv;
	} // Fin de setRepertoireSortieHistonatF07Csv(...).__________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07CsvANSI() {
		return this.repertoireSortieHistonatF07CsvANSI;
	} // Fin de getRepertoireSortieHistonatF07CsvANSI()._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07CsvANSI(
			final File pRepertoireSortieHistonatF07CsvANSI) {
		this.repertoireSortieHistonatF07CsvANSI 
			= pRepertoireSortieHistonatF07CsvANSI;
	} // Fin de setRepertoireSortieHistonatF07CsvANSI(...).______________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07CsvUTF8() {
		return this.repertoireSortieHistonatF07CsvUTF8;
	} // Fin de getRepertoireSortieHistonatF07CsvUTF8()._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07CsvUTF8(
			final File pRepertoireSortieHistonatF07CsvUTF8) {
		this.repertoireSortieHistonatF07CsvUTF8 
			= pRepertoireSortieHistonatF07CsvUTF8;
	} // Fin de setRepertoireSortieHistonatF07CsvUTF8(...).______________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07FeorXML() {
		return this.repertoireSortieHistonatF07FeorXML;
	} // Fin de getRepertoireSortieHistonatF07FeorXML().___________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07FeorXML(
			final File pRepertoireSortieHistonatF07FeorXML) {
		this.repertoireSortieHistonatF07FeorXML 
			= pRepertoireSortieHistonatF07FeorXML;
	} // Fin de setRepertoireSortieHistonatF07FeorXML(...).________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07FeorXMLANSI() {
		return this.repertoireSortieHistonatF07FeorXMLANSI;
	} // Fin de getRepertoireSortieHistonatF07FeorXMLANSI()._______________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07FeorXMLANSI(
			final File pRepertoireSortieHistonatF07FeorXMLANSI) {
		this.repertoireSortieHistonatF07FeorXMLANSI 
			= pRepertoireSortieHistonatF07FeorXMLANSI;
	} // Fin de setRepertoireSortieHistonatF07FeorXMLANSI(...).____________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF07FeorXMLUTF8() {
		return this.repertoireSortieHistonatF07FeorXMLUTF8;
	} // Fin de getRepertoireSortieHistonatF07FeorXMLUTF8()._______________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF07FeorXMLUTF8(
			final File pRepertoireSortieHistonatF07FeorXMLUTF8) {
		this.repertoireSortieHistonatF07FeorXMLUTF8 
			= pRepertoireSortieHistonatF07FeorXMLUTF8;
	} // Fin de setRepertoireSortieHistonatF07FeorXMLUTF8(...).____________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF08() {
		return this.repertoireSortieHistonatF08;
	} // Fin de getRepertoireSortieHistonatF08().__________________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF08(
			final File pRepertoireSortieHistonatF08) {
		this.repertoireSortieHistonatF08 = pRepertoireSortieHistonatF08;
	} // Fin de setRepertoireSortieHistonatF08(...)._______________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF08Ascii() {
		return this.repertoireSortieHistonatF08Ascii;
	} // Fin de getRepertoireSortieHistonatF08Ascii()._____________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF08Ascii(
			final File pRepertoireSortieHistonatF08Ascii) {
		this.repertoireSortieHistonatF08Ascii 
			= pRepertoireSortieHistonatF08Ascii;
	} // Fin de setRepertoireSortieHistonatF08Ascii(...).__________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF08AsciiANSI() {
		return this.repertoireSortieHistonatF08AsciiANSI;
	} // Fin de getRepertoireSortieHistonatF08AsciiANSI()._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF08AsciiANSI(
			final File pRepertoireSortieHistonatF08AsciiANSI) {
		this.repertoireSortieHistonatF08AsciiANSI 
			= pRepertoireSortieHistonatF08AsciiANSI;
	} // Fin de setRepertoireSortieHistonatF08AsciiANSI(...).______________


	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public File getRepertoireSortieHistonatF08AsciiUTF8() {
		return this.repertoireSortieHistonatF08AsciiUTF8;
	} // Fin de getRepertoireSortieHistonatF08AsciiUTF8()._________________



	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setRepertoireSortieHistonatF08AsciiUTF8(
			final File pRepertoireSortieHistonatF08AsciiUTF8) {
		this.repertoireSortieHistonatF08AsciiUTF8 
			= pRepertoireSortieHistonatF08AsciiUTF8;
	} // Fin de setRepertoireSortieHistonatF08AsciiUTF8(...).______________



} // FIN DE LA CLASSE ArboTrafic.--------------------------------------------
