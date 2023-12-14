package com.example.firfilterusewindow;

import java.io.Serializable;

public class BoLocThongDai extends BoLoc implements Serializable{
	private float tanSoThongTren;
	private float tanSoThongDuoi;
	public BoLocThongDai(){
		
	}
	public BoLocThongDai(float tanSoThongTren, float tanSoThongDuoi,float doRongGiaiChuyenTiep,float suyHaoDaiChan) {
		super(doRongGiaiChuyenTiep, suyHaoDaiChan);
		this.tanSoThongTren = tanSoThongTren;
		this.tanSoThongDuoi = tanSoThongDuoi;
	}
	
	public float getTanSoThongTren() {
		return tanSoThongTren;
	}
	public void setTanSoThongTren(float tanSoThongTren) {
		this.tanSoThongTren = tanSoThongTren;
	}
	public float getTanSoThongDuoi() {
		return tanSoThongDuoi;
	}
	public void setTanSoThongDuoi(float tanSoThongDuoi) {
		this.tanSoThongDuoi = tanSoThongDuoi;
	}
	@Override
	public float gtBoLoc(float bienChay) {
		// TODO Auto-generated method stub
		float gt=0.0f;
		if(bienChay==0){
			gt=(float) ((tanSoThongTren-tanSoThongDuoi)/Math.PI);
		}else{
			gt=(float) ((Math.sin(tanSoThongTren*bienChay)-Math.sin(tanSoThongDuoi*bienChay))/(Math.PI*bienChay));
		}
		return gt;
	}
	public static BoLocThongDai inst;
	public static BoLocThongDai getInstance(){
		if(inst==null)
			inst=new BoLocThongDai();
		return inst;
	}
	

}
