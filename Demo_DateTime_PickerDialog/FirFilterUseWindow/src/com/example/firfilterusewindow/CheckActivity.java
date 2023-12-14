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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends Activity{
	int lengthFilter;
	EditText tskiemtraw1;
	EditText tskiemtraw2;
	Button btCheck;
	LinearLayout dothikiemtra;
	LinearLayout dapungxungdaura;
	LinearLayout dapungbiendodaura;
	GraphicalView checkChart;
	GraphicalView outputChart;
	GraphicalView outputMagnitudeChart;
	float inputChartValue[];
	float outputChartValue[];
	float outputMagnitudeChartValue[];
	float[] inputMagnitudeValue;
	TextView tvdapungbiendodothikiemtra;
	TextView tvdapungbiendodaura;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check_layout);
		setUpView();
		Intent intent=getIntent();
		lengthFilter=intent.getIntExtra("length", 0);
		createInputMagnitudeChart();
		creatOutputChart();
		createOutputMagnitudeChart();
		dothikiemtra.removeAllViews();
		dothikiemtra.addView(checkChart);
		dapungxungdaura.removeAllViews();
		dapungxungdaura.addView(outputChart);
		dapungbiendodaura.removeAllViews();
		dapungbiendodaura.addView(outputMagnitudeChart);
		btCheck.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				createInputMagnitudeChart();
				creatOutputChart();
				createOutputMagnitudeChart();
				dothikiemtra.removeAllViews();
				dothikiemtra.addView(checkChart);
				dapungxungdaura.removeAllViews();
				dapungxungdaura.addView(outputChart);
				dapungbiendodaura.removeAllViews();
				dapungbiendodaura.addView(outputMagnitudeChart);
			}
		});
		
	}
	protected void creatOutputChart() {
		// TODO Auto-generated method stub
		for(int i=0;i<lengthFilter*2-1;i++){
			outputChartValue[i]=0;
			for(int j=0;(i>j)&&(j<lengthFilter);j++){
				outputChartValue[i]+=CurrentFilter.getInstance().filterValue[j]*inputChartValue[i-j];
			}
		}
		TimeSeries outputSeries=new TimeSeries("");
		for(int i=lengthFilter;i<lengthFilter*2-1;i++){
			outputSeries.add(i, outputChartValue[i]);
		}
		outputChart=GraphFunction.getInst().getLineChart(this, outputSeries, "n", "Output value",-1.5,1.5);
		
		
	}
	private void setUpView() {
		// TODO Auto-generated method stub
		tskiemtraw1=(EditText)findViewById(R.id.dauvaow1);
		tskiemtraw2=(EditText)findViewById(R.id.dauvaow2);
		dothikiemtra=(LinearLayout)findViewById(R.id.dothidauvao);
		dapungbiendodaura=(LinearLayout)findViewById(R.id.dapungbiendodaura);
		dapungxungdaura=(LinearLayout)findViewById(R.id.dapungxungdaura);
		tvdapungbiendodaura=(TextView)findViewById(R.id.tvDoThiDauVao);
		tvdapungbiendodaura=(TextView)findViewById(R.id.tvDapUngBienDoDauRa);
		btCheck=(Button)findViewById(R.id.btKiemTraBoLoc);
		inputChartValue=new float[1000];
		outputChartValue=new float[1000];
		outputMagnitudeChartValue=new float[1000];
		inputMagnitudeValue=new float[1000];
	}
	private void createOutputMagnitudeChart() {
		// TODO Auto-generated method stub
		
		float khoangchia=(float) (Math.PI/lengthFilter);
		for(int i=0;i<lengthFilter;i++){
			float phanThuc=0;
			float phanAo=0;
			for(int j=0;j<lengthFilter;j++){
				phanThuc+=outputChartValue[j]*Math.cos((i+1)*khoangchia*j);
				phanAo-=outputChartValue[j]*Math.sin((i+1)*khoangchia*j);
			}
			outputMagnitudeChartValue[i]=(float) Math.sqrt(Math.pow(phanThuc, 2)+Math.pow(phanAo, 2));
			
		}
		TimeSeries magnitudeSeries=new TimeSeries("");
		for(int i=0;i<lengthFilter;i++){
			magnitudeSeries.add(i, outputMagnitudeChartValue[i]);
		}
		outputMagnitudeChart=GraphFunction.getInst().getLineChart(this, magnitudeSeries, "n", "Magnitude value",-1.0,100);
	}
	public void createInputMagnitudeChart(){
		float ts1=Float.parseFloat(tskiemtraw1.getText()+"");
		float ts2=Float.parseFloat(tskiemtraw2.getText()+"");
		for(int i=0;i<=500;i++){
			inputChartValue[i]=(float) (Math.sin(ts1*Math.PI*i)+Math.sin(ts2*Math.PI*i));
		}
		float khoangchia=(float) (Math.PI/lengthFilter);
		for(int i=0;i<lengthFilter;i++){
			float phanThuc=0;
			float phanAo=0;
			for(int j=0;j<lengthFilter;j++){
				phanThuc+=inputChartValue[j]*Math.cos((i+1)*khoangchia*j);
				phanAo-=inputChartValue[j]*Math.sin((i+1)*khoangchia*j);
			}
			inputMagnitudeValue[i]=(float) Math.sqrt(Math.pow(phanThuc, 2)+Math.pow(phanAo, 2));
			
		}
		TimeSeries checkSeries=new TimeSeries("");
		for(int i=0;i<=lengthFilter;i++){
			checkSeries.add(i, inputMagnitudeValue[i]);
		}
		checkChart=GraphFunction.getInst().getLineChart(this, checkSeries, "n", "Check chart value",-1.5,100);
		
	}

}
