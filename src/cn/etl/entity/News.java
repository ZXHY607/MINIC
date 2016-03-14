package cn.etl.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class News extends BaseDomain{
	@Id
	@GeneratedValue
	private long nId;
	private String nContent;
	private String nTitle;
	@Temporal(TemporalType.DATE)
	private Date nTime;
	private String publisher;//发表人username
	private int publishRole;//0表示是老师发布的，1表示是管理员发布的
	
	public long getnId() {
		return nId;
	}
	public void setnId(long nId) {
		this.nId = nId;
	}
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	public Date getnTime() {
		return nTime;
	}
	public void setnTime(Date nTime) {
		this.nTime = nTime;
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
	
	
	
	
}
