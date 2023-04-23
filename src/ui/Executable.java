package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {
		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) {
		Executable exe = new Executable();
		exe.menu();
	}

	public void menu() {
		System.out.println ("Welcome to GreenSQA!");
		int proceed = 0;
        while (proceed == 0) {
			System.out.println ("Choose which of the following do you wish to do \n1. Register a project \n2. Close a project's stage \n3. Register a knowledge capsule \n4. Aprove a knowledge capsule \n5. Publish a knowledge capsule \n6. Consult the amount of capsules registered by their type \n7. Consult the lessons learned in a stage \n8. Consult the name of the project with more capsules registered \n9. Consult if a colaborator has registered any knowledge capsules \n10. Search lessons learned using keywords \n11. Exit the program ");
			int option = reader.nextInt() ;
			switch(option) {
			case 1:
				RegisterProject();
			break;
			case 2:
				closeProjectStage();
			break;
			case 3:
                registerKnowledgeCapsule();
			break;
			case 4:
                knowledgeCapsuleNewStatus();
			break;
			case 5:
                publishKnowledgeCapsules();
			break;
            case 6:
                getCapsulesByType();
			break;
            case 7:
                getLearnedLessonsByStage();
			break;
            case 8:
                getProjectWithMostCapsules();
			break;
            case 9:
                getCapsulesByColaborator();
			break;
            case 10:
                getLearnedLessonsByKeywords();
			case 11:
				proceed = 1 ;
				System.out.println ("Goodbye! Have a wonderfull day ");
			break;
			default:
				System.out.println ("Choose a valid option ") ;
			break;
			}
		}
	}

	public void RegisterProject() {
		//buffer
		reader.nextLine();

		System.out.println("Enter the proyect's name");
		String projectName= reader.nextLine();

		System.out.println("Enter the client's name");
		String clientName= reader.nextLine();

		System.out.println("Enter the GreenSQA manager's name");
		String gManagerName = reader.nextLine();

		System.out.println("Enter the GreenSQA manager's phone number");
		String gManagerNumber = reader.nextLine();

        System.out.println("Enter the client manager's name");
		String cManagerName = reader.nextLine();

		System.out.println("Enter the client manager's phone number");
		String cManagerNumber = reader.nextLine();

		System.out.println("Enter the project's initialization date:");
		System.out.println("-Enter the day ");
		int initialDay = reader.nextInt();

		System.out.println("-Enter the month ");
		int initialMonth = reader.nextInt();

		System.out.println("-Enter the year ");
		int initialYear = reader.nextInt();

		System.out.println("Enter the project's estimated finalization date");
		System.out.println("-Enter the day");
		int finalDay = reader.nextInt();

		System.out.println("-Enter the month ");
		int finalMonth = reader.nextInt();

		System.out.println("-Enter the year ");
		int finalYear = reader.nextInt();

		System.out.println("Enter the proyect's budget");
		double budget = reader.nextDouble();
        //buffer
		reader.nextLine();
        System.out.println("Enter the number of months the BEGINNING stage is going to last: ");
        int bStageMonths = reader.nextInt();
    
        System.out.println("Enter the number of months the ANALYSIS stage is going to last: ");
        int aStageMonths = reader.nextInt();
    
        System.out.println("Enter the number of months the DESIGN stage is going to last: ");
        int dStageMonths = reader.nextInt();
    
        System.out.println("Enter the number of months the EXECUTION stage is going to last: ");
        int eStageMonths = reader.nextInt();
    
        System.out.println("Enter the number of months the CLOSING & FOLLOW-UP stage is going to last: ");
        int cfStageMonths = reader.nextInt();
    
        System.out.println("Enter the number of months the CONTROL stage is going to last: ");
        int cStageMonths = reader.nextInt();

		if (controller.RegisterProject(projectName,  clientName, gManagerName, gManagerNumber, cManagerName, cManagerNumber,  budget,  initialDay,  initialMonth,  initialYear,  finalDay,  finalMonth, finalYear, bStageMonths, aStageMonths, dStageMonths, eStageMonths, cfStageMonths, cStageMonths)) {
			System.out.println("The project was successfully registered!");
		}else {
			System.out.println("Memory full, unable to register the project");
		}
	}

	public void closeProjectStage() {
        String projecInfo = controller.getProjectsInfo();
        if (projecInfo.equals("")){
            System.out.println("There are not active projects, all of them have been finished their final stage");
        }else{
            reader.nextLine();
            System.out.println("These are the registered projects, the stage they're currently in and their current status: ");
            System.out.println(projecInfo);

            System.out.println("Enter the name of the project whose stage you'd like to close: ");
            String projectStageName = reader.nextLine();

            System.out.println("Enter the day of the closure of this stage: ");
            int closureDay = reader.nextInt();

            System.out.println("Enter the month of the closure of this stage: ");
            int closureMonth = reader.nextInt();

            System.out.println("Enter the year of the closure of this stage: ");
            int closureYear = reader.nextInt();

            if(controller.compareName(projectStageName).equals(projectStageName)){
                controller.closeProjectStage(projectStageName, closureDay, closureMonth, closureYear);
                System.out.println("The stage was succesfuly closed and if the closed stage was the final one, the project has been inactivated");
            }
        }
    }

	public void registerKnowledgeCapsule() {
        //buffer
        reader.nextLine();
        String existingProjects = controller.getAllProjects();
        System.out.println("These are all the registered projects: ");
        System.out.println(existingProjects);
        System.out.println("Please enter the name of the project you want to register a knowledge capsule in. (Beware of spelling mistakes)");
        String projectName = reader.nextLine();
        System.out.println("Enter the stage in which you want to register the knowledge capsule: \n1. BEGINNING \n2. ANALYSIS \n3. DESIGN \n4. EXECUTION \n5. CLOSING & FOLLOW-UP \n6. CONTROL");
        int stage = reader.nextInt();
        reader.nextLine();
		System.out.println ("Enter the information of the new knowledge capsule: ");
        System.out.println ("Enter the id of the knowledge capsule");
        String id = reader.nextLine();
        System.out.println ("Enter the description of the knowledge capsule");
        String description = reader.nextLine();
		System.out.println ("Enter the type of capsule knowledge: \n1. Technical \n2. Management \n3. Domain \n4. Experiences ");
		int type = reader.nextInt();
        System.out.println ("Enter the name of the person registering the knowledge capsule ");
		String colaborator = reader.nextLine();
		//buffer
        reader.nextLine();
        System.out.println ("Enter the role that the person registering the knowledge capsule has in the company");
		String colaboratorRole = reader.nextLine();
		System.out.println ("Enter the lessons learned while making the knowledge capsule ");
        String learnedLessons = reader.nextLine();
        if(controller.registerKnowledgeCapsule(projectName, stage, id, colaborator, colaboratorRole, description, type, learnedLessons)){
            System.out.println ("Knowledge capsule successfully created");
        }else{
            System.out.println ("There arent any more spaces available, the knowledge capsule could not be registered");
        }
	}

	private void knowledgeCapsuleNewStatus() {
		//Limpieza de buffer
		reader.nextLine();
        String registerKnowledgeCapsules = controller.showRegisteredCapsules();
        if(registerKnowledgeCapsules.equals("")){
            System.out.println("No knowledge capsule has been registered");
        }else{
            System.out.println("This are the registered knowledge capsules, their ID and description: ");
            System.out.println(controller.showRegisteredCapsules());
            System.out.println("Enter the id of the capsule you want to change its approvation status");
            String id = reader.nextLine();
            if(controller.compareId(id).equals(id)){
                System.out.println("Enter the new status: \n 1. Approved \n 2. Not Approved");
                int kCapsuleStatus = reader.nextInt();
                //buffer
                reader.nextLine();
    
                System.out.println("Enter the day of the new knowledge capsule's status: ");
                int statusDay = reader.nextInt();
                System.out.println("Enter the month of the new knowledge capsule's status: ");
                int statusMonth = reader.nextInt();
                System.out.println("Enter the year of the new knowledge capsule's status: ");
                int statusYear = reader.nextInt();

                controller.knowledgeCapsuleNewStatus(id, kCapsuleStatus, statusDay, statusMonth, statusYear);
                System.out.println("The knowledge capsules's status has been changed succesfully");
            }else{
                System.out.println("There is not a knowledge unit with the given ID");
            }
        }

	}

	public void publishKnowledgeCapsules() {
		String approvedKnowledgeCapsules = controller.getApprovedKnowledgeCapsules();
        if(approvedKnowledgeCapsules.equals("")){
            System.out.println("None of the registered knowledge capsules have been approved");
        }else{
            //buffer
            reader.nextLine();
        
            System.out.println("These are the approved Knowledge Capsules: ");
            System.out.println(approvedKnowledgeCapsules);
            System.out.println("Enter the ID of the knowledge capsule you wish to publish: ");
            String id = reader.nextLine();

            if(controller.compareId(id).equals(id)){
                controller.publishKnowledgeUnit(id);
                System.out.println("The knowledge capsule was published successfully and it can be found with this URL: ");
                System.out.println(controller.getUrl(id));
            }else{
                System.out.println("There is no approved knowledge capsule with the given ID");
            }
        }
	}

    public void getCapsulesByType(){
        int capsulesInTechnical = controller.getCapsulesInTechnical();
        int capsulesInManagement = controller.getCapsulesInManagement();
        int capsulesInDomain = controller.getCapsulesInDomain();
        int capsulesInExperiences = controller.getCapsulesInExperiences();
        System.out.println("The amount of technical knowledge capsules is: " + capsulesInTechnical);
        System.out.println("The amount of management knowledge capsules is: " + capsulesInManagement);
        System.out.println("The amount of domain knowledge capsules is: " + capsulesInDomain);
        System.out.println("The amount of experiences knowledge capsules is: " + capsulesInExperiences);
    }
    
    public void getLearnedLessonsByStage(){
        System.out.println("Enter the stage in which you'd like to consult it's knowledge units: \n1. BEGINNING \n2. ANALYSIS \n3. DESIGN \n4. EXECUTION \n5. CLOSURE & FOLLOW_UP \n6. CONTROL");
        int stageOp = reader.nextInt();
        if(controller.getLearnedLessonsByStage(stageOp).equals("")){
            System.out.println("There aren't any knowledge capsules registered yet");
        }else{
            System.out.println(controller.getLearnedLessonsByStage(stageOp));
        }
    }

    public void getProjectWithMostCapsules(){
        if(controller.getMostCapsulesInProject().equals("")){
            System.out.println("There aren't any knowledge capsules registered yet");
        }else{
            System.out.println("The project with most knowledge capsules registered is: ");
            System.out.println(controller.getMostCapsulesInProject());
        }  
    }

    public void getCapsulesByColaborator(){
        //Buffer
        reader.nextLine();
        String existingProjects = controller.getAllProjects();
        System.out.println("Enter the name of the colaborator: ");
        String cName = reader.nextLine();
        System.out.println(existingProjects);
        System.out.println("Enter the name of the project you wish to consult in: ");
        String cProject = reader.nextLine();

        if(controller.getCapsulesByColaborator(cName, cProject).equals("")){
            System.out.println("There aren't any registered capsules by this colaborator in this project");
        }else{
            System.out.println("These are the capsules registered by this colaborator in the choosen proyect: ");
            System.out.println(controller.getCapsulesByColaborator(cName, cProject));
        }  
    }

    public void getLearnedLessonsByKeywords(){
        System.out.println("Enter the keyword to find the learned lesson of a capsule: ");
        String keyword = reader.nextLine();
        if(controller.getLearnedLessonsByKeywords(keyword).equals("")){
            System.out.println("There aren't any learned lessons that contain the given keyword");
        }else{
            System.out.println("These are the knowledge capsules registered with a learned lesson that contains the given word: ");
            System.out.println(controller.getLearnedLessonsByKeywords(keyword));
        }
    }
}