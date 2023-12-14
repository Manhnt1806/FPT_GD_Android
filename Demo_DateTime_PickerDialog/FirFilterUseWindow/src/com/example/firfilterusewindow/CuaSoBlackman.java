package com.example.firfilterusewindow;

public class CuaSoBlackman extends CuaSo{
	@Override
	public float gtCuaSo(int bienChay) {
		// TODO Auto-generated method stub
		float gt=0.0f;
		float tam=(float)(2*Math.PI*bienChay/(this.getDoRongCuaSo()-1));
		if(bienChay>=0&&bienChay<(this.getDoRongCuaSo())){
			gt=(float)(0.42f-0.5*Math.cos(tam)+0.08f*Math.cos(tam*2));
		}
		return gt;
	}
	private static CuaSoBlackman inst;
	public static CuaSoBlackman getInstance(){
		if(inst==null)
			inst=new CuaSoBlackman();
		return inst;
	}

}
