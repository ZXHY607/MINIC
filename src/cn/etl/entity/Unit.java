package cn.etl.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Unit extends BaseDomain{
	
	@EmbeddedId
	private UnitKey uId;
	/**
	 * 单元介绍
	 */
	private String uIntro;
	/**
	 * 单元名称(必）
	 */
	private String uName;
	
	
	

	public UnitKey getuId() {
		return uId;
	}

	public void setuId(UnitKey uId) {
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
	
    
	@Override
	public Serializable key() {
		// TODO Auto-generated method stub
		return uId;
	}
	
}
