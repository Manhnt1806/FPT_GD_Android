package com.example.firfilterusewindow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BLThongThapActivity extends Activity{
	EditText mDoRongDaiChuyenTiep,mSuyHaoDaiChan,mTanSoThong;
	Button mBtDesign;
	BoLocThongThap blThongThap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bolocthongthap);
		mDoRongDaiChuyenTiep=(EditText)findViewById(R.id.editDoRongGiaiChuyenTiepThongThap);
		mSuyHaoDaiChan=(EditText)findViewById(R.id.editDoSuyHaoDaiChanThongThap);
		mTanSoThong=(EditText)findViewById(R.id.editTanSoThongBLThongThap);
		mBtDesign=(Button)findViewById(R.id.btDesignBLThongThap);
		
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
				Intent myIntent=new Intent(BLThongThapActivity.this,DoThiThongThap.class);
				Bundle bundle=new Bundle();
				bundle.putFloat("doRongDaiChuyenTiep", doRongDaiChuyenTiep);
				bundle.putFloat("suyHaoDaiChan", suyHaoDaiChan);
				bundle.putFloat("tanSoThong", tanSoThong);
				myIntent.putExtra("thongthapPackage", bundle);
				startActivity(myIntent);
				}else{
					Toast.makeText(BLThongThapActivity.this, "Bạn chỉ nhập được số thực.Yêu cầu nhập lại!", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

}
