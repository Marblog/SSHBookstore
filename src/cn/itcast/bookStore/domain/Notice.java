package cn.itcast.bookStore.domain;

import java.sql.Timestamp;

/**
 * Notice entity. @author MyEclipse Persistence Tools
 */

public class Notice implements java.io.Serializable {

	// Fields

	private Integer NId;
	private String title;
	private String details;
	private Timestamp NTime;

	// Constructors

	/** default constructor */
	public Notice() {
	}

	/** minimal constructor */
	public Notice(Timestamp NTime) {
		this.NTime = NTime;
	}

	/** full constructor */
	public Notice(String title, String details, Timestamp NTime) {
		this.title = title;
		this.details = details;
		this.NTime = NTime;
	}

	// Property accessors

	public Integer getNId() {
		return this.NId;
	}

	public void setNId(Integer NId) {
		this.NId = NId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Timestamp getNTime() {
		return this.NTime;
	}

	public void setNTime(Timestamp NTime) {
		this.NTime = NTime;
	}

	@Override
	public String toString() {
		return "Notice [NId=" + NId + ", title=" + title + ", details=" + details + ", NTime=" + NTime + "]";
	}

}