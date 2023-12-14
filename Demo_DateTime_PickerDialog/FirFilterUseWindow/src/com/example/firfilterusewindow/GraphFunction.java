package com.example.firfilterusewindow;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.CombinedXYChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.view.View;

public class GraphFunction {
	public GraphicalView getLineChart(Context context,TimeSeries series,String xTitle,String yTitle,double yMin,double yMax){
		 XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();		         
	     dataset.addSeries(series);
	     
        XYSeriesRenderer renderer = new XYSeriesRenderer();
        renderer.setColor(Color.RED);//Màu đỏ
        renderer.setPointStyle(PointStyle.CIRCLE);//Chấm tròm
        renderer.setFillPoints(true);//Đổ đầy chấm
        renderer.setDisplayChartValues(false);//Cho phép hiển thị giá trị
      
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
 
        multiRenderer.setXTitle(xTitle);//Title trục X
        multiRenderer.setXLabelsColor(Color.CYAN);//Màu sắc cho chữ trục X
        multiRenderer.setAxisTitleTextSize(10.0f);
        multiRenderer.setYAxisAlign(Align.RIGHT, 0);
        multiRenderer.setYLabelsAlign(Align.LEFT);//Chữ nằm về phía bên phải của cột        
        multiRenderer.setYTitle(yTitle);//Title trục Y
        multiRenderer.setYAxisMin(yMin);
        multiRenderer.setYAxisMax(yMax);
        multiRenderer.setBackgroundColor(Color.WHITE);
        multiRenderer.setShowGrid(true);
        multiRenderer.setPointSize(2.0f);
        multiRenderer.setZoomButtonsVisible(false);//Không cho phép zoom nút button
 
        // Thêm visitsRenderer and LikesRenderer vào multipleRenderer
        multiRenderer.addSeriesRenderer(renderer);
        GraphicalView chart=(GraphicalView)ChartFactory.getLineChartView(context, dataset, multiRenderer);
        return chart;
		
	}
	public GraphicalView getScatterChart(Context context,TimeSeries series,String xTitle,String yTitle,double yMin,double yMax){
		XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();		         
	     dataset.addSeries(series);
	     
       XYSeriesRenderer renderer = new XYSeriesRenderer();
       renderer.setColor(Color.RED);//Màu đỏ
       renderer.setPointStyle(PointStyle.CIRCLE);//Chấm tròm
       renderer.setFillPoints(true);//Đổ đầy chấm
       renderer.setDisplayChartValues(false);//Cho phép hiển thị giá trị
     
       XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();

       multiRenderer.setXTitle(xTitle);//Title trục X
       multiRenderer.setXLabelsColor(Color.CYAN);//Màu sắc cho chữ trục X
       multiRenderer.setAxisTitleTextSize(10.0f);
       multiRenderer.setYAxisAlign(Align.RIGHT, 0);
       multiRenderer.setYLabelsAlign(Align.LEFT);//Chữ nằm về phía bên phải của cột        
       multiRenderer.setYTitle(yTitle);//Title trục Y
       multiRenderer.setYAxisMin(yMin);
       multiRenderer.setYAxisMax(yMax);
       multiRenderer.setShowGrid(true);
       multiRenderer.setPointSize(2.0f);
       multiRenderer.setZoomButtonsVisible(false);//Không cho phép zoom nút button

       // Thêm visitsRenderer and LikesRenderer vào multipleRenderer
       multiRenderer.addSeriesRenderer(renderer);
       GraphicalView chart=(GraphicalView)ChartFactory.getScatterChartView(context, dataset, multiRenderer);
       return chart;
	}
	public static GraphFunction inst;
	public static GraphFunction getInst(){
		if(inst==null){
			inst=new GraphFunction();
		}
		return inst;
	}

}
