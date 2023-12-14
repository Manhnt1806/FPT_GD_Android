package manhntph29583.baithi.demo_toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class ActivityCon extends AppCompatActivity {
    Toolbar mToolBar;
    TextView tv, tvTd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con);
        mToolBar = findViewById(R.id.myToolBar);
        tvTd = findViewById(R.id.id_tieude);
        setSupportActionBar(mToolBar); //cài đặt vai trò actionbar
        getSupportActionBar().setDisplayShowTitleEnabled(false); //ẩn tittle actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Hiển thị nút back
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_ios_24);
    }
}