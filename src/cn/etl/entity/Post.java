package cn.etl.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Post extends BaseDomain{
	@Id
	@GeneratedValue
	private long pId;
	private String pContent;
	private String pTitle;
	@Temporal(TemporalType.DATE)
	private Date pTime;
	/**
	 * 发帖人
	 */
	private String publisher;
	/**
	 * 发表人角色,0表示老师，1表示学生
	 */
	private int publishRole; 
	/**
	 * 对应课程的id
	 */
	private int cId;

	public long getpId() {
		return pId;
	}
	public void setpId(long pId) {
		this.pId = pId;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public Date getpTime() {
		return pTime;
	}
	public void setpTime(Date pTime) {
		this.pTime = pTime;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublishRole() {
		return publishRole;
	}
	public void setPublishRole(int publishRole) {
		this.publishRole = publishRole;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	
	
	
}
