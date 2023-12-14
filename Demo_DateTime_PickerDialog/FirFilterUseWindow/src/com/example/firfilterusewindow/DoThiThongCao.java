package com.example.firfilterusewindow;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DoThiThongCao extends Activity{
	float eps;
	GraphicalView windowChart;
	GraphicalView filterChart;
	GraphicalView magnitudeChart;
	LinearLayout cuasothongcao;
	LinearLayout dapungxungthongcao;
	LinearLayout dapungbiendothongcao;
	float window[];
	float chart[];
	float magnitude[];
	float phase[];
	float As;
	float wC;
	float deltaW;
	int N;//do rong cua so
	Button btCheck;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dothithongcao);
		cuasothongcao=(LinearLayout)findViewById(R.id.cuasothongcao);
		dapungxungthongcao=(LinearLayout)findViewById(R.id.dapungxungthongcao);
		dapungbiendothongcao=(LinearLayout)findViewById(R.id.dapungbiendothongcao);
		btCheck=(Button)findViewById(R.id.btCheckThongCao);
		window=new float[1000];
		chart=new float[1000];
		magnitude=new float[1000];
		phase=new float[1000];
		eps=(float) (2.224*Math.pow(10, -16));
		//lấy intent gọi Activity này
		 Intent callerIntent=getIntent();
		 //có intent rồi thì lấy Bundle dựa vào MyPackage
		 Bundle packageFromCaller=
		 callerIntent.getBundleExtra("thongcaoPackage");
		 deltaW=(float) (packageFromCaller.getFloat("doRongDaiChuyenTiep")*Math.PI);
		 As=packageFromCaller.getFloat("suyHaoDaiChan");
		 wC=(float) (packageFromCaller.getFloat("tanSoThong")*Math.PI);
		 createWindow();
		 createChart();
		 createMagnitudeChart();
		 
		 cuasothongcao.addView(windowChart);
		 dapungxungthongcao.addView(filterChart);
		 dapungbiendothongcao.addView(magnitudeChart);
		 btCheck.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent myIntent=new Intent(DoThiThongCao.this,CheckActivity.class);
					if(N!=0){
					myIntent.putExtra("length", N);
					startActivity(myIntent);
					}
					
				}
			});
	}
	public void createWindow(){
		if(As<=21){
			N=(int) ((1.8f*Math.PI)/deltaW);
			CuaSoChuNhat.getInstance().setDoRongCuaSo(N);
			for(int i=0;i<=N;i++){
				window[i]=CuaSoChuNhat.getInstance().gtCuaSo(i);
			}
		}else if(As <= 25){
            //Cua so tam giac
            N = (int) ((6.1*Math.PI)/deltaW);
            CuaSoTamGiac.getInstance().setDoRongCuaSo(N);
            for(int i = 0; i <= N; i++){
                window[i] = CuaSoTamGiac.getInstance().gtCuaSo(i);
            }
        }else if(As <= 44){
            //Cua so Hanning
            N = (int) ((6.2*Math.PI)/deltaW);
            CuaSoHanning.getInstance().setDoRongCuaSo(N);
            for(int i = 0; i <= N; i++){
                window[i] = CuaSoHanning.getInstance().gtCuaSo(i);
            }
        }else if(As <= 53){
            //Cua so Hamming
            N = (int) ((6.6*Math.PI)/deltaW);
            CuaSoHamming.getInstance().setDoRongCuaSo(N);
            for(int i = 0; i <= N; i++){
                window[i] = CuaSoHamming.getInstance().gtCuaSo(i);
            }
        }else if(As <= 74){
            //Cua so Blackman
            N = (int) ((11*Math.PI)/deltaW);
            CuaSoBlackman.getInstance().setDoRongCuaSo(N);
            for(int i = 0; i <= N; i++){
                window[i] = CuaSoBlackman.getInstance().gtCuaSo(i);
            }
        }
		// Khởi tạo TimeSeries là lượt tung do cua so
		TimeSeries windowSeries=new TimeSeries("");
		for(int i=0;i<=N;i++){
			windowSeries.add(i, window[i]);
		}
		windowChart=GraphFunction.getInst().getScatterChart(this, windowSeries, "n", "Window Value",-1.5,1.5);
		
	}
	public void createChart(){
		float anpha=N/2;
		BoLocThongCao.getInstance().setDoRongGiaiChuyenTiep((float) (deltaW*Math.PI));
		BoLocThongCao.getInstance().setSuyHaoDaiChan(As);
		BoLocThongCao.getInstance().setTanSoThong(wC);
		for(int i=0;i<=N;i++){
			chart[i]=BoLocThongCao.getInstance().gtBoLoc(i-anpha)*window[i];
		}
		CurrentFilter.getInstance().setValue(chart, N);
		TimeSeries chartSeries=new TimeSeries("");
		for(int i=0;i<=N;i++){
			chartSeries.add(i, chart[i]);
		}
		filterChart=GraphFunction.getInst().getScatterChart(this,chartSeries , "n", "chart value",-1.5,1.5);
		
	}
	private void createMagnitudeChart() {
		// TODO Auto-generated method stub
		
		float khoangchia=(float) (Math.PI/100);
		for(int i=0;i<100;i++){
			float phanThuc=0;
			float phanAo=0;
			for(int j=0;j<N;j++){
				phanThuc+=chart[j]*Math.cos((i+1)*khoangchia*j);
				phanAo-=chart[j]*Math.sin((i+1)*khoangchia*j);
			}
			magnitude[i]=(float) Math.sqrt(Math.pow(phanThuc, 2)+Math.pow(phanAo, 2));
			
		}
		TimeSeries magnitudeSeries=new TimeSeries("");
		for(int i=0;i<100;i++){
			magnitudeSeries.add(i, magnitude[i]);
		}
		magnitudeChart=GraphFunction.getInst().getLineChart(this, magnitudeSeries, "n", "Magnitude value",-1.5,1.5);
	}

}
