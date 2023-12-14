package manhntph29583.manhntph29583_lab2_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Question3 extends AppCompatActivity {
    Button btnA3, btnB3, btnC3, btnD3, btnPre3, btnNext3;
    TextView tvKq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        btnA3 = findViewById(R.id.A3);
        btnB3 = findViewById(R.id.B3);
        btnC3 = findViewById(R.id.C3);
        btnD3 = findViewById(R.id.D3);
        btnPre3 = findViewById(R.id.btn_Pre3);
        btnNext3 = findViewById(R.id.btn_Done);
        tvKq = findViewById(R.id.tv_kq3);
        btnPre3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Question3.this, Question2.class);
                startActivity(intent);
            }
        });
        btnNext3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvKq.getText().toString() == "Đáp án chính xác!\nXin chúc mừng!"){
                    Intent intent =new Intent(Question3.this, ScreenKQ.class);
                    startActivity(intent);
                }else{
                    tvKq.setText("Vui lòng chọn đáp án đúng!");
                }
            }
        });
        btnA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnC3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKq.setText("Đáp án chưa chính xác!\nVui lòng chọn lại!");
            }
        });
        btnD3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvKq.setText("Đáp án chính xác!\nXin chúc mừng!");
            }
        });
    }
}