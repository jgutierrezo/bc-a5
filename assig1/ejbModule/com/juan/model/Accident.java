package com.juan.model;


import java.io.Serializable;

public class Accident implements Serializable  {
    private static final long serialVersionUID = 2L;

	private int id;

	private String accidentTime;

	private String description;

	private String severity;

	public Accident(int id, String accidentTime, String description, String severity) {
		super();
		this.id = id;
		this.accidentTime = accidentTime;
		this.description = description;
		this.severity = severity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}	
	
}
