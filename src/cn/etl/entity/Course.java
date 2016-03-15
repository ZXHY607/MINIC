package cn.etl.entity;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Course extends BaseDomain {
	/**
	 * 课程Id
	 */
	@Id
	@GeneratedValue
	private int cId;
	/**
	 * 课程名称（必）
	 */
	private String cname;
	/**
	 * 课程介绍
	 */
	private String cintro;
	/**
	 * 学分（必）
	 */
	private String credits;
	/**
	 * 负责上传课件，微课，作业的老师
	 */
	private String chief;
	/**
	 * 课程包含的单元
	 */
	@OneToMany(targetEntity = Unit.class,
			   cascade = {CascadeType.ALL}, fetch=FetchType.EAGER)
	private List<Unit> units;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCintro() {
		return cintro;
	}
	public void setCintro(String cintro) {
		this.cintro = cintro;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public String getChief() {
		return chief;
	}
	public void setChief(String chief) {
		this.chief = chief;
	}
	public List<Unit> getUnits() {
		return units;
	}
	public void setUnits(List<Unit> units) {
		this.units = units;
	}
	@Override
	public Serializable getKey() {
		// TODO Auto-generated method stub
		return cId;
	}
	
}
