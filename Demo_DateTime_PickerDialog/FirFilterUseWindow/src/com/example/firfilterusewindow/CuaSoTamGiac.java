package com.example.firfilterusewindow;

public class CuaSoTamGiac extends CuaSo{
	@Override
	public float gtCuaSo(int bienChay) {
		// TODO Auto-generated method stub
		float gt = 0;
        if((bienChay>=0)&&(bienChay<=((this.getDoRongCuaSo()-1)/2))){
            gt =  (float)(2*bienChay*1.0/(this.getDoRongCuaSo()-1));
        }
        if((bienChay>=this.getDoRongCuaSo()/2)&&(bienChay<=this.getDoRongCuaSo())){
            gt = (float)(2-2*bienChay*1.0/(this.getDoRongCuaSo()-1));
        }
        return gt;
	}
	private static CuaSoTamGiac inst;
	public static CuaSoTamGiac getInstance(){
		if(inst==null)
			inst=new CuaSoTamGiac();
		return inst;
	}

}
