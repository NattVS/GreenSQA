package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stages {
    private String projectsNames;
    private String stageName;
    private DateFormat formatter;
    private Calendar plannedInitialDate;
    private Calendar plannedFinalDate;
    private Calendar realInitialDate;
    private Calendar realFinalDate;
    private StageStatus stageStatus;
    private KnowledgeCapsule[] capsules;

    public Stages(String projectsNames, String stageName, StageStatus stageStatus, Calendar plannedInitialDate, Calendar plannedFinalDate, Calendar realInitialDate, Calendar realFinalDate) {
        this.formatter = new SimpleDateFormat("dd/MM/yyyy");
        this.projectsNames = projectsNames;	
        this.stageName = stageName;
        this.stageStatus = stageStatus;
        this.plannedInitialDate = plannedInitialDate;
        this.plannedFinalDate = plannedFinalDate;
        this.realInitialDate = realInitialDate;
        this.realFinalDate = realFinalDate;
        this.capsules = new KnowledgeCapsule[50];
    }

    //Getters & Setter for stages
    public String getProjectsNames() {
        return projectsNames;
    }

    public void setProjectName(String projectName) {
        this.projectsNames = projectName;
    }

    public String getStageName() {
        return stageName;
    }
    
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public StageStatus getStageStatus() {
        return stageStatus;
    }

    public void setStageStatus(StageStatus stageStatus) {
        this.stageStatus = stageStatus;
    }

    public Calendar getPlannedInitialDate() {
        return plannedInitialDate;
    }

    public void setPlannedInitialDate(Calendar plannedInitialDate) {
        this.plannedInitialDate = plannedInitialDate;
    }

    public Calendar getPlannedFinalDate() {
        return plannedFinalDate;
    }

    public void setPlannedFinalDate(Calendar plannedFinalDate) {
        this.plannedFinalDate = plannedFinalDate;
    }

    public Calendar getRealInitialDate() {
        return realInitialDate;
    }

    public void setRealInitialDate(Calendar realInitialDate) {
        this.realInitialDate = realInitialDate;
    }

    public Calendar getRealFinalDate() {
        return realFinalDate;
    }

    public DateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(DateFormat formatter) {
        this.formatter = formatter;
    }

    public void setRealFinalDate(Calendar realFinalDate) {
        this.realFinalDate = realFinalDate;
    }

    //Getters & Setter for Knowledge Capsules
    public String getId(int KnowledgeCapsulePosition){
        return capsules[KnowledgeCapsulePosition].getId();
    }

    public void setId(int KnowledgeCapsulePosition, String id) {
        capsules[KnowledgeCapsulePosition].setId(id);
    }
    public String getDescription(int KnowledgeCapsulePosition){
        return capsules[KnowledgeCapsulePosition].getDescription();
    }

    public void setDescription(int KnowledgeCapsulePosition, String description) {
        capsules[KnowledgeCapsulePosition].setDescription(description);
    }

    public KnowledgeCapsuleType getCapsuleType(int KnowledgeCapsulePosition){
        return capsules[KnowledgeCapsulePosition].getCapsuleType();
    }

    public void setCapsuleType(int KnowledgeCapsulePosition, KnowledgeCapsuleType capsuleType) {
        capsules[KnowledgeCapsulePosition].setCapsuleType(capsuleType);
    }

    public String getLearnedLessons(int KnowledgeCapsulePosition){
        return capsules[KnowledgeCapsulePosition].getLearnedLessons();
    }

    public void setLearnedLessons(int KnowledgeCapsulePosition, String learnedLessons) {
        capsules[KnowledgeCapsulePosition].setLearnedLessons(learnedLessons);
    }

    public KnowledgeCapsule[] getCapsules() {
        return this.capsules;
    }

    public void setUnits(KnowledgeCapsule[] capsules) {
        this.capsules = capsules;
    }

}