/*package cn.etl.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class UnitKey implements Serializable{
	*//**
	 * 单元所属课程的ID（必）
	 *//*
	private int cId;
	*//**
	 * 第几单元（必）
	 *//*
	private int uIndex;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getuIndex() {
		return uIndex;
	}
	public void setuIndex(int uIndex) {
		this.uIndex = uIndex;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof UnitKey)
		{
			UnitKey unitkey=(UnitKey)obj;
			if(cId==unitkey.cId&&uIndex==unitkey.uIndex) return true;
			
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return cId*10000+uIndex;
	}
}
*/