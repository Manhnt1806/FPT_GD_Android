package com.example.firfilterusewindow;

public class CurrentFilter {
	public static float filterValue[];
	public CurrentFilter(){
		filterValue=new float[1000];
	}
	public void setValue(float filter[],int n){
		for(int i=0;i<n;i++){
			filterValue[i]=filter[i];
		}
	}
	public static CurrentFilter inst;
	public static CurrentFilter getInstance(){
		if(inst==null){
			inst=new CurrentFilter();
		}
		return inst;
	}

}
