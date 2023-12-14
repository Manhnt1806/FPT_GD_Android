package manhntph29583.baithi.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    Button btnFrag01, btnFrag02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFrag01 = findViewById(R.id.btn_frag01);
        btnFrag02 = findViewById(R.id.btn_frag02);
        fm = getSupportFragmentManager();
        Frag01 frag01 = new Frag01();
        Frag02 frag02 = new Frag02();

        //Xử lý tự động hiển thị frag01 khi vào trang
        fm.beginTransaction().add(R.id.frag_container01, frag01).commit();

        //code xử lý các nút bấm
        btnFrag01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_container01, frag01).commit();
            }
        });
        btnFrag02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().replace(R.id.frag_container01, frag02).commit();
            }
        });
    }
}