!INC Local Scripts.EAConstants-JScript

var TEMPLATE = "Template_Package_Note_Diagramme_Linked";
var OUTPUT_FILE = "C:\\Users\\dan\\git\\tuto_web_jee1.8.144.git\\tuto_web_jee1.8.144\\conception_appli\\Documentation g�n�r�e par EA\\Livrable.docx";
var GUID_MASTER_DOCUMENT = "{4023291D-9BFC-49b0-8ED2-978CA3A4AC8E}";

/*
 * Script Name: Generer_Livrable-JScript
 * Author: Daniel Lévy
 * Purpose: Générer automatiquement par Script le livrable du projet
 * Date: 4/09/2017
 */
 
function genererLivrable() {
	
	var projectInterface as EA.Project;
	
	projectInterface = Repository.GetProjectInterface();
	
	projectInterface.RunReport(GUID_MASTER_DOCUMENT, "", OUTPUT_FILE);
		
}

genererLivrable();