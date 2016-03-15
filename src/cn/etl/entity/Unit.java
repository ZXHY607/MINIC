package cn.etl.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class Unit extends BaseDomain{
	/**
	 * 单元Id,等于courseID*10000+单元序号（必）
	 */
	@Id
	private int uId;
	/**
	 * 单元介绍
	 */
	private String uIntro;
	/**
	 * 单元名称(必）
	 */
	private String uName;
	
	
	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuIntro() {
		return uIntro;
	}
	
	public void setuIntro(String uIntro) {
		this.uIntro = uIntro;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
    public int getCourseId(){
    	return uId/10000;
    }
    public int getUnitIndex(){
    	return uId%10000;
    }
	@Override
	public Serializable getKey() {
		// TODO Auto-generated method stub
		return uId;
	}
	
}
