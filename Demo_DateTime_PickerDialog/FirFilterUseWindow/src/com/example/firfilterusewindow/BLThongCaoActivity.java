package com.example.firfilterusewindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BLThongCaoActivity extends Activity{
	EditText mDoRongDaiChuyenTiep,mSuyHaoDaiChan,mTanSoThong;
	Button mBtDesign;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bolocthongcao);
		mDoRongDaiChuyenTiep=(EditText)findViewById(R.id.editDoRongGiaiChuyenTiepThongCao);
		mSuyHaoDaiChan=(EditText)findViewById(R.id.editDoSuyHaoDaiChanThongCao);
		mTanSoThong=(EditText)findViewById(R.id.editTanSoThongBLThongCao);
		mBtDesign=(Button)findViewById(R.id.btDesignBLThongCao);
		mBtDesign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String str="[0-9]+\\.[0-9]+";
				String textdoRongDaiChuyenTiep=mDoRongDaiChuyenTiep.getText()+"";
				String textSuyHaoChanDai=mSuyHaoDaiChan.getText()+"";
				String textTanSoThong=mTanSoThong.getText()+"";
				if(textdoRongDaiChuyenTiep.matches(str)&&textSuyHaoChanDai.matches(str)&&textTanSoThong.matches(str)){
				float doRongDaiChuyenTiep=Float.parseFloat(mDoRongDaiChuyenTiep.getText()+"");
				float suyHaoDaiChan=Float.parseFloat(mSuyHaoDaiChan.getText()+"");
				float tanSoThong=Float.parseFloat(mTanSoThong.getText()+"");
				Intent myIntent=new Intent(BLThongCaoActivity.this,DoThiThongCao.class);
				Bundle bundle=new Bundle();
				bundle.putFloat("doRongDaiChuyenTiep", doRongDaiChuyenTiep);
				bundle.putFloat("suyHaoDaiChan", suyHaoDaiChan);
				bundle.putFloat("tanSoThong", tanSoThong);
				myIntent.putExtra("thongcaoPackage", bundle);
				startActivity(myIntent);
				}else{
					Toast.makeText(BLThongCaoActivity.this, "Bạn chỉ nhập được số thực.Yêu cầu nhập lại!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

}
