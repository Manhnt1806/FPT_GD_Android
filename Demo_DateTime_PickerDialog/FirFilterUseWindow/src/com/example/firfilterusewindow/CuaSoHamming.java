package com.example.firfilterusewindow;

public class CuaSoHamming extends CuaSo{
	@Override
	public float gtCuaSo(int bienChay) {
		// TODO Auto-generated method stub
		float gt=0;
		float tam=(float)(2*Math.PI*bienChay/(this.getDoRongCuaSo()-1));
		if(bienChay>=0&&bienChay<this.getDoRongCuaSo()){
			gt=(float)(0.54f-0.46f*Math.cos(tam));
		}
		return gt;
	}
	private static CuaSoHamming inst;
	public static CuaSoHamming getInstance(){
		if(inst==null)
			inst=new CuaSoHamming();
		return inst;
	}
	

}
