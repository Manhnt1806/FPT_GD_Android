package com.example.firfilterusewindow;

public class BoLoc {
	private float doRongGiaiChuyenTiep;
	private float suyHaoDaiChan;
	public float getDoRongGiaiChuyenTiep() {
		return doRongGiaiChuyenTiep;
	}
	public void setDoRongGiaiChuyenTiep(float doRongGiaiChuyenTiep) {
		this.doRongGiaiChuyenTiep = doRongGiaiChuyenTiep;
	}
	public float getSuyHaoDaiChan() {
		return suyHaoDaiChan;
	}
	public void setSuyHaoDaiChan(float suyHaoDaiChan) {
		this.suyHaoDaiChan = suyHaoDaiChan;
	}
	public BoLoc(float doRongGiaiChuyenTiep, float suyHaoDaiChan) {
		super();
		this.doRongGiaiChuyenTiep = doRongGiaiChuyenTiep;
		this.suyHaoDaiChan = suyHaoDaiChan;
	}
	public float gtBoLoc(float bienChay){
		return 0.0f;
	}
	
	public BoLoc(){
		
	}
	public static BoLoc inst;
	public static BoLoc getInstance(){
		if(inst==null)
			inst=new BoLoc();
		return inst;
	}

}
