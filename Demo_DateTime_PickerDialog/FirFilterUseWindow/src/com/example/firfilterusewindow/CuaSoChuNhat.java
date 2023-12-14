package com.example.firfilterusewindow;

public class CuaSoChuNhat extends CuaSo{
	@Override
	public float gtCuaSo(int bienChay) {
		// TODO Auto-generated method stub
		float gt;
		if(bienChay>=0&&bienChay<=(this.getDoRongCuaSo()-1)){
			gt=1;
		}else{
			gt=0;
		}
		return gt;
	}
	public static CuaSoChuNhat inst;
	public static CuaSoChuNhat getInstance(){
		if(inst==null)
			inst=new CuaSoChuNhat();
		return inst;
	}

}
