package com.example.firfilterusewindow;

import java.io.Serializable;

public class BoLocThongThap extends BoLoc implements Serializable{
	private float tanSoThong;
	
	public BoLocThongThap(){
		super();
	}
	public BoLocThongThap(float tanSoThong,float doRongGiaiChuyenTiep,float suyHaoDaiChan){
		super(doRongGiaiChuyenTiep, suyHaoDaiChan);
		this.tanSoThong=tanSoThong;
	}
	public float getTanSoThong() {
		return tanSoThong;
	}
	public void setTanSoThong(float tanSoThong) {
		this.tanSoThong = tanSoThong;
	}
	
	@Override
	public float gtBoLoc(float bienChay) {
		// TODO Auto-generated method stub
		float gt=0.0f;
		if(bienChay==0){
			gt=(float) (tanSoThong/Math.PI);
		}else{
			gt=(float) (Math.sin(tanSoThong*bienChay)/(Math.PI*bienChay));
		}
		return gt;
	}
	public static BoLocThongThap inst;
	public static BoLocThongThap getInstance(){
		if(inst==null)
			inst=new BoLocThongThap();
		return inst;
	}

}
