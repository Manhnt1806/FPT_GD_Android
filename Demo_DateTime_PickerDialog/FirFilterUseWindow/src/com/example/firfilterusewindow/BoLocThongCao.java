package com.example.firfilterusewindow;

import java.io.Serializable;

public class BoLocThongCao extends BoLoc implements Serializable{
	private float tanSoThong;
	public BoLocThongCao(){
		super();
	}
	public BoLocThongCao(float tanSoThong,float doRongGiaiChuyenTiep,float suyHaoDaiChan){
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
			gt=(float) (1-tanSoThong/Math.PI);
		}else{
			gt=-(float) (Math.sin(bienChay*tanSoThong)/(Math.PI*bienChay));
			
		}
		return gt;
	}
	public static BoLocThongCao inst;
	public static BoLocThongCao getInstance(){
		if(inst==null)
			inst=new BoLocThongCao();
		return inst;
	}

}
