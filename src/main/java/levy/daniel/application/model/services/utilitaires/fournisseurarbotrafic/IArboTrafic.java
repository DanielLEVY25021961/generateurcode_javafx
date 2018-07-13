/**
 * 
 */
package levy.daniel.application.model.services.utilitaires.fournisseurarbotrafic;

import java.io.File;
import java.io.Serializable;

/**
 * INTERFACE IArboTrafic :<br/>
 * Interface factorisant tous les comportements des ArboTrafic.<br/>
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
 * @author daniel.levy Lévy
 * @version 1.0
 * @since 18 juin 2018
 *
 */
public interface IArboTrafic extends Serializable
			, Comparable<IArboTrafic>
						, IExportateurCsv, IExportateurJTable {


	/**
	 * SAUT_LIGNE_JAVA : char :<br/>
	 * '\n'.<br/>
	 */
	char SAUT_LIGNE_JAVA = '\n';
	
	/**
	 * TAB : String :<br/>
	 * "\t".<br/>
	 */
	String TAB = "\t";
	
	/**
	 * TAB2 : String :<br/>
	 * TAB + TAB.<br/>
	 */
	String TAB2 = TAB + TAB;
	
	/**
	 * TAB3 : String :<br/>
	 * TAB + TAB + TAB.<br/>
	 */
	String TAB3 = TAB + TAB + TAB;
	
	/**
	 * TAB4 : String :<br/>
	 * TAB + TAB + TAB + TAB.<br/>
	 */
	String TAB4 = TAB + TAB + TAB + TAB;
	
	/**
	 * TAB5 : String :<br/>
	 * TAB + TAB + TAB + TAB + TAB.<br/>
	 */
	String TAB5 = TAB + TAB + TAB + TAB + TAB;
	
	
	
	/**
	 * Retourne une String formatée pour l'affichage de l'arborescence.<br/>
	 * <br/>
	 * - retourne null si this.rootFile == null.<br/>
	 * - retourne null si this.anneeExploitation == null.<br/>
	 * <br/>
	 *
	 * @return : String.<br/>
	 */
	String toStringFormate();
	
	
	
	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;racine;anneeExploitation;
	 * repertoireTraficAnnuel;
	 * repertoireFichiersOriginaux;
	 * repertoireFichiersOriginauxANSI;repertoireFichiersOriginauxANSIcsv;
	 * repertoireFichiersOriginauxUTF8;repertoireFichiersOriginauxUTF8csv;
	 * repertoireFichiersNettoyesUTF8;repertoireFichiersNettoyesUTF8csv;
	 * repertoireFichiersReponseLocalisationUTF8;
	 * repertoireAnnee;
	 * repertoireDARWIN;repertoireDIRA;repertoireDIRCE;repertoireDIRCO;
	 * repertoireDIRE;repertoireDIRIF;repertoireDIRMC;repertoireDIRMED;
	 * repertoireDIRN;repertoireDIRNO;repertoireDIRO;repertoireDIRSO;
	 * repertoireEntree;
	 * repertoireEntreeDarwin;
	 * repertoireEntreeDarwinANSI;repertoireEntreeDarwinUTF8;repertoireEntreeDarwinOriginal;
	 * repertoireEntreeHit;
	 * repertoireEntreeHitANSI;
	 * repertoireEntreeHitANSIAscii;repertoireEntreeHitANSICsv;repertoireEntreeHitANSIFeorXML;
	 * repertoireEntreeHitUTF8;
	 * repertoireEntreeHitUTF8Ascii;repertoireEntreeHitUTF8Csv;repertoireEntreeHitUTF8FeorXML;
	 * repertoireEntreeHitOriginal;
	 * repertoireSortie;
	 * repertoireSortieHistonatF07;
	 * repertoireSortieHistonatF07Ascii;
	 * repertoireSortieHistonatF07AsciiANSI;repertoireSortieHistonatF07AsciiUTF8;
	 * repertoireSortieHistonatF07Csv;
	 * repertoireSortieHistonatF07CsvANSI;repertoireSortieHistonatF07CsvUTF8;
	 * repertoireSortieHistonatF07FeorXML;
	 * repertoireSortieHistonatF07FeorXMLANSI;repertoireSortieHistonatF07FeorXMLUTF8;
	 * repertoireSortieHistonatF08;
	 * repertoireSortieHistonatF08Ascii;
	 * repertoireSortieHistonatF08AsciiANSI;repertoireSortieHistonatF08AsciiUTF8;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;racine;anneeExploitation;
	 * repertoireTraficAnnuel;
	 * repertoireFichiersOriginaux;
	 * repertoireFichiersOriginauxANSI;repertoireFichiersOriginauxANSIcsv;
	 * repertoireFichiersOriginauxUTF8;repertoireFichiersOriginauxUTF8csv;
	 * repertoireFichiersNettoyesUTF8;repertoireFichiersNettoyesUTF8csv;
	 * repertoireFichiersReponseLocalisationUTF8;
	 * repertoireAnnee;
	 * repertoireDARWIN;repertoireDIRA;repertoireDIRCE;repertoireDIRCO;
	 * repertoireDIRE;repertoireDIRIF;repertoireDIRMC;repertoireDIRMED;
	 * repertoireDIRN;repertoireDIRNO;repertoireDIRO;repertoireDIRSO;
	 * repertoireEntree;
	 * repertoireEntreeDarwin;
	 * repertoireEntreeDarwinANSI;repertoireEntreeDarwinUTF8;repertoireEntreeDarwinOriginal;
	 * repertoireEntreeHit;
	 * repertoireEntreeHitANSI;
	 * repertoireEntreeHitANSIAscii;repertoireEntreeHitANSICsv;repertoireEntreeHitANSIFeorXML;
	 * repertoireEntreeHitUTF8;
	 * repertoireEntreeHitUTF8Ascii;repertoireEntreeHitUTF8Csv;repertoireEntreeHitUTF8FeorXML;
	 * repertoireEntreeHitOriginal;
	 * repertoireSortie;
	 * repertoireSortieHistonatF07;
	 * repertoireSortieHistonatF07Ascii;
	 * repertoireSortieHistonatF07AsciiANSI;repertoireSortieHistonatF07AsciiUTF8;
	 * repertoireSortieHistonatF07Csv;
	 * repertoireSortieHistonatF07CsvANSI;repertoireSortieHistonatF07CsvUTF8;
	 * repertoireSortieHistonatF07FeorXML;
	 * repertoireSortieHistonatF07FeorXMLANSI;repertoireSortieHistonatF07FeorXMLUTF8;
	 * repertoireSortieHistonatF08;
	 * repertoireSortieHistonatF08Ascii;
	 * repertoireSortieHistonatF08AsciiANSI;repertoireSortieHistonatF08AsciiUTF8;".<br/>
	 * <br/>
	 */
	@Override
	String toStringCsv();



	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;racine;anneeExploitation;
	 * repertoireTraficAnnuel;
	 * repertoireFichiersOriginaux;
	 * repertoireFichiersOriginauxANSI;repertoireFichiersOriginauxANSIcsv;
	 * repertoireFichiersOriginauxUTF8;repertoireFichiersOriginauxUTF8csv;
	 * repertoireFichiersNettoyesUTF8;repertoireFichiersNettoyesUTF8csv;
	 * repertoireFichiersReponseLocalisationUTF8;
	 * repertoireAnnee;
	 * repertoireDARWIN;repertoireDIRA;repertoireDIRCE;repertoireDIRCO;
	 * repertoireDIRE;repertoireDIRIF;repertoireDIRMC;repertoireDIRMED;
	 * repertoireDIRN;repertoireDIRNO;repertoireDIRO;repertoireDIRSO;
	 * repertoireEntree;
	 * repertoireEntreeDarwin;
	 * repertoireEntreeDarwinANSI;repertoireEntreeDarwinUTF8;repertoireEntreeDarwinOriginal;
	 * repertoireEntreeHit;
	 * repertoireEntreeHitANSI;
	 * repertoireEntreeHitANSIAscii;repertoireEntreeHitANSICsv;repertoireEntreeHitANSIFeorXML;
	 * repertoireEntreeHitUTF8;
	 * repertoireEntreeHitUTF8Ascii;repertoireEntreeHitUTF8Csv;repertoireEntreeHitUTF8FeorXML;
	 * repertoireEntreeHitOriginal;
	 * repertoireSortie;
	 * repertoireSortieHistonatF07;
	 * repertoireSortieHistonatF07Ascii;
	 * repertoireSortieHistonatF07AsciiANSI;repertoireSortieHistonatF07AsciiUTF8;
	 * repertoireSortieHistonatF07Csv;
	 * repertoireSortieHistonatF07CsvANSI;repertoireSortieHistonatF07CsvUTF8;
	 * repertoireSortieHistonatF07FeorXML;
	 * repertoireSortieHistonatF07FeorXMLANSI;repertoireSortieHistonatF07FeorXMLUTF8;
	 * repertoireSortieHistonatF08;
	 * repertoireSortieHistonatF08Ascii;
	 * repertoireSortieHistonatF08AsciiANSI;repertoireSortieHistonatF08AsciiUTF8;".<br/>
	 * <br/>
	 */
	@Override
	String getEnTeteColonne(int pI);



	/**
	 * {@inheritDoc}
	 * <br/>
	 * "id;racine;anneeExploitation;
	 * repertoireTraficAnnuel;
	 * repertoireFichiersOriginaux;
	 * repertoireFichiersOriginauxANSI;repertoireFichiersOriginauxANSIcsv;
	 * repertoireFichiersOriginauxUTF8;repertoireFichiersOriginauxUTF8csv;
	 * repertoireFichiersNettoyesUTF8;repertoireFichiersNettoyesUTF8csv;
	 * repertoireFichiersReponseLocalisationUTF8;
	 * repertoireAnnee;
	 * repertoireDARWIN;repertoireDIRA;repertoireDIRCE;repertoireDIRCO;
	 * repertoireDIRE;repertoireDIRIF;repertoireDIRMC;repertoireDIRMED;
	 * repertoireDIRN;repertoireDIRNO;repertoireDIRO;repertoireDIRSO;
	 * repertoireEntree;
	 * repertoireEntreeDarwin;
	 * repertoireEntreeDarwinANSI;repertoireEntreeDarwinUTF8;repertoireEntreeDarwinOriginal;
	 * repertoireEntreeHit;
	 * repertoireEntreeHitANSI;
	 * repertoireEntreeHitANSIAscii;repertoireEntreeHitANSICsv;repertoireEntreeHitANSIFeorXML;
	 * repertoireEntreeHitUTF8;
	 * repertoireEntreeHitUTF8Ascii;repertoireEntreeHitUTF8Csv;repertoireEntreeHitUTF8FeorXML;
	 * repertoireEntreeHitOriginal;
	 * repertoireSortie;
	 * repertoireSortieHistonatF07;
	 * repertoireSortieHistonatF07Ascii;
	 * repertoireSortieHistonatF07AsciiANSI;repertoireSortieHistonatF07AsciiUTF8;
	 * repertoireSortieHistonatF07Csv;
	 * repertoireSortieHistonatF07CsvANSI;repertoireSortieHistonatF07CsvUTF8;
	 * repertoireSortieHistonatF07FeorXML;
	 * repertoireSortieHistonatF07FeorXMLANSI;repertoireSortieHistonatF07FeorXMLUTF8;
	 * repertoireSortieHistonatF08;
	 * repertoireSortieHistonatF08Ascii;
	 * repertoireSortieHistonatF08AsciiANSI;repertoireSortieHistonatF08AsciiUTF8;".<br/>
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
	 * Getter de la <b>RACINE (Trafic_Histonat)</b> 
	 * des fichiers annuels de Trafic.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/racine_Trafic_Histonat.png" 
	 * alt="Racine des Trafics Trafic_Histonat" border="1" align="center" />
	 * <br/>
	 *
	 * @return rootFile : File.<br/>
	 */
	File getRootFile();

	
	
	/**
	* Setter de la <b>RACINE (Trafic_Histonat)</b> 
	* des fichiers annuels de Trafic.<br/>
	* <br/>
	*
	* @param pRootFile : File : 
	* valeur à passer à rootFile.<br/>
	*/
	void setRootFile(File pRootFile);
	

	
	/**
	 * Getter de l'<b>année d'exploitation</b> 
	 * des fichiers annuels de trafic (2013, 2017, ...).<br/>
	 * sur 4 digits obligatoirement.<br/>
	 * <br/>
	 *
	 * @return anneeExploitation : String.<br/>
	 */
	String getAnneeExploitation();
	
	
	
	/**
	* Setter de l'<b>année d'exploitation</b> 
	* des fichiers annuels de trafic (2013, 2017, ...).<br/>
	* sur 4 digits obligatoirement.<br/>
	* <br/>
	*
	* @param pAnneeExploitation : String : 
	* valeur à passer à anneeExploitation.<br/>
	*/
	void setAnneeExploitation(String pAnneeExploitation);
	
	

	/**
	 * Getter du <b>répertoire des Trafics annuels (Trafic_aaaa)</b> 
	 * sur un disque dur 
	 * pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Trafic_annuel.png" 
	 * alt="Trafic annuel" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireTraficAnnuel : File.<br/>
	 */
	File getRepertoireTraficAnnuel();
	
	

	/**
	* Setter du <b>répertoire des Trafics annuels (Trafic_aaaa)</b> 
	* sur un disque dur 
	* pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireTraficAnnuel : File : 
	* valeur à passer à repertoireTraficAnnuel.<br/>
	*/
	void setRepertoireTraficAnnuel(File pRepertoireTraficAnnuel);
	
	

	/**
	 * Getter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
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
	 *
	 * @return repertoireFichiersOriginaux : File.<br/>
	 */
	File getRepertoireFichiersOriginaux();
	
	

	/**
	 * Setter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <ul>
	 * <li>Les <b>fichiers des autoroutiers (DARWIN)</b> 
	 * sont nativement formatés en <b>CSV</b>.</li>
	 * <li>Les <b>fichiers des DIRs (HIT)</b> sont 
	 * nativement formatés en <b>ASCII</b>.</li>
	 * </ul>
	 *
	 * @param pRepertoireFichiersOriginaux : File : 
	 * valeur à passer à repertoireFichiersOriginaux.<br/>
	 */
	void setRepertoireFichiersOriginaux(File pRepertoireFichiersOriginaux);

	

	/**
	 * Getter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en ANSI</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Ansi.png" 
	 * alt="fichiers originaux ANSI" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireFichiersOriginauxANSI : File.<br/>
	 */
	File getRepertoireFichiersOriginauxANSI();
	
	

	/**
	* Setter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	* fournis par les gestionnaires pour 
	* une année pAnnee (à 4 chiffres) <b>transcodés en ANSI</b>.<br/>
	* <br/>
	*
	* @param pRepertoireFichiersOriginauxANSI : File : 
	* valeur à passer à repertoireFichiersOriginauxANSI.<br/>
	*/
	void setRepertoireFichiersOriginauxANSI(File pRepertoireFichiersOriginauxANSI);
	
	

	/**
	 * Getter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en ANSI</b> 
	 * et <b>formatés en CSV</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Ansi_csv.png" 
	 * alt="fichiers originaux ANSI en csv" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireFichiersOriginauxANSIcsv : File.<br/>
	 */
	File getRepertoireFichiersOriginauxANSIcsv();
	
	

	/**
	* Setter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	* fournis par les gestionnaires pour 
	* une année pAnnee (à 4 chiffres) <b>transcodés en ANSI</b> 
	* et <b>formatés en CSV</b>.<br/>
	* <br/>
	*
	* @param pRepertoireFichiersOriginauxANSIcsv : File : 
	* valeur à passer à repertoireFichiersOriginauxANSIcsv.<br/>
	*/
	void setRepertoireFichiersOriginauxANSIcsv(File pRepertoireFichiersOriginauxANSIcsv);
	
	

	/**
	 * Getter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en UTF8</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Utf8.png" 
	 * alt="fichiers originaux UTF8" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireFichiersOriginauxUTF8 : File.<br/>
	 */
	File getRepertoireFichiersOriginauxUTF8();
	
	

	/**
	* Setter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	* fournis par les gestionnaires pour 
	* une année pAnnee (à 4 chiffres) <b>transcodés en UTF8</b>.<br/>
	* <br/>
	*
	* @param pRepertoireFichiersOriginauxUTF8 : File : 
	* valeur à passer à repertoireFichiersOriginauxUTF8.<br/>
	*/
	void setRepertoireFichiersOriginauxUTF8(File pRepertoireFichiersOriginauxUTF8);
	
	

	/**
	 * Getter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	 * fournis par les gestionnaires pour 
	 * une année pAnnee (à 4 chiffres) <b>transcodés en UTF8</b> 
	 * et <b>formatés en CSV</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_originaux_Utf8_csv.png" 
	 * alt="fichiers originaux UTF8 en csv" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireFichiersOriginauxUTF8csv : File.<br/>
	 */
	File getRepertoireFichiersOriginauxUTF8csv();
	
	

	/**
	* Setter du <b>répertoire des fichiers originaux (HIT et DARWIN)</b> 
	* fournis par les gestionnaires pour 
	* une année pAnnee (à 4 chiffres) <b>transcodés en UTF8</b> 
	* et <b>formatés en CSV</b>.<br/>
	* <br/>
	*
	* @param pRepertoireFichiersOriginauxUTF8csv : File : 
	* valeur à passer à repertoireFichiersOriginauxUTF8csv.<br/>
	*/
	void setRepertoireFichiersOriginauxUTF8csv(File pRepertoireFichiersOriginauxUTF8csv);
	
	

	/**
	 * Getter du <b>répertoire des fichiers HIT nettoyés 
	 * (sens de trafic confondus)</b>
	 * encodés en UTF-8 sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres) <b>en ASCII natif</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_Nettoyes_Utf8.png" 
	 * alt="fichiers nettoyés UTF8" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireFichiersNettoyesUTF8 : File.<br/>
	 */
	File getRepertoireFichiersNettoyesUTF8();
	
	

	/**
	* Setter du <b>répertoire des fichiers HIT nettoyés 
	* (sens de trafic confondus)</b>
	* encodés en UTF-8 sur un disque dur pour 
	* une année pAnnee (à 4 chiffres) <b>en ASCII natif</b>.<br/>
	* <br/>
	*
	* @param pRepertoireFichiersNettoyesUTF8 : File : 
	* valeur à passer à repertoireFichiersNettoyesUTF8.<br/>
	*/
	void setRepertoireFichiersNettoyesUTF8(File pRepertoireFichiersNettoyesUTF8);
	
	

	/**
	 * Getter du <b>répertoire des fichiers HIT nettoyés 
	 * (sens de trafic confondus)</b>
	 * encodés en UTF-8 sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres) <b>formatés en CSV</b>.<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/Fichiers_Nettoyes_UTF8csv.png" 
	 * alt="fichiers nettoyés UTF8 csv" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireFichiersNettoyesUTF8csv : File.<br/>
	 */
	File getRepertoireFichiersNettoyesUTF8csv();
	
	

	/**
	* Setter du <b>répertoire des fichiers HIT nettoyés 
	* (sens de trafic confondus)</b>
	* encodés en UTF-8 sur un disque dur pour 
	* une année pAnnee (à 4 chiffres) <b>formatés en CSV</b>.<br/>
	* <br/>
	*
	* @param pRepertoireFichiersNettoyesUTF8csv : File : 
	* valeur à passer à repertoireFichiersNettoyesUTF8csv.<br/>
	*/
	void setRepertoireFichiersNettoyesUTF8csv(File pRepertoireFichiersNettoyesUTF8csv);
	
	

	/**
	 * Getter du <b>répertoire des fichiers de réponse d'ISIDOR</b> 
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
	 *
	 * @return repertoireFichiersReponseLocalisationUTF8 : File.<br/>
	 */
	File getRepertoireFichiersReponseLocalisationUTF8(); 
	
	

	/**
	 * Setter du <b>répertoire des fichiers de réponse d'ISIDOR</b> 
	 * pour la <b>localisation</b> des fichiers fournis 
	 * par les gestionnaires encodés en UTF-8 sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <i>ISIDOR indique pour chaque section de trafic 
	 * d'un fichier de gestionnaire (HIT, DARWIN) 
	 * si elle existe ou pas</i>.<br/>
	 * <br/>
	 *
	 * @param pRepertoireFichiersReponseLocalisationUTF8 : File : 
	 * valeur à passer à repertoireFichiersReponseLocalisationUTF8.<br/>
	*/
	void setRepertoireFichiersReponseLocalisationUTF8(File pRepertoireFichiersReponseLocalisationUTF8);
	
	

	/**
	 * Getter du <b>répertoire annee</b> contenant les sous-répertoires 
	 * pour chaque Gestionnaire ainsi que les 
	 * productions de l'application sur un disque dur pour 
	 * une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_annee.png" 
	 * alt="répertoire annee" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireAnnee : File.<br/>
	 */
	File getRepertoireAnnee(); 
	
	

	/**
	* Setter du <b>répertoire annee</b> contenant les sous-répertoires 
	* pour chaque Gestionnaire ainsi que les 
	* productions de l'application sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireAnnee : File : 
	* valeur à passer à repertoireAnnee.<br/>
	*/
	void setRepertoireAnnee(File pRepertoireAnnee); 
	
	

	/**
	 * Getter du <b>répertoire DARWIN</b> contenant les 
	 * données trafic des autoroutiers 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DARWIN.png" 
	 * alt="répertoire DARWIN" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDARWIN : File.<br/>
	 */
	File getRepertoireDARWIN(); 
	
	

	/**
	* Setter du <b>répertoire DARWIN</b> contenant les 
	* données trafic des autoroutiers 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDARWIN : File : 
	* valeur à passer à repertoireDARWIN.<br/>
	*/
	void setRepertoireDARWIN(File pRepertoireDARWIN);
	
	

	/**
	 * Getter du <b>répertoire DIRA</b> contenant les 
	 * données trafic de la DIR Atlantique (DIRA) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRA.png" 
	 * alt="répertoire DIRA" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRA : File.<br/>
	 */
	File getRepertoireDIRA(); 
	
	

	/**
	* Setter du <b>répertoire DIRA</b> contenant les 
	* données trafic de la DIR Atlantique (DIRA) 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRA : File : 
	* valeur à passer à repertoireDIRA.<br/>
	*/
	void setRepertoireDIRA(File pRepertoireDIRA);
	
	

	/**
	 * Getter du <b>répertoire DIRCE</b> contenant les 
	 * données trafic de la DIR Centre-Est (DIRCE)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRCE.png" 
	 * alt="répertoire DIRCE" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRCE : File.<br/>
	 */
	File getRepertoireDIRCE();
	
	

	/**
	* Setter du <b>répertoire DIRCE</b> contenant les 
	* données trafic de la DIR Centre-Est (DIRCE) 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRCE : File : 
	* valeur à passer à repertoireDIRCE.<br/>
	*/
	void setRepertoireDIRCE(File pRepertoireDIRCE); 
	
	

	/**
	 * Getter du <b>répertoire DIRCO</b> contenant les 
	 * données trafic de la DIR Centre-Ouest (DIRCO)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRCO.png" 
	 * alt="répertoire DIRCO" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRCO : File.<br/>
	 */
	File getRepertoireDIRCO();
	
	

	/**
	* Setter du <b>répertoire DIRCO</b> contenant les 
	* données trafic de la DIR Centre-Ouest (DIRCO)
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRCO : File : 
	* valeur à passer à repertoireDIRCO.<br/>
	*/
	void setRepertoireDIRCO(File pRepertoireDIRCO); 
	
	
	
	/**
	 * Getter du <b>répertoire DIRE</b> contenant les 
	 * données trafic de la DIR Est (DIRE) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRE.png" 
	 * alt="répertoire DIRE" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRE : File.<br/>
	 */
	File getRepertoireDIRE(); 
	
	
	
	/**
	* Setter du <b>répertoire DIRE</b> contenant les 
	* données trafic de la DIR Est (DIRE)
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRE : File : 
	* valeur à passer à repertoireDIRE.<br/>
	*/
	void setRepertoireDIRE(File pRepertoireDIRE);
	
	

	/**
	 * Getter du <b>répertoire DIRIF</b> contenant les 
	 * données trafic de la DIR Ile-de-France (DIRIF)  
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRIF.png" 
	 * alt="répertoire DIRIF" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRIF : File.<br/>
	 */
	File getRepertoireDIRIF(); 
	
	

	/**
	* Setter du <b>répertoire DIRIF</b> contenant les 
	* données trafic de la DIR Ile-de-France (DIRIF) 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRIF : File : 
	* valeur à passer à repertoireDIRIF.<br/>
	*/
	void setRepertoireDIRIF(File pRepertoireDIRIF); 
	
	

	/**
	 * Getter du <b>répertoire DIRMC</b> contenant les 
	 * données trafic de la DIR Massif-Central (DIRMC) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRMC.png" 
	 * alt="répertoire DIRMC" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRMC : File.<br/>
	 */
	File getRepertoireDIRMC(); 
	
	

	/**
	* Setter du <b>répertoire DIRMC</b> contenant les 
	* données trafic de la DIR Massif-Central (DIRMC)
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRMC : File : 
	* valeur à passer à repertoireDIRMC.<br/>
	*/
	void setRepertoireDIRMC(File pRepertoireDIRMC);
	
	

	/**
	 * Getter du <b>répertoire DIRMED</b> contenant les 
	 * données trafic de la DIR Méditerranée (DIRMED) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRMED.png" 
	 * alt="répertoire DIRMED" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRMED : File.<br/>
	 */
	File getRepertoireDIRMED();
	
	

	/**
	* Setter du <b>répertoire DIRMED</b> contenant les 
	* données trafic de la DIR Méditerranée (DIRMED) 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRMED : File : 
	* valeur à passer à repertoireDIRMED.<br/>
	*/
	void setRepertoireDIRMED(File pRepertoireDIRMED); 
	
	

	/**
	 * Getter du <b>répertoire DIRN</b> contenant les 
	 * données trafic de la DIR Nord (DIRN)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRN.png" 
	 * alt="répertoire DIRN" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRN : File.<br/>
	 */
	File getRepertoireDIRN(); 
	
	

	/**
	* Setter du <b>répertoire DIRN</b> contenant les 
	* données trafic de la DIR Nord (DIRN)
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRN : File : 
	* valeur à passer à repertoireDIRN.<br/>
	*/
	void setRepertoireDIRN(File pRepertoireDIRN); 
	
	

	/**
	 * Getter du <b>répertoire DIRNO</b> contenant les 
	 * données trafic de la DIR Nord-Ouest (DIRNO)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRNO.png" 
	 * alt="répertoire DIRNO" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRNO : File.<br/>
	 */
	File getRepertoireDIRNO(); 
	
	

	/**
	* Setter du <b>répertoire DIRNO</b> contenant les 
	* données trafic de la DIR Nord-Ouest (DIRNO)
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRNO : File : 
	* valeur à passer à repertoireDIRNO.<br/>
	*/
	void setRepertoireDIRNO(File pRepertoireDIRNO);
	
	

	/**
	 * Getter du <b>répertoire DIRO</b> contenant les 
	 * données trafic de la DIR Ouest (DIRO) 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRO.png" 
	 * alt="répertoire DIRO" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRO : File.<br/>
	 */
	File getRepertoireDIRO(); 
	
	

	/**
	* Setter du <b>répertoire DIRO</b> contenant les 
	* données trafic de la DIR Ouest (DIRO) 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRO : File : 
	* valeur à passer à repertoireDIRO.<br/>
	*/
	void setRepertoireDIRO(File pRepertoireDIRO); 
	
	

	/**
	 * Getter du <b>répertoire DIRSO</b> contenant les 
	 * données trafic de la DIR Sud-Ouest (DIRSO)
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_DIRSO.png" 
	 * alt="répertoire DIRSO" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireDIRSO : File.<br/>
	 */
	File getRepertoireDIRSO(); 
	
	

	/**
	* Setter du <b>répertoire DIRSO</b> contenant les 
	* données trafic de la DIR Sud-Ouest (DIRSO) 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireDIRSO : File : 
	* valeur à passer à repertoireDIRSO.<br/>
	*/
	void setRepertoireDIRSO(File pRepertoireDIRSO); 
	
	

	/**
	 * Getter du <b>répertoire annee/Entree</b> contenant 
	 * les données de trafic en entrée de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_Entree.png" 
	 * alt="répertoire Entree" border="1" align="center" />
	 * <br/>
	 *
	 * @return repertoireEntree : File.<br/>
	 */
	File getRepertoireEntree();
	
	

	/**
	* Setter du <b>répertoire annee/Entree</b> contenant 
	 * les données de trafic en entrée de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntree : File : 
	* valeur à passer à repertoireEntree.<br/>
	*/
	void setRepertoireEntree(File pRepertoireEntree);
	
	

	/**
	 * Getter du <b>répertoire Entree/Darwin</b> contenant 
	 * les données de trafic des autoroutiers 
	 * en entrée de l'application 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwin.png" 
	 * alt="répertoire Entree Darwin" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeDarwin : File.<br/>
	 */
	File getRepertoireEntreeDarwin(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Darwin</b> contenant 
	* les données de trafic des autoroutiers 
	* en entrée de l'application 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeDarwin : File : 
	* valeur à passer à this.repertoireEntreeDarwin.<br/>
	*/
	void setRepertoireEntreeDarwin(File pRepertoireEntreeDarwin);
	
	

	/**
	 * Getter du <b>répertoire Entree/Darwin/Darwin encodé en ANSI/</b> 
	 * contenant les données de trafic des autoroutiers 
	 * en entrée de l'application <b>encodées en ANSI</b> 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwinANSI.png" 
	 * alt="répertoire Entree Darwin ANSI" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeDarwinANSI : File.<br/>
	 */
	File getRepertoireEntreeDarwinANSI(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Darwin/Darwin encodé en ANSI/</b> 
	* contenant les données de trafic des autoroutiers 
	* en entrée de l'application <b>encodées en ANSI</b> 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeDarwinANSI : File : 
	* valeur à passer à this.repertoireEntreeDarwinANSI.<br/>
	*/
	void setRepertoireEntreeDarwinANSI(File pRepertoireEntreeDarwinANSI);
	
	

	/**
	 * Getter du <b>répertoire Entree/Darwin/Darwin encodé en UTF8/</b> 
	 * contenant les données de trafic des autoroutiers 
	 * en entrée de l'application <b>encodées en UTF8</b> 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwinUTF8.png" 
	 * alt="répertoire Entree Darwin UTF8" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeDarwinUTF8 : File.<br/>
	 */
	File getRepertoireEntreeDarwinUTF8(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Darwin/Darwin encodé en UTF8/</b> 
	* contenant les données de trafic des autoroutiers 
	* en entrée de l'application <b>encodées en UTF8</b> 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeDarwinUTF8 : File : 
	* valeur à passer à this.repertoireEntreeDarwinUTF8.<br/>
	*/
	void setRepertoireEntreeDarwinUTF8(File pRepertoireEntreeDarwinUTF8);
	
	

	/**
	 * Getter du <b>répertoire Entree/Darwin/Darwin original/</b> 
	 * contenant les données de trafic des autoroutiers 
	 * en entrée de l'application <b>fournies par le gestionnaire</b> 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeDarwinOriginal.png" 
	 * alt="répertoire Entree Darwin Original" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeDarwinOriginal : File.<br/>
	 */
	File getRepertoireEntreeDarwinOriginal(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Darwin/Darwin original/</b> 
	* contenant les données de trafic des autoroutiers 
	* en entrée de l'application <b>fournies par le gestionnaire</b> 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeDarwinOriginal : File : 
	* valeur à passer à this.repertoireEntreeDarwinOriginal.<br/>
	*/
	void setRepertoireEntreeDarwinOriginal(File pRepertoireEntreeDarwinOriginal);
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application 
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHit.png" 
	 * alt="répertoire Entree Hit" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHit : File.<br/>
	 */
	File getRepertoireEntreeHit(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application 
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHit : File : 
	* valeur à passer à this.repertoireEntreeHit.<br/>
	*/
	void setRepertoireEntreeHit(File pRepertoireEntreeHit); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en ANSI/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSI.png" 
	 * alt="répertoire Entree Hit ANSI" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitANSI : File.<br/>
	 */
	File getRepertoireEntreeHitANSI(); 
	
	
	
	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en ANSI/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en ANSI</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitANSI : File : 
	* valeur à passer à this.repertoireEntreeHitANSI.<br/>
	*/
	void setRepertoireEntreeHitANSI(File pRepertoireEntreeHitANSI); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_Ascii/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en Ascii</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSIAscii.png" 
	 * alt="répertoire Entree Hit ANSI Ascii" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitANSIAscii : File.<br/>
	 */
	File getRepertoireEntreeHitANSIAscii(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_Ascii/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en Ascii</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitANSIAscii : File : 
	* valeur à passer à this.repertoireEntreeHitANSIAscii.<br/>
	*/
	void setRepertoireEntreeHitANSIAscii(File pRepertoireEntreeHitANSIAscii); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_Csv/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en Csv</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSICsv.png" 
	 * alt="répertoire Entree Hit ANSI Csv" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitANSICsv : File.<br/>
	 */
	File getRepertoireEntreeHitANSICsv(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_Csv/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en Csv</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitANSICsv : File : 
	* valeur à passer à this.repertoireEntreeHitANSICsv.<br/>
	*/
	void setRepertoireEntreeHitANSICsv(File pRepertoireEntreeHitANSICsv); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_FeorXML/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en FeorXML</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitANSIFeorXML.png" 
	 * alt="répertoire Entree Hit ANSI FeorXML" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitANSIFeorXML : File.<br/>
	 */
	File getRepertoireEntreeHitANSIFeorXML();
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en ANSI/Hit encodés en ANSI_FeorXML/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en ANSI</b> et <b>formatées en FeorXML</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitANSIFeorXML : File : 
	* valeur à passer à this.repertoireEntreeHitANSIFeorXML.<br/>
	*/
	void setRepertoireEntreeHitANSIFeorXML(File pRepertoireEntreeHitANSIFeorXML); 
	
	
	
	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en UTF8/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8.png" 
	 * alt="répertoire Entree Hit UTF8" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitUTF8 : File.<br/>
	 */
	File getRepertoireEntreeHitUTF8();
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en UTF8/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en UTF8</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitUTF8 : File : 
	* valeur à passer à this.repertoireEntreeHitUTF8.<br/>
	*/
	void setRepertoireEntreeHitUTF8(File pRepertoireEntreeHitUTF8); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_Ascii/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en Ascii</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8Ascii.png" 
	 * alt="répertoire Entree Hit UTF8 Ascii" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitUTF8Ascii : File.<br/>
	 */
	File getRepertoireEntreeHitUTF8Ascii(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_Ascii/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en Ascii</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitUTF8Ascii : File : 
	* valeur à passer à this.repertoireEntreeHitUTF8Ascii.<br/>
	*/
	void setRepertoireEntreeHitUTF8Ascii(File pRepertoireEntreeHitUTF8Ascii); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_Csv/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en Csv</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8Csv.png" 
	 * alt="répertoire Entree Hit UTF8 Csv" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitUTF8Csv : File.<br/>
	 */
	File getRepertoireEntreeHitUTF8Csv(); 
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_Csv/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en Csv</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitUTF8Csv : File : 
	* valeur à passer à this.repertoireEntreeHitUTF8Csv.<br/>
	*/
	void setRepertoireEntreeHitUTF8Csv(File pRepertoireEntreeHitUTF8Csv); 
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_FeorXML/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en FeorXML</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitUTF8FeorXML.png" 
	 * alt="répertoire Entree Hit UTF8 FeorXML" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitUTF8FeorXML : File.<br/>
	 */
	File getRepertoireEntreeHitUTF8FeorXML();
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit encodés en UTF8_FeorXML/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>encodées en UTF8</b> et <b>formatées en FeorXML</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitUTF8FeorXML : File : 
	* valeur à passer à this.repertoireEntreeHitUTF8FeorXML.<br/>
	*/
	void setRepertoireEntreeHitUTF8FeorXML(File pRepertoireEntreeHitUTF8FeorXML);
	
	

	/**
	 * Getter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit originaux/</b> 
	 * contenant les données de trafic des DIRs 
	 * en entrée de l'application <b>fournies par les gestionnaires</b>
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_EntreeHitOriginal.png" 
	 * alt="répertoire Entree Hit Original" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireEntreeHitOriginal : File.<br/>
	 */
	File getRepertoireEntreeHitOriginal();
	
	

	/**
	* Setter du <b>répertoire Entree/Hit/Hit encodés en UTF8/Hit originaux/</b> 
	* contenant les données de trafic des DIRs 
	* en entrée de l'application <b>fournies par les gestionnaires</b>
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireEntreeHitOriginal : File : 
	* valeur à passer à this.repertoireEntreeHitOriginal.<br/>
	*/
	void setRepertoireEntreeHitOriginal(File pRepertoireEntreeHitOriginal);
	
	

	/**
	 * Getter du <b>répertoire annee/Sortie</b> contenant 
	 * les données de trafic en sortie (productions) de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_Sortie.png" 
	 * alt="répertoire Sortie" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireSortie : File.<br/>
	 */
	File getRepertoireSortie(); 
	
	

	/**
	* Setter du <b>répertoire annee/Sortie</b> contenant 
	* les données de trafic en sortie (productions) de l'application
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortie : File : 
	* valeur à passer à this.repertoireSortie.<br/>
	*/
	void setRepertoireSortie(File pRepertoireSortie); 
	
	

	/**
	 * Getter du <b>répertoire Sortie/HistonatF07/</b>
	 * contenant les données de trafic HistonatF07
	 * en sortie (productions) de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF07.png" 
	 * alt="répertoire Sortie HistonatF07" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireSortieHistonatF07 : File.<br/>
	 */
	File getRepertoireSortieHistonatF07(); 
	
	

	/**
	* Setter du <b>répertoire Sortie/HistonatF07/</b>
	* contenant les données de trafic HistonatF07
	* en sortie (productions) de l'application
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07 : File : 
	* valeur à passer à this.repertoireSortieHistonatF07.<br/>
	*/
	void setRepertoireSortieHistonatF07(File pRepertoireSortieHistonatF07); 
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07Ascii : File.<br/>
	 */
	File getRepertoireSortieHistonatF07Ascii();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en ASCII/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en Ascii</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07Ascii : File : 
	* valeur à passer à this.repertoireSortieHistonatF07Ascii.<br/>
	*/
	void setRepertoireSortieHistonatF07Ascii(File pRepertoireSortieHistonatF07Ascii);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07AsciiANSI : File.<br/>
	 */
	File getRepertoireSortieHistonatF07AsciiANSI();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en ASCII/
	* HistonatF07 ASCII encodé en ANSI/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en Ascii</b> et <b>encodées en ANSI</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07AsciiANSI : File : 
	* valeur à passer à this.repertoireSortieHistonatF07AsciiANSI.<br/>
	*/
	void setRepertoireSortieHistonatF07AsciiANSI(File pRepertoireSortieHistonatF07AsciiANSI);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07AsciiUTF8 : File.<br/>
	 */
	File getRepertoireSortieHistonatF07AsciiUTF8();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en ASCII/
	* HistonatF07 ASCII encodé en UTF8/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en Ascii</b> et <b>encodées en UTF8</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07AsciiUTF8 : File : 
	* valeur à passer à this.repertoireSortieHistonatF07AsciiUTF8.<br/>
	*/
	void setRepertoireSortieHistonatF07AsciiUTF8(File pRepertoireSortieHistonatF07AsciiUTF8);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07Csv : File.<br/>
	 */
	File getRepertoireSortieHistonatF07Csv();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en CSV/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en Csv</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07Csv : File : 
	* valeur à passer à this.repertoireSortieHistonatF07Csv.<br/>
	*/
	void setRepertoireSortieHistonatF07Csv(File pRepertoireSortieHistonatF07Csv);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07CsvANSI : File.<br/>
	 */
	File getRepertoireSortieHistonatF07CsvANSI();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en CSV/
	* HistonatF07 CSV encodé en ANSI/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en Csv</b> et <b>encodées en ANSI</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07CsvANSI : File : 
	* valeur à passer à this.repertoireSortieHistonatF07CsvANSI.<br/>
	*/
	void setRepertoireSortieHistonatF07CsvANSI(File pRepertoireSortieHistonatF07CsvANSI);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07CsvUTF8 : File.<br/>
	 */
	File getRepertoireSortieHistonatF07CsvUTF8();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en CSV/
	* HistonatF07 CSV encodé en UTF8/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en Csv</b> et <b>encodées en UTF8</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07CsvUTF8 : File : 
	* valeur à passer à this.repertoireSortieHistonatF07CsvUTF8.<br/>
	*/
	void setRepertoireSortieHistonatF07CsvUTF8(File pRepertoireSortieHistonatF07CsvUTF8);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07FeorXML : File.<br/>
	 */
	File getRepertoireSortieHistonatF07FeorXML();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en FeorXML/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en FeorXML</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07FeorXML : File : 
	* valeur à passer à this.repertoireSortieHistonatF07FeorXML.<br/>
	*/
	void setRepertoireSortieHistonatF07FeorXML(File pRepertoireSortieHistonatF07FeorXML);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07FeorXMLANSI : File.<br/>
	 */
	File getRepertoireSortieHistonatF07FeorXMLANSI();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en FeorXML/
	* HistonatF07 FeorXML encodé en ANSI/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en FeorXML</b> et <b>encodées en ANSI</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07FeorXMLANSI : File : 
	* valeur à passer à this.repertoireSortieHistonatF07FeorXMLANSI.<br/>
	*/
	void setRepertoireSortieHistonatF07FeorXMLANSI(File pRepertoireSortieHistonatF07FeorXMLANSI);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF07FeorXMLUTF8 : File.<br/>
	 */
	File getRepertoireSortieHistonatF07FeorXMLUTF8();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF07/HistonatF07 en FeorXML/
	* HistonatF07 FeorXML encodé en UTF8/</b>
	* contenant les données de trafic HistonatF07 
	* <b>formatées en FeorXML</b> et <b>encodées en UTF8</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF07FeorXMLUTF8 : File : 
	* valeur à passer à this.repertoireSortieHistonatF07FeorXMLUTF8.<br/>
	*/
	void setRepertoireSortieHistonatF07FeorXMLUTF8(File pRepertoireSortieHistonatF07FeorXMLUTF8);
	
	

	/**
	 * Getter du <b>répertoire Sortie/HistonatF08/</b>
	 * contenant les données de trafic HistonatF08 
	 * pour l'INDICE DE CIRCULATION
	 *  en sortie (productions) de l'application
	 * sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	 * <br/>
	 * <img src="../../../../../../../../../../../javadoc/images/repertoire_SortieHistonatF08.png" 
	 * alt="répertoire Sortie HistonatF08" border="1" align="center" />
	 * <br/>
	 *
	 * @return this.repertoireSortieHistonatF08 : File.<br/>
	 */
	File getRepertoireSortieHistonatF08();
	
	

	/**
	* Setter du <b>répertoire Sortie/HistonatF08/</b>
	* contenant les données de trafic HistonatF08 
	* pour l'INDICE DE CIRCULATION
	*  en sortie (productions) de l'application
	* sur un disque dur pour une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF08 : File : 
	* valeur à passer à this.repertoireSortieHistonatF08.<br/>
	*/
	void setRepertoireSortieHistonatF08(File pRepertoireSortieHistonatF08);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF08Ascii : File.<br/>
	 */
	File getRepertoireSortieHistonatF08Ascii();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF08/HistonatF08 en ASCII/</b>
	* contenant les données de trafic HistonatF08 
	* pour l'INDICE DE CIRCULATION
	* <b>formatées en Ascii</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF08Ascii : File : 
	* valeur à passer à this.repertoireSortieHistonatF08Ascii.<br/>
	*/
	void setRepertoireSortieHistonatF08Ascii(File pRepertoireSortieHistonatF08Ascii);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF08AsciiANSI : File.<br/>
	 */
	File getRepertoireSortieHistonatF08AsciiANSI();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF08/HistonatF08 en ASCII/
	* HistonatF08 ASCII encodé en ANSI/</b>
	* contenant les données de trafic HistonatF08 
	* pour l'INDICE DE CIRCULATION
	* <b>formatées en Ascii</b> et <b>encodées en ANSI</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF08AsciiANSI : File : 
	* valeur à passer à this.repertoireSortieHistonatF08AsciiANSI.<br/>
	*/
	void setRepertoireSortieHistonatF08AsciiANSI(File pRepertoireSortieHistonatF08AsciiANSI);
	
	

	/**
	 * Getter du <b>répertoire
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
	 *
	 * @return this.repertoireSortieHistonatF08AsciiUTF8 : File.<br/>
	 */
	File getRepertoireSortieHistonatF08AsciiUTF8();
	
	

	/**
	* Setter du <b>répertoire
	* Sortie/HistonatF08/HistonatF08 en ASCII/
	* HistonatF08 ASCII encodé en UTF8/</b>
	* contenant les données de trafic HistonatF08 
	* pour l'INDICE DE CIRCULATION
	* <b>formatées en Ascii</b> et <b>encodées en UTF8</b>
	* en sortie (productions) de l'application 
	* sur un disque dur pour 
	* une année pAnnee (à 4 chiffres).<br/>
	* <br/>
	*
	* @param pRepertoireSortieHistonatF08AsciiUTF8 : File : 
	* valeur à passer à this.repertoireSortieHistonatF08AsciiUTF8.<br/>
	*/
	void setRepertoireSortieHistonatF08AsciiUTF8(File pRepertoireSortieHistonatF08AsciiUTF8);
	

	
	
} // FIN DE L'INTERFACE IArboTrafic.-----------------------------------------