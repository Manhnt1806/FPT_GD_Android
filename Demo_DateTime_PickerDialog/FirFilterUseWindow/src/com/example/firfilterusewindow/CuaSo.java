package com.example.firfilterusewindow;

public class CuaSo {
	private int doRongCuaSo;
	public CuaSo(){
		
	}
	
	public CuaSo(int doRongCuaSo) {
		super();
		this.doRongCuaSo = doRongCuaSo;
	}

	public int getDoRongCuaSo() {
		return doRongCuaSo;
	}
	public void setDoRongCuaSo(int doRongCuaSo) {
		this.doRongCuaSo = doRongCuaSo;
	}
	public float gtCuaSo(int bienChay){
		return 0.0f;
	}
	private static CuaSo inst;
	public static CuaSo getInstance(){
		if(inst==null)
			inst=new CuaSo();
		return inst;
	}

}
