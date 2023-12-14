package com.example.firfilterusewindow;

public class CuaSoHanning extends CuaSo{
	@Override
	public float gtCuaSo(int bienChay) {
		float gt=0;
		float tam=(float)(2*Math.PI*bienChay/(this.getDoRongCuaSo()-1));
		if(bienChay>=0&&bienChay<this.getDoRongCuaSo()){
			gt=(float)(0.5f-0.5f*Math.cos(tam));
		}
		return gt;
	}
	private static CuaSoHanning inst;
	public static CuaSoHanning getInstance(){
		if(inst==null)
			inst=new CuaSoHanning();
		return inst;
	}

}
