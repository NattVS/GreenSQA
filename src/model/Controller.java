package model;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Controller {

    private Project[] projects;

	public Controller() {
        projects = new Project[10];
	}
	
    public boolean RegisterProject(String projectName, String clientName, String gManagerName, String gManagerNumber, String cManagerName, String cManagerNumber, double budget, int initialDay, int initialMonth, int initialYear, int finalDay, int finalMonth, int finalYear, int bStageMonths, int aStageMonths, int dStageMonths, int eStageMonths, int cfStageMonths, int cStageMonths) {

		Calendar initialDate = new GregorianCalendar(initialYear, initialMonth, initialDay); 
        Calendar dateBStage = initialDate;
        dateBStage.add(Calendar.MONTH, bStageMonths);
        Calendar dateAStage = dateBStage;
        dateAStage.add(Calendar.MONTH, aStageMonths);
        Calendar dateDStage = dateAStage;
        dateDStage.add(Calendar.MONTH, dStageMonths);
        Calendar dateEStage = dateDStage;
        dateEStage.add(Calendar.MONTH, eStageMonths);
        Calendar dateCFStage = dateEStage;
        dateCFStage.add(Calendar.MONTH, cfStageMonths);
        Calendar dateCStage = dateCFStage;
		Calendar newFinalDate = dateCStage;

		Project newProject = new Project(projectName, clientName, gManagerName, gManagerNumber, cManagerName, cManagerNumber, initialDate, newFinalDate, budget);
        
        Stages bSatge = new Stages(newProject.getProjectName(),"BEGINNING", StageStatus.ACTIVE, null, null, null, null);
        Stages aSatge = new Stages(newProject.getProjectName(),"ANALYSIS", StageStatus.INACTIVE, null, null, null, null);
        Stages dSatge = new Stages(newProject.getProjectName(),"DESIGN", StageStatus.INACTIVE, null, null, null, null);
        Stages eSatge = new Stages(newProject.getProjectName(),"EXECUTION", StageStatus.INACTIVE, null, null, null, null);
        Stages cfSatge = new Stages(newProject.getProjectName(),"CLOSING & FOLLOW-UP", StageStatus.INACTIVE, null, null, null, null);
        Stages cSatge = new Stages(newProject.getProjectName(),"CONTROL", StageStatus.INACTIVE, null, null, null, null);
        //Assigns stages to the projects
        newProject.setStage(0, bSatge);
        newProject.setStage(1, aSatge);
        newProject.setStage(2, dSatge);
        newProject.setStage(3, eSatge);
        newProject.setStage(4, cfSatge);
        newProject.setStage(5, cSatge);

		for (int i = 0; i < projects.length; i++) {
            if (projects[i] == null) {
                projects[i] = newProject;
                return true;
            }
        }
		return false;
	}

    public String getAllProjects() {
        String msg = "";
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                        msg += "\n" + (i+1) +". " + "Project's name: " + projects[i].getProjectName();
                    }
                }
            }
        }
        return msg;
    }

    public String getProjectsInfo() {
        String msg = "";
        for (int i = 0; i < projects.length; i++) {
            if (projects[i] != null) {
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                        msg += (i+1) +". " + "Project's name: " + projects[i].getProjectName() + "\nCurrent stage: " + projects[i].getStages()[x].getStageName() + "\nStatus: " + projects[i].getStages()[x].getStageStatus();
                    }
                }
            }
        }
        return msg;
    }

    public void closeProjectStage(String projectsNames, int closureDay, int closureMonth, int closureYear){
        Calendar closureDate = new GregorianCalendar(closureYear, closureMonth, closureDay);
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getProjectName().equals(projectsNames)){
                    for(int x = 0; x < projects[i].getStages().length; x++){
                        if(projects[i].getStages()[x] != null){
                            if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                                if (x == 5) {
                                    projects[i].getStages()[x].setStageStatus(StageStatus.INACTIVE);
                                    projects[i].getStages()[x].setRealFinalDate(closureDate);
                                } else {
                                    projects[i].getStages()[x].setStageStatus(StageStatus.INACTIVE);
                                    projects[i].getStages()[x].setRealFinalDate(closureDate);
                                    projects[i].getStages()[x+1].setStageStatus(StageStatus.ACTIVE);
                                    projects[i].getStages()[x+1].setRealFinalDate(closureDate);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String compareName(String projectsNames){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        if(projects[i].getStages()[x].getStageStatus().equals(StageStatus.ACTIVE)){
                            if(projects[i].getStages()[x].getProjectsNames().equals(projectsNames)){
                                msg = projects[i].getStages()[x].getProjectsNames();
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

	public boolean registerKnowledgeCapsule(String projectName, int stage, String id, String colaborator, String colaboratorRole, String description, int type, String learnedLessons) {
		KnowledgeCapsuleType capsuleType = KnowledgeCapsuleType.UNDEFINED;
        String stageNameCapsule = "";
        switch (type) {
			case 1:
				capsuleType = KnowledgeCapsuleType.TECHNICAL;
			break;
			case 2:
				capsuleType = KnowledgeCapsuleType.MANAGEMENT;
			break;
			case 3:
				capsuleType = KnowledgeCapsuleType.DOMAIN;
			break;
			case 4:
				capsuleType = KnowledgeCapsuleType.EXPERIENCES;
			break;
			default:
                capsuleType = KnowledgeCapsuleType.UNDEFINED;
			break;
		}
        switch (stage) {
			case 1:
                stageNameCapsule = "BEGINNING";
			break;
			case 2:
                stageNameCapsule = "ANALYSIS";
			break;
			case 3:
                stageNameCapsule = "DESIGN";
			break;
			case 4:
                stageNameCapsule = "EXECUTION";
			break;
            case 5:
                stageNameCapsule = "CLOSING & FOLLOW-UP";
			break;
            case 6:
                stageNameCapsule = "CONTROL";
			break;
			default:
                stageNameCapsule = "";
			break;
		}
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getProjectName().equals(projectName)){
                    for(int x = 0; x < projects[i].getStages().length; x++){
                        if(projects[i].getStages()[x] != null){
                            if(projects[i].getStages()[x].getStageName().equals(stageNameCapsule)){
                                for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                                    if(projects[i].getStages()[x].getCapsules()[y] == null){
                                        projects[i].getStages()[x].getCapsules()[y] = new KnowledgeCapsule(id, description, capsuleType, colaborator, colaboratorRole, learnedLessons);
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
	}

	public String showRegisteredCapsules() {
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                msg += projects[i].getStages()[x].getCapsules()[y].getId() + ": " + projects[i].getStages()[x].getCapsules()[y].getDescription() + "\n";
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public String compareId(String id){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getId().equals(id)){
                                    msg = projects[i].getStages()[x].getCapsules()[y].getId();
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public void knowledgeCapsuleNewStatus(String id, int kCapsuleStatus, int statusDay, int statusMonth, int statusYear) {
        Calendar statusDate = new GregorianCalendar(statusYear, statusMonth, statusDay);
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getId().equals(id)){
                                    if(kCapsuleStatus == 1){
                                        projects[i].getStages()[x].getCapsules()[y].setStatus(KnowledgeCapsuleStatus.APPROVED);
                                        projects[i].getStages()[x].getCapsules()[y].setStatusDate(statusDate);
                                    }
                                    else if(kCapsuleStatus == 2){
                                        projects[i].getStages()[x].getCapsules()[y].setStatus(KnowledgeCapsuleStatus.NOT_APPROVED);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String getApprovedKnowledgeCapsules(){
        String msg = "";

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getStatus().equals(KnowledgeCapsuleStatus.APPROVED)){
                                    msg += projects[i].getStages()[x].getCapsules()[y].getId() + ": " + projects[i].getStages()[x].getCapsules()[y].getDescription() + "(" + projects[i].getStages()[x].getCapsules()[y].getStatus()+ ")\n";
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public void publishKnowledgeUnit(String id) {

        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getId().equals(id)){
                                    if(projects[i].getStages()[x].getCapsules()[y].getStatus().equals(KnowledgeCapsuleStatus.APPROVED)){
                                        projects[i].getStages()[x].getCapsules()[y].setPublishingStatus(KnowledgeCapsulePublication.PUBLISHED);
                                        projects[i].getStages()[x].getCapsules()[y].setUrl("www.greensqa.com/" + projects[i].getProjectName() + "/" + projects[i].getStages()[x].getCapsules()[y].getId());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public String getUrl(String id){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getId().equals(id)){
                                    if(projects[i].getStages()[x].getCapsules()[y].getStatus().equals(KnowledgeCapsuleStatus.APPROVED)){
                                        if(projects[i].getStages()[x].getCapsules()[y].getCapsulePublication().equals(KnowledgeCapsulePublication.PUBLISHED)){
                                            msg = projects[i].getStages()[x].getCapsules()[y].getUrl();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public int getCapsulesInTechnical(){
        int amount = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getCapsuleType().equals(KnowledgeCapsuleType.TECHNICAL)){
                                    amount += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return amount;
    }

    public int getCapsulesInManagement(){
        int amount = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getCapsuleType().equals(KnowledgeCapsuleType.MANAGEMENT)){
                                    amount += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return amount;
    }

    public int getCapsulesInDomain(){
        int amount = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getCapsuleType().equals(KnowledgeCapsuleType.DOMAIN)){
                                    amount += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return amount;
    }

    public int getCapsulesInExperiences(){
        int amount = 0;
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getCapsuleType().equals(KnowledgeCapsuleType.EXPERIENCES)){
                                    amount += 1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return amount;
    }

    public String getLearnedLessonsByStage(int stageOp){
        String capsuleStage = "";
        switch (stageOp) {
			case 1:
                capsuleStage = "BEGINNING";
			break;
			case 2:
                capsuleStage = "ANALYSIS";
			break;
			case 3:
                capsuleStage = "DESIGN";
			break;
			case 4:
                capsuleStage = "EXECUTION";
			break;
            case 5:
                capsuleStage = "CLOSING & FOLLOW-UP";
			break;
            case 6:
                capsuleStage = "CONTROL";
			break;
			default:
                capsuleStage = "";
			break;
        }
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        if(projects[i].getStages()[x].getStageName().equals(capsuleStage)){
                            for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                                if(projects[i].getStages()[x].getCapsules()[y] != null){
                                    msg += projects[i].getStages()[x].getProjectsNames() + " (" + projects[i].getStages()[x].getStageName() + "): " + projects[i].getStages()[x].getCapsules()[y].getDescription() + "\n";
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }
    public String getMostCapsulesInProject(){
        String msg = "";
        int max = 0; 
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getAmountKnowledgeUnits() > max){
                    max = projects[i].getAmountKnowledgeUnits();
                    msg = projects[i].getProjectName() + " (" + projects[i].getAmountKnowledgeUnits() + ")";
                }
            }
        }
        return msg;
    }

    public String getCapsulesByColaborator(String cName, String cProject){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                if(projects[i].getProjectName().equals(cProject)){
                    for(int x = 0; x < projects[i].getStages().length; x++){
                        if(projects[i].getStages()[x] != null){
                            for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                                if(projects[i].getStages()[x].getCapsules()[y] != null){
                                    if(projects[i].getStages()[x].getCapsules()[y].getColaborator().equals(cName) ){
                                        msg += projects[i].getStages()[x].getCapsules()[y].toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public String getLearnedLessonsByKeywords(String keyword){
        String msg = "";
        for(int i = 0; i < projects.length; i++){
            if(projects[i] != null){
                for(int x = 0; x < projects[i].getStages().length; x++){
                    if(projects[i].getStages()[x] != null){
                        for(int y = 0; y < projects[i].getStages()[x].getCapsules().length; y++){
                            if(projects[i].getStages()[x].getCapsules()[y] != null){
                                if(projects[i].getStages()[x].getCapsules()[y].getStatus().equals(KnowledgeCapsuleStatus.APPROVED)){
                                    if(projects[i].getStages()[x].getCapsules()[y].getDescription().contains(keyword) || projects[i].getStages()[x].getCapsules()[y].getLearnedLessons().contains(keyword)){
                                        msg += projects[i].getStages()[x].getCapsules()[y].toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

}