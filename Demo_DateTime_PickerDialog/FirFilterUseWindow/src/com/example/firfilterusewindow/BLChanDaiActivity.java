package com.example.firfilterusewindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BLChanDaiActivity extends Activity{
	EditText mDoRongDaiChuyenTiep,mSuyHaoDaiChan,mTanSoTren,mTanSoDuoi;
	Button mBtDesign;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bolocchandai);
		mDoRongDaiChuyenTiep=(EditText)findViewById(R.id.editDoRongGiaiChuyenTiepChanDai);
		mSuyHaoDaiChan=(EditText)findViewById(R.id.editDoSuyHaoDaiChanChanDai);
		mTanSoTren=(EditText)findViewById(R.id.editTanSoThongTrenBLChanDai);
		mTanSoDuoi=(EditText)findViewById(R.id.editTanSoThongDuoiBLChanDai);
		mBtDesign=(Button)findViewById(R.id.btDesignBLChanDai);
		mBtDesign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str="[0-9]+\\.[0-9]+";
				String textdoRongDaiChuyenTiep=mDoRongDaiChuyenTiep.getText()+"";
				String textSuyHaoChanDai=mSuyHaoDaiChan.getText()+"";
				String textTanSoDuoi=mTanSoDuoi.getText()+"";
				String textTanSoTren=mTanSoTren.getText()+"";
				if(textdoRongDaiChuyenTiep.matches(str)&&textSuyHaoChanDai.matches(str)&&textTanSoDuoi.matches(str)&&textTanSoTren.matches(str)){
				float doRongDaiChuyenTiep=Float.parseFloat(mDoRongDaiChuyenTiep.getText()+"");
				float suyHaoDaiChan=Float.parseFloat(mSuyHaoDaiChan.getText()+"");
				float tanSoTren=Float.parseFloat(mTanSoTren.getText()+"");
				float tanSoDuoi=Float.parseFloat(mTanSoDuoi.getText()+"");
				Intent myIntent=new Intent(BLChanDaiActivity.this,DoThiChanDai.class);
				Bundle bundle=new Bundle();
				bundle.putFloat("doRongDaiChuyenTiep", doRongDaiChuyenTiep);
				bundle.putFloat("suyHaoDaiChan", suyHaoDaiChan);
				bundle.putFloat("tanSoTren", tanSoTren);
				bundle.putFloat("tanSoDuoi", tanSoDuoi);
				myIntent.putExtra("chandaiPackage", bundle);
				startActivity(myIntent);
				}else{
					Toast.makeText(BLChanDaiActivity.this, "Bạn chỉ nhập được số thực.Yêu cầu nhập lại!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

}
