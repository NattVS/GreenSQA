package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Project{
	
	private String projectName;
	private String clientName;
    private String gManagerName;
    private String gManagerNumber;
    private String cManagerName;
    private String cManagerNumber;
	private Calendar initialDate;
	private Calendar finalDate;
	private double budget;
    private Stages[] stages;

	private DateFormat formatter;

	public Project(String projectName, String clientName, String gManagerName, String gManagerNumber, String cManagerName, String cManagerNumber, Calendar initialDate, Calendar finalDate, double budget){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");
		this.projectName = projectName;	
		this.clientName = clientName;
        this.gManagerName = gManagerName;
        this.gManagerNumber = gManagerNumber;
        this.cManagerName = cManagerName;
        this.cManagerNumber = cManagerNumber;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
		this.budget = budget;
        this.stages = new Stages[6];
    }

    public int getAmountKnowledgeUnits(){
        int amount = 0;
        for(int x = 0; x < getStages().length; x++){
            if(getStages()[x] != null){
                for(int y = 0; y < getStages()[x].getCapsules().length; y++){
                    if(getStages()[x].getCapsules()[y] != null){
                        amount += 1; 
                    }
                }
            }
        }
        return amount;
    }

    //Getters for projects
	public String getProjectName(){
		return projectName;
	}
	
	public String getClientName(){
		return clientName;
	}
    public String getGreenManagerName(){
		return gManagerName;
	}
	
	public String getGreenManagerNumber(){
		return gManagerNumber;
	}
    public String getClientManagerName(){
		return cManagerName;
	}
	
	public String getClientManagerNumber(){
		return cManagerNumber;
	}
	public Calendar getInitialDate(){
		return initialDate;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.initialDate.getTime());
	}

	public Calendar getFinalDate(){
		return finalDate;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.finalDate.getTime());
	}		

	public double getBudget(){
		return budget;
	}
    //Getters & Setters for stages 
    public String getProjectsNames(int stagePosition){
        return stages[stagePosition].getProjectsNames();
    }

    public Calendar getPlannedInitialDate(int stagePosition){
        return stages[stagePosition].getPlannedInitialDate();
    }

    public Calendar getPlannedFinalDate(int stagePosition){
        return stages[stagePosition].getPlannedFinalDate();
    }

    public Calendar getRealInitialDate(int stagePosition){
        return stages[stagePosition].getRealInitialDate();
    }

    public Calendar getRealFinalDate(int stagePosition){
        return stages[stagePosition].getRealFinalDate();
    }

    public String[] getStageName() {
        String[] stageNames = {stages[0].getStageName(), stages[1].getStageName(), stages[2].getStageName(), stages[3].getStageName(), stages[4].getStageName(),stages[5].getStageName()};
        return stageNames;
    }

    public StageStatus getStageStatus(int stagePosition){
        return stages[stagePosition].getStageStatus();
    }
    public void setStage(int stagePosition, Stages stage){
        stages[stagePosition] = stage;
    }

    public Stages[] getStages() {
        return this.stages;
    }

    public void setStages(Stages[] stages) {
        this.stages = stages;
    }

	public String getProjectInfo() throws ParseException{
		return "\nName: " + projectName + "\nClient: " + clientName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
	}
}