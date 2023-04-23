package model;

import java.util.Calendar;

public class KnowledgeCapsule {

	private String id;
	private String description;
	private KnowledgeCapsuleType capsuleType;
    private String colaborator;
    private String colaboratorRole;
	private String learnedLessons;
	private KnowledgeCapsuleStatus status;
	private Calendar statusDate;
	private KnowledgeCapsulePublication capsulePublication;
    private String url;
	

	public KnowledgeCapsule(String id, String description, KnowledgeCapsuleType capsuleType, String colaborator, String colaboratorRole, String learnedLessons) {

		this.id = id;
		this.description = description;
		this.capsuleType = capsuleType;
        this.colaborator = colaborator;
        this.colaboratorRole = colaboratorRole;
		this.learnedLessons = learnedLessons;
		this.status = KnowledgeCapsuleStatus.UNDEFINED;
		this.capsulePublication = KnowledgeCapsulePublication.NOT_PUBLISHED;
		this.url = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public KnowledgeCapsuleType getCapsuleType() {
		return capsuleType;
	}

	public void setCapsuleType(KnowledgeCapsuleType capsuleType) {
		this.capsuleType = capsuleType;
	}

    public String getColaborator() {
		return colaborator;
	}

	public void setColaborator(String colaborator) {
		this.colaborator = colaborator;
	}

    public String getColaboratorRole() {
		return colaboratorRole;
	}

	public void setColaboratorRole(String colaboratorRole) {
		this.colaboratorRole = colaboratorRole;
	}

	public String getLearnedLessons() {
		return learnedLessons;
	}

	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	
	public KnowledgeCapsuleStatus getStatus() {
		return status;
	}

	public void setStatus(KnowledgeCapsuleStatus status) {
		this.status = status;
	}

	public Calendar getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Calendar statusDate) {
        this.statusDate = statusDate;
    }
	public KnowledgeCapsulePublication getCapsulePublication(){
        return capsulePublication;
    }

    public void setPublishingStatus(KnowledgeCapsulePublication capsulePublication){
        this.capsulePublication = capsulePublication;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

	public String toString() {
        String msg = "";
        msg = " ID:  " + id + "\n The description is: " + description + "\n The type is: " + getCapsuleType() + "\n The actual status is: " + getStatus() +" \n The learned lessons are: "+ learnedLessons + "\n The published status is: " + getCapsulePublication() + "\n This capsule's url is: " + url;
        return msg;
    }

}
