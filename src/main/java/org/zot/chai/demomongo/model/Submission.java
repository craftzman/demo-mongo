package org.zot.chai.demomongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("submission")
public class Submission {

	private String submissionId;
	private String user;
	
	public Submission(String submissionId, String user) {
		super();
		this.submissionId = submissionId;
		this.user = user;
	}

	/**
	 * @return the submissionId
	 */
	public String getSubmissionId() {
		return submissionId;
	}

	/**
	 * @param submissionId the submissionId to set
	 */
	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Submission [submissionId=" + submissionId + ", user=" + user + "]";
	}
	
	
}
