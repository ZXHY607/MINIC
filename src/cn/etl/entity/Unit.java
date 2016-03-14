package cn.etl.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UnitKey.class)
public class Unit extends BaseDomain{
	/**
	 * 第几单元
	 */
	@Id
	private int uIndex;
	/**
	 * 所属课程
	 */
	@Id
	private int cId;
	private String uIntro;
	/**
	 * 单元名称
	 */
	private String uName;
	/**
	 * 发给的人
	 */
	private String toPerson;
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
	public int getuIndex() {
		return uIndex;
	}
	public void setuIndex(int uIndex) {
		this.uIndex = uIndex;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getToPerson() {
		return toPerson;
	}

	public void setToPerson(String toPerson) {
		this.toPerson = toPerson;
	}
	
	
}
