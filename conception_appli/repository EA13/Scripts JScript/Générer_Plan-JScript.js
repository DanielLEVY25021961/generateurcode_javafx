!INC Local Scripts.EAConstants-JScript

var TEMPLATE = "Template_Plan_Activities";
var OUTPUT_FILE = "C:\\Users\\dan\\git\\tuto_web_jee1.8.144.git\\tuto_web_jee1.8.144\\conception_appli\\Documentation g�n�r�e par EA\\Plan.docx";
var GUID_MASTER_DOCUMENT = "{01EDB4D9-5BC5-4a44-AF27-0C481F627362}";

/*
 * Script Name: Generer_Plan_JScript
 * Author: Daniel Lévy
 * Purpose: Générer automatiquement par Script le plan du projet
 * Date: 4/09/2017
 */
 
function genererPlan() {
	
	var projectInterface as EA.Project;
	
	projectInterface = Repository.GetProjectInterface();
	
	projectInterface.RunReport(GUID_MASTER_DOCUMENT, "", OUTPUT_FILE);
		
}

genererPlan();